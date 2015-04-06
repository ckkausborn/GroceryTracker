
package AppPackage;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;



public class PantryPane extends JPanel{
    JList pantryList;
    JButton addItem;
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
        
        //init pantryList
        pantryList = new JList();
        pantryList.setVisibleRowCount(5);
        pantryList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        
        add(new JScrollPane(pantryList), BorderLayout.WEST);
        add(addItem, BorderLayout.NORTH);
        
        
    }
    
    public void updateList(ArrayList<String> e){
        pantryList.setListData(e.toArray());
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
