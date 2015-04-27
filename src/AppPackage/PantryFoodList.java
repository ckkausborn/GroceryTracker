
package AppPackage;

import java.util.ArrayList;
import java.util.Date;


public class PantryFoodList {
    ArrayList<foodItem> pantryFoodList;
    ArrayList<String> pantryListNames;
    
    public PantryFoodList(){
        pantryFoodList = new ArrayList<foodItem>();
        pantryListNames = new ArrayList<String>();
    }
    
    public int add(String name, double price, Date exp, MasterList ML){
        pantryFoodList.add(new foodItem(name, price, exp));
        //add to master list
        return pantryFoodList.size()-1;
    }
    
    public void updateNameList(){
        pantryListNames.clear();
        for (int i = 0; i < pantryFoodList.size(); i++){
            pantryListNames.add(pantryFoodList.get(i).getName());
        }
    }
    public Object[] toArray(){
        return pantryListNames.toArray();
    }
    
    public int size(){
        return pantryFoodList.size();
    }
    
    public foodItem get(int index){
        return pantryFoodList.get(index);
    }
    
    public foodItem remove (int index){
        pantryListNames.remove(index);
        return pantryFoodList.remove(index);        
    }
    
    public int indexOf(foodItem x){
        return pantryFoodList.indexOf(x);
    }

    
}
