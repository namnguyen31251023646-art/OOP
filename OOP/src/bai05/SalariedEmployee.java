package bai05;

public class SalariedEmployee extends Employee {

    private double weeklySalary;

    public SalariedEmployee() {
    }

    public SalariedEmployee(String firstName, String lastName,
                            String SSN, double weeklySalary) {
        super(firstName, lastName, SSN);
        this.weeklySalary = weeklySalary;
    }

    @Override
    public double earnings() {
        return weeklySalary;
    }

    @Override
    public String toString() {
        return "Salaried Employee: " + super.toString()
                + "\tWeekly salary: " + weeklySalary;
    }
}