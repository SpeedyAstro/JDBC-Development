package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class UpdateValues {
    public static void main(String[] args) {
        Scanner s=new Scanner(System.in);

        System.out.println("Enter email id : ");
        String email1=s.next();

        System.out.println("Enter password (to be updated)");
        String pass1=s.next();

        System.out.println("Enter phone_no (to be updated)");
        String phone_no=s.next();
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/demo","root","792002");

            PreparedStatement ps=con.prepareStatement("update register set password=?, phone_no=? where email=?");
            ps.setString(1, pass1);
            ps.setString(2, phone_no);
            ps.setString(3, email1);

            int i=ps.executeUpdate();
            if(i>0)
            {
                System.out.println("Success");
            }
            else
            {
                System.out.println("Fail");
            }

            ps.close();
            con.close();
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}
