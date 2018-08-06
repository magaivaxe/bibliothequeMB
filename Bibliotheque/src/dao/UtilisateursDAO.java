/*
 * Tous les doits au groupe Gustavo Pacheco, Marcos Gomes et Mohamed Nidhal
 */
package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import tables.Utilisateurs;

/**
 *
 * @author Marcos
 */
public class UtilisateursDAO extends DAO<Utilisateurs> {
    //Attributs
    String idReinit;
    
    
    // Contructeur
    public UtilisateursDAO() {
        super();
    }
    
    // Méthodes
    
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
                idReinit = rs.getString("idUtilisateur");
        } catch (SQLException ex) {
            Logger.getLogger(UtilisateursDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return idReinit;
    }

//==============================================================================
    
    public Utilisateurs rechercher(String idUtilisateurEntree) {
        // locaux
        Utilisateurs aRetouner = new Utilisateurs();
        
        // Essaye de la requête
        try {

            ResultSet resultat = this.connect
                    .createStatement(
                            ResultSet.TYPE_SCROLL_INSENSITIVE,
                            ResultSet.CONCUR_UPDATABLE
                    ).executeQuery(
                            "select * from Utilisateurs where idUtilisateur = "
                                    +"'"+ idUtilisateurEntree+"'"
                    );
            
            // Attribution à l'objet utilisateur les valeurs de la requête            
            if (resultat.first()) {
                aRetouner = new Utilisateurs(
                        resultat.getString("idUtilisateur"),
                        resultat.getString("nom"),
                        resultat.getString("preNom"),
                        resultat.getString("adresse"),
                        resultat.getString("telephone"),
                        resultat.getString("courriel"),
                        resultat.getDate("dateNe"), 
                        resultat.getDate("dateRegistre"),
                        resultat.getString("role"), 
                        resultat.getString("statusUT"));
            }
        } catch (SQLException e) {
        }
        
        return aRetouner;
    }

    
    @Override
    public Utilisateurs inserer() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Utilisateurs mettreAJour() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Utilisateurs rechercher() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        
    }

   
    
}
