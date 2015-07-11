/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pack1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 *
 * @author Kushagr Jolly
 */
@WebService(serviceName = "grid")
public class grid {

    @WebMethod(operationName = "gridtable")
    public ArrayList gridtable() {
        ArrayList<String> array= new ArrayList<>();
        try {
            Connection con;
            System.out.println("connecting");
            Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
            System.out.println("connected");
            con = DriverManager.getConnection("jdbc:odbc:grid");
            System.out.println(" driver loaded in connection.jsp");
            Statement stmt = con.createStatement();
             ResultSet rs=null;
            String all = "select * from product";
            System.out.println("Query"+all);
            rs = stmt.executeQuery(all);
            while (rs.next()) {
                array.add(rs.getString("product_id"));
                array.add(rs.getString("product_name"));
                array.add(rs.getString("price"));
                array.add(rs.getString("quantity"));
                array.add(rs.getString("image_path"));
            }
        } catch (Exception ex) {
            Logger.getLogger(grid.class.getName()).log(Level.SEVERE, null, ex);
        }
        return array;
    }
}
