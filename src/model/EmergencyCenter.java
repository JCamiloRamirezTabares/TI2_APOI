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
	
	//Setter Method
	public void setPet(){
		pets = null;
	}
	
	
	//All Methods
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
					confirmation += "\n===============================================\nSe ha registrado correctamente la nueva mascota\n===============================================\n";
				} else{arrivalOrder++;
					   pets[i] = new Pet(specie, petBreed, name, age, symptoms, priority, idOwner, ownerName, ownerPhone, ownerAddress, arrivalOrder); 
					   confirmation += "\n===============================================\nSe ha registrado correctamente la nueva mascota\n===============================================\n";}
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
			} else{text = "======================================================================================\nNo es posible retirar la mascota, pues esta se encuentra en consulta o ya fue retirada\n======================================================================================";}
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
	
	public String startConsult(int index){
		String confirmation = "";
		boolean sentinel = false;
		int i1 = -1, i2 = -1, i3 = -1, i4 = -1, i5 = -1, count = 0;
		
		for(int i = 0; i < MAXPETS; i++){
			if(pets[i] == null){
				count++;
			}
		}
		
		if(count != MAXPETS){
			if((vets[index].getStatus()).equals("Available")){
			
				for(int i = 0; i < MAXPETS && !sentinel; i++){
					if(pets[i] != null){
						if(pets[i].getStatus() == ConsultationStatus.WAITING_TO_BE_SERVED){
							if(pets[i].getPriority() == Priority.PRIORITY_1){
								sentinel = true;
								i1 = i;
							}
						}
					}
				}
				sentinel = false;
				for(int i = 0; i < MAXPETS && !sentinel; i++){
					if(pets[i] != null){
						if(pets[i].getStatus() == ConsultationStatus.WAITING_TO_BE_SERVED){
							if(pets[i].getPriority() == Priority.PRIORITY_2){
								sentinel = true;
								i2 = i;
							}
						}
					}
				}
				sentinel = false;
				for(int i = 0; i < MAXPETS && !sentinel; i++){
					if(pets[i] != null){
						if(pets[i].getStatus() == ConsultationStatus.WAITING_TO_BE_SERVED){
							if(pets[i].getPriority() == Priority.PRIORITY_3){
								sentinel = true;
								i3 = i;
							}
						}
					}
				}
				sentinel = false;
				for(int i = 0; i < MAXPETS && !sentinel; i++){
					if(pets[i] != null){
						if(pets[i].getStatus() == ConsultationStatus.WAITING_TO_BE_SERVED){
							if(pets[i].getPriority() == Priority.PRIORITY_4){
								sentinel = true;
								i4 = i;
							}
						}
					}
				}
				sentinel = false;
				for(int i = 0; i < MAXPETS && !sentinel; i++){
					if(pets[i] != null){
						if(pets[i].getStatus() == ConsultationStatus.WAITING_TO_BE_SERVED){
							if(pets[i].getPriority() == Priority.PRIORITY_5){
								sentinel = true;
								i5 = i;
							}
						}
					}
				}
			
			
				if(i1 != -1){pets[i1].setvetWhoAttendsPet(vets[index]); pets[i1].setStatus(ConsultationStatus.IN_CONSULTATION); vets[index].setStatus("In consultation"); vets[index].increaseNumbVeterinaryConsultation(1); confirmation = "Desde este momento, el veterinario " + vets[index].getName() + " " + vets[index].getLastName() + " pasa a consulta veterinaria";}
				else if(i2 != -1){pets[i2].setvetWhoAttendsPet(vets[index]); pets[i2].setStatus(ConsultationStatus.IN_CONSULTATION); vets[index].setStatus("In consultation"); vets[index].increaseNumbVeterinaryConsultation(1); confirmation = "Desde este momento, el veterinario " + vets[index].getName() + " " + vets[index].getLastName() + " pasa a consulta veterinaria";}
				else if(i3 != -1){pets[i3].setvetWhoAttendsPet(vets[index]); pets[i3].setStatus(ConsultationStatus.IN_CONSULTATION); vets[index].setStatus("In consultation"); vets[index].increaseNumbVeterinaryConsultation(1); confirmation = "Desde este momento, el veterinario " + vets[index].getName() + " " + vets[index].getLastName() + " pasa a consulta veterinaria";}
				else if(i4 != -1){pets[i4].setvetWhoAttendsPet(vets[index]); pets[i4].setStatus(ConsultationStatus.IN_CONSULTATION); vets[index].setStatus("In consultation"); vets[index].increaseNumbVeterinaryConsultation(1); confirmation = "Desde este momento, el veterinario " + vets[index].getName() + " " + vets[index].getLastName() + " pasa a consulta veterinaria";}
				else if(i5 != -1){pets[i5].setvetWhoAttendsPet(vets[index]); pets[i5].setStatus(ConsultationStatus.IN_CONSULTATION); vets[index].setStatus("In consultation"); vets[index].increaseNumbVeterinaryConsultation(1); confirmation = "Desde este momento, el veterinario " + vets[index].getName() + " " + vets[index].getLastName() + " pasa a consulta veterinaria";}
				else{confirmation += "No hay mascotar pendientes por atender";}
			
			} else{confirmation = "Lo sentimos, el veterinario seleccionado ya esta en consulta actualmente";}
		} else{confirmation = "No hay mascotas registradas en el centro";}
				
		return confirmation;
	}

	public Pet finishConsult(int indexVet, String namePet, int option){
		//Esta dejando pasar a hospitalizacion a las que ya estan en hospitalizacion, internamente esta finalizando consulta a aquellas que ya salieron
		int index = -1;
		boolean sentinel = false;
		int a = 0;
		
		Pet petreturn = null;
		
		for(int i = 0; i < MAXPETS && !sentinel; i++){
			if(pets[i] != null){
				if(pets[i].getVetWhoAttendsPet() == vets[indexVet]){
					if((pets[i].getName()).equals(namePet)){
						index = i;
						sentinel = true;
						if(option == 1){
							pets[index].setStatus(ConsultationStatus.AUTORIZED_DEPARTURE);
							vets[indexVet].setStatus("Available");
							a = 1;
						} else{
							pets[index].setStatus(ConsultationStatus.TRANSFER_TO_HOSPITALIZATION);
							petreturn = pets[index];
						}
						
					} else{a = 3;}
				}
			}
		}
		
		if(sentinel == false){a = 4;}
		
		if(a != 0){
			petreturn = new Pet(a);
		}
		
		
		return petreturn;
	}

	public String showUnattendedPets(){
		String unattendedPets = "";
		int count = 0, count2 = 0, count3 = 0;
		
		for(int i = 0; i < MAXPETS; i++){
			if(pets[i] != null){
				count2++;
				if(pets[i].getStatus() == ConsultationStatus.WAITING_TO_BE_SERVED){
				unattendedPets += pets[i].toString();
				} else{count3++;}
			} else{count++;}
			
		}
		
		if(count == MAXPETS){unattendedPets = "No hay mascotas registradas\n=====================================";
		} else if(count2 == count3){unattendedPets = "No hay mascotas pendientes por atender\n=====================================";}
		
		return unattendedPets;
	}

	public String closeCenter(){
		String confirmation = "";
		int countPet = 0, countVet = 0, countN = 0, indexHigher = 0;
		int countPr1 = 0, countPr2 = 0, countPr3 = 0, countPr4 = 0, countPr5 = 0;
		int countExitWithoutA = 0;
		
		for(int i = 0; i < MAXPETS; i++){
			if(pets[i] != null){
				if(pets[i].getStatus() == ConsultationStatus.WAITING_TO_BE_SERVED){
				countPet++;
				}
			} else{countN++;}
		}
		
		if(countPet != 0){confirmation = "=======================================\nAun hay mascotas pendientes por atender\n=======================================\n";
		} else if (countN == MAXPETS){
			confirmation = "=====================================\nNo hay mascotas registradas en el centro\nPor lo tanto no hay datos que comparar\n=====================================\n";
		}else{
			confirmation = "=======================================\n==  INFORME DE ESTADISTICAS FINALES  ==\n=======================================\n";
			for(int i = 1; i < MAXVETS; i++){
				if(vets[i] != null){
					if(vets[indexHigher].getNumbVeterinaryConsultation() < vets[i].getNumbVeterinaryConsultation()){
					indexHigher = i;
					}
				}	
			}
			confirmation += "=====================================================================\n";
			
			for(int i = 0; i < MAXVETS; i++){
				if(vets[i] == null){
					countVet++;
				}
			}
			
			if(countVet != MAXVETS){
				if(vets[indexHigher].getNumbVeterinaryConsultation() != 0){
				confirmation += "El veterinario con mas consultas realizadas fue: " + vets[indexHigher].getName() + " " + vets[indexHigher].getLastName() + " con un total de " + vets[indexHigher].getNumbVeterinaryConsultation() + " consultas realizadas\n";
				} else{confirmation += "Ningun veterinario atendio alguna mascota hoy\n";}
			} else{confirmation += "No hay veterinarios registrados\n";}
			
			for(int i = 0; i < MAXPETS; i++){
				if(pets[i] != null){
					if(pets[i].getPriority() == Priority.PRIORITY_1 && pets[i].getVetWhoAttendsPet() != null){
					countPr1++;
					} else if(pets[i].getPriority() == Priority.PRIORITY_2 && pets[i].getVetWhoAttendsPet() != null){
						countPr2++;
					} else if(pets[i].getPriority() == Priority.PRIORITY_3 && pets[i].getVetWhoAttendsPet() != null){
						countPr3++;
					} else if(pets[i].getPriority() == Priority.PRIORITY_4 && pets[i].getVetWhoAttendsPet() != null){
						countPr4++;
					} else if(pets[i].getPriority() == Priority.PRIORITY_5 && pets[i].getVetWhoAttendsPet() != null){
						countPr5++;
					}
				}
			}
			confirmation += "=====================================================================\n";
			confirmation += "Se atendieron:\n" + countPr1 + " mascotas de Prioridad 1\n" + countPr2 + " mascotas de Prioridad 2\n" + countPr3 + " mascotas de Prioridad 3\n" + countPr4 + " mascotas de Prioridad 4\n" + countPr5 + " mascotas de Prioridad 5\n";
			confirmation += "=====================================================================\n";
			
			for(int i = 0; i < MAXPETS; i++){
				if(pets[i] != null){
					if(pets[i].getStatus() == ConsultationStatus.EXIT_WITHOUT_ATTENTION){
						countExitWithoutA++;
					}
				}
			}
			
			if(countExitWithoutA != 0){
				confirmation += "Lastimosamente se fueron " + countExitWithoutA + " mascotas sin atender, debemos hacerlo mejor para la proxima\n=====================================================================";
			} else{confirmation += "Felicitaciones hemos logrado que ninguna mascota se vaya sin ser atendida, sigue asi!!!\n=====================================================================";}
			
			countPet = 0;
			
			for(int i = 0; i < MAXPETS; i++){
				if(pets[i] != null){
					countPet++;
				}
			}
			countExitWithoutA = 0;
			for(int i = 0; i < MAXPETS; i++){
				if(pets[i] != null){
					if(pets[i].getStatus() == ConsultationStatus.EXIT_WITHOUT_ATTENTION){
						countExitWithoutA++;
					}
				}
			}
			
			double average = (100 * countExitWithoutA)/countPet;
			confirmation += "\nEl " + average + "% de las mascotas registradas se fueron sin ser atendidas\n=====================================================================";
			
		}
		
		return confirmation;
		
	}

	
	//Este se debera borrar mas adelante
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
	
}