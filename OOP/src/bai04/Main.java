package bai04;

import java.time.LocalDate;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        DanhSachSach ds = new DanhSachSach(100);

        ds.them(new SachGiaoKhoa(
                "SGK01", LocalDate.of(2026, 9, 1),
                50000, 10, "K", true));

        ds.them(new SachGiaoKhoa(
                "SGK02", LocalDate.of(2026, 9, 2),
                60000, 8, "NXB GD", false));

        ds.them(new SachThamKhao(
                "STK01", LocalDate.of(2026, 9, 3),
                100000, 5, "NXB Tre", 10000));

        int chon;

        do {
            System.out.println("\n===== MENU BAI 4 =====");
            System.out.println("1. Xuat danh sach");
            System.out.println("2. Tong thanh tien SGK");
            System.out.println("3. Tong thanh tien STK");
            System.out.println("4. Tim SGK theo NXB");
            System.out.println("5. Thanh tien cao nhat");
            System.out.println("0. Thoat");
            System.out.print("Chon: ");

            chon = sc.nextInt();
            sc.nextLine();

            switch (chon) {
                case 1:
                    System.out.println(ds);
                    break;

                case 2:
                    System.out.println(
                            "Tong SGK: " + ds.tinhTongThanhTienSGK());
                    break;

                case 3:
                    System.out.println(
                            "Tong STK: " + ds.tinhTongThanhTienSTK());
                    break;

                case 4:
                    System.out.print("Nhap NXB: ");
                    String nxb = sc.nextLine();

                    for (Sach sach : ds.timSachGiaoKhoaTheoNXB(nxb)) {
                        System.out.println(sach);
                    }
                    break;

                case 5:
                    System.out.println(
                            "Thanh tien cao nhat: "
                                    + ds.timThanhTienCaoNhat());
                    break;

                case 0:
                    System.out.println("Ket thuc!");
                    break;

                default:
                    System.out.println("Lua chon khong hop le!");
            }

        } while (chon != 0);

        sc.close();
    }
}