/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package methodes;

import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author luizgustavopacheco
 */
public class Emprunt extends ConnectParent{
//entrées idreservation et tout pour l'emprunt
//sortie ("Le livre"+titre+" a été emprunté pour "+idutilisateur)
 
        public void emprunterChangeReservation(int idReservation){
    		try {
                    
			connect.setAutoCommit(false);
			Statement stmt ;
			stmt = connect.createStatement();
			stmt.executeUpdate("update reservations set statusrs = 'fini' where idreservation= "+idReservation);
                        System.out.println("Le livre réservé, a été emprunté");

			 stmt.close();
			 connect.commit();
			 connect.close();
		}
		catch(SQLException e) {
			e.getStackTrace();
		}    
    }
            public void retounerLivre(int idEmprunt){
    		try {
                    
			connect.setAutoCommit(false);
			Statement stmt ;
			stmt = connect.createStatement();
			stmt.executeUpdate("update emprunts set statusem = 'fini' where idemprunt= "+idEmprunt);
                        System.out.println("Le livre est retourné");

			 stmt.close();
			 connect.commit();
			 connect.close();
		}
		catch(SQLException e) {
			e.getStackTrace();
		}    
    }
            
            public void retouneEnRetard(int idEmprunt){
    		try {
                    
			connect.setAutoCommit(false);
			Statement stmt ;
			stmt = connect.createStatement();
			stmt.executeUpdate("update emprunts set statusem = 'delai' where idemprunt= "+idEmprunt);
                        System.out.println("Le livre est retourné");

			 stmt.close();
			 connect.commit();
			 connect.close();
		}
		catch(SQLException e) {
			e.getStackTrace();
		}    
    }
    
}
