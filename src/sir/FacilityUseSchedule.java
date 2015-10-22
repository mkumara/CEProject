/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package sir;

import facilitiies.Global;
import java.util.Arrays;

/**
 *
 * @author jmuthukudage
 */
public class FacilityUseSchedule {
    
    private int timesPool;
    private int timesRestroom;
    private int timesRestaurant;
    
    private int poolSchedule[];
    private int restroomSchedule[];
    private int restaurantSchedule[];

    public FacilityUseSchedule(int timesPool, int timesRestroom, int timesRestaurant) {
        this.timesPool = timesPool;
        this.timesRestroom = timesRestroom;
        this.timesRestaurant = timesRestaurant;
        
        if(timesPool>0)
             this.poolSchedule=new int[timesPool];
        if(timesRestroom>0)
            this.restroomSchedule=new int[timesRestroom];
        if(timesRestaurant>0)
            this.restaurantSchedule=new int[timesRestaurant];
        
        // assign a schedule
        int count=0;
        while(count < timesPool ){
            
            int time=(int)(Math.random()*24) + Global.startTime;
            if(time < Global.endTime && (!Arrays.asList(poolSchedule).contains(time))){
                poolSchedule[count]=time;
                count++;
            }
        }
        
        count=0;
         while(count < timesRestroom ){
            
            int time=(int)(Math.random()*24) + Global.startTime;
            if(time < Global.endTime && (!Arrays.asList(restroomSchedule).contains(time))){
                restroomSchedule[count]=time;
                count++;
            }
        }
         
         count=0;
         while(count < timesRestaurant ){
            
            int time=(int)(Math.random()*24) + Global.startTime;
            if(time < Global.endTime && (!Arrays.asList(restaurantSchedule).contains(time))){
                restaurantSchedule[count]=time;
                count++;
            }
        }
           
    }
    
    

    public int getTimesPool() {
        return timesPool;
    }

    public void setTimesPool(int timesPool) {
        this.timesPool = timesPool;
    }

    public int getTimesRestroom() {
        return timesRestroom;
    }

    public void setTimesRestroom(int timesRestroom) {
        this.timesRestroom = timesRestroom;
    }

    public int getTimesRestaurant() {
        return timesRestaurant;
    }

    public void setTimesRestaurant(int timesRestaurant) {
        this.timesRestaurant = timesRestaurant;
    }

    public int[] getPoolSchedule() {
        return poolSchedule;
    }

    public void setPoolSchedule(int[] poolSchedule) {
        this.poolSchedule = poolSchedule;
    }

    public int[] getRestroomSchedule() {
        return restroomSchedule;
    }

    public void setRestroomSchedule(int[] restroomSchedule) {
        this.restroomSchedule = restroomSchedule;
    }

    public int[] getRestaurantSchedule() {
        return restaurantSchedule;
    }

    public void setRestaurantSchedule(int[] restaurantSchedule) {
        this.restaurantSchedule = restaurantSchedule;
    }
  
    
    public void printSchedule(){
    
        //restarants
        System.out.print("Restarant schedule in 24 hour clock =");
        for(int i=0;i<this.timesRestaurant;i++){
            System.out.print(" "+this.restaurantSchedule[i]+" ");
        }
        System.out.println();
        
         //restarants
        System.out.print("Pool schedule in 24 hour clock =");
        for(int i=0;i<this.timesPool;i++){
            System.out.print(" "+this.poolSchedule[i]+" ");
        }
        System.out.println();
        
         //restarants
        System.out.print("Restroom schedule in 24 hour clock =");
        for(int i=0;i<this.timesRestroom;i++){
            System.out.print(" "+this.restroomSchedule[i]+" ");
        }
        System.out.println();
    
    }
    
    
}
