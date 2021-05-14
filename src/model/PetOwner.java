package model;

public class PetOwner{
	
	private String idNumber;
	private String name;
	private String phoneNumber;
	private String address;
	
	//Constructor Method
	public PetOwner(String idNumber, String name, String phoneNumber, String address){
		
		this.idNumber = idNumber;
		this.name = name;
		this.phoneNumber = phoneNumber;
		this.address = address;
		
	}
	
	//getters Methods
	public String getIdNumber(){
		return idNumber;
	}
	public String getName(){
		return name;
	}
	public String getPhoneNumber(){
		return phoneNumber;
	}
	public String getAddress(){
		return address;
	}
	
	//toString Method
	public String toString(){
		return "\n====================\n== Pet Owner Info ==\n====================\nID Number: " + idNumber + "\nName: " + name + "\nPhone: " + phoneNumber + "\nAddress: " + address + "\n"; 
	}
	
}