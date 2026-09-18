package bai06;

import java.time.LocalDate;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        QuanLyHangHoa ds = new QuanLyHangHoa(100);

        ds.them(new HangThucPham(
                "TP01", "Sua",
                30000, 10,
                "Vinamilk",
                LocalDate.of(2026, 9, 1),
                LocalDate.of(2026, 9, 10)));

        ds.them(new HangDienMay(
                "DM01", "May giat",
                8_000_000, 2,
                24, 2.0));

        ds.them(new HangSanhSu(
                "SS01", "Chen",
                50000, 60,
                "Bat Trang",
                LocalDate.now().minusDays(15)));

        int chon;

        do {
            System.out.println("\n===== MENU BAI 6 =====");
            System.out.println("1. Xuat tat ca");
            System.out.println("2. Xuat thuc pham");
            System.out.println("3. Xuat dien may");
            System.out.println("4. Xuat sanh su");
            System.out.println("5. Tim theo ma");
            System.out.println("6. Sap xep theo ten");
            System.out.println("7. Sap xep theo so luong giam");
            System.out.println("8. Xuat thuc pham kho ban");
            System.out.println("9. Xoa theo ma");
            System.out.println("10. Sua don gia");
            System.out.println("0. Thoat");
            System.out.print("Chon: ");

            chon = sc.nextInt();
            sc.nextLine();

            switch (chon) {

                case 1:
                    ds.xuatTatCa();
                    break;

                case 2:
                    ds.xuatThucPham();
                    break;

                case 3:
                    ds.xuatDienMay();
                    break;

                case 4:
                    ds.xuatSanhSu();
                    break;

                case 5:
                    System.out.print("Nhap ma: ");
                    String ma = sc.nextLine();

                    HangHoa hang = ds.timTheoMa(ma);

                    if (hang != null)
                        System.out.println(hang);
                    else
                        System.out.println("Khong tim thay!");
                    break;

                case 6:
                    ds.sapXepTheoTen();
                    System.out.println("Da sap xep!");
                    ds.xuatTatCa();
                    break;

                case 7:
                    ds.sapXepTheoSoLuong();
                    System.out.println("Da sap xep!");
                    ds.xuatTatCa();
                    break;

                case 8:
                    ds.xuatThucPhamKhoBan();
                    break;

                case 9:
                    System.out.print("Nhap ma can xoa: ");
                    ma = sc.nextLine();

                    System.out.println(
                            ds.xoa(ma)
                                    ? "Xoa thanh cong!"
                                    : "Khong tim thay!");
                    break;

                case 10:
                    System.out.print("Nhap ma: ");
                    ma = sc.nextLine();

                    System.out.print("Nhap don gia moi: ");
                    double gia = sc.nextDouble();

                    System.out.println(
                            ds.suaDonGia(ma, gia)
                                    ? "Sua thanh cong!"
                                    : "Sua that bai!");
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