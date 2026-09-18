package bai04;

import java.time.LocalDate;

public class SachThamKhao extends Sach {
    private double thue;

    public SachThamKhao() {
    }

    public SachThamKhao(String maSach, LocalDate ngayNhap,
                        double donGia, int soLuong,
                        String nhaXuatBan, double thue) {
        super(maSach, ngayNhap, donGia, soLuong, nhaXuatBan);
        this.thue = thue;
    }

    public double getThue() {
        return thue;
    }

    public void setThue(double thue) {
        this.thue = thue;
    }

    @Override
    public double getThanhTien() {
        return soLuong * donGia + thue;
    }

    @Override
    public String toString() {
        return super.toString()
                + ", Thue: " + thue
                + ", Thanh tien: " + getThanhTien();
    }
}