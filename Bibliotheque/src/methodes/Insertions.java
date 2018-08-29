/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package methodes;

import java.sql.SQLException;
import java.sql.Statement;
import mainPack.DateTime;
import rules.Emprunts;
import rules.Livres;
import rules.RendezVous;
import rules.Reservations;
import rules.UsersMotDePasse;
import rules.Utilisateurs;

/**
 *
 * @author luizgustavopacheco
 */
public class Insertions extends ConnectParent {
    
    public Livres insererLivres(String idLivreAInserer, String cduAInserer, String titreAInserer,
            String dateRegistreAInserer, String typeLivreAInserer){
    		try {
			connect.setAutoCommit(false);
			Statement stmt ;
			stmt = connect.createStatement();
			stmt.executeUpdate("insert into Livres"
                                + "(idLivre,"
                                + "cdu,"
                                + "titre,"
                                + "dateRegistre,"
                                + "typeLivre)"
                                + " values ('"
                                + idLivreAInserer+"','"
                                + cduAInserer+"','"
                                + titreAInserer+"','"
                                + dateRegistreAInserer+"','"                                
                                + typeLivreAInserer+"')");
                        System.out.println("Données insérées correctement pour le livre "+idLivreAInserer);
			 stmt.close();
			 connect.commit();
			 connect.close();
		}
		catch(SQLException e) {
			e.getStackTrace();
		}    
        return null;
    }     
    
    public Utilisateurs insererUtilisateur(String idUtilisateurAInserer,String nomAInserer,
            String preNomAInserer,String dateNeAInserer,String adresseAInserer,
            String telephoneAInserer,String courrielAInserer,
            String dateRegistreAInserer){
    		try {
			connect.setAutoCommit(false);
			Statement stmt ;
			stmt = connect.createStatement();
			stmt.executeUpdate("insert into Utilisateurs"
                                + "(idUtilisateur,"
                                + "nom,"
                                + "preNom,"
                                + "dateNe,"
                                + "adresse,"
                                + "telephone,"
                                + "courriel,"
                                + "dateRegistre)"
                                + " values ('"
                                + idUtilisateurAInserer+"','"
                                + nomAInserer+"','"
                                + preNomAInserer+"','"
                                + dateNeAInserer+"','"                                
                                + adresseAInserer+"','"
                                + telephoneAInserer+"','"
                                + courrielAInserer+"','"
                                + dateRegistreAInserer+"')");
                        System.out.println("Données insérées correctement pour l'utilisateur"+idUtilisateurAInserer);
			 stmt.close();
			 connect.commit();
			 connect.close();
		}
		catch(SQLException e) {
			e.getStackTrace();
		}    
        return null;
    }     
    
    public UsersMotDePasse insererMotDePAsse(String idUtilisateurAInserer,String mdpEncripteAInserer){
    		try {
			connect.setAutoCommit(false);
			Statement stmt ;
			stmt = connect.createStatement();
			stmt.executeUpdate("insert into UsersMotDePasse(idUtilisateur,mdpEncripte)"
                                + " values ('"
                                + idUtilisateurAInserer+"',AES_ENCRYPT('"+mdpEncripteAInserer+"','"+mdpEncripteAInserer+"'))");
                        System.out.println("Mot de passe inséré correctement pour l'utilisateur"+idUtilisateurAInserer);
			 stmt.close();
			 connect.commit();
			 connect.close();
		}
		catch(SQLException e) {
			e.getStackTrace();
		}    
        return null;
    }

    


   
   public Emprunts insererEmprunt(int idEmprunt, String idLivre, String idUtilisateur, 
            String dateEmp, String dateRen, String statusEM){
       
       try {
			connect.setAutoCommit(false);
			Statement stmt ;
			stmt = connect.createStatement();
			stmt.executeUpdate("insert into Emprunts "
                                + "(idEmprunt,"
                                + "idLivre,"
                                + "idUtilisateur,"
                                + "dateEmp,"
                                + "dateRen,"
                                + "statusEM)"
                                + " values ('"
                                + idEmprunt +"','"
                                + idLivre +"','"
                                + idUtilisateur +"','"
                                + dateEmp +"','"
                                + dateRen +"','"                                 
                                + statusEM +"')");
                        System.out.println("Le livre "+idLivre+
                                " a été emprunté pour "+idUtilisateur);

			 stmt.close();
			 connect.commit();
			 connect.close();
		}
		catch(SQLException e) {
			e.getStackTrace();
		}    
       
        return null;
   }
   
   public RendezVous insererRendezVous(int idRendezVous, String idLivre, String idUtilisateur, String datePrevue, String type, String statusRV){
       
       try {
			connect.setAutoCommit(false);
			Statement stmt ;
			stmt = connect.createStatement();
			stmt.executeUpdate("insert into RendezVous "
                                + "(idRendezVous,"
                                + "idLivre,"
                                + "idUtilisateur,"
                                + "datePrevue,"
                                + "type,"
                                + "statusRV)"
                                + " values ('"
                                + idRendezVous +"','"
                                + idLivre +"','"
                                + idUtilisateur +"','"
                                + datePrevue +"','"
                                + type +"','"                                 
                                + statusRV +"')");
                        System.out.println("Le rendez-vous a été fixé pour "+idUtilisateur+" le "+datePrevue+" "+type);

			 stmt.close();
			 connect.commit();
			 connect.close();
		}
		catch(SQLException e) {
			e.getStackTrace();
		}    
       
        return null;
   }
   
    
}
