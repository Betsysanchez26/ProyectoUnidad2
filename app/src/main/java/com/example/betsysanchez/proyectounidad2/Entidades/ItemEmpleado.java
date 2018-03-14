package com.example.betsysanchez.proyectounidad2.Entidades;

/**
 * Created by BetsySanchez on 09/03/2018.
 */

public class ItemEmpleado {
    private int id;
    private String nombre;
    private String actividad;
    private String fecha_inicio;
    private String fecha_fin;
    private String celular;
    private int cant_obra;
    private float pago_estimado;

    public ItemEmpleado() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getActividad() {
        return actividad;
    }

    public void setActividad(String actividad) {
        this.actividad = actividad;
    }

    public String getFecha_inicio() {
        return fecha_inicio;
    }

    public void setFecha_inicio(String fecha_inicio) {
        this.fecha_inicio = fecha_inicio;
    }

    public String getFecha_fin() {
        return fecha_fin;
    }

    public void setFecha_fin(String fecha_fin) {
        this.fecha_fin = fecha_fin;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public int getCant_obra() {
        return cant_obra;
    }

    public void setCant_obra(int cant_obra) {
        this.cant_obra = cant_obra;
    }

    public float getPago_estimado() {
        return pago_estimado;
    }

    public void setPago_estimado(float pago_estimado) {
        this.pago_estimado = pago_estimado;
    }
}
