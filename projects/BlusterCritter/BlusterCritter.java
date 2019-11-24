import java.awt.Color;
import java.util.ArrayList;

import info.gridworld.actor.Actor;
import info.gridworld.actor.Critter;
import info.gridworld.grid.Location;

public class BlusterCritter extends Critter {

	 private int courage;

	 public BlusterCritter(int c)
	 {
		 super();
		 courage = c;
	 } 
	 
	 public ArrayList<Actor> getActors()
	 {
		 ArrayList<Actor> acs = new ArrayList<Actor>();

		 Location loc = getLocation();
		 for(int r = loc.getRow() - 2; r <= loc.getRow() + 2; r++ )
			 for(int c = loc.getCol() - 2; c <= loc.getCol() + 2; c++)
			 {
				 Location Loc1 = new Location(r,c);
				 if(getGrid().isValid(Loc1))
				 {
					 Actor a = getGrid().get(Loc1);
					 if(a != null && a != this)
						 acs.add(a);
				 }
			 }
		 return acs;
	 } 
	 
	 public void processActors(ArrayList<Actor> actors)
	 {
		 int count = 0;
		 for(Actor a: actors)
			 if(a instanceof Critter)
				 count++;
		 if(count < courage)
			 lighten();
		 else
			 darken();
	 } 
	 
	 private void darken()
	 {
		 Color c = getColor();
		 int red = c.getRed();
		 int green = c.getGreen();
		 int blue = c.getBlue();
		 if(red > 0) red--;
		 if(green > 0) green--;
		 if(blue > 0) blue--;
		 setColor(new Color(red, green, blue)); 
	 }
	 
	 private void lighten()
	 {
		 Color c = getColor();
		 int red = c.getRed();
		 int green = c.getGreen();
		 int blue = c.getBlue();
		 if(red < 255) red++;
		 if(green < 255) green++;
		 if(blue < 255) blue++;
		 setColor(new Color(red, green, blue));
	 } 
}
