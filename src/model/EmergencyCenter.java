package model;

public class EmergencyCenter{
	
	private final int MAXPETS = 120;
	private final int MAXVETS = 7;
	private int arrivalOrder;
	
	//Relationships
	private Vet []vets;
	private Pet []pets;
	
	public EmergencyCenter(){
		
		vets = new Vet[MAXVETS];
		pets = new Pet[MAXPETS];
		arrivalOrder = 0;
		
	}
	
	public String addVet(String idNumber, String name, String lastName, String uVR){
		
		String confirmation = "";
		boolean sentinel = false;
		
		for(int i = 0; i < MAXVETS && !sentinel; i++){
			if(vets[i] == null){
				sentinel = true;
				
				vets[i] = new Vet(idNumber, name, lastName, uVR);
				confirmation += "\n============================================\nSe ha agregado correctamente el nuevo veterinario\n============================================\n";
			}
			
		}
		
		return confirmation;
	}
	
	public int findVet(String id){
		int index = -1;
		boolean sentinel = false;
		
		for(int i = 0; i < MAXVETS && !sentinel; i++){
			if(vets[i] != null){
				if(id.equals(vets[i].getIdNumber())){
					sentinel = true;
					index = i;
				}
			}
		}
		if(sentinel = false){index = -1;}
		
		return index;
	}
	
	public String deleteVet(int index){
		String message;
		int count = 0;
		
		for(int i = 0; i < MAXPETS; i++){
			if(pets[i] == null){count++;}
		}
		
		if(count == MAXPETS){
			message = "Se ha eliminado correctamente el veterinario " + vets[index].getName() + " " + vets[index].getLastName();
			vets[index] = null;
		} else{message = "El veterinario no se puede eliminar, porque hay mascotas en el centro";}
		
		return message;
	}
	
	public boolean verify_Pet_And_Owner_Relationship(PetsAvailable specie, String petBreed, String name, String idOwner){
		boolean verify = false;
		
		for(int i = 0; i < MAXPETS; i++){
			if(pets[i] != null){
				if(pets[i].getPetBreed() != null){
					if((pets[i].getSpecie() == specie)&&(pets[i].getPetBreed().equals(petBreed))&&(pets[i].getName().equals(name))&&(pets[i].getIdOwner().equals(idOwner))){
						verify = true;
					}
				} else{
					if((pets[i].getSpecie() == specie)&&(pets[i].getName().equals(name))&&(pets[i].getIdOwner().equals(idOwner))){
						verify = true;
					}
				}
			}
		}
		
		return verify;
	}
	
	public String addPet(PetsAvailable specie, String petBreed, String name, int age, String symptoms, Priority priority, String idOwner, String ownerName, String ownerPhone, String ownerAddress){
		
		String confirmation = "";
		boolean sentinel = false;
		
		for(int i = 0; i < MAXPETS && !sentinel; i++){
			if(pets[i] == null){
				sentinel = true;
				
				if(petBreed == ""){
					arrivalOrder++;
					pets[i] = new Pet(specie, name, age, symptoms, priority, idOwner, ownerName, ownerPhone, ownerAddress, arrivalOrder);
					confirmation += "\n============================================\nSe ha registrado correctamente la nueva mascota\n============================================\n";
				} else{arrivalOrder++;
					   pets[i] = new Pet(specie, petBreed, name, age, symptoms, priority, idOwner, ownerName, ownerPhone, ownerAddress, arrivalOrder); 
					   confirmation += "\n============================================\nSe ha registrado correctamente la nueva mascota\n============================================\n";}
			}
		}
		
		if(sentinel = false){
			confirmation += "Lo sentimos, hemos alcanzado el limite de mascotas para registrar";
		}
		
		return confirmation;
	}
	
	public int findPet(PetsAvailable specie, String petBreed, String name, String idOwner){
		int index = -1;
		boolean sentinel = false;
		
		for(int i = 0; i < MAXPETS && !sentinel; i++){
			if(pets[i] != null){
				if(pets[i].getPetBreed() != null){
					if((pets[i].getSpecie() == specie)&&(pets[i].getPetBreed().equals(petBreed))&&(pets[i].getName().equals(name))&&(pets[i].getIdOwner().equals(idOwner))){
						index = i;
						sentinel = true;
					} else{index = -2;}
				} else{
						if((pets[i].getSpecie() == specie)&&(pets[i].getName().equals(name))&&(pets[i].getIdOwner().equals(idOwner))){
						index = i;
						sentinel = true;
						} else{index = -2;}
					}
			}
		}
		
		return index;
	}
	
	public String removalPet(int index){
		String text = "";
		
		if(index != -1 && index != -2){
			if(pets[index].getStatus() == ConsultationStatus.WAITING_TO_BE_SERVED){
				text = "=============================\nHas autorizado la salida de la mascota sin ser atendida\n=============================";
				pets[index].setStatus(ConsultationStatus.EXIT_WITHOUT_ATTENTION);
			} else{text = "=============================\nNo es posible retirar la mascota, pues esta se encuentra en consulta o ya fue retirada\n=============================";}
		} else if(index == -2){
			text = "=============================\nNo hay ninguna mascota que coincida con los datos suministrados\n=============================";
		} else{text = "=============================\nNo hay mascotas en el centro\n=============================";}
		
		return text;
	}
	
	public String showVets(){
		String text = "========\n= VETS =\n========\n\n=========================\n";
		int count = 0;
		
		for(int i = 0; i < MAXVETS; i++){
			if(vets[i] != null){
				
				text += vets[i].toString();
				
			}else{count++;}
		}
		
		if(count == MAXVETS){text = "No hay veterinarios registrados";}
		
		return text;
	}
	
	/*
	public void find_The_Next_Pet_To_Attend(){
		int i = 0;
		
		while(i < MAXPETS){
			for(int j = 0; j < MAXPETS; j++){
				if(pets[j] != null){
					if(pets[j].getVetWhoAttendsPet() == null){
						if(pets[j].getPriority() == Priority.PRIORITY_1){
							petsPerPriority[i] = pets[j];
							i++;
						}
					}
				}
			}
			for(int j = 0; j < MAXPETS; j++){
				if(pets[j] != null){
					if(pets[j].getVetWhoAttendsPet() == null){
						if(pets[j].getPriority() == Priority.PRIORITY_2){
							petsPerPriority[i] = pets[j];
							i++;
						}
					}
				}
			}
			for(int j = 0; j < MAXPETS; j++){
				if(pets[j] != null){
					if(pets[j].getVetWhoAttendsPet() == null){
						if(pets[j].getPriority() == Priority.PRIORITY_3){
							petsPerPriority[i] = pets[j];
							i++;
						}
					}
				}
			}
			for(int j = 0; j < MAXPETS; j++){
				if(pets[j] != null){
					if(pets[j].getVetWhoAttendsPet() == null){
						if(pets[j].getPriority() == Priority.PRIORITY_4){
							petsPerPriority[i] = pets[j];
							i++;
						}
					}
				}
			}
			for(int j = 0; j < MAXPETS; j++){
				if(pets[j] != null){
					if(pets[j].getVetWhoAttendsPet() == null){
						if(pets[j].getPriority() == Priority.PRIORITY_5){
							petsPerPriority[i] = pets[j];
							i++;
						}
					}
				}
			}
			
		}
	} */
	
	public String startConsult(int index){
		String confirmation = "";
		
		if((vets[index].getStatus()).equals("Available")){
			
			for(int i = 0; i < MAXPETS; i++){
				if(pets[i].getPriority() == Priority.PRIORITY_1){
					
				} else if(pets[i].getPriority() == Priority.PRIORITY_2){}
			}
			
			vets[index].setStatus("In consultation");
			confirmation = "Desde este momento, el veterinario " + vets[index].getName() + " " + vets[index].getLastName() + " pasa a consulta veterinaria";
		} else{confirmation = "Lo sentimos, el veterinario seleccionado ya esta en consulta actualmente";}
		
		return confirmation;
	}

	public String showPets(){
		String text = "";
		int count = 0;
		
		for(int i = 0; i < MAXPETS; i++){
			if(pets[i] != null){
				
				text += "En la posicon " + i + ", hay la siguiente informacion:\n" + pets[i].toString() + "\n";
				
			} else{count++;}
		}
		
		if(count == MAXPETS){text += "No hay mascotas en el centro";}
		
		return text;
	}
	
	public String showOrderPets(){
		String text = "";
		int count = 0;
		
		for(int i = 0; i < MAXPETS; i++){
			if(petsPerPriority[i] != null){
				
				text += petsPerPriority[i].toString() + "\n";
				
			} else{count++;}
		}
		
		if(count == MAXPETS){text += "No hay mascotas en el centro";}
		
		return text;
	}
}