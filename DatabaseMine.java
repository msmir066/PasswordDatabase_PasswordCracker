
public class DatabaseMine implements DatabaseInterface {
 //source d'une partie du code http://www.cs.rmit.edu.au/online/blackboard/chapter/05/documents/contribute/chapter/05/documents/Hashtest.java
 
 private Hash[] table ;
 int elem; 
 class Hash
    {  
       private String cle;
       private String data;
       private boolean deleted;

       Hash(String cle, String data)
       {
          this.cle=cle;
          this.data = data;
          deleted = false;
       }

       public void setDeleted()
       {
          deleted = true;
       }
       
       public boolean isDeleted()
       {
          return deleted;
       }
       
       public String getcle()
       {
          return cle;
       }
       
       public String getData()
       {
          return data;
       }
    }
 
 
 public DatabaseMine() {
  
  this.table = new Hash[elem];
 }
 
 public int size() {
  
  return table.length;
 }
 
 public String save(String encrypted,String pwd ) {
  String prev = recuperation(encrypted);
  add(encrypted, pwd);
  return prev;

 }

 
 public String decrypt(String encrypted) {
  return recuperation(encrypted);
 }

 
 
 public int hashfunction(String cle) {
  int address=cle.hashCode()%elem;
  return (address>=0)?address:(address+elem);
  
  
 }
 public boolean add(String cle, String data)
    {
   
       int n;
       
     
       int code = hashfunction(cle);
       
      
       if ((table[code] == null) || table[code].isDeleted())
       {
          table[code] = new Hash(cle, data);
          n = -1;
       }
      
       else
       {
          
          if (code == (table.length - 1) )
             n= 0;
          else
             n= code + 1;
       }
       
    
     
       while ((n!= -1) && (n!= code))
       {
       
          if ((table[n] == null) || table[n].isDeleted())
          {
            
             table[n] = new Hash(cle, data);
             n= -1;
          }
        
          else
          {
             if (n== (table.length -1) )
                n= 0;
             else
                n++;
          }
       }
    
      
       if (n!= -1)
          return false;
       else
          return true;
    }
 
 
    public String recuperation(String cle)
    {
       
       int n;
       
       
       int code = hashfunction(cle);
       
    
       if (table[code] == null)
          return null;
       
       else if (table[code].getcle().equals(cle))
          return table[code].getData();
       
       else
       {
         
          if (code == (table.length - 1) )
             n= 0;
          else
             n= code + 1;
       }
       
      
       while ((n!= -1) && (n!= code))
       {
         
          if (table[n] == null)
             return null;
    
          else if (table[n].getcle().equals(cle))
          {
            
             return table[n].getData();
          }
        
          else
          {
             if (n == (table.length - 1) )
                n= 0;
             else
                n++;
          }
       }
    
       return null;
    }

    
    
 
    
 public void printStatistics() {
    size();
 }
 
}
