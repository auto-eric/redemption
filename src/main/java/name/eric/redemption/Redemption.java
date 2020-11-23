package name.eric.redemption;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDate;

@AllArgsConstructor
@Getter
public class Redemption {

    private final LocalDate date;
    private final Long loanInMinorUnits;
    private final Long interestAmountInMinorUnits;
    private final Long redemptionAmountInMinorUnits;
    private final Long residualDebtInMinorUnits;
}
