package com.ebs.model;

import java.util.Objects;
import com.ebs.model.EmployeeDTO;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.ArrayList;
import java.util.List;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * EmployeesResultModel
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2018-12-21T01:53:27.486+01:00")

public class EmployeesResultModel   {
  @JsonProperty("EmployeeDTO")
  @Valid
  private List<EmployeeDTO> employeeDTO = null;

  public EmployeesResultModel employeeDTO(List<EmployeeDTO> employeeDTO) {
    this.employeeDTO = employeeDTO;
    return this;
  }

  public EmployeesResultModel addEmployeeDTOItem(EmployeeDTO employeeDTOItem) {
    if (this.employeeDTO == null) {
      this.employeeDTO = new ArrayList<>();
    }
    this.employeeDTO.add(employeeDTOItem);
    return this;
  }

  /**
   * Get employeeDTO
   * @return employeeDTO
  **/
  @ApiModelProperty(value = "")

  @Valid

  public List<EmployeeDTO> getEmployeeDTO() {
    return employeeDTO;
  }

  public void setEmployeeDTO(List<EmployeeDTO> employeeDTO) {
    this.employeeDTO = employeeDTO;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    EmployeesResultModel employeesResultModel = (EmployeesResultModel) o;
    return Objects.equals(this.employeeDTO, employeesResultModel.employeeDTO);
  }

  @Override
  public int hashCode() {
    return Objects.hash(employeeDTO);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class EmployeesResultModel {\n");
    
    sb.append("    employeeDTO: ").append(toIndentedString(employeeDTO)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(java.lang.Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}

