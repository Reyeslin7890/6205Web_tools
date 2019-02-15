
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Reyes
 */
public class test {
    public static void main(String[] args) {
        int q = 3;
        Connection conn = null;
        ResultSet rs = null;
        PreparedStatement stm = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost/booksdb", "root", "7890");
            String query = "insert into book value (?,?,?,?);";
            stm = conn.prepareStatement(query);
            for (int i = 0; i < q; i++) {
                for (int j = 1; j <= 3; j++) {
                    String txt = "txt"+i+j;
                    stm.setString(j, txt);
                }
                String txt = "33.33";
                stm.setFloat(4, Float.parseFloat(txt));
                stm.execute();
            }
        } catch (SQLException e) {
            System.err.println("SQLException" + e.getMessage());
        } catch (ClassNotFoundException e) {
            System.err.println("ClassNotFoundException" + e.getMessage());
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (stm != null) {
                    stm.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException e) {
                System.err.println("Finally SQLException" + e.getMessage());
            }
        }
    }
}
