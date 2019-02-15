import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

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
            Class.forName("org.relique.jdbc.csv.CsvDriver");
            Connection conn = DriverManager.getConnection("jdbc:relique:csv:d:/");
            Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet results = stmt.executeQuery("SELECT * FROM SalesOrder");

            // dump out the last record in the result set, then the first record
            if (results.last()) {
                System.out.println("ID= " + results.getString(1)
                        + "   NAME= " + results.getString(2));
                if (results.first()) {
                    System.out.println("ID= " + results.getString(1)
                            + "   NAME= " + results.getString(2));
                }
            }
            results.close();
            stmt.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
