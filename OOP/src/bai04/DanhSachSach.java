package bai04;

import java.util.ArrayList;
import java.util.List;

public class DanhSachSach {

    private List<Sach> list;
    private int count;

    public DanhSachSach(int n) {
        list = new ArrayList<>(n);
        count = 0;
    }

    public boolean them(Sach sach) {
        for (Sach s : list) {
            if (s.getMaSach().equalsIgnoreCase(sach.getMaSach())) {
                return false;
            }
        }

        list.add(sach);
        count++;
        return true;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();

        for (Sach sach : list) {
            sb.append(sach).append("\n");
        }

        return sb.toString();
    }

    public double tinhTongThanhTienSGK() {
        double tong = 0;

        for (Sach sach : list) {
            if (sach instanceof SachGiaoKhoa) {
                tong += sach.getThanhTien();
            }
        }

        return tong;
    }

    public double tinhTongThanhTienSTK() {
        double tong = 0;

        for (Sach sach : list) {
            if (sach instanceof SachThamKhao) {
                tong += sach.getThanhTien();
            }
        }

        return tong;
    }

    public List<Sach> timSachGiaoKhoaTheoNXB(String nxb) {
        List<Sach> ketQua = new ArrayList<>();

        for (Sach sach : list) {
            if (sach instanceof SachGiaoKhoa
                    && sach.getNhaXuatBan().equalsIgnoreCase(nxb)) {
                ketQua.add(sach);
            }
        }

        return ketQua;
    }

    public double timThanhTienCaoNhat() {
        if (list.isEmpty()) {
            return 0;
        }

        double max = list.get(0).getThanhTien();

        for (Sach sach : list) {
            if (sach.getThanhTien() > max) {
                max = sach.getThanhTien();
            }
        }

        return max;
    }
}