package skeleton;

import utilities.Vector;

public class Wheel {
	private Vector position, direction; // position represents the location of the wheel with respect to the
										//center of the robot with +y being towards the front and +x being to the right
										//facing towards the frong
	
	/**
	 * Takes a position representing the position of the wheel with respect to the robot.
	 * @param position
	 */
	public Wheel(Vector position){
		this.position = position;
		this.direction = new Vector(0,0,0);
	}
	
	public static void main(String[] args){
		
	}
}
