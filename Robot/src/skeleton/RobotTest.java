package skeleton;

import processing.core.*;
import utilities.Vector;

public class RobotTest extends PApplet{
	Robot robot;
	
	boolean left, right, up, down;
	boolean rotateRight;
	boolean rotateLeft;
	
	
	
	public void setup(){
		
		left = false;
		right = false;
		up = false;
		down = false;
		
		rotateRight = false;
		rotateLeft = false;
		
		size(500,500);
		background(0);
		robot = new Robot(new Vector[]{
				new Vector(-25,-25,0), 
				new Vector(25,-25,0),
				new Vector(25,25,0),
				new Vector(-25,25,0)});
	}
	
	public void draw(){
		stroke(255);
		background(0);
		robot.draw();
		
		double xVelocity = 0;
		double yVelocity = 0;
		double rotation = 0;
		if(left){
			xVelocity = -1;
		}
		if(right){
			xVelocity = 1;
		}
		if(up){
			yVelocity = -1;
		}
		if(down){
			yVelocity = 1;
		}
		
		
		if(rotateRight){
			rotation = .05;
		}
		if(rotateLeft){
			rotation = -.05;
		}
		
		robot.step(1, new Vector(0,0,rotation), new Vector(xVelocity, yVelocity, 0));
		
		
	}
	
	private class Robot{
		Wheel [] wheels;
		Vector[] actualPositions;
		Vector averageDisplacement;
		
		public Robot(Vector [] positions){
			wheels = new Wheel[positions.length];
			actualPositions = new Vector[positions.length];
			averageDisplacement = Vector.zero;
			
			for(int i = 0;i<positions.length;i++){
				wheels[i] = new Wheel(positions[i]);
				actualPositions[i] = positions[i];
			}
		}
		
		public void step(double timestep, Vector rotation, Vector velocity){
			
			
			averageDisplacement = averageDisplacement.add(velocity.scale(timestep));
			
			
			for(int i = 0;i<wheels.length;i++){
				wheels[i].setDirection(velocity, rotation, actualPositions[i].subtract(averageDisplacement));
				actualPositions[i] = actualPositions[i].add(wheels[i].getDirection().scale(timestep));
			}
			
		}
		
		public void draw(){
			stroke(255);
			for(int i = 1;i<actualPositions.length;i++){
				line((float)actualPositions[i-1].getX(), 
						(float)actualPositions[i-1].getY(),
						(float)actualPositions[i].getX(), 
						(float)actualPositions[i].getY());
				
			}
			
			line((float)actualPositions[0].getX(), 
					(float)actualPositions[0].getY(),
					(float)actualPositions[actualPositions.length-1].getX(), 
					(float)actualPositions[actualPositions.length-1].getY());
		}
		
		
	}

	
	public void keyPressed(){
		
		switch(keyCode){
		case 37://left
			left = true;
			break;
		case 39://right
			right = true;
			break;
		case 38://up
			up = true;
			break;
		case 40://down
			down = true;
			break;
		}
		
		switch(key){
		case 'a':
			rotateRight = true;
			break;
		case 'd':
			rotateLeft = true;
		}
	}
	
	public void keyReleased(){
		switch(keyCode){
		case 37://left
			left = false;
			break;
		case 39://right
			right = false;
			break;
		case 38://up
			up = false;
			break;
		case 40://down
			down = false;
			break;
		}
		
		switch(key){
		case 'a':
			rotateRight = false;
			break;
		case 'd':
			rotateLeft = false;
		}
		
	}
	
}



