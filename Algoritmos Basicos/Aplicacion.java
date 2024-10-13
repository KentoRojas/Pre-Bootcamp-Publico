import clases.Algoritmos;  // Importar la clase Algoritmos desde el paquete clases

public class Aplicacion {

    public static void main(String[] args) {
        System.out.println("¿4 es par? " + Algoritmos.esPar(4)); 
        System.out.println("¿7 es par? " + Algoritmos.esPar(7)); 

        System.out.println("¿5 es primo? " + Algoritmos.esPrimo(5)); 
        System.out.println("¿10 es primo? " + Algoritmos.esPrimo(10)); 

        System.out.println("Reversa de 'Hola': " + Algoritmos.stringEnReversa("Hola")); 

        System.out.println("¿'anilina' es un palíndromo? " + Algoritmos.esPalindromo("anilina")); 
        System.out.println("¿'Hola' es un palíndromo? " + Algoritmos.esPalindromo("Hola")); 

        System.out.println("Secuencia FizzBuzz para 15:");
        Algoritmos.secuenciaFizzBuzz(15); 
    }
}
