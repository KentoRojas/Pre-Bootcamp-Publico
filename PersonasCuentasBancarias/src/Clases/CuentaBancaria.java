package Clases;

import java.util.ArrayList;
import java.util.Random;

public class CuentaBancaria {
    private static int totalCuentas = 0;
    private double saldo; 
    private Persona titular;
    private int numeroCuenta; 
    private static ArrayList<CuentaBancaria> listaDeCuentasBancarias = new ArrayList<>(); 

    public CuentaBancaria(double saldo, Persona titular) {
        this.saldo = saldo;
        this.titular = titular;
        this.numeroCuenta = generarNumeroCuenta(); 
        totalCuentas++;
        listaDeCuentasBancarias.add(this); 
    }

   
    private int generarNumeroCuenta() {
        Random random = new Random();
        return 100000 + random.nextInt(900000); 
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public Persona getTitular() {
        return titular;
    }

    public void setTitular(Persona titular) {
        this.titular = titular;
    }

    public int getNumeroCuenta() {
        return numeroCuenta;
    }

    public static int getTotalCuentas() {
        return totalCuentas;
    }

    public static ArrayList<CuentaBancaria> getListaDeCuentasBancarias() {
        return listaDeCuentasBancarias;
    }
    public void depositar(double monto) {
        if (monto > 0) {
            saldo += monto;
            System.out.println("Se han depositado " + monto + " a la cuenta " + numeroCuenta);
        } else {
            System.out.println("El monto a depositar debe ser positivo.");
        }
    }

    public void retirar(double monto) {
        if (monto > 0 && saldo >= monto) {
            saldo -= monto;
            System.out.println("Se han retirado " + monto + " de la cuenta " + numeroCuenta);
        } else {
            System.out.println("Saldo insuficiente o monto no válido.");
        }
    }

    public void despliegaInformacion() {
    	System.out.println("Información del titular:"); titular.despliegaInformacion();
        System.out.println("Número de cuenta: " + numeroCuenta);
        System.out.println("Saldo: " + saldo);
    }

    public static void imprimeInformacionDeTodasLasCuentas() {
        System.out.println("Información de todas las cuentas:");
        for (CuentaBancaria cuenta : listaDeCuentasBancarias) {
            cuenta.despliegaInformacion();
            System.out.println("---------------");
        }
    }
}

    


