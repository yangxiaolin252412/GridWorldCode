import java.awt.Color;

import info.gridworld.actor.Actor;
import info.gridworld.actor.Flower;
import info.gridworld.actor.Rock;
import info.gridworld.grid.Grid;
import info.gridworld.grid.Location;

public class Jumper extends Actor{

	public Jumper() {
		setColor(Color.PINK);
	}
	
	
	
	public void act() {
		if (canMove())
            move();
		else if(canJump()) {
			jump();
		}
        else
            turn();
	}
	
	public void jump()
	{
		Grid<Actor> gr = getGrid();
		if (gr == null)
			return;
		Location loc = getLocation();
		Location next = loc.getAdjacentLocation(getDirection());
		Location twoAway = next.getAdjacentLocation(getDirection());
		if (gr.isValid(twoAway))
			moveTo(twoAway);
		else
			removeSelfFromGrid();
	} 
	
	public boolean canJump()
	{
		Grid<Actor> gr = getGrid();
		if (gr == null)
			return false;
		Location loc = getLocation();
		Location next = loc.getAdjacentLocation(getDirection());
		if (!gr.isValid(next))
			return false;
		Actor neighbor = gr.get(next);
		if (!((neighbor == null) || (neighbor instanceof Flower)
				|| (neighbor instanceof Rock)))
			return false;
		Location twoAway = next.getAdjacentLocation(getDirection());
		if (!gr.isValid(twoAway))
			return false;

		neighbor = gr.get(twoAway);
		return (neighbor == null) ;
	 } 
	
	public void turn()
    {
        setDirection(getDirection() + Location.HALF_RIGHT);
    }
	
	 public boolean canMove()
	 {
		 Grid<Actor> gr = getGrid();
	     if (gr == null)
	            return false;
	     Location loc = getLocation();
	     Location next = loc.getAdjacentLocation(getDirection());
	     if (!gr.isValid(next))
	            return false;
	     Actor neighbor = gr.get(next);
	        return (neighbor == null);
	 }
	 
	 public void move()
	 {
	        Grid<Actor> gr = getGrid();
	        if (gr == null)
	            return;
	        Location loc = getLocation();
	        Location next = loc.getAdjacentLocation(getDirection());
	        if (gr.isValid(next))
	            moveTo(next);
	        else
	            removeSelfFromGrid();
	 }
}
