package com.utils;

import com.Dto.Transaction;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonUtil {
    private static final ObjectMapper objectMapper = new ObjectMapper();

    public static String convertTransactionToJson(Transaction transaction){
        try {
            return objectMapper.writeValueAsString(transaction);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

}
