package controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Hotel_Manager;
import model.tbl_HangHoa;
import model.tbl_Nhaphanphoi;
import model.tbl_NhapHang;
import static model.Hotel_Manager.dbURL;
import model.tbl_DoAn;

public class HangHoaController {

    
    public static Connection conn = null;
    public static String sql, sql2;
    public static String slm, sls;

    public static List<String> NguonCBBHangHoa() throws SQLException{
        List<String> fields = new ArrayList<>();
        Statement state = null;
        java.sql.Connection conn = DriverManager.getConnection(Hotel_Manager.dbURL);
            // Thực hiện truy vấn và lấy kết quả trả về
            sql = "SHOW COLUMNS FROM mathang";
            state = conn.createStatement();
            ResultSet rs = state.executeQuery(sql);
             while (rs.next()) {
            // Lấy tên trường và thêm vào danh sách
            String fieldName = rs.getString("Field");
            fields.add(fieldName);
        }
        return fields;
    }
    
    public static List<tbl_HangHoa> LoadDataHangHoaToArrayList(String sMaKT,String tCot) {
        List<tbl_HangHoa> list = new ArrayList<>();
        try {
            conn = (Connection) DriverManager.getConnection(dbURL);
            Statement st = (Statement) conn.createStatement();
            sql = "Select * From mathang";
            if(sMaKT != null && !sMaKT.equals("")){
                if (sMaKT != null && !sMaKT.equals("")) {
                   sql = sql + " WHERE " + tCot + " LIKE '%" + sMaKT + "%'";
                }
            }
            sql = sql + " order by MaHang";
            ResultSet rs = (ResultSet) st.executeQuery(sql);
            while (rs.next()) {
                tbl_HangHoa hh = new tbl_HangHoa();
                hh.setMahang(rs.getString("MaHang"));
                hh.setTenhang(rs.getString("TenHang"));
                hh.setMacongty(rs.getString("MaCongTy"));
                hh.setLoaihang(rs.getString("LoaiHang"));
                hh.setSoluong(rs.getString("SoLuong"));
                hh.setDonvitinh(rs.getString("Donvitinh"));
                hh.setGianhap(rs.getString("GiaNhap"));
                hh.setGiaban(rs.getString("GiaBan"));

                list.add(hh);
            }
            st.close();
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(HangHoaController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
    
        public static String LayGiaBan(String mahang) {
         PreparedStatement state = null;
         String giaban = "";

         try {
             java.sql.Connection conn = DriverManager.getConnection(dbURL);
             String sql = "SELECT GiaBan FROM mathang WHERE MaHang=?";
             state = conn.prepareStatement(sql);
             state.setString(1, mahang);

             ResultSet rs = state.executeQuery();
             while (rs.next()) {
                 giaban = rs.getString("GiaBan");
             }
         } catch (SQLException ex) {
             ex.printStackTrace();
             // throw new SQLException("Lỗi khi cập nhật sản phẩm");
         }

         return giaban;
     }

    public static List<tbl_Nhaphanphoi> LoadDatanccToArrayList() {
        List<tbl_Nhaphanphoi> list = new ArrayList<>();
        try {
            conn = (Connection) DriverManager.getConnection(dbURL);
            Statement st = (Statement) conn.createStatement();
            sql = " select * from nhacungcap ";
            ResultSet rs = (ResultSet) st.executeQuery(sql);
            while (rs.next()) {
                tbl_Nhaphanphoi ncc = new tbl_Nhaphanphoi();
                ncc.setMact(rs.getString("MaCongTy"));
                ncc.setTenct(rs.getString("TenCongTy"));
                ncc.setDiachi(rs.getString("DiaChi"));
                ncc.setEmail(rs.getString("Email"));
                ncc.setDienthoai(rs.getString("DienThoai"));

                list.add(ncc);
            }
            st.close();
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(HangHoaController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
    
   
    public static void ThemHangHoa(tbl_HangHoa hh) {
        conn = null;
        PreparedStatement state = null;
        try {
            java.sql.Connection conn = DriverManager.getConnection(dbURL);
            sql = "INSERT INTO mathang (MaHang, TenHang, MaCongTy,LoaiHang,SoLuong,DonViTinh,GiaNhap,GiaBan) VALUES (?, ?, ?,?, ?, ?,?,?)";
            state = conn.prepareStatement(sql);
            state.setString(1, hh.getMahang());
            state.setString(2, hh.getTenhang());
            state.setString(3, hh.getMacongty());
            state.setString(4, hh.getLoaihang());
            state.setString(5, hh.getSoluong());
            state.setString(6, hh.getDonvitinh());
            state.setString(7, hh.getGianhap());
            state.setString(8, hh.getGiaban());

            state.execute();
            state.close();
            conn.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {

            try {
                if (state != null) {
                    state.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }

    public static void CapNhapHangHoa(tbl_HangHoa hh, String masp) {
        conn = null;
        PreparedStatement state = null;
        try {
            java.sql.Connection conn = DriverManager.getConnection(dbURL);
            sql = "UPDATE mathang SET MaHang = ?, TenHang = ?,MaCongTy=?,LoaiHang=?, SoLuong = ?,DonViTinh=?, GiaNhap=?, GiaBan=? WHERE MaHang = ?";

            state = conn.prepareStatement(sql);
            state.setString(1, hh.getMahang());
            state.setString(2, hh.getTenhang());
            state.setString(3, hh.getMacongty());
            state.setString(5, hh.getSoluong());
            state.setString(4, hh.getLoaihang());
            state.setString(6, hh.getDonvitinh());
            state.setString(7, hh.getGianhap());
            state.setString(8, hh.getGiaban());
            state.setString(9, masp);
            state.execute();
            state.close();
            conn.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {

            try {
                if (state != null) {
                    state.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }

    public static void XoaHangHoa(String masp) {
        conn = null;
        PreparedStatement state = null;
        try {
            java.sql.Connection conn = DriverManager.getConnection(dbURL);
            sql = "DELETE FROM mathang WHERE MaHang = ?";
            state = conn.prepareStatement(sql);
            state.setString(1, masp);
            state.execute();
            state.close();
            conn.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {

            try {
                if (state != null) {
                    state.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }

    public static boolean KiemTraTrungMa(String tenbang, String tentruong, String manhap, boolean kt, String macu) {
        conn = null;
        Statement state = null;
        boolean kq = false;
        try {
            conn = (Connection) DriverManager.getConnection(dbURL);
            if (kt == true) {
                sql = "Select * From " + tenbang + " Where " + tentruong + " = '" + manhap + "'";
            } else {
                sql = "Select * From " + tenbang + " Where " + tentruong + " = '" + manhap + "' and " + tentruong + " <> '" + macu + "'";
            }
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
        } catch (SQLException ex) {
            Logger.getLogger(HangHoaController.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (state != null) {
                try {
                    state.close();
                } catch (SQLException ex) {
                    Logger.getLogger(HangHoaController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException ex) {
                    Logger.getLogger(HangHoaController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return kq;
    }

    public static List<tbl_NhapHang> LoadDataNhapHangToArrayList(String kt) {
        List<tbl_NhapHang> list = new ArrayList<>();
        try {
            conn = (Connection) DriverManager.getConnection(dbURL);
            Statement st = (Statement) conn.createStatement();
            sql = " select * from nhaphang ";
             if (kt != null && !kt.equals("")) {
                sql = sql + "where MaNhapHang like N'%" + kt + "%' or MaHang like N'%" + kt + "%'";

            }
            ResultSet rs = (ResultSet) st.executeQuery(sql);
            while (rs.next()) {
                tbl_NhapHang nh = new tbl_NhapHang();
                nh.setMaNhap(rs.getString("MaNhapHang"));
                nh.setMaHang(rs.getString("MaHang"));
                nh.setMaCongTy(rs.getString("MaCongTy"));
                nh.setSoluong(rs.getInt("SoLuong"));
                nh.setDonViTinh(rs.getString("Donvitinh"));
                nh.setLoaiHang(rs.getString("LoaiHang"));
                nh.setGiaNhap(rs.getString("GiaNhap"));
                nh.setNgayNhap(rs.getString("NgayNhap"));

                list.add(nh);
            }
            st.close();
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(HangHoaController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;

    }
    public static String gianhapgoc="";
    public static boolean KiemTraSp(String masp, String mancc) {
    boolean kt = false; 
  
    try {
        java.sql.Connection conn = DriverManager.getConnection(dbURL);
        String sql = "SELECT * FROM mathang  WHERE  MaHang = ? AND MaCongTy = ?";
        PreparedStatement state = conn.prepareStatement(sql);
        state.setString(1, masp);
        state.setString(2, mancc);

        ResultSet rs = state.executeQuery();
        if (rs.next()) {
            gianhapgoc=rs.getString("GiaNhap");
            kt = true; 
        }

        conn.close();
    } catch (SQLException ex) {
        ex.printStackTrace();
        // throw new SQLException("Lỗi khi cập nhật sản phẩm");
    }

    return kt;
}

            
    public static void NhapHangHoa(tbl_NhapHang nh) throws SQLException {
        conn = null;
        PreparedStatement state = null;
        try {
            java.sql.Connection conn = DriverManager.getConnection(dbURL);
            
            sql = "Update mathang Set SoLuong= SoLuong + ? , GiaNhap =? WHERE MaHang = ? and MaCongTy=? ";
            state = conn.prepareStatement(sql);
            state.setInt(1, nh.getSoluong());
            state.setString(2, nh.getGiaNhap());
            state.setString(3, nh.getMaHang());
            state.setString(4, nh.getMaCongTy());
            int rowsUpdated = state.executeUpdate();
            if (rowsUpdated == 0) {
                throw new SQLException("Không tìm thấy sản phẩm để cập nhật");
            }

            sql2 = "INSERT INTO nhaphang (MaNhapHang,MaHang, MaCongTy,SoLuong,LoaiHang,DonViTinh,GiaNhap,NgayNhap) VALUES (?,?, ?, ?,?, ?, ?,?) ";
            state = conn.prepareStatement(sql2);
            state.setString(1, nh.getMaNhap());
            state.setString(2, nh.getMaHang());
            state.setString(3, nh.getMaCongTy());
            state.setInt(4, nh.getSoluong());
            state.setString(5, nh.getLoaiHang());
            state.setString(6, nh.getDonViTinh());
            state.setString(7, nh.getGiaNhap());
            state.setString(8, nh.getNgayNhap());
            state.execute();

            conn.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
            throw new SQLException("Lỗi khi cập nhật sản phẩm");
        } finally {

            try {
                if (state != null) {
                    state.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }

    public static void SuaHangHoa(tbl_NhapHang hh, String mcnhap, String mmnhap, String mcsp,String mmsp, String mcty) throws SQLException {
        conn = null;
        PreparedStatement state = null;
        int soluongcu = 0;
        try {
            java.sql.Connection conn = DriverManager.getConnection(dbURL);
            sql = " select * from nhaphang where MaNhapHang=? and MaHang=?";
            state = conn.prepareStatement(sql);
            state.setString(1, mcnhap);
            state.setString(2, mcsp);

            ResultSet rs = (ResultSet) state.executeQuery();
            while (rs.next()) {
                soluongcu = rs.getInt("SoLuong"); 
            }
            if (mcsp==mmsp && mcnhap==mmnhap) {
                    sql2 = "Update mathang Set SoLuong= SoLuong - ? +? , GiaNhap =? WHERE MaHang = ? and MaCongTy=? ";
                    state = conn.prepareStatement(sql2);
                    state.setInt(1, soluongcu);
                    state.setInt(2, hh.getSoluong());
                    state.setString(3, hh.getGiaNhap());
                    state.setString(4, hh.getMaHang());
                    state.setString(5, mcty);
                    int rowsUpdated = state.executeUpdate();
                    if (rowsUpdated == 0) {
                        throw new SQLException("Không tìm thấy sản phẩm để cập nhật");
                    }
              
            }
            else  {

                sql2 = "Update mathang Set SoLuong= SoLuong - ? , GiaNhap =? WHERE MaHang = ? and MaCongTy=?";
                state = conn.prepareStatement(sql2);
                state.setInt(1, soluongcu);
                state.setString(2, hh.getGiaNhap());
                state.setString(3, mcsp);
                state.setString(4, mcty);
                state.executeUpdate();

                sql = "Update mathang Set SoLuong= SoLuong + ? , GiaNhap =? WHERE MaHang = ? and MaCongTy=? ";
                state = conn.prepareStatement(sql);
                state.setInt(1, hh.getSoluong());
                state.setString(2, hh.getGiaNhap());
                state.setString(3, hh.getMaHang());
                state.setString(4, hh.getMaCongTy());
                state.executeUpdate();

            }
            sql = "Update  nhaphang Set MaNhapHang = ?, MaHang=?,MaCongTy=?,SoLuong=?,LoaiHang=?,DonViTinh=? , GiaNhap =?,NgayNhap=? WHERE MaNhapHang = ? ";
            state = conn.prepareStatement(sql);
            state.setString(1, hh.getMaNhap());
            state.setString(2, hh.getMaHang());
            state.setString(3, hh.getMaCongTy());
            state.setInt(4, hh.getSoluong());
            state.setString(5, hh.getLoaiHang());
            state.setString(6, hh.getDonViTinh());
            state.setString(7, hh.getGiaNhap());
            state.setString(8, hh.getNgayNhap());
            state.setString(9, mcnhap);
            state.execute();
        
       } catch (SQLException ex) {
            ex.printStackTrace();
//           throw new SQLException("Lỗi khi cập nhật sản phẩm");
        }

    }
        

    public static void XoaNhapHang(tbl_NhapHang hh, String mcnhap, String mcsp, String mcty) {
        conn = null;
        String maNhapHang = null, maHang = null;
        int soluongcu = 0;
        PreparedStatement state = null;
        try {
            java.sql.Connection conn = DriverManager.getConnection(dbURL);

            sql = " select * from nhaphang where MaNhapHang=? and MaHang=?";
            state = conn.prepareStatement(sql);
            state.setString(1, mcnhap);
            state.setString(2, mcsp);

            ResultSet rs = (ResultSet) state.executeQuery();
            while (rs.next()) {
                maNhapHang = rs.getString("MaNhapHang");
                maHang = rs.getString("MaHang");
                soluongcu = rs.getInt("SoLuong");
            }

            sql = "DELETE FROM nhaphang WHERE MaNhapHang = ?";
            state = conn.prepareStatement(sql);
            state.setString(1, mcnhap);
            state.executeUpdate();

            sql2 = "Update mathang Set SoLuong= SoLuong -? , GiaNhap =? WHERE MaHang = ? and MaCongTy=? ";
            state = conn.prepareStatement(sql2);
            state.setInt(1, soluongcu);
            state.setString(2, hh.getGiaNhap());
            state.setString(3, mcsp);
            state.setString(4, mcty);
            state.executeUpdate();

        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {

            try {
                if (state != null) {
                    state.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }
    
    public static List<String> NguonCBBDoAn() throws SQLException{
        List<String> fields = new ArrayList<>();
        Statement state = null;
        java.sql.Connection conn = DriverManager.getConnection(Hotel_Manager.dbURL);
            // Thực hiện truy vấn và lấy kết quả trả về
            sql = "SHOW COLUMNS FROM doan";
            state = conn.createStatement();
            ResultSet rs = state.executeQuery(sql);
             while (rs.next()) {
            // Lấy tên trường và thêm vào danh sách
            String fieldName = rs.getString("Field");
            fields.add(fieldName);
        }
        return fields;
    }
    
    public static List<tbl_DoAn> NguonDoAn(String sMaKT,String tCot) throws IOException {
        List<tbl_DoAn> arrDoAn = new ArrayList<>();
        Statement state = null;
        try {
            java.sql.Connection conn = DriverManager.getConnection(Hotel_Manager.dbURL);
            // Thực hiện truy vấn và lấy kết quả trả về
            sql = "Select * From DoAn";
            if(sMaKT != null && !sMaKT.equals("")){
                if (sMaKT != null && !sMaKT.equals("")) {
                   sql = sql + " WHERE " + tCot + " LIKE '%" + sMaKT + "%'";
                }
            }
            sql = sql + " order by ID";
            state = conn.createStatement();
            ResultSet rs = state.executeQuery(sql);
            // Xử lý kết quả trả về
            while (rs.next()) {
                tbl_DoAn da = new tbl_DoAn();
                da.setId(rs.getString("ID"));
                da.setTenmon(rs.getString("TenMon"));
                da.setPhanloai(rs.getString("PhanLoai"));
                da.setThoigiannau(rs.getString("ThoiGianNau"));
                da.setDokho(rs.getString("DoKho"));
                da.setThanhphan(rs.getString("ThanhPhan"));
                da.setHamluongcalo(rs.getString("HamLuongCalo"));
                da.setThanhtien(rs.getString("ThanhTien"));
                da.setMota(rs.getString("MoTa"));
                da.setSoluongban(rs.getString("SoLuongDaBan"));
                da.setImg(rs.getString("img"));
                arrDoAn.add(da);
            }
            state.close();
            conn.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        } 
        return arrDoAn;
    }
    
    public static void ThemDoAn(tbl_DoAn da) {
        conn = null;
        PreparedStatement state = null;
        try {
            java.sql.Connection conn = DriverManager.getConnection(dbURL);
            sql = "INSERT INTO DoAn (ID, TenMon, PhanLoai, ThoiGianNau, DoKho, ThanhPhan, HamLuongCalo, ThanhTien, MoTa, SoLuongDaBan, img) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            state = conn.prepareStatement(sql);
            state.setString(1, da.getId());
            state.setString(2, da.getTenmon());
            state.setString(3, da.getPhanloai());
            state.setString(4, da.getThoigiannau());
            state.setString(5, da.getDokho());
            state.setString(6, da.getThanhphan());
            state.setString(7, da.getHamluongcalo());
            state.setString(8, da.getThanhtien());
            state.setString(9, da.getMota());
            state.setString(10, da.getSoluongban());
            state.setString(11, da.getImg());
            state.execute();
            state.close();
            conn.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public static void CapNhapDoAn(tbl_DoAn da, String macu) {
        conn = null;
        PreparedStatement state = null;
        try {
            java.sql.Connection conn = DriverManager.getConnection(dbURL);
            sql = "UPDATE DoAn SET ID = ?, TenMon = ?, PhanLoai = ?, ThoiGianNau= ?, DoKho= ?, ThanhPhan = ?, HamLuongCalo = ?, ThanhTien = ?, MoTa = ?, SoLuongDaBan = ?, img = ?  WHERE ID = ?";
            state = conn.prepareStatement(sql);
            state.setString(1, da.getId());
            state.setString(2, da.getTenmon());
            state.setString(3, da.getPhanloai());
            state.setString(4, da.getThoigiannau());
            state.setString(5, da.getDokho());
            state.setString(6, da.getThanhphan());
            state.setString(7, da.getHamluongcalo());
            state.setString(8, da.getThanhtien());
            state.setString(9, da.getMota());
            state.setString(10, da.getSoluongban());
            state.setString(11, da.getImg());
            state.setString(12, macu);
            state.execute();
            state.close();
            conn.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        } 
    }

    public static void XoaDoAn(String id) {
        conn = null;
        PreparedStatement state = null;
        try {
            java.sql.Connection conn = DriverManager.getConnection(dbURL);
            sql = "DELETE FROM DoAn WHERE ID = ?";
            state = conn.prepareStatement(sql);
            state.setString(1, id);
            state.execute();
            state.close();
            conn.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        } 
    }
    
    public static String NguonTruyVanDuDoAn(String sTenCotGT, String sMaKT) throws IOException {
        String ketqua = "";
        Statement state = null;
        try {
            conn = DriverManager.getConnection(Hotel_Manager.dbURL);
            // Thực hiện truy vấn và lấy kết quả trả về
            sql = "Select " + sTenCotGT + " from doan where ID = '" + sMaKT + "'";
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

}
