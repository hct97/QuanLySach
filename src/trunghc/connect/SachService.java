package trunghc.connect;

import trunghc.model.NhaXuatBan;
import trunghc.model.Sach;

import javax.swing.*;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class SachService extends MySqlService {

    //Mảng lấy toàn bộ sách
    public ArrayList<Sach> hienThiToanBoSach(){
        ArrayList<Sach> dsSach = new ArrayList<Sach>();
        try{
            Connection conn = MySqlService.getMySQLConnection();
            String sql = "select * from tblsach";
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            ResultSet result = preparedStatement.executeQuery();
            while (result.next()){
                Sach sach = new Sach();
                sach.setMaSach(result.getString(1));
                sach.setTenSach(result.getString(2));
                sach.setSoTrang(result.getInt(3));
                sach.setMaNhaXuatBan(result.getString(4));
                dsSach.add(sach);
            }
        }
        catch(Exception ex){
            ex.printStackTrace();
        }
        return dsSach;
    }

    //Mảng tìm sách theo mã nhà xuất bản
    public ArrayList<Sach> timSachTheoNhaXuatBan(String manxb){
        ArrayList<Sach> dsSach = new ArrayList<Sach>();
        try{
            Connection conn = MySqlService.getMySQLConnection();
            String sql = "select * from tblsach where manxb =?";
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setString(1,manxb);
            ResultSet result = preparedStatement.executeQuery();
            while (result.next()){
                Sach sach = new Sach();
                sach.setMaSach(result.getString(1));
                sach.setTenSach(result.getString(2));
                sach.setSoTrang(result.getInt(3));
                sach.setMaNhaXuatBan(result.getString(4));
                dsSach.add(sach);
            }
        }
        catch(Exception ex){
            ex.printStackTrace();
        }
        return dsSach;
    }

    //Thêm mới sách vào cơ sở dữ liệu
    public void themSach(String maSach, String tenSach, String soTrang, String maNXB){

        try{
            Connection conn = MySqlService.getMySQLConnection();
            String sql = "INSERT INTO tblsach VALUES(?,?,?,?) ";
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setString(1,maSach);
            preparedStatement.setString(2,tenSach);
            preparedStatement.setInt(3, Integer.parseInt(soTrang));
            preparedStatement.setString(4,maNXB);
            int x= preparedStatement.executeUpdate();
            if(x>0){
                JOptionPane.showMessageDialog(null,"Sucsses");
            }

        }
        catch(Exception ex){
            ex.printStackTrace();
        }

    }
}
