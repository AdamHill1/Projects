/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package turtlevehiclecontroller;
import BookClasses.*;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
/**
 *
 * @author clatulip
 */
public abstract class VehicleTurtle extends Turtle {

    private int paceTime = 100;
    private Color vehicleColor = Color.BLACK;


    public VehicleTurtle(int x, int y, ModelDisplay modelDisplayer) {
        super(x, y, modelDisplayer);
        initialize();
    }

    public VehicleTurtle(ModelDisplay modelDisplay) {
        super(modelDisplay);
        initialize();
    }
    
        /**
     * Set the value of vehicleColor
     *
     * @param vehicleColor new value of vehicleColor
     */
    public void setVehicleColor(Color vehicleColor) {
        this.vehicleColor = vehicleColor;
    }

    /**
     * Set the value of paceTime
     *
     * @param paceTime new value of paceTime
     */
    public void setPaceTime(int paceTime) {
        this.paceTime = paceTime;
    }
    
    @Override
    public void forward(int x) {
        try {
            for (int i = 0; i < (int)(x/2); i++) {   
                super.forward(2);
                Thread.sleep(paceTime);
            }
        } 
        catch (InterruptedException e) {
            System.out.println("Thread.sleep threw exception");
        }
    }
    
    @Override
    public void backward(int x) {
        try {
            for (int i = 0; i < x; i++) {      
                super.forward(-1);    
                Thread.sleep(paceTime);
            }
        } 
        catch (InterruptedException e) {
            System.out.println("Thread.sleep threw exception");
        }
    }
    
    public void initialize() {
        setBodyColor(vehicleColor);
        setPenColor(vehicleColor);
    }
    
    /**
   * Method to paint the turtle 
   * @param g the graphics context to paint on
   */
    @Override
  public abstract void paintComponent(Graphics g);
  
    
}










