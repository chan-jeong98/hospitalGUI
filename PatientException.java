/**
* PatientException --- exception class for patient class
* @author Chan Jeong
*/
public class PatientException extends Exception{
   
   private String message = "";
   //constructor
   public void PatientException(){
   }
   // set message for exception
   public void setMessage(String message){
      this.message = message;
   }
   // get exception message
   public String getMessage(){
      return this.message;
   }
}