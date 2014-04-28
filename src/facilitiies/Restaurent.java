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
public class Restaurent {
    
    private int capacity;
    private int seafood;
    private int vegebar;
    private int id;
    private int infected;
    private int cleaned;

     public Restaurent() {}
     
    public Restaurent(int capacity) {
        this.capacity = capacity;
    }

    public Restaurent(int capacity, int seafood) {
        this.capacity = capacity;
        this.seafood = seafood;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public int getSeafood() {
        return seafood;
    }

    public void setSeafood(int seafood) {
        this.seafood = seafood;
    }

    public int getVegebar() {
        return vegebar;
    }

    public void setVegebar(int vegebar) {
        this.vegebar = vegebar;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getInfected() {
        return infected;
    }

    public void setInfected(int infected) {
        this.infected = infected;
    }

    public void setCleaned(int i) {
      this.cleaned=i;
    }
    
    public int getCleaned(){
     return this.cleaned;
    }
       
}
