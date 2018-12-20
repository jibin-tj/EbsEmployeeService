package de.ebs.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * EmployeeDTO
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2018-12-20T00:53:27.219+01:00")

public class EmployeeDTO   {
  @JsonProperty("empId")
  private Integer empId = null;

  public EmployeeDTO empId(Integer empId) {
    this.empId = empId;
    return this;
  }

  /**
   * Get empId
   * @return empId
  **/
  @ApiModelProperty(value = "")


  public Integer getEmpId() {
    return empId;
  }

  public void setEmpId(Integer empId) {
    this.empId = empId;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    EmployeeDTO employeeDTO = (EmployeeDTO) o;
    return Objects.equals(this.empId, employeeDTO.empId);
  }

  @Override
  public int hashCode() {
    return Objects.hash(empId);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class EmployeeDTO {\n");
    
    sb.append("    empId: ").append(toIndentedString(empId)).append("\n");
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

