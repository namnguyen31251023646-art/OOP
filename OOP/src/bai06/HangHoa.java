package bai06;

public abstract class HangHoa {

    protected final String maHang;
    protected String tenHang;
    protected double donGia;
    protected int soLuongTon;

    public HangHoa(String maHang, String tenHang,
                   double donGia, int soLuongTon) {

        if (maHang == null || maHang.trim().isEmpty()) {
            throw new IllegalArgumentException("Ma hang khong duoc rong!");
        }

        if (tenHang == null || tenHang.trim().isEmpty()) {
            tenHang = "xxx";
        }

        if (donGia < 0 || soLuongTon < 0) {
            throw new IllegalArgumentException("Gia va so luong phai >= 0!");
        }

        this.maHang = maHang;
        this.tenHang = tenHang;
        this.donGia = donGia;
        this.soLuongTon = soLuongTon;
    }

    public String getMaHang() {
        return maHang;
    }

    public String getTenHang() {
        return tenHang;
    }

    public int getSoLuongTon() {
        return soLuongTon;
    }

    public double getDonGia() {
        return donGia;
    }

    public void setDonGia(double donGia) {
        if (donGia >= 0) {
            this.donGia = donGia;
        }
    }

    public abstract double tinhVAT();

    public abstract String danhGia();

    @Override
    public String toString() {
        return "Ma: " + maHang
                + ", Ten: " + tenHang
                + ", Don gia: " + donGia
                + ", SL ton: " + soLuongTon;
    }
}