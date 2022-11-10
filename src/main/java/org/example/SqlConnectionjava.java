package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class SqlConnectionjava {
    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/demo","root","792002");
            PreparedStatement ps = con.prepareStatement("insert into register values('yash','yash@gmail.com')");
            ps.executeUpdate();
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}
