package bai05;

public class CommissionEmployee extends Employee {

    protected double grossSales;
    protected double commissionRate;

    public CommissionEmployee() {
    }

    public CommissionEmployee(String firstName, String lastName,
                              String SSN, double grossSales,
                              double commissionRate) {
        super(firstName, lastName, SSN);
        this.grossSales = grossSales;
        this.commissionRate = commissionRate;
    }

    @Override
    public double earnings() {
        return commissionRate * grossSales;
    }

    @Override
    public String toString() {
        return "Commission Employee: " + super.toString()
                + "\tGross sales: " + grossSales
                + "\tCommission rate: " + commissionRate;
    }
}