package bai01;

public class Chuyenxengoaithanh extends Chuyenxe {
    private String noiDen;
    private int soNgayDiDuoc;

    public Chuyenxengoaithanh() {
    }

    public Chuyenxengoaithanh(String maSoChuyen, String hoTenTaiXe,
                              String soXe, double doanhThu,
                              String noiDen, int soNgayDiDuoc) {
        super(maSoChuyen, hoTenTaiXe, soXe, doanhThu);
        this.noiDen = noiDen;
        this.soNgayDiDuoc = soNgayDiDuoc;
    }

    @Override
    public String toString() {
        return super.toString()
                + ", Noi den: " + noiDen
                + ", So ngay di duoc: " + soNgayDiDuoc;
    }
}