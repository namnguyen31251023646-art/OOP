package bai07;

public class Employee extends Person {

    private double heSoLuong;

    public Employee(String hoTen, String diaChi,
                    double heSoLuong) {
        super(hoTen, diaChi);
        this.heSoLuong = heSoLuong;
    }

    public double tinhLuong() {
        return heSoLuong * 1_800_000;
    }

    /*
     * De bai khong quy dinh nguong danh gia.
     * Phan nay dung nguong minh hoa.
     */
    public String danhGia() {

        if (heSoLuong >= 4)
            return "Tot";

        if (heSoLuong >= 2)
            return "Kha";

        return "Trung binh";
    }

    @Override
    public String toString() {
        return "EMPLOYEE | " + super.toString()
                + ", He so luong: " + heSoLuong
                + ", Luong: " + tinhLuong()
                + ", Danh gia: " + danhGia();
    }
}