package trunghc.ui;

import trunghc.connect.NhaXuatBanService;
import trunghc.model.NhaXuatBan;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Vector;

public class QuanLySachUI extends JFrame {

    JTextField txtMaNxb, txtTenNxb, txtDiaChi, txtDienThoai;
    JButton btnVeTruoc,btnVeSau, btnThem, btnLuu, btnSua, btnXoa;
    JLabel lblStep;

    DefaultTableModel dtmNxb;
    JTable tblNXB;

    JButton btnTimkiem;

    ArrayList<NhaXuatBan> dsNXB = null;

    public QuanLySachUI(String title) throws SQLException {
        super(title);
        addControls();
        addEvents();
        hienThiToanBoNhaXuatBan();
    }


    //Hàm lấy toàn bộ nhà xuất bản xuất ra bảng hiển thị
    private void hienThiToanBoNhaXuatBan() throws SQLException {
        NhaXuatBanService nhaXuatBanService = new NhaXuatBanService();
        dsNXB = nhaXuatBanService.layToanBoNhaXuatBan();

        dtmNxb.setRowCount(0);
        for(NhaXuatBan nhaXuatBan:dsNXB){
            Vector<Object>vector = new Vector<Object>();
            vector.add(nhaXuatBan.getMaNhaXuatBan());
            vector.add(nhaXuatBan.getTenNhaXuatBan());
            vector.add(nhaXuatBan.getDiaChi());
            vector.add(nhaXuatBan.getSoDienThoai());
            dtmNxb.addRow(vector);
        }
    }

    private void addControls(){
        Container con = getContentPane();
        con.setLayout(new BorderLayout());
        JPanel pnNorth = new JPanel();
        JPanel pnCenter = new JPanel();
        JPanel pnSouth = new JPanel();
        pnSouth.setLayout(new BorderLayout());

        con.add(pnCenter,BorderLayout.CENTER);
        con.add(pnNorth,BorderLayout.NORTH);
        con.add(pnSouth,BorderLayout.SOUTH);

        //Khu vực chi tiết nhà xuất bản và các nút thực hiện
        pnNorth.setLayout(new BorderLayout());
        JPanel pnChiTiet = new JPanel();
        pnNorth.add(pnChiTiet,BorderLayout.CENTER);
        JPanel pnThucHien = new JPanel();
        pnNorth.add(pnThucHien,BorderLayout.EAST);

        //Khu vực hiển thị Thông tin nhà xuất bản
        pnChiTiet.setLayout(new BoxLayout(pnChiTiet,BoxLayout.Y_AXIS));
        JPanel pnNxb = new JPanel();
        JLabel lblNxb = new JLabel("Thông tin nhà xuất bản");
        lblNxb.setForeground(Color.BLUE);
        Font ft = new Font("segeo ui", Font.BOLD, 20);
        lblNxb.setFont(ft);
        pnNxb.add(lblNxb);
        pnChiTiet.add(pnNxb);

        //Dòng mã nhà xuất bản
        JPanel pnMaNxb= new JPanel();
        JLabel lblMaNxb = new JLabel("Mã NXB:");
        txtMaNxb = new JTextField(25);
        pnMaNxb.add(lblMaNxb);
        pnMaNxb.add(txtMaNxb);
        pnChiTiet.add(pnMaNxb);

        //Dòng tên nhà xuất bản
        JPanel pnTenNxb= new JPanel();
        JLabel lblTenNxb = new JLabel("Tên NXB:");
        txtTenNxb = new JTextField(25);
        pnTenNxb.add(lblTenNxb);
        pnTenNxb.add(txtTenNxb);
        pnChiTiet.add(pnTenNxb);

        //Dòng địa chỉ nhà xuất bản
        JPanel pnDiaChi= new JPanel();
        JLabel lblDiaChi = new JLabel("Địa chỉ:");
        txtDiaChi = new JTextField(25);
        pnDiaChi.add(lblDiaChi);
        pnDiaChi.add(txtDiaChi);
        pnChiTiet.add(pnDiaChi);

        //Dòng số điện thoại nhà xuất bản
        JPanel pnDienThoai = new JPanel();
        JLabel lblDienThoai = new JLabel("Điện Thoại:");
        txtDienThoai = new JTextField(25);
        pnDienThoai.add(lblDienThoai);
        pnDienThoai.add(txtDienThoai);
        pnChiTiet.add(pnDienThoai);

        //2 nút điều khiển bảng
        JPanel pnButtonChiTiet = new JPanel();
        btnVeTruoc = new JButton("Về Trước");
        btnVeSau = new JButton("Về Sau");
        lblStep = new JLabel("1/1");

        pnButtonChiTiet.add(btnVeTruoc);
        pnButtonChiTiet.add(lblStep);
        pnButtonChiTiet.add(btnVeSau);
        pnChiTiet.add(pnButtonChiTiet);

        //Nút thêm mới sách
        pnThucHien.setLayout(new BoxLayout(pnThucHien,BoxLayout.Y_AXIS));
        JPanel pnButtonThem = new JPanel();
        btnThem = new JButton("Thêm");
        pnButtonThem.add(btnThem);
        pnThucHien.add(pnButtonThem);

        //Nút lưu mới thông tin nhà xuất bản
        JPanel pnButtonLuu = new JPanel();
        btnLuu = new JButton("Lưu");
        pnButtonLuu.add(btnLuu);
        pnThucHien.add(pnButtonLuu);

        //Nút sửa thông tin nhà xuất bản
        JPanel pnButtonSua = new JPanel();
        btnSua = new JButton("Sửa");
        pnButtonSua.add(btnSua);
        pnThucHien.add(pnButtonSua);

        //Nút xoá nhà xuất bản
        JPanel pnButtonXoa = new JPanel();
        btnXoa = new JButton("Xoá");
        pnButtonXoa.add(btnXoa);
        pnThucHien.add(pnButtonXoa);

        //Bảng dữ liệu nhà xuất bản
        pnCenter.setLayout(new BorderLayout());
        dtmNxb = new DefaultTableModel();
        dtmNxb.addColumn("Mã nhà xuất bản");
        dtmNxb.addColumn("Tên nhà xuất bản");
        dtmNxb.addColumn("Địa chỉ");
        dtmNxb.addColumn("Điện thoại");
        tblNXB = new JTable(dtmNxb);
        JScrollPane scTable = new JScrollPane(tblNXB,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        pnCenter.add(scTable,BorderLayout.CENTER);

        //Nút hiển thị, tìm kiếm sách
        JPanel pnButtonOfSouth = new JPanel();
        btnTimkiem = new JButton("Sách");
        pnButtonOfSouth.add(btnTimkiem);
        pnSouth.add(pnButtonOfSouth, BorderLayout.WEST);

        //Border
        TitledBorder borderThongTinChiTiet = new TitledBorder(BorderFactory.createLineBorder(Color.BLUE),"Thông tin chi tiết");
        pnChiTiet.setBorder(borderThongTinChiTiet);

        TitledBorder borderThucHien = new TitledBorder(BorderFactory.createLineBorder(Color.BLUE),"Thực hiện");
        pnThucHien.setBorder(borderThucHien);

        lblMaNxb.setPreferredSize(lblDienThoai.getPreferredSize());
        lblTenNxb.setPreferredSize(lblDienThoai.getPreferredSize());
        lblDiaChi.setPreferredSize(lblDienThoai.getPreferredSize());

        //Set Icon cho các nút chức năng
        btnThem.setIcon(new ImageIcon("images/them.png"));
        btnLuu.setIcon(new ImageIcon("images/save.png"));
        btnSua.setIcon(new ImageIcon("images/edit.png"));
        btnXoa.setIcon(new ImageIcon("images/remove.png"));
        btnVeTruoc.setIcon(new ImageIcon("images/previous.png"));
        btnVeSau.setIcon(new ImageIcon("images/next.png"));
        btnTimkiem.setIcon(new ImageIcon("images/search.png"));

        //Border bảng
        TitledBorder borderDanhSachNXB = new TitledBorder(BorderFactory.createLineBorder(Color.BLUE),"Danh sách nhà xuất bản");
        pnCenter.setBorder(borderDanhSachNXB);

        //Phần thông tin nhà phát triển
        JPanel pnFooter = new JPanel();
        pnFooter.setLayout(new BorderLayout());
        JLabel lblFooter = new JLabel("Design By TrungHC");
        lblFooter.setForeground(Color.RED);
        pnFooter.add(lblFooter);
        pnSouth.add(pnFooter,BorderLayout.EAST);

    }

    private void addEvents(){

        btnTimkiem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //Gọi ra cửa sổ tìm kiếm sách
                TimKiemUI ui= new TimKiemUI("Tìm kiếm sách");
                ui.showWindow();
            }
        });

        btnLuu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    xuLyLuu();
                } catch (SQLException e1) {
                    JOptionPane.showMessageDialog(null,"Lỗi khi thêm mới");
                }
            }
        });
        btnSua.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    xuLySua();
                } catch (SQLException e1) {
                    JOptionPane.showMessageDialog(null,"Lỗi khi sửa");
                }
            }
        });
        btnXoa.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    xuLyXoa();
                } catch (SQLException e1) {
                    JOptionPane.showMessageDialog(null,"Lỗi khi xoá");
                }
            }
        });
        btnThem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                xuLyThem();
            }
        });

        //Sự kiện khi bấm vào 1 nhà xuất bản sẽ hiển thị thông tin nhà xuất bản đó lên trên khu vực chi tiết
        tblNXB.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                JTable source = (JTable)e.getSource();
                int row= source.rowAtPoint(e.getPoint());
                int column = source.columnAtPoint(e.getPoint());
                if(! source.isRowSelected(row))
                    source.changeSelection(row,column,false,false);
                txtMaNxb.setText((String) source.getValueAt(row,0));
                txtTenNxb.setText((String) source.getValueAt(row,1));
                txtDiaChi.setText((String) source.getValueAt(row,2));
                txtDienThoai.setText((String) source.getValueAt(row,3));
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });
    }


    private void xuLyXoa() throws SQLException {
        NhaXuatBanService s = new  NhaXuatBanService();
        s.xoaNhaXuatBan(txtMaNxb.getText());
        hienThiToanBoNhaXuatBan();
    }

    private void xuLySua() throws SQLException {
        NhaXuatBanService s = new  NhaXuatBanService();
        s.suaNhaXuatBan(txtMaNxb.getText(),txtTenNxb.getText(),txtDiaChi.getText(),txtDienThoai.getText());
        hienThiToanBoNhaXuatBan();
    }

    private void xuLyLuu() throws SQLException {
        NhaXuatBanService s = new  NhaXuatBanService();
        s.themNhaXuatBan(txtMaNxb.getText(),txtTenNxb.getText(),txtDiaChi.getText(),txtDienThoai.getText());
        hienThiToanBoNhaXuatBan();
    }

    private void xuLyThem() {
        //Hiển thị màn hình Thêm sách
        ThemSachUI ui = new ThemSachUI("New BOOK");
        ui.showWindow();
    }

    public void showWindow(){
        this.setSize(800,800);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }
}
