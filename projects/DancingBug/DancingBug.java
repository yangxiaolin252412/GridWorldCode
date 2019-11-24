import info.gridworld.actor.Bug;

public class DancingBug extends Bug{

	private int[] turnList;
	 private int currentStep;

	 public DancingBug(int[] turnlist)
	 {
		 turnList = turnlist;
		 currentStep = 0;
	 }
	 public void turn(int num)
	 {
		 for(int j = 1; j <= num; j++)
		 {
		 	turn();
		 }
	 }

	 public void act()
	 {
		 if(currentStep == turnList.length)
			 currentStep = 0;
		 turn (turnList[currentStep]);
		 currentStep++;
		 super.act();
	 } 
}
