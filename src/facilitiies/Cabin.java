/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package facilitiies;

import sir.Individual;

/**
 *
 * @author jmuthukudage
 */
public class Cabin {
    
    private Restroom restroom;
    private int numIndividuals;
    private Individual individuals[];
    private final float seaFoodPortion = 0.25f;
    private float infectivity=0.95f;

    public Cabin(Restroom restroom, int numIndividuals) {
        this.restroom = restroom;
        this.numIndividuals = numIndividuals;
        this.individuals = new Individual[numIndividuals];
        
        
        for(int i=0;i<this.numIndividuals;i++){
           boolean seaFood=false; 
           double x = Math.random();
            if (x < this.seaFoodPortion) 
                    seaFood =true;           
           this.individuals[i]=new Individual(0,seaFood,false); 
        }
    }

   public  Cabin() {
    }
   

    public Restroom getRestroom() {
        return restroom;
    }

    public void setRestroom(Restroom restroom) {
        this.restroom = restroom;
    }

    public int getNumIndividuals() {
        return numIndividuals;
    }

    public void setNumIndividuals(int numIndividuals) {
        this.numIndividuals = numIndividuals;
    }

    public Individual[] getIndividuals() {
        return individuals;
    }

    public void setIndividuals(Individual[] individuals) {
        this.individuals = individuals;
    }
    
     public float getInfectivity() {
        return infectivity;
    }

    public void setInfectivity(float infectivity) {
        this.infectivity = infectivity;
    }
    
    
    public void useRestRoom(int indIndex){
        
        if(this.restroom.getInfected()==1){
          if(this.individuals[indIndex].getInfState()==0){
          
              double x = Math.random();
              
              if(x < this.infectivity){
                  
                  this.individuals[indIndex].setInfState(1);
              }
          }
        }
        
        //contaminating restroom if individual is infected
        
        if(this.individuals[indIndex].getInfState()==2){
          if(this.restroom.getInfected()==0){
          
              double x = Math.random();
              
              if(x < 0.5){
                this.restroom.setInfected(1);
              }
          }
        }
            
    }
    
    public void infectCabin(){
      
        if(this.numIndividuals > 0){
        int x=(int)(Math.random()*this.getNumIndividuals());
        System.out.println(x+" out of "+this.numIndividuals);
        this.individuals[x].setInfState(1);
        }
    }

   public int getInfected() {
     
       for(int i=0;i<this.numIndividuals;i++)
       {
         if(this.individuals[i].getInfState()==1) 
             return 1;
       }
       
       return 0;
    }
   
   public void printCabinSchedule(){
   
       for(int i=0;i<this.numIndividuals;i++){
           this.individuals[i].getSchedule().printSchedule();
       }
   }
    
}

