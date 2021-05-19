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
public class Project {
    
    private int id;
    private String name;
    private String status;
    private int customerId;
    private int headResearcherId;

    /**
     *
     * @param id
     * @param name
     * @param status
     * @param customerId
     * @param headResearcherId
     */
    public Project(int id, String name, String status, int customerId, int headResearcherId) {
        this.id = id;
        this.name = name;
        this.status = status;
        this.customerId = customerId;
        this.headResearcherId = headResearcherId;
    }

    
    // GETTERS AND SETTERS
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public int getHeadResearcherId() {
        return headResearcherId;
    }

    public void setHeadResearcherId(int headResearcherId) {
        this.headResearcherId = headResearcherId;
    }
    
    
}
