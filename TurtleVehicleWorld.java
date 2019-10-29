/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package turtlevehiclecontroller;
import BookClasses.*;

/**
 *
 * @author clatulip
 */
public class TurtleVehicleWorld {
    private World w;
    private TurtleVehicleModel myModel;
    
    
    public TurtleVehicleWorld(TurtleVehicleModel model){
        this.myModel = model;
        w = new World(myModel.getWorldWidth(), myModel.getWorldHeight());
        // register this world with the model
        myModel.registerWorld(this, w);
        
    }
    
    public void updateWorld() {
        w.modelChanged();
    }
    

    
}
