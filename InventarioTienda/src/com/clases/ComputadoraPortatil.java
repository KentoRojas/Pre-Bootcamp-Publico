package com.clases;

public class ComputadoraPortatil extends ProductoElectrodomestico {
	private String marca;
	private int memoriasRAM;
	private int numeroSerie;
	
	public ComputadoraPortatil(String nombre, double precio, int cantidadDisponible, String marca, int memoriasRAM,
			int numeroSerie) {
		super(nombre, precio, cantidadDisponible);
		this.marca = marca;
		this.memoriasRAM = memoriasRAM;
		this.numeroSerie = numeroSerie;
	}		
		 @Override
		    public void mostrarInformacion() {
		        super.mostrarInformacion();
		        System.out.println("Marca: " + marca);
		        System.out.println("Cantidad De RAM: " + memoriasRAM);
		        System.out.println("Número De Serie: " + numeroSerie);
	}
}
	



