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
public class DernierId extends ConnectParent{
    
    public int chercherDernierIdEmprunt(){
        try {
            Statement stmt;
            stmt = connect.createStatement();
            ResultSet rs = stmt.executeQuery("select idEmprunt from emprunts order by idEmprunt desc limit 1");
            while (rs.next()) {
                int DernierIdEmprunt = rs.getInt("idEmprunt");
                System.out.println("Le dernier idEmprunt est "+DernierIdEmprunt);
            }
        }
            catch (SQLException e) {
            e.printStackTrace();
        }
        
        return 0;
}
   
    public int chercherDernierIdRendezVous(){
        try {
            Statement stmt;
            stmt = connect.createStatement();
            ResultSet rs = stmt.executeQuery("select idRendezVous from RendezVous order by idRendezVous desc limit 1");
            while (rs.next()) {
                int DernierIdRendezVous = rs.getInt("idRendezVous");
                System.out.println("Le dernier idRendezVous est "+DernierIdRendezVous);
            }
        }
            catch (SQLException e) {
            e.printStackTrace();
        }        
        return 0;
}
    
    
    
    public int chercherDernierIdAmende(){
        try {
            Statement stmt;
            stmt = connect.createStatement();
            ResultSet rs = stmt.executeQuery("select idAmende from Amendes order by idAmende desc limit 1");
            while (rs.next()) {
                int DernierIdAmende = rs.getInt("idAmende");
                System.out.println("Le dernier idAmende est "+DernierIdAmende);
            }
        }
            catch (SQLException e) {
            e.printStackTrace();
        }        
        return 0;
}    
}
