package service;

import br.com.alura.tdd.modelo.Employee;
import br.com.alura.tdd.service.BonusService;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BonusServiceTest {

    @Test
    public void calculateBonusShouldReturnZeroWhenSalaryIsGreaterThanTenThousand() {
        BonusService bonusService = new BonusService();

        BigDecimal bonusValue = bonusService.calculateBonus(new Employee("Patricia", LocalDate.now(), new BigDecimal(25000)));

        assertEquals(new BigDecimal("0.00"), bonusValue);
    }

    @Test
    public void calculateBonusShouldReturnTenPerCentSalaryWhenSalaryIsLessThanTenThousand() {
        BonusService bonusService = new BonusService();
        int salaryValue = 1000;

        BigDecimal bonusValue = bonusService.calculateBonus(new Employee("Patricia", LocalDate.now(), new BigDecimal(salaryValue)));

        BigDecimal expectedValue = new BigDecimal(salaryValue * 0.1).setScale(2, RoundingMode.HALF_UP);

        assertEquals(expectedValue, bonusValue);
    }

    @Test
    public void calculateBonusShouldReturnTenPerCentSalaryWhenSalaryIsEqualTenThousand() {
        BonusService bonusService = new BonusService();
        int salaryValue = 10000;

        BigDecimal bonusValue = bonusService.calculateBonus(new Employee("Patricia", LocalDate.now(), new BigDecimal(salaryValue)));

        BigDecimal expectedValue = new BigDecimal(salaryValue * 0.1).setScale(2, RoundingMode.HALF_UP);

        assertEquals(expectedValue, bonusValue);
    }
}
