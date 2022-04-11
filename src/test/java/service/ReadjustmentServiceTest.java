package service;

import br.com.alura.tdd.modelo.Employee;
import br.com.alura.tdd.modelo.PERFORMANCE;
import br.com.alura.tdd.service.ReadjustmentService;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ReadjustmentServiceTest {

    @Test
    public void salaryShouldBeThreePercentOfReadjustmentPlusSalaryWhenPerformanceToWish() {
        ReadjustmentService service = new ReadjustmentService();
        int salaryValue = 1000;
        Employee employee = new Employee("Patricia", LocalDate.now(), new BigDecimal(salaryValue));
        service.calculateReadjustment(employee, PERFORMANCE.TO_WISH);

        BigDecimal expectedSalary = new BigDecimal(salaryValue + (salaryValue * 0.03)).setScale(2, RoundingMode.UP);

        assertEquals(expectedSalary, employee.getSalary());
    }

    @Test
    public void salaryShouldBeFifteenPercentOfReadjustmentPlusSalaryWhenPerformanceToGood() {
        ReadjustmentService service = new ReadjustmentService();
        int salaryValue = 1000;
        Employee employee = new Employee("Patricia", LocalDate.now(), new BigDecimal(salaryValue));
        service.calculateReadjustment(employee, PERFORMANCE.GOOD);

        BigDecimal expectedSalary = new BigDecimal(salaryValue + (salaryValue * 0.15)).setScale(2, RoundingMode.UP);

        assertEquals(expectedSalary, employee.getSalary());
    }

    @Test
    public void salaryShouldBeTwentyPercentOfReadjustmentPlusSalaryWhenPerformanceToGood() {
        ReadjustmentService service = new ReadjustmentService();
        int salaryValue = 1000;
        Employee employee = new Employee("Patricia", LocalDate.now(), new BigDecimal(salaryValue));
        service.calculateReadjustment(employee, PERFORMANCE.EXCELLENT);

        BigDecimal expectedSalary = new BigDecimal(salaryValue + (salaryValue * 0.20)).setScale(2, RoundingMode.UP);

        assertEquals(expectedSalary, employee.getSalary());
    }
}
