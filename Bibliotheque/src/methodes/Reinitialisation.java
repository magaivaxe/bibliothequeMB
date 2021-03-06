/*
 * Tous les doits au groupe Gustavo Pacheco, Marcos Gomes et Mohamed Nidhal
 */
package methodes;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import rules.Utilisateurs;

/**
 *
 * @author luizgustavopacheco
 */
public class Reinitialisation extends ConnectParent {
    //Attributs
    String idConfirmee;

    // Contructeur
    public Reinitialisation() {
        super();
    }
    
//==============================================================================
//RÉINITIALISER MOT DE PASSE
//PREND L'IDUTILISATEUR ET SA DATE DE NAISSANCE POUR CONFIRMER L'IDENTITÉ
//PREND L'IDENTITÉ ET CHANGE LE MOT DE PASSE
     
    public String chercherUtilisateur(String idUtilisateurEntree,String dateNeEntree)
    {
        try {
            ResultSet rs = connect.createStatement().executeQuery(
                    "select idUtilisateur,dateNe from Utilisateurs where "
                            + "idUtilisateur="+"'"+idUtilisateurEntree+"'"
                                    +" and dateNe="+"'"+dateNeEntree+"'");
            if(rs.next())
                idConfirmee = rs.getString("idUtilisateur");
        } catch (SQLException ex) {
            Logger.getLogger(Reinitialisation.class.getName()).log(Level.SEVERE, null, ex);
        }
        return idConfirmee;
    }

//==============================================================================
    
    public Utilisateurs rechercher(String idUtilisateurEntree) {
        
        Utilisateurs aRetouner = new Utilisateurs();

        try {
            ResultSet resultat = this.connect
                    .createStatement(
                            ResultSet.TYPE_SCROLL_INSENSITIVE,
                            ResultSet.CONCUR_UPDATABLE
                    ).executeQuery(
                            "select * from Utilisateurs where idUtilisateur = "
                                    +"'"+ idUtilisateurEntree+"'"
                    );
           
            if (resultat.first()) {
                aRetouner = new Utilisateurs(
                        resultat.getString("idUtilisateur"),
                        resultat.getString("nom"),
                        resultat.getString("preNom"),
                        resultat.getString("adresse"),
                        resultat.getString("telephone"),
                        resultat.getString("courriel"),
                        resultat.getString("dateNe"), 
                        resultat.getString("dateRegistre"),
                        resultat.getString("role"), 
                        resultat.getString("statusUT"));
            }
        } catch (SQLException e) {
        }
        
        return aRetouner;
    }

//==============================================================================
    
         public String changerMotDePasse(String id, String new_pw)
     {        
         try {
            Statement stmt;
            stmt = connect.createStatement();
            stmt.executeUpdate("update UsersMotDePasse "
                + "set mdpEncripte="+
                "AES_ENCRYPT('"+ new_pw+"','"+ new_pw+"')"
              + " where idUtilisateur="+"'"+ id+"'");
          
		System.out.println("LE NOUVEAU MOT DE PASSE EST "  + new_pw 
                        +" POUR L'UTILISATEUR "+id);		
    
        } catch (SQLException e) {
            
        }
        return new_pw;
        }  
         
//==============================================================================         
 
}
