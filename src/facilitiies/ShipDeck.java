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
public class ShipDeck {
    
    private int numOfRestrooms;
    private int numOfRestaurents;
    private int numOfPools;
    private int numOfCabins;

    private Pool pools[];
    private Restaurent restaurents[];
    private Restroom restrooms[];
    private Cabin cabins[];
    
    public ShipDeck(){}
    
    public ShipDeck(int numOfRestrooms, int numOfRestaurents, int numOfPools, int numOfCabins) {
        this.numOfRestrooms = numOfRestrooms;
        this.numOfRestaurents = numOfRestaurents;
        this.numOfPools = numOfPools;
        this.numOfCabins=numOfCabins;
        
        this.pools=new Pool[this.numOfPools];
        this.restaurents=new Restaurent[this.numOfRestaurents];
        this.restrooms=new Restroom[this.numOfRestrooms];
        this.cabins=new Cabin[this.numOfCabins];
        
        for(int i=0;i<this.numOfPools;i++){
            this.pools[i]=new Pool(0,0,0);
           }
        
        for(int i=0;i<this.numOfRestaurents;i++){
            this.restaurents[i]=new Restaurent();
            this.restaurents[i].setInfected(0);
        }
        
        for(int i=0;i<this.numOfRestrooms;i++){
            this.restrooms[i]=new Restroom(0,0,0);
            
        }
        
         for(int i=0;i<this.numOfCabins;i++){
            this.cabins[i]=new Cabin();
            
        }
        
               
    }
        
    public int getNumOfRestrooms() {
        return numOfRestrooms;
    }

    public void setNumOfRestrooms(int numOfRestrooms) {
        this.numOfRestrooms = numOfRestrooms;
    }

    public int getNumOfRestaurents() {
        return numOfRestaurents;
    }

    public void setNumOfRestaurents(int numOfRestaurents) {
        this.numOfRestaurents = numOfRestaurents;
    }

    public int getNumOfPools() {
        return numOfPools;
    }

    public void setNumOfPools(int numOfPools) {
        this.numOfPools = numOfPools;
    }

    public Pool[] getPools() {
        return pools;
    }

    public void setPools(Pool[] pools) {
        this.pools = pools;
    }

    public Restaurent[] getRestaurents() {
        return restaurents;
    }

    public void setRestaurents(Restaurent[] restaurents) {
        this.restaurents = restaurents;
    }

    public Restroom[] getRestrooms() {
        return restrooms;
    }

    public void setRestrooms(Restroom[] restrooms) {
        this.restrooms = restrooms;
    }
    
    public int getNumOfCabins() {
        return numOfCabins;
    }

    public void setNumOfCabins(int numOfCabins) {
        this.numOfCabins = numOfCabins;
    }

    public Cabin[] getCabins() {
        return cabins;
    }

    public void setCabins(Cabin[] cabins) {
        this.cabins = cabins;
    }
   
      public void setInfectionInDeck(int infectedRestRooms, int infectedPools, int infectedRestaurents)
    {
       this.setInfectedPools(infectedPools);
       this.setInfectedRestrooms(infectedRestRooms);
       this.setInfectedRestaurents(infectedRestaurents);
    }
    
    public void setInfectedRestrooms(int numberOfInfected){
    
        if(numberOfInfected >= this.numOfRestrooms){
           for(int i=0;i<this.numOfRestrooms;i++){
               this.restrooms[i].setInfected(1);
           }
        }
        else//randomly infect restrooms
        {
            int control=0;
            while(control<numberOfInfected){
              int  ran=(int)(Math.random()*this.numOfRestrooms);
               
               if(this.restrooms[ran].getInfected()==0){
                 this.restrooms[ran].setInfected(1);
                 control++;
               }
            }       
        }
    }
    
      
     public void setInfectedRestaurents(int numberOfInfected){
    
        if(numberOfInfected >= this.numOfRestaurents){
           for(int i=0;i<this.numOfRestaurents;i++){
               this.restaurents[i].setInfected(1);
           }
        }
        else//randomly infect restrooms
        {
             int control=0;
            while(control<numberOfInfected){
              int  ran=(int)(Math.random()*this.numOfRestaurents);
              
               if(this.restaurents[ran].getInfected()==0){
                 this.restaurents[ran].setInfected(1);
                 control++;
               }
            }       
        }
    }
     
     
 public void setInfectedPools(int numberOfInfected){
    
        if(numberOfInfected >= this.numOfPools){
           for(int i=0;i<this.numOfPools;i++){
               this.pools[i].setInfected(1);
           }
        }
        else//randomly infect restrooms
        {
            int control=0;
            while(control< numberOfInfected){
              int  ran=(int)(Math.random()*this.numOfPools);
              
               if(this.pools[ran].getInfected()==0){
                 this.pools[ran].setInfected(1);
                 control++;
               }
            }       
        }
    }
 
 public void setInfectedCabins(int numberOfInfected){
    
        if(numberOfInfected >= this.numOfCabins){
           for(int i=0;i<this.numOfCabins;i++){
               this.cabins[i].infectCabin();
           }
        }
        else//randomly infect restrooms
        {
            int control=0;
            while(control< numberOfInfected){
              int  ran=(int)(Math.random()*this.numOfCabins);
              
               if(this.cabins[ran].getInfected()==0){
                 this.cabins[ran].infectCabin();
                 control++;
               }
            }       
        }
    }
 
 
 public void cleanRestRooms(){
 
     for(int i=0;i<this.numOfRestrooms;i++){
       this.restrooms[i].setCleaned(1);
       this.restrooms[i].setInfected(0);
     }
     
      for(int i=0;i<this.numOfCabins;i++){
          
          (this.getCabins())[i].setInfectivity(0);
      }
      
 }
 
 public void cleanPools(){
 
     for(int i=0;i<this.numOfPools;i++){
       this.pools[i].setCleaned(1);
       this.pools[i].setInfected(0);
     }
 }
 
  public void cleanRestaurents(){
 
     for(int i=0;i<this.numOfRestaurents;i++){
       this.restaurents[i].setCleaned(1);
       this.restaurents[i].setInfected(0);
     }
 }
     
     
       
}
