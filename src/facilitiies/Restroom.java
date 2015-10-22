/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package facilitiies;

/**
 *
 * @author Nirosha
 */
public class Restroom {
    
    private int infected;
    private int x;
    private int y;
    private int cleaned;
    private int id;
    private int infectedTime;

    
   public Restroom(){}
    
   public Restroom(int x, int y, int infected){
    this(x,y);
    this.infected=infected;
    }
    
   public Restroom(int x, int y){
    this.x=x;
    this.y=y;
   }

    public void setInfected(int infected) {
        this.infected = infected;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void setCleaned(int cleaned) {
        this.cleaned = cleaned;
    }

    public int getInfected() {
        return infected;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getCleaned() {
        return cleaned;
    }
    
     public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }
    
     public void contaminate(){
   
       double x=Math.random();
       
       if(x < 0.5)
           this.infected=1;
   } 
     
     public int getInfectedTime() {
        return infectedTime;
    }

    public void setInfectedTime(int infectedTime) {
        this.infectedTime = infectedTime;
    }
   
}
