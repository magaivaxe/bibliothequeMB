/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tableData;

import java.util.Date;

/**
 *
 * @author sire_marcos
 */
public class SearchedHistoty {
    // Fields
    private String type;
    private Date date;
    private String titleBook;
    private String status;
    // Constructors
    public SearchedHistoty() {}
    
    public SearchedHistoty(String type, Date date,
        String titleBook, String status) {
        this.type = type;
        this.date = date;
        this.titleBook = titleBook;
        this.status = status;
    }
    
    // Setters and getters
    public String getType() {return type;}

    public void setType(String type) {this.type = type;}

    public Date getDate() {return date;}

    public void setDate(Date date) {this.date = date;}

    public String getTitleBook() {return titleBook;}

    public void setTitleBook(String titleBook) {this.titleBook = titleBook;}

    public String getStatus() {return status;}

    public void setStatus(String status) {this.status = status;}
    
    // To String

    @Override
    public String toString() {
        return "SearchedHistoty{" + 
                "type=" + type + 
                ", date=" + date + 
                ", titleBook=" + titleBook + 
                ", status=" + status + '}';
    }
    
    
    
}
