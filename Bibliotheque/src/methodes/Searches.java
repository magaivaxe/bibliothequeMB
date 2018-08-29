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
import rules.UpdateBook;
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
    
    public UpdateBook byID(String id) throws SQLException {
        // Locals
        UpdateBook ub = new UpdateBook();
        Statement stm = connect.createStatement();
        
        ResultSet rs = stm.executeQuery(
            "select l.idLivre,l.cdu,l.titre,l.typeLivre,"
          + "a.p_a_PreNom,a.p_a_Nom,a.anneeNe,a.anneeMort,"
          + "a.s_a_PreNom,a.s_a_Nom,a.t_a_PreNom,a.t_a_Nom,"
          + "e.isbn,e.maisonPub,e.villePub,e.anneePub,e.pages,e.prix"
          + " from Livres as l" +
            " inner join Livres_Editions as le" +
            " on l.idLivre = le.idLivre" +
            " inner join Editions as e" +
            " on le.isbn = e.isbn" +
            " inner join Auteurs as a" +
            " on le.idAuteur = a.idAuteur" +
            " where l.idLivre = '"+ id +"'");
        
        if (rs.first()) {
            ub.setId(rs.getString(1));
            ub.setCdu(rs.getString(2));
            ub.setType(rs.getString(3));
            ub.setPrenomA1(rs.getString(4));
            ub.setNomA1(rs.getString(5));
            ub.setYearBirth(rs.getString(6));
            ub.setYearDeath(rs.getString(7));
            ub.setPrenomA2(rs.getString(8));
            ub.setNomA2(rs.getString(9));
            ub.setPrenomA3(rs.getString(10));
            ub.setNomA3(rs.getString(11));
            ub.setIsbn(rs.getInt(12));
            ub.setPublisher(rs.getString(13));
            ub.setCity(rs.getString(14));
            ub.setYearPub(rs.getString(15));
            ub.setPages(rs.getInt(16));
            ub.setPrice(rs.getDouble(17));
        }
        return ub;
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
