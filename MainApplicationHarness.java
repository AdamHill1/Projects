/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package turtlevehiclecontroller;

/**
 *
 * @author clatulip
 */
public class MainApplicationHarness {
    public static void main(String[] args) {
        TurtleVehicleModel myModel = new TurtleVehicleModel(1000, 800);
        TurtleVehicleController myController = new TurtleVehicleController(myModel);
        TurtleVehicleWorld myWorld = new TurtleVehicleWorld(myModel);
        
        // make the controller appear off to the right of the World
        myController.setLocation(1000, 100);
        myController.setVisible(true);
        
    }
}
