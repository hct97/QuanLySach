package trunghc.test;

import trunghc.ui.QuanLySachUI;

import java.sql.SQLException;

public class TestQuanLySachUI {
    public static void main(String[] args) throws SQLException {
        QuanLySachUI ui = new QuanLySachUI("Quản lý sách");
        ui.showWindow();
    }
}
