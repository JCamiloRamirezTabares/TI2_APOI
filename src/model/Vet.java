package model;

public class Vet{
	
	private String idNumber;
	private String name;
	private String lastName;
	private String uVR;
	private String status;
	private int numbVeterinaryConsultation;
	
	//Constructor Method
	public Vet(String idNumber, String name, String lastName, String uVR){
		
		this.idNumber = idNumber;
		this.name = name;
		this.lastName = lastName;
		this.uVR = uVR;
		status = "Available";
		numbVeterinaryConsultation = 0;
		
	}
	
	//getter Methods
	public String getIdNumber(){
		return idNumber;
	}
	public String getName(){
		return name;
	}
	public String getLastName(){
		return lastName;
	}
	public String getUVR(){
		return uVR;
	}
	public String getStatus(){
		return status;
	}
	public int getNumbVeterinaryConsultation(){
		return numbVeterinaryConsultation;
	}
	
	//setter Methods
	public void setStatus(String pStatus){
		status = pStatus;
	}
	public void increaseNumbVeterinaryConsultation(int pNumbVeterinaryConsultation){
		numbVeterinaryConsultation += pNumbVeterinaryConsultation;
	}
	
	//toString Method
	public String toString(){
		return "CC: " + idNumber + "\nName: " + name + " " + lastName + "\nIs currently: " + status + "\nNumber of veterinay consultation made: " + numbVeterinaryConsultation + "\n=================================================\n";
	}
	
}