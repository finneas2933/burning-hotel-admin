package view.hoatdong;

import controller.HoaDonController;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import model.tbl_PhieuTraPhong;

public class JP_HoaDon extends javax.swing.JPanel {

    static DefaultTableModel model;
    static ArrayList<tbl_PhieuTraPhong> arrTraPhong = new ArrayList<>();

    public static String mahoadonString, makhachhangString, tenkhachhangString, maphongString, ngaydenString, ngaydiString, songayluutruString, giaphongString, giadichvuString, giamonanString, tongtienString, conthieuString, tiencocString;

    public JP_HoaDon() throws IOException, SQLException {
        initComponents();
        LayNguon("");
    }

    public static void LayNguon(String dk) throws IOException, SQLException {
        arrTraPhong = HoaDonController.NguonPhong(dk);
        model = (DefaultTableModel) tb_hoadon.getModel();
        model.setRowCount(0);
        arrTraPhong.forEach((KQ) -> {
            model.addRow(new Object[]{KQ.getMahoadon(), KQ.getMakhachhang(), KQ.getPhong(), KQ.getNgayden(), KQ.getNgaydi(),
                KQ.getSongayolai(), KQ.getTongthanhtoan(), KQ.getConthieu()});
        });
    }

    public void update() {
        lb_mahoadon.setText(mahoadonString);
        lb_makh.setText(makhachhangString);
        lb_tenkh.setText(tenkhachhangString);
        lb_maphong.setText(maphongString);
        lb_ngayden.setText(ngaydenString);
        lb_ngaydi.setText(ngaydiString);
        lb_songayo.setText(songayluutruString);
        lb_giaphong.setText(giaphongString);
        lb_monan.setText(giamonanString);
        lb_giadichvu.setText(giadichvuString);
        lb_TongTien.setText(tongtienString);
        lb_Con.setText(conthieuString);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        lb_trangthai = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        lb_mahoadon = new javax.swing.JLabel();
        lb_makh = new javax.swing.JLabel();
        lb_tenkh = new javax.swing.JLabel();
        lb_maphong = new javax.swing.JLabel();
        lb_ngayden = new javax.swing.JLabel();
        lb_ngaydi = new javax.swing.JLabel();
        lb_songayo = new javax.swing.JLabel();
        lb_giaphong = new javax.swing.JLabel();
        lb_giadichvu = new javax.swing.JLabel();
        lb_monan = new javax.swing.JLabel();
        lb_TongTien = new javax.swing.JLabel();
        lb_Con = new javax.swing.JLabel();
        btn_dongy = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        jPanel9 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tb_hoadon = new javax.swing.JTable();

        setLayout(new java.awt.BorderLayout());

        jPanel1.setBackground(new java.awt.Color(76, 41, 211));
        jPanel1.setPreferredSize(new java.awt.Dimension(1140, 70));
        jPanel1.setLayout(new java.awt.BorderLayout());

        jLabel1.setFont(new java.awt.Font("Century", 1, 30)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Invoice");
        jPanel1.add(jLabel1, java.awt.BorderLayout.CENTER);

        add(jPanel1, java.awt.BorderLayout.PAGE_START);

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setPreferredSize(new java.awt.Dimension(280, 710));
        jPanel2.setLayout(new java.awt.BorderLayout());

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setPreferredSize(new java.awt.Dimension(200, 120));
        jPanel4.setLayout(new java.awt.BorderLayout());

        jLabel2.setBackground(new java.awt.Color(255, 255, 255));
        jLabel2.setFont(new java.awt.Font("Montserrat Medium", 0, 24)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Hoá Đơn");
        jLabel2.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jLabel2.setPreferredSize(new java.awt.Dimension(45, 100));
        jPanel4.add(jLabel2, java.awt.BorderLayout.CENTER);

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));
        jPanel5.setPreferredSize(new java.awt.Dimension(280, 30));
        jPanel5.setLayout(new java.awt.BorderLayout());

        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/search_16px_blue.png"))); // NOI18N
        jLabel5.setPreferredSize(new java.awt.Dimension(40, 24));
        jLabel5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel5MouseClicked(evt);
            }
        });
        jPanel5.add(jLabel5, java.awt.BorderLayout.LINE_END);

        jPanel4.add(jPanel5, java.awt.BorderLayout.PAGE_START);

        jPanel2.add(jPanel4, java.awt.BorderLayout.PAGE_START);

        jPanel8.setBackground(new java.awt.Color(255, 255, 255));
        jPanel8.setPreferredSize(new java.awt.Dimension(300, 590));
        jPanel8.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setFont(new java.awt.Font("Montserrat", 0, 14)); // NOI18N
        jLabel3.setText("Mã Hoá Đơn:");
        jPanel8.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(2, 23, 108, -1));

        lb_trangthai.setFont(new java.awt.Font("Montserrat", 0, 14)); // NOI18N
        lb_trangthai.setText("Còn:");
        jPanel8.add(lb_trangthai, new org.netbeans.lib.awtextra.AbsoluteConstraints(2, 355, 108, -1));

        jLabel26.setFont(new java.awt.Font("Montserrat", 0, 14)); // NOI18N
        jLabel26.setText("Tổng Tiền:");
        jPanel8.add(jLabel26, new org.netbeans.lib.awtextra.AbsoluteConstraints(2, 323, 108, -1));

        jLabel24.setFont(new java.awt.Font("Montserrat", 0, 14)); // NOI18N
        jLabel24.setText("Giá Dịch Vụ:");
        jPanel8.add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(2, 263, 108, -1));

        jLabel13.setFont(new java.awt.Font("Montserrat", 0, 14)); // NOI18N
        jLabel13.setText("Giá Phòng:");
        jPanel8.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(2, 233, 108, -1));

        jLabel14.setFont(new java.awt.Font("Montserrat", 0, 14)); // NOI18N
        jLabel14.setText("Lưu Trú:");
        jPanel8.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(2, 203, 108, -1));

        jLabel15.setFont(new java.awt.Font("Montserrat", 0, 14)); // NOI18N
        jLabel15.setText("Ngày Đi:");
        jPanel8.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(2, 173, 108, -1));

        jLabel16.setFont(new java.awt.Font("Montserrat", 0, 14)); // NOI18N
        jLabel16.setText("Ngày Đến:");
        jPanel8.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(2, 143, 108, -1));

        jLabel10.setFont(new java.awt.Font("Montserrat", 0, 14)); // NOI18N
        jLabel10.setText("Phòng:");
        jPanel8.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(2, 113, 108, -1));

        jLabel7.setFont(new java.awt.Font("Montserrat", 0, 14)); // NOI18N
        jLabel7.setText("Người Đặt:");
        jPanel8.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(2, 83, 108, -1));

        jLabel6.setFont(new java.awt.Font("Montserrat", 0, 14)); // NOI18N
        jLabel6.setText("Mã Khách Hàng:");
        jPanel8.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(2, 53, -1, -1));

        lb_mahoadon.setFont(new java.awt.Font("Montserrat Medium", 1, 14)); // NOI18N
        lb_mahoadon.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lb_mahoadon.setText(" ");
        jPanel8.add(lb_mahoadon, new org.netbeans.lib.awtextra.AbsoluteConstraints(117, 21, 150, -1));

        lb_makh.setFont(new java.awt.Font("Montserrat Medium", 1, 14)); // NOI18N
        lb_makh.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lb_makh.setText(" ");
        jPanel8.add(lb_makh, new org.netbeans.lib.awtextra.AbsoluteConstraints(117, 51, 150, -1));

        lb_tenkh.setFont(new java.awt.Font("Montserrat Medium", 1, 14)); // NOI18N
        lb_tenkh.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lb_tenkh.setText(" ");
        jPanel8.add(lb_tenkh, new org.netbeans.lib.awtextra.AbsoluteConstraints(117, 81, 150, -1));

        lb_maphong.setFont(new java.awt.Font("Montserrat Medium", 1, 14)); // NOI18N
        lb_maphong.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lb_maphong.setText(" ");
        jPanel8.add(lb_maphong, new org.netbeans.lib.awtextra.AbsoluteConstraints(117, 111, 150, -1));

        lb_ngayden.setFont(new java.awt.Font("Montserrat Medium", 1, 14)); // NOI18N
        lb_ngayden.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lb_ngayden.setText(" ");
        jPanel8.add(lb_ngayden, new org.netbeans.lib.awtextra.AbsoluteConstraints(117, 141, 150, -1));

        lb_ngaydi.setFont(new java.awt.Font("Montserrat Medium", 1, 14)); // NOI18N
        lb_ngaydi.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lb_ngaydi.setText(" ");
        jPanel8.add(lb_ngaydi, new org.netbeans.lib.awtextra.AbsoluteConstraints(117, 171, 150, -1));

        lb_songayo.setFont(new java.awt.Font("Montserrat Medium", 1, 14)); // NOI18N
        lb_songayo.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lb_songayo.setText(" ");
        jPanel8.add(lb_songayo, new org.netbeans.lib.awtextra.AbsoluteConstraints(117, 201, 150, -1));

        lb_giaphong.setFont(new java.awt.Font("Montserrat Medium", 1, 14)); // NOI18N
        lb_giaphong.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lb_giaphong.setText(" ");
        jPanel8.add(lb_giaphong, new org.netbeans.lib.awtextra.AbsoluteConstraints(117, 231, 150, -1));

        lb_giadichvu.setFont(new java.awt.Font("Montserrat Medium", 1, 14)); // NOI18N
        lb_giadichvu.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lb_giadichvu.setText(" ");
        jPanel8.add(lb_giadichvu, new org.netbeans.lib.awtextra.AbsoluteConstraints(117, 261, 150, -1));

        lb_monan.setFont(new java.awt.Font("Montserrat Medium", 1, 14)); // NOI18N
        lb_monan.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lb_monan.setText(" ");
        jPanel8.add(lb_monan, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 290, 150, -1));

        lb_TongTien.setFont(new java.awt.Font("Montserrat Medium", 1, 14)); // NOI18N
        lb_TongTien.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lb_TongTien.setText(" ");
        jPanel8.add(lb_TongTien, new org.netbeans.lib.awtextra.AbsoluteConstraints(117, 321, 150, -1));

        lb_Con.setFont(new java.awt.Font("Montserrat Medium", 1, 14)); // NOI18N
        lb_Con.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lb_Con.setText(" ");
        jPanel8.add(lb_Con, new org.netbeans.lib.awtextra.AbsoluteConstraints(117, 351, 150, -1));

        btn_dongy.setFont(new java.awt.Font("Montserrat", 3, 14)); // NOI18N
        btn_dongy.setText("Thanh Toán");
        btn_dongy.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_dongyMouseClicked(evt);
            }
        });
        btn_dongy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_dongyActionPerformed(evt);
            }
        });
        jPanel8.add(btn_dongy, new org.netbeans.lib.awtextra.AbsoluteConstraints(5, 410, 270, -1));

        jLabel4.setFont(new java.awt.Font("Montserrat", 0, 14)); // NOI18N
        jLabel4.setText("Món Ăn:");
        jPanel8.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(4, 290, 60, -1));

        jPanel2.add(jPanel8, java.awt.BorderLayout.CENTER);

        add(jPanel2, java.awt.BorderLayout.LINE_END);

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setLayout(new java.awt.BorderLayout());

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));
        jPanel6.setPreferredSize(new java.awt.Dimension(100, 10));
        jPanel6.setRequestFocusEnabled(false);
        jPanel3.add(jPanel6, java.awt.BorderLayout.PAGE_START);

        jPanel7.setBackground(new java.awt.Color(255, 255, 255));
        jPanel7.setPreferredSize(new java.awt.Dimension(5, 100));
        jPanel3.add(jPanel7, java.awt.BorderLayout.LINE_END);

        jPanel9.setBackground(new java.awt.Color(255, 255, 255));
        jPanel9.setPreferredSize(new java.awt.Dimension(5, 100));
        jPanel3.add(jPanel9, java.awt.BorderLayout.LINE_START);

        tb_hoadon.setFont(new java.awt.Font("Montserrat", 0, 14)); // NOI18N
        tb_hoadon.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "ID", "Mã Khách Hàng", "Phòng", "Ngày Đến", "Ngày Đi", "Lưu Trú", "Tổng Tiền", "Còn"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tb_hoadon.setRowHeight(25);
        tb_hoadon.setRowMargin(2);
        tb_hoadon.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tb_hoadonMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tb_hoadon);
        if (tb_hoadon.getColumnModel().getColumnCount() > 0) {
            tb_hoadon.getColumnModel().getColumn(0).setPreferredWidth(5);
            tb_hoadon.getColumnModel().getColumn(1).setPreferredWidth(25);
            tb_hoadon.getColumnModel().getColumn(2).setPreferredWidth(25);
            tb_hoadon.getColumnModel().getColumn(3).setPreferredWidth(25);
            tb_hoadon.getColumnModel().getColumn(4).setPreferredWidth(25);
            tb_hoadon.getColumnModel().getColumn(5).setPreferredWidth(5);
            tb_hoadon.getColumnModel().getColumn(6).setPreferredWidth(30);
            tb_hoadon.getColumnModel().getColumn(7).setPreferredWidth(30);
        }

        jPanel3.add(jScrollPane2, java.awt.BorderLayout.CENTER);

        add(jPanel3, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    private void layThem(String a) {
        try {
            ArrayList<tbl_PhieuTraPhong> arrThem = HoaDonController.NguonPhongBonus(a);
           
            for (tbl_PhieuTraPhong phieuTraPhong : arrThem) {
                giaphongString = phieuTraPhong.getGiaphong();
                giadichvuString = phieuTraPhong.getGiadichvu();
                tenkhachhangString = phieuTraPhong.getTenkhachhang();
                giamonanString = phieuTraPhong.getGiamonan();
            }
        } catch (SQLException ex) {
            Logger.getLogger(JP_HoaDon.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void MoKhoaBTN(String a) {
        if (a.equals("Hoàn Thành")) {
            btn_dongy.setVisible(false);
            lb_trangthai.setText("Trạng thái:");
        } else {
            btn_dongy.setVisible(true);
            lb_trangthai.setText("Còn:");
        }
    }
    private void btn_dongyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_dongyActionPerformed

    }//GEN-LAST:event_btn_dongyActionPerformed

    private void btn_dongyMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_dongyMouseClicked
        try {
            JFrame dialogHD = new JDiaLog_HoaDon();
            dialogHD.setVisible(true);
            dialogHD.setLocationRelativeTo(null);
        } catch (SQLException | IOException ex) {
            Logger.getLogger(JP_HoaDon.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btn_dongyMouseClicked

    private void jLabel5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel5MouseClicked
        JFrame dialogBL = new JDiaLog_BoLocHoaDon();
        dialogBL.setVisible(true);
        dialogBL.setLocationRelativeTo(null);
    }//GEN-LAST:event_jLabel5MouseClicked

    private void tb_hoadonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tb_hoadonMouseClicked
        int index = tb_hoadon.getSelectedRow();
        TableModel model = tb_hoadon.getModel();
        mahoadonString = model.getValueAt(index, 0).toString();
        makhachhangString = model.getValueAt(index, 1).toString();
        maphongString = model.getValueAt(index, 2).toString();
        ngaydenString = model.getValueAt(index, 3).toString();
        ngaydiString = model.getValueAt(index, 4).toString();
        songayluutruString = model.getValueAt(index, 5).toString();
        tongtienString = model.getValueAt(index, 6).toString();
        conthieuString = model.getValueAt(index, 7).toString();

        layThem(mahoadonString);
        update();
        MoKhoaBTN(conthieuString);
    }//GEN-LAST:event_tb_hoadonMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_dongy;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane2;
    public static javax.swing.JLabel lb_Con;
    public static javax.swing.JLabel lb_TongTien;
    public static javax.swing.JLabel lb_giadichvu;
    public static javax.swing.JLabel lb_giaphong;
    public static javax.swing.JLabel lb_mahoadon;
    public static javax.swing.JLabel lb_makh;
    public static javax.swing.JLabel lb_maphong;
    public static javax.swing.JLabel lb_monan;
    public static javax.swing.JLabel lb_ngayden;
    public static javax.swing.JLabel lb_ngaydi;
    public static javax.swing.JLabel lb_songayo;
    public static javax.swing.JLabel lb_tenkh;
    private javax.swing.JLabel lb_trangthai;
    public static javax.swing.JTable tb_hoadon;
    // End of variables declaration//GEN-END:variables
}
