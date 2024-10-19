package com.clases;

import java.util.ArrayList;

public class TiendaElectronica {
    private ArrayList<ProductoElectrodomestico> listaDeProductos;

    public TiendaElectronica() {
        listaDeProductos = new ArrayList<>();
    }

    public void agregarProducto(ProductoElectrodomestico producto) {
        listaDeProductos.add(producto);
        System.out.println("Producto agregado: " + producto.getNombre());
    }

    public void mostrarProductos() {
        if (listaDeProductos.isEmpty()) {
            System.out.println("No hay productos disponibles en el inventario.");
            return;
        }
        
        System.out.println("Productos disponibles:");
        for (ProductoElectrodomestico producto : listaDeProductos) {
            System.out.println("- " + producto.getNombre() + " | Cantidad: " + producto.getCantidadDisponible());
        }
    }

    public ProductoElectrodomestico buscarProductoPorNombre(String nombre) {
        for (ProductoElectrodomestico producto : listaDeProductos) {
            if (producto.getNombre().equalsIgnoreCase(nombre)) {
                return producto;
            }
        }
        return null;
    }

    public void realizarVenta(String nombreProducto) {
        ProductoElectrodomestico producto = buscarProductoPorNombre(nombreProducto);
        
        if (producto != null) {
            if (producto.getCantidadDisponible() > 0) {
                producto.setCantidadDisponible(producto.getCantidadDisponible() - 1);
                System.out.println("Venta realizada: " + producto.getNombre());
                System.out.println("Cantidad restante: " + producto.getCantidadDisponible());
            } else {
                System.out.println("Producto agotado: " + producto.getNombre());
            }
        } else {
            System.out.println("Producto no encontrado: " + nombreProducto);
        }
    }
}
