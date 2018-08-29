/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package methodes;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import rules.Emprunts;

/**
 *
 * @author luizgustavopacheco
 */
public class Renouvellement extends ConnectParent{
    //chercher le livre emprunté status cours.
    //prendre la dateRendre et la transformer en dateEmprunt
    //entree titre et idUtilisateur
    //sortie alerte: impossible renouveler et renouvelé jusqu'à tel date
    //select * from emprunts where idlivre='livre1' and idutilisateur='NidhalAfrican' and statusem='cours';
//==============================================================================
//ON CHERCHE UN LIVRE PRÉCISE DÉJÀ EMPRUNTÉ POUR L'UTILISATEUR 
//ON N'UTILISE PAS LE TITRE PARCE QU'IL PEUT ÊTRE RÉPÉTÉ
    public Emprunts chercherLivreEmprunte(String idLivre, String idUtilisateur){
        Emprunts aRetourner = new Emprunts();
            String dateRend = null;        
        try {
            Statement stmt;

            stmt = connect.createStatement();
            		ResultSet rs = stmt.executeQuery("select * from emprunts "
                    + "where idLivre="+"'"+idLivre+"'" 
                    + "and idUtilisateur="+"'"+idUtilisateur+"'"
                    + "and statusEM='cours'");

            while (rs.next()) {
                aRetourner = new Emprunts(rs.getInt("idEmprunt"),
                        rs.getString("idLivre"),
                        rs.getString("idUtilisateur"),
                        rs.getString("dateEmp"),
                        rs.getString("dateRen"),
                        rs.getString("statusEM"));
            }
        }
            catch (SQLException e) {
            e.printStackTrace();
        }
    
        return aRetourner;
    }
//==============================================================================
//ON FAIT UN NOUVEAU EMPRUNT AVEC LA DATEREND EN METTANT COMME DATEEMP
//ON CHANGE AUSSI L'IDENTITÉ D'EMPRUNT

    public void insererRenouvellement(int idEmprunt, String idLivre, String idUtilisateur, 
            String dateEmp, String dateRen, String statusEM){
       
                Insertions i = new Insertions();
                i.insererEmprunt(idEmprunt, idLivre, idUtilisateur, dateEmp, dateRen, statusEM);
       
   }
    
}
