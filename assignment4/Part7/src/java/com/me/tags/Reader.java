/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.me.tags;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.servlet.http.HttpSession;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.JspFragment;
import javax.servlet.jsp.tagext.SimpleTagSupport;

/**
 *
 * @author Reyes
 */
public class Reader extends SimpleTagSupport {

    private String filename;

    /**
     * Called by the container to invoke this tag. The implementation of this
     * method is provided by the tag library developer, and handles all tag
     * processing, body iteration, etc.
     */
    @Override
    public void doTag() throws JspException {
        JspWriter out = getJspContext().getOut();
        

        try {
            ArrayList<String[]> rs = new ArrayList<>();
            try {
                Class.forName("org.relique.jdbc.csv.CsvDriver");
                Connection conn = DriverManager.getConnection("jdbc:relique:csv:d:/");
                Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
                ResultSet results = stmt.executeQuery("SELECT * FROM " + filename);
                int count = 0;
                while (results.next()) {
                    String[] row = new String[25];
                    for (int i = 0; i < 25; i++) {
                        row[i] = results.getString(i + 1);
                    }
                    rs.add(row);
                }
                
                getJspContext().setAttribute("rs", rs, PageContext.SESSION_SCOPE);
                
                results.close();
                stmt.close();
                conn.close();
            } catch (SQLException e) {
                System.err.println("SQLException" + e.getMessage());
            } catch (ClassNotFoundException e) {
                System.err.println("ClassNotFoundException" + e.getMessage());
            }
            
            // TODO: insert code to write html before writing the body content.
            // e.g.:
            //
            // out.println("<strong>" + attribute_1 + "</strong>");
            // out.println("    <blockquote>");

            JspFragment f = getJspBody();
            if (f != null) {
                f.invoke(out);
            }
            // TODO: insert code to write html after writing the body content.
            // e.g.:
            //
            // out.println("    </blockquote>");

            out.println("<form action='part7.htm?action=add' method='post'>");

            out.println("<input type='submit' value='Submit to MySQL Database'/>");
            out.println("<table border='1' width='100%'>");
            int rowcount = 0;
            for (String[] row : rs) {
                rowcount++;
                if (rowcount <= 100) {
                    out.println("<tr>");
                    int count = 0;
                    for (String str : row) {
                        out.println("<td>");
                        count++;
                        out.println("<input type='text' name='r" + rowcount + "t" + count + "' value='" + str + "'/>");
                        out.println("</td>");
                    }
                    out.println("</tr>");
                } else {
//                    int count = 0;
//                    for (String str : row) {
//                        count++;
//                        out.println("<input type='hidden' name='r" + rowcount + "t" + count + "'value='" + str + "'/>");
//                    }
                }
            }
            out.println("</table>");
            out.println("<input type='hidden' name='rowcount' value='" + rowcount + "'/>");
            out.println("</form>");
        } catch (java.io.IOException ex) {
            throw new JspException("Error in myTag tag", ex);
        }
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

}
