package bai05;

public class BasePlusCommissionEmployee
        extends CommissionEmployee {

    private double baseSalary;

    public BasePlusCommissionEmployee() {
    }

    public BasePlusCommissionEmployee(String firstName, String lastName,
                                      String SSN, double grossSales,
                                      double commissionRate,
                                      double baseSalary) {
        super(firstName, lastName, SSN,
                grossSales, commissionRate);
        this.baseSalary = baseSalary;
    }

    @Override
    public double earnings() {
        return super.earnings() + baseSalary;
    }

    @Override
    public String toString() {
        return "Base Plus Commission Employee: "
                + super.toString()
                + "\tBase salary: " + baseSalary;
    }
}