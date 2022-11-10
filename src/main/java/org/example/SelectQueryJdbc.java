package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class SelectQueryJdbc{
    public static void main(String[] args) {
        String user_email = "pandeyanubhav888@gmail.com";
        String user_name = "anubhav";
        try {
            Class.forName("com.mysql.cj.jdbc.Driver"); // loading driver class
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/demo","root","792002");
//            PreparedStatement ps = con.prepareStatement("select * from register"); //
            PreparedStatement ps = con.prepareStatement("select * from register where email='"+user_email+"' and name='"+user_name+"'"); // query with conditions
            ResultSet rs = ps.executeQuery();
            while (rs.next()){ //iterating through the database
                String name = rs.getString("name");
                String email = rs.getString("email");
                String phone_no = rs.getString("phone_no");
                String age = rs.getString("age");
                // printing data
                System.out.println("Name : "+ name );
                System.out.println("email : "+ email );
                System.out.println("phone no : "+ phone_no );
                System.out.println("age : "+ age );
                System.out.println("-------------------------------------------------");
            }
            con.close(); // connection closed
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}
