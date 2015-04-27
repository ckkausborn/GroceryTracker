
package AppPackage;

import java.awt.BorderLayout;
import java.util.ArrayList;
import javax.swing.JLabel;
import javax.swing.JPanel;


class ShoppingList {
    ArrayList<foodItem> ShoppingList;
    ArrayList<String> ShoppingListNames;
    
    public ShoppingList(){
        ShoppingList = new ArrayList<foodItem>();
        ShoppingListNames = new ArrayList<String>();
    }
    
    public void updateNameList(){
        ShoppingListNames.clear();
        for (int i = 0; i < ShoppingList.size(); i++){
            ShoppingListNames.add(ShoppingList.get(i).getName());
        }
    }
    
    public int size(){
        return ShoppingList.size();
    }
    
    public Object[] toArray(){
        return ShoppingListNames.toArray();
    }
    
    public foodItem get(int index){
        return ShoppingList.get(index);
    }
    public double generatedSum(){
        double sum = 0;
        for(int i = 0; i< ShoppingList.size(); i++){
            sum+=ShoppingList.get(i).getPrice();
        }
        return sum;
    }
    
    public double customSum(){
        double sum = 0; 
        for(int i = 0; i< ShoppingList.size(); i++){
            if (ShoppingList.get(i).getShowPrice()){
                sum+=ShoppingList.get(i).getPrice();
            }
        }   
        return sum;
    }
}
