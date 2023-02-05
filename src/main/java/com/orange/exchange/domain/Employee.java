package com.orange.exchange.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Employee {
    @Id
    private Long id;
    private String name;
    private String position;
    private Long exchangeOfficeId;

}
