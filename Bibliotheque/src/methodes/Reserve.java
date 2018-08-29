/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package methodes;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import mainPack.DateTime;

/**
 *
 * @author luizgustavopacheco
 */
public class Reserve extends ConnectParent{
    // Singleton
    private Reserve(){}
    
    public static Reserve getInstance(){return ReserveHolder.INSTANCE;}
    
    private static class ReserveHolder {
        private static final Reserve INSTANCE = new Reserve();
    }
    
    private int lastId() throws SQLException{
        // Locals
        int lastID = 0;
        
        Statement stmt;
        stmt = connect.createStatement();
        
        ResultSet rs = stmt.executeQuery(
            "select idReservation from Reservations"
         + " order by idReservation desc limit 1");
        if (rs.first()) {
            lastID = rs.getInt("idReservation");
        }     
        return lastID;
}
    
    private String lastDate(String idLivre) throws SQLException {
        // Locals
        String lastDate = "";
        Statement stmt;
        stmt = connect.createStatement();

        ResultSet rs = stmt.executeQuery(
            "select datePrevue from reservations"
          + " where idlivre='" + idLivre + "'"
          + " order by datePrevue desc limit 1");

        if (rs.first()) {
            lastDate = rs.getString("datePrevue");
        }
        return lastDate;
    }
    
    public void insert(String idLivre,String idUser) throws SQLException {
        // Locals
        String lastDate = "";
        // Find last date
        lastDate = lastDate(idLivre);
        int id = lastId() + 1;
        // condition to add date
        if (!lastDate.isEmpty()) {
            lastDate = DateTime.getInstance().addDays(lastDate, 14);
        } else {
            LocalDate ld = LocalDate.now();
            lastDate = ld.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        }
            connect.setAutoCommit(false);
            Statement stmt ;
            stmt = connect.createStatement();
            stmt.executeUpdate(
                "insert into Reservations (idReservation,idLivre,idUtilisateur,"
              + "datePrevue)"
              + " values ('"
                    + id+"','"+ idLivre+ "','"
                    + idUser+"','" + lastDate +"')");
            stmt.close();
            connect.commit();
            connect.close();
        
    }
}
