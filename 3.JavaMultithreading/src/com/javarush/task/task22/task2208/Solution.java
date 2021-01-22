package com.javarush.task.task22.task2208;

import java.util.*;

/* 
Формируем WHERE
*/

public class Solution {
    public static void main(String[] args) {
        Map<String, String> query = new HashMap<>();
//        query.put("name", "Ivanov");
//        query.put("country", "Ukraine");
//        query.put("city", "Kiev");
//        query.put("age", null);
        query.put("name", null);
        query.put("country", null);
        query.put("city", null);
        query.put("age", null);
        getQuery(query);
    }

    public static String getQuery(Map<String, String> params) {
        String query = "";
        Collection<String> values = params.values();
        int i = 0;
        int valuesSize = values.size();
        for (String temp : values
        ) {
            if (temp == null) i++;
        }
        if (i == valuesSize) { query = "";
        } else {
            StringBuilder stringBuilder = new StringBuilder(query);
            for (Map.Entry<String, String> entry : params.entrySet()) {
                if (entry.getValue() != null) {
                    String s = "";
                    s = entry.getKey() + " = " + "'" + entry.getValue() + "'";
                    stringBuilder.append(s);
                    stringBuilder.append(" and ");
                }
            }
            query = stringBuilder.toString();
            query = query.substring(0, query.length() - 5);
            System.out.println(query);
        }

        return query;
    }
}
