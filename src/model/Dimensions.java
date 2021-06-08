package model;

public class Dimensions{
	
	private double length;
	private double width;
	
	public Dimensions(double length, double width){
		
		this.length = length;
		this.width = width;
		
	}
	
	//toString Method
	public String toString(){
		return "\nDimensions:\nLength: " + length + "\nWidth: " + width + "\n=======================================\n";
	}
}