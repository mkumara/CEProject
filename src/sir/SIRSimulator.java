/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sir;

import facilitiies.Cabin;
import facilitiies.Restroom;
import facilitiies.ShipDeck;
import java.util.ArrayList;

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
         if(cabs[x].getNumIndividuals()>2)
          cabs[x].useRestRoom();
         //System.out.println("Cabin infected  "+ x +" "+ cabs[x].getInfected());
         
        }
       /* for (Cabin cab : cabs) {
            cab.printCabinSchedule();
        }*/
        
        this.ship.cleanRestRooms();
        
       /* for(int j=0;j<this.DURATION;j++){
          
        }*/
       
    }

    public void printStats() {
        this.sus = 0;
        this.inf = 0;
        this.rec = 0;

        for (int i = 0; i < this.NUM_IND; i++) {
            if (this.population[i].getInfState() == 0) {
                this.sus++;
            }

            if (this.population[i].getInfState() == 1) {
                this.inf++;
            }
            if (this.population[i].getInfState() == 2) {
                this.rec++;
            }
        }

        System.out.println("Suseptible=" + this.sus + " Infected=" + this.inf + " Recovered=" + this.rec + "\n");
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

}
