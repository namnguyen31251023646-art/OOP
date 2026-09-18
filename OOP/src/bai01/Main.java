package bai01;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        ArrayList<Chuyenxe> danhSach = new ArrayList<>();

        // 2 chuyến xe nội thành
        Chuyenxenoithanh xeNoi1 = new Chuyenxenoithanh(
                "NT01", "Nguyen Van A", "51A-12345",
                500000, 10, 25.5
        );

        Chuyenxenoithanh xeNoi2 = new Chuyenxenoithanh(
                "NT02", "Tran Van B", "51B-67890",
                700000, 15, 32.0
        );

        // 2 chuyến xe ngoại thành
        Chuyenxengoaithanh xeNgoai1 = new Chuyenxengoaithanh(
                "NG01", "Le Van C", "51C-11111",
                1500000, "Vung Tau", 2
        );

        Chuyenxengoaithanh xeNgoai2 = new Chuyenxengoaithanh(
                "NG02", "Pham Van D", "51D-22222",
                2000000, "Da Lat", 3
        );

        // Thêm vào danh sách
        danhSach.add(xeNoi1);
        danhSach.add(xeNoi2);
        danhSach.add(xeNgoai1);
        danhSach.add(xeNgoai2);

        // Xuất danh sách
        System.out.println("===== DANH SACH CHUYEN XE =====");

        for (Chuyenxe xe : danhSach) {
            System.out.println(xe);
        }

        // Tính tổng doanh thu
        double tongDoanhThu = 0;
        double doanhThuNoiThanh = 0;
        double doanhThuNgoaiThanh = 0;

        for (Chuyenxe xe : danhSach) {
            tongDoanhThu += xe.getDoanhThu();

            if (xe instanceof Chuyenxenoithanh) {
                doanhThuNoiThanh += xe.getDoanhThu();
            } else if (xe instanceof Chuyenxengoaithanh) {
                doanhThuNgoaiThanh += xe.getDoanhThu();
            }
        }

        System.out.println("\n===== DOANH THU =====");
        System.out.println("Tong doanh thu: " + tongDoanhThu);
        System.out.println("Doanh thu noi thanh: " + doanhThuNoiThanh);
        System.out.println("Doanh thu ngoai thanh: " + doanhThuNgoaiThanh);
    }
}