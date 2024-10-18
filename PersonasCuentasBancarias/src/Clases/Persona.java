package Clases;

public class Persona {
    public String nombre;
    public int edad;  

    public Persona(String nombre ,int edad) {
        this.nombre = nombre;
        this.edad = edad;
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
		
	public void despliegaInformacion() {
		System.out.println("nombre: " + this.nombre); 
        System.out.println("edad: " + this.edad); 
	}
}
