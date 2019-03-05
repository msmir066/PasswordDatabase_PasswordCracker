
import java.util.HashMap;


public class DatabaseStandard implements DatabaseInterface {
 
 private java.util.HashMap<String, String> map; 
 
 public DatabaseStandard() {
  this.map= new HashMap<String, String>();
  
 }

 public String save(String pwd, String encrypted) {
  
  String previous = map.get(encrypted);
  map.put(encrypted, pwd);
  return previous;
 }

 public int size() {
  
  return map.size();
  
 }
 public void printStatistics() {
   size(); 
  
 }
 public String decrypt(String encrypted) { 
  return map.get(encrypted);
 }


}