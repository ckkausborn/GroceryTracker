/*

MAJOR
------
-Fix the listeners so that the shoppingpane updates properly.
-Create a remove Recipe option.
    -This is also needed so that when an item is removed from the MasterList, any recipes containing that item are removed as well.

MINOR
-----
-Removing an item produces an error message. not sure why but it updates the list correctly.
-Recipe List needs to output ingredients.
-Fix JLists so that they don't change size

*/

package AppPackage;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTabbedPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;




public class StartGui {
    SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy"); 
    JFrame frame;
    JButton settingsButton;
    JTabbedPane tabs;
    Settings settings;
    PantryPane pantrypane;
    RecipePane recipepane;
    ShoppingPane shoppingpane;
    MasterList ML = new MasterList();
    PantryFoodList pantryFoodList = new PantryFoodList();
    RecipeList recipeList = new RecipeList();
    ShoppingList shoppingList = new ShoppingList();
    foodItem itemtemp;
    Recipe recipetemp;
    
    public StartGui(){
        initComponents();
        settings = new Settings();
        settings.display(pantryFoodList);
        
    }
    
    private void initComponents(){
        //init frame
        frame = new JFrame("GroceryTracker");
        frame.setLayout(new BorderLayout());
        frame.setSize(600, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        //init settingsButton
        settingsButton = new JButton("Settings");
        
        //init tabs
        tabs = new JTabbedPane();
        pantrypane = new PantryPane(settings);
        recipepane = new RecipePane(settings);
        shoppingpane = new ShoppingPane();
        tabs.add("Pantry", pantrypane);
        tabs.add("Recipes", recipepane);
        tabs.add("Shopping", shoppingpane);
        
        
        frame.add(settingsButton, BorderLayout.NORTH);
        frame.add(tabs, BorderLayout.CENTER);
        frame.setVisible(true);
        
        //settingsButton listener
        settingsButton.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent e){
                    settings.display(pantryFoodList);
                    
                }
        });
        
        //addItem listener
        pantrypane.addItem.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                AddItemFrame a = new AddItemFrame(settings);
                a.initNewItem(ML);
                
                pantryFoodList = ML.constructPantryList();
                pantrypane.updateList(pantryFoodList);
                shoppingList = ML.constructShoppingList();
                shoppingpane.update(shoppingList);
            }
        });
        
        //removeItem Listener
        pantrypane.removeItem.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                JPanel newpanel = new JPanel();
                newpanel.setLayout(new BoxLayout(newpanel,BoxLayout.Y_AXIS));
                JRadioButton removePantry = new JRadioButton("Remove from Pantry");
                JRadioButton removeAll = new JRadioButton ("Remove from Master List");
                ButtonGroup bg = new ButtonGroup();
                bg.add(removePantry);
                bg.add(removeAll);
                newpanel.add(removePantry);
                newpanel.add(removeAll);
                removePantry.setSelected(true);
                int result = JOptionPane.showConfirmDialog(null, newpanel, "Remove Item", JOptionPane.OK_CANCEL_OPTION);
                if (result == JOptionPane.OK_OPTION){
                    if (removePantry.isSelected()){
                        pantryFoodList = ML.removeFromPantry(pantryFoodList.get(pantrypane.pantryList.getSelectedIndex()));
                        pantrypane.updateList(pantryFoodList);
                    }
                    else if(removeAll.isSelected()){
                        ML.remove(pantryFoodList.get(pantrypane.pantryList.getSelectedIndex()));
                        pantryFoodList = ML.constructPantryList();
                        pantrypane.updateList(pantryFoodList);                
                    }
                }
                shoppingList = ML.constructShoppingList();
                shoppingpane.update(shoppingList);                
            }
        });
        
       //addRecipe listener
        recipepane.addRecipe.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                if (ML.size()==0){
                    JOptionPane.showMessageDialog(null, "You must add food to your pantry first!");
                }
                else{
                AddRecipeFrame b = new AddRecipeFrame(settings, ML);
                b.initNewRecipe(recipeList, ML);
                recipepane.updateList(recipeList);
                }
            }
        });
        
        //RecipeList listener
        recipepane.recipeNameList.addListSelectionListener(
                new ListSelectionListener(){
                    public void valueChanged(ListSelectionEvent e){
                        recipepane.resetLabels();
                        //get item info to print here.
                        recipetemp = recipeList.get(recipepane.recipeNameList.getSelectedIndex());
                        recipepane.RecipeName.setText("Recipe: " + recipetemp.getRecipeName());
                        recipepane.ingredients.setText(recipetemp.getIngredientList());
                        recipepane.cal.setText("Calories: " + recipetemp.getCal());
                        recipepane.sugar.setText("Sugar: " + recipetemp.getSugar());
                        recipepane.protein.setText("Protein: " + recipetemp.getProtein());
                        recipepane.carbs.setText("Carbohydrates: " + recipetemp.getCarbs());
                        recipepane.fat.setText("Fat: " + recipetemp.getFat());
                        recipepane.chol.setText("Choleterol: " + recipetemp.getChol());
                        recipepane.firstExpire.setText("First Ingredient Expires: " + formatter.format(recipetemp.getFirstExpire()));
                        recipepane.initLabels(settings);
                    } 
                }
        );
        
        //addList listener
        pantrypane.pantryList.addListSelectionListener(
                new ListSelectionListener(){
                    public void valueChanged(ListSelectionEvent e){
                        pantrypane.resetLabels();
                        //get item info to print here.
                        itemtemp = pantryFoodList.get(pantrypane.pantryList.getSelectedIndex());
                        pantrypane.name.setText("Item: " + itemtemp.getName() + "\n");
                        pantrypane.cal.setText("Calories: " + itemtemp.getCal());
                        pantrypane.sugar.setText("Sugar: " + itemtemp.getSugar());
                        pantrypane.protein.setText("Protein: " + itemtemp.getProtein());
                        pantrypane.carbs.setText("Carbohydrates: " + itemtemp.getCarbs());
                        pantrypane.fat.setText("Fat: " + itemtemp.getFat());
                        pantrypane.chol.setText("Choleterol: " + itemtemp.getChol());
                        pantrypane.expire.setText("Expiration Date: " + formatter.format(itemtemp.getExpire()));
                        pantrypane.initLabels(settings);
                    } 
                }
        );
        
    }
    
    public static void main(String args[]) {
        new StartGui();
    }
    
}

