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
				"(4) Para mostrar las canciones\n" +  
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
			addUser();
			break;
		case 2:
			System.out.println(mcs.showUser());
			break;
	
		case 3:
			addSong();
			break;

		case 4:
			System.out.println(mcs.showSong());
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

	public void addSong(){
		String title = "";
		String band = "";
		String date = "";
		String songGenre = "";
		 
		int minute,second,selection;

		minute = 0;
		second = 0;

		if(mcs.hasSong()){
			System.out.println("Ingrese el titulo de la canción por favor:");
			title = reader.nextLine();
			System.out.println("Ingrese la banda o el artista de la canción: "+ title);
			band = reader.nextLine();
			System.out.println("Ingrese la fecha de lanzamiento de la canción: "+ title);
			date = reader.nextLine();
			System.out.print("Ingrese la duración de la canción, primero minutos y luego segundos \n"+
								  "Ejemplo: 5:2, primero minutos '5' y luego segundos '2' \n");
			System.out.println("Ingrese minutos:");		
			minute = reader.nextInt();
			System.out.println("Ingrese segundos:");
			second = reader.nextInt();
			System.out.println("Seleccione el numero que respresenta el genero de la canción\n"+
				"*******************Genere******************** \n"+
				"(1) Si la canción es de ROCK\n"+
				"(2) Si la canción es de HIP HOP\n"+
				"(3) Si la canción es de CLASSIC\n"+
				"(4) Si la canción es de REGGAE\n"+
				"(5) Si la canción es de SALSA\n"+
				"(6) Si la canción es de METAL\n");
			selection=reader.nextInt();
		switch (selection){
			case 1:
					songGenre = "ROCK";
			break;
			
			case 2:
					songGenre = "HIP_HOP";
			break;
			
			case 3:
					songGenre = "CLASSIC";
			break;
			
			case 4:
					songGenre = "REGGAE";
			break;
			
			case 5:
					songGenre = "SALSA";
			break;
			
			case 6:
					songGenre = "METAL";
			break;
		
			default: 
			System.out.println("Error");
		}		  	

			mcs.addSongToPool(title, band, date, minute, second, songGenre);					  
			System.out.println("La canción \""+ title +"\" ha sido añadida con éxito\n");
		}
		else{
			System.out.println("No puede crearse la canción porque se llegó al límite");
		}
	
	}
		}
	
