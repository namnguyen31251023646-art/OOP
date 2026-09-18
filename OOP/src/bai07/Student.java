package bai07;

public class Student extends Person {

    private double diemMon1;
    private double diemMon2;

    public Student(String hoTen, String diaChi,
                   double diemMon1, double diemMon2) {
        super(hoTen, diaChi);
        this.diemMon1 = diemMon1;
        this.diemMon2 = diemMon2;
    }

    public double tinhDiemTrungBinh() {
        return (diemMon1 + diemMon2) / 2;
    }

    /*
     * De bai khong quy dinh nguong danh gia.
     * Phan nay dung nguong minh hoa de chuong trinh co the chay.
     */
    public String danhGia() {
        double dtb = tinhDiemTrungBinh();

        if (dtb >= 8)
            return "Tot";
        if (dtb >= 5)
            return "Dat";

        return "Khong dat";
    }

    @Override
    public String toString() {
        return "STUDENT | " + super.toString()
                + ", Diem TB: " + tinhDiemTrungBinh()
                + ", Danh gia: " + danhGia();
    }
}