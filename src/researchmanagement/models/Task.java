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
public class Task {
    private int id;
    private String name;
    private String status;
    private int projectId;
    private int accountId;

    /**
     *
     * @param id
     * @param name
     * @param status
     * @param projectId
     * @param accountId
     */
    public Task(int id, String name, String status, int projectId, int accountId) {
        this.id = id;
        this.name = name;
        this.status = status;
        this.projectId = projectId;
        this.accountId = accountId;
    }

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

    public int getProjectId() {
        return projectId;
    }

    public void setProjectId(int projectId) {
        this.projectId = projectId;
    }

    public int getAccountId() {
        return accountId;
    }

    public void setAccountId(int accountId) {
        this.accountId = accountId;
    }
    
    
         
}
