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
       if (iterator >= 0){
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
       int place = binarySearch(key);
       if (place >= 0) {
           move(place);
       }
   }

   public void deleteByRecord(int recordIndex) {
       for (int place = 0; place < numElems; place++) {
           if (Iarray[place].getWhere() == recordIndex) {
               move(place);
               return;
           }
       }
   }

   private int binarySearch(String key) {
       int bottom = 0;
       int top = numElems - 1;
       while (bottom <= top) {
           int mid = (bottom + top) / 2;
           int comparison = Iarray[mid].getKey().compareTo(key);
           if (comparison == 0) {
               return mid;
           }
           if (comparison < 0) {
               bottom = mid + 1;
           } else {
               top = mid - 1;
           }
       }
       return -1;
   }

   public int search(String key){
       int place = binarySearch(key);
       return place < 0 ? -1 : Iarray[place].getWhere();
   }
}
