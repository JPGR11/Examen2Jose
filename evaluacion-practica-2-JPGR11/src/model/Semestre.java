package model;
import model.Curso;

public class Semestre {
    private String nombrePeriodo;
    private Curso[] cursos;

    public Semestre(String nombrePeriodo) {
        this.nombrePeriodo = nombrePeriodo;
        this.cursos = new Curso[8]; 
    }

    public String getNombrePeriodo() {
        return nombrePeriodo;
    }

    public void setNombrePeriodo(String nombrePeriodo) {
        this.nombrePeriodo = nombrePeriodo;
    }

    // Getter y setter para cursos
    public Curso[] getCursos() {
        return cursos;
    }

    public void setCursos(Curso[] cursos) {
        this.cursos = cursos;
    }

    public void sendInfo(String nameTeacher, Curso curso){
        curso.
    }

    public Curso searchCurso(String nameCurso){
        for (Curso curso: cursos) { 
        if (cursos != null && curso.getNombreCurso().equalsIgnoreCase(nameCurso)){
            return curso;
        }
    }
    return null;
    }
	
	public double calcularPromedio(String nameSemester){
        double promedio = 0;
        int contador = 0; // Variable para contar los cursos válidos
    
        for (int i = 0; i < cursos.length; i++) {
            if (cursos[i] != null && getNombrePeriodo().equalsIgnoreCase(nameSemester)) {
                promedio += cursos[i].getNota();
                contador++; // Incrementar el contador
            }
        }
    
        if (contador == 0) {
            return 0; // Si no hay cursos válidos, retornar 0 para evitar división por 0
        }
    
        promedio = promedio / contador; // Calcular el promedio dividiendo por el contador
        return promedio;
    }
    

    public void agregarCurso(Curso curso) {
        for (int i = 0; i < cursos.length; i++) {
            if (cursos[i] == null) {
                cursos[i] = curso;
                break;
            }
        }
    }
}