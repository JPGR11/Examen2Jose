package model;
import model.*;

public class Controladora {
    private Estudiante[] estudiantes;

    public Controladora() {
        this.estudiantes = new Estudiante[29];
    }

    public Profesor crearProfesor(String nombre, int edad, String cedula, TypeTeacher tipoProfesor) {
    	Profesor profesor = new Profesor(nombre, edad, cedula, tipoProfesor);
    	return profesor;
    }

    public Curso crearCurso(String nombreCurso, int notaObtenida, int creditos, String facultad) {
    	Curso curso = new Curso(nombreCurso, notaObtenida, creditos, facultad);
    	return curso;
    }

    public Semestre crearSemestre(String nombrePeriodo) {
    	Semestre semestre = new Semestre(nombrePeriodo);
    	return semestre;
    }

    public void asociarCursoConSemestre(Curso curso, Semestre semestre) {
    	semestre.agregarCurso(curso);
    }

    public double mostrarNotaSemestre(String nameSemestre, Estudiante estudiante){
        return estudiante.calcularNotaSemestre(nameSemestre);
    }

    public Estudiante buscarEstudiante(String nameStudent){
        for (Estudiante estudiante: estudiantes) { // Recorrido de objetos, "objeto por objeto"
            if (estudiante != null && estudiante.getNombre().equalsIgnoreCase(nameStudent)){
                return estudiante;
            }
        }
        return null;
    }

    public Estudiante crearEstudiante(String nombre, int edad, String codigoEstudiante) {
    	Estudiante estudiante = new Estudiante(nombre, edad, codigoEstudiante);
    	return estudiante;
    }

    public void agregarEstudiante(Estudiante estudiante) {
        for (int i = 0; i < estudiantes.length; i++) {
            if (estudiantes[i] == null) {
                estudiantes[i] = estudiante;
                break;
            }
        }
    }

    public int obtenerCantidadEstudiantes() {
		int contadorEstudiantesVerdaderos = 0;
		for (int i = 0; i < estudiantes.length; i++) {
            if (estudiantes[i] != null) {
                contadorEstudiantesVerdaderos++;
            }
        }
		return contadorEstudiantesVerdaderos;
	}

    public void asociarSemestreConEstudiante(Estudiante estudiante, Semestre semestre) {
    	estudiante.agregarSemestre(semestre);
    }

    public void asociarProfesorConCurso(Estudiante estudiante, String nameTeacher, String nameCurso, Semestre semestre){
        estudiante.asociateTeacherWithSemester(nameTeacher, nameCurso, semestre);
    }

	//--------------------------------------------Semestre con curso----------------------------------
	
	public void asociarSemestreConCurso(Curso curso, Semestre semestre) {
        semestre.agregarCurso(curso);
    }
	
	//-------------------------------------------Buscar semestre--------------------------------------
	
	public Semestre buscarSemestre(String nombreSemestre, String nombreEstudiante) {
        for (Estudiante estudiante: estudiantes) { // Recorrido de objetos, "objeto por objeto"
            if (estudiante != null && estudiante.buscarNombreSemestre(nombreSemestre) != null && estudiante.getNombre().equals(nombreEstudiante)){
				Semestre semestreBuscado = estudiante.buscarNombreSemestre(nombreSemestre);
                return semestreBuscado;
            }
        }
        return null;
    }

    public String listarEstudiante(int indice) {
        if (indice >= 0 && indice < estudiantes.length && estudiantes[indice] != null) {
            Estudiante estudiante = estudiantes[indice];
            return "Nombre: " + estudiante.getNombre() + "\n" +
                   "Edad: " + estudiante.getEdad() + "\n" +
                   "Código de Estudiante: " + estudiante.getCodigoEstudiante();
        } else {
            return "";
        }
    }

    public int obtenerCantidadEstudiantesArreglo() {
        return estudiantes.length;
    }

    public Estudiante buscarEstudiantePorCodigo(String codigo) {
        for (Estudiante estudiante : estudiantes) { // Recorrido de objetos, "objeto por objeto"
            if (estudiante != null && estudiante.getCodigoEstudiante().equals(codigo)) {
                return estudiante;
            }
        }
        return null;
    }

    public String listarSemestre(int indice, Estudiante estudiante) {
        Semestre[] semestresEstudiante = estudiante.getSemestres();
        if (indice >= 0 && indice < estudiante.getSemestres().length && semestresEstudiante[indice] != null) {
            Semestre semestre = semestresEstudiante[indice];
            return "Nombre del periodo: " + semestre.getNombrePeriodo();
        } else {
            return "";
        }
    }

    public TypeTeacher tipoProfesor(int decision){
    TypeTeacher tipoProfesor = TypeTeacher.CATEDRA;
    switch (decision) {
        case 1:
        tipoProfesor = TypeTeacher.CATEDRA;
        break;
        
        case 2:
        tipoProfesor = TypeTeacher.TITULARES;
        break;

        default:
        System.out.println("Opción no válida, por favor .");
        break;
    }
    return tipoProfesor;
    }
}