
package AppPackage;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListModel;
import javax.swing.ListSelectionModel;



public class PantryPane extends JPanel{
    JList pantryList;
    JButton addItem;
    JButton removeItem;
    JLabel name = new JLabel();
    JLabel cal= new JLabel();
    JLabel sugar = new JLabel();
    JLabel protein = new JLabel();
    JLabel carbs = new JLabel();
    JLabel fat = new JLabel();
    JLabel chol = new JLabel();
    JLabel expire = new JLabel();
    
            
    public PantryPane(Settings s){
        addItem = new JButton("+");
        removeItem = new JButton ("-");
        
        //init pantryList
        pantryList = new JList();
        pantryList.setVisibleRowCount(5);
        pantryList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        JScrollPane scrollpane = new JScrollPane(pantryList);
        
        
        add(scrollpane, BorderLayout.WEST);
        add(addItem, BorderLayout.NORTH);
        add(removeItem, BorderLayout.NORTH);
        
        
    }
    public void updateList(PantryFoodList e){
        pantryList.setListData(e.pantryListNames.toArray());
    }
    
    public void resetLabels(){
        name.setText("");
        cal.setText("");
        sugar.setText("");
        protein.setText("");
        carbs.setText("");
        fat.setText("");
        chol.setText("");
        expire.setText("");
        name.setVisible(false);
        cal.setVisible(false);
        sugar.setVisible(false);
        protein.setVisible(false);
        carbs.setVisible(false);
        fat.setVisible(false);
        chol.setVisible(false);
        expire.setVisible(false);
    }
    public void initLabels(Settings a){
        add(name);
        name.setVisible(true);
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
        add(expire);
        expire.setVisible(true);
    }
}
