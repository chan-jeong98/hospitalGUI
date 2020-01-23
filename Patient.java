/**
* Patient --- creates patient object
* @author Chan Jeong
*/

import java.util.*;
import java.text.*;

public class Patient{

   private String name = "";
   private int triage = 0;
   private int coverage = 0;
   private double total = 0;
   // blank constructor for object initialization in GUI
   public Patient (){
   }
   // constructor that takes parameters in order
   public Patient (String name, int triage, int coverage, double total)throws PatientException{
      this.setName(name);
      this.setTriage(triage);
      this.setCoverage(coverage);
      this.setTotal(total);
   }
   // set method for patient name   
   public void setName (String name) throws PatientException{
      if (name.trim().length()<5){
         PatientException eName = new PatientException();
         eName.setMessage("Name must be at least 5 characters long");
         throw(eName);
      }
      else{
         this.name = name;
      }
   }
   // set method for patient triage
   public void setTriage (int triage) throws PatientException{
      if (triage >= 1 && triage <= 5){
         this.triage = triage;
      }
      else {
         PatientException eTriage = new PatientException();
         eTriage.setMessage("This number is out of bounds, must be between 1 and 5. 1 is an extremely urgent visit, and 5 is a routine visit");
         throw(eTriage);
      }
   }
   //set method for patient coverage
   public void setCoverage (int coverage) throws PatientException{
      if (coverage >=0 && coverage <= 100){
         this.coverage = coverage;
      }
      else {
         PatientException eCoverage = new PatientException();
         eCoverage.setMessage("This is not a valid percent, must be between 0 and 100.");
         throw(eCoverage);
      }
   }
   // set method for patient total
   public void setTotal (double total) throws PatientException {
      if (total < 0){
         PatientException eTotal = new PatientException();
         eTotal.setMessage("The amount owed to the hospital cannot be negative.");
         throw(eTotal);
      }
      else {
         this.total = total;
      }
   }
   // get method for patient name
   public String getName (){
      return name;
   }
   // get method for patient triage
   public int getTriage (){
      return triage;
   }
   // get method for patient coverage
   public int getCoverage (){
      return coverage;
   }
   // get method for patient total
   public double getTotal (){      
      return total;
   }
   // get method for total formatted
   public String getFormatTotal (){
      DecimalFormat formatter = new DecimalFormat("$###,###.00");
      String formatTotal = formatter.format(total);
      return formatTotal;  
   }
   // toString method to return patient object data as a string
   public String toString (){
   
      DecimalFormat formatter = new DecimalFormat("$###,###.00");
      String formatTotal = formatter.format(total);
      
      String spacer = "--------------------";
      String printName = "Name: " + this.name;
      String printTriage = "Urgency of visit (1 = urgent, 5 = routine): " + this.triage;
      String printCoverage = "Percent of bill covered by insurance: " + this.coverage;
      String printTotal = "Amount owed to hospital before insurance: " + formatTotal;
      String combined = spacer + "\n\n" + printName + "\n\n" + printTriage + "\n\n" + printCoverage + "\n\n" + printTotal + "\n\n" + spacer;
      return combined;
   }
}