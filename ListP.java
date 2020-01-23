/**
* @author: Chan Jeong
* LinkedList class for patients
*/

import java.io.*;
import java.text.*;
import java.util.*; 

public class ListP{
// instance variables
   private static int counter = 0;
   private static NodeP front = null;
   private static NodeP back = null;
   private static NodeP afterCurrent = null;
   private static NodeP current = null;
   
   // adds a patient to the list
   public void addPatient(Patient p){
      if (counter ==0){
         NodeP newNode = new NodeP(p);
         front = newNode;
         back = newNode;
         counter++;
      }
      else{
         NodeP newNode = new NodeP(p);
         back.setNext(newNode);
         back = back.getNext();
         counter++;
      }
   }
   
   // removes a patient from the list by name
   public void removePatient(String name){
      current = front;
      afterCurrent = front.getNext();
      
      if (current.getPatient().getName().trim().equalsIgnoreCase(name)){
         front = afterCurrent;
         current = null;
         counter--;
      }
      else {
         while (!afterCurrent.getPatient().getName().trim().equalsIgnoreCase(name)){
            afterCurrent = afterCurrent.getNext();
            current = current.getNext();
         }
         if (afterCurrent.getNext() == null){
            current.setNext(null);
            back = current;
            afterCurrent = null;
            counter--;
         }
         else{
            current.setNext(afterCurrent.getNext());
            afterCurrent = null;
            counter--;
         }
      }
   }
   
   // finds a patient by name and displays info on screen
   public NodeP findPatient (String name){
      NodeP current = front;
       
      while (!current.getPatient().getName().trim().equalsIgnoreCase(name)){
         current = current.getNext();
      }
      return current;
   }
   
   // lists all the patients    
   public ArrayList<String> printList(){
      NodeP current = front;
      ArrayList<String> wholelist = new ArrayList<String>();
      
      if(counter ==0){
         System.out.println("No items are on the list");
      }
      else {
         while (current != null){
            wholelist.add(current.toString());
            current = current.getNext();
         }         
      }
      return wholelist;
   }
   
   // lists all the patients without insurance
   public ArrayList<String> printNoInsurance(){
      NodeP current = front;
      ArrayList<String> noInsurance = new ArrayList<String>();
      
      if(counter ==0){
         System.out.println("No items are on the list");
      }
      else {
         while (current != null){
            if (current.getPatient().getCoverage() == 0){
               noInsurance.add(current.toString());
               current = current.getNext();
            }
            else {
               current = current.getNext();
            }
         }
      }
      return noInsurance;
   }
   
   // lists all patients that owe more than a given amount
   public ArrayList<String> printOweAmount(double t){
      NodeP current = front;
      ArrayList<String> oweAmount = new ArrayList<String>();
      
      if (counter ==0){
         System.out.println("No items are on the list");
      }
      else {
         while (current != null){
            if (current.getPatient().getTotal() > t){
               oweAmount.add(current.toString());
               current = current.getNext();
            }
            else {
               current = current.getNext();
            }
         }
      }
      return oweAmount;
   }
   
   // outputs size of linked list
   public int listSize(){
      return counter;
   }
}