package com.bankole;

record UpdateEmployeeRequest (
        String name,
        Integer age,
        String position,
        String department,
        Double salary
){
}
