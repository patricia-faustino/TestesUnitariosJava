package br.com.alura.tdd.service;

import br.com.alura.tdd.modelo.Employee;
import br.com.alura.tdd.modelo.PERFORMANCE;

import java.math.BigDecimal;

public class ReadjustmentService {

    public void calculateReadjustment(Employee employee, PERFORMANCE performance) {
        BigDecimal readjustment = performance.readjustmentPercentage();
        employee.readjustmentSalary(employee.getSalary().multiply(readjustment));
    }
}
