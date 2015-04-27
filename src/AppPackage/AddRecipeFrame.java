
package AppPackage;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import javax.swing.BoxLayout;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;


public class AddRecipeFrame {
    Settings a;
    SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy"); 
    int tempindex;
    int tempnum;
    
    JTextField RecipeName;
    JPanel displayPanel;
    JComboBox[] comboarray;
  
    
    JTextField ingredientNum;
    JTextField newIngredient;
    JComboBox Box;

    
    public AddRecipeFrame(Settings a, MasterList ML){
        this.a = a;
        comboarray = new JComboBox[10];
        JComboBox ing1 = new JComboBox(ML.toArray());
        JComboBox ing2 = new JComboBox(ML.toArray());
        JComboBox ing3 = new JComboBox(ML.toArray());
        JComboBox ing4 = new JComboBox(ML.toArray());
        JComboBox ing5 = new JComboBox(ML.toArray());
        JComboBox ing6 = new JComboBox(ML.toArray());
        JComboBox ing7 = new JComboBox(ML.toArray());
        JComboBox ing8 = new JComboBox(ML.toArray());
        JComboBox ing9 = new JComboBox(ML.toArray());
        JComboBox ing10 = new JComboBox(ML.toArray());
        comboarray[0] = ing1;
        comboarray[1] = ing2;
        comboarray[2] = ing3;
        comboarray[3] = ing4;
        comboarray[4] = ing5;
        comboarray[5] = ing6;
        comboarray[6] = ing7;
        comboarray[7] = ing8;
        comboarray[8] = ing9;
        comboarray[9] = ing10;
    }
    
    public void initNewRecipe(RecipeList rl, MasterList ML){
        RecipeName = new JTextField();
        ingredientNum = new JTextField();
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel,BoxLayout.Y_AXIS));
        panel.add(new JLabel("What is the name of this recipe?"));
        panel.add(RecipeName);
        panel.add(new JLabel("How many ingredients does this recipe have?"));
        panel.add(ingredientNum);
        int result = JOptionPane.showConfirmDialog(null, panel, 
               "Add Recipe", JOptionPane.OK_CANCEL_OPTION);
        if (result != JOptionPane.OK_OPTION){
            return;
        }
        else {
            try{
                tempindex = rl.add(RecipeName.getText());
                tempnum = Integer.parseInt(ingredientNum.getText());
                display(rl, ML);
            }
            catch(Exception e){
                JOptionPane.showMessageDialog(null, "Please enter an integer for the number of ingeredients in the recipe.");
                initNewRecipe(rl, ML);
            }
        }
    }
    
    public void display (RecipeList rl, MasterList ML){
        displayPanel = new JPanel();
        displayPanel.setLayout(new BoxLayout(displayPanel,BoxLayout.Y_AXIS));
        for (int i = 0; i < tempnum; i++){
           displayPanel.add(new JLabel("Ingredient" + (i+1) + ": "));
           displayPanel.add(comboarray[i]);
        }
        int result = JOptionPane.showConfirmDialog(null, displayPanel, 
                "Add Recipe Ingredients", JOptionPane.OK_CANCEL_OPTION);
        if (result != JOptionPane.OK_OPTION){
            rl.remove(rl.size()-1);
        }
        else
            dataCollect(rl,ML); 
    }
    
    public void dataCollect(RecipeList rl, MasterList ML){
        for (int i = 0; i < tempnum; i++){
            rl.get(tempindex).addIngredient(ML.get(comboarray[i].getSelectedIndex()));
        }
        rl.get(tempindex).totals();
        rl.get(tempindex).findEarliestExpire();
    }
    
}


