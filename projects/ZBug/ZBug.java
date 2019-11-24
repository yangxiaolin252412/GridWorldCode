import info.gridworld.actor.Bug;
import info.gridworld.grid.Location;

public class ZBug extends Bug{
	
	 private int stepLength; 
	 private int steps; 
	 private int step; 
	 
	 public ZBug(int l)
	 {
		 setDirection(Location.EAST);
		 steps = 0;
		 step = 1;
		 stepLength = l;
	 }
	 public void act()
	 {
		 if (step <= 3 && steps < stepLength)
		 {
			 if (canMove())
			 {
				 move();
				 steps++;
			 }
		 }
		 else if (step == 1)
		 {
			 setDirection(Location.SOUTHWEST);
			 steps = 0;
			 step++;
		 }
		 else if (step == 2)
		 {
			 setDirection(Location.EAST);
			 steps = 0;
			 step++;
		 }
	 } 
}
