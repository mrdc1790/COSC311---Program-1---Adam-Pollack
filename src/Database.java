import java.io.*;
import java.util.Scanner;

public class Database {
   private DatabaseRecord[] myDB;
   private IndexArray ID, First, Last;
   private int next;

   private final Scanner scnr;

   public Database() {
       this(new Scanner(System.in));
   }

   public Database(Scanner scnr) {
       this.scnr = scnr;
       next = 0;
       myDB = new DatabaseRecord[100];
       ID = new IndexArray(100);
       First = new IndexArray(100);
       Last = new IndexArray(100);

       try {
           File myObj = new File("dataset.txt");
           Scanner file = new Scanner(myObj);
           while (file.hasNextLine()) {
               String[] data = file.nextLine().split(" ");
               this.addRecord(data[2], data[1], data[0]);
           }
           file.close();
       } catch (FileNotFoundException e) {
           System.out.println("An error has occurred.");
           e.printStackTrace();
       }
   }

   public void addIt() {
       System.out.println("Please enter the ID of the record.");
       if (!scnr.hasNext()) return;
       String id1 = scnr.next();
       if (this.ID.search(id1) == -1) {
           System.out.println("Please enter both first and last name: ");
           if (!scnr.hasNext()) return;
           String firstName = scnr.next();
           if (!scnr.hasNext()) return;
           this.addRecord(id1, firstName, scnr.next());
       } else {
           System.out.println("ID has already been taken. Please enter another.");
       }
   }

   private void addRecord(String cID, String cFirst, String cLast) {
       if (this.ID.search(cID) >= 0) {
           System.out.println("ID entered has already been used.");
           return;
       }
       if (next >= myDB.length) {
           System.out.println("The database has no room for another record.");
           return;
       }
       cFirst = cFirst.toUpperCase();
       cLast = cLast.toUpperCase();
       this.ID.insert(new IndexRecord(cID, next));
       this.First.insert(new IndexRecord(cFirst, next));
       this.Last.insert(new IndexRecord(cLast, next));
       myDB[next++] = new DatabaseRecord(cID, cFirst, cLast);
   }

   public void deleteIt() {
       System.out.println("Please enter the ID of the record.");
       if (!scnr.hasNext()) return;
       String id1 = scnr.next();
       int whereRec = ID.search(id1);
       if (whereRec >= 0) {
           ID.delete(id1);
           Last.deleteByRecord(whereRec);
           First.deleteByRecord(whereRec);
           System.out.println("Record has been deleted.");
       } else {
           System.out.println("Record has not been found.");
       }
   }

   public void findIt() {
       System.out.println("Please enter the ID of the record.");
       if (!scnr.hasNext()) return;
       String id1 = scnr.next();
       int answer = ID.search(id1);
       if (answer >= 0) {
           System.out.println(myDB[answer]);
       } else {
           System.out.println("Searched ID not found");
       }
   }

   public void ListByIDAscending() {
       ID.iteratorInitFront();
       while (ID.hasNext()) {
           String DatabaseRecord = myDB[ID.getNext()].toString();
           System.out.println(DatabaseRecord);
       }
   }

   public void ListByFirstAscending() {
       First.iteratorInitFront();
       while (First.hasNext()) {
           String DatabaseRecord = myDB[First.getNext()].toString();
           System.out.println(DatabaseRecord);
       }
   }

   public void ListByLastAscending() {
       Last.iteratorInitFront();
       while (Last.hasNext()) {
           String DatabaseRecord = myDB[Last.getNext()].toString();
           System.out.println(DatabaseRecord);
       }
   }

   public void ListByIDDescending() {
       ID.iteratorInitBack();
       while (ID.hasPrevious()) {
           String DatabaseRecord = myDB[ID.getPrevious()].toString();
           System.out.println(DatabaseRecord);
       }
   }

   public void ListByFirstDescending() {
       First.iteratorInitBack();
       while (First.hasPrevious()) {
           String DatabaseRecord = myDB[First.getPrevious()].toString();
           System.out.println(DatabaseRecord);
       }
   }

   public void ListByLastDescending() {
       Last.iteratorInitBack();
       while (Last.hasPrevious()) {
           String DatabaseRecord = myDB[Last.getPrevious()].toString();
           System.out.println(DatabaseRecord);
       }
   }
}
