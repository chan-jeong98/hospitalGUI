/**
* SecondFrame --- pop-up GUI for hospital interface
* @author Chan Jeong
*/

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class SecondFrame extends JFrame implements ActionListener{
   // instance variables
   private final int WIDTH = 600;
   private final int HEIGHT = 300;
   private JLabel insLabel = new JLabel("");
   private TextField inputText = new TextField(100);
   private JButton enterName = new JButton(" Enter ");
   private JButton enterTriage = new JButton(" Enter ");
   private JButton enterCoverage = new JButton(" Enter ");
   private JButton enterTotal = new JButton(" Enter ");
   ListP newList = new ListP();
   
   // constructor
   public SecondFrame() {
      this.setExtendedState(this.MAXIMIZED_BOTH);
      this.setTitle("");
      this.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
      this.setVisible(true);
   }
   // adds patient object to linked list
   public void addPatient (){
      Patient newPatient = new Patient();
      JPanel secondPanel = new JPanel();
      secondPanel.setLayout(new BorderLayout());
      
      this.add(secondPanel);               
      secondPanel.add("North", insLabel);
      secondPanel.add("Center", inputText);
      
      insLabel.setText("Please input the patient name (must be at least 5 characters long)");
      secondPanel.add("East", enterName);

      enterName.addActionListener(new ActionListener()
      {   
         public void actionPerformed (ActionEvent e){
            try {                    
               newPatient.setName(inputText.getText());
               insLabel.setText("Please input the triage (between 1-5)");
               inputText.setText("");
               secondPanel.remove(enterName);
               secondPanel.add("East",enterTriage);
            }
            catch (Exception E){              
               JOptionPane.showMessageDialog(new JFrame(),
                     "The name has to be 5 characters or more",
                     "Error message",
                     JOptionPane.ERROR_MESSAGE);
            }  
         }
      }); 
      enterTriage.addActionListener(new ActionListener()
      {
         public void actionPerformed (ActionEvent e){
            try {
               newPatient.setTriage(Integer.parseInt(inputText.getText()));
               insLabel.setText("Please input percent of coverage (between 0 and 100)");
               inputText.setText("");
               secondPanel.remove(enterTriage);
               secondPanel.add("East", enterCoverage);
            }
            catch (Exception E){
               JOptionPane.showMessageDialog(new JFrame(),
                        "The number has to be between 1-5",
                        "Error message",
                        JOptionPane.ERROR_MESSAGE);        
            }
         }
      });
      enterCoverage.addActionListener(new ActionListener()
      {
         public void actionPerformed (ActionEvent e){
            try {
               newPatient.setCoverage(Integer.parseInt(inputText.getText()));
               insLabel.setText("Please input the amount owed to the hospital");
               inputText.setText("");
               secondPanel.remove(enterCoverage);
               secondPanel.add("East", enterTotal);
            }
            catch (Exception E){
               JOptionPane.showMessageDialog(new JFrame(),
                     "The number needs to be between 0-100",
                     "Error message",
                     JOptionPane.ERROR_MESSAGE);     
            }
         }
      });
      enterTotal.addActionListener(new ActionListener()
      {
         public void actionPerformed (ActionEvent e){
            try {
               newPatient.setTotal(Double.parseDouble(inputText.getText()));               
               newList.addPatient(newPatient);
               insLabel.setText("The patient has been added. Please close the window");
               inputText.setText("");
               secondPanel.remove(enterTotal);
               secondPanel.remove(inputText);
            }
            catch (Exception E){
               JOptionPane.showMessageDialog(new JFrame(),
                     "The number cannot be negative",
                     "Error message",
                     JOptionPane.ERROR_MESSAGE);                    
            }
         }
      });       
   }
   // removes patient from linked list
   public void removePatient() {
      JPanel secondPanel = new JPanel();
      secondPanel.setLayout(new BorderLayout());
      
      this.add(secondPanel);               
      secondPanel.add("North", insLabel);
      secondPanel.add("Center", inputText);
      
      insLabel.setText("Please input the patient name to be removed");
      secondPanel.add("East", enterName);
      
      enterName.addActionListener(new ActionListener()
      {   
         public void actionPerformed (ActionEvent e){
            try {                    
               newList.removePatient(inputText.getText());
               insLabel.setText("That patient was deleted, please close the window");
               inputText.setText("");
               secondPanel.remove(enterName);
               secondPanel.remove(inputText);
            }
            catch (Exception E){
               JOptionPane.showMessageDialog(new JFrame(),
                     "That patient was not found",
                     "Error message",
                     JOptionPane.ERROR_MESSAGE);     
            }  
         }
      });
   }
   // finds patient from linked list
   public void findPatient() {
      JPanel secondPanel = new JPanel();
      secondPanel.setLayout(new BorderLayout());
      
      this.add(secondPanel);               
      secondPanel.add("North", insLabel);
      secondPanel.add("Center", inputText);
      
      insLabel.setText("Please input the patient name for their information");
      secondPanel.add("East", enterName);
      
      enterName.addActionListener(new ActionListener()
      {   
         public void actionPerformed (ActionEvent e) {
            try {
               newList.findPatient(inputText.getText());         
               JLabel line1 = new JLabel("  This is the patient information requested:");
               JLabel line2 = new JLabel("  Name: " + newList.findPatient(inputText.getText()).getPatient().getName());
               JLabel line3 = new JLabel("  Urgency of visit (1 = urgent, 5 = routine): " + newList.findPatient(inputText.getText()).getPatient().getTriage());
               JLabel line4 = new JLabel("  Percent of bill covered by insurance: " + newList.findPatient(inputText.getText()).getPatient().getCoverage());
               JLabel line5 = new JLabel("  Amount owed to hospital before insurance: " + newList.findPatient(inputText.getText()).getPatient().getFormatTotal());
               
               secondPanel.remove(insLabel);
               secondPanel.remove(enterName);
               secondPanel.remove(inputText);               
               secondPanel.setLayout(new GridLayout(5,1));
               secondPanel.add(line1);
               secondPanel.add(line2);
               secondPanel.add(line3);
               secondPanel.add(line4);
               secondPanel.add(line5);
               secondPanel.validate();
               secondPanel.repaint();               
            }
            catch (Exception E){
               JOptionPane.showMessageDialog(new JFrame(),
                     "That patient was not found",
                     "Error message",
                     JOptionPane.ERROR_MESSAGE);      
            }  
         }
      }); 
   }
   // prints patients from linked list
   public void printList(){
      JPanel secondPanel = new JPanel();
      secondPanel.setLayout(new BorderLayout());
      
      this.add(secondPanel);
      TextArea outputText = new TextArea(1, 100);
      secondPanel.add("Center", outputText);
      
      String listString = String.join("\n", newList.printList());
      outputText.setText(listString);
   }
   // prints patients without insurance from linked list
   public void printNoInsurance(){
      JPanel secondPanel = new JPanel();
      secondPanel.setLayout(new BorderLayout());
      
      this.add(secondPanel);
      TextArea outputText = new TextArea(1, 100);
      secondPanel.add("Center", outputText);
      
      String noInsuranceString = String.join("\n", newList.printNoInsurance());
      outputText.setText(noInsuranceString);
   }
   // prints patients that owe more than a certain amount
   public void printOweAmount(){
      JPanel secondPanel = new JPanel();
      secondPanel.setLayout(new BorderLayout());
      JPanel doublePanel = new JPanel();      
      
      this.add(secondPanel);
      TextArea outputText = new TextArea(1, 100);
      doublePanel.add(inputText);
      inputText.setText("Put amount owed to hospital here");
      doublePanel.add(enterTotal);
      secondPanel.add("North", doublePanel);
      secondPanel.add("Center", outputText);
      enterTotal.addActionListener(new ActionListener()
      {
         public void actionPerformed (ActionEvent e){
            try {
               String oweAmountString = String.join("\n", newList.printOweAmount(Double.parseDouble(inputText.getText())));
               outputText.setText(oweAmountString);              
               inputText.setText("");
               secondPanel.remove(enterTotal);
               secondPanel.remove(inputText);
            }
            catch (Exception E){
               JOptionPane.showMessageDialog(new JFrame(),
                     "The number cannot be negative",
                     "Error message",
                     JOptionPane.ERROR_MESSAGE);
            }
         }
      });      
   }
   // method implemented from actionlistener class         
   public void actionPerformed (ActionEvent e) {
   }
            
}   