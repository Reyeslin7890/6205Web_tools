
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

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
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/moviedb", "root", "7890");
            Statement stm = conn.createStatement();
            String sql = "select * from movies where actor like '%rey%'";
            ResultSet rs = stm.executeQuery(sql);
            ArrayList<String[]> result = new ArrayList<>();
            while (rs.next()) {
                String[] temp = new String[5];
                temp[0] = rs.getString(1);
                temp[1] = rs.getString(2);
                temp[2] = rs.getString(3);
                temp[3] = rs.getString(4);
                temp[4] = rs.getString(5);
                result.add(temp);                
            }
            for (String[] k:result){System.out.println(k[0]+k[1]+k[2]+k[3]+k[4]);}
            rs.close();
            stm.close();
            conn.close();
        } catch (SQLException e) {
            System.err.println("SQLException" + e.getMessage());
        } catch (ClassNotFoundException e) {
            System.err.println("ClassNotFoundException" + e.getMessage());
        }
    }
}
