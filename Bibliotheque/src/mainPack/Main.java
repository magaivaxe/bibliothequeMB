/*
 * Tous les doits au groupe Gustavo Pacheco, Marcos Gomes et Mohamed Nidhal
 */
package mainPack;



import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import methodes.Emprunt;
import methodes.Historique;
import methodes.Insertions;
import methodes.Login;
import methodes.Reinitialisation;
import methodes.RechercherParTitre;
import methodes.RendezVousMethodes;
import methodes.Renouvellement;
import tables.Emprunts;
import tables.UsersMotDePasse;
import tables.Utilisateurs;

/**
 *
 * @author luizgustavopacheco
 */
public class Main{

    public static void main(String[] args) throws SQLException {
        
        String idUtilisateurEntree = "Utilisateur";
        String motDePasseEntree = "123util";
        
        Reinitialisation r = new Reinitialisation();
        Utilisateurs ut = r.rechercher(idUtilisateurEntree);
        //System.out.println("TEST "+ut.toString());        
        
        String dateNeEntree = "1234-12-12";
        String nouveauMotDePasse = "123encrypte";
        
        String courrielEntree = "123@ex.com";

        //LOGIN===============================================================OK
        Login l = new Login();
        UsersMotDePasse umdp = new UsersMotDePasse();                
        //umdp = l.trouverMotDePasse(idUtilisateurEntree,motDePasseEntree);
        //System.out.println("TEST "+umdp.toString()); 
        
        String mdpEncrypte = umdp.getMdpEncripte();
        String mdpDecrypte = l.decrypterMotDePasse(motDePasseEntree);
        //System.out.println("TEST MOT DE PASSE ENCRYPTE "+mdpEncrypte); 
        System.out.println("TEST MOT DE PASSE DECRYPTE "+mdpDecrypte);

        //l.trouverMotDePasse(idUtilisateurEntree,motDePasseEntree);
        //l.comparerMotDePasse(motDePasseEntree,mdpDecrypte);

        //RÉINITIALISER MOT DE PASSE============================================OK        
        String idConfirmee = r.chercherUtilisateur(idUtilisateurEntree, dateNeEntree);
        //r.changerMotDePasse(idConfirmee, nouveauMotDePasse);déjà fait  
        
        //RECHERCHE DE LIVRE PAR TITRE==========================================OK
        String titreEntre = "Nom du livre";
        RechercherParTitre rpt = new RechercherParTitre();
        //rpt.rechercherSimple(titreEntre);

        //INSERTIONS============================================================
        Insertions in = new Insertions();

        //INSÉRER LIVRES========================================================OK        
        String idLivreAInserer = "livre";
        String cduAInserer = "12345678";
        String titreAInserer = "Nom du livre";                                
        String typeLivreAInserer = "regulier";
        //in.insererLivres(idLivreAInserer, cduAInserer, titreAInserer, dateRegistreAInserer, typeLivreAInserer);déjà fait
        
        
        //INSÉRER UTILISATEUR===================================================OK        
        String idUtilisateurAInserer = "lpg";
        String nomAInserer="Pacheco";
        String preNomAInserer="Luiz Gustavo"; 
        String dateNeAInserer= "1976-02-16"; 
        String adresseAInserer="2125 RueSM app1409";
        String telephoneAInserer="5145153176";
        String courrielAInserer="pacheco.luizgustavo@gmail.com";
        //in.insererUtilisateur(idUtilisateurAInserer,nomAInserer,preNomAInserer,dateNeAInserer,adresseAInserer,telephoneAInserer,courrielAInserer,dateRegistreAInserer);déjà fait
           
        //INSERER MOT DE PASSE==================================================OK
        String mdpEncripteAInserer = "123lgp";
        //in.insererMotDePAsse(idUtilisateurAInserer,mdpEncripteAInserer);déjà fait
        
        //INSERER RESERVATION===================================================
        //creer condition pour eviter conflit de date

        //in.insererReservation(0,"livre1", "Utilisateur", "2018-07-30", "annule");déjà fait
        //in.insererReservation(1,"livre1","NidhalAfrican","2018-08-01","fini");déjà fait
        //in.insererReservation(2,"livre", "NidhalAfrican", "2018-08-15", "fini");déjà fait
        //in.insererReservation(3,"livre1", "GustavoPach", "2018-08-16", "fini");déjà fait
        //in.insererReservation(4,"livre", "NidhalAfrican", "2018-08-29", "attente");déjà fait
        //in.insererReservation(5,"livre1","Utilisateur","2018-09-02","attente");déjà fait
        //tester la condition
        //in.insererReservation(6,"livre1","Utilisateur","2018-09-02","attente");

       //RESERVATION DE LIVRES=================================================OK
        
        int idReservation= 6;
        String idLivreReservation = "livre1";
        String idUtilisateurReservation = "GustavoPach";
        String datePrevueReservation = "2018-09-17";                                
        String statusRsReservation = "attente";
 
        //in.insererReservation(idReservation, idLivreReservation, idUtilisateurReservation, datePrevueReservation, statusRsReservation);        
        
        //HITORIQUES WEB ET ANDROID=============================================OK
        Historique historique = new Historique();
        //historique.chercherHistoriqueWeb();
        //historique.chercherHistoriqueAndroid(idUtilisateurEntree);
        
        //EMPRUNTS DE LIVRES====================================================OK
        //ATTENTION L'EMPRUNT NE PEUT PAS ÊTRE SUPPRIMÉ!!!!!!!!!!!!
        //in.insererEmprunt(3,"livre","NidhalAfrican","2018-08-30","2018-09-13","cours");déjà fait
	//in.insererEmprunt(4,"livre1","GustavoPach","2018-08-16","2018-09-01","cours");déjà fait
       
        int idEmpruntAEmprunter = 5; 
        int idDuLivreReserve = 6;//exemple en haut dans reservation de livres
        String idLivreAEmprunter = "livre1"; 
        String idUtilisateurAEmprunter = "Utilisateur"; 
        String dateEmpAEmprunter = "2018-09-02"; 
        String dateRenAEmprunter = addDays(dateEmpAEmprunter,14); 
        String statusEMAEmprunter = "cours";
        
        //pour emprunter sans reservation
        //in.insererEmprunt(idEmpruntAEmprunter,idLivreAEmprunter,idUtilisateurAEmprunter,dateEmpAEmprunter,dateRenAEmprunter,statusEMAEmprunter);
        
        //pour emprunter avec reservation
        //in.insererEmprunt(idEmpruntAEmprunter,idLivreAEmprunter,idUtilisateurAEmprunter,dateEmpAEmprunter,dateRenAEmprunter,statusEMAEmprunter);
        Emprunt emp = new Emprunt();
        //emp.emprunterChangeReservation(idDuLivreReserve);
        
        //pour retourner le livre
        //emp.retounerLivre(idEmpruntAEmprunter);

        //FIXER UN RENDEZ-VOUS==================================================OK
        //in.insererRendezVous(2,"livre","NidhalAfrican","2018-09-15","apresmidi","attente");déjà fait
        //pour annuler un rendez-vous
        RendezVousMethodes rvm = new RendezVousMethodes();
        //rvm.anuulerRendezVous(2);
        //pour changer l'horaire du rendez-vous
        //rvm.changerHoraireRendezVous(2, "2018-09-15", "matin");
        
        //RENOUVELLEMENT D'EMPRUNT DE LIVRE=====================================OK
        Renouvellement rn = new Renouvellement();
        Emprunts e = new Emprunts();

        e = rn.chercherLivreEmprunte("livre1", "NidhalAfrican");
        //System.out.println("Test prémier emprunt "+e.toString());

        int idEmpruntPremierEmprunt = e.getIdEmprunt();
        String idLivrePremierEmprunt = e.getIdLivre();
        String idUtilisateurPremierEmprunt = e.getIdUtilisateur();
        String dateEmp = e.getDateRen();
        String dateRen = addDays(dateEmp, 14);
        String statusEM = e.getStatusEM();
        
        //rn.insererRenouvellement(idEmpruntPremierEmprunt,idLivrePremierEmprunt,idUtilisateurPremierEmprunt,dateEmp,dateRen,statusEM);

        //TEST POUR CHANGER DATE================================================
        //System.out.println("Date de retour "+e.getDateRen());
        //System.out.println("Nouvelle date de retour "+addDays("2018-09-13", 14));
        
        //TEST DE COMPARAISON DE STRING=========================================
        String a= "2018-07-31";
        String b= "2018-07-14";

        //System.out.println(a.compareTo(b));
        //testerComparaison(a,b);
    }
    
        public static void testerComparaison(String a, String b){
                if(a.compareTo(b)==0){System.out.println("a==b");}
                else if(a.compareTo(b)<0){System.out.println("a<b");}
                  else{System.out.println("a>b");}
            } 

        public static String addDays(String date, Integer days){
                        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                        String result = "";
                        try {
                                Date df = sdf.parse(date);
                                GregorianCalendar calendar = new java.util.GregorianCalendar();
                                calendar.setTime(df);
                                calendar.add (Calendar.DAY_OF_MONTH, days);
                                result = sdf.format(calendar.getTime());
                        } catch (ParseException e) {
                                e.printStackTrace();
                        }
                        return result;
                }           
    
}