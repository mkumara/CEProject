/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package sir;

import facilitiies.Global;

/**
 *
 * @author jmuthukudage
 */
public class Individual {
    
    private int age;
    private int daysOfInfection;
    private int infState;
    private boolean seaFood;
    private boolean quarantine;
    private FacilityUseSchedule schedule;

    public FacilityUseSchedule getSchedule() {
        return schedule;
    }

    public void setSchedule(FacilityUseSchedule schedule) {
        this.schedule = schedule;
    }

    public Individual(int infState, boolean seaFood, boolean quarantine) {
        this.infState = infState;
        this.seaFood = seaFood;
        this.quarantine = quarantine;
        
        int timesPool, timesRestroom, timesRestaurant;
        timesPool=(int)(Math.random()*Global.MAX_POOL_TIMES);
        timesRestroom=(int)(Math.random()*Global.MAX_RESTROOM_TIMES);
        timesRestaurant=(int)(Math.random()*Global.MAX_RESTAURANT_TIMES);
        this.schedule=new FacilityUseSchedule(timesPool, timesRestroom, timesRestaurant);
    }
    

   public Individual(){}
    
    public Individual(int inf, int daysOfInf){
      this.daysOfInfection=daysOfInf;
      this.infState=inf;
    }
    
    public void incDays(){
     this.daysOfInfection++;
    }
    
    public int getDays(){
    return this.daysOfInfection;
    }
    
    public void setInfState(int state){
        this.infState=state;
    }
    
    public int getInfState(){
    return this.infState;
    }
    
     public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public boolean isSeaFood() {
        return seaFood;
    }

    public void setSeaFood(boolean seaFood) {
        this.seaFood = seaFood;
    }
    
     public int getDaysOfInfection() {
        return daysOfInfection;
    }

    public void setDaysOfInfection(int daysOfInfection) {
        this.daysOfInfection = daysOfInfection;
    }

    public boolean isQuarantine() {
        return quarantine;
    }

    public void setQuarantine(boolean quarantine) {
        this.quarantine = quarantine;
    }
    
}
