package org.upcy.simbia.api.employee.output;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.upcy.simbia.api.industry.output.IndustryResponseDto;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class EmployeeResponseDto {
    private String employeeName;
    private IndustryResponseDto industry;
}
