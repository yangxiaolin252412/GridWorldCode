import java.awt.Color;

import info.gridworld.actor.ActorWorld;
import info.gridworld.grid.Location;

public class DancingBugRunner {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ActorWorld world = new ActorWorld();
		 int[] turnlist = {3,1,2,4};
		 DancingBug dbug = new DancingBug(turnlist);
		 dbug.setColor(Color.ORANGE);
		 world.add(new Location(5, 5), dbug);
		 world.show(); 
	}

}
