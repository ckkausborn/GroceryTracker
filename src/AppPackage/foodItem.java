

package AppPackage;

import java.util.Date;



public class foodItem {
    private String name="";
    private Date expire = new Date(); //need to figure out how to input the date
    private double cal;
    private double sugar;
    private double protein;
    private double carbs;
    private double fat;
    private double chol;
    private boolean Pantry;
    
    public foodItem(String name, Date expire){
        this.name = name;
        this.expire = expire;
    }
    public foodItem(String name, Date expire, double cal, double sugar, double 
            protein, double carbs, double fat, double chol, boolean Pantry){
        this.name = name;
        this.expire = expire;
        this.cal = cal;
        this.sugar = sugar;
        this.protein = protein;
        this.carbs = carbs;
        this.fat = fat;
        this.chol = chol;
        this.Pantry = Pantry;
    }
    public String getName(){
        return name;
    }
    public Date getExpire(){
        return expire;
    }
    public double getCal(){
        return cal;
    }
    public double getSugar(){
        return sugar;
    }
    public double getProtein(){
        return protein;
    }
    public double getCarbs(){
        return carbs;
    }
    public double getFat(){
        return fat;
    }
    public double getChol(){
        return chol;
    }
    public boolean getPantry(){
        return Pantry;
    }
}
