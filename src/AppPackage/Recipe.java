
package AppPackage;

import java.util.ArrayList;
import java.util.Date;


public class Recipe extends ArrayList{
    String RecipeName;
    boolean allIngredients = false;
    ArrayList<foodItem> ingredients;
    int calTotal;
    int sugarTotal;
    int proteinTotal;
    int carbsTotal;
    int fatTotal;
    int cholTotal;
    Date earliestExpire;
    
    public Recipe(String name){
        RecipeName = name;
        ingredients = new ArrayList<foodItem>();
    }
    
    public Date getFirstExpire(){
        findEarliestExpire();
        return earliestExpire;
    }
    public double getCal(){
        return calTotal;
    }
    public double getSugar(){
        return sugarTotal;
    }
    public double getProtein(){
        return proteinTotal;
    }
    public double getCarbs(){
        return carbsTotal;
    }
    public double getFat(){
        return fatTotal;
    }
    public double getChol(){
        return cholTotal;
    }
    
    public String getRecipeName(){
        return RecipeName;
    }
    
    public void addIngredient(foodItem x){
        ingredients.add(x);
    }
    
    public foodItem getIngredient(int x){
        return ingredients.get(x);
    }
    
    public String getIngredientList(){
        StringBuilder sb = new StringBuilder();
        sb.append("Ingredients: ");
        for (int i = 0; i < ingredients.size(); i++){
            sb.append(ingredients.get(i).getName());
            if (i != ingredients.size()-1)
                sb.append(", ");
        }
        return sb.toString();
    }
    
    public int ingredientNum(){
        return ingredients.size();
    }
    
    public boolean itemSearch(foodItem x, PantryFoodList list){
        for (int i = 0; i<list.size(); i++){
            if(list.get(i).equals(x)){
                return true;
            }
        }
        return false;
    }
    
    public void findEarliestExpire(){
        Date temp = ingredients.get(0).getExpire();
        for (int i = 1; i < ingredients.size(); i++){
            if (ingredients.get(i).getExpire().before(temp))
                temp = ingredients.get(i).getExpire();
        }
        earliestExpire = temp;
    }
    
    public void IngredientUpdate(PantryFoodList list){
        for(int i = 0; i<list.size(); i++){
            ingredients.get(i).setPantry(itemSearch(ingredients.get(i), list));
        }
    }
    
    public boolean IngredientSearch(){
        for(int i = 0; i<ingredients.size();i++){
            if (!ingredients.get(i).getPantry())
               return false;
        }
        return true;
    }
    public void totals(){
        for (int i = 0; i < ingredients.size();i++){
            calTotal += ingredients.get(i).getCal();
            sugarTotal += ingredients.get(i).getSugar();
            proteinTotal += ingredients.get(i).getProtein();
            carbsTotal += ingredients.get(i).getCarbs();
            fatTotal += ingredients.get(i).getFat();
            cholTotal += ingredients.get(i).getChol();
        }
    }
}
