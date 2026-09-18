package bai03;

import java.time.LocalDate;

public abstract class GiaoDich {
    protected String maGiaoDich;
    protected LocalDate ngayGiaoDich;
    protected double donGia;
    protected int soLuong;

    public GiaoDich() {
    }

    public GiaoDich(String maGiaoDich, LocalDate ngayGiaoDich,
                    double donGia, int soLuong) {
        this.maGiaoDich = maGiaoDich;
        this.ngayGiaoDich = ngayGiaoDich;
        this.donGia = donGia;
        this.soLuong = soLuong;
    }

    public abstract double thanhTien();

    public double getDonGia() {
        return donGia;
    }

    public int getSoLuong() {
        return soLuong;
    }

    @Override
    public String toString() {
        return "Ma GD: " + maGiaoDich
                + ", Ngay: " + ngayGiaoDich
                + ", Don gia: " + donGia
                + ", So luong: " + soLuong;
    }
}