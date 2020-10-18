public class IndexRecord{
   private String key;
   private int where;

   public IndexRecord(String key, int where){
       this.key = key;
       this.where = where;
   }

   public String getKey(){
       return key;
   }

   public int getWhere(){
       return where;
   }

   public String toString(){
       return key + " " + where;
   }
}
