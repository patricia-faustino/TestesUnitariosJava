package br.com.alura.tdd.service;

import java.math.BigDecimal;
import java.math.RoundingMode;

import br.com.alura.tdd.modelo.Employee;

public class BonusService {

	public BigDecimal calculateBonus(Employee funcionario) {
		BigDecimal value = funcionario.getSalary().multiply(new BigDecimal("0.1"));
		if (value.compareTo(new BigDecimal("1000")) > 0) {
			throw new IllegalArgumentException("Bônus não é aplicado em funcionário que possui salario maior que R$10000,00.");
		}
		return value.setScale(2, RoundingMode.HALF_UP);
	}

}
