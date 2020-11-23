package name.eric.redemption;

import com.beust.jcommander.JCommander;
import com.beust.jcommander.Parameter;

import java.time.LocalDate;
import java.util.List;

public class Application {

    @Parameter(names = {"-a", "--amount"}, description = "Amount of the loan, without minor units", required = true, help = true)
    private Integer loanAmount;

    @Parameter(names = {"-i", "--interest"}, description = "the annual interest rate in %, e.g. 2.5", required = true, help = true)
    private Double interestRate;

    @Parameter(names = {"-r", "--redemption"}, description = "the initial redemption rate in %, e.g. 1.25", required = true, help = true)
    private Double initialRedemptionRate;

    @Parameter(names = {"-t", "--term"}, description = "the term in months", required = true, help = true)
    private Integer termInMonth;

    @Parameter(names = {"-s", "--start"}, description = "the start date in format YYYY-MM-DD, e.g. 2020-11-20", required = true, help = true)
    private String startDateString;

    @Parameter(names = "--help", description = "shows this text", help = true)
    private boolean help;

    RedemptionPlaner planer = new RedemptionPlaner();
    RedemptionPlanTablePrinter printer = new RedemptionPlanTablePrinter();

    public static void main(String[] args) {
        var application = new Application();
        var cli = JCommander.newBuilder()
                .addObject(application)
                .build();
        cli.parse(args);
        cli.setProgramName("redemption.jar");

        if (application.help) {
            cli.usage();
            return;
        }
        application.run();
    }

    public void run() {
        LocalDate startDate = LocalDate.parse(startDateString);
        List<Redemption> redemptions = planer.calculatePlan(
                interestRate / 100,
                initialRedemptionRate / 100,
                (long) (loanAmount * 100),
                termInMonth,
                startDate);
        printer.print(redemptions);
    }
}
