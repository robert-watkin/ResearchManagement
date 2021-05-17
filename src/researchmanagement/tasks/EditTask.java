/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package researchmanagement.tasks;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import researchmanagement.Dashboard;
import researchmanagement.Database;
import researchmanagement.Login;
import researchmanagement.models.Account;
import researchmanagement.models.ComboBoxItem;
import researchmanagement.models.Task;

/**
 *
 * @author robert.watkin
 */
public class EditTask extends javax.swing.JFrame {

    private Account loggedIn;
    private DefaultComboBoxModel projectModel = new DefaultComboBoxModel();
    private DefaultComboBoxModel accountModel = new DefaultComboBoxModel();
    private Task taskToEdit;
    
    /**
     * Creates new form NewAccount
     */
    public EditTask(Account loggedIn, Task taskToEdit) {
        initComponents();
        this.setVisible(true);
        
        // check for unauthorised login
        if (loggedIn.getId() == -1){
            Login l = new Login();
            l.setVisible(true);
            this.dispose();
        }
        this.loggedIn = loggedIn;
        this.taskToEdit = taskToEdit;
        
        setValues();
    }
    
    // Sets the values for the combo boxes
    private void setValues(){
        
        // SQL string to get all accounts that are head admins
        String sqlGetAccounts = "SELECT * FROM tbl_accounts WHERE role IN ('Head Researcher','Researcher')";
        
        // Try with resource for database query
        try (Connection conn = Database.Connect();
                // prepare statement to run
                PreparedStatement ps = conn.prepareStatement(sqlGetAccounts)){
                
                // result set to store customers
                ResultSet rs = ps.executeQuery();
                
                // remove all from the combo box
                this.accountSelection.removeAll();
                
                // populate name field
                this.nameField.setText(taskToEdit.getName());
                
                // Check for 0 customers
                if (!rs.isBeforeFirst()){
                    // Display error message
                    JOptionPane.showMessageDialog(this, "Cannot create task as there are no researchers\n\nReturning to Dashboard");

                    // return to dashboard screen
                    Dashboard d = new Dashboard(loggedIn);
                    d.setVisible(true);
                    this.dispose();
                    return;
                }
                
                // loop through projects and add to model
                while (rs.next()){
                    accountModel.addElement(new ComboBoxItem(rs.getInt("AccountID"), rs.getString("FirstName") + " " + rs.getString("LastName")));
                }
                
                // set boxmodel selected item to account
                for (int i = 0; i < accountModel.getSize(); i++){
                    ComboBoxItem account = (ComboBoxItem) accountModel.getElementAt(i);
                    if (account.getId() == taskToEdit.getAccountId()){
                        accountModel.setSelectedItem(account);
                    }
                }
                
                // add model to the combo box
                this.accountSelection.setModel(accountModel);
        } catch (Exception e){
            // Display error message
            JOptionPane.showMessageDialog(this, "An error has occured while retrieving customers\n\n" + e);
            
            // return to dashboard screen
            Dashboard d = new Dashboard(loggedIn);
            d.setVisible(true);
            this.dispose();
        }
            
        String sqlGetProjects = "SELECT * FROM tbl_projects";
       
        // Try with resource for database query
        try (Connection conn = Database.Connect();
                // prepare statement to run
                PreparedStatement ps = conn.prepareStatement(sqlGetProjects)){
                
                // result set to store customers
                ResultSet rs = ps.executeQuery();
                
                // remove all from the combo box
                this.projectSelection.removeAll();
                
                // Check for 0 projects
                if (!rs.isBeforeFirst()){
                    // Display error message
                    JOptionPane.showMessageDialog(this, "Cannot create task as there are no projects\n\nReturning to Dashboard");

                    // return to dashboard screen
                    Dashboard d = new Dashboard(loggedIn);
                    d.setVisible(true);
                    this.dispose();
                }
                
                // loop through projects and add to model
                while (rs.next()){
                    projectModel.addElement(new ComboBoxItem(rs.getInt("ProjectID"), rs.getString("Name")));
                }
                
                // set boxmodel selected item to project
                for (int i = 0; i < projectModel.getSize(); i++){
                    ComboBoxItem project = (ComboBoxItem) projectModel.getElementAt(i);
                    if (project.getId() == taskToEdit.getProjectId()){
                        projectModel.setSelectedItem(project);
                    }
                }
                
                // add model to the combo box
                this.projectSelection.setModel(projectModel);
        } catch (Exception e){
            // Display error message
            JOptionPane.showMessageDialog(this, "An error has occured while retrieving projects\n\n" + e);
            
            // return to dashboard screen
            Dashboard d = new Dashboard(loggedIn);
            d.setVisible(true);
            this.dispose();
        }   
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel8 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        nameField = new javax.swing.JTextField();
        accountSelection = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        projectSelection = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        saveTaskButton = new javax.swing.JButton();
        cancelButton = new javax.swing.JButton();

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel8.setText("Date of Birth");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(300, 350));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel1.setText("Edit Task");

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel7.setText("Task Name");

        nameField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nameFieldActionPerformed(evt);
            }
        });

        accountSelection.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        accountSelection.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                accountSelectionActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel5.setText("Assign Researcher");

        projectSelection.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        projectSelection.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                projectSelectionActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel6.setText("Project");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(nameField)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 151, Short.MAX_VALUE))
            .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(accountSelection, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(projectSelection, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(nameField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(accountSelection, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(projectSelection, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(36, Short.MAX_VALUE))
        );

        saveTaskButton.setText("Save Task");
        saveTaskButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveTaskButtonActionPerformed(evt);
            }
        });

        cancelButton.setText("Cancel");
        cancelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(saveTaskButton, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(cancelButton))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 15, Short.MAX_VALUE)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 14, Short.MAX_VALUE)))
                .addContainerGap())
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 98, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(saveTaskButton)
                    .addComponent(cancelButton))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cancelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelButtonActionPerformed
        // return to dashboard screen
        Dashboard d = new Dashboard(loggedIn);
        d.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_cancelButtonActionPerformed

    private void accountSelectionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_accountSelectionActionPerformed
        // not used
    }//GEN-LAST:event_accountSelectionActionPerformed

    private void saveTaskButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveTaskButtonActionPerformed
        // prepare sql string
        String sqlInsert = "INSERT INTO tbl_tasks (Name, Status, ProjectID, AccountID) VALUES (?, ?, ?, ?)";
            
        // Insert the customer into the database
        try (Connection conn = Database.Connect();
                PreparedStatement insertPs = conn.prepareStatement(sqlInsert)){

            System.out.println(nameField.getText());
            
            // prepare sql with values
            insertPs.setString(1, nameField.getText());
            insertPs.setString(2, "In Progress");
            
            // retrieve selected customer and head researcher
            ComboBoxItem project = (ComboBoxItem) projectSelection.getSelectedItem();
            ComboBoxItem researcher = (ComboBoxItem) accountSelection.getSelectedItem();
            
            // add IDs to prepared statement
            insertPs.setInt(3, project.getId()); 
            insertPs.setInt(4, researcher.getId());
            
            // execute the sql query
            int row = insertPs.executeUpdate();
            System.out.println("Task inserted into row " + row);
                  
            JOptionPane.showMessageDialog(null, "Create Successful!\n\nReturning to Dashboard");

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Cannot save task!\n\nError: " + e);
        }
        
        // return to dashboard screen
        Dashboard d = new Dashboard(loggedIn);
        d.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_saveTaskButtonActionPerformed

    private void nameFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nameFieldActionPerformed
        // not used
    }//GEN-LAST:event_nameFieldActionPerformed

    private void projectSelectionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_projectSelectionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_projectSelectionActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(EditTask.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(EditTask.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(EditTask.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(EditTask.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new EditTask(new Account(-1, null, null, null, null, null), null).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> accountSelection;
    private javax.swing.JButton cancelButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField nameField;
    private javax.swing.JComboBox<String> projectSelection;
    private javax.swing.JButton saveTaskButton;
    // End of variables declaration//GEN-END:variables
}
