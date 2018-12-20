package com.ebs.util;

import com.ebs.model.EmployeeDTO;
import com.ebs.repo.entity.Employee;

public class EntityMapper {

	public static EmployeeDTO mapEntityToModel(Employee employeeEntity) {
		EmployeeDTO dto = new EmployeeDTO();
		dto.setId(employeeEntity.getId());
		dto.setAddress(employeeEntity.getAddress());
		dto.setEmail(employeeEntity.getEmail());
		dto.setName(employeeEntity.getName());
		dto.setSurname(employeeEntity.getSurName());
		dto.setSalary(Long.valueOf(employeeEntity.getSalary()));
		dto.setCompanyId(employeeEntity.getCompany().getId());
		return dto;
	}

}
