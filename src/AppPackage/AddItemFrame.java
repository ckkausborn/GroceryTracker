
package AppPackage;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.BoxLayout;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class AddItemFrame {
    Settings a;
    int tempindex;
    SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy"); 
    
    JTextField Titem = new JTextField(8);
    JTextField Price = new JTextField(6);
    JTextField Tcal = new JTextField(6);
    JTextField Tsugar = new JTextField(6);
    JTextField Tprotein = new JTextField(6);
    JTextField Tcarbs = new JTextField(6);
    JTextField Tfat = new JTextField(6);
    JTextField Tchol = new JTextField(6);
    JFormattedTextField Texpiration = new JFormattedTextField(formatter);
    
    //constructor
    public AddItemFrame(Settings a){
        this.a = a;
    }
    
    
    public void clear(){
        Titem.setText("");
        Price.setText("");
        Tcal.setText("");
        Tsugar.setText("");
        Tprotein.setText("");
        Tcarbs.setText("");
        Tfat.setText("");
        Tchol.setText("");
        Texpiration.setText("00/00/0000");
    }
    
    public void confirm(MasterList list){
         
            list.get(tempindex).setName(Titem.getText());
            if (a.getCal()){
                try{
                    list.get(tempindex).setCal(Double.parseDouble(Tcal.getText()));
                }
                catch (Exception e){
                    JOptionPane.showMessageDialog(null, "Please enter calories as a number.");
                    display(list);
                }
            }
            if (a.getSugar()){
                try {
                    list.get(tempindex).setSugar(Double.parseDouble(Tsugar.getText()));
                }
                catch (Exception e){
                    JOptionPane.showMessageDialog(null, "Please enter sugar as a number.");
                    display(list);
                }
            }
            if (a.getProtein()){
                try {
                    list.get(tempindex).setProtein(Double.parseDouble(Tprotein.getText()));
                }
                catch (Exception e){
                    JOptionPane.showMessageDialog(null, "Please enter protein as a number.");
                    display(list);
                }
            }
            if (a.getCarbs()){
                try {
                    list.get(tempindex).setCarbs(Double.parseDouble(Tcarbs.getText()));
                }
                catch (Exception e){
                    JOptionPane.showMessageDialog(null, "Please enter carbohydrates as a number.");
                    display(list);
                }
            }
            if (a.getFat()){
                try {
                    list.get(tempindex).setFat(Double.parseDouble(Tfat.getText()));
                }
                catch (Exception e){
                    JOptionPane.showMessageDialog(null, "Please enter fat as a number.");
                    display(list);
                }
            }
            if (a.getChol()){
                try{
                    list.get(tempindex).setChol(Double.parseDouble(Tchol.getText()));
                }
                catch (Exception e){
                    JOptionPane.showMessageDialog(null, "Please enter calories as a number.");
                    display(list);
                }
            }
            try{
                list.get(tempindex).setExpire(formatter.parse(Texpiration.getText()));
            }
            catch(Exception e){
                JOptionPane.showMessageDialog(null, "Please enter the expiration date in the format 'MM/DD/YYYY");
                display(list);
            }
            
    }
    
    public void initNewItem(MasterList list){
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel,BoxLayout.Y_AXIS));
        panel.add(new JLabel("Food Name:"));
        panel.add(Titem);
        panel.add(new JLabel("Food Price:"));
        panel.add(Price);
        panel.add(new JLabel("Expiration Date:"));
        panel.add(Texpiration);
        
        int result = JOptionPane.showConfirmDialog(null, panel, 
               "Add Item", JOptionPane.OK_CANCEL_OPTION);
        if(result == JOptionPane.OK_OPTION){
            try{
            tempindex = list.add(Titem.getText(), Double.parseDouble(Price.getText()), formatter.parse(Texpiration.getText()));
            display(list);
            }
            catch(Exception e){
                JOptionPane.showMessageDialog(null, "Please enter the expiration date in the format 'MM/DD/YYYY'\nand the price in the form of 0.00");
                initNewItem(list);
            }
        }
    }
    
    public void display(MasterList list){
        if (a.noSelection == false){
            JPanel myPanel = new JPanel(); //create dialog box
            myPanel.setLayout(new BoxLayout(myPanel,BoxLayout.Y_AXIS));

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

            int result = JOptionPane.showConfirmDialog(null, myPanel, 
                   list.get(tempindex).getName(), JOptionPane.OK_CANCEL_OPTION);
            if (result != JOptionPane.OK_OPTION){
                list.remove(list.size()-1);
            }
            if (result == JOptionPane.OK_OPTION) {
                confirm(list);
                clear();
            }
        }
    }
}
