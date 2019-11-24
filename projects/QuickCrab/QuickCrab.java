import java.awt.Color;
import java.util.ArrayList;

import info.gridworld.grid.Grid;
import info.gridworld.grid.Location;

public class QuickCrab extends CrabCritter {

	public QuickCrab()
	{
		setColor(Color.BLUE);
	}
	
	public ArrayList<Location> getMoveLocations()
	{
		ArrayList<Location> locs = new ArrayList<Location>();

		addMove(locs,getDirection() + Location.LEFT);
		addMove(locs,getDirection() + Location.RIGHT);

		if (locs.size() == 0)
			return super.getMoveLocations();

		return locs;
	} 
	
	private void addMove(ArrayList<Location> locs,int dir)
	{
		Grid gr = getGrid();
		Location loc = getLocation();

		Location temp = loc.getAdjacentLocation(dir);

		if(gr.isValid(temp) && gr.get(temp) == null)
		{
			Location loc2 = temp.getAdjacentLocation(dir);
			if(gr.isValid(loc2) && gr.get(loc2)== null)
				locs.add(loc2);
		}
	} 
}
