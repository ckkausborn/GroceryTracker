

package AppPackage;

import java.text.SimpleDateFormat;
import java.util.Date;



public class foodItem {
    SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy"); 
    private String name="";
    private Date expire = new Date(); //need to figure out how to input the date
    private double cal = 0;
    private double sugar = 0;
    private double protein = 0;
    private double carbs = 0;
    private double fat = 0;
    private double chol = 0;
    private double price = 0;
    private boolean Pantry = true;
    private boolean showPrice = true;
    
    public foodItem(String name, double price, Date expire){
        this.name = name;
        this.expire = expire;
        this.price = price;
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
    public void setShowPrice(boolean b){
        showPrice = b;
    }
    public void setPrice(double price){
        this.price = price;
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
    public boolean getShowPrice(){
        return showPrice;
    }
    public double getPrice(){
        return price;
    }
}
