package bai03;

import java.time.LocalDate;

public class GiaoDichTienTe extends GiaoDich {
    private double tiGia;
    private String loaiTienTe;

    public GiaoDichTienTe() {
    }

    public GiaoDichTienTe(String maGiaoDich, LocalDate ngayGiaoDich,
                          double donGia, int soLuong,
                          double tiGia, String loaiTienTe) {
        super(maGiaoDich, ngayGiaoDich, donGia, soLuong);
        this.tiGia = tiGia;
        this.loaiTienTe = loaiTienTe;
    }

    @Override
    public double thanhTien() {
        if (loaiTienTe.equalsIgnoreCase("VN")) {
            return soLuong * donGia;
        }

        return soLuong * donGia * tiGia;
    }

    @Override
    public String toString() {
        return super.toString()
                + ", Ti gia: " + tiGia
                + ", Loai tien: " + loaiTienTe
                + ", Thanh tien: " + thanhTien();
    }
}