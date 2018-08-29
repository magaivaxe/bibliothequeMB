/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package methodes;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
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
     * @param title
     * @return
     * @throws SQLException 
     */
    public ArrayList<SearchedBook> byTitle(String title) throws SQLException {
        // Locals
        ArrayList<SearchedBook> list = new ArrayList();
        Statement stmt;
        stmt = connect.createStatement();
        
        ResultSet rs = stmt.executeQuery("select livres.titre,livres.idLivre,"
                        + "auteurs.p_a_PreNom,auteurs.p_a_Nom,livres.typeLivre"
                        + " from livres inner join Livres_Editions on"
                        + " livres.idLivre=Livres_Editions.idLivre"
                        + " inner join Auteurs on"
                        + " Livres_Editions.idAuteur=Auteurs.idAuteur"
                        + " where livres.titre like "+"'%"+title+"%'");
        while (rs.next()) {
            SearchedBook sb = new SearchedBook();
            sb.setTitre(rs.getString("titre"));
            sb.setIdLivre(rs.getString("idLivre"));
            sb.setAuteur(rs.getString("p_a_Nom") + ", "
                    + rs.getString("p_a_PreNom"));
            sb.setType(rs.getString("typeLivre"));
            list.add(sb);
        }
        return list;
    }
    
    /**
     * 
     * @return 
     */
    public ArrayList<SearchedBook> byDeadArchive(){
        // TODO search dead archive
        return new ArrayList<>();
    }
}
