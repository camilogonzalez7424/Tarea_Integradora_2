package ui;

import java.util.Scanner;

import model.Mcs;

public class Main {
	
	private static Scanner reader;
	private static Mcs mcs;

	public Main() {
		mcs = new Mcs();
		reader = new Scanner(System.in);
	}
	public static void main(String [] args) {
		
		System.out.println("Iniciando la aplicación");
		
		Main ppal= new Main();
		
		int option=0;
		
		do{
			option = ppal.showMenu();
			ppal.executeOperation(option);
			
		}while (option!=0);
		
	}
	
	public int showMenu() {
		int option=0;

		System.out.println(
				"Menú principal, seleccione una opción\n" +
				"(1) Para crear un usuario \n" +
				"(2) Para mostrar los usuarios\n"+
				"(3) Para agregar las canciones\n"+
				"(4) \n" +  
				"(0) Para salir"
				);
		option= reader.nextInt();
		reader.nextLine();
		return option;
	}
	
	public void executeOperation(int operation) {
		
		switch(operation) {
		case 0:
			System.out.println("Bye!");
			break;
		case 1:
			addUser() ;
			break;
		case 2:
			break;
	
		case 3:
			break;

		case 4:
			break;
		
		default:
			System.out.println("Error, opción no válida");
		
		}
	}		
	public void addUser(){
		String userName, password;
		int age;

		if(mcs.hasUser()){
			System.out.println("Ingrese el nombre del usuario, una sola linea por favor:");
			userName = reader.nextLine();
			System.out.println("Ingrese una contraseña para el usuario: "+ userName);
			password = reader.nextLine();
			System.out.println("Ingrese la edad del usuario "+ userName);
			age = reader.nextInt();

			mcs.createUser(userName, password, age);

			System.out.println("El usuario \""+ userName +"\" ha sido creado con éxito\n");
		}
		else{
			System.out.println("No puede crearse el usuario porque se llegó al límite");
		}
	
	}
		}
	
