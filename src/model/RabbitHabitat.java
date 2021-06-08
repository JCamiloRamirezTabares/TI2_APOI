package model;

public class RabbitHabitat extends PetHabitat{
	
	private String plantType;
	private int amountOfPlants;
	
	public RabbitHabitat(String id, double length, double width, String plantType, int amountOfPlants){
		super(id, length, width);
		this.plantType = plantType;
		this.amountOfPlants = amountOfPlants;
	}
	
	//toString Method
	public String toString(){
		String info = "=======================================\n" +
		"=====  Information about Habitat  =====\n" +
		"============ RABBIT HABITAT ===========" +
		"=======================================\n" +
		"ID Habitat: " + idNumber + dimensions.toString() + 
		"\nType of use: " + useType +
		"\n=======================================\n" + 
		"A beatiful place that contains " + amountOfPlants + " " + plantType + " in its area" +
		"\n=======================================\n";
		
		if(petInsideTheHabitat != null){
			info += petInsideTheHabitat.toString();
		}
		
		return info;
	}
	
}