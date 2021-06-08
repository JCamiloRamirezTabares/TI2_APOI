package model;

public class Pet{
	
	private String petBreed;
	private String name;
	private int age;
	private String symptoms;
	private int arrivalOrder;
	private int auxConfirmation;
	private int hospitalizationDays;
	
	//Relationships
	private PetsAvailable specie;
	private PetOwner owner;
	private Priority priority;
	private ConsultationStatus status;
	private Vet vetWhoAttendsPet;
	
	//Constructor Methods
	/*If the user choosed DOG or CAT*/
	public Pet(PetsAvailable specie, String petBreed, String name, int age, String symptoms, Priority priority, String idOwner, String ownerName, String ownerPhone, String ownerAddress, int arrivalOrder){
		this.specie = specie;
		this.petBreed = petBreed;
		this.name = name;
		this.age = age;
		this.symptoms = symptoms;
		this.priority = priority;
		status = ConsultationStatus.WAITING_TO_BE_SERVED;
		this.arrivalOrder = arrivalOrder;
		vetWhoAttendsPet = null;
		
		owner = new PetOwner(idOwner, ownerName, ownerPhone, ownerAddress);
	}
	
	/*If the user choosed RABBIT, LIZARD or BIRD*/
	public Pet(PetsAvailable specie, String name, int age, String symptoms, Priority priority, String idOwner, String ownerName, String ownerPhone, String ownerAddress, int arrivalOrder){
		this.specie = specie;
		this.name = name;
		this.age = age;
		this.symptoms = symptoms;
		this.priority = priority;
		status = ConsultationStatus.WAITING_TO_BE_SERVED;
		this.arrivalOrder = arrivalOrder;
		
		owner = new PetOwner(idOwner, ownerName, ownerPhone, ownerAddress);
	}
	
	public Pet(PetsAvailable specie, String petBreed, String name, int age, String idOwner, String ownerName, String ownerPhone, String ownerAddress, int days){
		this.specie = specie;
		this.petBreed = petBreed;
		this.name = name;
		this.age = age;
		hospitalizationDays = days;
		
		owner = new PetOwner(idOwner, ownerName, ownerPhone, ownerAddress);
	}
	
	public Pet(PetsAvailable specie, String name, int age, String idOwner, String ownerName, String ownerPhone, String ownerAddress, int days){
		this.specie = specie;
		this.name = name;
		this.age = age;
		hospitalizationDays = days;
		
		owner = new PetOwner(idOwner, ownerName, ownerPhone, ownerAddress);
	}
	
	
	public Pet(int a){
		auxConfirmation = a;
	}
	
	//getters Methods
	public PetsAvailable getSpecie(){
		return specie;
	}
	public String getPetBreed(){
		return petBreed;
	}
	public String getName(){
		return name;
	}
	public int getAge(){
		return age;
	}
	public PetOwner getOwner(){
		return owner;
	}
	public String getIdOwner(){
		String idOwner = owner.getIdNumber();
		return idOwner;
	}
	public ConsultationStatus getStatus(){
		return status;
	}
	public int getArrivalOrder(){
		return arrivalOrder;
	}
	public Vet getVetWhoAttendsPet(){
		return vetWhoAttendsPet;
	}
	public Priority getPriority(){
		return priority;
	}
	public int getAuxConfirmation(){
		return auxConfirmation;
	}
	
	//setters Methods
	public void setvetWhoAttendsPet(Vet veterinarian){
		vetWhoAttendsPet = veterinarian;
	}
	public void setStatus(ConsultationStatus pStatus){
		status = pStatus;
	}
	
	//toString Method
	public String toString(){
		String info;
		
		if(petBreed == null){
			info = "==============\n== Pet Info ==\n==============\nSpecie: " + specie + "\nName: " + name + "\nAge of the pet: " + age + owner.toString();
		} else{info = "==============\n== Pet Info ==\n==============\nSpecie: " + specie + "\nPet Breed: " + petBreed + "\nName: " + name + "\nAge of the pet: " + age + owner.toString();}
		
		info += "\n==============================\nPriority: " + priority + "\nStatus: " + status + "\nOrder of arrival: " + arrivalOrder;
		
		if(vetWhoAttendsPet != null){info += "\nVet who attend the Pet: " + vetWhoAttendsPet.getName() + " " + vetWhoAttendsPet.getLastName();}
		
		return info + "\n==============================\n";
	}
		
}