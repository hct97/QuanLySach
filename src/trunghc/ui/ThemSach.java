package trunghc.ui;

import trunghc.connect.SachService;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class ThemSachUI extends JFrame {

    JTextField txtMaSach,txtTenSach,txtSoTrang,txtMaNxb;
    JButton btnLuu,btnHuy;

    public ThemSachUI(String title){
        super(title);
        addControls();
        addEvents();
    }

    private void addControls(){
        Container con = getContentPane();
        con.setLayout(new BorderLayout());
        JPanel pnCenter = new JPanel();
        con.add(pnCenter, BorderLayout.CENTER);
        JPanel pnChiTiet = new JPanel();
        pnChiTiet.setLayout(new BoxLayout(pnChiTiet,BoxLayout.Y_AXIS));

        JPanel pnSach = new JPanel();
        JLabel lblSach = new JLabel("Thêm sách");
        lblSach.setForeground(Color.BLUE);
        Font ft = new Font("segeo ui", Font.BOLD, 20);
        lblSach.setFont(ft);
        pnSach.add(lblSach);
        pnChiTiet.add(pnSach);

        JPanel pnMaSach= new JPanel();
        JLabel lblMaSach = new JLabel("Mã sách:");
        txtMaSach = new JTextField(25);
        pnMaSach.add(lblMaSach);
        pnMaSach.add(txtMaSach);
        pnChiTiet.add(pnMaSach);

        JPanel pnTenSach= new JPanel();
        JLabel lblTenSach = new JLabel("Tên sách:");
        txtTenSach = new JTextField(25);
        pnTenSach.add(lblTenSach);
        pnTenSach.add(txtTenSach);
        pnChiTiet.add(pnTenSach);

        JPanel pnSoTrang= new JPanel();
        JLabel lblSoTrang = new JLabel("Trang:");
        txtSoTrang = new JTextField(25);
        pnSoTrang.add(lblSoTrang);
        pnSoTrang.add(txtSoTrang);
        pnChiTiet.add(pnSoTrang);

        JPanel pnMaNXB = new JPanel();
        JLabel lblMaNXB = new JLabel("Mã NXB:");
        txtMaNxb = new JTextField(25);
        pnMaNXB.add(lblMaNXB);
        pnMaNXB.add(txtMaNxb);
        pnChiTiet.add(pnMaNXB);

        JPanel pnBtn = new JPanel();
        btnLuu = new JButton("Lưu");
        btnHuy = new JButton("Huỷ");
        pnBtn.add(btnLuu);
        pnBtn.add(btnHuy);
        pnChiTiet.add(pnBtn);
        pnCenter.add(pnChiTiet);

        lblMaNXB.setPreferredSize(lblMaSach.getPreferredSize());
        lblTenSach.setPreferredSize(lblMaSach.getPreferredSize());
        lblSoTrang.setPreferredSize(lblMaSach.getPreferredSize());
    }

    private void addEvents(){
        btnLuu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SachService s = new SachService();
                s.themSach(txtMaSach.getText(),txtTenSach.getText(),txtSoTrang.getText(),txtMaNxb.getText());
            }
        });
        btnHuy.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
    }

    public void showWindow(){
        this.setSize(600,300);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }
}
