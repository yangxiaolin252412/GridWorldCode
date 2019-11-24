import java.awt.Color;
import java.util.ArrayList;

import info.gridworld.actor.Actor;
import info.gridworld.actor.Critter;
import info.gridworld.grid.Location;

public class ModifiedChameleonCritter extends Critter
{
    /**
     * Randomly selects a neighbor and changes this critter's color to be the
     * same as that neighbor's. If there are no neighbors, no action is taken.
     */
	
	private static final double DF = 0.05;
	
    public void processActors(ArrayList<Actor> actors)
    {
        int n = actors.size();
        if (n == 0) {
        	darken();
            return;
        }
        int re = (int) (Math.random() * n);

        Actor other = actors.get(re);
        setColor(other.getColor());
    }
    
    private void darken()
    {
     Color col = getColor();
     int red = (int) (col.getRed() * (1 - DF));
     int green = (int) (col.getGreen() * (1 - DF));
     int blue = (int) (col.getBlue() * (1 - DF));
     setColor(new Color(red, green, blue));
    } 

    /**
     * Turns towards the new location as it moves.
     */
    public void makeMove(Location loc)
    {
        setDirection(getLocation().getDirectionToward(loc));
        super.makeMove(loc);
    }
}