
package AppPackage;

import java.awt.BorderLayout;
import java.awt.Component;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;


public class RecipePane extends JPanel{
    JList recipeNameList;
    JButton addRecipe;
    JLabel ingredients = new JLabel();
    JLabel firstExpire = new JLabel();
    JLabel RecipeName = new JLabel();
    
    JLabel cal= new JLabel();
    JLabel sugar = new JLabel();
    JLabel protein = new JLabel();
    JLabel carbs = new JLabel();
    JLabel fat = new JLabel();
    JLabel chol = new JLabel();
    
    
    public RecipePane(Settings s){
        addRecipe = new JButton("+");
        
        //init pantryList
        recipeNameList = new JList();
        recipeNameList.setVisibleRowCount(5);
        recipeNameList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        
        add(new JScrollPane(recipeNameList), BorderLayout.WEST);
        add(addRecipe, BorderLayout.NORTH);
    }
    
    
    public void updateList(RecipeList e){
        e.updateNameList();
        recipeNameList.setListData(e.recipeListNames.toArray());
    }
    
    public void resetLabels(){
        RecipeName.setText("");
        ingredients.setText("");
        firstExpire.setText("");
        cal.setText("");
        sugar.setText("");
        protein.setText("");
        carbs.setText("");
        fat.setText("");
        chol.setText("");
        RecipeName.setVisible(false);
        ingredients.setVisible(false);
        firstExpire.setVisible(false);
        cal.setVisible(false);
        sugar.setVisible(false);
        protein.setVisible(false);
        carbs.setVisible(false);
        fat.setVisible(false);
        chol.setVisible(false);

    }
    public void initLabels(Settings a){
        add(RecipeName);
        RecipeName.setVisible(true);
        add(ingredients);
        ingredients.setVisible(true);
        add(firstExpire);
        firstExpire.setVisible(true);
        if (a.getCal()){
            add(cal);
            cal.setVisible(true);
        }       
        if (a.getSugar()){
            add(sugar);
            sugar.setVisible(true);
        }
        if (a.getProtein()){
            add(protein);
            protein.setVisible(true);
        }
        if (a.getCarbs()){
            add(carbs);
            carbs.setVisible(true);
        }
        if (a.getFat()){
            add(fat);
            fat.setVisible(true);
        }
        if (a.getChol()){
            add(chol);   
            chol.setVisible(true);
        }
    }
}
