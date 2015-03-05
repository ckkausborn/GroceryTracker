

package AppPackage;
import javax.swing.*;

public class Settings {
    //Default each setting to false
        boolean cal = false;
        boolean sugar = false;
        boolean protein = false;
        boolean carbs = false;
        boolean fat = false;
        boolean chol = false;
    public Settings(){
    }
    
    public boolean getCal(){
        return cal;
    }
    public boolean getSugar(){
        return sugar;
    }
    public boolean getProtein(){
        return protein;
    }
    public boolean getCarbs(){
        return carbs;
    }
    public boolean getFat(){
        return fat;
    }
    public boolean getChol(){
        return chol;
    }
    
    public void display(){
        JPanel myPanel = new JPanel(); //create dialog box
        
        JCheckBox cal =new JCheckBox("Calories");
        JCheckBox sugar = new JCheckBox("Sugar");
        JCheckBox protein = new JCheckBox("Protein");
        JCheckBox carbs = new JCheckBox("Carbohydrates");
        JCheckBox fat = new JCheckBox("Fat");
        JCheckBox chol = new JCheckBox("Cholesterol");
                
        
        myPanel.setLayout(new BoxLayout(myPanel,BoxLayout.Y_AXIS)); //set more aesthetic layout
        //prompt
        myPanel.add(new JLabel("<html>GroceryTracker allows you to track more "
                + "than just the food you<br/>have. Please select the components"
                + " you wish to keep track of.</html>"));
        //adds the checkboxes
        myPanel.add(cal);
        myPanel.add(sugar);
        myPanel.add(protein);
        myPanel.add(carbs);
        myPanel.add(fat);
        myPanel.add(chol);
        
        //loop shows the dialog box until user confirms choices
        int result = 2;
        while( result != JOptionPane.OK_OPTION ){
             result = JOptionPane.showConfirmDialog(null, myPanel, 
               "Personalized Settings", JOptionPane.OK_OPTION);
        }
        this.cal = cal.isSelected();
        this.sugar = sugar.isSelected();
        this.carbs = carbs.isSelected();
        this.chol= chol.isSelected();
        this.fat = fat.isSelected();
        this.protein = protein.isSelected();         
    }
}
