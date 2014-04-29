/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package facilitiies;

import java.util.Arrays;
import java.util.Comparator;
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
    
    
    public void useRestRoom(){
        
        //get the number of times an individual uses the restroom
        int totalTimes=0;
        
        for(int i=0;i<this.numIndividuals;i++){
          totalTimes+=this.individuals[i].getSchedule().getTimesRestroom();
          }
        Integer[][] restRoomUse=new Integer[totalTimes][2];
        int count=0;
         for(int i=0;i<this.numIndividuals;i++){
           
             for(int j=0;j<this.individuals[i].getSchedule().getTimesRestroom();j++){
                 restRoomUse[count][1]=i;
                 restRoomUse[count][0]=(this.individuals[i].getSchedule().getRestroomSchedule())[j];
                 count++;
                 
             }
          }
             
       Arrays.sort(restRoomUse, new Comparator<Integer[]>(){
        @Override
        public int compare(Integer[] o1, Integer[] o2) {
            return o1[0].compareTo(o2[0]);
        }
        });
       
       for(int k=0;k<restRoomUse.length;k++){
       if(this.restroom.getInfected()==1){
          if(this.individuals[k].getInfState()==0){
          
              double x = Math.random();
              
              if(x < this.infectivity){
                  
                  this.individuals[k].setInfState(1);
              }
          }
              
        }
        
        //contaminating restroom if individual is infected
        
        if(this.individuals[k].getInfState()==2){
          if(this.restroom.getInfected()==0){
          
              double x = Math.random();
              
              if(x < 0.5){
                this.restroom.setInfected(1);
              }
          }
        }
           }      
            
    }
    
    public void infectCabin(){
      
        if(this.numIndividuals > 0){
        int x=(int)(Math.random()*this.getNumIndividuals());
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

