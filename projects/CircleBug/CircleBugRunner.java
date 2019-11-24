import java.awt.Color;

import info.gridworld.actor.ActorWorld;
import info.gridworld.grid.Location;

public class CircleBugRunner {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ActorWorld world = new ActorWorld();
        CircleBug alice = new CircleBug(1);
        alice.setColor(Color.ORANGE);
        //CircleBug bob = new CircleBug(3);
        world.add(new Location(3, 3), alice);
        //world.add(new Location(5, 5), bob);
        world.show();
	}

}
