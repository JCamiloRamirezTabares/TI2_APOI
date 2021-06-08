package model;

public class BirdHabitat extends PetHabitat{
	
	private double height;
	private int numberOfBirdsSupported;
	private CageType cageType;
	
	public BirdHabitat(String id, double length, double width, double height, int numberOfBirdsSupported){
		super(id, length, width);
		this.height = height;
		this.numberOfBirdsSupported = numberOfBirdsSupported;
	}
	
	public void setCageType(CageType cageType){
		this.cageType = cageType;
	}
	
	//toString Method
	public String toString(){
		String info = "=======================================\n" +
		"=====  Information about Habitat  =====\n" +
		"============= BIRD HABITAT ============" +
		"=======================================\n" +
		"ID Habitat: " + idNumber + dimensions.toString() + 
		"\nType of use: " + useType +
		"\n=======================================\n";
		
		if(cageType != null){
			info += "A habitat of type: " + cageType;
		}
		 
		info += "\nWith a Heigh of " + height + " cm" +
		"\nA beatifull place with a maximum support of " + numberOfBirdsSupported + " birds" +
		"\n=======================================\n";
		
		if(petInsideTheHabitat != null){
			info += petInsideTheHabitat.toString();
		}
		
		return info;
	}
	
}