package model;

public class DogHabitat extends PetHabitat{
	
	private int amountToys;
	
	public DogHabitat(String id, double length, double width, int amountToys){
		super(id, length, width);
		this.amountToys = amountToys;
	}
	
	//toString Method
	@Override
	public String toString(){
		String info = "=======================================\n" +
		"=====  Information about Habitat  =====\n" +
		"============= DOG HABITAT =============" +
		"=======================================\n" +
		"ID Habitat: " + idNumber + dimensions.toString() + 
		"\nType of use: " + useType +
		"\n=======================================\n" + 
		"The habitat contains " + amountToys + " toys for the Dog" + 
		"\n=======================================\n";
		
		if(petInsideTheHabitat != null){
			info += petInsideTheHabitat.toString();
		}
		
		return info;
	}
	
}