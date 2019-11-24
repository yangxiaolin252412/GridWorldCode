import info.gridworld.actor.Actor;
import info.gridworld.actor.ActorWorld;
import info.gridworld.actor.Bug;
import info.gridworld.actor.Flower;

public class JumperRunner {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ActorWorld world = new ActorWorld();
		 world.add(new Jumper());
		 world.add(new Actor());
		 world.add(new Bug());
		 world.add(new Flower());
		 world.show(); 
	}

}
