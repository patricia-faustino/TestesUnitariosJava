package br.com.alura.tdd.modelo;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;

public class Employee {

	private String name;
	private LocalDate admissionDate;
	private BigDecimal salary;

	public Employee(String name, LocalDate admissionDate, BigDecimal salary) {
		this.name = name;
		this.admissionDate = admissionDate;
		this.salary = salary;
	}

	public String getName() {
		return name;
	}

	public LocalDate getAdmissionDate() {
		return admissionDate;
	}

	public BigDecimal getSalary() {
		return salary;
	}

	public void readjustmentSalary(BigDecimal readjustment) {
		this.salary = this.salary.add(readjustment).setScale(2, RoundingMode.UP);
	}
}
