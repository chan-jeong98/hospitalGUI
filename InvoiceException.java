public class InvoiceException extends Exception{
   
   private String message;
   
   public void InvoiceException(){
   }
   
   public void setMessage(String message){
      this.message = message;
   }
   
   public String getMessage(){
      return this.message;
   }
}