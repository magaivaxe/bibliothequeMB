/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package methodes;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import tableData.SearchedBook;

/**
 *
 * @author luizgustavopacheco
 */
public class Searches extends ConnectParent {
    // Singleton
    private Searches() {super();}
    
    public static Searches getInstance() {return SearchesHolder.INSTANCE;}
    
    private static class SearchesHolder {
        private static final Searches INSTANCE = new Searches();
    }

    /**
     * 
     * @param titreEntre
     * @return
     * @throws SQLException 
     */
    public LinkedList<SearchedBook> byTitle(String titreEntre)
                                                           throws SQLException {
        // Locals
        LinkedList<SearchedBook> list = new LinkedList<>();
        SearchedBook sb = new SearchedBook();
        
        Statement stmt;
        stmt = connect.createStatement();
        
        ResultSet rs = stmt.executeQuery(
                "select livres.titre,livres.cdu,"
                        + "auteurs.p_a_PreNom,auteurs.p_a_Nom,livres.typeLivre"
                        + " from livres inner join Livres_Editions on"
                        + " livres.idLivre=Livres_Editions.idLivre"
                        + " inner join Auteurs on"
                        + " Livres_Editions.idAuteur=Auteurs.idAuteur"
                        + " where livres.titre="+"'"+titreEntre+"'");
        
        while (rs.next()) {
            sb.setTitre(rs.getString("titre"));
            sb.setCdu(rs.getString("cdu"));
            sb.setAuteur(rs.getString("p_a_Nom") + ", "
                    + rs.getString("p_a_PreNom"));
            sb.setType(rs.getString("typeLivre"));
            list.add(sb);
        }
        
        return list;
    }
    
}
