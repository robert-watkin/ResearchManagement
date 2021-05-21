/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package researchmanagement;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author robert.watkin
 */
public class Audit {
    public static void Update(String tableName, int accountId, String accountName, String action){
        // sql to insert to the audit table
        String sqlUpdateAudit = "INSERT INTO tbl_audit (TableName, AccountID, AccountName, Action, DateTime) VALUES (?, ?, ?, ?, ?)";
        
        // try with resource for DB querying
        try (Connection conn = Database.Connect();
                PreparedStatement ps = conn.prepareStatement(sqlUpdateAudit)){
            
            // input values to prepared statement
            ps.setString(1, tableName);
            ps.setInt(2, accountId);
            ps.setString(3, accountName);
            ps.setString(4, action);
            
            // set current date time
            SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");  
            Date date = new Date();  
            ps.setString(5, formatter.format(date));
            
            ps.executeUpdate();
           
            
        } catch (Exception e){
            System.out.println("Can't update audit log\n\n"+e);
        }
      
    }
}
