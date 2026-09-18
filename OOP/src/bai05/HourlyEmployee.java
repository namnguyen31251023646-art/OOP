package bai05;

public class HourlyEmployee extends Employee {

    private double hours;
    private double wage;

    public HourlyEmployee() {
    }

    public HourlyEmployee(String firstName, String lastName,
                          String SSN, double hours, double wage) {
        super(firstName, lastName, SSN);
        this.hours = hours;
        this.wage = wage;
    }

    @Override
    public double earnings() {
        if (hours <= 40) {
            return wage * hours;
        }

        return 40 * wage + (hours - 40) * wage * 1.5;
    }

    @Override
    public String toString() {
        return "Hourly Employee: " + super.toString()
                + "\tWage: " + wage
                + "\tHours: " + hours;
    }
}