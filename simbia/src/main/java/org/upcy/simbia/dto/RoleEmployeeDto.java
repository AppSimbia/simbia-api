package org.upcy.simbia.dto;

import lombok.Data;
import org.upcy.simbia.model.Employee;

@Data
public class RoleEmployeeDto {
    private Long role;
    private Long employee;
}
