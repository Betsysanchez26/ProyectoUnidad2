package com.example.betsysanchez.proyectounidad2.Entidades;

/**
 * Created by BetsySanchez on 09/03/2018.
 */

public class Empleado {
    /**
     * Define el nombre de la tabla
     */
    public static final String TABLE_EMPLEADO = "empleado";


    /**
     * Define los campos de la tabla
     */
    public static final String ID = "idEmpleado";
    public static final String NOMBRE = "nombre";
    public static final String ACTIVIDAD = "actividad";
    public static final String FECHA_INICIO = "fecha_inicio";
    public static final String FECHA_FIN = "fecha_fin";
    public static final String CELULAR = "celular";
    public static final String CANT_OBRA = "cant_obra";
    public static final String PAGO_ESTIMADO = "pago_estimado";
    /**
     * Define la cadena SQL para la creación de la tabla
     * ->agregar aquí la otra tabla, Para la version 006
     *
     */
    public static final String CREATE_TABLE_EMPLEADO = "CREATE TABLE " + TABLE_EMPLEADO + "("
            + ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
            + NOMBRE + " TEXT,"
            + ACTIVIDAD + " TEXT,"
            + FECHA_INICIO + " TEXT,"
            + FECHA_FIN + " TEXT,"
            + CELULAR + " TEXT,"
            + CANT_OBRA + " TEXT,"
            + PAGO_ESTIMADO + " TEXT"+ ")";

}
