package com.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class InsertData {

    public static void main(String[] args) throws SQLException{
        String URL = "jdbc:mysql://localhost:3306/db_devsocmed";
        String USER = "root";
        String PWD = "";
        Connection conn = null;

        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(URL, USER, PWD);
            System.out.println(conn);

            String sql = "insert into administrator(name, administratorID) values(?,?)";
            PreparedStatement pst = conn.prepareStatement(sql);

            pst.setString(1, "Ans");
            pst.setString(2, "AD006");
            int affectedRow = pst.executeUpdate();
            //executeUpdate() =execute query and return rows affected

            pst.setString(1, "Adrian");
            pst.setString(2, "AD007");
            affectedRow += pst.executeUpdate();

            System.out.println(affectedRow + " records inserted");
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        } finally {
            conn.close();
        }
    }

}
