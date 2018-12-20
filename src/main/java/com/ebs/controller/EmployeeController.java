package com.ebs.controller;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ebs.model.EmployeeDTO;
import com.ebs.model.EmployeesResultModel;
import com.ebs.model.ErrorDTO;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
public class EmployeeController implements EmployeesApi {

	Logger log = LoggerFactory.getLogger(EmployeeController.class);

	@Autowired
	com.ebs.service.EmployeeService employeeService;

	@ApiOperation(value = "", nickname = "getEmployee", notes = "Get", response = EmployeesResultModel.class, tags = {})
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Get all employees", response = EmployeesResultModel.class),
			@ApiResponse(code = 400, message = "Bad Request", response = ErrorDTO.class),
			@ApiResponse(code = 401, message = "Access is denied due to invalid credentials", response = ErrorDTO.class),
			@ApiResponse(code = 500, message = "Internal Server Error", response = ErrorDTO.class) })
	@RequestMapping(value = "/employees", produces = { "application/json" }, method = RequestMethod.GET)
	@Override
	public ResponseEntity<EmployeesResultModel> getEmployee() {

		return new ResponseEntity<>(employeeService.getAllEmployees(), HttpStatus.OK);
	}

	@ApiOperation(value = "", nickname = "getEmployeeForId", notes = "Get", response = EmployeesResultModel.class, tags = {})
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "GetEmployee for id", response = EmployeesResultModel.class),
			@ApiResponse(code = 400, message = "Bad Request", response = ErrorDTO.class),
			@ApiResponse(code = 401, message = "Access is denied due to invalid credentials", response = ErrorDTO.class),
			@ApiResponse(code = 500, message = "Internal Server Error", response = ErrorDTO.class) })
	@RequestMapping(value = "/employees/:id", produces = { "application/json" }, method = RequestMethod.GET)
	@Override
	public ResponseEntity<EmployeesResultModel> getEmployeeForId(
			@Valid @RequestParam(value = "id", required = true) Integer id) {

		return new ResponseEntity<>(employeeService.getEmployee(id), HttpStatus.OK);
	}

	@ApiOperation(value = "", nickname = "deleteEmployee", notes = "Delete employee", response = EmployeesResultModel.class, tags = {})
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "GetEmployee for id", response = EmployeesResultModel.class),
			@ApiResponse(code = 400, message = "Bad Request", response = ErrorDTO.class),
			@ApiResponse(code = 401, message = "Access is denied due to invalid credentials", response = ErrorDTO.class),
			@ApiResponse(code = 500, message = "Internal Server Error", response = ErrorDTO.class) })
	@RequestMapping(value = "/employees/:id", produces = { "application/json" }, method = RequestMethod.DELETE)
	@Override
	public ResponseEntity<Void> deleteEmployee(
			@NotNull @ApiParam(value = "Id of the employee", required = true) @Valid @RequestParam(value = "id", required = true) Integer id) {
		employeeService.deleteEmployee(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}

	@ApiOperation(value = "", nickname = "createEmployee", notes = "Create employee", response = EmployeesResultModel.class, tags = {})
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Employee Created", response = EmployeesResultModel.class),
			@ApiResponse(code = 400, message = "Bad Request", response = ErrorDTO.class),
			@ApiResponse(code = 401, message = "Access is denied due to invalid credentials", response = ErrorDTO.class),
			@ApiResponse(code = 500, message = "Internal Server Error", response = ErrorDTO.class) })
	@RequestMapping(value = "/employees", produces = { "application/json" }, method = RequestMethod.POST)
	@Override
	public ResponseEntity<EmployeeDTO> createEmployee(
			@NotNull @ApiParam(value = "Name of the employee", required = true) @Valid @RequestParam(value = "name", required = true) String name,
			@ApiParam(value = "surName of the employee") @Valid @RequestParam(value = "surName", required = false) String surName,
			@ApiParam(value = "email of the employee") @Valid @RequestParam(value = "email", required = false) String email,
			@ApiParam(value = "address of the employee") @Valid @RequestParam(value = "address", required = false) String address,
			@ApiParam(value = "salary of the employee") @Valid @RequestParam(value = "salary", required = false) Integer salary,
			@ApiParam(value = "companyId of the employee") @Valid @RequestParam(value = "companyId", required = false) Integer companyId) {

		return new ResponseEntity<>(employeeService.createEmplyee(name, surName, email, address, salary, companyId),
				HttpStatus.OK);
	}

}
