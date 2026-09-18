package bai01;

public class Chuyenxenoithanh extends Chuyenxe {
    private int soTuyen;
    private double soKmDiDuoc;

    public Chuyenxenoithanh() {
    }

    public Chuyenxenoithanh(String maSoChuyen, String hoTenTaiXe,
                            String soXe, double doanhThu,
                            int soTuyen, double soKmDiDuoc) {
        super(maSoChuyen, hoTenTaiXe, soXe, doanhThu);
        this.soTuyen = soTuyen;
        this.soKmDiDuoc = soKmDiDuoc;
    }

    @Override
    public String toString() {
        return super.toString()
                + ", So tuyen: " + soTuyen
                + ", So km di duoc: " + soKmDiDuoc;
    }
}