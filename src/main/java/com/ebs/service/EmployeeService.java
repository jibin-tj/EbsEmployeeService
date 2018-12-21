package com.ebs.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ebs.exception.CompanyNotFound;
import com.ebs.exception.EmployeeNotFound;
import com.ebs.exception.InvalidRequest;
import com.ebs.model.EmployeeDTO;
import com.ebs.model.EmployeeRequestModel;
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

		List<EmployeeDTO> dtos = employeeRepo.findAll().stream().map(EntityMapper::mapEntityToModel)
				.collect(Collectors.toList());

		EmployeesResultModel employeesResultModel = new EmployeesResultModel();
		employeesResultModel.setEmployeeDTO(dtos);

		return employeesResultModel;
	}

	@Override
	public EmployeeDTO getEmployee(Integer id) {

		return employeeRepo.findById(id).map(EntityMapper::mapEntityToModel)
				.orElseThrow(() -> new EmployeeNotFound("Employee not found"));
	}

	@Override
	public void deleteEmployee(Integer id) {
		employeeRepo.deleteById(id);
	}

	@Override
	public EmployeeDTO createEmplyee(EmployeeRequestModel empReqModel) {
		if (empReqModel != null) {
			Employee employee = new Employee();
			employee.setAddress(empReqModel.getAddress());
			employee.setEmail(empReqModel.getEmail());
			employee.setName(empReqModel.getName());
			employee.setSurName(empReqModel.getSurname());
			employee.setSalary(empReqModel.getSalary());
			employee.setCompany(getCompany(empReqModel.getCompanyId()));
			return EntityMapper.mapEntityToModel(employee);
		} else {
			throw new InvalidRequest("Invalid Request");
		}

	}

	private Company getCompany(Integer companyId) {
		return companyRepo.findById(companyId).orElseThrow(() -> new CompanyNotFound("Company Id id invalid"));
	}

	@Override
	public EmployeeDTO updateEmployee(EmployeeDTO employeeDTO) {

		if (employeeDTO.getId() == null) {
			throw new InvalidRequest("Id cannot be null for updating employee details");
		}
		Employee employee = employeeRepo.findById(employeeDTO.getId())
				.orElseThrow(() -> new EmployeeNotFound("Employee Not Found"));
		employee.setAddress(employeeDTO.getAddress());
		employee.setEmail(employeeDTO.getEmail());
		employee.setName(employeeDTO.getName());
		employee.setSurName(employeeDTO.getSurname());
		employee.setSalary(employeeDTO.getSalary());
		if (employeeDTO.getCompanyId() != null)
			employee.setCompany(getCompany(employeeDTO.getCompanyId()));
		employee = employeeRepo.save(employee);
		return EntityMapper.mapEntityToModel(employee);
	}

}
