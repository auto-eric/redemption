package name.eric.redemption;

import java.text.NumberFormat;
import java.util.List;

public class RedemptionPlanTablePrinter {

    private final NumberFormat nf;

    public RedemptionPlanTablePrinter() {
        nf = NumberFormat.getInstance();
        nf.setMinimumFractionDigits(2);
        nf.setMaximumFractionDigits(2);
    }

    public void print(List<Redemption> redemptionPlan) {
        System.out.println("Datum\t\t| Restschuld\t| Zins\t\t| Tilgung\t| Rate");
        System.out.println("----------------|---------------|---------------|---------------|---------------");
        redemptionPlan.forEach(r -> System.out.printf(
                "%s\t| %s\t| %s\t| %s\t| %s" + System.lineSeparator(),
                r.getDate(),
                nf.format((double) r.getResidualDebtInMinorUnits() / 100 * -1),
                nf.format((double) r.getInterestAmountInMinorUnits() / 100),
                nf.format((double) r.getRedemptionAmountInMinorUnits() / 100),
                nf.format((double) (r.getRedemptionAmountInMinorUnits()+r.getInterestAmountInMinorUnits()) / 100)
        ));
    }
}
