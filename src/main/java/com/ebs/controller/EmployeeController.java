package com.ebs.controller;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ebs.model.EmployeeDTO;
import com.ebs.model.EmployeeRequestModel;
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
			@ApiResponse(code = 404, message = "Not found", response = ErrorDTO.class),
			@ApiResponse(code = 500, message = "Internal Server Error", response = ErrorDTO.class) })
	@RequestMapping(value = "/employees", produces = { "application/json" }, method = RequestMethod.GET)
	@Override
	public ResponseEntity<EmployeesResultModel> getEmployee() {

		return new ResponseEntity<>(employeeService.getAllEmployees(), HttpStatus.OK);
	}

	@ApiOperation(value = "", nickname = "getEmployeeById", notes = "Get", response = EmployeeDTO.class, tags = {})
	@ApiResponses(value = { @ApiResponse(code = 200, message = "GetEmployee for id", response = EmployeeDTO.class),
			@ApiResponse(code = 400, message = "Bad Request", response = ErrorDTO.class),
			@ApiResponse(code = 500, message = "Internal Server Error", response = ErrorDTO.class) })
	@RequestMapping(value = "/employees/:id", produces = { "application/json" }, method = RequestMethod.GET)
	@Override
	public ResponseEntity<EmployeeDTO> getEmployeeById(
			@NotNull @ApiParam(value = "Id of the employee", required = true) @Valid @RequestParam(value = "id", required = true) Integer id) {

		return new ResponseEntity<>(employeeService.getEmployee(id), HttpStatus.OK);
	}

	@ApiOperation(value = "", nickname = "deleteEmployee", notes = "Delete employee ", tags = {})
	@ApiResponses(value = { @ApiResponse(code = 204, message = "Employee deleted"),
			@ApiResponse(code = 400, message = "Bad Request", response = ErrorDTO.class),
			@ApiResponse(code = 500, message = "Internal Server Error", response = ErrorDTO.class) })
	@RequestMapping(value = "/employees/:id", produces = { "application/json" }, method = RequestMethod.DELETE)
	@Override
	public ResponseEntity<Void> deleteEmployee(
			@NotNull @ApiParam(value = "Id of the employee", required = true) @Valid @RequestParam(value = "id", required = true) Integer id) {
		employeeService.deleteEmployee(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}

	@ApiOperation(value = "", nickname = "createEmployee", notes = "Create employee", response = EmployeeDTO.class, tags = {})
	@ApiResponses(value = { @ApiResponse(code = 201, message = "Employee Created", response = EmployeeDTO.class),
			@ApiResponse(code = 400, message = "Bad Request", response = ErrorDTO.class),
			@ApiResponse(code = 404, message = "Not found", response = ErrorDTO.class),
			@ApiResponse(code = 500, message = "Internal Server Error", response = ErrorDTO.class) })
	@RequestMapping(value = "/employees", produces = { "application/json" }, method = RequestMethod.POST)
	@Override
	public ResponseEntity<EmployeeDTO> createEmployee(
			@ApiParam(value = "The employee details", required = true) @Valid @RequestBody EmployeeRequestModel employee) {
		return new ResponseEntity<>(employeeService.createEmplyee(employee), HttpStatus.CREATED);
	}

	@ApiOperation(value = "", nickname = "updateEmployee", notes = "Update employee", response = EmployeeDTO.class, tags = {})
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Employee Created", response = EmployeeDTO.class),
			@ApiResponse(code = 400, message = "Bad Request", response = ErrorDTO.class),
			@ApiResponse(code = 404, message = "Not found", response = ErrorDTO.class),
			@ApiResponse(code = 500, message = "Internal Server Error", response = ErrorDTO.class) })
	@RequestMapping(value = "/employees", produces = { "application/json" }, method = RequestMethod.PUT)
	@Override
	public ResponseEntity<EmployeeDTO> updateEmployee(
			@ApiParam(value = "The employee details", required = true) @Valid @RequestBody EmployeeDTO employee) {
		return new ResponseEntity<>(employeeService.updateEmployee(employee), HttpStatus.OK);
	}

}
