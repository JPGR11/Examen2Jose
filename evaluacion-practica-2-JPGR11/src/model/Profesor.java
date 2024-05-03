package model;

public class Profesor {
    private String nombre;
    private int edad;
    private String cedula;
	private TypeTeacher tipoProfesor;

    public Profesor(String nombre, int edad, String cedula, TypeTeacher tipoProfesor) {
        this.nombre = nombre;
        this.edad = edad;
        this.cedula = cedula;
		this.tipoProfesor = tipoProfesor;
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

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }
}