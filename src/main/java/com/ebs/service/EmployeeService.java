package com.ebs.service;

import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ebs.EntityMapper;
import com.ebs.model.EmployeeDTO;
import com.ebs.model.EmployeesResultModel;
import com.ebs.repo.EmployeeRepo;
import com.ebs.repo.entity.Company;
import com.ebs.repo.entity.Employee;

@Service
public class EmployeeService implements IEmployeeService {

	@Autowired
	EmployeeRepo employeeRepo;

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
		employee.setSalary(salary);
		
		employee.setCompany(employeeRepo.findByCompanyId(companyId).getCompany());

		employee = employeeRepo.save(employee);
		return EntityMapper.mapEntityToModel(employee);

	}
	
	private Company getCompany(Integer companyId) {
		Employee employee=employeeRepo.findByCompanyId(companyId);
	}

}
