package bai07;

public class Person {

    protected String hoTen;
    protected String diaChi;

    public Person() {
    }

    public Person(String hoTen, String diaChi) {
        this.hoTen = hoTen;
        this.diaChi = diaChi;
    }

    public String getHoTen() {
        return hoTen;
    }

    @Override
    public String toString() {
        return "Ho ten: " + hoTen
                + ", Dia chi: " + diaChi;
    }
}