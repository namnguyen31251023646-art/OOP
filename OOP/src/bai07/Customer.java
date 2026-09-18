package bai07;

public class Customer extends Person {

    private String tenCongTy;
    private double triGiaHoaDon;
    private String danhGia;

    public Customer(String hoTen, String diaChi,
                    String tenCongTy,
                    double triGiaHoaDon,
                    String danhGia) {
        super(hoTen, diaChi);
        this.tenCongTy = tenCongTy;
        this.triGiaHoaDon = triGiaHoaDon;
        this.danhGia = danhGia;
    }

    @Override
    public String toString() {
        return "CUSTOMER | " + super.toString()
                + ", Cong ty: " + tenCongTy
                + ", Tri gia hoa don: " + triGiaHoaDon
                + ", Danh gia: " + danhGia;
    }
}