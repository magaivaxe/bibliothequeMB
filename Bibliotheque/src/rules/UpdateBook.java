/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rules;

/**
 *
 * @author sire_marcos
 */
public class UpdateBook {
    // Fields
    String title,nomA1,prenomA1,nomA2,prenomA2,nomA3,prenomA3,type;
    String yearBirth,yearDeath,id,publisher,city,cdu,yearPub;
    int isbn,pages;
    double price;
    byte image;
    
    // Constructor
    public UpdateBook() {
    }

    @Override
    public String toString() {
        return "UpdateBook{" + "title=" + title + ", nomA1=" + nomA1 + ", prenomA1=" + prenomA1 + ", nomA2=" + nomA2 + ", prenomA2=" + prenomA2 + ", nomA3=" + nomA3 + ", prenomA3=" + prenomA3 + ", type=" + type + ", yearBirth=" + yearBirth + ", yearDeath=" + yearDeath + ", id=" + id + ", publisher=" + publisher + ", city=" + city + ", cdu=" + cdu + ", yearPub=" + yearPub + ", isbn=" + isbn + ", pages=" + pages + ", price=" + price + ", image=" + image + '}';
    }
    
    

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }
    
    
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getNomA1() {
        return nomA1;
    }

    public void setNomA1(String nomA1) {
        this.nomA1 = nomA1;
    }

    public String getPrenomA1() {
        return prenomA1;
    }

    public void setPrenomA1(String prenomA1) {
        this.prenomA1 = prenomA1;
    }

    public String getNomA2() {
        return nomA2;
    }

    public void setNomA2(String nomA2) {
        this.nomA2 = nomA2;
    }

    public String getPrenomA2() {
        return prenomA2;
    }

    public void setPrenomA2(String prenomA2) {
        this.prenomA2 = prenomA2;
    }

    public String getNomA3() {
        return nomA3;
    }

    public void setNomA3(String nomA3) {
        this.nomA3 = nomA3;
    }

    public String getPrenomA3() {
        return prenomA3;
    }

    public void setPrenomA3(String prenomA3) {
        this.prenomA3 = prenomA3;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getYearBirth() {
        return yearBirth;
    }

    public void setYearBirth(String yearBirth) {
        this.yearBirth = yearBirth;
    }

    public String getYearDeath() {
        return yearDeath;
    }

    public void setYearDeath(String yearDeath) {
        this.yearDeath = yearDeath;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int getIsbn() {
        return isbn;
    }

    public void setIsbn(int isbn) {
        this.isbn = isbn;
    }

    public String getCdu() {
        return cdu;
    }

    public void setCdu(String cdu) {
        this.cdu = cdu;
    }

    public String getYearPub() {
        return yearPub;
    }

    public void setYearPub(String yearPub) {
        this.yearPub = yearPub;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public byte getImage() {
        return image;
    }

    public void setImage(byte image) {
        this.image = image;
    }
    
    
}
