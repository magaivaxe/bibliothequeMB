/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package methodes;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author luizgustavopacheco
 */
public class Reservation extends ConnectParent{
    
    String derniereReservation;
    
    public String conditionReservation(String idLivre){
    try{
        
    Statement stmt;
    stmt = connect.createStatement();
				
	ResultSet rs = stmt.executeQuery("select datePrevue "
                + "from reservations where idlivre='"
                +idLivre+"' order by datePrevue desc limit 1");
        while (rs.next()) {
        derniereReservation = rs.getString("datePrevue");
        }
        
        //stmt.close();
        //connect.close();
    }
        catch(SQLException e){
            e.printStackTrace();
        }
        return derniereReservation;
    } 
    
    
}
