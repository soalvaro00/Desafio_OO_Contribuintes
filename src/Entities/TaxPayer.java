package Entities;

public class TaxPayer {
    private double salaryIncome;
    private double servicesIncome;
    private double capitalIncome;
    private double healthSpending;
    private double educationSpending;

    public TaxPayer(double salaryIncome, double servicesIncome, double capitalIncome, double healthSpending, double educationSpending) {
        this.salaryIncome = salaryIncome;
        this.servicesIncome = servicesIncome;
        this.capitalIncome = capitalIncome;
        this.healthSpending = healthSpending;
        this.educationSpending = educationSpending;
    }

    public double salaryTax() {
        if (salaryIncome < 30000.0) {
            return 0.0;
        } else if (salaryIncome < 50000.0) {
            return salaryIncome * 0.10;
        } else {
            return salaryIncome * 0.20;
        }
    }

    public double servicesTax() {
        return servicesIncome * 0.15;
    }

    public double capitalTax() {
        return capitalIncome * 0.20;
    }

    public double grossTax() {
        return salaryTax() + servicesTax() + capitalTax();
    }

    public double taxRebate() {
        double maxRebate = grossTax() * 0.30;
        double actualRebate = healthSpending + educationSpending;
        return Math.min(actualRebate, maxRebate);
    }

    public double netTax() {
        return grossTax() - taxRebate();
    }
}








