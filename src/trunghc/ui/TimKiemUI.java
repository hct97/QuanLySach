package trunghc.ui;

import trunghc.connect.SachService;
import trunghc.model.Sach;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Vector;

public class TimKiemUI extends JFrame {

    JTextField txtTim;
    JButton btnTim;
    DefaultTableModel dtmSach;
    JTable tblsach;
    ArrayList<Sach> dsSach = null;


    public TimKiemUI(String title){
        super(title);
        addControls();
        addEvents();
        hienThiToanBoSach();
    }

    //Hàm hiển thị toàn bộ sách
    private void hienThiToanBoSach() {
        SachService sachService = new SachService();
        dsSach = sachService.hienThiToanBoSach();

        dtmSach.setRowCount(0);
        for(Sach sach:dsSach){
            Vector<Object>vector = new Vector<Object>();
            vector.add(sach.getMaSach());
            vector.add(sach.getTenSach());
            vector.add(sach.getSoTrang());
            vector.add(sach.getMaNhaXuatBan());
            dtmSach.addRow(vector);
        }
    }

    private void addControls(){
        Container con = getContentPane();
        con.setLayout(new BorderLayout());
        JPanel pnNorth = new JPanel();
        pnNorth.setLayout(new FlowLayout(FlowLayout.LEFT));
        //Khung tìm kiếm
        JLabel lblNhap = new JLabel("Mã NXB: ");
        txtTim = new JTextField(20);
        btnTim = new JButton("Tìm kiếm");
        pnNorth.add(lblNhap);
        pnNorth.add(txtTim);
        pnNorth.add(btnTim);
        con.add(pnNorth,BorderLayout.NORTH);

        //Bảng hiển thị tất cả sách
        JPanel pnCenter = new JPanel();
        pnCenter.setLayout(new BorderLayout());
        dtmSach = new DefaultTableModel();
        dtmSach.addColumn("Mã sách");
        dtmSach.addColumn("Tên sách");
        dtmSach.addColumn("Số trang");
        dtmSach.addColumn("Nhà xuất bản");
        tblsach = new JTable(dtmSach);
        JScrollPane scTable = new JScrollPane(tblsach, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        pnCenter.add(scTable,BorderLayout.CENTER);
        con.add(pnCenter,BorderLayout.CENTER);

    }

    private void addEvents(){
        btnTim.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                xyLyTimKiem();
            }
        });
    }

    private void xyLyTimKiem() {
        SachService sachService = new SachService();
        ArrayList<Sach> dsSach = sachService.timSachTheoNhaXuatBan(txtTim.getText());
        dtmSach.setRowCount(0);
        for(Sach sach : dsSach){
            Vector<Object> vector = new Vector<Object>();
            vector.add(sach.getMaSach());
            vector.add(sach.getTenSach());
            vector.add(sach.getSoTrang());
            vector.add(sach.getMaNhaXuatBan());
            dtmSach.addRow(vector);
        }
    }


    public void showWindow(){
        this.setSize(600,600);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }
}
