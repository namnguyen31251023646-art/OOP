package bai04;

import java.time.LocalDate;

public class SachGiaoKhoa extends Sach {
    private boolean tinhTrang;

    public SachGiaoKhoa() {
    }

    public SachGiaoKhoa(String maSach, LocalDate ngayNhap,
                        double donGia, int soLuong,
                        String nhaXuatBan, boolean tinhTrang) {
        super(maSach, ngayNhap, donGia, soLuong, nhaXuatBan);
        this.tinhTrang = tinhTrang;
    }

    public boolean getTinhTrang() {
        return tinhTrang;
    }

    public void setTinhTrang(boolean tinhTrang) {
        this.tinhTrang = tinhTrang;
    }

    @Override
    public double getThanhTien() {
        if (tinhTrang) {
            return soLuong * donGia;
        }
        return soLuong * donGia * 0.5;
    }

    @Override
    public String toString() {
        return super.toString()
                + ", Tinh trang: " + (tinhTrang ? "Moi" : "Cu")
                + ", Thanh tien: " + getThanhTien();
    }
}