package com.clases;

public class Televisor extends ProductoElectrodomestico {
    private int tamañoPantalla;
    private String resolucion;

    public Televisor(String marca,  double precio, int tamañoPantalla, String resolucion) {
        super(marca, precio);
        this.tamañoPantalla = tamañoPantalla;
        this.resolucion = resolucion;
    }

    @Override
    public void mostrarInformacion() {
        super.mostrarInformacion();
        System.out.println("Tamaño de pantalla: " + tamañoPantalla + " pulgadas");
        System.out.println("Resolución: " + resolucion);
    }
}


