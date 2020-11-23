package name.eric.redemption;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class RedemptionPlanerTest {

    private RedemptionPlaner planer = new RedemptionPlaner();

    @ParameterizedTest
    @CsvSource({
            "0.05, 100000, 1",
            "0.05, 100000, 12",
            "0.05, 100000, 24",
            "0.05, 100000, 36",
    })
    public void testPlanCreation(double annualInterestRate, long loanInMinorUnits, int termInMonth) {
        var redemptionList = planer.calculatePlan(annualInterestRate, loanInMinorUnits, termInMonth, LocalDate.now());
        assertEquals(termInMonth + 1, redemptionList.size());
    }

}