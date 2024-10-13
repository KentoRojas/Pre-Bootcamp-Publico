public class TiendaOnline {
   public static void main(String[] args) {
       // VARIABLES DE LA TIENDA
       // Mensajes de la aplicación
       String mensajeBienvenida = "Bienvenido a nuestra tienda en línea, ";
       String mensajeConfirmacion = ", tu pedido ha sido confirmado";
       String mensajeRechazo = ", lamentablemente el artículo seleccionado está agotado";
       String mensajeMostrarTotal = "El total de tu compra es: $";
      
       // Variables de productos (agrega las tuyas a continuación)
       double precioLibro = 15.99;
       double precioCamiseta = 25.50;
       double precioPantalones = 12.50;
       double precioZapatos = 20.40;
  
       // Variables de clientes (agrega las tuyas a continuación)
    String cliente1 = "Ana";
    String cliente2 = "Alex";
    String cliente3 = "Miguel";

  
       // Estado de pedidos (agrega las tuyas a continuación)
       boolean pedidoConfirmadoCliente1 = true;
       boolean pedidoConfirmadoCliente2 = true;
       boolean pedidoConfirmadoCliente3 = true;
  
    //Pedidos
   double pedidoCliente1 = precioPantalones; 
   double pedidoCliente2 = 2 * precioZapatos + precioCamiseta + precioPantalones; 
   double pedidoCliente3 = precioZapatos + precioLibro; 

       // INTERACCIÓN DE LA APLICACIÓN
       System.out.println(mensajeBienvenida + cliente1); // Muestra "Bienvenido a nuestra tienda en línea, Ana"
       if (pedidoConfirmadoCliente1) {
           System.out.println(cliente1 + mensajeConfirmacion);
       } else {
           System.out.println(cliente1 + mensajeRechazo);
       }
  
       System.out.println(mensajeBienvenida + cliente3); // Muestra "Bienvenido a nuestra tienda en línea, Miguel"
       if (pedidoConfirmadoCliente3) {
           System.out.println(cliente3 + mensajeConfirmacion);
       } else {
           System.out.println(cliente3 + mensajeRechazo);
       }
  
       System.out.println(mensajeBienvenida + cliente2); // Muestra "Bienvenido a nuestra tienda en línea, Alex"
       System.out.println(mensajeMostrarTotal + pedidoCliente2); // Muestra el total de la orden de Alex
       if (pedidoConfirmadoCliente2) {
           System.out.println(cliente2 + mensajeConfirmacion);
       } else {
           System.out.println(cliente2 + mensajeRechazo);
       }
  
       double pedidoCliente3Error = pedidoCliente3 + precioPantalones + precioCamiseta;
       double diferencia = pedidoCliente3Error - pedidoCliente3;
       System.out.println("Miguel, hemos detectado un error en su pedido. La diferencia es de $" + diferencia);
       // Muestra "Bienvenido a nuestra tienda en línea, Ana"
       // ** Aquí irán las declaraciones de impresión relacionadas con la interacción del cliente ** //
       
   }
}