package fi.unju.edu.ar.tpfinal.Models;

import java.util.Date;

/**
 * Created by joel on 06/11/2017.
 */

public class Producto {
    private Integer id;
    private String nombre;
    private String unidad;
    private Integer cantidad;
    private Double precio;
    private String fechaCompra;
    private Category categoria;
    private byte[] imagen;
    private String comercio;



    public Producto() {
    }

    public Producto(Integer id, String nombre, String unidad, Integer cantidad, Double precio, String fechaCompra, Category categoria, byte[] imagen, String comercio) {
        this.id = id;
        this.nombre = nombre;
        this.unidad = unidad;
        this.cantidad = cantidad;
        this.precio = precio;
        this.fechaCompra = fechaCompra;
        this.categoria = categoria;
        this.imagen = imagen;
        this.comercio = comercio;
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getUnidad() {
        return unidad;
    }

    public void setUnidad(String unidad) {
        this.unidad = unidad;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    public String getFechaCompra() {
        return fechaCompra;
    }

    public void setFechaCompra(String fechaCompra) {
        this.fechaCompra = fechaCompra;
    }

    public byte[] getImagen() {
        return imagen;
    }

    public void setImagen(byte[] imagen) {
        this.imagen = imagen;
    }

    public String getComercio() {
        return comercio;
    }

    public void setComercio(String comercio) {
        this.comercio = comercio;
    }

    public Category getCategoria() {
        return categoria;
    }

    public void setCategoria(Category categoria) {
        this.categoria = categoria;
    }
}
