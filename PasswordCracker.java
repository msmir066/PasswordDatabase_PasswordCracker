

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;


public class PasswordCracker {
 
public void createDatabase(ArrayList<String> Commonpwd, DatabaseInterface base_de_donnees)   {
  
  ArrayList<String> Passwordsaugmented = new ArrayList<String>(Commonpwd);
  
  for(String mdp  : Commonpwd) {
   // On met la premiere lettre en majuscule
   if (mdp.matches(".*[a-z].*")) {  
    String majuscule =mdp.substring(0, 1).toUpperCase() + mdp.substring(1);
    Passwordsaugmented.add(majuscule);
   }
   // On remplace le i par 1
   
   String remplacer_I = mdp.replaceAll("i", "1");
   Passwordsaugmented.add(remplacer_I);
   //On remplace le a par @
   String remplacer_A = mdp.replaceAll("a", "@"); 
   Passwordsaugmented.add(remplacer_A);
   //On remplace le e par 3
   String remplacer_e = mdp.replaceAll("e", "3");
   Passwordsaugmented.add(remplacer_e) ;
   //On ajoute l'annee a la fin de chaque mot de passe
   String year = mdp + "2018"; 
   Passwordsaugmented.add(year); 
  }
for(String mdp : Passwordsaugmented ) {

   String encryptedPwd;
   try { 
    encryptedPwd = Sha1.hash(mdp);
    base_de_donnees.save(mdp, encryptedPwd);
    
   } catch (UnsupportedEncodingException e) {
    
    e.printStackTrace();
   }
   

 
  }

 }
 public String crackPassword(String Passwordenc, DatabaseInterface base_de_donnees) { 
  if (base_de_donnees.decrypt(Passwordenc) == null) {
   return "";
  } 
  return base_de_donnees.decrypt(Passwordenc);
 }
 

}