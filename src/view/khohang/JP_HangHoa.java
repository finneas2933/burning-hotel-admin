package view.khohang;

import controller.HangHoaController;
import controller.QuanLyController;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import model.tbl_HangHoa;
import model.tbl_Nhaphanphoi;
import view.quanly.JP_DauBep;

public class JP_HangHoa extends javax.swing.JPanel {

    DefaultTableModel model;
    List<tbl_HangHoa> list = new ArrayList<>();
    private static boolean ktThem;
    private static String macu, sTimHangHoa;
    private static String mahang, tenhang, macongty, loaihang, donvitinh, gianhap, giaban, tcot;
    int soluong;

    public JP_HangHoa() throws IOException, SQLException {
        initComponents();
        XoaTrang();
        KhoaMo(false);
        LoadArrayListToTable();
        LoadComBoBoxHangHoa();
        menu.add(panel);
        LoadJList();
        sTimHangHoa = "";
    }

    public void LoadArrayListToTable() {
        list = HangHoaController.LoadDataHangHoaToArrayList(sTimHangHoa, tcot);
        model = (DefaultTableModel) tbhanghoa.getModel();
        model.setRowCount(0);
        for (tbl_HangHoa hh : list) {
            model.addRow(new Object[]{hh.getMahang(), hh.getTenhang(), hh.getMacongty(), hh.getLoaihang(), hh.getSoluong(), hh.getDonvitinh(), hh.gianhap, hh.giaban});
        }
    }
    
    private DefaultComboBoxModel<String> comboBoxHangHoa;
    public void LoadComBoBoxHangHoa() throws IOException, SQLException {
        comboBoxHangHoa = new DefaultComboBoxModel<>();
        cb_hanghoa.setModel(comboBoxHangHoa);
         List<String> hanghoa = HangHoaController.NguonCBBHangHoa();
         for (String db : hanghoa) {
            comboBoxHangHoa.addElement(db);
         }
    }

    public void LoadJList() {
        DefaultListModel<String> listModel = new DefaultListModel<>();
        List<tbl_Nhaphanphoi> ncc = HangHoaController.LoadDatanccToArrayList();
        macongty = txtmact.getText().toLowerCase();
        for (tbl_Nhaphanphoi o : ncc) {
            if (o.getTenct().toLowerCase().contains(macongty.toLowerCase())) {
                listModel.addElement(o.getMact() + "-" + o.getTenct());
            }
        }
        listncc.setModel(listModel);
    }

    public void KhoaMo(boolean b) {
        txtmasp.setEditable(b);
        txttensp.setEditable(b);
        txtmact.setEditable(b);
        txtloaihang.setEditable(b);
        txtsoluong.setEditable(b);
        txtgianhap.setEditable(b);
        txtgiaban.setEditable(b);
        cbdvt.setEditable(b);
        btthem.setEnabled(!b);
        btsua.setEnabled(!b);
        btxoa.setEnabled(!b);
        btghi.setEnabled(b);
        btkhong.setEnabled(b);
     
    }

    public void refresh(boolean b) {
        txtmasp.setEditable(b);
        txttensp.setEditable(b);
        txtmact.setEditable(b);
        txtloaihang.setEditable(b);
        txtsoluong.setEditable(b);
        cbdvt.setEditable(b);
        txtgianhap.setEnabled(b);
        txtgiaban.setEnabled(b);
        btthem.setEnabled(b);
        btsua.setEnabled(b);
        btxoa.setEnabled(b);
        btghi.setEnabled(b);
        btkhong.setEnabled(b);
    }

    public void XoaTrang() {
        txtmasp.setText("");
        txttensp.setText("");
        cbdvt.setSelectedIndex(0);
        txtmact.setText("");
        txtgianhap.setText("");
        txtgiaban.setText("");
        txtsoluong.setText("");
        txtloaihang.setText("");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panel = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        listncc = new javax.swing.JList<>();
        menu = new javax.swing.JPopupMenu();
        jPanel6 = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();
        cb_hanghoa = new javax.swing.JComboBox<>();
        txt_timkiem = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        txtmasp = new javax.swing.JTextField();
        txttensp = new javax.swing.JTextField();
        txtmact = new javax.swing.JTextField();
        txtloaihang = new javax.swing.JTextField();
        txtsoluong = new javax.swing.JTextField();
        txtgianhap = new javax.swing.JTextField();
        txtgiaban = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        btthem = new javax.swing.JButton();
        btsua = new javax.swing.JButton();
        btxoa = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        btghi = new javax.swing.JButton();
        btkhong = new javax.swing.JButton();
        cbdvt = new javax.swing.JComboBox<>();
        jPanel5 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        txttimkiem = new javax.swing.JTextField();
        bttimkiem = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbhanghoa = new javax.swing.JTable();

        listncc.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                listnccMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(listncc);

        javax.swing.GroupLayout panelLayout = new javax.swing.GroupLayout(panel);
        panel.setLayout(panelLayout);
        panelLayout.setHorizontalGroup(
            panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 354, Short.MAX_VALUE)
                .addContainerGap())
        );
        panelLayout.setVerticalGroup(
            panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 317, Short.MAX_VALUE))
        );

        setBackground(new java.awt.Color(255, 255, 255));

        jPanel6.setBackground(new java.awt.Color(76, 41, 211));
        jPanel6.setMinimumSize(new java.awt.Dimension(1140, 70));
        jPanel6.setPreferredSize(new java.awt.Dimension(1140, 70));
        jPanel6.setLayout(new java.awt.BorderLayout());

        jPanel8.setBackground(new java.awt.Color(76, 41, 211));
        jPanel8.setPreferredSize(new java.awt.Dimension(300, 70));

        cb_hanghoa.setBackground(new java.awt.Color(76, 41, 211));
        cb_hanghoa.setFont(new java.awt.Font("Montserrat", 1, 10)); // NOI18N
        cb_hanghoa.setForeground(new java.awt.Color(255, 255, 255));

        txt_timkiem.setBackground(new java.awt.Color(123, 156, 225));
        txt_timkiem.setFont(new java.awt.Font("Montserrat Medium", 0, 12)); // NOI18N
        txt_timkiem.setBorder(null);
        txt_timkiem.setMinimumSize(new java.awt.Dimension(100, 15));
        txt_timkiem.setPreferredSize(new java.awt.Dimension(200, 20));

        jLabel13.setFont(new java.awt.Font("Montserrat", 0, 11)); // NOI18N
        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/search_25px.png"))); // NOI18N
        jLabel13.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel13MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(cb_hanghoa, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txt_timkiem, javax.swing.GroupLayout.DEFAULT_SIZE, 162, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel13)
                .addContainerGap())
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txt_timkiem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(cb_hanghoa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel13))
                .addGap(15, 15, 15))
        );

        jPanel6.add(jPanel8, java.awt.BorderLayout.LINE_END);

        jLabel1.setFont(new java.awt.Font("Century Schoolbook", 1, 30)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Customer management");
        jPanel6.add(jLabel1, java.awt.BorderLayout.CENTER);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel3.setFont(new java.awt.Font("Montserrat", 0, 11)); // NOI18N
        jLabel3.setText("Mã sản phẩm");

        jLabel4.setFont(new java.awt.Font("Montserrat", 0, 11)); // NOI18N
        jLabel4.setText("Mã công ty");

        jLabel5.setFont(new java.awt.Font("Montserrat", 0, 11)); // NOI18N
        jLabel5.setText("Loại Hàng");

        jLabel6.setFont(new java.awt.Font("Montserrat", 0, 11)); // NOI18N
        jLabel6.setText("Số lượng");

        jLabel7.setFont(new java.awt.Font("Montserrat", 0, 11)); // NOI18N
        jLabel7.setText("Đơn vị tính");

        jLabel8.setFont(new java.awt.Font("Montserrat", 0, 11)); // NOI18N
        jLabel8.setText("Giá Nhập");

        jLabel9.setFont(new java.awt.Font("Montserrat", 0, 11)); // NOI18N
        jLabel9.setText("Giá Bán ");

        txtmasp.setFont(new java.awt.Font("Montserrat Medium", 0, 12)); // NOI18N

        txttensp.setFont(new java.awt.Font("Montserrat Medium", 0, 12)); // NOI18N

        txtmact.setFont(new java.awt.Font("Montserrat Medium", 0, 12)); // NOI18N
        txtmact.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtmactKeyReleased(evt);
            }
        });

        txtloaihang.setFont(new java.awt.Font("Montserrat Medium", 0, 12)); // NOI18N

        txtsoluong.setFont(new java.awt.Font("Montserrat Medium", 0, 12)); // NOI18N

        txtgianhap.setFont(new java.awt.Font("Montserrat Medium", 0, 12)); // NOI18N

        txtgiaban.setFont(new java.awt.Font("Montserrat Medium", 0, 12)); // NOI18N

        jLabel10.setFont(new java.awt.Font("Montserrat", 0, 11)); // NOI18N
        jLabel10.setText("Tên sản phẩm");

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Cập nhập", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Montserrat", 0, 12))); // NOI18N

        btthem.setFont(new java.awt.Font("Montserrat Medium", 0, 12)); // NOI18N
        btthem.setText("Thêm");
        btthem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btthemActionPerformed(evt);
            }
        });

        btsua.setFont(new java.awt.Font("Montserrat Medium", 0, 12)); // NOI18N
        btsua.setText("Sửa");
        btsua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btsuaActionPerformed(evt);
            }
        });

        btxoa.setFont(new java.awt.Font("Montserrat Medium", 0, 12)); // NOI18N
        btxoa.setText("Xóa");
        btxoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btxoaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btthem)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btsua)
                .addGap(27, 27, 27)
                .addComponent(btxoa)
                .addGap(27, 27, 27))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btthem)
                    .addComponent(btsua)
                    .addComponent(btxoa))
                .addGap(0, 13, Short.MAX_VALUE))
        );

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Điều Khiển", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Montserrat", 0, 12))); // NOI18N

        btghi.setBackground(new java.awt.Color(0, 0, 255));
        btghi.setFont(new java.awt.Font("Montserrat SemiBold", 1, 13)); // NOI18N
        btghi.setForeground(new java.awt.Color(255, 255, 255));
        btghi.setText("Ghi");
        btghi.setPreferredSize(new java.awt.Dimension(130, 34));
        btghi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btghiActionPerformed(evt);
            }
        });

        btkhong.setFont(new java.awt.Font("Montserrat SemiBold", 1, 13)); // NOI18N
        btkhong.setForeground(new java.awt.Color(0, 0, 255));
        btkhong.setText("Không");
        btkhong.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 255)));
        btkhong.setPreferredSize(new java.awt.Dimension(130, 34));
        btkhong.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btkhongActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btghi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(37, 37, 37)
                .addComponent(btkhong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btghi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btkhong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        cbdvt.setFont(new java.awt.Font("Montserrat Medium", 0, 12)); // NOI18N
        cbdvt.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Chai", "Lon", "Chiếc" }));

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));
        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Tìm kiếm", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Montserrat", 0, 12))); // NOI18N

        jLabel11.setFont(new java.awt.Font("Montserrat", 0, 11)); // NOI18N
        jLabel11.setText("Nhập từ khóa cần tìm");

        txttimkiem.setFont(new java.awt.Font("Montserrat Medium", 0, 12)); // NOI18N

        bttimkiem.setFont(new java.awt.Font("Montserrat Medium", 0, 12)); // NOI18N
        bttimkiem.setText("Chọn");
        bttimkiem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bttimkiemActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(txttimkiem, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(bttimkiem)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel11)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(bttimkiem)
                    .addComponent(txttimkiem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(21, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txtgianhap, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 324, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtsoluong, javax.swing.GroupLayout.PREFERRED_SIZE, 324, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtmasp)
                        .addComponent(txttensp)
                        .addComponent(txtmact)
                        .addComponent(txtgiaban)
                        .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel7)
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(cbdvt, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtloaihang, javax.swing.GroupLayout.PREFERRED_SIZE, 324, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(27, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addGap(0, 0, 0)
                .addComponent(txtmasp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel10)
                .addGap(0, 0, 0)
                .addComponent(txttensp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4)
                .addGap(0, 0, 0)
                .addComponent(txtmact, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6)
                .addComponent(jLabel5)
                .addGap(0, 0, 0)
                .addComponent(txtloaihang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6)
                .addComponent(jLabel6)
                .addGap(0, 0, 0)
                .addComponent(txtsoluong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel7)
                .addGap(0, 0, 0)
                .addComponent(cbdvt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6)
                .addComponent(jLabel8)
                .addGap(0, 0, 0)
                .addComponent(txtgianhap, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6)
                .addComponent(jLabel9)
                .addGap(0, 0, 0)
                .addComponent(txtgiaban, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(102, 102, 102))
        );

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));

        tbhanghoa.setFont(new java.awt.Font("Montserrat", 0, 12)); // NOI18N
        tbhanghoa.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Mã sản phẩm ", "Tên sản phẩm", "Mã  công ty", "Loại Hàng", "Số lượng", "Đơn vị tính", "Giá Nhập", "Giá Bán"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbhanghoa.setRowHeight(25);
        tbhanghoa.setRowMargin(5);
        tbhanghoa.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbhanghoaMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbhanghoa);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 717, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 659, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(45, 45, 45))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void txtmactKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtmactKeyReleased
        menu.show(txtmact, 0, txtmact.getHeight());
    }//GEN-LAST:event_txtmactKeyReleased

    private void btthemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btthemActionPerformed
        ktThem = true;
        macu = "";
        KhoaMo(true);
        XoaTrang();
        txtmasp.requestFocus();

    }//GEN-LAST:event_btthemActionPerformed

    private void btsuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btsuaActionPerformed
        // TODO add your handling code here:
        if (txtmasp.getText().length() <= 0) {
            return;
        }
        macu = txtmasp.getText();
        ktThem = false;
        KhoaMo(true);
        txtmasp.requestFocus();
    }//GEN-LAST:event_btsuaActionPerformed

    private void btxoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btxoaActionPerformed
        // TODO add your handling code here:
        if (txtmasp.getText().length() <= 0) {
            JOptionPane.showConfirmDialog(this, "Hãy nhập thông tin cần xoá!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
            return;
        }
        macu = txtmasp.getText();
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getMahang().equals(macu)) {
                int kq = JOptionPane.showConfirmDialog(this, "Bạn có muốn xóa sản phẩm này không?", "Thông Báo", JOptionPane.YES_NO_OPTION);
                if (kq == JOptionPane.YES_OPTION) {
                    HangHoaController.XoaHangHoa(macu);
                    XoaTrang();
                    LoadArrayListToTable();
                } else {
                    JOptionPane.showConfirmDialog(this, "Không tìm thấy kết quả!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
                    txtmasp.requestFocus();
                }
            }
        }
    }//GEN-LAST:event_btxoaActionPerformed

    private void btghiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btghiActionPerformed
        // TODO add your handling code here:
        if (txtmasp.getText().length() <= 0) {
            JOptionPane.showMessageDialog(this, "Bạn chưa nhập mã sản phẩm.", "Thông Báo", JOptionPane.ERROR_MESSAGE);
            txtmasp.requestFocus();
            return;
        }
        if (cbdvt.getSelectedIndex() == -1) {
            JOptionPane.showMessageDialog(this, "Bạn chưa chọn loại sản phẩm .", "Thông Báo", JOptionPane.ERROR_MESSAGE);
            cbdvt.requestFocus();
            return;
        }

        if (HangHoaController.KiemTraTrungMa("mathang", "MaHang", txtmasp.getText(), ktThem, macu) == true) {
            JOptionPane.showMessageDialog(this, "Mã sản phẩm đã tồn tại ", "Thông Báo", JOptionPane.ERROR_MESSAGE);
            txtmasp.requestFocus();
            return;
        }
        if (HangHoaController.KiemTraTrungMa("nhacungcap", "MaCongTy", txtmact.getText(), ktThem, macu) == false) {
            JOptionPane.showMessageDialog(this, "Mã Công Ty không tồn tại", "Thông Báo", JOptionPane.ERROR_MESSAGE);
            txtmasp.requestFocus();
            return;
        }
        mahang = txtmasp.getText();
        tenhang = txttensp.getText();
        macongty = txtmact.getText();
        loaihang = txtloaihang.getText();
        soluong = Integer.parseInt(txtsoluong.getText());
        donvitinh = (String) cbdvt.getSelectedItem();
        gianhap = txtgianhap.getText();
        giaban = txtgiaban.getText();
        int giaban1 = Integer.parseInt(giaban);
        int gianhap2 = Integer.parseInt(gianhap);
         if(giaban1 < gianhap2){
             JOptionPane.showMessageDialog(this, "Giá Bán nhỏ hơn Giá nhập  ", "Thông Báo", JOptionPane.ERROR_MESSAGE);
             return ;
        }
        tbl_HangHoa hh = new tbl_HangHoa(mahang, tenhang, macongty, loaihang, String.valueOf(soluong), donvitinh, gianhap, giaban);
        if (ktThem == true) {
            HangHoaController.ThemHangHoa(hh);
            JOptionPane.showMessageDialog(this, "Thêm mới thành công");
        } else {
            HangHoaController.CapNhapHangHoa(hh, macu);
            JOptionPane.showMessageDialog(this, "Cập nhập thành công");
        }
        LoadArrayListToTable();
        KhoaMo(false);
    }//GEN-LAST:event_btghiActionPerformed

    private void btkhongActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btkhongActionPerformed
        // TODO add your handling code here:
        XoaTrang();
        KhoaMo(false);
    }//GEN-LAST:event_btkhongActionPerformed

    private void bttimkiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bttimkiemActionPerformed
        // TODO add your handling code here:
        sTimHangHoa = txttimkiem.getText();
        LoadArrayListToTable();
    }//GEN-LAST:event_bttimkiemActionPerformed

    private void tbhanghoaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbhanghoaMouseClicked
        // TODO add your handling code here:
        int index = tbhanghoa.getSelectedRow();
        TableModel model = tbhanghoa.getModel();
        mahang = model.getValueAt(index, 0).toString();
        tenhang = model.getValueAt(index, 1).toString();
        macongty = model.getValueAt(index, 2).toString();
        loaihang = model.getValueAt(index, 3).toString();
        soluong = Integer.parseInt(model.getValueAt(index, 4).toString());
        donvitinh = model.getValueAt(index, 5).toString();
        gianhap = model.getValueAt(index, 6).toString();
        giaban = model.getValueAt(index, 7).toString();

        txtmasp.setText(mahang);
        txttensp.setText(tenhang);
        txtmact.setText(macongty);
        txtloaihang.setText(loaihang);
        txtsoluong.setText(String.valueOf(soluong));
        cbdvt.setSelectedItem(donvitinh);
        txtgianhap.setText(gianhap);
        txtgiaban.setText(giaban);
    }//GEN-LAST:event_tbhanghoaMouseClicked

    private void listnccMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_listnccMouseClicked
        int selectedIndex = listncc.getSelectedIndex();//llaasy vị trí
        String selectedValue = listncc.getSelectedValue();//lấy giá trị
        String[] values = selectedValue.split("-");//chia chuỗi
        String mact = values[0];
        txtmact.setText(mact);
    }//GEN-LAST:event_listnccMouseClicked

    private void jLabel13MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel13MouseClicked
        sTimHangHoa = txt_timkiem.getText();
        tcot=(String)cb_hanghoa.getSelectedItem();
        LoadArrayListToTable();
    }//GEN-LAST:event_jLabel13MouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btghi;
    private javax.swing.JButton btkhong;
    private javax.swing.JButton btsua;
    private javax.swing.JButton btthem;
    private javax.swing.JButton bttimkiem;
    private javax.swing.JButton btxoa;
    private javax.swing.JComboBox<String> cb_hanghoa;
    private javax.swing.JComboBox<String> cbdvt;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JList<String> listncc;
    private javax.swing.JPopupMenu menu;
    private javax.swing.JPanel panel;
    private javax.swing.JTable tbhanghoa;
    private javax.swing.JTextField txt_timkiem;
    private javax.swing.JTextField txtgiaban;
    private javax.swing.JTextField txtgianhap;
    private javax.swing.JTextField txtloaihang;
    private javax.swing.JTextField txtmact;
    private javax.swing.JTextField txtmasp;
    private javax.swing.JTextField txtsoluong;
    private javax.swing.JTextField txttensp;
    private javax.swing.JTextField txttimkiem;
    // End of variables declaration//GEN-END:variables
}
