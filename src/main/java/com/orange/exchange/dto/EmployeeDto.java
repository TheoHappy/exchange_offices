package com.orange.exchange.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class EmployeeDto {
    private String name;
    private String position;
    private Long exchangeOfficeId;
}
