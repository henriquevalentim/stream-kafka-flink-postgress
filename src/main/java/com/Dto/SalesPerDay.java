package com.Dto;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class SalesPerDay {
    private Date transactionDate;
    private Double totalSales;
}
