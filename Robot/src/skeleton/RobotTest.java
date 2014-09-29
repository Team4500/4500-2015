package skeleton;

import processing.core.*;
import utilities.Vector;

public class RobotTest extends PApplet{
	public void setup(){
		size(500,500);
		background(0);
	}
	
	public void draw(){
		stroke(255);
		if(mousePressed){
			line(mouseX, mouseY, pmouseX, pmouseY);
		}
		
	}
	
	private class Robot{
		Wheel [] wheels;
		Vector[] actualPositions;
		
		
		public Robot(Vector [] positions){
			wheels = new Wheel[positions.length];
			actualPositions = new Vector[positions.length];
			
			for(int i = 0;i<positions.length;i++){
				wheels[i] = new Wheel(positions[i]);
				actualPositions[i] = Vector.zero;
			}
		}
		
		public void step(double timestep, Vector rotation, Vector velocity){
			for(Wheel w : wheels){
				w.setDirection(velocity, rotation);
				
			}
			
			for(int i = 0;i<wheels.length;i++){
				actualPositions[i] = actualPositions[i].add(wheels[i].getDirection().scale(timestep));
			}
			
		}
		
		public void draw(){
			stroke(255);
			
		}
		
		
	}

	
}



