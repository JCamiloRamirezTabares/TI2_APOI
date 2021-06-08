package model;

public class ReptileHabitat extends PetHabitat{
	
	private String material;
	private ReptileTypeHabitat habitatType;
	
	public ReptileHabitat(String id, double length, double width, String material){
		super(id, length, width);
		this.material = material;
	}
	
	public void setHabitatType(ReptileTypeHabitat habitatType){
		this.habitatType = habitatType;
	}
	
	//toString Method
	public String toString(){
		String info = "=======================================\n" +
		"=====  Information about Habitat  =====\n" +
		"=========== REPTILE HABITAT ===========" +
		"=======================================\n" +
		"ID Habitat: " + idNumber + dimensions.toString() + 
		"\nType of use: " + useType +
		"\n=======================================\n";
		
		if(habitatType != null){
			info += "Type of Habitat: " + habitatType;
		}
		 
		info = "\nHabitat Material: " + material +
		"\n=======================================\n";
		
		if(petInsideTheHabitat != null){
			info += petInsideTheHabitat.toString();
		}
		
		return info;
	}
	
}