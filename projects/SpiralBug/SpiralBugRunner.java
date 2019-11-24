import java.awt.Color;

import info.gridworld.actor.Actor;
import info.gridworld.actor.ActorWorld;
import info.gridworld.grid.Location;
import info.gridworld.grid.UnboundedGrid;

public class SpiralBugRunner {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		UnboundedGrid grid = new UnboundedGrid<Actor>();
		ActorWorld world = new ActorWorld(grid);
        SpiralBug alice = new SpiralBug(1);
        alice.setColor(Color.ORANGE);
        //BoxBug bob = new BoxBug(3);
        world.add(new Location(5, 5), alice);
        //world.add(new Location(5, 5), bob);
        world.show();
	}

}
