package name.eric.redemption;

public class AnnuityCalculator {

    public Long calculateAnnuity(double annualInterestRate, Long loanInMinorUnits, Integer termInMonth) {
        double monthlyInterestRate = annualInterestRate / 12 ;
        return Math.round(
                loanInMinorUnits * ((Math.pow(1 + monthlyInterestRate, termInMonth) * monthlyInterestRate) / (Math.pow(1 + monthlyInterestRate, termInMonth) - 1)) );
    }

    public Long calculateAnnuity(double annualInterestRate, double initialRedemptionRate, Long loanInMinorUnits) {
        double initialRedemptionAmount = loanInMinorUnits * initialRedemptionRate / 12;
        double interestAmount = loanInMinorUnits * annualInterestRate / 12;

        return Math.round(interestAmount + initialRedemptionAmount);
    }
}
