package bai07;

import java.util.Scanner;

public class Test {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        Management ds = new Management(100);

        ds.them(new Student(
                "Nguyen An", "TPHCM", 8, 9));

        ds.them(new Employee(
                "Tran Binh", "TPHCM", 3.5));

        ds.them(new Customer(
                "Le Cuong", "Dong Nai",
                "ABC", 50_000_000,
                "Tot"));

        int chon;

        do {
            System.out.println("\n===== MENU BAI 7 =====");
            System.out.println("1. Them Student");
            System.out.println("2. Them Employee");
            System.out.println("3. Them Customer");
            System.out.println("4. Xuat danh sach");
            System.out.println("5. Xoa theo ho ten");
            System.out.println("6. Sap xep theo ho ten");
            System.out.println("0. Thoat");
            System.out.print("Chon: ");

            chon = sc.nextInt();
            sc.nextLine();

            switch (chon) {

                case 1:
                    System.out.print("Ho ten: ");
                    String ten = sc.nextLine();

                    System.out.print("Dia chi: ");
                    String dc = sc.nextLine();

                    System.out.print("Diem mon 1: ");
                    double d1 = sc.nextDouble();

                    System.out.print("Diem mon 2: ");
                    double d2 = sc.nextDouble();

                    sc.nextLine();

                    ds.them(new Student(
                            ten, dc, d1, d2));
                    break;

                case 2:
                    System.out.print("Ho ten: ");
                    ten = sc.nextLine();

                    System.out.print("Dia chi: ");
                    dc = sc.nextLine();

                    System.out.print("He so luong: ");
                    double hs = sc.nextDouble();

                    sc.nextLine();

                    ds.them(new Employee(
                            ten, dc, hs));
                    break;

                case 3:
                    System.out.print("Ho ten: ");
                    ten = sc.nextLine();

                    System.out.print("Dia chi: ");
                    dc = sc.nextLine();

                    System.out.print("Ten cong ty: ");
                    String congTy = sc.nextLine();

                    System.out.print("Tri gia hoa don: ");
                    double hoaDon = sc.nextDouble();

                    sc.nextLine();

                    System.out.print("Danh gia: ");
                    String dg = sc.nextLine();

                    ds.them(new Customer(
                            ten, dc, congTy,
                            hoaDon, dg));
                    break;

                case 4:
                    ds.xuatDanhSach();
                    break;

                case 5:
                    System.out.print("Nhap ho ten can xoa: ");
                    ten = sc.nextLine();

                    System.out.println(
                            ds.xoa(ten)
                                    ? "Xoa thanh cong!"
                                    : "Khong tim thay!");
                    break;

                case 6:
                    ds.sapXepTheoTen();
                    System.out.println("Da sap xep!");
                    break;

                case 0:
                    break;

                default:
                    System.out.println("Sai lua chon!");
            }

        } while (chon != 0);

        sc.close();
    }
}