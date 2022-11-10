package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class UserInputLogin {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("ENTER EMAIL ID : ");
        String user_email = sc.next();
        System.out.println("Enter password :");
        String user_pass = sc.next();
        Connection connection = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/demo","root","792002"); // database connectivity
            ps = connection.prepareStatement("select * from register where email=? and password=?");
            ps.setString(1,user_email);
            ps.setString(2,user_pass);

            rs = ps.executeQuery();
            if(rs.next()){
                System.out.println("Login Successfully");
            }else{
                System.out.println("Invalid email or password");
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
        finally {
            try {
                connection.close();
                ps.close();
                rs.close();
            }
            catch (Exception e){
                e.printStackTrace();
            }
        }
    }
}
