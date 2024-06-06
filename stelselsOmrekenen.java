import java.awt.*;
import java.awt.event.*;
import java.applet.Applet;

/**
  *
  * Description
  * Aantal keren ; vergeten: 2
  *
  * @version 1.0 from 31/05/2024
  *
  * Jarno Kaptein
  * Joris Blackstone
  *
  * Uw beste leerlingen
  */

public class stelselsOmrekenen extends Applet {
  // start attributes
  private Label titelLabel = new Label();
  private NumberField inputField = new NumberField();
  private Button submitButtonDS = new Button();
  private Label outputLabel = new Label();
  private Label label1 = new Label();
  private Label label2 = new Label();
  private NumberField stelselInputDS = new NumberField();
  private Label titelLabel1 = new Label();
  private Label label3 = new Label();
  private Label label4 = new Label();
  private NumberField stelselGetalInputField = new NumberField();
  private NumberField stelselInputSD = new NumberField();
  private Button submitButtonSD = new Button();
  private Label outputLabel1 = new Label();
  // end attributes
  
  public void init() {
    Panel cp = new Panel(null);
    cp.setBounds(0, 0, 599, 300);
    add(cp);
    // start components
    
    titelLabel.setBounds(8, 8, 277, 41);
    titelLabel.setText("Decimaal naar stelsel");
    titelLabel.setAlignment(Label.CENTER);
    titelLabel.setFont(new Font("Consolas", Font.PLAIN, 24));
    titelLabel.setBackground(Color.WHITE);
    cp.add(titelLabel);
    inputField.setBounds(168, 64, 105, 33);
    inputField.setText("");
    cp.add(inputField);
    submitButtonDS.setBounds(104, 160, 89, 25);
    submitButtonDS.setLabel("Reken om");
    submitButtonDS.addActionListener(new ActionListener() { 
      public void actionPerformed(ActionEvent evt) { 
        submitButtonDS_ActionPerformed(evt);
      }
    });
    cp.add(submitButtonDS);
    
    outputLabel.setBounds(8, 192, 275, 57);
    outputLabel.setText("");    
    outputLabel.setFont(new Font("Consolas", Font.PLAIN, 12)); 
    outputLabel.setBackground(Color.WHITE);
    cp.add(outputLabel);
    
    label1.setBounds(8, 64, 155, 33);
    label1.setText("Decimaal getal:");
    label1.setBackground(Color.WHITE);
    cp.add(label1);
    
    label2.setBounds(8, 112, 156, 33);
    label2.setText("Naar welk stelsel?");
    label2.setBackground(Color.WHITE);
    cp.add(label2);
    
    stelselInputDS.setBounds(168, 112, 33, 33);
    stelselInputDS.setText("");
    stelselInputDS.setSelectionStart(2);
    stelselInputDS.setSelectionEnd(9);
    cp.add(stelselInputDS);
    titelLabel1.setBounds(296, 8, 277, 41);
    titelLabel1.setText("Stelsel naar decimaal");
    titelLabel1.setAlignment(Label.CENTER);
    titelLabel1.setFont(new Font("Consolas", Font.PLAIN, 24));
    titelLabel1.setBackground(Color.WHITE);
    cp.add(titelLabel1);
    label3.setBounds(296, 64, 155, 33);
    label3.setText("Stelsel getal:");
    label3.setBackground(Color.WHITE);
    cp.add(label3);
    label4.setBounds(295, 112, 156, 33);
    label4.setText("Van welk stelsel?");
    label4.setBackground(Color.WHITE);
    cp.add(label4);
    stelselGetalInputField.setBounds(464, 64, 105, 33);
    stelselGetalInputField.setText("");
    cp.add(stelselGetalInputField);
    stelselInputSD.setBounds(464, 112, 33, 33);
    stelselInputSD.setText("");
    stelselInputSD.setSelectionEnd(9);
    stelselInputSD.setSelectionStart(2);
    cp.add(stelselInputSD);
    submitButtonSD.setBounds(392, 160, 89, 25);
    submitButtonSD.setLabel("Reken om");
    submitButtonSD.addActionListener(new ActionListener() { 
      public void actionPerformed(ActionEvent evt) { 
        submitButtonSD_ActionPerformed(evt);
      }
    });
    cp.add(submitButtonSD);
    outputLabel1.setBounds(296, 192, 275, 57);
    outputLabel1.setText("");
    outputLabel1.setFont(new Font("Consolas", Font.PLAIN, 12));
    outputLabel1.setBackground(Color.WHITE);
    cp.add(outputLabel1);
    cp.setBackground(new Color(0xC0C0C0));
    // end components
    
  } // end of init
  
  // start methods
  public void submitButtonDS_ActionPerformed(ActionEvent evt) {
    // DECIMAAL NAAR STELSEL  
    
    int decimaalGetalInput = 0;
    int stelsel = 0;
    
    decimaalGetalInput = inputField.getInt();
    stelsel = stelselInputDS.getInt();    
    
    // Van decimaal naar stelsel x:
    //Delen door x
    //Rest van x opslaan
    
    // TODO: Check sum (geen inputs, stelsel > 9, stelsel < 2
    
    if (stelsel<2) {
      outputLabel.setText("Vul een geldig stelsel tussen 2 en 9 in");
    } else if (stelsel>9) {
      outputLabel.setText("Vul een geldig stelsel tussen 2 en 9 in"); 
    } else {
      int rest;
      String getalOutput = "";
      
      while (decimaalGetalInput > 0) {
        rest = decimaalGetalInput % stelsel;             // Slaat de rest na een deling van het aantal tallig stelsel op als variabel
        getalOutput = rest + getalOutput;                // Voegt de rest toe aan de output string
        decimaalGetalInput /= stelsel;                   //  /= is de afkorting van a = a / b. We delen hier door het aantal van het tallig stelsel zodat je opnieuw de lus kunt uitvoeren.
      } // end of while, 
      // Dit gaat door todat de input 0 is. Als de input 0 is wordt de while lus gestopt.
      
      //Zodra de lus klaar is word de output gegeven op het scherm.
      
      outputLabel.setText("Omgerekend vanuit het "+stelsel+"-tallig stelsel is "+getalOutput);       
    } // end of if-else
  } // end of submitButtonDS_ActionPerformed
  
  public void submitButtonSD_ActionPerformed(ActionEvent evt) {
    //STELSEL NAAR DECIMAAL
    
    int stelselGetal = stelselGetalInputField.getInt();
    String strStelselGetal = ""+stelselGetal;
    int stelselGetalLength = strStelselGetal.length();
    
    int stelsel = stelselInputSD.getInt();
    
    double getalOutput = 0;
    
    for (int i = 0; i < stelselGetalLength; i++) {
      //tot de macht lengte - i
      String strHuidigGetal = strStelselGetal.substring(i, i+1);
      int huidigGetal = Integer.parseInt(strHuidigGetal);
      
      double huidigGetalOmgerekend = Math.pow(huidigGetal, stelselGetalLength - i);
      
      getalOutput = getalOutput + huidigGetalOmgerekend;
    }// end of for
    
    outputLabel1.setText(""+getalOutput); 
  } // end of submitButtonSD_ActionPerformed
  
  // end methods
}  
// end of class BinairOmrekenen
