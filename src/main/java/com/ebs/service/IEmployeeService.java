package com.ebs.service;

import com.ebs.model.EmployeeDTO;
import com.ebs.model.EmployeeRequestModel;
import com.ebs.model.EmployeesResultModel;

/**
 * @author jibin
 *
 */
public interface IEmployeeService {
	public EmployeesResultModel getAllEmployees();

	public EmployeeDTO getEmployee(Integer id);

	public void deleteEmployee(Integer id);

	public EmployeeDTO createEmplyee(EmployeeRequestModel empReqModel);

	public EmployeeDTO updateEmployee(EmployeeDTO employeeDTO);
}
