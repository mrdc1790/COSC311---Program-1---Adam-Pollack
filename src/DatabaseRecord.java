public class DatabaseRecord {
   private String id;
   private String firstName;
   private String lastName;

   //Parameterized constructor
   public DatabaseRecord(String id, String firstName, String lastName) {
       this.id = id;
       this.firstName = firstName;
       this.lastName = lastName;
   }

   //toString method
   public String toString() {
       return id + " " + firstName + " " + lastName;
   }
}
