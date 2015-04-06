
package AppPackage;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTabbedPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;



public class StartGui {
    JFrame frame;
    JButton settingsButton;
    JTabbedPane tabs;
    Settings settings;
    PantryPane pantrypane;
    ArrayList<foodItem> foodlist = new ArrayList<foodItem>();
    ArrayList<String> itemnames = new ArrayList<String>();
    foodItem itemtemp;
    
    public static void main(String args[]) {
        new StartGui();
    }
    public StartGui(){
        initComponents();
        settings = new Settings();
        settings.display();
        
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
        tabs.add("Pantry", pantrypane);
        tabs.add("Recipes", new RecipePane());
        tabs.add("Shopping", new ShoppingPane());
        
        
        frame.add(settingsButton, BorderLayout.NORTH);
        frame.add(tabs, BorderLayout.CENTER);
        frame.setVisible(true);
        
        //settingsButton listener
        settingsButton.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent e){
                    settings.display();
                }
        });
        
        //addItem listener
        pantrypane.addItem.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                AddItemFrame a = new AddItemFrame(settings);
                a.display();
                foodlist.add(new foodItem(a.getName(),a.getExpire(), a.getCal(),
                        a.getSugar(), a.getProtein(), a.getCarbs(), a.getFat(), 
                        a.getChol(), true));
                itemnames.add(a.getName());
                pantrypane.updateList(itemnames);
            }
        });
        
        //addList listener
        pantrypane.pantryList.addListSelectionListener(
                new ListSelectionListener(){
                    public void valueChanged(ListSelectionEvent e){
                        pantrypane.resetLabels();
                        //get item info to print here.
                        itemtemp = foodlist.get(pantrypane.pantryList.getSelectedIndex());
                        pantrypane.name.setText("Item: " + itemtemp.getName());
                        pantrypane.cal.setText("Calories: " + itemtemp.getCal());
                        pantrypane.sugar.setText("Sugar: " + itemtemp.getSugar());
                        pantrypane.protein.setText("Protein: " + itemtemp.getProtein());
                        pantrypane.carbs.setText("Carbohydrates: " + itemtemp.getCarbs());
                        pantrypane.fat.setText("Fat: " + itemtemp.getFat());
                        pantrypane.chol.setText("Choleterol: " + itemtemp.getChol());
                        pantrypane.expire.setText("Expiration Date: " + itemtemp.getExpire());
                        pantrypane.initLabels(settings);
                    } 
                }
        );
    }
    
}

