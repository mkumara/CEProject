/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sir;

import facilitiies.Cabin;
import facilitiies.Pool;
import facilitiies.Restaurent;
import facilitiies.Restroom;
import facilitiies.ShipDeck;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

/**
 *
 * @author jmuthukudage
 */
public class SIRSimulator {

    private int NUM_IND = 2000;
    private int CONTACT_RATE = 3;
    private int INFECTIOUS_PERIOD = 2;
    private int LATENT_PERIOD = 2;
    private float INFECTIVITY = 0.95f;
    private int DURATION = 8;
    private float seaFoodPortion = 0.25f;
    private Individual population[];
    private int sus = 0;
    private int rec = 0;
    private int inf = 0;
    private int exp;
    private ShipDeck ship;
    private int MAX_IND_PER_CABIN=4;
    

    public SIRSimulator() {
           }

    public SIRSimulator(int numOfRestrooms, int numOfRestaurents, int numOfPools,int numOfCabins) {
        
       this.ship=new ShipDeck(numOfRestrooms, numOfRestaurents, numOfPools, numOfCabins);
                
        int assignedIndividuals=0;
        int remaining=this.NUM_IND;
        int cabinId=0;
        Cabin cabin[]=this.ship.getCabins();
       while(assignedIndividuals <= this.NUM_IND){
           
            int x = (int)(Math.random()*this.MAX_IND_PER_CABIN) + 1;
            if(x<2) // make sure at least two poeple in a cabin
                 x++;
            
            assignedIndividuals+=x;
            remaining=this.NUM_IND-assignedIndividuals;
            
             if(remaining <= this.MAX_IND_PER_CABIN){
                 cabin[cabinId]=new Cabin(new Restroom(0,0,0), x);
                 break;
             }
             
             cabin[cabinId]=new Cabin(new Restroom(0,0,0), x);
             
             cabinId++;
            
            }           
    }
    
     public SIRSimulator(ShipDeck ship) {
        
       this.ship=ship;
                
        int assignedIndividuals=0;
        int remaining=this.NUM_IND;
        int cabinId=0;
        Cabin cabin[]=this.ship.getCabins();
        while(assignedIndividuals <= this.NUM_IND){
           
            int x = (int)(Math.random()*this.MAX_IND_PER_CABIN) + 1;
            if(x<2) // make sure at least two poeple in a cabin
                 x++;
            
            assignedIndividuals+=x;
            remaining=this.NUM_IND-assignedIndividuals;
            
                      
             if(remaining <= this.MAX_IND_PER_CABIN){
                 cabin[cabinId]=new Cabin(new Restroom(0,0,0), x);
                 break;
             }
             
             cabin[cabinId]=new Cabin(new Restroom(0,0,0), x);
                        
             cabinId++;
            
            }           
    }

    public void run() {
        
        Cabin cabs[]=this.ship.getCabins();
        
        for(int i=0;i<1;i++){
         int x=(int)(Math.random()*this.ship.getNumOfCabins());
         //System.out.println("Num ind = "+ cabs[x].getNumIndividuals());
         cabs[x].infectCabin(); 
          //System.out.println("Cabin infected  "+ x +" "+ cabs[x].getInfected());
         
        }
        
        for(int j=0;j<this.DURATION;j++){
               
        this.ship.cleanRestRooms();
        this.ship.cleanRestaurents();
        this.ship.cleanPools();
        
         
         
         this.useDeckRestroom();
         
          this.ship.cleanRestRooms();
        this.ship.cleanRestaurents();
        this.ship.cleanPools();
         
         this.usePool();
         
        this.ship.cleanRestRooms();
        this.ship.cleanRestaurents();
        this.ship.cleanPools();
         this.useRestaurant();
         
         for (Cabin cab : cabs) {
            cab.useRestRoom();
        }
         
         for(Cabin cab : cabs){
        for(int i=0;i<cab.getNumIndividuals();i++){
              if((cab.getIndividuals()[i].getInfState())==1){
                 if(j >=this.LATENT_PERIOD)
                  cab.getIndividuals()[i].setInfState(2);                
              }else{
                if((cab.getIndividuals()[i].getInfState())==2){
                   if(j >=(this.LATENT_PERIOD + this.INFECTIOUS_PERIOD)){
                       cab.getIndividuals()[i].setInfState(3);
                  }
               }
              }
            }
        }
         
         //int tot=this.getInfectCount();
        // System.out.println("Total infections = "+tot);
         this.printStats();
        }
        
      
       
    }

    public void printStats() {
        this.sus = 0;
        this.inf = 0;
        this.rec = 0;
        this.exp=0;
        
        Cabin cabs[]=this.ship.getCabins();

        for(Cabin cab : cabs){
        for(int i=0;i<cab.getNumIndividuals();i++){
            if((cab.getIndividuals()[i].getInfState())==0)
                 this.sus++;
            if((cab.getIndividuals()[i].getInfState())==1)
                this.exp++;
            if((cab.getIndividuals()[i].getInfState())==2)
                this.inf++;
            if((cab.getIndividuals()[i].getInfState())==3)
                this.rec++;
          }
        }
       

        System.out.println("Suseptible=" + this.sus +" Exposed ="+this.exp + " Infected=" + this.inf + " Recovered=" + this.rec + "\n");
    }

    public void setInfectious(int num) {

        ArrayList markedInfectious = new ArrayList(num);
        int location;
        int i = 0;

        while (i < num) {

            location = (int) Math.round(Math.random() * (this.NUM_IND - 1));

            if (!markedInfectious.contains(location)) {
                markedInfectious.add(location);
                this.population[location].setInfState(1);
                i++;
            }

        }

        this.inf = num;
        this.sus = this.NUM_IND - this.inf;
        this.rec = 0;
        printStats();
    }
    
    public int getInfectCount(){
       Cabin cabs[]=this.ship.getCabins();
       int total=0;
        for (Cabin cab : cabs) {
            
            for(int i=0;i<cab.getNumIndividuals();i++){
              if((cab.getIndividuals()[i].getInfState())==2){
                total++;
              }
            }
        }
        
        return total;
    }
    
     public void useRestaurant(){
        
        //get the number of times an individual uses the restroom
        
        Cabin cabs[]=this.ship.getCabins();
        
        for(Cabin cab : cabs){
        
            for(int i=0;i<cab.getNumIndividuals();i++){
                
            int restaurent=(int)(Math.random()*this.ship.getNumOfRestaurents()) ;
           
            
            if((cab.getIndividuals()[i].getInfState())==2){
                double x=Math.random();
                if(x < 0.1){
                  this.ship.getRestaurents()[restaurent].setInfected(1);
                }
            } 
            
            if((this.ship.getRestaurents()[restaurent].getInfected())==1){
                double x=Math.random();
                if((this.ship.getRestaurents()[restaurent].getSeafood())==1){
                if(x < 0.1)
                    cab.getIndividuals()[i].setInfState(1);
              }
            }
           
           }  
        }
       
      
            
    }
     
     
     public void usePool(){
        
        //get the number of times an individual uses the restroom
        
        Cabin cabs[]=this.ship.getCabins();
        
        for(Cabin cab : cabs){
        
            for(int i=0;i<cab.getNumIndividuals();i++){
                
            int pool=(int)(Math.random()*this.ship.getNumOfPools());
           
            
            if((cab.getIndividuals()[i].getInfState())==2){
                double x=Math.random();
                if(x < 0.1)
                  this.ship.getPools()[pool].setInfected(1);
            } 
            
            Pool p=this.ship.getPools()[pool];
            if(p.getInfected()==1){
                double x=Math.random();
                if(x < 0.1)
                    cab.getIndividuals()[i].setInfState(1);
            }
           
           }  
        }
     } 
     
     
     public void useDeckRestroom(){
        
        //get the number of times an individual uses the restroom
        
        Cabin cabs[]=this.ship.getCabins();
        
        for(Cabin cab : cabs){
        
            for(int i=0;i<cab.getNumIndividuals();i++){
                
            int rest=(int)(Math.random()*this.ship.getNumOfRestrooms());
           
            
            if((cab.getIndividuals()[i].getInfState())==2){
                double x=Math.random();
                if(x < 0.5)
                  this.ship.getRestrooms()[rest].setInfected(1);
            } 
            
            Restroom r=(this.ship.getRestrooms())[rest];
            if(r.getInfected()==1){
                double x=Math.random();
                if(x < 0.5)
                    cab.getIndividuals()[i].setInfState(1);
            }
           
           }  
        }
     }  
  
    

}
