
package AppPackage;

import java.util.ArrayList;
import java.util.Date;


public class RecipeList {
    ArrayList<Recipe> recipeList;
    ArrayList<String> recipeListNames;
    
    public RecipeList(){
        recipeList = new ArrayList<Recipe>();
        recipeListNames = new ArrayList<String>();
    }
    
    public int add(String name){
        recipeList.add(new Recipe(name));
        recipeListNames.add(name);
        return recipeList.size()-1; //index of the newly created object
    }
    
    public int size(){
        return recipeList.size();
    }
    
    public Recipe get(int index){
        return recipeList.get(index);
    }
    
    public void updateNameList(){
        recipeListNames.clear();
        for (int i= 0; i < recipeList.size(); i++){
            recipeListNames.add(recipeList.get(i).getRecipeName());
        }
    }
    
    public Recipe remove (int index){
        return recipeList.remove(index);
    }
    
    public int indexOf(Recipe x){
        return recipeList.indexOf(x);
    }
}
