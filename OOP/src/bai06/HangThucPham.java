package bai06;

import java.time.LocalDate;

public class HangThucPham extends HangHoa {

    private String nhaCungCap;
    private LocalDate ngaySanXuat;
    private LocalDate ngayHetHan;

    public HangThucPham(String maHang, String tenHang,
                        double donGia, int soLuongTon,
                        String nhaCungCap,
                        LocalDate ngaySanXuat,
                        LocalDate ngayHetHan) {

        super(maHang, tenHang, donGia, soLuongTon);

        this.nhaCungCap = nhaCungCap;
        this.ngaySanXuat = ngaySanXuat;
        this.ngayHetHan = ngayHetHan;
    }

    @Override
    public double tinhVAT() {
        return donGia * 0.05;
    }

    @Override
    public String danhGia() {
        if (soLuongTon > 0
                && ngayHetHan.isBefore(LocalDate.now())) {
            return "Kho ban";
        }

        return "Khong danh gia";
    }

    @Override
    public String toString() {
        return super.toString()
                + ", NCC: " + nhaCungCap
                + ", NSX: " + ngaySanXuat
                + ", HSD: " + ngayHetHan
                + ", VAT: " + tinhVAT()
                + ", Danh gia: " + danhGia();
    }
}