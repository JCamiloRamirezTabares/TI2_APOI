package model;

public class PetHabitat{
	
	protected String idNumber;
	protected Dimensions dimensions;
	protected UseState useType;
	protected Pet petInsideTheHabitat;
	
	public PetHabitat(String id, double length, double width){
		idNumber = id;
		dimensions = new Dimensions(length, width);
		useType = UseState.EMPTY_EMPTY;
		petInsideTheHabitat = null;
	}
	
	//Methods
	public void setUseType(UseState state){
		useType = state;
	}
	
	public void setPetInsideTheHabitat(Pet aPet){
		petInsideTheHabitat = aPet;
	}
	
	public String getIdNumber(){
		return idNumber;
	}
	
	public Pet getPetInsideTheHabitat(){
		return petInsideTheHabitat;
	}
	
	//toString Method
	public String toString(){
		String info = "Information about Habitat\n" +
		"ID Habitat: " + idNumber + 
		"\n=======================================" + dimensions.toString() + 
		"\nType of use: " + useType +
		"\n=======================================\n";
		
		return info;
	}
	
	
}