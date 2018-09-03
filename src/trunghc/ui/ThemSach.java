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

        //Tiêu đề
        JPanel pnSach = new JPanel();
        JLabel lblSach = new JLabel("Thêm sách");
        lblSach.setForeground(Color.BLUE);
        Font ft = new Font("segeo ui", Font.BOLD, 20);
        lblSach.setFont(ft);
        pnSach.add(lblSach);
        pnChiTiet.add(pnSach);

        //Dòng mã sách
        JPanel pnMaSach= new JPanel();
        JLabel lblMaSach = new JLabel("Mã sách:");
        txtMaSach = new JTextField(25);
        pnMaSach.add(lblMaSach);
        pnMaSach.add(txtMaSach);
        pnChiTiet.add(pnMaSach);

        //Dòng tên sách
        JPanel pnTenSach= new JPanel();
        JLabel lblTenSach = new JLabel("Tên sách:");
        txtTenSach = new JTextField(25);
        pnTenSach.add(lblTenSach);
        pnTenSach.add(txtTenSach);
        pnChiTiet.add(pnTenSach);

        //Dòng số trang
        JPanel pnSoTrang= new JPanel();
        JLabel lblSoTrang = new JLabel("Trang:");
        txtSoTrang = new JTextField(25);
        pnSoTrang.add(lblSoTrang);
        pnSoTrang.add(txtSoTrang);
        pnChiTiet.add(pnSoTrang);

        //Dòng mã nhà xuất bản
        JPanel pnMaNXB = new JPanel();
        JLabel lblMaNXB = new JLabel("Mã NXB:");
        txtMaNxb = new JTextField(25);
        pnMaNXB.add(lblMaNXB);
        pnMaNXB.add(txtMaNxb);
        pnChiTiet.add(pnMaNXB);

        //2 nút thực hiện
        JPanel pnBtn = new JPanel();
        btnLuu = new JButton("Lưu");
        btnHuy = new JButton("Huỷ");
        pnBtn.add(btnLuu);
        pnBtn.add(btnHuy);
        pnChiTiet.add(pnBtn);
        pnCenter.add(pnChiTiet);

        //Chỉnh kích thước ô nhập bằng nhau
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
