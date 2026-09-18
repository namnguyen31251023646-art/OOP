package bai06;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class HangSanhSu extends HangHoa {

    private String nhaSanXuat;
    private LocalDate ngayNhapKho;

    public HangSanhSu(String maHang, String tenHang,
                      double donGia, int soLuongTon,
                      String nhaSanXuat,
                      LocalDate ngayNhapKho) {

        super(maHang, tenHang, donGia, soLuongTon);

        this.nhaSanXuat = nhaSanXuat;
        this.ngayNhapKho = ngayNhapKho;
    }

    @Override
    public double tinhVAT() {
        return donGia * 0.10;
    }

    @Override
    public String danhGia() {

        long soNgay = ChronoUnit.DAYS.between(
                ngayNhapKho, LocalDate.now());

        if (soLuongTon > 50 && soNgay > 10) {
            return "Ban cham";
        }

        return "Khong danh gia";
    }

    @Override
    public String toString() {
        return super.toString()
                + ", NSX: " + nhaSanXuat
                + ", Ngay nhap kho: " + ngayNhapKho
                + ", VAT: " + tinhVAT()
                + ", Danh gia: " + danhGia();
    }
}