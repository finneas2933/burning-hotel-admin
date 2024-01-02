package controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Hotel_Manager;
import model.tbl_CTPhieuDV;
import model.tbl_CTPhieuSP;
import model.tbl_DichVu;
import model.tbl_HangHoa;
import model.tbl_HoaDon;
import model.tbl_KhachHang;
import model.tbl_MonAn;
import model.tbl_PhieuDatPhong;
import model.tbl_Phong;
import model.tbl_PhieuBonus;

public class DatPhongController {

    private static Connection conn = null;
    private static String sql, sql1;

    public static List<tbl_Phong> NguonPhong(String sPhanLoai, String sMaKT) throws IOException {
        List<tbl_Phong> arrPhong = new ArrayList<>();
        Statement state = null;
        try {
            conn = DriverManager.getConnection(Hotel_Manager.dbURL);
            // Thực hiện truy vấn và lấy kết quả trả về
            sql = "Select MaPhong, LoaiPhong, LEFT(MaPhong,1) as Tang, TrangThai From Phong";
            if (sMaKT != null && !sMaKT.equals("")) {
                sql = sql + " Where " + sPhanLoai + " Like '%" + sMaKT + "%'";
            }
            sql = sql + " Order by MaPhong";
            state = conn.createStatement();
            ResultSet rs = state.executeQuery(sql);
            // Xử lý kết quả trả về
            while (rs.next()) {
                tbl_Phong bp = new tbl_Phong();
                bp.setMaPhong(rs.getString("MaPhong"));
                bp.setLoaiPhong(rs.getString("LoaiPhong"));
                bp.setTang(rs.getString("Tang"));
                bp.setTinhTrang(rs.getString("TrangThai"));
                if (rs.getString("TrangThai").equals("Trống")) {
                    bp.setTinhTrang("Trống");
                } else {
                    bp.setTinhTrang("Đầy");
                }
                arrPhong.add(bp);
            }
            state.close();
            conn.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return arrPhong;
    }

    public static List<tbl_KhachHang> NguonKhachHang(String sPhanLoai, String sMaKT) {
    List<tbl_KhachHang> arrKhachHang = new ArrayList<>();
    Statement state = null;
    try {
        conn = DriverManager.getConnection(Hotel_Manager.dbURL);
        // Thực hiện truy vấn và lấy kết quả trả về
        sql = "Select * From khachhang";
        if (sMaKT != null && !sMaKT.equals("")) {
            sql = sql + " Where " + sPhanLoai + " Like '%" + sMaKT + "%'";
        }
        sql = sql + " order by ID DESC";
        state = conn.createStatement();
        ResultSet rs = state.executeQuery(sql);
        // Xử lý kết quả trả về
        while (rs.next()) {
            tbl_KhachHang bp = new tbl_KhachHang();
            bp.setMakh(rs.getString("ID"));
            bp.setTenkh(rs.getString("HoTen"));
            bp.setDiachi(rs.getString("DiaChi"));
            
            int gioiTinhValue = rs.getInt("GioiTinh");
            String gioiTinh;
            switch (gioiTinhValue) {
                case 1:
                    gioiTinh = "Nam";
                    break;
                case 0:
                    gioiTinh = "Nữ";
                    break;
                default:
                    gioiTinh = "Khác";
                    break;
            }
            
            bp.setGioitinh(gioiTinh);
            
            bp.setEmail(rs.getString("Email"));
            bp.setCmnd(rs.getString("CMND"));
            bp.setSdt(rs.getString("SDT"));
            arrKhachHang.add(bp);
        }
        state.close();
        conn.close();
    } catch (SQLException ex) {
        ex.printStackTrace();
    }
    return arrKhachHang;
}


    public static List<tbl_MonAn> NguonSanPham(String sMaKT) {
        List<tbl_MonAn> arrMonAn = new ArrayList<>();
        Statement state = null;
        try {
            conn = DriverManager.getConnection(Hotel_Manager.dbURL);
            state = conn.createStatement();
            sql = "select * from doan";
            if (sMaKT != null && !sMaKT.equals("")) {
                sql = sql + " WHERE ID Like '%" + sMaKT + "%'";
            }
            ResultSet rs = (ResultSet) state.executeQuery(sql);
            while (rs.next()) {
                tbl_MonAn hh = new tbl_MonAn();
                hh.setID(rs.getString("ID"));
                hh.setTenMon(rs.getString("TenMon"));
                hh.setPhanLoai(rs.getString("PhanLoai"));
                hh.setThoiGianNau(rs.getString("ThoiGianNau"));
                hh.setDoKho(rs.getString("DoKho"));
                hh.setThanhPhan(rs.getString("ThanhPhan"));
                hh.setHamLuongKalo(rs.getString("HamLuongKalo"));                
                hh.setThanhTien(rs.getString("ThanhTien"));
                hh.setMoTa(rs.getString("MoTa"));
                hh.setSoLuongDaBan(rs.getString("SoLuongDaBan"));
                arrMonAn.add(hh);
            }
            state.close();
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(HangHoaController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return arrMonAn;

    }

    public static List<tbl_DichVu> NguonDichVu(String sMaKT) {
        List<tbl_DichVu> arrDichVu = new ArrayList<>();
        Statement state = null;
        try {
            java.sql.Connection conn = DriverManager.getConnection(Hotel_Manager.dbURL);
            // Thực hiện truy vấn và lấy kết quả trả về
            sql = "Select * From DichVu ";
            if (sMaKT != null && !sMaKT.equals("")) {
                sql = sql + " Where MaDichVu Like '%" + sMaKT + "%'";
            }
            sql = sql + " Order by MaDichVu";
            state = conn.createStatement();
            ResultSet rs = state.executeQuery(sql);
            // Xử lý kết quả trả về
            while (rs.next()) {
                tbl_DichVu bp = new tbl_DichVu();
                bp.setMadichvu(rs.getString("MaDichVu"));
                bp.setTendichvu(rs.getString("TenDichVu"));
                bp.setGiadichvu(rs.getString("DonGia"));
                arrDichVu.add(bp);
            }
            state.close();
            conn.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return arrDichVu;
    }
    
    public static List<tbl_PhieuDatPhong> NguonPhieuDatPhong(String sMaKT) throws IOException {
        List<tbl_PhieuDatPhong> arrPhieuDatPhong = new ArrayList<>();
        Statement state = null;
        try {
            conn = DriverManager.getConnection(Hotel_Manager.dbURL);
            // Thực hiện truy vấn và lấy kết quả trả về
            sql = "Select * From phieudatphong";
            if(sMaKT != null && !sMaKT.equals("")){
                sql = sql + " Where MaPhieuDatPhong ='" + sMaKT + "'";
            }
            sql = sql + " order by MaPhieuDatPhong ";
            state = conn.createStatement();
            ResultSet rs = state.executeQuery(sql);
            // Xử lý kết quả trả về
            while (rs.next()) {
                tbl_PhieuDatPhong bp = new tbl_PhieuDatPhong();
                bp.setMaPhieuDK(rs.getString("MaPhieuDatPhong"));
                bp.setMaKhachHang(rs.getString("ID"));
                bp.setNgayDen(rs.getString("NgayDen"));
                bp.setNgayDi(rs.getString("NgayDi"));
                bp.setMaPhong(rs.getString("MaPhong"));
                bp.setMaNhanVien(rs.getString("MaNhanVien"));
                bp.setThanhTien(rs.getString("ThanhTienP"));
                arrPhieuDatPhong.add(bp);
            }
            state.close();
            conn.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        } 
        return arrPhieuDatPhong;
    }

    public static String NguonTruyVanDuLieu(String sTenCotGT, String sTenBang, String sTenCotDK, String sDieuKien) throws IOException {
        String ketqua = "";
        Statement state = null;
        try {
            conn = DriverManager.getConnection(Hotel_Manager.dbURL);
            // Thực hiện truy vấn và lấy kết quả trả về
            sql = "Select " + sTenCotGT + " From " + sTenBang + " Where " + sTenCotDK + " = '" + sDieuKien + "'";
            state = conn.createStatement();
            ResultSet rs = state.executeQuery(sql);
            // Xử lý kết quả trả về
            while (rs.next()) {
                ketqua = rs.getString(sTenCotGT);
            }
            state.close();
            conn.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return ketqua;
    }
    
    public static int MaPhieuLonNhat() throws IOException {
        int ketqua = 0;
        Statement state = null;
        try {
            conn = DriverManager.getConnection(Hotel_Manager.dbURL);
            // Thực hiện truy vấn và lấy kết quả trả về
            sql = "SELECT MAX(MaPDP) FROM phieudatphong";
            state = conn.createStatement();
            ResultSet rs = state.executeQuery(sql);
            // Xử lý kết quả trả về
            while (rs.next()) {
                ketqua = rs.getInt("MAX(MaPDP)") + 1;
            }
            state.close();
            conn.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return ketqua;
    }

    // kiem tra trung ma
    public static boolean KiemTra(String tenbang, String tentruong, String manhap) throws SQLException {
        conn = null;
        Statement state = null;
        boolean kq = false;
        conn = DriverManager.getConnection(Hotel_Manager.dbURL);
        sql = "Select * From " + tenbang + " Where " + tentruong + " = '" + manhap + "'";
        state = conn.createStatement();
        ResultSet rs = state.executeQuery(sql);
        if (rs.next()) {
            state.close();
            conn.close();
            kq = true;
        } else {
            state.close();
            conn.close();
            kq = false;
        }
        return kq;
    }

    public static void ThemKhachHang(tbl_KhachHang bp) throws SQLException {
        conn = null;
        PreparedStatement state = null;
        try {
            java.sql.Connection conn = DriverManager.getConnection(Hotel_Manager.dbURL);
            sql = "INSERT INTO KhachHang (ID, TenKhachHang, DiaChi, GioiTinh, CMND, SDT) VALUES(?, ?, ?, ?, ?, ?)";
            state = conn.prepareStatement(sql);
            state.setString(1, bp.getMakh());
            state.setString(2, bp.getTenkh());
            state.setString(3, bp.getDiachi());
            state.setString(4, bp.getGioitinh());
            state.setString(5, bp.getCmnd());
            state.setString(6, bp.getSdt());
            state.execute();
            state.close();
            conn.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public static boolean ThemPhieuDatPhong(tbl_PhieuDatPhong bp, Date ngayhientai) throws SQLException {
    Connection conn = null;
    PreparedStatement state = null;
    String updateTrangThai = "UPDATE phong SET TrangThai='Đầy' WHERE MaPhong = ?";
    try {
        conn = DriverManager.getConnection(Hotel_Manager.dbURL);
        sql = "INSERT INTO phieudatphong VALUES(?, ?, ?, ?, ?, ?, ?)";
        state = conn.prepareStatement(sql);
        state.setString(1, bp.getMaPhieuDK());
        state.setString(2, bp.getMaKhachHang());
        state.setString(3, bp.getMaNhanVien());
        state.setDouble(4, Double.parseDouble(bp.getThanhTien()));            
        state.setDouble(5, 0.0); // Sử dụng 0.0 thay vì Double.parseDouble("0")
        state.setString(6, "Thanh Toán Trực Tiếp");
        state.setDate(7, new java.sql.Date(ngayhientai.getTime())); // Set giá trị ngày hôm nay

        state.execute();

        PreparedStatement update = conn.prepareStatement(updateTrangThai);
        update.setString(1, bp.getMaPhong());
        update.executeUpdate();
        return true;
    } catch (SQLException ex) {
        System.out.println("Lỗi khi thêm phiếu đặt phòng: " + ex.getMessage());
        ex.printStackTrace();
        return false;
    } finally {
        if (state != null) {
            state.close();
        }
        if (conn != null) {
            conn.close();
        }
    }
}



    // Thêm dữ liệu cho cả bảng phieudichvu, phieusanpham;
    public static void ThemPhieuBonus(tbl_PhieuBonus bp, String MaLoaiPhieu, String tenBang, String dinhDangPhieu) throws SQLException {
        conn = null;
        PreparedStatement state = null;
        try {
            java.sql.Connection conn = DriverManager.getConnection(Hotel_Manager.dbURL);
            // Lấy mã chức vụ lớn nhất trong CSDL
            String sql = "SELECT MAX(" + MaLoaiPhieu + ") FROM " + tenBang;
            Statement statement = conn.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            // Lấy số thứ tự của mã chức vụ hiện tại
            int index = 0;
            if (rs.next()) {
                String maxId = rs.getString(1);
                if (maxId != null) {
                    index = Integer.parseInt(maxId.substring(3));
                }
            }
            index++;
            String newId = dinhDangPhieu + String.format("%03d", index);
            // Thêm mới vào CSDL với mã phiếu dịch vụ mới
            sql = "INSERT INTO " + tenBang + " VALUES (?, ?, ?)";
            state = conn.prepareStatement(sql);
            state.setString(1, newId);
            state.setString(2, bp.getMaphieudatphong());
            state.setDouble(3, Double.parseDouble(bp.getTongtien()));
            state.execute();
            state.close();
            conn.close();
        } catch (SQLException ex) {
            System.out.println("Lỗi: " + ex.getMessage());
        }
    }

    public static void ThemCTPhieuDichVu(tbl_CTPhieuDV bp) throws SQLException {
        String sql_check = "SELECT MAX(MaCTDV) FROM ChiTietPhieuDichVu";
        String sql_checkMa = "SELECT MAX(MaPhieuDichVu) FROM PhieuDichVu";
        sql = "INSERT INTO ChiTietPhieuDichVu  VALUES (?, ?, ?, ?)";
        try (Connection conn = DriverManager.getConnection(Hotel_Manager.dbURL); Statement statement = conn.createStatement(); ResultSet rs = statement.executeQuery(sql_check); Statement statement1 = conn.createStatement(); ResultSet rs1 = statement1.executeQuery(sql_checkMa); PreparedStatement state = conn.prepareStatement(sql)) {

            // Lấy số thứ tự của mã hiện tại
            int index = 1;
            if (rs.next()) {
                String maxId = rs.getString(1);
                if (maxId != null) {
                    index = Integer.parseInt(maxId.substring(1)) + 1;
                }
            }
            // Lấy mã phiếu dịch vụ cuối cùng trong CSDL
            String maphieudichvu = null;
            if (rs1.next()) {
                maphieudichvu = rs1.getString(1);
            }
            // Thêm mới vào CSDL với mã mới
            state.setString(1, String.format("%03d", index));
            state.setString(2, maphieudichvu);
            state.setString(3, bp.getMaDichVu());
            state.setDouble(4, Double.parseDouble(bp.getThanhTien()));
            state.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public static void ThemCTPhieuSanPham(tbl_CTPhieuSP bp) throws SQLException {
        String maxMaCTSP = "SELECT MAX(MaCTSP) FROM ChiTietPhieuSanPham";
        String maxMaPhieuSP = "SELECT MAX(MaPhieuSanPham) FROM PhieuSanPham";
        String updateSoLuong = "UPDATE mathang SET SoLuong = SoLuong - ? WHERE MaHang = ?";
        sql = "INSERT INTO ChiTietPhieuSanPham VALUES (?, ?, ?, ?, ?)";
        try (Connection conn = DriverManager.getConnection(Hotel_Manager.dbURL); PreparedStatement getMaxMaCTSP = conn.prepareStatement(maxMaCTSP); PreparedStatement getMaxMaPhieuSP = conn.prepareStatement(maxMaPhieuSP); PreparedStatement updateSoLuongMH = conn.prepareStatement(updateSoLuong); PreparedStatement insertdata = conn.prepareStatement(sql)) {
            int index = 0;
            ResultSet rs = getMaxMaCTSP.executeQuery();
            if (rs.next()) {
                String maxId = rs.getString(1);
                if (maxId != null) {
                    index = Integer.parseInt(maxId.substring(1));
                }
            }
            index++;
            rs.close();
            rs = getMaxMaPhieuSP.executeQuery();
            String maphieusanpham = null;
            if (rs.next()) {
                maphieusanpham = rs.getString(1);
            }
            insertdata.setString(1, String.format("%03d", index));
            insertdata.setString(2, maphieusanpham);
            insertdata.setString(3, bp.getMaHang());
            insertdata.setString(4, bp.getSoLuong());
            insertdata.setDouble(5, Double.parseDouble(bp.getThanhTien()));
            insertdata.executeUpdate();

            updateSoLuongMH.setString(1, bp.getSoLuong());
            updateSoLuongMH.setString(2, bp.getMaHang());
            updateSoLuongMH.executeUpdate();

        } catch (SQLException ex) {
            System.out.println("Lỗi: " + ex.getMessage());

        }
    }

    public static void ThemHoaDon(tbl_HoaDon bp, String tinhtrang) throws SQLException {
        String maxIdHoaDon = "SELECT MAX(MaHoaDon) FROM HoaDon";
        sql = "INSERT INTO hoadon "
                + "VALUES (?, ?, ?, ?)";
        try (Connection conn = DriverManager.getConnection(Hotel_Manager.dbURL); PreparedStatement getMaxIdHoaDon = conn.prepareStatement(maxIdHoaDon); PreparedStatement insertdata = conn.prepareStatement(sql)) {
            // Lấy phiếu hoá đơn lớn nhất sau đấy để insert tự tăng 1 đơn vị
            int indexHD = 0;
            ResultSet rs = getMaxIdHoaDon.executeQuery();
            if (rs.next()) {
                String maxId = rs.getString(1);
                if (maxId != null && !maxId.isEmpty()) {
                    indexHD = Integer.parseInt(maxId.substring(2));
                }
            }
            indexHD++;
            String newId = "HD" + String.format("%03d", indexHD);
            rs.close();
            String maphieudichvu = null;
            if (rs.next()) {
                maphieudichvu = rs.getString(1);
            }
            insertdata.setString(1, newId);
            insertdata.setString(2, bp.getMaPhieuDatPhong());
            insertdata.setDouble(3, Double.valueOf(bp.getTongTien()));
            insertdata.setString(4, tinhtrang);
            insertdata.execute();
            insertdata.close();
            conn.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    
    public static void TienCoc(String ID, String tiencoc) {
        conn = null;
        PreparedStatement state = null;
        try {
            java.sql.Connection conn = DriverManager.getConnection(Hotel_Manager.dbURL);
            sql = "UPDATE phieudatphongphong SET ThanhToanTruoc = '" + tiencoc + "' WHERE MaPDP = " + ID +";";
            state = conn.prepareStatement(sql);
            state.execute();
            state.close();
            conn.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        } 
    }

    public static void XoaPhieuDatPhong(String maPhong) throws SQLException {
        conn = null;
        PreparedStatement state = null;
        try {
            java.sql.Connection conn = DriverManager.getConnection(Hotel_Manager.dbURL);
            sql = "DELETE FROM phong WHERE maphong = ?";
            state = conn.prepareStatement(sql);
            state.setString(1, maPhong);
            state.execute();
            state.close();
            conn.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public static void CapNhatPhieuDatPhong(tbl_PhieuDatPhong bp, String mapdp, String maphongcu) {
    conn = null;
        PreparedStatement state = null;
        try {
            java.sql.Connection conn = DriverManager.getConnection(Hotel_Manager.dbURL);
            sql = "UPDATE Phong SET TrangThai = CASE " +
                                "WHEN MaPhong = ? THEN 0 " +
                                "WHEN MaPhong = ? THEN 1 " +
                                "ELSE TrangThai END";
            state = conn.prepareStatement(sql);
            state.setString(1, maphongcu);
            state.setString(2, bp.getMaPhong());
            
            state.execute();
 
            sql1="UPDATE PhieuDatPhong SET MaPhong = ?, ThanhTienP = DATEDIFF(NgayDi, NgayDen) * (SELECT GiaPhong FROM Phong WHERE MaPhong = ?)   WHERE MaPhieuDatPhong = ? AND MaPhong = ?";
            state = conn.prepareStatement(sql1);
            state.setString(1, bp.getMaPhong());
            state.setString(2, bp.getMaPhong());
            state.setString(3, mapdp);
            state.setString(4, maphongcu);
            state.execute();
            state.close();
            conn.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        } 
    }
    
    public static void CapNhatPhong(tbl_Phong bp, String maphong) {
        conn = null;
        PreparedStatement state = null;
        try {
            java.sql.Connection conn = DriverManager.getConnection(Hotel_Manager.dbURL);
            sql = "UPDATE phong SET MaPhong = ?, LoaiPhong = ?,SoGiuong = ?, SoPhong = ?, GiaPhong = ?, TrangThai = ?, MoTa = ? WHERE MaPhong = ?";
            state = conn.prepareStatement(sql);
            state.setString(1, bp.getMaPhong());
            state.setString(2, bp.getLoaiPhong());
            //state.setString(3, bp.getSoGiuong());
           // state.setString(4, bp.getSoPhong());
            state.setString(5, bp.getGiaPhong());
            //state.setString(6, bp.getTrangThai());
            state.setString(7, bp.getMoTa());
            state.setString(8, maphong);
            state.execute();
            state.close();
            conn.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        } 
    }
    public static String HienThiPhong(String mpm)  {
       conn = null;
        PreparedStatement state = null;
        String tinhtrang = null;
        try {
            java.sql.Connection conn = DriverManager.getConnection(Hotel_Manager.dbURL);
            sql = " select * from Phong where MaPhong=?";
            state = conn.prepareStatement(sql);
            state.setString(1, mpm);
            ResultSet rs = (ResultSet) state.executeQuery();
            while (rs.next()) {
                tinhtrang = rs.getString("TrangThai"); 
            }
       
    }catch (SQLException ex) {
            ex.printStackTrace();
        } 
        return tinhtrang;
     }
}
