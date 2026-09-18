package bai05;

public class Main {

    public static void main(String[] args) {

        Employee[] employees = new Employee[4];

        employees[0] = new SalariedEmployee(
                "Nguyen", "An", "001", 10_000_000);

        employees[1] = new HourlyEmployee(
                "Tran", "Binh", "002", 45, 100_000);

        employees[2] = new CommissionEmployee(
                "Le", "Cuong", "003",
                50_000_000, 0.1);

        employees[3] = new BasePlusCommissionEmployee(
                "Pham", "Dung", "004",
                60_000_000, 0.1, 5_000_000);

        System.out.println("========== BANG LUONG ==========");

        for (Employee employee : employees) {
            System.out.println(employee);
            System.out.println("Earnings: "
                    + employee.earnings());
            System.out.println("--------------------------------");
        }
    }
}