/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sang2k.doan_tcp.MainAdmin;

import com.sang2k.doan_tcp.Check.MessageHelper;
import com.sang2k.doan_tcp.dao.MaHoaDes;
import com.sang2k.doan_tcp.dao.SinhvienDao;
import com.sang2k.doan_tcp.entity.DataSQL;
import com.sang2k.doan_tcp.entity.SinhVien;
import java.awt.BorderLayout;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import com.sang2k.doan_tcp.dao.MaHoaDes;

/**
 *
 * @author Yahiko
 */
public class QL_SinhVien extends javax.swing.JPanel {
    String user,pass,port;
    private MainFrame parentform;
    private DefaultTableModel tblTableModell;
    DataSQL datasql=new DataSQL();
    /**
     * Creates new form QL_SinhVien
     */
    public QL_SinhVien() {
        initComponents();
    }
    
    public QL_SinhVien(DataSQL dt) {
        initComponents();
        datasql.setUsername(dt.getUsername());
        datasql.setPassword(dt.getPassword());
        datasql.setPort(dt.getPort());
        initTable();
        LoadDataTable();
    }
    public void initTable(){
        tblTableModell = new DefaultTableModel();
        JScrollPane pane=new JScrollPane();
        tbl_SV.add(pane,BorderLayout.CENTER);
        tblTableModell.setColumnIdentifiers(new String[]{"Mã Sinh Viên","Họ Và Tên","Giới Tính","SĐT","Email"});
        tbl_SV.setModel(tblTableModell);
        tbl_SV.getTableHeader().setFont(new java.awt.Font("Times New Roman", 3, 14));
        DefaultTableCellRenderer rightRenderer = new DefaultTableCellRenderer();
        rightRenderer.setHorizontalAlignment(SwingConstants.LEFT);
        tbl_SV.setDefaultRenderer(Object.class,rightRenderer);
    }
    private void LoadDataTable(){
        try {
           SinhvienDao sinhvien=new SinhvienDao();
           List <SinhVien> list=sinhvien.FindAllSV(datasql);
           tblTableModell.setRowCount(0);
           String gioitinh;
           for(SinhVien sb :list){
               String Masv=MaHoaDes.Decrypt(sb.getMaSV(),"123");
               String Email=MaHoaDes.Decrypt(sb.getEmail(),"123");
               String sd=MaHoaDes.Decrypt(sb.getSDT(),"123");
               if (sb.getGioiTinh()==1) {
                   gioitinh="Nam";
               }
               else 
                   gioitinh="Nữ";
               tblTableModell.addRow(new Object[]{
                   Masv,sb.getHoTen(),gioitinh,sd,Email});
           }
           tblTableModell.fireTableDataChanged();
        } catch (Exception e) {
        }
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        rdb_male = new javax.swing.ButtonGroup();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_SV = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        txt_masv = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txt_hoten = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txt_sdt = new javax.swing.JTextField();
        txt_email = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        btn_new = new javax.swing.JButton();
        btn_them = new javax.swing.JButton();
        btn_xoa = new javax.swing.JButton();
        btn_sua = new javax.swing.JButton();
        male = new javax.swing.JRadioButton();
        female = new javax.swing.JRadioButton();

        tbl_SV.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null}
            },
            new String [] {
                "Title 1", "Title 2"
            }
        ));
        tbl_SV.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_SVMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbl_SV);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/Account/id-card.png"))); // NOI18N
        jLabel1.setText("Mã SV");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/Account/edit-user.png"))); // NOI18N
        jLabel2.setText("Họ Tên");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/Account/male-female.png"))); // NOI18N
        jLabel3.setText("Giới Tính");

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/Account/phone.png"))); // NOI18N
        jLabel4.setText("SĐT");

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/Account/gmail.png"))); // NOI18N
        jLabel5.setText("Email");

        btn_new.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        btn_new.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/Account/new.png"))); // NOI18N
        btn_new.setText("Tạo Mới");
        btn_new.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_newActionPerformed(evt);
            }
        });

        btn_them.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        btn_them.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/Account/add.png"))); // NOI18N
        btn_them.setText("Thêm");
        btn_them.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_themActionPerformed(evt);
            }
        });

        btn_xoa.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        btn_xoa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/Account/delete.png"))); // NOI18N
        btn_xoa.setText("Xóa");
        btn_xoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_xoaActionPerformed(evt);
            }
        });

        btn_sua.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        btn_sua.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/Account/edit.png"))); // NOI18N
        btn_sua.setText("Cập Nhật");
        btn_sua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_suaActionPerformed(evt);
            }
        });

        rdb_male.add(male);
        male.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        male.setText("Nam");

        rdb_male.add(female);
        female.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        female.setText("Nữ");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(94, 94, 94)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btn_xoa, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btn_new))
                        .addGap(61, 61, 61)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btn_sua, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btn_them, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(55, 55, 55)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addGap(96, 96, 96)
                                .addComponent(txt_sdt))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addGap(91, 91, 91)
                                .addComponent(txt_email))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel3)
                                        .addGap(92, 92, 92)
                                        .addComponent(male)
                                        .addGap(29, 29, 29)
                                        .addComponent(female, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addGap(7, 7, 7)
                                                .addComponent(jLabel1))
                                            .addComponent(jLabel2))
                                        .addGap(78, 78, 78)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(txt_masv, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txt_hoten, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addGap(0, 45, Short.MAX_VALUE)))))
                .addGap(92, 92, 92)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 803, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(60, 60, 60))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(65, 65, 65)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(txt_masv, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(41, 41, 41)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txt_hoten, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addGap(31, 31, 31)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(male)
                            .addComponent(female)
                            .addComponent(jLabel3))
                        .addGap(29, 29, 29)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txt_sdt, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))
                        .addGap(39, 39, 39)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel5)
                            .addComponent(txt_email, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(62, 62, 62)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btn_them)
                            .addComponent(btn_new))
                        .addGap(66, 66, 66)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btn_sua)
                            .addComponent(btn_xoa)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(56, 56, 56)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 615, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(98, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btn_newActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_newActionPerformed
        txt_masv.setText("");
        txt_hoten.setText("");
        male.setSelected(true);
        txt_sdt.setText("");
        txt_email.setText("");
    }//GEN-LAST:event_btn_newActionPerformed

    private void btn_themActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_themActionPerformed

            SinhVien SV=new SinhVien();
            SV.setHoTen(txt_hoten.getText());
            SV.setMaSV(txt_masv.getText());
            SV.setGioiTinh(male.isSelected()?1 :0);
            SV.setSDT(txt_sdt.getText());
            SV.setEmail(txt_email.getText());
            
            try {
                Socket client = new Socket("localhost" ,9999) ;
                DataInputStream DT=new DataInputStream(client.getInputStream());
                DataOutputStream OT=new DataOutputStream(client.getOutputStream());
                ObjectOutputStream OOS = new ObjectOutputStream(client.getOutputStream()) ;
                ObjectInputStream  IS = new ObjectInputStream(client.getInputStream()) ;
                    OT.writeInt(1);
                    OOS.writeObject(SV);
                    OOS.writeObject(datasql);
                    boolean check=DT.readBoolean();
                    if (check==true) {
                        MessageHelper.showMesage(parentform,"Thêm thành công","Thông Báo");
                        LoadDataTable();
                        client.close();
                    }
                    else MessageHelper.showMesage(parentform,"Sinh Viên Này Đã Tồn Tại","Thông Báo"); 
                } 
                
            catch (IOException ex) {
            ex.printStackTrace();
        }
    }//GEN-LAST:event_btn_themActionPerformed

    private void btn_xoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_xoaActionPerformed
        SinhVien SV=new SinhVien();
            SV.setHoTen(txt_hoten.getText());
            SV.setMaSV(txt_masv.getText());
            SV.setGioiTinh(male.isSelected()?1 :0);
            SV.setSDT(txt_sdt.getText());
            SV.setEmail(txt_email.getText());
            
            try {
                Socket client = new Socket("localhost" ,9999) ;
                DataInputStream DT=new DataInputStream(client.getInputStream());
                DataOutputStream OT=new DataOutputStream(client.getOutputStream());
                ObjectOutputStream OOS = new ObjectOutputStream(client.getOutputStream()) ;
                ObjectInputStream  IS = new ObjectInputStream(client.getInputStream()) ;
                    OT.writeInt(3);
                    OOS.writeObject(SV);
                    OOS.writeObject(datasql);
                    boolean check=DT.readBoolean();
                    if (check==true) {
                        MessageHelper.showMesage(parentform,"Xóa thành công","Thông Báo");
                        LoadDataTable();
                        client.close();
                    }
                    else MessageHelper.showMesage(parentform,"Không Xóa Được\n"+"Vui Lòng Xóa Điểm Của Sinh Viên Trước","Thông Báo"); 
                } 
                
            catch (IOException ex) {
            ex.printStackTrace();
        }
    }//GEN-LAST:event_btn_xoaActionPerformed

    private void btn_suaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_suaActionPerformed
            SinhVien SV=new SinhVien();
            SV.setHoTen(txt_hoten.getText());
            SV.setMaSV(txt_masv.getText());
            SV.setGioiTinh(male.isSelected()?1 :0);
            SV.setSDT(txt_sdt.getText());
            SV.setEmail(txt_email.getText());
            
            try {
                Socket client = new Socket("localhost" ,9999) ;
                DataInputStream DT=new DataInputStream(client.getInputStream());
                DataOutputStream OT=new DataOutputStream(client.getOutputStream());
                ObjectOutputStream OOS = new ObjectOutputStream(client.getOutputStream()) ;
                ObjectInputStream  IS = new ObjectInputStream(client.getInputStream()) ;
                    OT.writeInt(2);
                    Thread.sleep(15);
                    OOS.writeObject(SV);
                    Thread.sleep(15);
                    OOS.writeObject(datasql);
                    boolean check=DT.readBoolean();
                    if (check==true) {
                        MessageHelper.showMesage(parentform,"Cập Nhật Thành Công","Thông Báo");
                        LoadDataTable();
                        client.close();
                    }
                        else MessageHelper.showMesage(parentform,"Không Cập Nhật Được\n"+"Vui Lòng Kiểm Tra Lại","Thông Báo");    
                } 
            catch (Exception e) {
             e.printStackTrace();
        }
    }//GEN-LAST:event_btn_suaActionPerformed

    private void tbl_SVMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_SVMouseClicked
        try {
            int row=tbl_SV.getSelectedRow();
            if (row>=0) 
            {
                String id=(String) tblTableModell.getValueAt(row,0);
                SinhvienDao sb=new SinhvienDao();
                SinhVien SV1=sb.FindSV(MaHoaDes.Encrypt(id, id),datasql);
                if (SV1!=null) {
                    txt_masv.setText(MaHoaDes.Decrypt(SV1.getMaSV(), id));
                    txt_hoten.setText(SV1.getHoTen());
                    txt_sdt.setText(MaHoaDes.Decrypt(SV1.getSDT(), id));
                    male.setSelected(SV1.getGioiTinh()==1? Boolean.TRUE:Boolean.FALSE);
                    female.setSelected(SV1.getGioiTinh()==0? Boolean.TRUE:Boolean.FALSE);
                    txt_email.setText(MaHoaDes.Decrypt(SV1.getEmail(), id));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            MessageHelper.ErrorMesage(parentform,"Lỗi","Lỗi");
        }
    }//GEN-LAST:event_tbl_SVMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_new;
    private javax.swing.JButton btn_sua;
    private javax.swing.JButton btn_them;
    private javax.swing.JButton btn_xoa;
    private javax.swing.JRadioButton female;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JRadioButton male;
    private javax.swing.ButtonGroup rdb_male;
    private javax.swing.JTable tbl_SV;
    private javax.swing.JTextField txt_email;
    private javax.swing.JTextField txt_hoten;
    private javax.swing.JTextField txt_masv;
    private javax.swing.JTextField txt_sdt;
    // End of variables declaration//GEN-END:variables
}
