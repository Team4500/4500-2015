package utilities;

public class Vector {
	private double x,y,z;
	
	/**
	 * Returns the X component of the vector.
	 * @return
	 */
	public double getX(){
		return x;
	}
	
	/**
	 * Returns the Y component of the vector.
	 * @return
	 */
	public double getY(){
		return y;
	}
	
	/**
	 * Returns the Z component of the vector
	 * @return
	 */
	public double getZ(){
		return z;
	}
	
	/**
	 * Constructor for vector <x, y, z>
	 * @param x
	 * @param y
	 * @param z
	 */
	public Vector(double x, double y, double z){
		this.x = x;
		this.y = y;
		this.z = z;
		
	}
	
	/**
	 * Adds two vectors together and returns the result.
	 * @param other
	 * @return
	 */
	public Vector add(Vector other){
		return new Vector(x+other.x, y+other.y, z+other.z);
	}
	
	/**
	 * Subtracts other from this vector and returns the result.
	 * @param other
	 * @return
	 */
	public Vector subtract(Vector other){
		return new Vector(x-other.x, y-other.y, z-other.z);
	}
	
	/**
	 * Finds the dot product of this vector and the other vector.
	 * @param other
	 * @return
	 */
	public double dot(Vector other){
		return x*other.x + y*other.y + z*other.z;
	}
	
	/**
	 * Returns the cross product of this vector and the other vector in that order.
	 * @param other
	 * @return
	 */
	public Vector cross(Vector other){
		return new Vector(
				y*other.z - z*other.y,
				z*other.x - x*other.z,
				x*other.y - y*other.x
				);
	}
	
	/**
	 * Returns the magnitude of the vector,
	 * @return
	 */
	public double magnitude(){
		return Math.sqrt(x*x + y*y + z*z);
	}
	
	/**
	 * Returns the magnitude squared of the vector.
	 * @return
	 */
	public double magnitudeSquared(){
		return x*x + y*y + z*z;
	}
	
	/**
	 * Returns a unit vector pointing in the direction of this vector.
	 * @return
	 */
	public Vector normalize(){
		double mag = magnitude();
		return new Vector(x/mag, y/mag, z/mag);
	}
	
	/**
	 * Returns true if this vector equals the other vector, otherwise it returns false.
	 * @param other
	 * @return
	 */
	public boolean equals(Vector other){
		return x == other.x && y == other.y && z == other.z;
	}
	
	/**
	 * Returns this vector scaled by a scale factor.
	 * @param factor
	 * @return
	 */
	public Vector scale(double factor){
		return new Vector(x*factor, y*factor, z*factor);
	}
	
	/*
	 * Rotates the vector about the Z axis theta radians with positive 
	 * being counterclockwise looking down onto the vector (in the -Z direction)
	 */
	public Vector rotateAboutZAxis(double theta){
		double newX = x*Math.cos(theta) - y*Math.sin(theta);
		double newY = x*Math.sin(theta) + y*Math.cos(theta);
		
		return new Vector(newX, newY, z);
		
		
	}
	
	public String toString(){
		return "<"+x+", "+y+", "+z+">";
	}
	
	
	public static void main(String[] args){
		/*Vector a = new Vector(1,1,1);
		Vector b = new Vector(1,1,1);
		Vector f = new Vector(2,2,2);
		
		Vector c = new Vector(1,0,0);
		Vector d = new Vector(0,1,0);
		Vector e = new Vector(1,-1,1);
		
		System.out.println(a.equals(b) + " " +
		(a.add(b).equals(f))+ " " +
		(e.magnitude() == Math.sqrt(3))+ " " +
		(a.scale(4).equals(new Vector(4,4,4)))+ " " +
		(a.dot(b) == 3.0)+ " " +
		(c.normalize().equals(c))+ " " +
		(c.cross(d).equals(new Vector(0,0,1)))); //running tests
		
		c.cross(d);*/
		
		Vector a = new Vector(0,1,0);
		System.out.println(a+" "+a.rotateAboutZAxis(Math.PI/2));
		
	}
}
