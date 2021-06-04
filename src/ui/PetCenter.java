package ui;

import java.util.Scanner;
import model.EmergencyCenter;
import model.PetsAvailable;
import model.Priority;

/**
* @author Juan Camilo Ramirez Tabares
* Description: This is the main class of my project
*/
public class PetCenter{
	
	/**
	* Description: An object of type Scanner called reader is defined
	*/
	private Scanner reader;
	/**
	* Description: An object of type EmergencyCenter (main class of model) called app is defined
	*/
	private EmergencyCenter app;
	/**
	* Description: An static object of type int called optionMenu is defined
	*/
	private static int optionMenu;
	
	/**
	* Description: Constructor: this method prints a welcome message, creates an instance of type Scanner and an instance of type EmergencyCenter and initializes the variable optionM
	* pre: the instances: app.EmergencyCenter, reader.Scanner, and optionM.int must have been previously created
	* pos: the instances: app.EmergencyCenter, reader.Scanner, and optionM.int will be initialized
	*/
	//Constructor Method
	public PetCenter(){
		
		System.out.println("============================\n======== BIENVENIDO ========\n============================\n");
		reader = new Scanner(System.in);
		app = new EmergencyCenter();
		optionMenu = 0;
	}
	
	//void main Method
	public static void main(String []juank){
		
		PetCenter ppal = new PetCenter();
		
		do{
			optionMenu = ppal.showMenu();
			
			switch(optionMenu){
				case 1:
				ppal.addNewVet();
				break;
				case 2:
				ppal.deleteVet();
				break;
				case 3:
				ppal.addNewPet();
				break;
				case 4:
				ppal.removalPet();
				break;
				case 5:
				ppal.startVeterinaryConsult();
				break;
				case 6:
				ppal.finishConsult();
				break;
				case 7:
				ppal.showUnattendedPet();
				break;
				case 8:
				ppal.closeCenter();
				break;
				case 9:
				ppal.showPets();
				break;
				default:
				optionMenu = 0;
				break;
			}
			
		}while(optionMenu != 0);
		
		
		
	}
	
	//Methods
	/**
	* Description: This method prints a menu, then request a value equivalent to an option and return it
	* @return option.int Returns an integer that will be the equivalent of selecting a function from the menu, which will be used to identify what course a do while will take in the main method
	*/
	public int showMenu(){
		int option;
		
		System.out.println("Por favor escoge la opcion que se ajusta a tu requerimiento:");
		System.out.println("(1) Para añadir un nuevo veterinario");
		System.out.println("(2) Para eliminar un veterinario");
		System.out.println("(3) Para registrar una mascota");
		System.out.println("(4) Para retirar una mascota");
		System.out.println("(5) Para iniciar una consulta");
		System.out.println("(6) Para finalizar una consulta");
		System.out.println("(7) Para mostrar las mascotas que aun no han sido atendidas");
		System.out.println("(8) Para cerrar el centro de urgencias");
		System.out.println("\n( ) Cualquier otro numero para salir\n");
		
		System.out.print("Opcion: ");
		option = reader.nextInt();
		reader.nextLine();
		
		return option;
	}
	
	/**
	* Description: This method requests information that will be used for the registration of a new vet in the center
	* pre: The instance with EmergencyCenter must have been previously created and initialized
	* pos: Create a new vet (object) in an array (vets) located in the EmergencyCenter.model class
	*/
	public void addNewVet(){
		String idNumber = "", name = "", lastName = "", uVR = "";
		
		System.out.println("Porfavor ingrese los siguientes datos del Veterinario:\n");
		System.out.print("CC: ");
		idNumber = reader.nextLine();
		System.out.print("Nombre: ");
		name = reader.nextLine();
		System.out.print("Apellidos: ");
		lastName = reader.nextLine();
		System.out.print("Registro unico veterinario: ");
		uVR = reader.nextLine();
		
		System.out.println(app.addVet(idNumber, name, lastName, uVR));
		
	}
	
	/**
	* Description: This method requests information that will be used to search for a vet in the center and if found, then eliminate it.
	* pre: The instance with EmergencyCenter must have been previously created and initialized
	* pos: Delete a vet (object) in an array (vets) located in the EmergencyCenter.model class
	*/
	public void deleteVet(){
		String idNumber = "";
		int indexToDelete = 0;
		
		System.out.println("Porfavor ingrese el numero de identificacion del veterinario que desea eliminar:\n");
		System.out.print("CC: ");
		idNumber = reader.nextLine();
		System.out.println("===================================");
		
		indexToDelete = app.findVet(idNumber);
		
		if(indexToDelete != -1){
			System.out.println(app.deleteVet(indexToDelete));
		} else{System.out.println("No existe ningun veterinario con esa identificacion");}
		System.out.println("===================================");
		
	}
	
	/**
	* Description: This method requests information that will be used for the registration of a new Pet in the center
	* pre: The instance with EmergencyCenter must have been previously created and initialized
	* pos: Create a new Pet (object) in an array (pets) located in the EmergencyCenter.model class
	*/
	public void addNewPet(){

		PetsAvailable specie = null;
		String petBreed, name, symptoms, idOwner, ownerName, ownerPhone, ownerAddress;
		int age = 0;
		Priority priority = null;
		
		System.out.println("==========================\n= Formulario de Registro =\n==========================\n");
		int option = 0;
		
		do{
			System.out.println("=============================\n= Informacion de la Mascota =\n=============================");
			System.out.println("Digite el numero correspondiente a la especie a la que pertenece su mascota: ");
			System.out.println("( 1 ) PERRO");
			System.out.println("( 2 ) GATO");
			System.out.println("( 3 ) CONEJO");
			System.out.println("( 4 ) LAGARTO");
			System.out.println("( 5 ) PAJARO");
			System.out.print("Especie #");
			option = reader.nextInt();
			reader.nextLine();
			
			switch(option){
				case 1:
				specie = PetsAvailable.DOG;
				break;
				case 2:
				specie = PetsAvailable.CAT;
				break;
				case 3:
				specie = PetsAvailable.RABBIT;
				break;
				case 4:
				specie = PetsAvailable.LIZARD;
				break;
				case 5:
				specie = PetsAvailable.BIRD;
				break;
				default:
				option = 0;
				break;
			}
			
		}while(option == 0);
		
		if(option == 1 || option == 2){
			System.out.print("Raza: ");
			petBreed = reader.nextLine();
		} else{petBreed = "";}
		
		System.out.print("Nombre de la mascota: ");
		name = reader.nextLine();
		System.out.print("Edad: ");
		age = reader.nextInt();
		reader.nextLine();
		
		System.out.println("=======================================\n= Informacion del Dueño o Responsable =\n=======================================");
		System.out.print("CC: ");
		idOwner = reader.nextLine();
		System.out.print("Nombre del responsable: ");
		ownerName = reader.nextLine();
		System.out.print("Telefono de contacto: ");
		ownerPhone = reader.nextLine();
		System.out.print("Direccion de contacto: ");
		ownerAddress = reader.nextLine();
		
		System.out.println("==========================\n= Evaluacion Clinica =\n==========================\n");
		System.out.println("A continuacion detalle los sintomas que presenta su mascota: ");
		System.out.print("Sintomas: ");
		symptoms = reader.nextLine();
		
		int selection = 0;
		do{
			System.out.println("\nA continuacion escoja la prioridad que usted considere\n");
			System.out.println("Digite el numero correspondiente a la prioridad que usted considere: ");
			System.out.println("( 1 ) Necesita atención de forma inmediata");
			System.out.println("( 2 ) El tiempo de espera es máximo 10 minutos");
			System.out.println("( 3 ) La atención puede demorarse 60 minutos");
			System.out.println("( 4 ) La atención puede demorarse 2 horas");
			System.out.println("( 5 ) La atención puede demorarse 4 horas");
			System.out.print("Prioridad: ");
			selection = reader.nextInt();
			reader.nextLine();
			
			switch(selection){
				case 1:
				priority = Priority.PRIORITY_1;
				break;
				case 2:
				priority = Priority.PRIORITY_2;
				break;
				case 3:
				priority = Priority.PRIORITY_3;
				break;
				case 4:
				priority = Priority.PRIORITY_4;
				break;
				case 5:
				priority = Priority.PRIORITY_5;
				break;
				default:
				selection = 0;
				break;
			}
			
		}while(selection == 0);
		
		boolean verify = app.verify_Pet_And_Owner_Relationship(specie, petBreed, name, idOwner);
		
		if(verify == false){
			System.out.println(app.addPet(specie, petBreed, name, age, symptoms, priority, idOwner, ownerName, ownerPhone, ownerAddress));
		} else{System.out.println("La combinacion mascota-dueño ya existe");}
		
	}
	
	/**
	* Description: This method requests information that will be used for remove a Pet in the center
	* pre: The instance with EmergencyCenter must have been previously created and initialized
	* pos: Remove a Pet (object) in an array (pets) located in the EmergencyCenter.model class
	*/
	public void removalPet(){
		PetsAvailable specie = null;
		String petBreed, name, idOwner;
		int option = 0;
		
		System.out.println("Porfavor ingrese los siguientes datos de la mascota que desea retirar:\n");
		
		do{
			System.out.println("Digite el numero correspondiente a la especie a la que pertenece la mascota: ");
			System.out.println("( 1 ) PERRO");
			System.out.println("( 2 ) GATO");
			System.out.println("( 3 ) CONEJO");
			System.out.println("( 4 ) LAGARTO");
			System.out.println("( 5 ) PAJARO");
			System.out.print("Especie #");
			option = reader.nextInt();
			reader.nextLine();
			
			switch(option){
				case 1:
				specie = PetsAvailable.DOG;
				break;
				case 2:
				specie = PetsAvailable.CAT;
				break;
				case 3:
				specie = PetsAvailable.RABBIT;
				break;
				case 4:
				specie = PetsAvailable.LIZARD;
				break;
				case 5:
				specie = PetsAvailable.BIRD;
				break;
				default:
				option = 0;
				break;
			}
			
		}while(option == 0);
		
		if(option == 1 || option == 2){
			System.out.print("Raza: ");
			petBreed = reader.nextLine();
		} else{petBreed = "";}
		
		System.out.print("Nombre de la mascota: ");
		name = reader.nextLine();
		System.out.print("Numero de Identificacion del dueño o la persona responsable: ");
		idOwner = reader.nextLine();
		
		int indexToRemoval = app.findPet(specie, petBreed, name, idOwner);
		System.out.println(app.removalPet(indexToRemoval));
	}
	
	/**
	* Description: This method requests information that will be used to find a vet(object) in an array (vets) located in the EmergencyCenter.model class; after that, this vet will attend the pet that has the WAITING_TO_BE_SERVED.enum attribute and that has the highest priority level
	* pre: The instance with EmergencyCenter must have been previously created and initialized
	* pos: The selected vet will attend a pet, after that the status.String attribute will be set to "In consultation" and the vet will be associated with the pet
	*/
	public void startVeterinaryConsult(){
		
		System.out.println(app.showVets());
		if((app.showVets()).equals("No hay veterinarios registrados")){
			System.out.println();
		} else{
			System.out.println("Porfavor digita el numero de identificacion del veterinario que iniciara su consulta: ");
			System.out.print("CC: ");
			String idVet = reader.nextLine();
			System.out.println("");
			
			int indexToStartConsult = app.findVet(idVet);
			
			if(indexToStartConsult != -1){
				System.out.println(app.startConsult(indexToStartConsult));
			} else{System.out.println("No existe ningun veterinario con esa identificacion");}
			
			System.out.println("===============================================================");
		}
		
	}
	
	/**
	* Description: This method requests information that will be used to find a vet(object) in an array (vets) located in the EmergencyCenter.model class; after that the method confirms if the vet is attending the pet and if true the TRANSFER_TO_HOSPITALIZATION.enum or AUTORIZED_DEPARTURE.enum attribute of the pet will be set. Also the vet will be set to "Available". String attribute
	* pre: The instance with EmergencyCenter must have been previously created and initialized
	* pos: The selected vet will be finish the consult, after that the status.String attribute will be set to "Available" and the pet will be set TRANSFER_TO_HOSPITALIZATION.enum or AUTORIZED_DEPARTURE.enum attribute
	*/
	public void finishConsult(){
		String idNumber, namePet;
		int indexVet, option = 0;
		
		System.out.println(app.showVets());
		if((app.showVets()).equals("No hay veterinarios registrados")){
			System.out.println();
		} else{
			System.out.println("Por favor ingrese el numero de identificacion del veterinario que desea finalizar su consulta:\n");
			System.out.print("CC: ");
			idNumber = reader.nextLine();
			System.out.print("Nombre de la mascota quien esta atendiendo: ");
			namePet = reader.nextLine();
			
			indexVet = app.findVet(idNumber);
			
			if(indexVet != -1){
				do{
					System.out.println("Escoja la opcion que desea:");
					System.out.println("(1) Para autorizar la salida");
					System.out.println("(2) Para pasar la mascota a hospitalizacion");
					System.out.print("Opcion: ");
					option = reader.nextInt();
					reader.nextLine();
					
					switch(option){
						case 1:
						option = 1;
						break;
						case 2:
						option = 2;
						break;
						default:
						option = 0;
						break;
					}
					
				}while(option == 0);
				
				System.out.println(app.finishConsult(indexVet, namePet, option));
				
			} else{System.out.println("No existe ningun veterinario con esa identificacion");}
				System.out.println("===================================");
		}
		
	}
	
	/**
	* Description: This method finds all the pets with WAITING_TO_BE_SERVED.ConsultationStatus<enum> in the EmergencyCenter.model class; after that print those pets
	* pre: The instance with EmergencyCenter must have been previously created and initialized
	* pos: Print all pets that have not been attend
	*/
	public void showUnattendedPet(){
		System.out.println("=================================");
		System.out.println("========  Unattends Pets ========");
		System.out.println("=================================\n");
		System.out.println(app.showUnattendedPets());
	}
	
	/**
	* Description: This method just call a method called closeCenter ():String in the EmergencyCenter.model class. This is in charge of evaluating when the center can be closed and when not. After that return a confirmation
	* pre: The instance with EmergencyCenter must have been previously created and initialized
	* pos: Print a report with the veterinarian with the most consultations made, the number of pets attended by priority and the percentage of pets that left without being attended or if the center cannot be closed, it informs us
	*/
	public void closeCenter(){
		if((app.closeCenter()).equals("=======================================\nAun hay mascotas pendientes por atender\n=======================================\n")){
			System.out.println(app.closeCenter());
		} else if((app.closeCenter()).equals("=====================================\nNo hay mascotas registradas en el centro\n=====================================\n\n")){
			optionMenu = 0;
			System.out.println("Hasta otro dia :3");
		} else{
			System.out.println(app.closeCenter());
			app.setPet();
			optionMenu = 0;
			System.out.println("Hasta otro dia :3");
		}
		
	}
	
	/**
	//Estos metodos se utilizan para testear
	public void showVets(){
		System.out.println(app.showVets());
	}
	*/
	public void showPets(){
		System.out.println(app.showPets());
	}
	
	
}