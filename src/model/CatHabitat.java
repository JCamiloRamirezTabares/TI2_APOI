package model;

public class CatHabitat extends PetHabitat{
	
	private double height;
	private double weight;
	
	public CatHabitat(String id, double length, double width, double height, double weight){
		super(id, length, width);
		this.height = height;
		this.weight = weight;
	} 
	
	//toString Method
	public String toString(){
		String info = "=======================================\n" +
		"=====  Information about Habitat  =====\n" +
		"============= CAT HABITAT =============\n" +
		"=======================================\n" +
		"ID Habitat: " + idNumber + dimensions.toString() + 
		"\nType of use: " + useType +
		"\n=======================================\n" + 
		"Height: " + height + 
		"Weight: " + weight +
		"\n=======================================\n";
		
		if(petInsideTheHabitat != null){
			info += petInsideTheHabitat.toString();
		}
		
		return info;
	}
	
}