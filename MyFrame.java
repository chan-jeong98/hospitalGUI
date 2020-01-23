/**
* MyFrame --- creates GUI for hospital interface
* @author Chan Jeong
*/

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MyFrame extends JFrame{
   // instance variables
   private final int WIDTH = 600;
   private final int HEIGHT = 300;
   private JLabel welcomeLabel = new JLabel("Welcome to the hospital interface!");
   private JLabel insLabel = new JLabel("");
   private JButton run = new JButton(" Run ");
   private TextField inputText = new TextField(100);
   private String[] options = {"Please select an option", "Add a patient", "Remove a patient", "Find a patient", "List all patients", "List all patients without insurance", "List all patients that owe more than a given amount"};
   private JComboBox<String> choices = new JComboBox<String>(options);
   public int choiceNum = 0;
   // constructor
   public MyFrame(){
      this.setExtendedState(this.MAXIMIZED_BOTH);
      this.setTitle("Hospital Interface");
      this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      this.setVisible(true);
   }
   // initializes GUI
   public void initializeGUI(){
      ActionListener ears1 = new MyAListener();
      ItemListener ears2 = new MyIListener();
      run.addActionListener(ears1);
      choices.addItemListener(ears2);
            
      JPanel panelMain = new JPanel();
      panelMain.setBackground(Color.white);
      panelMain.setLayout(new BorderLayout());
      
      JPanel welcomePanel = new JPanel();
      welcomePanel.setBackground(Color.white);
      welcomePanel.add(welcomeLabel);
      
      JPanel choicePanel = new JPanel();
      choicePanel.setBackground(Color.white);
      choicePanel.add(choices);
      choicePanel.add(run);
               
      this.add(panelMain);
      panelMain.add("North", welcomePanel);
      panelMain.add("Center", choicePanel);
   }
   // actionlistener innerclass
   private class MyAListener implements ActionListener {
      public void actionPerformed(ActionEvent e){

         if(e.getSource()==run){
            if (choiceNum == 0){
               JOptionPane.showMessageDialog(new JFrame(),
                     "You need to choose an option!",
                     "Error message",
                     JOptionPane.ERROR_MESSAGE);
            }
            else if (choiceNum == 1){
               SecondFrame secondFrame = new SecondFrame();
               secondFrame.addPatient();               
            }
            else if (choiceNum == 2){
               SecondFrame secondFrame = new SecondFrame();
               secondFrame.removePatient();
            }
            else if (choiceNum == 3){
               SecondFrame secondFrame = new SecondFrame();
               secondFrame.findPatient();
            }
            else if (choiceNum == 4){
               SecondFrame secondFrame = new SecondFrame();
               secondFrame.printList();
            }
            else if (choiceNum == 5){
               SecondFrame secondFrame = new SecondFrame();
               secondFrame.printNoInsurance();
            }
            else if (choiceNum == 6){
               SecondFrame secondFrame = new SecondFrame();
               secondFrame.printOweAmount();
            }                     
         }
      }                        
   }
   // itemlistener inner class
   private class MyIListener implements ItemListener {
      public void itemStateChanged(ItemEvent e){
         if(e.getSource() == choices){
            if (choices.getSelectedIndex() == 0){
               choiceNum = 0;
            }
            else if (choices.getSelectedIndex() == 1){
               choiceNum = 1;
            }
            else if (choices.getSelectedIndex() == 2){
               choiceNum = 2;
            }
            else if (choices.getSelectedIndex() == 3){
               choiceNum = 3;
            }
            else if (choices.getSelectedIndex() == 4){
               choiceNum = 4;
            }
            else if (choices.getSelectedIndex() == 5){
               choiceNum = 5;
            }
            else if (choices.getSelectedIndex() == 6){
               choiceNum = 6;
            }
         }
      }
   }
}