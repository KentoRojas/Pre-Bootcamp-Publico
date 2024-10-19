package Apli;
import com.clases.TiendaElectronica;
import com.clases.ProductoElectrodomestico;
import com.clases.Televisor;
import com.clases.ComputadoraPortatil;

public class Aplicacion {

	public static void main(String[] args) {
		
		TiendaElectronica tienda = new TiendaElectronica();

        ComputadoraPortatil laptop = new ComputadoraPortatil("Laptop ASUS", 800000, 5, "ASUS", 16, 12345);
        Televisor televisor = new Televisor("Televisor Nexon", 450000, 55, "HD");

        tienda.agregarProducto(laptop);
        tienda.agregarProducto(televisor);

        System.out.println("\nProductos en el inventario inicial:");
        tienda.mostrarProductos();

        System.out.println("\nRealizando ventas...");
        tienda.realizarVenta("Laptop ASUS");
        tienda.realizarVenta("Laptop ASUS"); 
        tienda.realizarVenta("Televisor NEXON"); 

        System.out.println("\nProductos en el inventario después de las ventas:");
        tienda.mostrarProductos();
    }
}
