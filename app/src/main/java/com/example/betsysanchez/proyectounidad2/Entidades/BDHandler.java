package com.example.betsysanchez.proyectounidad2.Entidades;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by BetsySanchez on 10/03/2018.
 */

public class BDHandler extends SQLiteOpenHelper {
    private SQLiteDatabase db=getWritableDatabase();
    private static final String DB_NAME = "construccion.db";
    private static final int DB_VERSION = 1;

    private Empleado empleado = new Empleado();
    private Cliente cliente = new Cliente();
    private ActividadEmpleado actEmpleado = new ActividadEmpleado();
    public BDHandler(Context context) {
        super(context, DB_NAME,null,DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(empleado.CREATE_TABLE_EMPLEADO);
        db.execSQL(cliente.CREATE_TABLE_CLIENTE);
        db.execSQL(actEmpleado.CREATE_TABLE_ACTIVIDAD_EMPLEADO);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS EMPLEADO");
        onCreate(db);
    }

    public String[][] consultarEmpleados(String sql){
        Cursor c = db.rawQuery(sql,null);
        String [][] elementos = new String [c.getCount()][c.getColumnCount()];
        if (c.moveToFirst()){
            int contador=0;
            do{
                elementos[contador][0]=c.getString(c.getColumnIndex("idEmpleado"));
                elementos[contador][1]=c.getString(c.getColumnIndex("nombre"));
                elementos[contador][2]=c.getString(c.getColumnIndex("actividad"));
                elementos[contador][3]=c.getString(c.getColumnIndex("fecha_inicio"));
                elementos[contador][4]=c.getString(c.getColumnIndex("fecha_fin"));
                elementos[contador][5]=c.getString(c.getColumnIndex("celular"));
                elementos[contador][6]=c.getString(c.getColumnIndex("cant_obra"));
                elementos[contador][7]=c.getString(c.getColumnIndex("pago_estimado"));
                contador++;
            }while(c.moveToNext());
        }
        if(c!=null){c.close();}
        return elementos;
    }
    public void actEmpleado(String id,String nombre, String actividad,String fechaIni, String fechaFin
            , String celular, String cantObra, String pagoEst){
        ContentValues contentValues = new ContentValues();
        contentValues.put("nombre",nombre);
        contentValues.put("actividad",actividad);
        contentValues.put("fecha_inicio",fechaIni);
        contentValues.put("fecha_fin",fechaFin);
        contentValues.put("celular",celular);
        contentValues.put("cant_obra",cantObra);
        contentValues.put("pago_estimado",pagoEst);
        db.update("empleado",contentValues,"idEmpleado='"+id+"'",null);
    }
    public String[][] consultarClientes(String sql){
        Cursor c = db.rawQuery(sql,null);
        String [][] elementos = new String [c.getCount()][c.getColumnCount()];
        if (c.moveToFirst()){
            int contador=0;
            do{
                elementos[contador][0]=c.getString(c.getColumnIndex("idCliente"));
                elementos[contador][1]=c.getString(c.getColumnIndex("nombre"));
                elementos[contador][2]=c.getString(c.getColumnIndex("direccion"));
                elementos[contador][3]=c.getString(c.getColumnIndex("celular"));
                elementos[contador][4]=c.getString(c.getColumnIndex("mail"));
                elementos[contador][5]=c.getString(c.getColumnIndex("descripcion"));
                elementos[contador][6]=c.getString(c.getColumnIndex("monto"));
                elementos[contador][7]=c.getString(c.getColumnIndex("finalizada"));
                contador++;
            }while(c.moveToNext());
        }
        if(c!=null){c.close();}
        return elementos;
    }
}
