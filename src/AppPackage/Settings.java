

package AppPackage;
import java.util.ArrayList;
import javax.swing.*;

public class Settings {
    //Default each setting to false
    boolean cal = false;
    boolean sugar = false;
    boolean protein = false;
    boolean carbs = false;
    boolean fat = false;
    boolean chol = false;

    //comparison holders
    boolean tempcal = cal;
    boolean tempsugar = sugar;
    boolean tempcarbs = carbs;
    boolean tempchol = chol;
    boolean tempfat = fat;
    boolean tempprotein = protein;
    boolean noSelection = false;

    boolean firstUse = true;
        
    //constructor    
    public Settings(){
    }
    
    //get methods
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
    public void setSelection(boolean b){
        noSelection = b;
    }
    
    public void display(PantryFoodList al){
        JPanel myPanel = new JPanel(); //create dialog box
        
        JCheckBox calbox =new JCheckBox("Calories", cal);
        JCheckBox sugarbox = new JCheckBox("Sugar", sugar);
        JCheckBox proteinbox = new JCheckBox("Protein", protein);
        JCheckBox carbsbox = new JCheckBox("Carbohydrates", carbs);
        JCheckBox fatbox = new JCheckBox("Fat", fat);
        JCheckBox cholbox = new JCheckBox("Cholesterol", chol);
                
        
        myPanel.setLayout(new BoxLayout(myPanel,BoxLayout.Y_AXIS)); //set more aesthetic layout
        //prompt
        myPanel.add(new JLabel("<html>GroceryTracker allows you to track more "
                + "than just the food you<br/>have. Please select the components"
                + " you wish to keep track of.</html>"));
        //adds the checkboxes
        myPanel.add(calbox);
        myPanel.add(sugarbox);
        myPanel.add(proteinbox);
        myPanel.add(carbsbox);
        myPanel.add(fatbox);
        myPanel.add(cholbox);
        
        //loop shows the dialog box until user confirms choices
        int result = 2;
        while( result != JOptionPane.OK_OPTION ){
             result =JOptionPane.showConfirmDialog(null, myPanel, 
               "Personalized Settings", JOptionPane.OK_OPTION);
        }
        cal = calbox.isSelected();
        sugar = sugarbox.isSelected();
        protein = proteinbox.isSelected();
        carbs = carbsbox.isSelected();
        fat = fatbox.isSelected();
        chol = cholbox.isSelected();
        if (!getCal()&&!getSugar()&&!getProtein()&&!getCarbs()&&!getFat()&&!getChol()){
            setSelection(true);}
        else{
            setSelection(false);}
    }
}