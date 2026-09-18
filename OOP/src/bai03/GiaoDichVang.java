package bai03;

import java.time.LocalDate;

public class GiaoDichVang extends GiaoDich {
    private String loaiVang;

    public GiaoDichVang() {
    }

    public GiaoDichVang(String maGiaoDich, LocalDate ngayGiaoDich,
                        double donGia, int soLuong, String loaiVang) {
        super(maGiaoDich, ngayGiaoDich, donGia, soLuong);
        this.loaiVang = loaiVang;
    }

    @Override
    public double thanhTien() {
        return soLuong * donGia;
    }

    @Override
    public String toString() {
        return super.toString()
                + ", Loai vang: " + loaiVang
                + ", Thanh tien: " + thanhTien();
    }
}