package ui;

import java.util.Scanner;

import model.Mcs;

public class Main {
	
	private Scanner reader; 
	private Mcs mcs;

	public Main() {
		mcs = new Mcs();
		reader = new Scanner(System.in);
	}
	public static void main(String [] args) {
System.out.println("(((((((((((((((((((((((((((((((((((((((((((((((((\n"+
"((((((((((((((((/((((((((((((((((((((((((((((((((\n"+
"(((/  .(((((((*  .((((((*        (((((/      /(((\n"+
"(((/   .((((((.  .(((((   ,((((((((((*  .((((((((\n"+
"(((/    /((((/   .((((/  ,(((((((((((.  /((((((((\n"+
"(((/     ((((*   .((((*  ,(((((((((((/   ((((((((\n"+
"(((/  *  *(((     ((((*  ,((((((((((((,  .(((((((\n"+
"(((/  /.  ((*     ((((*  *(((((((((((((,   ((((((\n"+
"(((/  //  ,(  .   ((((*  *((((((((((((((/   /((((\n"+
"((/  *(*  ,  (   ((((*  *((((((((((((((((   /(((\n"+
"(((/  ,(/    ,(   /(((*  ,(((((((((((((((((   (((\n"+
"(((/  .((    ((   /((((  .(((((((((((((((((.  /((\n"+
"(((/  .((.  .((.  *((((,  *((((((((((((((((   /((\n"+
"(((/  .((((((((.  *(((((   *((((/,/(((((((/   (((\n"+
"(((/  .((((((((.  *((((((.        *((   .   .((((\n"+
"(((((((((((((((/*/((((((((((///(((((((////(((((((\n"+
"(((((((((((((((((((((((((((((((((((((((((((((((((\n"+
"               ./(###((///((###(*                \n"+
"          *#(,                   *((,            \n"+
"        ,#/                           ((         \n"+
"     .#*          .**/////*,.          ((        \n"+
"     *(.      .//////////////////*       *#      \n"+
"    .#,     *///////////////////////,     /(     \n"+
"    /(    *///////////////////////////    .#.    \n"+
"  ,/////,*/////////////////////////////,*////*.  \n"+
"  /////////////////////////*,...,/////////////,  \n"+
"  //////*,,,********,,.............,,,,,//////,  \n"+
"  //////*.........//*........//*.......,//////,  \n"+
"  //////*.........,,.........,,........,//////,  \n"+
"  //////*..............................,//////,  \n"+
"   *///*  ........,/.........**.......  .*///,   \n"+
"            .......,/*.....,/*.......            \n"+
"               ........,,,,.......               \n"+
"                    .........                    \n"+
"												\n"+
"*************************************************\n");
		System.out.println("************************");
		System.out.println("***  Welcome to MCS  ***");
		System.out.println("************************");
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
				"Menú principal, seleccione la opción que guste\n" +
				"(1) Para crear un usuario \n" +
				"(2) Para mostrar los usuarios\n"+
				"(3) Para agregar las canciones\n"+
				"(4) Para mostrar las canciones\n" +  
				"(5) Para crear playlist\n"+
				"(6) Para agregar canciones a la playlist\n"+
				"(7) Para calificar una playlist publica\n"+
				"(8) Para mostrar las playlist\n"+
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
		case 5:
			createPlaylist();
			break;
		case 6:
			addSongToPlaylist();	
			break;
		case 7:
		System.out.println("Las playlist disponibles son: ");
		System.out.println(mcs.showPlaylists());
		System.out.println("Ingrese el nombre de la playlist PUBLICA: ");
		String namePlaylist = reader.nextLine();
		System.out.println("Califique de 1 a 5 la playlist: ");
		double score = reader.nextDouble();
		mcs.scorePublicPlaylist(score, namePlaylist);
			break;	
		case 8:
			System.out.println(mcs.showPlaylists());
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

			System.out.println("El usuario \""+ userName +"\" ha sido creado con éxito :D \n");
		}
		else{
			System.out.println("No puede crearse el usuario porque se llegó al límite :( ");
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
			System.out.println(mcs.showUser());
//reader.nextLine();
			String name = "";

			System.out.println("Ingrese el nombre del usuario que añade la canción compartida");
			name = reader.nextLine();
			
			mcs.updateCategory(name);

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
			System.out.println("Seleccione el número que respresenta el genero de la canción\n"+
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
		
			System.out.println("La canción \""+ title +"\" ha sido añadida con éxito :D \n");
		}
		else{
			System.out.println("No puede crearse la canción porque se llegó al límite :( ");
		}
	
	}

	private void createPlaylist(){
		int numplay;
		String name;
	
		System.out.println("Digite la información de la playlist, por favor");
		System.out.println("Escriba el nombre de la playlist");
		name = reader.nextLine();
		System.out.println("Seleccione el número que respresenta el tipo de playlist:\n"+
		"*******************Playlist tipo:******************** \n"+
		"(1) Si la playlist es publica\n"+
		"(2) Si la playlist es restringida\n"+
		"(3) Si la playlist es privada\n");
		numplay = reader.nextInt();
		reader.nextLine(); 
		switch(numplay) {
		case 1:		
			if(mcs.hasPlaylist()){
				mcs.createPlaylist(name);
				System.out.println("La playlist publica: \""+ name +"\" ha sido creada con éxito :D \n");

			}else{
				System.out.println("Numero máximo de playlists alcanzado");
			}
			break;
		case 2:
		if(mcs.hasPlaylist()){	
			int [] indexRestricted = new int[5];
			System.out.println(mcs.findUsers());
			System.out.println("Ingrese los usuarios que tienen acceso a esta playlist");
                            for(int i = 0; i<5; i++){
                                indexRestricted[i] = reader.nextInt()-1;
                            }
                            mcs.createPlaylist(name, mcs.restrictedUserArray(indexRestricted));
			
			
			
			System.out.println("La playlist restringida: \""+ name +"\" ha sido creada con éxito :D \n");
		}else{
				System.out.println("Numero máximo de playlists alcanzado");
			}
			break;
		case 3:
			if(mcs.hasPlaylist()){
				System.out.println("Desde que usuario desea crear esta playlist");
				System.out.println(mcs.showUser());
				System.out.println("Ingrese el nombre del usuario que la crea: ");
				String userName = reader.nextLine();
				mcs.createPlaylist(name, mcs.findUser(userName));
				System.out.println("La playlist privada: \""+ name +"\" ha sido creada con éxito :D \n");

	}else{
			System.out.println("Numero máximo de playlists alcanzado");
		}
			break;
		default:
			System.out.println("Error, opción no válida");
		}
	}

	public void addSongToPlaylist(){
		String songName,playlistName;
		String user = "";
		int index;
		System.out.println("Escoga el tipo de playlist: \n"+ 
							"[1] Si es publica"+"\n"+
							"[2] Si es restringida"+"\n"+
							"[3] Si es privada");		
		int election = reader.nextInt();
		reader.nextLine();
		switch(election){
			case 1:
				System.out.println("Las canciones disponibles son: ");
				System.out.println(mcs.showSong());
				System.out.println("Ingrese el nombre de la canción que desea añadir: ");
				songName = reader.nextLine();
				System.out.println("Las playlist disponibles son: ");
				System.out.println(mcs.showPlaylists());
				System.out.println("Ingrese el nombre de la playlist PUBLICA donde añadira la canción: ");
				playlistName = reader.nextLine();
				index = 0;
				System.out.println(mcs.addSongToPLaylist(songName, playlistName,user,index));

			break;
			case 2:
				System.out.println("Las canciones disponibles son: ");
				System.out.println(mcs.showSong());
				System.out.println("Ingrese el nombre de la canción que desea añadir: ");
				songName = reader.nextLine();
				System.out.println("Las playlist disponibles son: ");
				System.out.println(mcs.showPlaylists());
				System.out.println("Ingrese el nombre de la playlist RESTRINGIDA donde añadira la canción: ");
				playlistName = reader.nextLine();
				System.out.println("Ingrese el numero del usuario que añade la canción"+"\n"+
							"Tenga en cuenta que solo los creadores pueden añadir una canción ");
				System.out.println(mcs.findUsers());			
				index = reader.nextInt();
				index=index-1;
				System.out.println(mcs.addSongToPLaylist(songName, playlistName,user,index));

			break;
			case 3:
				System.out.println("Las canciones disponibles son: ");
				System.out.println(mcs.showSong());
				System.out.println("Ingrese el nombre de la canción que desea añadir: ");
				songName = reader.nextLine();
				System.out.println("Las playlist disponibles son: ");
				System.out.println(mcs.showPlaylists());
				System.out.println("Ingrese el nombre de la playlist PRIVADA donde añadira la canción: ");
				playlistName = reader.nextLine();
				System.out.println("Ingrese el nombre del usuario que creo la playlist y añadira la canción ");
				user = reader.nextLine();
				index = 0;
				System.out.println(mcs.addSongToPLaylist(songName, playlistName,user,index));
			break;
			default:
			System.out.println("Error, opción no válida");
		
		}

	}

		}
	
