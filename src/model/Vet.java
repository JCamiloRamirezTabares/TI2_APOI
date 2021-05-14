package model;

public class Vet{
	
	private String idNumber;
	private String name;
	private String lastName;
	private String uVR;
	private String status;
	
	//Constructor Method
	public Vet(String idNumber, String name, String lastName, String uVR){
		
		this.idNumber = idNumber;
		this.name = name;
		this.lastName = lastName;
		this.uVR = uVR;
		status = "Available";
		
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
	
	//setter Methods
	public void setStatus(String pStatus){
		status = pStatus;
	}
	
	//toString Method
	public String toString(){
		return "CC: " + idNumber + "\nName: " + name + " " + lastName + "\nIs currently: " + status + "\n=========================\n";
	}
	
}