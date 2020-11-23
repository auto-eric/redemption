package name.eric.redemption;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/*
 This tests have no assertions and are used to
 */
class RedemptionPlanTablePrinterTest {

    private RedemptionPlaner planer = new RedemptionPlaner();
    private RedemptionPlanTablePrinter printer = new RedemptionPlanTablePrinter();

    @Test
    void print() {
        var redemptionList = planer.calculatePlan(0.05, 100000L, 12, LocalDate.now());
        printer.print(redemptionList);
    }

    @Test
    void printWithInitialRedemptionRate() {
        var redemptionList = planer.calculatePlan(0.0212, 0.02, 10000000L, 120, LocalDate.now());
        printer.print(redemptionList);
    }
}