package com.example.betsysanchez.proyectounidad2.Entidades;

/**
 * Created by BetsySanchez on 13/03/2018.
 */

public class ActividadEmpleado {
    /**
     * Define el nombre de la tabla
     */
    public static final String TABLE_ACTIVIDAD = "actividad_empleado";


    /**
     * Define los campos de la tabla
     */
    public static final String ID_CLIENTE= "id_cliente";
    public static final String ID_EMPLEADO = "id_empleado";
    /**
     * Define la cadena SQL para la creación de la tabla
     * ->agregar aquí la otra tabla, Para la version 006
     *
     */
    public static final String CREATE_TABLE_ACTIVIDAD_EMPLEADO = "CREATE TABLE " + TABLE_ACTIVIDAD + "("
            + ID_CLIENTE + " INTEGER,"
            + ID_EMPLEADO + " INTEGER"+ ","
            +"FOREIGN KEY("+ID_CLIENTE+") REFERENCES cliente(idCliente)"
            +"FOREIGN KEY("+ID_EMPLEADO+") REFERENCES empleado(idEmpleado))";

}
