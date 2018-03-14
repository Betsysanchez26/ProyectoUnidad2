package com.example.betsysanchez.proyectounidad2.Entidades;

/**
 * Created by BetsySanchez on 09/03/2018.
 */

public class Cliente {

    /**
     * Define el nombre de la tabla
     */
    public static final String TABLE_CLIENTE = "cliente";


    /**
     * Define los campos de la tabla
     */
    public static final String ID = "idCliente";
    public static final String NOMBRE = "nombre";
    public static final String DIRECCION = "direccion";
    public static final String CELULAR = "celular";
    public static final String MAIL = "mail";
    public static final String DESCRIPCION = "descripcion";
    public static final String MONTO = "monto";
    public static final String FINALIZADA = "finalizada";
    /**
     * Define la cadena SQL para la creación de la tabla
     * ->agregar aquí la otra tabla, Para la version 006
     *
     */
    public static final String CREATE_TABLE_CLIENTE = "CREATE TABLE " + TABLE_CLIENTE + "("
            + ID + " INTEGER PRIMARY KEY,"
            + NOMBRE + " TEXT,"
            + DIRECCION + " TEXT,"
            + CELULAR + " TEXT,"
            + MAIL + " TEXT,"
            + DESCRIPCION + " TEXT,"
            + MONTO + " TEXT,"
            + FINALIZADA + " TEXT"+ ")";

}
