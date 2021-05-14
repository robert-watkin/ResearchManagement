/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package researchmanagement.models;

/**
 *
 * @author robert.watkin
 */
public class Invoice {
    private int id;
    private int customerID;
    private int projectID;
    private float amountPaid;
    private float amountOwed;
    private String paymentSchedule;

    /**
     *
     * @param id
     * @param customerID
     * @param projectID
     * @param amountPaid
     * @param amountOwed
     * @param paymentSchedule
     */
    public Invoice(int id, int customerID, int projectID, float amountPaid, float amountOwed, String paymentSchedule) {
        this.id = id;
        this.customerID = customerID;
        this.projectID = projectID;
        this.amountPaid = amountPaid;
        this.amountOwed = amountOwed;
        this.paymentSchedule = paymentSchedule;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCustomerID() {
        return customerID;
    }

    public void setCustomerID(int customerID) {
        this.customerID = customerID;
    }

    public int getProjectID() {
        return projectID;
    }

    public void setProjectID(int projectID) {
        this.projectID = projectID;
    }

    public float getAmountPaid() {
        return amountPaid;
    }

    public void setAmountPaid(float amountPaid) {
        this.amountPaid = amountPaid;
    }

    public float getAmountOwed() {
        return amountOwed;
    }

    public void setAmountOwed(float amountOwed) {
        this.amountOwed = amountOwed;
    }

    public String getPaymentSchedule() {
        return paymentSchedule;
    }

    public void setPaymentSchedule(String paymentSchedule) {
        this.paymentSchedule = paymentSchedule;
    }
         
    
}
