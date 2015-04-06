
package AppPackage;

import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.BoxLayout;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class AddItemFrame {
    Settings a;
    String name;
    double cal = 0;
    double sugar = 0;
    double protein = 0;
    double carbs = 0;
    double fat = 0;
    double chol = 0;
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
    public String getName(){
        return name;
    }
    public Date getExpire(){
        return expire;
    }
    public double getCal(){
        return cal;
    }
    public double getSugar(){
        return sugar;
    }
    public double getProtein(){
        return protein;
    }
    public double getCarbs(){
        return carbs;
    }
    public double getFat(){
        return fat;
    }
    public double getChol(){
        return chol;
    }
    
    public void clear(){
        Titem.setText("");
        Tcal.setText("");
        Tsugar.setText("");
        Tprotein.setText("");
        Tcarbs.setText("");
        Tfat.setText("");
        Tchol.setText("");
        Texpiration.setText("00/00/00");
    }
    public void confirm(){
         
            name = Titem.getText();
            if (a.getCal()){
                try{
                    cal = Double.parseDouble(Tcal.getText());
                }
                catch (Exception e){
                    JOptionPane.showMessageDialog(null, "Please enter calories as a number.");
                    display();
                }
            }
            if (a.getSugar()){
                try {
                    sugar = Double.parseDouble(Tsugar.getText());
                }
                catch (Exception e){
                    JOptionPane.showMessageDialog(null, "Please enter sugar as a number.");
                    display();
                }
            }
            if (a.getProtein()){
                try {
                    protein = Double.parseDouble(Tprotein.getText());
                }
                catch (Exception e){
                    JOptionPane.showMessageDialog(null, "Please enter protein as a number.");
                    display();
                }
            }
            if (a.getCarbs()){
                try {
                    carbs = Double.parseDouble(Tcarbs.getText());
                }
                catch (Exception e){
                    JOptionPane.showMessageDialog(null, "Please enter carbohydrates as a number.");
                    display();
                }
            }
            if (a.getFat()){
                try {
                    fat = Double.parseDouble(Tfat.getText());
                }
                catch (Exception e){
                    JOptionPane.showMessageDialog(null, "Please enter fat as a number.");
                    display();
                }
            }
            if (a.getChol()){
                try{
                    chol = Double.parseDouble(Tchol.getText());
                }
                catch (Exception e){
                    JOptionPane.showMessageDialog(null, "Please enter calories as a number.");
                    display();
                }
            }
            try{
                expire = formatter.parse(Texpiration.getText());
            }
            catch(Exception e){
                JOptionPane.showMessageDialog(null, "Please enter the expiration date in the format 'MM/DD/YYYY");
                display();
            }
            
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
            confirm();
            clear();
        }
    }
}
