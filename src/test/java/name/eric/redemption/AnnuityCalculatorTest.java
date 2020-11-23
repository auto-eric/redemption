package name.eric.redemption;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class AnnuityCalculatorTest {

    private AnnuityCalculator calculator = new AnnuityCalculator();

    @ParameterizedTest
    @CsvSource({
            "0.065, 1000000, 36, 30649",
            "0.065, 2500000, 36, 76623",
            "0.075, 2500000, 36, 77766",
            "0.065, 2500000, 12, 215741",
            "0.05, 50000000, 24, 2193569"
    })
    void calculateAnnuity(Double annualInterestRate, Long loadInMinorUnits, Integer termInMonth, Long monthlyRate) {
        assertEquals(monthlyRate, calculator.calculateAnnuity(annualInterestRate, loadInMinorUnits, termInMonth));
    }

    @ParameterizedTest
    @CsvSource({
        "0.0212, 0.02, 10000000, 34333",
        "0.025, 0.028, 10000000, 44167"
    })
    void calculateAnnuityOnInitialRedemptionRate(double annualInterestRate, double initialRedemptionRate, long loanInMinorUnits, Long monthlyRate){
        assertEquals(monthlyRate, calculator.calculateAnnuity(annualInterestRate, initialRedemptionRate, loanInMinorUnits));
    }
}