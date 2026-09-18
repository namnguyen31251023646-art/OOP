using System;
using System.Collections.Generic;

// bai01: Quản lý chuyến xe

public class ChuyenXe
{
    public string MaSoChuyen { get; set; }
    public string HoTenTaiXe { get; set; }
    public string SoXe { get; set; }
    public double DoanhThu { get; set; }

    public ChuyenXe(string maSoChuyen, string hoTenTaiXe, string soXe, double doanhThu)
    {
        MaSoChuyen = maSoChuyen;
        HoTenTaiXe = hoTenTaiXe;
        SoXe = soXe;
        DoanhThu = doanhThu;
    }
}

public class ChuyenXeNoiThanh : ChuyenXe
{
    public int SoTuyen { get; set; }
    public double SoKmDiDuoc { get; set; }

    public ChuyenXeNoiThanh(string maSoChuyen, string hoTenTaiXe, string soXe, double doanhThu, int soTuyen, double soKmDiDuoc)
        : base(maSoChuyen, hoTenTaiXe, soXe, doanhThu)
    {
        SoTuyen = soTuyen;
        SoKmDiDuoc = soKmDiDuoc;
    }
}

public class ChuyenXeNgoaiThanh : ChuyenXe
{
    public string NoiDen { get; set; }
    public int SoNgayDiDuoc { get; set; }

    public ChuyenXeNgoaiThanh(string maSoChuyen, string hoTenTaiXe, string soXe, double doanhThu, string noiDen, int soNgayDiDuoc)
        : base(maSoChuyen, hoTenTaiXe, soXe, doanhThu)
    {
        NoiDen = noiDen;
        SoNgayDiDuoc = soNgayDiDuoc;
    }
}
// bai02: Quản lý sách thư viện
public class Sach
{
    public string MaSach { get; set; }
    public DateTime NgayNhap { get; set; }
    public double DonGia { get; set; }
    public int SoLuong { get; set; }
    public string NhaXuatBan { get; set; }

    public Sach(string maSach, DateTime ngayNhap, double donGia, int soLuong, string nhaXuatBan)
    {
        MaSach = maSach;
        NgayNhap = ngayNhap;
        DonGia = donGia;
        SoLuong = soLuong;
        NhaXuatBan = nhaXuatBan;
    }

    public virtual double GetThanhTien() => 0;
}

public class SachGiaoKhoa : Sach
{
    public bool TinhTrang { get; set; } // true: Mới, false: Cũ

    public SachGiaoKhoa(string maSach, DateTime ngayNhap, double donGia, int soLuong, string nhaXuatBan, bool tinhTrang)
        : base(maSach, ngayNhap, donGia, soLuong, nhaXuatBan)
    {
        TinhTrang = tinhTrang;
    }

    public override double GetThanhTien() => TinhTrang ? SoLuong * DonGia : SoLuong * DonGia * 0.5;
}

public class SachThamKhao : Sach
{
    public double Thue { get; set; }

    public SachThamKhao(string maSach, DateTime ngayNhap, double donGia, int soLuong, string nhaXuatBan, double thue)
        : base(maSach, ngayNhap, donGia, soLuong, nhaXuatBan)
    {
        Thue = thue;
    }

    public override double GetThanhTien() => SoLuong * DonGia + Thue;
}

// bai03: Quản lý giao dịch
public class GiaoDich
{
    public string MaGiaoDich { get; set; }
    public DateTime NgayGiaoDich { get; set; }
    public double DonGia { get; set; }
    public int SoLuong { get; set; }

    public GiaoDich(string maGiaoDich, DateTime ngayGiaoDich, double donGia, int soLuong)
    {
        MaGiaoDich = maGiaoDich;
        NgayGiaoDich = ngayGiaoDich;
        DonGia = donGia;
        SoLuong = soLuong;
    }

    public virtual double GetThanhTien() => SoLuong * DonGia;
}

public class GiaoDichVang : GiaoDich
{
    public string LoaiVang { get; set; }

    public GiaoDichVang(string maGiaoDich, DateTime ngayGiaoDich, double donGia, int soLuong, string loaiVang)
        : base(maGiaoDich, ngayGiaoDich, donGia, soLuong) { LoaiVang = loaiVang; }
}

public class GiaoDichTienTe : GiaoDich
{
    public double TiGia { get; set; }
    public string LoaiTienTe { get; set; } // "VND", "USD", "Euro"

    public GiaoDichTienTe(string maGiaoDich, DateTime ngayGiaoDich, double donGia, int soLuong, double tiGia, string loaiTienTe)
        : base(maGiaoDich, ngayGiaoDich, donGia, soLuong)
    {
        TiGia = tiGia;
        LoaiTienTe = loaiTienTe;
    }

    public override double GetThanhTien() => LoaiTienTe.ToUpper() == "VND" ? SoLuong * DonGia : SoLuong * DonGia * TiGia;
}
// bai04: Quản lý danh sách sách theo mô hình OOP
public class DanhSachSach
{
    private List<Sach> list;

    public DanhSachSach() => list = new List<Sach>();

    public bool Them(Sach s)
    {
        if (list.Exists(x => x.MaSach == s.MaSach)) return false;
        list.Add(s);
        return true;
    }

    public double TinhTongThanhTienSGK()
    {
        double sum = 0;
        foreach (var s in list) if (s is SachGiaoKhoa) sum += s.GetThanhTien();
        return sum;
    }

    public double TinhTongThanhTienSTK()
    {
        double sum = 0;
        foreach (var s in list) if (s is SachThamKhao) sum += s.GetThanhTien();
        return sum;
    }

    public List<Sach> TimSachGiaoKhoaTheoNXB(string nxb)
    {
        return list.FindAll(s => s is SachGiaoKhoa && s.NhaXuatBan.Equals(nxb, StringComparison.OrdinalIgnoreCase));
    }

    public double TimThanhTienCaoNhat()
    {
        double max = 0;
        foreach (var s in list)
        {
            double tt = s.GetThanhTien();
            if (tt > max) max = tt;
        }
        return max;
    }
}

// bai05: Bảng lương nhân viên

public abstract class Employee
{
    public string FirstName { get; set; }
    public string LastName { get; set; }
    public string SSN { get; set; }

    public Employee(string firstName, string lastName, string ssn)
    {
        FirstName = firstName;
        LastName = lastName;
        SSN = ssn;
    }

    public abstract double Earnings();

    public override string ToString() => $"{FirstName} {LastName}\nSSN: {SSN}";
}

public class SalariedEmployee : Employee
{
    public double WeeklySalary { get; set; }

    public SalariedEmployee(string f, string l, string ssn, double weeklySalary) : base(f, l, ssn)
    {
        WeeklySalary = weeklySalary;
    }

    public override double Earnings() => WeeklySalary;
    public override string ToString() => $"Salaried Employee: {base.ToString()}\nWeekly Salary: {WeeklySalary:C}";
}

public class HourlyEmployee : Employee
{
    public double Wage { get; set; }
    public double Hours { get; set; }

    public HourlyEmployee(string f, string l, string ssn, double wage, double hours) : base(f, l, ssn)
    {
        Wage = wage;
        Hours = hours;
    }

    public override double Earnings() => Hours <= 40 ? Wage * Hours : 40 * Wage + (Hours - 40) * Wage * 1.5;
    public override string ToString() => $"Hourly Employee: {base.ToString()}\nWage: {Wage:C}; Hours: {Hours}";
}

public class CommissionEmployee : Employee
{
    public double GrossSales { get; set; }
    public double CommissionRate { get; set; }

    public CommissionEmployee(string f, string l, string ssn, double grossSales, double commissionRate) : base(f, l, ssn)
    {
        GrossSales = grossSales;
        CommissionRate = commissionRate;
    }

    public override double Earnings() => GrossSales * CommissionRate;
    public override string ToString() => $"Commission Employee: {base.ToString()}\nGross Sales: {GrossSales:C}; Rate: {CommissionRate}";
}

public class BasePlusCommissionEmployee : CommissionEmployee
{
    public double BaseSalary { get; set; }

    public BasePlusCommissionEmployee(string f, string l, string ssn, double grossSales, double commissionRate, double baseSalary)
        : base(f, l, ssn, grossSales, commissionRate)
    {
        BaseSalary = baseSalary;
    }

    public override double Earnings() => base.Earnings() + BaseSalary;
    public override string ToString() => $"Base Salaried {base.ToString()}\nBase Salary: {BaseSalary:C}";
}
// bai06: Quản lý siêu thị
public abstract class HangHoa
{
    public string MaHang { get; private set; }
    public string TenHang { get; set; }
    public double DonGia { get; set; }
    public int SoLuongTon { get; set; }

    public HangHoa(string maHang, string tenHang, double donGia, int soLuongTon)
    {
        if (string.IsNullOrWhiteSpace(maHang)) throw new ArgumentException("Ma hang khong duoc rong");
        MaHang = maHang;
        TenHang = string.IsNullOrWhiteSpace(tenHang) ? "xxx" : tenHang;
        DonGia = donGia >= 0 ? donGia : 0;
        SoLuongTon = soLuongTon >= 0 ? soLuongTon : 0;
    }

    public abstract string DanhGiaMucDoBanBuon();
    public abstract double GetVAT();
}

public class HangThucPham : HangHoa
{
    public string NhaCungCap { get; set; }
    public DateTime NgaySanXuat { get; set; }
    public DateTime NgayHetHan { get; set; }

    public HangThucPham(string ma, string ten, double gia, int ton, string ncc, DateTime nsx, DateTime nhh)
        : base(ma, ten, gia, ton)
    {
        NhaCungCap = ncc;
        NgaySanXuat = nsx <= DateTime.Now ? nsx : DateTime.Now;
        NgayHetHan = nhh >= NgaySanXuat ? nhh : NgaySanXuat;
    }

    public override string DanhGiaMucDoBanBuon() => (SoLuongTon > 0 && NgayHetHan < DateTime.Now) ? "Kho ban" : "Khong danh gia";
    public override double GetVAT() => DonGia * 0.05;
}

public class HangDienMay : HangHoa
{
    public int ThoiGianBaoHanh { get; set; }
    public double CongSuat { get; set; }

    public HangDienMay(string ma, string ten, double gia, int ton, int bh, double cs)
        : base(ma, ten, gia, ton)
    {
        ThoiGianBaoHanh = bh >= 0 ? bh : 0;
        CongSuat = cs >= 0 ? cs : 0;
    }

    public override string DanhGiaMucDoBanBuon() => SoLuongTon < 3 ? "Ban duoc" : "Khong danh gia";
    public override double GetVAT() => DonGia * 0.1;
}

public class HangSanhSu : HangHoa
{
    public string NhaSanXuat { get; set; }
    public DateTime NgayNhapKho { get; set; }

    public HangSanhSu(string ma, string ten, double gia, int ton, string nsx, DateTime nnk)
        : base(ma, ten, gia, ton)
    {
        NhaSanXuat = nsx;
        NgayNhapKho = nnk <= DateTime.Now ? nnk : DateTime.Now;
    }

    public override string DanhGiaMucDoBanBuon() => (SoLuongTon > 50 && (DateTime.Now - NgayNhapKho).TotalDays > 10) ? "Ban cham" : "Khong danh gia";
    public override double GetVAT() => DonGia * 0.1;
}
// bai07: Quản lý học viện (Person, Student, Employee, Customer)

public class Person
{
    public string HoTen { get; set; }
    public string DiaChi { get; set; }

    public Person(string hoTen, string diaChi)
    {
        HoTen = hoTen;
        DiaChi = diaChi;
    }

    public override string ToString() => $"Ho Ten: {HoTen}, Dia Chi: {DiaChi}";
}

public class Student : Person
{
    public double DiemMH1 { get; set; }
    public double DiemMH2 { get; set; }

    public Student(string hoTen, string diaChi, double d1, double d2) : base(hoTen, diaChi)
    {
        DiemMH1 = d1;
        DiemMH2 = d2;
    }

    public double TinhDiemTB() => (DiemMH1 + DiemMH2) / 2;

    public override string ToString() => $"{base.ToString()}, Diem TB: {TinhDiemTB():F2}";
}

public class PersonEmployee : Person
{
    public double HeSoLuong { get; set; }

    public PersonEmployee(string hoTen, string diaChi, double heSoLuong) : base(hoTen, diaChi)
    {
        HeSoLuong = heSoLuong;
    }

    public double TinhLuong() => HeSoLuong * 1500000;

    public override string ToString() => $"{base.ToString()}, Luong: {TinhLuong():N0} VND";
}

public class Customer : Person
{
    public string TenCongTy { get; set; }
    public double TriGiaHoaDon { get; set; }

    public Customer(string hoTen, string diaChi, string tenCongTy, double triGiaHoaDon) : base(hoTen, diaChi)
    {
        TenCongTy = tenCongTy;
        TriGiaHoaDon = triGiaHoaDon;
    }

    public override string ToString() => $"{base.ToString()}, Cty: {TenCongTy}, Hoa Don: {TriGiaHoaDon:N0} VND";
}

// bai08: Đa hình với các hình học (Shape, Drawing)

public abstract class Shape
{
    public abstract void Draw();
    public abstract void Erase();
    public abstract void Move(int x, int y);
}

public class Circle : Shape
{
    public override void Draw() => Console.WriteLine("Ve hinh Tron (Circle)");
    public override void Erase() => Console.WriteLine("Xoa hinh Tron (Circle)");
    public override void Move(int x, int y) => Console.WriteLine($"Di chuyen hinh Tron den ({x}, {y})");
}

public class Quad : Shape
{
    public override void Draw() => Console.WriteLine("Ve hinh Tu giac (Quad)");
    public override void Erase() => Console.WriteLine("Xoa hinh Tu giac (Quad)");
    public override void Move(int x, int y) => Console.WriteLine($"Di chuyen hinh Tu giac den ({x}, {y})");
}

public class Rectangle : Quad
{
    public override void Draw() => Console.WriteLine("Ve hinh Chu nhat (Rectangle)");
    public override void Erase() => Console.WriteLine("Xoa hinh Chu nhat (Rectangle)");
    public override void Move(int x, int y) => Console.WriteLine($"Di chuyen hinh Chu nhat den ({x}, {y})");
}

public class Triangle : Shape
{
    public override void Draw() => Console.WriteLine("Ve hinh Tam giac (Triangle)");
    public override void Erase() => Console.WriteLine("Xoa hinh Tam giac (Triangle)");
    public override void Move(int x, int y) => Console.WriteLine($"Di chuyen hinh Tam giac den ({x}, {y})");
}

public class Drawing
{
    public void DrawShape(Shape theShape)
    {
        theShape.Draw();
    }
}

// CHƯƠNG TRÌNH CHẠY CÁC BÀI 

class Program
{
    static void Main()
    {
        Console.WriteLine("=== CHUONG TRINH MODULE 3: KE THUA - DA HINH ===");

        // bai01
        Console.WriteLine("\n--- Demo bai01 ---");
        List<ChuyenXe> dsChuyenXe = new List<ChuyenXe>
        {
            new ChuyenXeNoiThanh("NT01", "Nguyen Van A", "51A-12345", 1500000, 1, 120),
            new ChuyenXeNgoaiThanh("NG01", "Le Van C", "51C-11111", 5000000, "Da Lat", 3)
        };
        double tongDoanhThu = 0;
        foreach (var cx in dsChuyenXe) tongDoanhThu += cx.DoanhThu;
        Console.WriteLine($"Tong doanh thu chuyen xe: {tongDoanhThu:N0} VND");

        // bai02 & bai04
        Console.WriteLine("\n--- Demo bai02 & bai04 ---");
        DanhSachSach dsSach = new DanhSachSach();
        dsSach.Them(new SachGiaoKhoa("SGK1", DateTime.Now, 50000, 10, "Kim Dong", true));
        dsSach.Them(new SachThamKhao("STK1", DateTime.Now, 100000, 3, "Giao Duc", 10000));
        Console.WriteLine($"Tong thanh tien SGK: {dsSach.TinhTongThanhTienSGK():N0} VND");
        Console.WriteLine($"Tong thanh tien STK: {dsSach.TinhTongThanhTienSTK():N0} VND");

        // bai03
        Console.WriteLine("\n--- Demo bai03 ---");
        GiaoDichVang gdVang = new GiaoDichVang("GDV01", DateTime.Now, 6000000, 5, "9999");
        Console.WriteLine($"Thanh tien giao dich vang: {gdVang.GetThanhTien():N0} VND");

        // bai05
        Console.WriteLine("\n--- Demo bai05 ---");
        Employee emp = new SalariedEmployee("John", "Smith", "111-11-111", 800);
        Console.WriteLine(emp);
        Console.WriteLine($"Earnings: {emp.Earnings():C}");

        // bai06
        Console.WriteLine("\n--- Demo bai06 ---");
        HangHoa htp = new HangThucPham("HTP1", "Sua tươi", 15000, 5, "Vinamilk", DateTime.Now.AddDays(-20), DateTime.Now.AddDays(-1));
        Console.WriteLine($"Hang: {htp.TenHang}, Danh gia: {htp.DanhGiaMucDoBanBuon()}, VAT: {htp.GetVAT():N0} VND");

        // bai07
        Console.WriteLine("\n--- Demo bai07 ---");
        Person st = new Student("Nguyen Van A", "TP.HCM", 8.5, 9.0);
        Console.WriteLine(st);

        // bai08
        Console.WriteLine("\n--- Demo bai08 ---");
        Drawing dw = new Drawing();
        dw.DrawShape(new Circle());
        dw.DrawShape(new Rectangle());
    }
}