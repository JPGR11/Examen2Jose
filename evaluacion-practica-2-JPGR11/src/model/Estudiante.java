package model;
import model.Semestre;

public class Estudiante {
    private String nombre;
    private int edad;
    private String codigoEstudiante;
    private Semestre[] semestres; 

    public Estudiante(String nombre, int edad, String codigoEstudiante) {
        this.nombre = nombre;
        this.edad = edad;
        this.codigoEstudiante = codigoEstudiante;
        this.semestres = new Semestre[10]; // Inicializa, todas las 10 posiciones son nulas (null)
    }
	
	public Semestre buscarNombreSemestre(String semestreName){
		for (int i = 0; i < semestres.length; i++) {
            if (semestres[i].getNombrePeriodo().equals(semestreName)) {
                return semestres[i];
            }
        }
		return null;
	}

    public void asociateTeacherWithSemester(String nameTeacher, String nameCurso, Semestre semestre){
        semestre.sendInfo(nameTeacher, semestre.searchCurso(nameCurso));
    }

    public double calcularNotaSemestre(String semestreName){
		for (int i = 0; i < semestres.length; i++) {
            if (semestres[i].getNombrePeriodo().equals(semestreName)) {
                return semestres[i].calcularPromedio(semestreName);
            }
        }
		return 0;
	}

    public void sendTeacherInfo(String cursoName, String profesorName){

    }
	
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getCodigoEstudiante() {
        return codigoEstudiante;
    }

    public void setCodigoEstudiante(String codigoEstudiante) {
        this.codigoEstudiante = codigoEstudiante;
    }

    public Semestre[] getSemestres() {
        return semestres;
    }

    public void setSemestres(Semestre[] semestres) {
        this.semestres = semestres;
    }

    public void agregarSemestre(Semestre semestre) {
        for (int i = 0; i < semestres.length; i++) {
            if (semestres[i] == null) {
                semestres[i] = semestre;
                break;
            }
        }
    }

    public int cuantosSemestres() {
        return semestres.length;
    }
}