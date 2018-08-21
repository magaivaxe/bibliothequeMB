/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tableData;

/**
 *
 * @author Marcos
 */
public class SearchedUser {
    // Fields
    private String id;
    private String user;
    private String status;
    
    // COnstructors
    public SearchedUser () {}

    public SearchedUser(String id, String user, String status) {
        this.id = id;
        this.user = user;
        this.status = status;
    }
    
    // Getters and setters

    public String getId() {return id;}

    public void setId(String id) {this.id = id;}

    public String getUser() {return user;}

    public void setUser(String user) {this.user = user;}

    public String getStatus() {return status;}

    public void setStatus(String status) {this.status = status;}
    
    
}
