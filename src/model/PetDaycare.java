package model;

public class PetDaycare{
	
	//Maximum of rooms for pets
	private final int ROWMATRIX = 6;
	private final int COLUMNMATRIX = 5;
	
	//For Cats
	private final int ROWMINIMUM_FORCAT = 0;
	private final int ROWLIMIT_FORCAT = 2;
	private final int COLUMNMINIMUM_FORCAT = 0;
	private final int COLUMNLIMIT_FORCAT = 2;
	
	//For Dogs
	private final int ROWMINIMUM_FORDOG = 3;
	private final int ROWLIMIT_FORDOG = 5;
	private final int COLUMNMINIMUM_FORDOG = 0;
	private final int COLUMNLIMIT_FORDOG = 2;
	
	//For Rabbits
	private final int ROWMINIMUM_FORRABBIT = 2;
	private final int ROWLIMIT_FORRABBIT = 3;
	private final int COLUMNMINIMUM_FORRABBIT = 3;
	private final int COLUMNLIMIT_FORRABBIT = 4;
	
	//For Reptiles
	private final int ROWMINIMUM_FORREPTILE = 0;
	private final int ROWLIMIT_FORREPTILE = 1;
	private final int COLUMNMINIMUM_FORREPTILE = 3;
	private final int COLUMNLIMIT_FORREPTILE = 4;
	
	//For Birds
	private final int ROWMINIMUM_FORBIRD = 4;
	private final int ROWLIMIT_FORBIRD = 5;
	private final int COLUMNMINIMUM_FORBIRD = 3;
	private final int COLUMNLIMIT_FORBIRD = 4;
	
	
	private PetHabitat[][] habitats;
	
	//Constructor Method
	public PetDaycare(){
		habitats = new PetHabitat[ROWMATRIX][COLUMNMATRIX];
		int ac = 0;
		
		for(int i = ROWMINIMUM_FORCAT; i <= ROWLIMIT_FORCAT; i++){
			for(int j = COLUMNMINIMUM_FORCAT; j <= COLUMNLIMIT_FORCAT; j++){
				habitats[i][j] = new CatHabitat("CH"+(ac+1), 160.5, 130.2, 135.8, 15.3);
				ac++;
			}
		}
		
		ac = 0;
		for(int i = ROWMINIMUM_FORDOG; i <= ROWLIMIT_FORDOG; i++){
			for(int j = COLUMNMINIMUM_FORDOG; j <= COLUMNLIMIT_FORDOG; j++){
				habitats[i][j] = new DogHabitat("DH"+(ac+1), 160.5, 130.2, 4);
				ac++;
			}
		}
		
		ac = 0;
		for(int i = ROWMINIMUM_FORREPTILE; i <= ROWLIMIT_FORREPTILE; i++){
			for(int j = COLUMNMINIMUM_FORREPTILE; j <= COLUMNLIMIT_FORREPTILE; j++){
				habitats[i][j] = new ReptileHabitat("LH"+(ac+1), 160.5, 130.2, "Glass");
				ac++;
			}
		}
		
		ac = 0;
		for(int i = ROWMINIMUM_FORRABBIT; i <= ROWLIMIT_FORRABBIT; i++){
			for(int j = COLUMNMINIMUM_FORRABBIT; j <= COLUMNLIMIT_FORRABBIT; j++){
				habitats[i][j] = new RabbitHabitat("RH"+(ac+1), 160.5, 130.2, "Lettuce", 3);
				ac++;
			}
		}
		
		ac = 0;
		for(int i = ROWMINIMUM_FORBIRD; i <= ROWLIMIT_FORBIRD; i++){
			for(int j = COLUMNMINIMUM_FORBIRD; j <= COLUMNLIMIT_FORBIRD; j++){
				habitats[i][j] = new BirdHabitat("BH"+(ac+1), 160.5, 130.2, 12.1, 5);
				ac++;
			}
		}
		
	}
	
	
	//Methods
	
	//To add CATS
	public boolean verifyIfThereRoomsForCAT(){
		boolean confirmation = false;
		
		for(int i = ROWMINIMUM_FORCAT; (i <= ROWLIMIT_FORCAT) && !confirmation; i++){
			for(int j = COLUMNMINIMUM_FORCAT; (j <= COLUMNLIMIT_FORCAT) && !confirmation; j++){
				if(habitats[i][j].getPetInsideTheHabitat() == null){
					confirmation = true;
				} else{confirmation = false;}
			}
		}
		
		return confirmation;
	}
	
	public String addCatInDaycare(Pet cat){
		boolean sentinel = false;
		String confirmation = "";
		
		for(int i = ROWMINIMUM_FORCAT; (i <= ROWLIMIT_FORCAT) && !sentinel; i++){
			for(int j = COLUMNMINIMUM_FORCAT; (j <= COLUMNLIMIT_FORCAT) && !sentinel; j++){
				if(habitats[i][j].getPetInsideTheHabitat() == null){
					sentinel = true;
					habitats[i][j].setPetInsideTheHabitat(cat);
					habitats[i][j].setUseType(UseState.OCCUPIED_SICK);
					confirmation = "Se ha trasladado la mascota al habitat " + habitats[i][j].getIdNumber() + ", ubicado en la guarderia de mascotas";
				}
			}
		}
		
		return confirmation;
	}
	
	//To add DOGS
	public boolean verifyIfThereRoomsForDOG(){
		boolean confirmation = false;
		
		for(int i = ROWMINIMUM_FORDOG; (i <= ROWLIMIT_FORDOG) && !confirmation; i++){
			for(int j = COLUMNMINIMUM_FORDOG; (j <= COLUMNLIMIT_FORDOG) && !confirmation; j++){
				if(habitats[i][j].getPetInsideTheHabitat() == null){
					confirmation = true;
				} else{confirmation = false;}
			}
		}
		
		return confirmation;
	}
	
	public String addDogInDaycare(Pet dog){
		boolean sentinel = false;
		String confirmation = "";
		
		for(int i = ROWMINIMUM_FORDOG; (i <= ROWLIMIT_FORDOG) && !sentinel; i++){
			for(int j = COLUMNMINIMUM_FORDOG; (j <= COLUMNLIMIT_FORDOG) && !sentinel; j++){
				if(habitats[i][j].getPetInsideTheHabitat() == null){
					sentinel = true;
					habitats[i][j].setPetInsideTheHabitat(dog);
					habitats[i][j].setUseType(UseState.OCCUPIED_SICK);
					confirmation = "Se ha trasladado la mascota al habitat " + habitats[i][j].getIdNumber() + ", ubicado en la guarderia de mascotas";
				}
			}
		}
		
		return confirmation;
	}
	
	//To add REPTILES
	public boolean verifyIfThereRoomsForREPTILE(){
		boolean confirmation = false;
		
		for(int i = ROWMINIMUM_FORREPTILE; (i <= ROWLIMIT_FORREPTILE) && !confirmation; i++){
			for(int j = COLUMNMINIMUM_FORREPTILE; (j <= COLUMNLIMIT_FORREPTILE) && !confirmation; j++){
				if(habitats[i][j].getPetInsideTheHabitat() == null){
					confirmation = true;
				} else{confirmation = false;}
			}
		}
		
		return confirmation;
	}
	
	public String addReptileInDaycare(Pet reptile){
		boolean sentinel = false;
		String confirmation = "";
		
		for(int i = ROWMINIMUM_FORREPTILE; (i <= ROWLIMIT_FORREPTILE) && !sentinel; i++){
			for(int j = COLUMNMINIMUM_FORREPTILE; (j <= COLUMNLIMIT_FORREPTILE) && !sentinel; j++){
				if(habitats[i][j].getPetInsideTheHabitat() == null){
					sentinel = true;
					habitats[i][j].setPetInsideTheHabitat(reptile);
					habitats[i][j].setUseType(UseState.OCCUPIED_SICK);
					confirmation = "Se ha trasladado la mascota al habitat " + habitats[i][j].getIdNumber() + ", ubicado en la guarderia de mascotas";
				}
			}
		}
		
		return confirmation;
	}
	
	//To add RABBITS
	public boolean verifyIfThereRoomsForRABBIT(){
		boolean confirmation = false;
		
		for(int i = ROWMINIMUM_FORRABBIT; (i <= ROWLIMIT_FORRABBIT) && !confirmation; i++){
			for(int j = COLUMNMINIMUM_FORRABBIT; (j <= COLUMNLIMIT_FORRABBIT) && !confirmation; j++){
				if(habitats[i][j].getPetInsideTheHabitat() == null){
					confirmation = true;
				} else{confirmation = false;}
			}
		}
		
		return confirmation;
	}
	
	public String addRabbitInDaycare(Pet rabbit){
		boolean sentinel = false;
		String confirmation = "";
		
		for(int i = ROWMINIMUM_FORRABBIT; (i <= ROWLIMIT_FORRABBIT) && !sentinel; i++){
			for(int j = COLUMNMINIMUM_FORRABBIT; (j <= COLUMNLIMIT_FORRABBIT) && !sentinel; j++){
				if(habitats[i][j].getPetInsideTheHabitat() == null){
					sentinel = true;
					habitats[i][j].setPetInsideTheHabitat(rabbit);
					habitats[i][j].setUseType(UseState.OCCUPIED_SICK);
					confirmation = "Se ha trasladado la mascota al habitat " + habitats[i][j].getIdNumber() + ", ubicado en la guarderia de mascotas";
				}
			}
		}
		
		return confirmation;
	}
	
	//To add BIRDS
	public boolean verifyIfThereRoomsForBIRD(){
		boolean confirmation = false;
		
		for(int i = ROWMINIMUM_FORBIRD; (i <= ROWLIMIT_FORBIRD) && !confirmation; i++){
			for(int j = COLUMNMINIMUM_FORBIRD; (j <= COLUMNLIMIT_FORBIRD) && !confirmation; j++){
				if(habitats[i][j].getPetInsideTheHabitat() == null){
					confirmation = true;
				} else{confirmation = false;}
			}
		}
		
		return confirmation;
	}
	
	public String addBirdInDaycare(Pet bird){
		boolean sentinel = false;
		String confirmation = "";
		
		for(int i = ROWMINIMUM_FORBIRD; (i <= ROWLIMIT_FORBIRD) && !sentinel; i++){
			for(int j = COLUMNMINIMUM_FORBIRD; (j <= COLUMNLIMIT_FORBIRD) && !sentinel; j++){
				if(habitats[i][j].getPetInsideTheHabitat() == null){
					sentinel = true;
					habitats[i][j].setPetInsideTheHabitat(bird);
					habitats[i][j].setUseType(UseState.OCCUPIED_SICK);
					confirmation = "Se ha trasladado la mascota al habitat " + habitats[i][j].getIdNumber() + ", ubicado en la guarderia de mascotas";
				}
			}
		}
		
		return confirmation;
	}
	
	//For addPet
	public String addPet(int option, Pet newPet){
		String confirmation = "";
		boolean sentinel = false;
		boolean sentinel2 = false;
		
		if(option == 1){
			for(int i = ROWMINIMUM_FORDOG; (i <= ROWLIMIT_FORDOG) && !sentinel; i++){
				for(int j = COLUMNMINIMUM_FORDOG; (j <= COLUMNLIMIT_FORDOG) && !sentinel2; j++){
					if(habitats[i][j].getPetInsideTheHabitat() == null){
						sentinel = true;
						sentinel2 = true;
						habitats[i][j].setPetInsideTheHabitat(newPet);
						habitats[i][j].setUseType(UseState.OCCUPIED_HEALTHY);
						confirmation = "Se ha trasladado la mascota al habitat " + habitats[i][j].getIdNumber() + ", ubicado en la guarderia de mascotas";
					}
				}
			}
		} else if(option == 2){
			for(int i = ROWMINIMUM_FORCAT; (i <= ROWLIMIT_FORCAT) && !sentinel; i++){
				for(int j = COLUMNMINIMUM_FORCAT; (j <= COLUMNLIMIT_FORCAT) && !sentinel2; j++){
					if(habitats[i][j].getPetInsideTheHabitat() == null){
						sentinel = true;
						sentinel2 = true;
						habitats[i][j].setPetInsideTheHabitat(newPet);
						habitats[i][j].setUseType(UseState.OCCUPIED_HEALTHY);
						confirmation = "Se ha trasladado la mascota al habitat " + habitats[i][j].getIdNumber() + ", ubicado en la guarderia de mascotas";
					}
				}
			}
		} else if(option == 3){
			for(int i = ROWMINIMUM_FORRABBIT; (i <= ROWLIMIT_FORRABBIT) && !sentinel; i++){
				for(int j = COLUMNMINIMUM_FORRABBIT; (j <= COLUMNLIMIT_FORRABBIT) && !sentinel2; j++){
					if(habitats[i][j].getPetInsideTheHabitat() == null){
						sentinel = true;
						sentinel2 = true;
						habitats[i][j].setPetInsideTheHabitat(newPet);
						habitats[i][j].setUseType(UseState.OCCUPIED_HEALTHY);
						confirmation = "Se ha trasladado la mascota al habitat " + habitats[i][j].getIdNumber() + ", ubicado en la guarderia de mascotas";
					}
				}
			}
		} else if(option == 4){
			for(int i = ROWMINIMUM_FORREPTILE; (i <= ROWLIMIT_FORREPTILE) && !sentinel; i++){
				for(int j = COLUMNMINIMUM_FORREPTILE; (j <= COLUMNLIMIT_FORREPTILE) && !sentinel2; j++){
					if(habitats[i][j].getPetInsideTheHabitat() == null){
						sentinel = true;
						sentinel2 = true;
						habitats[i][j].setPetInsideTheHabitat(newPet);
						habitats[i][j].setUseType(UseState.OCCUPIED_HEALTHY);
						confirmation = "Se ha trasladado la mascota al habitat " + habitats[i][j].getIdNumber() + ", ubicado en la guarderia de mascotas";
					}
				}
			}
		} else if(option == 5){
			for(int i = ROWMINIMUM_FORBIRD; (i <= ROWLIMIT_FORBIRD) && !sentinel; i++){
				for(int j = COLUMNMINIMUM_FORBIRD; (j <= COLUMNLIMIT_FORBIRD) && !sentinel2; j++){
					if(habitats[i][j].getPetInsideTheHabitat() == null){
						sentinel = true;
						sentinel2 = true;
						habitats[i][j].setPetInsideTheHabitat(newPet);
						habitats[i][j].setUseType(UseState.OCCUPIED_HEALTHY);
						confirmation = "Se ha trasladado la mascota al habitat " + habitats[i][j].getIdNumber() + ", ubicado en la guarderia de mascotas";
					}
				}
			}
		}
		
		
		return confirmation;
	}
	
	//For find a pet
	public String findPet(String namePet){
		
		String confirmation = "";
		boolean sentinel = false;
		boolean sentinel2 = false;
		
		for(int i = 0; (i < ROWMATRIX) && !sentinel; i++){
			for(int j = 0; (j < COLUMNMATRIX) && !sentinel2; j++){
				if(habitats[i][j].getPetInsideTheHabitat() != null){
					if((habitats[i][j].getPetInsideTheHabitat().getName()).equals(namePet)){
						sentinel = true;
						sentinel2 = true;
						confirmation += "\nLa mascota " + namePet + " se encuentra en el habitat " + habitats[i][j].getIdNumber() + "\nSu estado actual es "; 
						
						if(habitats[i][j].getUseType() == UseState.OCCUPIED_SICK){
							confirmation += "enferma\n===================================================";
						} else{
							confirmation += "sana\n===================================================";
						}
					}
				} else{confirmation = "El nombre ingresado no corresponde a ninguna mascota\n===================================================";}
			}
		}
		
		return confirmation;
	}
	
	//For print PetDaycare Map
	public String Map(){
		
		String confirmation = "\n==================================\n====      PETDAYCARE MAP      ====\n==================================\n| ";
		int maxCount = 0;
		int countC = 1, countD = 1, countR = 1, countL = 1, countB = 1;
		
		
		for(int i = 0; i < ROWMATRIX; i++){
			for(int j = 0; j < COLUMNMATRIX; j++){
				if(habitats[i][j] instanceof CatHabitat){
					confirmation += "G"+countC;
					
					if(habitats[i][j].getUseType() == UseState.EMPTY_EMPTY){
					confirmation += "V";
					} else if(habitats[i][j].getUseType() == UseState.OCCUPIED_HEALTHY){
						confirmation += "S";
					} else if(habitats[i][j].getUseType() == UseState.OCCUPIED_SICK){
						confirmation += "E";
					}
					countC++;
					confirmation += " | ";
				} else if(habitats[i][j] instanceof DogHabitat){
					confirmation += "P"+countD;
					
					if(habitats[i][j].getUseType() == UseState.EMPTY_EMPTY){
					confirmation += "V";
					} else if(habitats[i][j].getUseType() == UseState.OCCUPIED_HEALTHY){
						confirmation += "S";
					} else if(habitats[i][j].getUseType() == UseState.OCCUPIED_SICK){
						confirmation += "E";
					}
					countD++;
					confirmation += " | ";
				} else if(habitats[i][j] instanceof RabbitHabitat){
					confirmation += "C"+countR;
					
					if(habitats[i][j].getUseType() == UseState.EMPTY_EMPTY){
					confirmation += "V";
					} else if(habitats[i][j].getUseType() == UseState.OCCUPIED_HEALTHY){
						confirmation += "S";
					} else if(habitats[i][j].getUseType() == UseState.OCCUPIED_SICK){
						confirmation += "E";
					}
					countR++;
					confirmation += " | ";
				} else if(habitats[i][j] instanceof ReptileHabitat){
					confirmation += "R"+countL;
					
					if(habitats[i][j].getUseType() == UseState.EMPTY_EMPTY){
					confirmation += "V";
					} else if(habitats[i][j].getUseType() == UseState.OCCUPIED_HEALTHY){
						confirmation += "S";
					} else if(habitats[i][j].getUseType() == UseState.OCCUPIED_SICK){
						confirmation += "E";
					}
					countL++;
					confirmation += " | ";
				} else if(habitats[i][j] instanceof BirdHabitat){
					confirmation += "A"+countB;
					
					if(habitats[i][j].getUseType() == UseState.EMPTY_EMPTY){
					confirmation += "V";
					} else if(habitats[i][j].getUseType() == UseState.OCCUPIED_HEALTHY){
						confirmation += "S";
					} else if(habitats[i][j].getUseType() == UseState.OCCUPIED_SICK){
						confirmation += "E";
					}
					countB++;
					confirmation += " | ";
				}
				
				maxCount++;
				
				if(maxCount == 5){
					maxCount = 0;
					confirmation += "\n| ";
				}
			}
		}
		
		return confirmation;
	}
	
	
	
	
	
	
	//For Test
	public String showPetDaycare(){
		String confirmation = "";
		
		for(int i = 0; i < ROWMATRIX; i++){
			for(int j = 0; j < COLUMNMATRIX; j++){
				if(habitats[i][j] != null){
					if(habitats[i][j].getPetInsideTheHabitat() == null){
					confirmation += "En la posicion: FILA-" + i + "/COLUMNA-" + j + 
									"\nSe encuentra vacio el habitat\n";
					} else{
					confirmation += "En la posicion: FILA-" + i + "/COLUMNA-" + j + 
									"\nHay una mascota con los siguientes datos:\n" +
									"==========================================\n" + habitats[i][j].toString();
					}
				}
				
			}
		}
		
		return confirmation;
	}
}