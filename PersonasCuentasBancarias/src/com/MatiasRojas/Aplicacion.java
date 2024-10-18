package com.MatiasRojas;

import Clases.Persona;
import Clases.CuentaBancaria;

public class Aplicacion {
    public static void main(String[] args) {
        Persona persona1 = new Persona("Sarif", 30);
        Persona persona2 = new Persona("Arce", 25);
        Persona persona3 = new Persona("Tocornal", 28);

        CuentaBancaria cuenta1 = new CuentaBancaria(1000.0, persona1);
        CuentaBancaria cuenta2 = new CuentaBancaria(2000.0, persona2);
        CuentaBancaria cuenta3 = new CuentaBancaria(1500.0, persona3);

        cuenta1.depositar(500);
        cuenta2.retirar(250);
        cuenta3.depositar(300);

        System.out.println("Saldo cuenta 1: " + cuenta1.getSaldo());
        System.out.println("Saldo cuenta 2: " + cuenta2.getSaldo());
        System.out.println("Saldo cuenta 3: " + cuenta3.getSaldo());

        CuentaBancaria.imprimeInformacionDeTodasLasCuentas();
    }
}

