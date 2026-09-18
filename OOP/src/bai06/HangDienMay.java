package bai06;

public class HangDienMay extends HangHoa {

    private int thoiGianBaoHanh;
    private double congSuat;

    public HangDienMay(String maHang, String tenHang,
                       double donGia, int soLuongTon,
                       int thoiGianBaoHanh,
                       double congSuat) {

        super(maHang, tenHang, donGia, soLuongTon);

        if (thoiGianBaoHanh < 0 || congSuat < 0) {
            throw new IllegalArgumentException(
                    "Bao hanh va cong suat phai >= 0!");
        }

        this.thoiGianBaoHanh = thoiGianBaoHanh;
        this.congSuat = congSuat;
    }

    @Override
    public double tinhVAT() {
        return donGia * 0.10;
    }

    @Override
    public String danhGia() {
        if (soLuongTon < 3) {
            return "Ban duoc";
        }

        return "Khong danh gia";
    }

    @Override
    public String toString() {
        return super.toString()
                + ", Bao hanh: " + thoiGianBaoHanh + " thang"
                + ", Cong suat: " + congSuat + " KW"
                + ", VAT: " + tinhVAT()
                + ", Danh gia: " + danhGia();
    }
}