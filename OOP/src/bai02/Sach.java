package bai02;

import java.time.LocalDate;

public class Sach {
    protected String maSach;
    protected LocalDate ngayNhap;
    protected double donGia;
    protected int soLuong;
    protected String nhaXuatBan;

    public Sach() {
    }

    public Sach(String maSach, LocalDate ngayNhap,
                double donGia, int soLuong, String nhaXuatBan) {
        this.maSach = maSach;
        this.ngayNhap = ngayNhap;
        this.donGia = donGia;
        this.soLuong = soLuong;
        this.nhaXuatBan = nhaXuatBan;
    }

    public double thanhTien() {
        return soLuong * donGia;
    }

    public double getThanhTien() {
        return thanhTien();
    }

    public String getNhaXuatBan() {
        return nhaXuatBan;
    }

    @Override
    public String toString() {
        return "Ma sach: " + maSach
                + ", Ngay nhap: " + ngayNhap
                + ", Don gia: " + donGia
                + ", So luong: " + soLuong
                + ", NXB: " + nhaXuatBan;
    }
}