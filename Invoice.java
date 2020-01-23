import java.util.*;
import java.text.*;

public class Invoice{

   private int invoiceNumber = 0;
   private double total = 0;
   private String customer = "";
    
   public void setInvoiceNumber (int invoiceNumber)throws Exception{
      if (invoiceNumber >= 100 && invoiceNumber <= 20000){
         this.invoiceNumber = invoiceNumber;
      }
      
      else{
         InvoiceException iNum = new InvoiceException();
         iNum.setMessage("The invoice number is out of boundaries (100-20000).");
         throw(iNum);
      }   
   }
   
   public void setTotal (double total)throws Exception{
      if (total < 0){
         InvoiceException iTotal = new InvoiceException();
         iTotal.setMessage("The value of total cannot be negative.");
         throw(iTotal);
      }
      else{
         this.total = total;
      }
   }
   
   public void setCustomer (String customer)throws Exception{
      if (customer.length()<4){
         InvoiceException iCustomer = new InvoiceException();
         iCustomer.setMessage("This name is too short.");
         throw(iCustomer);
      }
      else{
         this.customer = customer;
      }
   }
   
   public int getInvoiceNumber(){
      return invoiceNumber;
   }
   
   public double getTotal(){
      return total;
   }
   
   public String getCustomer(){
      return customer;
   }
   
   public Invoice(int invoiceNumber, double total, String customer)throws Exception{
      setInvoiceNumber(invoiceNumber);
      setTotal(total);
      setCustomer(customer);
      
      getInvoiceNumber();
      getTotal();
      getCustomer();
   }
   
   public String toString() {
     
     DecimalFormat formatter = new DecimalFormat("$###,###.##");
     String formatTotal = formatter.format(total);
      
     String spacer = "---------------------------";
     String resultInvoiceNumber = "Invoice number: " + this.invoiceNumber;
     String resultCustomer = "Customer: " + this.customer;
     String resultTotal = "Total: " + formatTotal;
     String together = spacer + "\n\n" + resultInvoiceNumber + "\n\n" + resultCustomer + "\n\n" + resultTotal + "\n\n" + spacer;
     return together;
   }
}