import java.util.Scanner;

public class DepositCalculator {
    public static void main(String[] args) {

        new DepositCalculator().calculationDeposit();
    }

    double calculateComplexPercent(double amount,double percent,int period) {
        double pay = amount * Math.pow((1 + percent / 12), 12 * period);
        return conversionNum(pay, 2);
    }

    double calculateSimplePercent(double Amount,double yearRate,int depositPeriod) {
        return conversionNum(Amount + Amount * yearRate * depositPeriod, 2);
    }

    double conversionNum(double value,int places) {
        double scale = Math.pow(10, places);
        return Math.round(value * scale) / scale;
    }

    void calculationDeposit() {
        int period;
        int action;
        double profit = 0;

        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите сумму вклада в рублях:");
        int amount = scanner.nextInt();
        System.out.println("Введите срок вклада в годах:");
        period = scanner.nextInt();
        System.out.println("Выберите тип вклада, 1 - вклад с обычным процентом, 2 - вклад с капитализацией:");
        action = scanner.nextInt();


        if (action == 1) {
            profit = calculateSimplePercent(amount, 0.06, period);
        } else if (action == 2) {
            profit = calculateComplexPercent(amount, 0.06, period);
        }
        System.out.println("Результат вклада: " + amount + " за " + period + " лет превратятся в " + profit);
    }
}
