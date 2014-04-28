/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package sir;

import facilitiies.*;

/**
 *
 * @author jmuthukudage
 */
public class SIR {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
       /* SIRSimulator ss=new SIRSimulator();
        System.out.println("Starting infection");
        ss.setInfectious(5);
        System.out.println("Starting run");
        ss.run();*/
        
        ShipDeck sd=new ShipDeck(10, 2,2,1000);
        sd.setInfectionInDeck(5, 1, 1);
        
        SIRSimulator sirsim=new SIRSimulator(sd);
        sirsim.run();
        
    }
    
}
