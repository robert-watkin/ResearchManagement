/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package researchmanagement.invoices;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import researchmanagement.Database;
import researchmanagement.Login;
import researchmanagement.models.Account;
import researchmanagement.models.ComboBoxItem;
import researchmanagement.models.Invoice;


/**
 *
 * @author robert.watkin
 */
public class EditInvoice extends javax.swing.JFrame {

    private Account loggedIn;
    private DefaultComboBoxModel customerModel = new DefaultComboBoxModel();
    private DefaultComboBoxModel projectModel = new DefaultComboBoxModel();
    private Invoice invoiceToEdit;
    
    /**
     * Creates new form NewAccount
     */
    public EditInvoice(Account acc, Invoice invoiceToEdit) {
        initComponents();
        this.setVisible(true);
        
        // check for unauthorised login
        if (acc.getId() == -1){
            Login l = new Login();
            l.setVisible(true);
            this.dispose();
        }
        loggedIn = acc;
        this.invoiceToEdit = invoiceToEdit;
        
        setValues();
    }
    
    // Sets the values for the combo boxes
    private void setValues(){
        
        // SQL string to get all customers
        String sqlGetCustomers = "SELECT * FROM tbl_customers";
        
        // Try with resource for database query
        try (Connection conn = Database.Connect();
                // prepare statement to run
                PreparedStatement ps = conn.prepareStatement(sqlGetCustomers)){
                
                // result set to store customers
                ResultSet rs = ps.executeQuery();
                
                // remove all from the combo box
                this.customerSelection.removeAll();
                
                // Check for 0 customers
                if (!rs.isBeforeFirst()){
                    // Display error message
                    JOptionPane.showMessageDialog(this, "Cannot create invoices as there are no customers\n\nReturning to Invoice Management screen");

                    // return to invoice management screen
                    InvoiceManagement im = new InvoiceManagement(loggedIn);
                    im.setVisible(true);
                    this.dispose();
                }
                
                // loop through projects and add to model
                while (rs.next()){
                    customerModel.addElement(new ComboBoxItem(rs.getInt("CustomerId"), rs.getString("FirstName") + " " + rs.getString("LastName")));
                }
      
                // loop to set selected customer to the current customer of the invoice                
                for (int i = 0; i < customerModel.getSize(); i++){
                    ComboBoxItem customer = (ComboBoxItem) customerModel.getElementAt(i);
                    if (customer.getId() == invoiceToEdit.getCustomerId()){
                        customerModel.setSelectedItem(customer);
                    }
                }
                
                // add model to the combo box
                this.customerSelection.setModel(customerModel);
        } catch (Exception e){
            // Display error message
            JOptionPane.showMessageDialog(this, "An error has occured while retrieving customers\n\n" + e);
            
            // return to invoice management screen
            InvoiceManagement im = new InvoiceManagement(loggedIn);
            im.setVisible(true);
            this.dispose();
        }
            
        // SQL string to get all projects
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
                    JOptionPane.showMessageDialog(this, "Cannot create invoices as there are no projects\n\nReturning to Invoice Management screen");

                    // return to invoice management screen
                    InvoiceManagement im = new InvoiceManagement(loggedIn);
                    im.setVisible(true);
                    this.dispose();
                }
                
                // loop through projects and add to model
                while (rs.next()){
                    projectModel.addElement(new ComboBoxItem(rs.getInt("ProjectID"), rs.getString("Name")));
                }
                
                // loop to set selected project to the current project of the invoice
                for (int i = 0; i < projectModel.getSize(); i++){
                    ComboBoxItem project = (ComboBoxItem) projectModel.getElementAt(i);
                    if (project.getId() == invoiceToEdit.getProjectId()){
                        projectModel.setSelectedItem(project);
                    }
                }
                
                // add model to the combo box
                this.projectSelection.setModel(projectModel);
        } catch (Exception e){
            // Display error message
            JOptionPane.showMessageDialog(this, "An error has occured while retrieving projects\n\n" + e);
            
            // return to invoice management screen
            InvoiceManagement im = new InvoiceManagement(loggedIn);
            im.setVisible(true);
            this.dispose();
        }   
        
        this.amountOwedField.setText(String.valueOf(invoiceToEdit.getAmountOwed()));
        this.amountPaidField.setText(String.valueOf(invoiceToEdit.getAmountPaid()));
        this.paymentSelection.setSelectedItem(invoiceToEdit.getPaymentSchedule());
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
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        projectSelection = new javax.swing.JComboBox<>();
        customerSelection = new javax.swing.JComboBox<>();
        jLabel10 = new javax.swing.JLabel();
        amountOwedField = new javax.swing.JFormattedTextField();
        amountPaidField = new javax.swing.JFormattedTextField();
        jLabel11 = new javax.swing.JLabel();
        paymentSelection = new javax.swing.JComboBox<>();
        createInvoiceButton = new javax.swing.JButton();
        cancelButton = new javax.swing.JButton();

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel8.setText("Date of Birth");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(300, 400));
        setResizable(false);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel1.setText("New Invoice");

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel5.setText("Customer");

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel6.setText("Project");

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel7.setText("Amount Owed (e.g £12.34)");

        projectSelection.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        customerSelection.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        customerSelection.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                customerSelectionActionPerformed(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel10.setText("Amount Paid (e.g £12.34)");

        amountOwedField.setColumns(20);
        amountOwedField.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(java.text.NumberFormat.getCurrencyInstance())));
        amountOwedField.setText("£00.00");
        amountOwedField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                amountOwedFieldActionPerformed(evt);
            }
        });

        amountPaidField.setColumns(20);
        amountPaidField.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(java.text.NumberFormat.getCurrencyInstance())));
        amountPaidField.setText("£00.00");
        amountPaidField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                amountPaidFieldActionPerformed(evt);
            }
        });

        jLabel11.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel11.setText("Payment Schedule");

        paymentSelection.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Daily", "Weekly", "Monthly" }));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(projectSelection, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(customerSelection, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(amountOwedField, javax.swing.GroupLayout.Alignment.TRAILING)
            .addComponent(amountPaidField)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 151, Short.MAX_VALUE))
            .addComponent(paymentSelection, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(customerSelection, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel6)
                .addGap(2, 2, 2)
                .addComponent(projectSelection, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel7)
                .addGap(2, 2, 2)
                .addComponent(amountOwedField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel10)
                .addGap(2, 2, 2)
                .addComponent(amountPaidField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel11)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(paymentSelection, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        createInvoiceButton.setText("Create Invoice");
        createInvoiceButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                createInvoiceButtonActionPerformed(evt);
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
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 15, Short.MAX_VALUE)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 14, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(createInvoiceButton, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(cancelButton)))
                .addContainerGap())
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 95, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(createInvoiceButton)
                    .addComponent(cancelButton))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cancelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelButtonActionPerformed
        // invoice management page
        InvoiceManagement im = new InvoiceManagement(loggedIn);
        im.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_cancelButtonActionPerformed

    private void amountOwedFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_amountOwedFieldActionPerformed
        // not used
    }//GEN-LAST:event_amountOwedFieldActionPerformed

    private void customerSelectionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_customerSelectionActionPerformed
        // not used
    }//GEN-LAST:event_customerSelectionActionPerformed

    private void createInvoiceButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_createInvoiceButtonActionPerformed
        // prepare sql string  
        String sqlUpdate = "UPDATE tbl_invoices SET Date=?, AmountOwed=?, AmountPaid=?, PaymentSchedule=?, CustomerID=?, ProjectID=? WHERE InvoiceID=?";           
            
        // Insert the customer into the database
        try (Connection conn = Database.Connect();
                PreparedStatement insertPs = conn.prepareStatement(sqlUpdate)){

            // get todays date
            String pattern = "dd/MM/yyyy";
            String date = new SimpleDateFormat(pattern).format(new Date());

            
            // prepare sql with values
            insertPs.setString(1, date);
            insertPs.setString(2, String.valueOf(amountOwedField.getText()));
            insertPs.setString(3, String.valueOf(amountPaidField.getText())); // dates stored as string as SQLite does not have a date datatype
            insertPs.setString(4, String.valueOf(paymentSelection.getSelectedItem()));
            
            // get the selected customer and project from the combo boxes
            ComboBoxItem customer = (ComboBoxItem) customerSelection.getSelectedItem();
            ComboBoxItem project = (ComboBoxItem) projectSelection.getSelectedItem();
            
            // insert customer and project id into prepared statement
            insertPs.setInt(5, customer.getId());
            insertPs.setInt(6, project.getId());

            // add id to prepared statement
            insertPs.setInt(7, invoiceToEdit.getId());
            
            // execute the sql query
            int row = insertPs.executeUpdate();
            System.out.println("Invoice updated at row " + row);
                  
            JOptionPane.showMessageDialog(null, "Create Successful!\n\nReturning to Invoice Management Screen");

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Cannot save invoice!\n\nError: " + e);
        }
        
        // Return to invoice management screen
        InvoiceManagement im = new InvoiceManagement(loggedIn);
        im.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_createInvoiceButtonActionPerformed

    private void amountPaidFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_amountPaidFieldActionPerformed
        // not used
    }//GEN-LAST:event_amountPaidFieldActionPerformed

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
            java.util.logging.Logger.getLogger(EditInvoice.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(EditInvoice.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(EditInvoice.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(EditInvoice.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new EditInvoice(new Account(-1, null, null, null, null, null), null).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JFormattedTextField amountOwedField;
    private javax.swing.JFormattedTextField amountPaidField;
    private javax.swing.JButton cancelButton;
    private javax.swing.JButton createInvoiceButton;
    private javax.swing.JComboBox<String> customerSelection;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JComboBox<String> paymentSelection;
    private javax.swing.JComboBox<String> projectSelection;
    // End of variables declaration//GEN-END:variables
}
