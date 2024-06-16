// JARNO KAPTEIN & JORIS BLACKSTONE, Havo 4, 2024

import java.awt.*;
import java.awt.event.*;
import java.applet.Applet;

/**
  *
  * 
  *  ____  _       _          _    ___                     _                         
  * / ___|| |_ ___| |___  ___| |  / _ \ _ __ ___  _ __ ___| | _____ _ __   ___ _ __  
  * \___ \| __/ _ \ / __|/ _ \ | | | | | '_ ` _ \| '__/ _ \ |/ / _ \ '_ \ / _ \ '_ \ 
  *  ___) | ||  __/ \__ \  __/ | | |_| | | | | | | | |  __/   <  __/ | | |  __/ | | |
  * |____/ \__\___|_|___/\___|_|  \___/|_| |_| |_|_|  \___|_|\_\___|_| |_|\___|_| |_|
  
  *
  * @version 1.0 gemaakt 31/05/2024
  *
  * Jarno Kaptein
  * Joris Blackstone
  * 
  * Een applet waarme je stelsels kan omrekenen naar het decimaal stelsel en vice versa.
  * 
  */

public class stelselsOmrekenen extends Applet {
  // start attributes
  private Label titelLabel = new Label();
  private NumberField getalInput = new NumberField();
  private Button stelselButton = new Button();
  private Label outputLabel = new Label();
  private Label getalLabel = new Label();
  private Label stelselLabel = new Label();
  private NumberField stelselInput = new NumberField();
  private Button decimaalButton = new Button();
  // end attributes
  
  public void init() {
    Panel cp = new Panel(null);
    cp.setBounds(0, 0, 498, 300);
    add(cp);
    // start components
    
    titelLabel.setBounds(8, 8, 466, 41);
    titelLabel.setText("Stelsel Omrekenen");
    titelLabel.setAlignment(Label.CENTER);
    titelLabel.setFont(new Font("Consolas", Font.PLAIN, 24));
    titelLabel.setBackground(Color.WHITE);
    cp.add(titelLabel);
    getalInput.setBounds(240, 64, 233, 33);
    getalInput.setText("");
    cp.add(getalInput);
    stelselButton.setBounds(24, 160, 193, 25);
    stelselButton.setLabel("Naar stelsel");
    stelselButton.addActionListener(new ActionListener() { 
      public void actionPerformed(ActionEvent evt) { 
        stelselButton_ActionPerformed(evt);
      }
    });
    cp.add(stelselButton);
    
    outputLabel.setBounds(8, 192, 467, 49);
    outputLabel.setText("");    
    outputLabel.setBackground(Color.WHITE);
    outputLabel.setFont(new Font("Consolas", Font.PLAIN, 14));
    cp.add(outputLabel);
    
    getalLabel.setBounds(8, 64, 219, 33);
    getalLabel.setText("Getal:");
    getalLabel.setBackground(Color.WHITE);
    cp.add(getalLabel);
    
    stelselLabel.setBounds(8, 112, 220, 33);
    stelselLabel.setText("Stelsel:");
    stelselLabel.setBackground(Color.WHITE);
    cp.add(stelselLabel);
    
    stelselInput.setBounds(240, 112, 33, 33);
    stelselInput.setText("");
    stelselInput.setSelectionStart(2);
    stelselInput.setSelectionEnd(9);
    cp.add(stelselInput);
    cp.setBackground(Color.WHITE);
    decimaalButton.setBounds(264, 160, 193, 25);
    decimaalButton.setLabel("Naar decimaal");
    decimaalButton.addActionListener(new ActionListener() { 
      public void actionPerformed(ActionEvent evt) { 
        decimaalButton_ActionPerformed(evt);
      }
    });
    cp.add(decimaalButton);
    // end components
    
  } // end of init
  
  // start methods
  public void stelselButton_ActionPerformed(ActionEvent evt) {
    // DECIMAAL NAAR STELSEL  
    
    int decimaalGetalInput = 0;
    int stelsel = 0;
    
    decimaalGetalInput = getalInput.getInt();
    stelsel = stelselInput.getInt();    
    
    /**
    * STAPPENPLAN VAN DECIMAAL NAAR STELSEL REKENEN
    * 
    * Van decimaal naar stelsel x:
    * Delen door x
    * Rest van x opslaan
    * Door rekenen met de deling (afronden naar beneden)
    *
    **/
    
    if (stelsel<2) {
      outputLabel.setText("Voer een geldig stelsel tussen 2 en 9 in");
    } else if (stelsel>9) {
      outputLabel.setText("Voer een geldig stelsel tussen 2 en 9 in"); 
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
    }// end of checksum, hier is dus het einde van de if-else
  } // Einde van het omrekenen naar een stelsel
  
  public void decimaalButton_ActionPerformed(ActionEvent evt) {
    //STELSEL NAAR DECIMAAL
    
    int getal;
    int stelsel;
    
    getal = getalInput.getInt();
    stelsel = stelselInput.getInt();
    
    if (stelsel<2) {                                                    //Als het stelsel kleiner is dan 2, dan geeft hij een foutmelding/correctie aan.
      outputLabel.setText("Voer een geldig stelsel tussen 2 en 9 in");
    } else if (stelsel>9) {                                             //Als het stelsel groter is dan 9, dan geeft hij een foutmelding/correctie aan.
      outputLabel.setText("Voer een geldig stelsel tussen 2 en 9 in"); 
    } else {                                                            //Als het stelsel goed is ingevoerd, dan gaat de code door. Hiermee voorkomen we foute berekeningen.
      
      int outputGetal = 0;
      
      String getalString = "" + getal;                                                                       // Het getal exporteren naar een String zodat de getallen gesplitst kunnen worden van de invoer.
      
      /**
      * STAPPENPLAN VAN STELSEL NAAR DECIMAAL REKENEN
      * 
      * Voor elk getal geld:
      * Vermenigvuldigen met het stelsel tot de macht van de huidige positie, waar je begint met tellen vanaf rechts = 0
      * 
      **/
      
      for (int i=0; i<getalString.length(); i++) {                                                           // Voor elk nummer in het getal van de invoer het volgende uitvoeren:        
        String huidigGetalString = getalString.substring(i, (i+1));                                          // Het huidige getal splitsen zodat je daarmee kan werken, echter is dit een string en niet een Integer 
        int huidigGetal = Integer.parseInt(huidigGetalString);                                               // Het huidige getal converteren van een String naar een Integer zodat je kan rekenen ermee
        
        outputGetal = huidigGetal * (int) (Math.pow(stelsel, getalString.length() - i - 1)) + outputGetal;    // Elk getal apart vermenigvuldigen met het stelsel tot de macht van de plek van het nummer. Die getallen worden als laatste stapt bij elkaar gevoegd als 1 getal. Dus plus elkaar.
      }                                                                                                       // Dus dat betekent: huidigGetal * (stelsel^plek) + vorigeGetal
      
      outputLabel.setText("Omgerekend naar het decimaal stelsel is: "+outputGetal);                           // Het eindresultaat exporteren naar de outputLabel zodat de gebruiker dit kan lezen.
      
    } // end of checksum, hier is dus het einde van de if-else
  } // Einde van het omrekenen naar het decimaal stelsel
  
  // end methods
}  
  // end of class BinairOmrekenen
