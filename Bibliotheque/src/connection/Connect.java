/*
 * Tous les doits au groupe Gustavo Pacheco, Marcos Gomes et Mohamed Nidhal
 */
package connection;


import java.sql.Connection;
import java.sql.DriverManager;

/**
 * pour faire la connection avec la base de donneés
 * @author luizgustavopacheco
 */
public class Connect {
    
    private static String url =
        "jdbc:mysql://localhost:3306/bibliothequeMB_DB?useSSL=false";
	private static String user = "root";
	private static String passwd = "mp09s02g00";
    private static Connection connection;
        
    public static Connection connecter(){
       if (connection == null){
           try {
               connection = DriverManager.getConnection(url, user, passwd);
           } catch (Exception e) {
               throw new IllegalStateException("Impossible connecter", e);
           }
       }
       return connection;
    }
}
