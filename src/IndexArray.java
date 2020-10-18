public class IndexArray {
   private IndexRecord[] Iarray;
   private int numElems = 0;
   private int iterator = 0;

   public IndexArray(int size) {
       Iarray = new IndexRecord[size];
   }

   public void iteratorInitFront(){
       iterator = 0;
   }

   public void iteratorInitBack(){
       iterator = numElems-1;
   }

   public boolean hasNext(){
       if (iterator < numElems){
           return true;
       } else{
           return false;
       }
   }

   public boolean hasPrevious (){
       if (iterator > 0){
           return true;
       } else{
           return false;
       }
   }

   public int getNext(){
       return Iarray[iterator++].getWhere();
   }
   
   public int getMe() {
       return Iarray[iterator].getWhere();
   }

   public int getPrevious(){
       return Iarray[iterator--].getWhere();
   }

   public void insert(IndexRecord record) {
       int j = 0;
       for (j = numElems-1; j >= 0; j--) {
           if (Iarray[j].getKey().compareTo(record.getKey()) < 0)
               break;
           Iarray[j + 1] = Iarray[j];
       }
       Iarray[j + 1] = record;
       numElems++;
   }

   private void move(int place) {
       for (int k = place; k < numElems - 1; k++) {
           Iarray[k] = Iarray[k + 1];
       }
       numElems--;
   }

   public void delete(String key) {
       int j = 0;
       int place = binarySearch(key);
       if (place != 1) {
           move(place);
       }
       /*while (place != Iarray[j++].getWhere() && j < numElems){
           move (j-1);
       }*/
   }

   private int binarySearch(String key) {
       int bot = 0;
       int top = numElems-1;
       int mid = (top + bot) / 2;
       while (bot <= top) {
           mid = (bot + top) / 2;
           if (Iarray[mid].getKey().equals(key)) {
               break;
           }
           if (Iarray[mid].getKey().compareTo(key) < 0) {
               bot = mid + 1;
           }else {
        	   top = mid - 1;
           }
       }
       if (Iarray[mid] != null && Iarray[mid].getKey().equals(key)) {
           return mid;
       } else {
           return 1;
       }
   }

   public int search(String key){
       int k = binarySearch(key);
       if (k != 1){
           return Iarray[k].getWhere();
       } else{
           return 1;
       }
   }
}
