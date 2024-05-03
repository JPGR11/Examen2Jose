package ui;

import java.util.Scanner;
import model.Controladora;

public class Executable {

	// Atributos de la clase Ejecutable
	private Scanner reader;
	private Controladora cont;
	private static boolean flag;

	private Executable() {
		reader = new Scanner(System.in);
		cont = new Controladora();
	}

	public void run(boolean flag)
	{

		flag = false;

		while (!flag) {
			linea();
			System.out.println("------------------------" + "Bienvenido al menu" + "----------------------");
			linea();
			System.out.println("Opciones:\n"+ "----------------------------------------------------------------\n" + "[1] Registrar estudiante \n" + "[2] Imprimir estudiantes\n"
					+ "[3] Crear semestre a estudiante \n" + "[4] Mostrar semestres de un estudiante \n" + "[5] Registrar curso en el semestre de un estudianta.\n" + "[6] Mostrar promedio.\n"+ "[7] Salir del programa \n");

			int option = reader.nextInt();
			linea();
			reader.nextLine();

			switch (option) {
					case 1:
					erase();
					registrarEstudiante();
					break;

					case 2:
					erase();
					imprimirEstudiantes();
					break;

					case 3:
					erase();
					crearSemestreAEstudiante();
					break;

					case 4:
					erase();
					imprimirSemestresDeEstudiante();
					break;

					case 5:
					erase();
					registrarCursos();
					break;
					
					case 6:
					erase();
					calcularNotas();
					break;

					case 7:
					erase();
					calcularNotas();
					break;

					case 8:
					erase();
					
					break;
					
					case 9:
						flag = true;
						System.exit(0);
						break;
					default:
						System.out.print("Por favor ingrese una opcion valida");
						continue;
			}

		}

	}

	public static void main(String[] args) {
		Executable mainApp = new Executable();
		mainApp.run(flag);
	}

	public void asociarProfesorConCurso(){
		linea();
		System.out.println("------------------Asociar profesor con curso--------------------");
		linea();

		System.out.println("Ingrese el nombre del profesor: ");
		String nameTeacher = reader.nextLine();
		System.out.println("Ingrese el nombre del curso: ");
		String nombreCurso = reader.nextLine();
		System.out.println("Ingrese el semestre del cual dictará clases el profesor: ");
		String nameSemester = reader.nextLine();
		showStudentsIndependent();
		System.out.println("Ingrese el código del estudiante el cual va a ver clase con este profesor: ");
		String studentCode = reader.nextLine();
		
		cont.asociarProfesorConCurso(cont.buscarEstudiantePorCodigo(studentCode), nameTeacher, nombreCurso, cont.buscarSemestre(nameSemester,studentCode));
	}

	public void registrarProfesor(){
		linea();
		System.out.println("-----------------------Registrar profesor-----------------------");
		linea();
		System.out.println("Ingrese el nombre del profesor: ");
		String nameTeacher = reader.nextLine();
		System.out.println("Ingrese la edad del profesor: ");
		int ageTeacher = reader.nextInt();
		System.out.println("Ingrese la cédula del profesor: ");
		String cedula = reader.nextLine();
		System.out.println("Ingrese el tipo de profesor: \n" + "[1] Catedra. \n" + "[2] Titulares.");
		int typeTeacher = reader.nextInt();
		
		cont.crearProfesor(nameTeacher, ageTeacher, cedula, cont.tipoProfesor(typeTeacher));
	}	
	
	
	public void linea(){
		System.out.println("----------------------------------------------------------------");
	}

	public void calcularNotas(){
		linea();
		System.out.println("------------------Mostrar promedio--------------------------");
		linea();
		showStudentsIndependent();
		linea();
		System.out.println("Ingrese el estudiante al que desea consular: ");
		String studentName = reader.nextLine();
		System.out.println("Ingrese el semestre que desea consultar: ");
		String semester = reader.nextLine();

		System.out.println(cont.mostrarNotaSemestre(semester, cont.buscarEstudiante(studentName)));
	}

	//-----------------------------------------------------------------------------------------------
	//---------------------------------------Requerimiento 1-----------------------------------------
	//-----------------------------------------------------------------------------------------------

	public void registrarEstudiante() {
		String nombreEstudiante, codigoEstudiante;
		int edadEstudiante;

		linea();
		System.out.println("------------------Registrar estudiante--------------------------");
		linea();
		System.out.println("Ingrese nombre del estudiante: ");
		nombreEstudiante = reader.nextLine();
		System.out.println("Ingrese edad del estudiante: ");
		edadEstudiante = reader.nextInt();
		reader.nextLine(); // Limpiar el buffer
		System.out.println("Ingrese codigo del estudiante: ");
		codigoEstudiante = reader.nextLine();
		
		//System.out.println("Datos del estudiante: \n" + 
		//"Nombre: " + nombreEstudiante + "\n" + 
		//"Edad: " + edadEstudiante + "\n" + 
		//"Codigo: " + codigoEstudiante);
		
		
		cont.agregarEstudiante(cont.crearEstudiante(nombreEstudiante, edadEstudiante, codigoEstudiante));
	}

	public void erase(){
		System.out.print("\033[H\033[2J");  
		System.out.flush(); 
	}

	//-----------------------------------------------------------------------------------------------
	//---------------------------------------Requerimiento 2-----------------------------------------
	//-----------------------------------------------------------------------------------------------

	public void showStudentsIndependent(){
		int cantidadEstudiantes = cont.obtenerCantidadEstudiantes();

		for(int i = 0; i <= cantidadEstudiantes; i++) {
			String impresionEstudiante = cont.listarEstudiante(i);
			if(impresionEstudiante != "") {
				System.out.println("Estudiante " + (i+1) + ": "); 
				System.out.println(impresionEstudiante);
			} else {
				break;
			}
			
		}
	}

	public void imprimirEstudiantes() {
		linea();
		System.out.println("--------------------Mostrar estudiantes-------------------------");
		linea();

		showStudentsIndependent();

	}

	//-----------------------------------------------------------------------------------------------
	//---------------------------------------Requerimiento 3-----------------------------------------
	//-----------------------------------------------------------------------------------------------

	public void crearSemestreAEstudiante() {

		String codigoEstudiante;

		linea();
		System.out.println("-----------------Crear semestre a estudiante--------------------");
		linea();

		showStudentsIndependent();

		linea();

		System.out.println("Ingrese el codigo del estudiante al que le vamos a crear el semestre: ");

		codigoEstudiante = reader.nextLine();

		String nombrePeriodoSemestre;

		System.out.println("Ingrese el nombre del periodo del semestre: ");

		nombrePeriodoSemestre = reader.nextLine();

		if(cont.buscarEstudiantePorCodigo(codigoEstudiante) != null){
			cont.asociarSemestreConEstudiante(cont.buscarEstudiantePorCodigo(codigoEstudiante), cont.crearSemestre(nombrePeriodoSemestre));
			System.out.println("¡Semestre registrado con éxito!");
		} else if(cont.buscarEstudiantePorCodigo(codigoEstudiante) == null){
			System.out.println("Estudiante deseado no existe en el sistema.");
		}
	}

	//-----------------------------------------------------------------------------------------------
	//---------------------------------------Requerimiento 4-----------------------------------------
	//-----------------------------------------------------------------------------------------------

	public void imprimirSemestresDeEstudiante() {
		linea();
		System.out.println("----------------------Mostrar semestres-------------------------");
		linea();

		String codigoEstudiante;

		System.out.println("Ingrese el codigo del estudiante al que le vamos a averiguar el semestre: ");

		codigoEstudiante = reader.nextLine();



		for(int i = 0; i <= cont.buscarEstudiantePorCodigo(codigoEstudiante).cuantosSemestres(); i++) {
			String impresionEstudiante = cont.listarSemestre(i, cont.buscarEstudiantePorCodigo(codigoEstudiante));
			if(impresionEstudiante != "") {
				System.out.println(impresionEstudiante);
			} else {
				break;
			}
			
		}
		
	}

	//-----------------------------------------------------------------------------------------------
	//---------------------------------------Requerimiento 5-----------------------------------------
	//-----------------------------------------------------------------------------------------------

	public void registrarCursos(){
		linea();
		System.out.println("-----------------------Ingresar cursos--------------------------");
		linea();
		System.out.println("Ingrese el nombre del curso: ");
		String nombreCurso = reader.nextLine();
		System.out.println("Ingrese la nota obtenida: ");
		int nota = reader.nextInt();
		reader.nextLine();
		System.out.println("Ingrese la cantidad de creditos del curso: ");
		int creditos = reader.nextInt();
		reader.nextLine();
		System.out.println("Ingrese la facultad a la que pertenece el curso: ");
		String facultad = reader.nextLine();
		System.out.println("Ingrese el estudiante que ve el curso: ");
		String estudiante = reader.nextLine();
		System.out.println("Ingrese el semestre al que desea agregar el curso: ");
		String semestre = reader.nextLine();
		cont.asociarSemestreConCurso(cont.crearCurso(nombreCurso, nota, creditos, facultad),cont.buscarSemestre(semestre, estudiante));
	}


	

	
}