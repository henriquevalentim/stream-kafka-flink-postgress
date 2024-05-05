package com.Dto;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class SalesPerCategory {
    private Date transactionDate;
    private String category;
    private Double totalSales;

}
