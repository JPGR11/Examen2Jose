package model;
import model.Profesor;

public class Curso {
    private String nombreCurso;
    private int notaObtenida;
    private int creditos;
    private String facultad;
    private Profesor[] profesor;

    public Curso(String nombreCurso, int notaObtenida, int creditos, String facultad) {
        this.nombreCurso = nombreCurso;
        this.notaObtenida = notaObtenida;
        this.creditos = creditos;
        this.facultad = facultad;
    }

    //----------------------------------------------------------------------------------------------------
    //---------------------------------------------Getters and setters------------------------------------
    //----------------------------------------------------------------------------------------------------

    public int getNota() {
        return notaObtenida;
    }

    public void setNota(int nota) {
        this.notaObtenida = nota;
    }


    public String getNombreCurso() {
        return nombreCurso;
    }

    public void setNombreCurso(String nombreCurso) {
        this.nombreCurso = nombreCurso;
    }


    public int getCreditos() {
        return creditos;
    }

    public void setCreditos(int creditos) {
        this.creditos = creditos;
    }


    public String getFacultad() {
        return facultad;
    }

    public void setFacultad(String facultad) {
        this.facultad = facultad;
    }


    public Profesor[] getProfesor() {
        return profesor;
    }

    public void setProfesor(Profesor profesor) {
        this.profesor = profesor;
    }
}