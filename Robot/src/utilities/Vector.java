package utilities;

public class Vector {
	double x,y,z;
	public Vector(double x, double y, double z){
		this.x = x;
		this.y = y;
		this.z = z;
		
	}
	
	public Vector add(Vector other){
		return new Vector(x+other.x, y+other.y, z+other.z);
	}
	
	public Vector subtract(Vector other){
		return new Vector(x-other.x, y-other.y, z-other.z);
	}
	
	public double dot(Vector other){
		return x*other.x + y*other.y + z*other.z;
	}
	
	public Vector cross(Vector other){
		return new Vector(
				y*other.z - z*other.y,
				z*other.x - x*other.z,
				x*other.y - y*other.x
				);
	}
	
	public double magnitude(){
		return Math.sqrt(x*x + y*y + z*z);
	}
	
	public double magnitudeSquared(){
		return x*x + y*y + z*z;
	}
	
	public Vector normalize(){
		double mag = magnitude();
		return new Vector(x/mag, y/mag, z/mag);
	}
	
	public boolean equals(Vector other){
		return x == other.x && y == other.y && z == other.z;
	}
	
	public Vector scale(double factor){
		return new Vector(x*factor, y*factor, z*factor);
	}
	
	public static void main(String[] args){
		Vector a = new Vector(1,1,1);
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
		
		
	}
}
