package bai02;

import java.time.LocalDate;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        ArrayList<Sach> danhSach = new ArrayList<>();

        // 3 sách giáo khoa
        SachGiaoKhoa sgk1 = new SachGiaoKhoa(
                "SGK01", LocalDate.of(2026, 9, 1),
                50000, 10, "K", "moi"
        );

        SachGiaoKhoa sgk2 = new SachGiaoKhoa(
                "SGK02", LocalDate.of(2026, 9, 2),
                60000, 8, "NXB Giao Duc", "cu"
        );

        SachGiaoKhoa sgk3 = new SachGiaoKhoa(
                "SGK03", LocalDate.of(2026, 9, 3),
                70000, 5, "K", "moi"
        );

        // 3 sách tham khảo
        SachThamKhao stk1 = new SachThamKhao(
                "STK01", LocalDate.of(2026, 9, 1),
                100000, 5, "NXB Tre", 10000
        );

        SachThamKhao stk2 = new SachThamKhao(
                "STK02", LocalDate.of(2026, 9, 2),
                120000, 4, "NXB Giao Duc", 15000
        );

        SachThamKhao stk3 = new SachThamKhao(
                "STK03", LocalDate.of(2026, 9, 3),
                90000, 6, "NXB Kim Dong", 12000
        );

        danhSach.add(sgk1);
        danhSach.add(sgk2);
        danhSach.add(sgk3);
        danhSach.add(stk1);
        danhSach.add(stk2);
        danhSach.add(stk3);

        // Xuất danh sách
        System.out.println("===== DANH SACH SACH =====");

        for (Sach sach : danhSach) {
            System.out.println(sach);
        }

        // Tính tổng tiền sách giáo khoa
        double tongSGK = 0;
        double tongSTK = 0;

        for (Sach sach : danhSach) {
            if (sach instanceof SachGiaoKhoa) {
                tongSGK += sach.thanhTien();
            } else if (sach instanceof SachThamKhao) {
                tongSTK += sach.thanhTien();
            }
        }

        System.out.println("\n===== TONG TIEN =====");
        System.out.println("Tong tien sach giao khoa: " + tongSGK);
        System.out.println("Tong tien sach tham khao: " + tongSTK);

        // Xuất sách giáo khoa của NXB K
        System.out.println("\n===== SACH GIAO KHOA CUA NXB K =====");

        for (Sach sach : danhSach) {
            if (sach instanceof SachGiaoKhoa
                    && sach.getNhaXuatBan().equalsIgnoreCase("K")) {
                System.out.println(sach);
            }
        }

        // Tìm sách có thành tiền cao nhất
        Sach sachMax = danhSach.get(0);

        for (Sach sach : danhSach) {
            if (sach.thanhTien() > sachMax.thanhTien()) {
                sachMax = sach;
            }
        }

        System.out.println("\n===== SACH CO THANH TIEN CAO NHAT =====");
        System.out.println(sachMax);
    }
}