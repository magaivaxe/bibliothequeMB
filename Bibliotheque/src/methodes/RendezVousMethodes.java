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
public class RendezVousMethodes extends ConnectParent{
    
            public void anuulerRendezVous(int idRendezVous){
    		try {
                    
			connect.setAutoCommit(false);
			Statement stmt ;
			stmt = connect.createStatement();
			stmt.executeUpdate("update rendezvous set statusrv = 'annule' where idRendezVous= "+idRendezVous);
                        System.out.println("Le rendez-vous "+idRendezVous+" a été annulé");

			 stmt.close();
			 connect.commit();
			 connect.close();
		}
		catch(SQLException e) {
			e.getStackTrace();
		}    
    }

            public void changerHoraireRendezVous(int idRendezVous, String datePrevue, String type){
    		try {
                    
			connect.setAutoCommit(false);
			Statement stmt ;
			stmt = connect.createStatement();
			stmt.executeUpdate("update rendezvous set datePrevue = '"+datePrevue+"',type = '"+type+"' where idRendezVous= "+idRendezVous);
                        System.out.println("Le rendez-vous "+idRendezVous+" a été changé pour le "+datePrevue+" "+type);

			 stmt.close();
			 connect.commit();
			 connect.close();
		}
		catch(SQLException e) {
			e.getStackTrace();
		}    
    }            
    
}
