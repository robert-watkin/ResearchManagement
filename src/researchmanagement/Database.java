/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package researchmanagement;

import java.sql.*;

/**
 *
 * @author robert.watkin
 */
public class Database {
    public static Connection Connect() {
        
        try {
            Class.forName("org.sqlite.JDBC");
            Connection conn = DriverManager.getConnection("jdbc:sqlite:C:\\Users\\robert.watkin\\OneDrive - Accenture\\Documents\\newcastleCollegeUni\\LVL 6 SEM 1\\CMP330 Systems Development\\Practical\\research_management.db");
            return conn;
        }
        catch (Exception e) {
            System.out.println("Error: " + e);
            return null;
        }
        
    }
}
