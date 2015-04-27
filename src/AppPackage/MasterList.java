
package AppPackage;

import java.util.ArrayList;
import java.util.Date;


public class MasterList {
    ArrayList<foodItem> foodItems;
    
    public MasterList(){
        foodItems = new ArrayList<foodItem>();
    }

    public ArrayList<foodItem> getList(){
        return foodItems;
    }
    
    public foodItem get(int index){
        return foodItems.get(index);
    }
    
    public int add(String name, double price, Date date){
        foodItems.add(new foodItem(name,price,date));
        return foodItems.size()-1;
    }
    
    public void remove(int index){
        foodItems.remove(index);
    }
    
    public void remove(foodItem item){
        int index = searchList(item);
        foodItems.remove(index);
    }
    
    public int searchList(foodItem item){
        for (int i = 0; i < foodItems.size();i++){
            if (item.equals(foodItems.get(i)))
                return i;
        }
        return -1;
    }
    public Object[] toArray(){
        ArrayList<String> temp = new ArrayList<String>();
        for (int i = 0; i < foodItems.size(); i++){
            temp.add(foodItems.get(i).getName());
        }
        return temp.toArray();
    }
    public PantryFoodList removeFromPantry(foodItem item){
        foodItems.get(searchList(item)).setPantry(false);
        foodItems.get(searchList(item)).setShowPrice(true);
        return constructPantryList();
    }
    
    public int size(){
        return foodItems.size();
    }
    
    public PantryFoodList constructPantryList(){
        PantryFoodList newpantry = new PantryFoodList();
        for (int i = 0; i<foodItems.size(); i++){
            if (foodItems.get(i).getPantry())
                newpantry.pantryFoodList.add(foodItems.get(i));
        }
        newpantry.updateNameList();
        return newpantry;
    }
     public ShoppingList constructShoppingList(){
         ShoppingList newlist = new ShoppingList();
         for (int i = 0; i<foodItems.size(); i++){
             if (foodItems.get(i).getPantry() == false){
                 newlist.ShoppingList.add(foodItems.get(i));
             }
         }
         newlist.updateNameList();
         return newlist;
     }
}


