package bai03;

import java.time.LocalDate;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        ArrayList<GiaoDich> danhSach = new ArrayList<>();

        // 3 giao dich vang
        danhSach.add(new GiaoDichVang(
                "V01", LocalDate.of(2026, 9, 1),
                800_000_000, 2, "24K"));

        danhSach.add(new GiaoDichVang(
                "V02", LocalDate.of(2026, 9, 2),
                1_200_000_000, 1, "18K"));

        danhSach.add(new GiaoDichVang(
                "V03", LocalDate.of(2026, 9, 3),
                900_000_000, 3, "24K"));

        // 3 giao dich tien te
        danhSach.add(new GiaoDichTienTe(
                "T01", LocalDate.of(2026, 9, 1),
                25_000, 1000, 1, "VN"));

        danhSach.add(new GiaoDichTienTe(
                "T02", LocalDate.of(2026, 9, 2),
                25_000, 1000, 25_000, "USD"));

        danhSach.add(new GiaoDichTienTe(
                "T03", LocalDate.of(2026, 9, 3),
                27_000, 500, 30_000, "Euro"));

        System.out.println("===== DANH SACH GIAO DICH =====");
        for (GiaoDich gd : danhSach) {
            System.out.println(gd);
        }

        int tongVang = 0;
        int tongTienTe = 0;
        double tongTienTeThanhTien = 0;
        int demTienTe = 0;

        for (GiaoDich gd : danhSach) {

            if (gd instanceof GiaoDichVang) {
                tongVang += gd.getSoLuong();
            }

            if (gd instanceof GiaoDichTienTe) {
                tongTienTe += gd.getSoLuong();
                tongTienTeThanhTien += gd.thanhTien();
                demTienTe++;
            }
        }

        System.out.println("\n===== TONG SO LUONG =====");
        System.out.println("Tong so luong giao dich vang: " + tongVang);
        System.out.println("Tong so luong giao dich tien te: " + tongTienTe);

        System.out.println("\n===== TRUNG BINH THANH TIEN TIEN TE =====");
        System.out.println(tongTienTeThanhTien / demTienTe);

        System.out.println("\n===== GIAO DICH CO DON GIA > 1 TY =====");
        for (GiaoDich gd : danhSach) {
            if (gd.getDonGia() > 1_000_000_000) {
                System.out.println(gd);
            }
        }
    }
}