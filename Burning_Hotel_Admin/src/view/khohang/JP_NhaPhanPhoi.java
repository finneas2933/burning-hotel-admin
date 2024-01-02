package view.khohang;

import controller.QuanLyController;
import controller.QuanLyKhachSanController;
import java.io.IOException;
import java.lang.System.Logger;
import java.lang.System.Logger.Level;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import model.tbl_Nhaphanphoi;

public final class JP_NhaPhanPhoi extends javax.swing.JPanel {

    DefaultTableModel model;
    List<tbl_Nhaphanphoi> list = new ArrayList<>();
    private static boolean ktThem;
    private static String macu;
    private static String macty, tencty, email, sdt, diachi;
    private static String timkiem, tcot;

    public JP_NhaPhanPhoi() throws IOException, SQLException {
        initComponents();
        XoaTrang();
        KhoaMo(false);
        LoadDataArrayListToTable();
        LoadComBoBoxNhaPhanPhoi();
        timkiem = "";
    }

    public void LoadDataArrayListToTable() {
        list = QuanLyController.LoadDataToArrayNhaCungCap(timkiem, tcot);
        model = (DefaultTableModel) tb_nhacungcap.getModel();
        model.setRowCount(0);
        for (tbl_Nhaphanphoi ncc : list) {
            model.addRow(new Object[]{ncc.getMact(), ncc.getTenct(), ncc.getDiachi(), ncc.getEmail(), ncc.getDienthoai()});
        }
    }
    
    private DefaultComboBoxModel<String> comboBoxNhaPhanPhoi;
     public void LoadComBoBoxNhaPhanPhoi() throws IOException, SQLException {
        comboBoxNhaPhanPhoi = new DefaultComboBoxModel<>();
        cb_nhaphanphoi.setModel(comboBoxNhaPhanPhoi);
         List<String> nhaphanphoi = QuanLyController.NguonCBBNhaCungCap();
         for (String db : nhaphanphoi) {
            comboBoxNhaPhanPhoi.addElement(db);
         }
    }

    public void KhoaMo(boolean b) {
        txtmacty.setEditable(b);
        txttencty.setEditable(b);
        txtsdt.setEditable(b);
        txtemail.setEditable(b);
        txtdiachi.setEditable(b);
        txtsdt.setEditable(b);
        bt_them.setEnabled(!b);
        bt_sua.setEnabled(!b);
        bt_xoa.setEnabled(!b);
        bt_ghi.setEnabled(b);
        bt_khong.setEnabled(b);
    }

    public void refresh(boolean b) {
        txtmacty.setEditable(b);
        txttencty.setEditable(b);
        txtsdt.setEditable(b);
        txtemail.setEditable(b);
        txtdiachi.setEditable(b);
        txtsdt.setEditable(b);
        bt_them.setEnabled(b);
        bt_sua.setEnabled(b);
        bt_xoa.setEnabled(b);
        bt_ghi.setEnabled(b);
        bt_khong.setEnabled(b);
    }

    public void XoaTrang() {
        txtmacty.setText("");
        txttencty.setText("");
        txtemail.setText("");
        txtdiachi.setText("");
        txtsdt.setText("");
        txt_timkiem.setText("");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel10 = new javax.swing.JPanel();
        jPanel15 = new javax.swing.JPanel();
        cb_nhaphanphoi = new javax.swing.JComboBox<>();
        txt_timkiem = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        btn_b2_refreshdv = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        lb1 = new javax.swing.JLabel();
        txtmacty = new javax.swing.JTextField();
        lb2 = new javax.swing.JLabel();
        txttencty = new javax.swing.JTextField();
        lb7 = new javax.swing.JLabel();
        txtemail = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtdiachi = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtsdt = new javax.swing.JTextField();
        jPanel6 = new javax.swing.JPanel();
        bt_them = new javax.swing.JButton();
        bt_sua = new javax.swing.JButton();
        bt_xoa = new javax.swing.JButton();
        jPanel7 = new javax.swing.JPanel();
        bt_ghi = new javax.swing.JButton();
        bt_khong = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tb_nhacungcap = new javax.swing.JTable();

        setBackground(new java.awt.Color(255, 255, 255));
        setMinimumSize(new java.awt.Dimension(1140, 780));
        setPreferredSize(new java.awt.Dimension(1140, 780));
        setLayout(new java.awt.BorderLayout());

        jPanel1.setBackground(new java.awt.Color(76, 41, 211));
        jPanel1.setPreferredSize(new java.awt.Dimension(1140, 70));
        jPanel1.setLayout(new java.awt.BorderLayout());

        jPanel10.setBackground(new java.awt.Color(76, 41, 211));
        jPanel10.setLayout(new java.awt.BorderLayout());

        jPanel15.setBackground(new java.awt.Color(76, 41, 211));
        jPanel15.setPreferredSize(new java.awt.Dimension(300, 70));
        jPanel15.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEADING, 5, 20));

        cb_nhaphanphoi.setBackground(new java.awt.Color(76, 41, 211));
        cb_nhaphanphoi.setFont(new java.awt.Font("Montserrat", 1, 10)); // NOI18N
        cb_nhaphanphoi.setForeground(new java.awt.Color(255, 255, 255));
        jPanel15.add(cb_nhaphanphoi);

        txt_timkiem.setBackground(new java.awt.Color(123, 156, 225));
        txt_timkiem.setFont(new java.awt.Font("Montserrat Medium", 0, 12)); // NOI18N
        txt_timkiem.setBorder(null);
        txt_timkiem.setMinimumSize(new java.awt.Dimension(100, 15));
        txt_timkiem.setPreferredSize(new java.awt.Dimension(150, 20));
        jPanel15.add(txt_timkiem);

        jLabel8.setFont(new java.awt.Font("Montserrat", 0, 11)); // NOI18N
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/search_25px.png"))); // NOI18N
        jLabel8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel8MouseClicked(evt);
            }
        });
        jPanel15.add(jLabel8);

        btn_b2_refreshdv.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/refresh_26px_light.png"))); // NOI18N
        btn_b2_refreshdv.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_b2_refreshdvMouseClicked(evt);
            }
        });
        jPanel15.add(btn_b2_refreshdv);

        jPanel10.add(jPanel15, java.awt.BorderLayout.LINE_END);

        jPanel1.add(jPanel10, java.awt.BorderLayout.LINE_END);

        jLabel1.setFont(new java.awt.Font("Century Schoolbook", 1, 30)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Provider manager");
        jPanel1.add(jLabel1, java.awt.BorderLayout.CENTER);

        add(jPanel1, java.awt.BorderLayout.PAGE_START);

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setPreferredSize(new java.awt.Dimension(400, 700));
        jPanel3.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 5, 20));

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));
        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Thông Tin Chi Tiết", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Montserrat", 0, 11))); // NOI18N
        jPanel5.setPreferredSize(new java.awt.Dimension(360, 264));

        lb1.setFont(new java.awt.Font("Montserrat", 0, 11)); // NOI18N
        lb1.setText("Mã Công Ty");

        txtmacty.setFont(new java.awt.Font("Montserrat Medium", 0, 14)); // NOI18N
        txtmacty.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtmactyActionPerformed(evt);
            }
        });

        lb2.setFont(new java.awt.Font("Montserrat", 0, 11)); // NOI18N
        lb2.setText("Tên Công Ty:");

        txttencty.setFont(new java.awt.Font("Montserrat Medium", 0, 14)); // NOI18N

        lb7.setFont(new java.awt.Font("Montserrat", 0, 11)); // NOI18N
        lb7.setText("Email:");

        txtemail.setFont(new java.awt.Font("Montserrat Medium", 0, 14)); // NOI18N

        jLabel2.setFont(new java.awt.Font("Montserrat", 0, 11)); // NOI18N
        jLabel2.setText("Địa Chỉ:");

        txtdiachi.setFont(new java.awt.Font("Montserrat Medium", 0, 14)); // NOI18N

        jLabel3.setFont(new java.awt.Font("Montserrat", 0, 11)); // NOI18N
        jLabel3.setText("Điện Thoại:");

        txtsdt.setFont(new java.awt.Font("Montserrat Medium", 0, 14)); // NOI18N

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtmacty)
                    .addComponent(txttencty)
                    .addComponent(txtdiachi)
                    .addComponent(txtemail)
                    .addComponent(txtsdt)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lb7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lb2, javax.swing.GroupLayout.DEFAULT_SIZE, 319, Short.MAX_VALUE)
                    .addComponent(lb1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lb1)
                .addGap(0, 0, 0)
                .addComponent(txtmacty, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lb2)
                .addGap(0, 0, 0)
                .addComponent(txttencty, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addGap(0, 0, 0)
                .addComponent(txtdiachi, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lb7)
                .addGap(0, 0, 0)
                .addComponent(txtemail, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addGap(0, 0, 0)
                .addComponent(txtsdt, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel3.add(jPanel5);

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));
        jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Cập Nhật", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Montserrat", 0, 11))); // NOI18N
        jPanel6.setPreferredSize(new java.awt.Dimension(360, 79));

        bt_them.setFont(new java.awt.Font("Montserrat Medium", 0, 12)); // NOI18N
        bt_them.setText("Thêm ");
        bt_them.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_themActionPerformed(evt);
            }
        });

        bt_sua.setFont(new java.awt.Font("Montserrat Medium", 0, 12)); // NOI18N
        bt_sua.setText("Sửa ");
        bt_sua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_suaActionPerformed(evt);
            }
        });

        bt_xoa.setFont(new java.awt.Font("Montserrat Medium", 0, 12)); // NOI18N
        bt_xoa.setText("Xóa");
        bt_xoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_xoaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(bt_them)
                .addGap(46, 46, 46)
                .addComponent(bt_sua, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 59, Short.MAX_VALUE)
                .addComponent(bt_xoa, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bt_them)
                    .addComponent(bt_sua)
                    .addComponent(bt_xoa))
                .addGap(21, 21, 21))
        );

        jPanel3.add(jPanel6);

        jPanel7.setBackground(new java.awt.Color(255, 255, 255));
        jPanel7.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Điều Khiển", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Montserrat", 0, 11))); // NOI18N
        jPanel7.setPreferredSize(new java.awt.Dimension(360, 70));

        bt_ghi.setBackground(new java.awt.Color(0, 0, 255));
        bt_ghi.setFont(new java.awt.Font("Montserrat SemiBold", 1, 13)); // NOI18N
        bt_ghi.setForeground(new java.awt.Color(255, 255, 255));
        bt_ghi.setText("Ghi");
        bt_ghi.setPreferredSize(new java.awt.Dimension(130, 34));
        bt_ghi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_ghiActionPerformed(evt);
            }
        });

        bt_khong.setFont(new java.awt.Font("Montserrat SemiBold", 1, 13)); // NOI18N
        bt_khong.setForeground(new java.awt.Color(0, 0, 255));
        bt_khong.setText("Không");
        bt_khong.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 255)));
        bt_khong.setPreferredSize(new java.awt.Dimension(130, 34));
        bt_khong.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_khongActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(bt_ghi, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 39, Short.MAX_VALUE)
                .addComponent(bt_khong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bt_ghi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bt_khong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jPanel3.add(jPanel7);

        add(jPanel3, java.awt.BorderLayout.LINE_START);

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setLayout(new java.awt.BorderLayout());

        tb_nhacungcap.setFont(new java.awt.Font("Montserrat Medium", 0, 12)); // NOI18N
        tb_nhacungcap.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "ID", "Tên Công Ty", "Địa Chỉ", "Email", "Điện Thoại"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tb_nhacungcap.setRowHeight(25);
        tb_nhacungcap.setRowMargin(5);
        tb_nhacungcap.setSelectionBackground(new java.awt.Color(255, 255, 255));
        tb_nhacungcap.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tb_nhacungcapMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tb_nhacungcap);
        if (tb_nhacungcap.getColumnModel().getColumnCount() > 0) {
            tb_nhacungcap.getColumnModel().getColumn(0).setPreferredWidth(35);
            tb_nhacungcap.getColumnModel().getColumn(1).setPreferredWidth(150);
            tb_nhacungcap.getColumnModel().getColumn(2).setPreferredWidth(50);
            tb_nhacungcap.getColumnModel().getColumn(3).setPreferredWidth(50);
            tb_nhacungcap.getColumnModel().getColumn(4).setPreferredWidth(50);
        }

        jPanel4.add(jScrollPane1, java.awt.BorderLayout.CENTER);

        add(jPanel4, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    private void tb_nhacungcapMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tb_nhacungcapMouseClicked
        // TODO add your handling code here:
        int index = tb_nhacungcap.getSelectedRow();
        TableModel model = tb_nhacungcap.getModel();
        macty = model.getValueAt(index, 0).toString();
        tencty = model.getValueAt(index, 1).toString();
        diachi = model.getValueAt(index, 2).toString();
        email = model.getValueAt(index, 3).toString();
        sdt = model.getValueAt(index, 4).toString();
        txtmacty.setText(macty);
        txttencty.setText(tencty);
        txtsdt.setText(sdt);
        txtemail.setText(email);
        txtdiachi.setText(diachi);
    }//GEN-LAST:event_tb_nhacungcapMouseClicked

    private void txtmactyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtmactyActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtmactyActionPerformed

    private void bt_themActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_themActionPerformed
        // TODO add your handling code here:
        ktThem = true;
        macu = "";
        KhoaMo(true);
        txtmacty.requestFocus();
    }//GEN-LAST:event_bt_themActionPerformed

    private void bt_suaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_suaActionPerformed
        // TODO add your handling code here:
        if (txtmacty.getText().length() <= 0) {
            return;
        }
        macu = txtmacty.getText();
        ktThem = false;
        KhoaMo(true);
        txtmacty.requestFocus();
    }//GEN-LAST:event_bt_suaActionPerformed

    private void bt_xoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_xoaActionPerformed
        // TODO add your handling code here:
        if (txtmacty.getText().length() <= 0) {
            JOptionPane.showConfirmDialog(this, "Hãy nhập thông tin cần xoá!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
            return;
        }
        macu = txtmacty.getText();
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getMact().equals(macu)) {
                int kq = JOptionPane.showConfirmDialog(this, "Bạn có muốn xóa khumg?", "Thông Báo", JOptionPane.YES_NO_OPTION);
                if (kq == JOptionPane.YES_OPTION) {
                    QuanLyController.XoaNhaCungCap(macu);
                    LoadDataArrayListToTable();
                } else {
                    JOptionPane.showConfirmDialog(this, "Không tìm thấy kết quả!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
                    txtmacty.requestFocus();
                }
            }
        }
    }//GEN-LAST:event_bt_xoaActionPerformed

    private void bt_ghiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_ghiActionPerformed
        // TODO add your handling code here:
        if (txtmacty.getText().length() <= 0) {
            JOptionPane.showMessageDialog(this, "Bạn chưa nhập mã công ty", "Thông Báo", JOptionPane.ERROR_MESSAGE);
            txtmacty.requestFocus();
            return;
        }
        if (QuanLyKhachSanController.KiemTraTrungMa("nhacungcap", "MaCongTy", txtmacty.getText(), ktThem, macu) == true) {
            JOptionPane.showMessageDialog(this, "Mã công ty đã tồn tại", "Thông Báo", JOptionPane.ERROR_MESSAGE);
            txtmacty.requestFocus();
            return;
        }
        macty = txtmacty.getText();
        tencty = txttencty.getText();
        sdt = txtsdt.getText();
        email = txtemail.getText();
        diachi = txtdiachi.getText();
        tbl_Nhaphanphoi ncc = new tbl_Nhaphanphoi(macty, tencty, diachi, email, sdt);
        if (ktThem == true) {
            QuanLyController.ThemNhaCungCap(ncc);
            JOptionPane.showMessageDialog(this, "Thêm mới thành công");
        } else {
            QuanLyController.CapNhapNhaCungCap(ncc, macu);
            JOptionPane.showMessageDialog(this, "Cập nhập thành công");
        }
        LoadDataArrayListToTable();
        KhoaMo(false);
    }//GEN-LAST:event_bt_ghiActionPerformed

    private void bt_khongActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_khongActionPerformed
        // TODO add your handling code here:
        XoaTrang();
        KhoaMo(false);
    }//GEN-LAST:event_bt_khongActionPerformed

    private void jLabel8MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel8MouseClicked
        timkiem = txt_timkiem.getText();
        tcot=(String)cb_nhaphanphoi.getSelectedItem();
        LoadDataArrayListToTable();
    }//GEN-LAST:event_jLabel8MouseClicked

    private void btn_b2_refreshdvMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_b2_refreshdvMouseClicked
        timkiem = "";
        tcot=(String)cb_nhaphanphoi.getSelectedItem();
        LoadDataArrayListToTable();
    }//GEN-LAST:event_btn_b2_refreshdvMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bt_ghi;
    private javax.swing.JButton bt_khong;
    private javax.swing.JButton bt_sua;
    private javax.swing.JButton bt_them;
    private javax.swing.JButton bt_xoa;
    private javax.swing.JLabel btn_b2_refreshdv;
    private javax.swing.JComboBox<String> cb_nhaphanphoi;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lb1;
    private javax.swing.JLabel lb2;
    private javax.swing.JLabel lb7;
    private javax.swing.JTable tb_nhacungcap;
    private javax.swing.JTextField txt_timkiem;
    private javax.swing.JTextField txtdiachi;
    private javax.swing.JTextField txtemail;
    private javax.swing.JTextField txtmacty;
    private javax.swing.JTextField txtsdt;
    private javax.swing.JTextField txttencty;
    // End of variables declaration//GEN-END:variables
}
