package service;

import br.com.alura.tdd.modelo.Employee;
import br.com.alura.tdd.service.BonusService;
import br.com.alura.tdd.service.ReadjustmentService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class BonusServiceTest {

    BonusService service;

    @BeforeEach
    public void initialize() {
        this.service = new BonusService();
    }


    @Test
    public void calculateBonusShouldReturnZeroWhenSalaryIsGreaterThanTenThousand() {
        BonusService bonusService = new BonusService();

        Employee employee = new Employee("Patricia", LocalDate.now(), new BigDecimal(25000));

        assertThrows(IllegalArgumentException.class,
                () -> bonusService.calculateBonus(employee));
    }

    @Test
    public void calculateBonusShouldReturnTenPerCentSalaryWhenSalaryIsLessThanTenThousand() {
        int salaryValue = 1000;

        Employee employee = new Employee("Patricia", LocalDate.now(), new BigDecimal(1000));
        BigDecimal bonusValue = service.calculateBonus(employee);

        BigDecimal expectedValue = new BigDecimal(salaryValue * 0.1).setScale(2, RoundingMode.HALF_UP);

        assertEquals(expectedValue, bonusValue);
    }

    @Test
    public void calculateBonusShouldReturnTenPerCentSalaryWhenSalaryIsEqualTenThousand() {
        int salaryValue = 10000;
        Employee employee = new Employee("Patricia", LocalDate.now(), new BigDecimal(10000));
        BigDecimal bonusValue = service.calculateBonus(employee);

        BigDecimal expectedValue = new BigDecimal(salaryValue * 0.1).setScale(2, RoundingMode.HALF_UP);

        assertEquals(expectedValue, bonusValue);
    }
}
