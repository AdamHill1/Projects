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
public class PlaneTurtle extends VehicleTurtle {
    
    private final int PLANE_PACE = 10;
    private final Color PLANE_COLOR = Color.BLUE;

    public PlaneTurtle(ModelDisplay modelDisplay) {
        super(modelDisplay);
        initializePlane();
    }

    public PlaneTurtle(int x, int y, ModelDisplay modelDisplayer) {
        super(x, y, modelDisplayer);
        initializePlane();
    }
    
    private void initializePlane() {
        setPaceTime(PLANE_PACE);
        setVehicleColor(PLANE_COLOR);
        initialize();
    }
    
    @Override
    public void backward(int x) {
        turn(180);
        forward(x);
        turn(180);
    }
    
    @Override
  public synchronized void paintComponent(Graphics g)
  {
    // cast to 2d object (DON'T CHANGE THIS)
    Graphics2D g2 = (Graphics2D) g;
    
    // only bother with this if the VehicleTurtle object is visible
    if (this.isVisible())
    {
      // save the current tranform (DON'T CHANGE THIS)
      AffineTransform oldTransform = g2.getTransform();
      
      // rotate the turtle and translate to xPos and yPos (DON'T CHANGE THIS)
      g2.rotate(Math.toRadians(this.getHeading()),this.getXPos(),this.getYPos());
      
      // create local variables to use in drawing (you can change/add/remove)
      int width = 15;
      int height = 20;
      int halfWidth = (int) (width/2); 
      int halfHeight = (int) (height/2);
      int quarterWidth = (int) (width/4);
      int quarterHeight = (int) (height/4);
      
      // draw the inside of the vehicle
      g2.setColor(PLANE_COLOR);
      int[] xPoints = {this.getXPos() - halfWidth, this.getXPos(), this.getXPos() + halfWidth};
      int[] yPoints = {this.getYPos() + halfHeight, this.getYPos() - halfHeight, this.getYPos() + halfHeight};
      g2.fillPolygon(xPoints, yPoints, 3);
      
      
      // draw the outline of the vehicle
      g2.setColor(Color.BLACK);
      g2.drawPolygon(xPoints, yPoints, 3);
      
      penUp();
      getPen().paintComponent(g);
      
      // reset the tranformation matrix (DON'T CHANGE THIS)
      g2.setTransform(oldTransform);
    }
    
  }
}
