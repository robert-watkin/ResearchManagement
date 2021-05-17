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
public class ComboBoxItem {
    private int id;
    private String name;

    /**
     *
     * @param id
     * @param name
     */
    public ComboBoxItem(int id, String name) {
        this.id = id;
        this.name = name;
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
    

    @Override
    public String toString(){
        return this.id + " " + this.name;
    }
}
