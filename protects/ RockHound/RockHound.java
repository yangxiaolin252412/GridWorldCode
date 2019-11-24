import java.util.ArrayList;

import info.gridworld.actor.Actor;
import info.gridworld.actor.Critter;
import info.gridworld.actor.Rock;

public class RockHound extends Critter{

	public void processActors(ArrayList<Actor> actors)
	{
		for (Actor ar : actors)
		{
			if (ar instanceof Rock)
				ar.removeSelfFromGrid();
		}
	} 
}
