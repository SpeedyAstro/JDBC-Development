package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class InsertValues {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter name : ");
        String name1=sc.next();

        System.out.println("Enter email id : ");
        String email=sc.next();

        System.out.println("Enter phone no : ");
        String phone_no=sc.next();

        System.out.println("Enter age : ");
        String age=sc.next();

        System.out.println("Enter password");
        String password=sc.next();
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/demo","root","792002");

            PreparedStatement ps=con.prepareStatement("insert into register values(?,?,?,?,?)");
            ps.setString(1, name1);
            ps.setString(2, email);
            ps.setString(3, phone_no);
            ps.setString(4, age);
            ps.setString(5, password);
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
