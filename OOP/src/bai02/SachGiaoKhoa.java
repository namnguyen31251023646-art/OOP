package bai02;

import java.time.LocalDate;

public class SachGiaoKhoa extends Sach {
    private String tinhTrang;

    public SachGiaoKhoa() {
    }

    public SachGiaoKhoa(String maSach, LocalDate ngayNhap,
                        double donGia, int soLuong,
                        String nhaXuatBan, String tinhTrang) {
        super(maSach, ngayNhap, donGia, soLuong, nhaXuatBan);
        this.tinhTrang = tinhTrang;
    }

    @Override
    public double thanhTien() {
        if (tinhTrang.equalsIgnoreCase("moi")) {
            return soLuong * donGia;
        } else {
            return soLuong * donGia * 0.5;
        }
    }

    @Override
    public String toString() {
        return super.toString()
                + ", Tinh trang: " + tinhTrang
                + ", Thanh tien: " + thanhTien();
    }
}