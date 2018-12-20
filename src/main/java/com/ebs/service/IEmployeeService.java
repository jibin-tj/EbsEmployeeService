package com.ebs.service;

import com.ebs.model.EmployeeDTO;
import com.ebs.model.EmployeesResultModel;

/**
 * @author jibin
 *
 */
public interface IEmployeeService {
	public EmployeesResultModel getAllEmployees();

	public EmployeesResultModel getEmployee(Integer id);

	public void deleteEmployee(Integer id);

	public EmployeeDTO createEmplyee(String name, String surName, String email, String address, Integer salary,
			Integer companyId);
}
