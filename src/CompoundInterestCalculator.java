import java.util.Scanner;

public class CompoundInterestCalculator {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter principal amount: ");
        double principal = sc.nextDouble();

        System.out.print("Enter annual interest rate (in percentage): ");
        double annualRate = sc.nextDouble() / 100;

        System.out.print("Enter time period (years, days, or months): ");
        String timePeriod = sc.next().toLowerCase();

        System.out.print("Enter the number of " + timePeriod + ": ");
        int time = sc.nextInt();

        double compoundInterest = calculateCompoundInterest(principal, annualRate, time, timePeriod);

        System.out.println("Compound Interest after " + time + " " + timePeriod + ": " + compoundInterest);

        sc.close();
    }

    public static double calculateCompoundInterest(double principal, double annualRate, int time, String timePeriod) {
        double effectiveRate;

        switch (timePeriod) {
            case "years":
                effectiveRate = Math.pow(1 + annualRate, time);
                break;
            case "months":
                effectiveRate = Math.pow(1 + annualRate / 12, time);
                break;
            case "days":
                effectiveRate = Math.pow(1 + annualRate / 365, time);
                break;
            default:
                throw new IllegalArgumentException("Invalid time period. Use years, months, or days.");
        }

        return principal * (effectiveRate - 1);
    }
}
