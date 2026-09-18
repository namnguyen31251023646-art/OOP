package bai05;

public abstract class Employee {

    protected String firstName;
    protected String lastName;
    protected String SSN;

    public Employee() {
    }

    public Employee(String firstName, String lastName, String SSN) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.SSN = SSN;
    }

    public abstract double earnings();

    @Override
    public String toString() {
        return firstName + " " + lastName
                + "\tSSN: " + SSN;
    }
}