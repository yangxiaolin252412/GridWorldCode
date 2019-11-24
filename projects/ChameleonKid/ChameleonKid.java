import java.util.ArrayList;

import info.gridworld.actor.Actor;
import info.gridworld.grid.Grid;
import info.gridworld.grid.Location;

public class ChameleonKid extends ModifiedChameleonCritter {

	 public ArrayList<Actor> getActors()
	 {
		 ArrayList<Actor> acts = new ArrayList<Actor>();
		 int[] dirs =
			 { Location.AHEAD, Location.HALF_CIRCLE };
		 for (Location loc : getLocationsInDirections(dirs))
		 {
			 Actor a = getGrid().get(loc);
			 if (a != null)
				 acts.add(a);
		 }
		 return acts;
	 } 
	 
	 public ArrayList<Location> getLocationsInDirections(int[] directions)
	 {
		 ArrayList<Location> locs = new ArrayList<Location>();
		 Grid gr = getGrid();
		 Location loc = getLocation();

	 	for (int d : directions)
	 	{
	 		Location neighborLoc = loc.getAdjacentLocation(getDirection() + d);
	 		if (gr.isValid(neighborLoc))
	 			locs.add(neighborLoc);
	 	}
	 	return locs;
	 } 
}
