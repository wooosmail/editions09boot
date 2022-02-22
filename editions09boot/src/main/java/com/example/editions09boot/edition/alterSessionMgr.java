package com.example.editions09boot.edition;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

public class alterSessionMgr {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {

        Class.forName("oracle.jdbc.OracleDriver");
        Properties p = new Properties();
        p.put("user", "TESTUSER");
        p.put("password", "1234");

        Connection conn2 = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521/xe", p);

        ResultSet rs = conn2.createStatement().executeQuery(
                "select sys_context('userenv', 'current_edition_name') from dual");
        rs.next();
        System.out.println(" First " + rs.getString(1));


        p.put("oracle.jdbc.editionName", "RELEASE2");
        conn2 = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521/xe", p);

         rs = conn2.createStatement().executeQuery(
                "select sys_context('userenv', 'current_edition_name') from dual");
        rs.next();
        System.out.println(rs.getString(1));
    }
}
