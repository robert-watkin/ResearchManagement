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
    private int customerId;
    private int taskId;
    private String date;
    private String amountPaid;
    private String amountOwed;
    private String paymentSchedule;

    /**
     *
     * @param id
     * @param customerId
     * @param taskId
     * @param date
     * @param amountPaid
     * @param amountOwed
     * @param paymentSchedule
     */
    public Invoice(int id, int customerId, int taskId, String date, String amountPaid, String amountOwed, String paymentSchedule) {
        this.id = id;
        this.customerId = customerId;
        this.taskId = taskId;
        this.date = date;
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

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerID) {
        this.customerId = customerID;
    }

    public int getTaskId() {
        return taskId;
    }

    public void setTaskId(int taskId) {
        this.taskId = taskId;
    }

    public String getAmountPaid() {
        return amountPaid;
    }

    public void setAmountPaid(String amountPaid) {
        this.amountPaid = amountPaid;
    }

    public String getAmountOwed() {
        return amountOwed;
    }

    public void setAmountOwed(String amountOwed) {
        this.amountOwed = amountOwed;
    }

    public String getPaymentSchedule() {
        return paymentSchedule;
    }

    public void setPaymentSchedule(String paymentSchedule) {
        this.paymentSchedule = paymentSchedule;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
