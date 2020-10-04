package com.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ReadData
{
    public static void main(String[] args) throws SQLException
    {
        //check driver installed
        // try {
        //     Class.forName("com.mysql.jdbc.Driver");
        //     System.out.println("connection success");
        // }
        // catch (ClassNotFoundException e) {
        //     System.out.println("not success");
        // }

        String URL = "jdbc:mysql://localhost:3306/db_devsocmed";
        String user = "root";
        String pwd = "";

        Connection conn = null;

        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(URL, user, pwd);
            System.out.println(conn);

            Statement st = conn.createStatement();
            String sql = "Select * from administrator";
            ResultSet rs = st.executeQuery(sql);

            while(rs.next())
            {
                System.out.println("ID: " + rs.getString("administratorID"));
                System.out.println("Nama: " + rs.getString("name"));
                System.out.println("--------------------------");
            }

        } catch (Exception e) {
            //TODO: handle exception
            e.printStackTrace();
        }

        finally {
            conn.close();
        }
    }
}