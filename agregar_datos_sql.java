import java.util.Random;
import java.util.Scanner;
public class agregar_datos_sql{
	//Aquí declaro los objetos globales
	static Scanner sc = new Scanner(System.in);
	static Random rnd = new Random();
	//DATOS PARA EL PROGRAMA
	static String nombres[] = {"Andrea", "Laura", "Juan", "Carlos", "Luis", "Diego", "Gonzalo", "Jeremy", "Jesús", "Bryan", "Angelo", "Jimena", "Alondra", "Lilian","Joaquín"};
	static String apellidos[] = {"Murga Pascual", "Escalona Palmer", "Ramiz Agullo", "Barriga Esteban", "Segura Gárate", "Uribe Delsagavia", "Uriarte Gordillo", "Nebot Soto", "Berrocal izquierdo", "Egea Solsona", "Barrio Silva", "Montes Pariona", "Amoros Barrena", "Nicolau Abat","Cabello Murga"};
	static String pais[] = {"Perú", "Argentina", "Chile", "México", "Panamá", "Uruguay", "Venezuela", "Brasil", "Bolivia", "Perú"};
	static String estado_civil[] = {"Soltero", "Casado", "Viudo", "Divorciado"};
	//Declaración de variables
	static int dni_random, cel_random;
	static int columnas_array[];
	static String matriz_datos_random[][]; 
	static int num_filas, num_columnas;
	static String respuesta, nom_random, ape_random, pais_random, email, estado_civil_random;

	//Método para limpiar pantalla
	public static void limpiar_pantalla(){
		for (int i=0; i<=70; i++){
			System.out.println("");
		}
	}
	//Método main
	public static void main(String[] args){
		int cant_8 = 0;
		
		//Portada
		System.out.println("=======================================");
		System.out.println("AGREGANDO REGISTROS A UNA BASE DE DATOS");
		System.out.println("=======================================");
		System.out.print("\nIngrese el número de columnas: ");
		num_columnas = sc.nextInt();
		columnas_array = new int[num_columnas];
		//Aquí se elegirá la cantidad de las columnas

		limpiar_pantalla();

		//Portada de categorías
		System.out.println("\n==========");
		System.out.println("CATEGORÍAS");
		System.out.println("==========");

		System.out.println("\n1) Nombres\n2) Apellidos\n3) DNI's\n4) Números de celular\n5) Estado Cívil\n6) E-mail\n7) País\n8) Otros\n");
		//Con este bucle FOR se elegirán las categorías en datos INT
		for (int i=0; i<num_columnas; i++){
		System.out.print("Ingrese el Nº de categoría para la columna Nº "+(i+1)+": ");
			columnas_array[i] = sc.nextInt();
		}

		for (int i=0; i<columnas_array.length;i++){
			if (columnas_array[i]==8){
				cant_8++;
			}
		}
		//Método para generar datos random
		generar_datos(columnas_array, cant_8);
		//Se introducirá el número de filas de registros
		System.out.print("\nIngrese el número de filas: ");
		num_filas = sc.nextInt();

		limpiar_pantalla();

		//Resultados
		resultados(num_filas, columnas_array.length, cant_8);
	}

		public static void resultados(int x, int y, int z){
			System.out.println("==========");
			System.out.println("RESULTADOS");
			System.out.println("==========\n");
			
			//Este for será para las filas
			//Coloqué los randoms acá para que se guarden y el email dependa del nombre y apellido guardado
			for (int i=0; i<x; i++){
				int c=0;
				System.out.print("(");
				nom_random = nombres[rnd.nextInt(nombres.length)];
				ape_random = apellidos[rnd.nextInt(apellidos.length)];
				pais_random = pais[rnd.nextInt(pais.length)];
				dni_random = rnd.nextInt(99999999);
				cel_random = rnd.nextInt(900000000, 999999999);
				estado_civil_random = estado_civil[rnd.nextInt(estado_civil.length)];
				email = (nom_random.substring(0,4)+"."+ape_random.substring(0,3)+"@gmail.com").toLowerCase();
				//Este FOR son para las columnas
				for (int j=0; j<y; j++){
					//Colqué este IF para que cuando el c++ valga lo mismo que matriz_random.length(), le reste 1.
					//Porque sino el c++ vuelve y ahora valdrá uno mas, y saldra error.
					if (c==matriz_datos_random.length){
						c=matriz_datos_random.length-1;
					}
					switch(columnas_array[j]){
					case 1: System.out.print("'"+nom_random+"'");break;
					case 2: System.out.print("'"+ape_random+"'");break;
					case 3: System.out.print("'"+String.format("%08d", dni_random)+"'");break;
					case 4: System.out.print("'"+cel_random+"'");break;
					case 5: System.out.print("'"+estado_civil_random+"'");break;
					case 6: System.out.print("'"+email+"'");break;
					case 7: System.out.print("'"+pais_random+"'");break;
					case 8: System.out.print("'"+matriz_datos_random[c][rnd.nextInt(matriz_datos_random[c].length)]+"'");c++;break;
					}
					//Puse un IF, para que todas las columnas tengan ",". Pero cuando llegue a la útlima no la coloque
					if(j<columnas_array.length-1){
						System.out.print(", ");
					}
				}
				//Aquí de igual puse que todas las filas tengan una "," al final. Pero en la última ya no la tenga.
				if(i<num_filas-1){
					System.out.println("),");
				}
				else{
					System.out.println(")");			
				}
			}
		}
		public static void generar_datos(int[] columnas, int x){
			int c=0;
			matriz_datos_random = new String[x][];
			for(int i=0;i<columnas.length;i++){
				if (columnas[i]==8){
						System.out.print("Ingrese la cantidad de datos a introducir en la columna Nº "+(i+1)+": ");
						int cant_datos=sc.nextInt();
						sc.nextLine(); //borro el ENTER del nextInt
						matriz_datos_random[c]=new String[cant_datos];

						for (int j=0;j<matriz_datos_random[c].length;j++){
							System.out.print("Dato Nº "+(j+1)+": ");
							matriz_datos_random[c][j]=sc.nextLine();
						}
						c++;
				}
			}

		}
}