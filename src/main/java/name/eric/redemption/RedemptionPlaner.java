package name.eric.redemption;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class RedemptionPlaner {

    private AnnuityCalculator annuityCalculator = new AnnuityCalculator();

    /**
     * provides a redemption plan to finish in term.
     */
    public List<Redemption> calculatePlan(double annualInterestRate, Long loanInMinorUnits, Integer termInMonth, LocalDate startMonth) {
        var monthlyPayment = annuityCalculator.calculateAnnuity(annualInterestRate, loanInMinorUnits, termInMonth);
        return getRedemptionList(annualInterestRate, loanInMinorUnits, termInMonth, monthlyPayment, startMonth);
    }

    /**
     * provides a redemption plan based on initial redemption rate.
     */
    public List<Redemption> calculatePlan(double annualInterestRate, double initialRedemptionRate, Long loanInMinorUnits, Integer termInMonth, LocalDate startMonth) {
        var monthlyPayment = annuityCalculator.calculateAnnuity(annualInterestRate, initialRedemptionRate, loanInMinorUnits);
        return getRedemptionList(annualInterestRate, loanInMinorUnits, termInMonth, monthlyPayment, startMonth);
    }

    private List<Redemption> getRedemptionList(double annualInterestRate, Long loanInMinorUnits, Integer termInMonth, Long monthlyPayment, LocalDate startMonth) {
        var redemptionList = new ArrayList<Redemption>(termInMonth);
        redemptionList.add(new Redemption(startMonth, loanInMinorUnits, 0L, 0L, loanInMinorUnits));
        var loanLeft = loanInMinorUnits;

        for (int i = 1; i <= termInMonth && loanLeft > 0; i++) {
            var interestAmount = Long.valueOf(Math.round(loanLeft * (annualInterestRate/12)));
            var redemption = monthlyPayment - interestAmount;
            if(loanLeft<redemption) {
                redemption = loanLeft;
            }
            redemptionList.add(new Redemption(startMonth.plusMonths(i), loanLeft, interestAmount, redemption, loanLeft-redemption));
            loanLeft -= redemption;
        }
        return redemptionList;
    }

}
