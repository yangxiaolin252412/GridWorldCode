import java.awt.Color;
import java.util.ArrayList;

import info.gridworld.actor.Actor;
import info.gridworld.grid.Location;

public class KingCrab extends CrabCritter{
	public KingCrab()
	{
		setColor(Color.YELLOW);
	}
	
	public int distance(Location loc1, Location loc2)
	{
		int x1 = loc1.getRow();
		int y1 = loc1.getCol();
		int x2 = loc2.getRow();
		int y2 = loc2.getCol();
		double dist = Math.sqrt((x1 - x2)*(x1 - x2) + (y1 - y2)*(y1 - y2)) + .5;
		return (int)Math.floor(dist);
	} 
	
	private boolean ifmoveAway(Actor a)
	{
		ArrayList<Location> locs =getGrid().getEmptyAdjacentLocations(a.getLocation());

		for(Location loc:locs)
		{
			if(distance(getLocation(), loc) > 1)
			{
				a.moveTo(loc);
				return true;
			}
		}

		return false;
	} 
	
	public void processActors(ArrayList<Actor> actors)
	{
		for (Actor a : actors)
		{
			if (!ifmoveAway(a))
			{
				a.removeSelfFromGrid();
			}
		}
	} 
}
