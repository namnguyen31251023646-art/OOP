package bai01;

public class Chuyenxe {
    protected String maSoChuyen;
    protected String hoTenTaiXe;
    protected String soXe;
    protected double doanhThu;

    public Chuyenxe() {
    }

    public Chuyenxe(String maSoChuyen, String hoTenTaiXe,
                    String soXe, double doanhThu) {
        this.maSoChuyen = maSoChuyen;
        this.hoTenTaiXe = hoTenTaiXe;
        this.soXe = soXe;
        this.doanhThu = doanhThu;
    }

    public double getDoanhThu() {
        return doanhThu;
    }

    public void setDoanhThu(double doanhThu) {
        this.doanhThu = doanhThu;
    }

    @Override
    public String toString() {
        return "Ma so chuyen: " + maSoChuyen
                + ", Ho ten tai xe: " + hoTenTaiXe
                + ", So xe: " + soXe
                + ", Doanh thu: " + doanhThu;
    }
}