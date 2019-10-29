/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package turtlevehiclecontroller;

import BookClasses.*;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author clatulip
 */
public class TurtleVehicleModel {
    private int worldWidth;
    private int worldHeight;
    private TurtleVehicleWorld myWorld;
    private World w;
    private PlaneTurtle t;
    

    public TurtleVehicleModel(int worldWidth, int worldHeight) {
        this.worldWidth = worldWidth;
        this.worldHeight = worldHeight;
        
    }

    public int getWorldWidth() {
        return worldWidth;
    }

    public int getWorldHeight() {
        return worldHeight;
    }
    
    public void registerWorld(TurtleVehicleWorld vw, World w) {
        this.myWorld = vw;
        this.w = w;
        t = new PlaneTurtle(w);
    }
    
    public void setHeading(int num) {
        if (t != null) {
            t.setHeading(num);
            myWorld.updateWorld();
        }
    }
    
    public void forward(int num) {
        if (t!=null) {
            t.forward(num);
            myWorld.updateWorld();
        }
        
    }
    
    public void setPos(int x, int y) {
        t.moveTo(x, y);
        myWorld.updateWorld();
    }
    
    public int getTurtleX() {
        if (t == null) return -1;
        return t.getXPos();
    }
    
    public int getTurtleY() {
        if (t == null) return -1;
        return t.getYPos();
    }
    
    public void drawSquare(){
        t.penDown();
        t.setHeading(0);
        t.forward(50);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException ex) {
            Logger.getLogger(TurtleVehicleModel.class.getName()).log(Level.SEVERE, null, ex);
        }
        t.setHeading(90);
        t.forward(50);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException ex) {
            Logger.getLogger(TurtleVehicleModel.class.getName()).log(Level.SEVERE, null, ex);
        }
        t.setHeading(180);
        t.forward(50);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException ex) {
            Logger.getLogger(TurtleVehicleModel.class.getName()).log(Level.SEVERE, null, ex);
        }
        t.setHeading(270);
        t.forward(50);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException ex) {
            Logger.getLogger(TurtleVehicleModel.class.getName()).log(Level.SEVERE, null, ex);
        }
        t.setHeading(0);
        t.penUp();
        
        
    }
}
