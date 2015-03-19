/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package AppPackage;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.BoxLayout;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class AddItemFrame {
    Settings a = new Settings();
    String name;
    double cal;
    double sugar;
    double protein;
    double carbs;
    double fat;
    double chol;
    Date expire;
    SimpleDateFormat formatter = new SimpleDateFormat("MM/DD/YYYY"); 
    
    JTextField Titem = new JTextField(8);
    JTextField Tcal = new JTextField(6);
    JTextField Tsugar = new JTextField(6);
    JTextField Tprotein = new JTextField(6);
    JTextField Tcarbs = new JTextField(6);
    JTextField Tfat = new JTextField(6);
    JTextField Tchol = new JTextField(6);
    JFormattedTextField Texpiration = new JFormattedTextField(formatter);
    
    public AddItemFrame(Settings a){
        this.a = a;
    }
    public void display(){
        JPanel myPanel = new JPanel(); //create dialog box
        myPanel.setLayout(new BoxLayout(myPanel,BoxLayout.Y_AXIS));
        myPanel.add(new JLabel("Food Name:"));
        myPanel.add(Titem);
        if (a.getCal()){
            myPanel.add(new JLabel("Calories:"));
            myPanel.add(Tcal);
        }
        if (a.getSugar()){
            myPanel.add(new JLabel("Sugar:"));
            myPanel.add(Tsugar);
        }
        if (a.getProtein()){
            myPanel.add(new JLabel("Protein:"));
            myPanel.add(Tprotein);
        }       
        if (a.getCarbs()){
            myPanel.add(new JLabel("Carbohydrates:"));
            myPanel.add(Tcarbs);
        }
        if (a.getFat()){
            myPanel.add(new JLabel("Fat:"));
            myPanel.add(Tfat);
        }
        if (a.getChol()){
            myPanel.add(new JLabel("Cholesterol:"));
            myPanel.add(Tchol);
        }
        myPanel.add(new JLabel("Expiration Date:"));
        myPanel.add(Texpiration);
        
        int result = JOptionPane.showConfirmDialog(null, myPanel, 
               "Add Item", JOptionPane.OK_CANCEL_OPTION);
        if (result == JOptionPane.OK_OPTION) {
            try{
            name = Titem.getText();
            cal = Double.parseDouble(Tcal.getText());
            sugar = Double.parseDouble(Tsugar.getText());
            protein = Double.parseDouble(Tprotein.getText());
            carbs = Double.parseDouble(Tcarbs.getText());
            fat = Double.parseDouble(Tfat.getText());
            chol = Double.parseDouble(Tchol.getText());
            expire = formatter.parse(Texpiration.getText());
            }
            catch(Exception e){
                JOptionPane.showMessageDialog(null, "Please enter the expiration date in the format 'MM/DD/YYY");
            }
        }
    }
}
