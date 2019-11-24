import java.awt.Color;

import info.gridworld.actor.ActorWorld;
import info.gridworld.grid.Location;

public class ZBugRunner {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ActorWorld world = new ActorWorld();
        ZBug alice = new ZBug(5);
        alice.setColor(Color.ORANGE);
        //BoxBug bob = new BoxBug(3);
        world.add(new Location(4, 4), alice);
        //world.add(new Location(5, 5), bob);
        world.show();
	}

}
