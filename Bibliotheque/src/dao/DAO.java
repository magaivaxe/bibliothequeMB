/*
 * Tous les doits au groupe Gustavo Pacheco, Marcos Gomes et Mohamed Nidhal
 */
package dao;

import connection.Connect;
import java.sql.Connection;


public abstract class DAO<T> {
    
    public Connection connect = Connect.connecter();
           
    public abstract T rechercher();
   
    public abstract T inserer();
    
    public abstract T mettreAJour();

    
}
