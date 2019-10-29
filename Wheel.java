package woffortune;

import java.util.ArrayList;

/**
 * This class defines a Wheel for the Wheel of Fortune game
 * @author clatulip
 */
public class Wheel {
    // enumerated type, wheel wedges can be any of these

    /**
     *types of wedges
     */
    public enum WedgeType { 

        /**
         *Money for wheel of fortune wedge
         */
        MONEY, 

        /**
         *Bankrupt for wheel of fortune wedge
         */
        BANKRUPT, 

        /**
         *Lose a turn for wheel of fortune wedge
         */
        LOSE_TURN, 

        /**
         *Prizes for wheel of fortune wedge
         */
        PRIZE}
    // the type for the current sping
    private WedgeType spinType;
    // if a money wedge, the amount
    private int spinDollarAmount;
    // list of wedges
    private ArrayList<Wedge> wedges = new ArrayList<Wedge>();

    /**
     * Constructor
     * Creates the wheel
     */
    public Wheel() {
        // put a bankrupt wedge on the wheel
        wedges.add(new Wedge(WedgeType.BANKRUPT));
        
        // put prize wedge on the wheel
        wedges.add(new Wedge(WedgeType.PRIZE));
        
        // put a lose-turn wedge on the wheel
        wedges.add(new Wedge(WedgeType.LOSE_TURN));
        
        // put 20 money wedges on the wheel
        for (int i = 1; i < 20; i++) {
            wedges.add(new Wedge(WedgeType.MONEY));
        }

    }
    
    /**
     * Spins the wheel
     * @return WedgeType 
     */
    public WedgeType spin() {
        int index = (int)(Math.random()*wedges.size());
        spinType = wedges.get(index).getType();
        spinDollarAmount = wedges.get(index).getAmount();
        return spinType;
    }
    
    /**
     * Getter
     * For when the spin lands on a money wedge
     * @return int the amount of money on the wedge
     */
    public int getAmount() {
        return spinDollarAmount;
    }
    
}
