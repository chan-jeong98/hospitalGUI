/**
* NodeP --- node class for linked list
* @author Chan Jeong
*/
public class NodeP{
   
   //instance variables
   private Patient patient = null;
   private NodeP next = null;
   
   //Constructors
   public NodeP(Patient p){
      this.setPatient(p);
      this.next = null;
   }
   
   public NodeP(Patient p, NodeP next){
      this.setPatient(p);
      this.next = next;
   }
   
   //get method for reference node
   public NodeP getNext(){
      return this.next;
   }
   
   //get method for patient data
   public Patient getPatient(){
      return this.patient;
   }
   
   // set method for reference node
   public void setNext(NodeP next){
      this.next = next;
   }
   
   // set method for patient data
   public void setPatient(Patient newPatient){
      this.patient = newPatient;
   }
   
   // toString method to print patient data
   public String toString(){
      String s = this.getPatient().toString();
      return s;
   }
}