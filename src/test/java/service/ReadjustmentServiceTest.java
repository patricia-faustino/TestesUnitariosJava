package service;

import br.com.alura.tdd.modelo.Employee;
import br.com.alura.tdd.modelo.PERFORMANCE;
import br.com.alura.tdd.service.ReadjustmentService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ReadjustmentServiceTest {

    private ReadjustmentService service;
    private Employee employee;
    private static final Integer salaryValue = 1000;

    @BeforeEach
    public void initialize() {
        this.service = new ReadjustmentService();
        this.employee = new Employee("Patricia", LocalDate.now(), new BigDecimal(1000));
    }

    @Test
    public void salaryShouldBeThreePercentOfReadjustmentPlusSalaryWhenPerformanceToWish() {
        service.calculateReadjustment(employee, PERFORMANCE.TO_WISH);

        BigDecimal expectedSalary = new BigDecimal(salaryValue + (salaryValue * 0.03)).setScale(2, RoundingMode.UP);

        assertEquals(expectedSalary, employee.getSalary());
    }

    @Test
    public void salaryShouldBeFifteenPercentOfReadjustmentPlusSalaryWhenPerformanceToGood() {
        service.calculateReadjustment(employee, PERFORMANCE.GOOD);

        BigDecimal expectedSalary = new BigDecimal(salaryValue + (salaryValue * 0.15)).setScale(2, RoundingMode.UP);

        assertEquals(expectedSalary, employee.getSalary());
    }

    @Test
    public void salaryShouldBeTwentyPercentOfReadjustmentPlusSalaryWhenPerformanceToGood() {
        service.calculateReadjustment(employee, PERFORMANCE.EXCELLENT);

        BigDecimal expectedSalary = new BigDecimal(salaryValue + (salaryValue * 0.2)).setScale(2, RoundingMode.UP);

        assertEquals(expectedSalary, employee.getSalary());
    }
}
