

package AppPackage;

import java.util.Date;



public class foodItem {
    private String name="";
    private Date expire = new Date(); //need to figure out how to input the date
    private double cal = 0;
    private double sugar = 0;
    private double protein = 0;
    private double carbs = 0;
    private double fat = 0;
    private double chol = 0;
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
    //set methods
    public void setName(String name){
        this.name = name;
    }
    public void setExpire(Date expire){
        this.expire = expire;
    }
    public void setCal(double cal){
        this.cal = cal;
    }
    public void setSugar(double sugar){
        this.sugar = sugar;
    }
    public void setProtein(double protein){
        this.protein = protein;
    }
    public void setCarbs(double carbs){
        this.carbs = carbs;
    }
    public void setFat(double fat){
        this.fat = fat;
    }
    public void setChol(double chol){
        this.chol = chol;
    }
    public void setPantry(boolean pantry){
        Pantry = pantry;
    }
    //get methods
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
