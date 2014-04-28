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
public class Pool {
    
    private int id;
    private int x;
    private int y;
    private int infected;
    private int cleaned;
    private int capacity;

    public Pool(){}
    public Pool(int x, int y, int infected) {
        this.x = x;
        this.y = y;
        this.infected = infected;
    }

    public Pool(int x, int y, int capacity, int infected) {
        this.x = x;
        this.y = y;
        this.capacity = capacity;
        this.infected=infected;
    }
    
   public Pool(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getId() {
        return id;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getInfected() {
        return infected;
    }

    public int getCleaned() {
        return cleaned;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void setInfected(int infected) {
        this.infected = infected;
    }

    public void setCleaned(int cleaned) {
        this.cleaned = cleaned;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }
   
   public void contaminate(){
   
       double x=Math.random();
       
       if(x < 0.5)
           this.infected=1;
   } 
    
}
