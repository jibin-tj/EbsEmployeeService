package com.ebs.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ebs.exception.CompanyNotFound;
import com.ebs.exception.EmployeeNotFound;
import com.ebs.model.EmployeeDTO;
import com.ebs.model.EmployeesResultModel;
import com.ebs.repo.CompanyRepo;
import com.ebs.repo.EmployeeRepo;
import com.ebs.repo.entity.Company;
import com.ebs.repo.entity.Employee;
import com.ebs.util.EntityMapper;

@Service
public class EmployeeService implements IEmployeeService {

	@Autowired
	EmployeeRepo employeeRepo;

	@Autowired
	CompanyRepo companyRepo;

	@Override
	public EmployeesResultModel getAllEmployees() {

		List<EmployeeDTO> dtos = employeeRepo.findAll().stream().map(employeeEntity -> {
			EmployeeDTO dto = EntityMapper.mapEntityToModel(employeeEntity);
			return dto;
		}).collect(Collectors.toList());

		System.out.println(dtos);

		EmployeesResultModel employeesResultModel = new EmployeesResultModel();
		employeesResultModel.setEmployeeDTO(dtos);

		return employeesResultModel;
	}

	@Override
	public EmployeesResultModel getEmployee(Integer id) {

		List<EmployeeDTO> dtos = employeeRepo.findById(id).stream().map(employeeEntity -> {
			EmployeeDTO dto = EntityMapper.mapEntityToModel(employeeEntity);
			return dto;
		}).collect(Collectors.toList());

		System.out.println(dtos);

		EmployeesResultModel employeesResultModel = new EmployeesResultModel();
		employeesResultModel.setEmployeeDTO(dtos);

		return employeesResultModel;
	}

	@Override
	public void deleteEmployee(Integer id) {
		employeeRepo.deleteById(id);
	}

	@Override
	public EmployeeDTO createEmplyee(String name, String surName, String email, String address, Integer salary,
			Integer companyId) {
		Employee employee = new Employee();
		employee.setAddress(address);
		employee.setEmail(email);
		employee.setName(name);
		employee.setSurName(surName);
		employee.setSalary(salary);
		employee.setCompany(getCompany(companyId));
		employee = employeeRepo.save(employee);
		return EntityMapper.mapEntityToModel(employee);

	}

	private Company getCompany(Integer companyId) {
		return companyRepo.findById(companyId).orElseThrow(() -> new CompanyNotFound("Company Id id invalid"));
	}

	@Override
	public EmployeeDTO editEmployee(Integer id, String name, String surName, String email, String address,
			Integer salary, Integer companyId) {

		Employee employee = employeeRepo.findById(id).orElseThrow(() -> new EmployeeNotFound("Employee Not Found"));
		if (address != null)
			employee.setAddress(address);
		if (email != null)
			employee.setEmail(email);
		if (name != null)
			employee.setName(name);
		if (surName != null)
			employee.setSurName(surName);
		if (salary != null && salary > 0)
			employee.setSalary(salary);
		if (companyId != null)
			employee.setCompany(getCompany(companyId));
		employee = employeeRepo.save(employee);
		return EntityMapper.mapEntityToModel(employee);
	}

}
