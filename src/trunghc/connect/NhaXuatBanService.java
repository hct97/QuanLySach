package trunghc.connect;

import trunghc.model.NhaXuatBan;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class NhaXuatBanService extends MySqlService {

    //Mảng lấy toàn bộ danh sách nhà xuất bản
    public ArrayList<NhaXuatBan> layToanBoNhaXuatBan(){
        ArrayList<NhaXuatBan> dsNxb = new ArrayList<NhaXuatBan>();
        try{
            Connection conn = MySqlService.getMySQLConnection();
            String sql = "select * from tblnhaxuatban";
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            ResultSet result = preparedStatement.executeQuery();
            while (result.next()){
                NhaXuatBan nxb = new NhaXuatBan();
                nxb.setMaNhaXuatBan(result.getString(1));
                nxb.setTenNhaXuatBan(result.getString(2));
                nxb.setDiaChi(result.getString(3));
                nxb.setSoDienThoai(result.getString(4));
                dsNxb.add(nxb);
            }
        }
        catch(Exception ex){
            ex.printStackTrace();
        }
        return dsNxb;
    }

    //Thêm mới nhà xuất bản vào cơ sở dữ liệu
    public void themNhaXuatBan(String maNXB,String tenNXB,String diaChi, String dienThoai){
        try{
            Connection conn = MySqlService.getMySQLConnection();
            String sql = "INSERT INTO tblnhaxuatban VALUES(?,?,?,?) ";
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setString(1,maNXB);
            preparedStatement.setString(2,tenNXB);
            preparedStatement.setString(3, diaChi);
            preparedStatement.setString(4,dienThoai);
            int x= preparedStatement.executeUpdate();
            if(x>0){
                JOptionPane.showMessageDialog(null,"Sucsses");
            }
        }
        catch (Exception ex){
            ex.printStackTrace();
        }
    }

    //Sửa thông tin nhà xuất bản trong cơ sở dữ liệu
    public void suaNhaXuatBan(String maNXB,String tenNXB,String diaChi, String dienThoai){
        try{
            Connection conn = MySqlService.getMySQLConnection();
            String sql = "update tblnhaxuatban set tennxb = ?, diachi=?, dienthoai= ? where manxb=? ";
            PreparedStatement preparedStatement = conn.prepareStatement(sql);

            preparedStatement.setString(1,tenNXB);
            preparedStatement.setString(2, diaChi);
            preparedStatement.setString(3,dienThoai);
            preparedStatement.setString(4,maNXB);

            int x= preparedStatement.executeUpdate();
            if(x>0){
                JOptionPane.showMessageDialog(null,"Sucsses");
            }
        }
        catch (Exception ex){
            ex.printStackTrace();
        }
    }

    //Xoá nhà xuất bản trong cơ sở dữ liệu
    public void xoaNhaXuatBan(String maNXB){
        try{
            Connection conn = MySqlService.getMySQLConnection();
            String sql = "delete from tblnhaxuatban where manxb=? ";
            PreparedStatement preparedStatement = conn.prepareStatement(sql);

            preparedStatement.setString(1,maNXB);

            int x= preparedStatement.executeUpdate();
            if(x>0){
                JOptionPane.showMessageDialog(null,"Sucsses");
            }
        }
        catch (Exception ex){
            ex.printStackTrace();
        }
    }

    public NhaXuatBanService() throws SQLException {
    }
}
