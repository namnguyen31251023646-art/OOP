package bai06;

import java.util.Arrays;
import java.util.Comparator;

public class QuanLyHangHoa {

    private HangHoa[] ds;
    private int count;

    public QuanLyHangHoa(int n) {
        ds = new HangHoa[n];
        count = 0;
    }

    public boolean them(HangHoa hang) {

        if (count == ds.length) {
            return false;
        }

        if (timTheoMa(hang.getMaHang()) != null) {
            return false;
        }

        ds[count++] = hang;
        return true;
    }

    public HangHoa timTheoMa(String ma) {

        for (int i = 0; i < count; i++) {
            if (ds[i].getMaHang().equalsIgnoreCase(ma)) {
                return ds[i];
            }
        }

        return null;
    }

    public void xuatTatCa() {

        for (int i = 0; i < count; i++) {
            System.out.println(ds[i]);
        }
    }

    public void xuatThucPham() {
        for (int i = 0; i < count; i++) {
            if (ds[i] instanceof HangThucPham) {
                System.out.println(ds[i]);
            }
        }
    }

    public void xuatDienMay() {
        for (int i = 0; i < count; i++) {
            if (ds[i] instanceof HangDienMay) {
                System.out.println(ds[i]);
            }
        }
    }

    public void xuatSanhSu() {
        for (int i = 0; i < count; i++) {
            if (ds[i] instanceof HangSanhSu) {
                System.out.println(ds[i]);
            }
        }
    }

    public void sapXepTheoTen() {

        Arrays.sort(ds, 0, count,
                Comparator.comparing(HangHoa::getTenHang));
    }

    public void sapXepTheoSoLuong() {

        Arrays.sort(ds, 0, count,
                Comparator.comparingInt(
                        HangHoa::getSoLuongTon).reversed());
    }

    public void xuatThucPhamKhoBan() {

        for (int i = 0; i < count; i++) {

            if (ds[i] instanceof HangThucPham
                    && ds[i].danhGia().equals("Kho ban")) {

                System.out.println(ds[i]);
            }
        }
    }

    public boolean xoa(String ma) {

        for (int i = 0; i < count; i++) {

            if (ds[i].getMaHang().equalsIgnoreCase(ma)) {

                for (int j = i; j < count - 1; j++) {
                    ds[j] = ds[j + 1];
                }

                ds[--count] = null;
                return true;
            }
        }

        return false;
    }

    public boolean suaDonGia(String ma, double giaMoi) {

        HangHoa hang = timTheoMa(ma);

        if (hang == null || giaMoi < 0) {
            return false;
        }

        hang.setDonGia(giaMoi);
        return true;
    }
}