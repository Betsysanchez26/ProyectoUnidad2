package com.example.betsysanchez.proyectounidad2.Activitys;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.betsysanchez.proyectounidad2.Entidades.BDHandler;
import com.example.betsysanchez.proyectounidad2.Entidades.Empleado;
import com.example.betsysanchez.proyectounidad2.Entidades.ActividadEmpleado;
import com.example.betsysanchez.proyectounidad2.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by BetsySanchez on 07/03/2018.
 */

public class NuevoEmpleadoActivity extends AppCompatActivity {
    EditText nombre,celular,cantObra,pagoEst;
    Spinner actividad;
    Button guardar,cancelar;
    DatePicker fecIni,fecFin;
    public static String identificador="";
    public ArrayList<String> datos;
    BDHandler conn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.nuevo_empleado);

        nombre=findViewById(R.id.nombreEmp);
        actividad=findViewById(R.id.actividadEmp);
        fecIni=findViewById(R.id.fecIni);
        fecFin=findViewById(R.id.fecFin);
        celular=findViewById(R.id.celularEmp);
        cantObra=findViewById(R.id.cantObra);
        pagoEst=findViewById(R.id.pagoEst);
        guardar=findViewById(R.id.saveEmpl);
        cancelar=findViewById(R.id.cancelEmpl);

        conn=new BDHandler(this);
        String [][] a = conn.consultarClientes("Select * from cliente");
        datos = new ArrayList<String>();
        for(int i=0;i<a.length;i++){
            datos.add(a[i][5]);
        }
        actividad.setAdapter(new ArrayAdapter<String>(this,R.layout.support_simple_spinner_dropdown_item,datos));
        //hacer consulta e imprimir el id
        System.out.println(identificador);
       if(identificador!="") {
            String [][] mod=conn.consultarEmpleados("select * from empleado where idEmpleado='" + identificador + "'");
            nombre.setText(mod[0][1]);
            actividad.setSelection(Integer.parseInt(mod[0][2]));
            String [] fi = mod[0][3].split("-");
            fecIni.updateDate(Integer.parseInt(fi[2])
                    ,Integer.parseInt(fi[1])-1,
                    Integer.parseInt(fi[0]));
            String [] ff = mod[0][4].split("-");
            fecIni.updateDate(Integer.parseInt(ff[2])
                    ,Integer.parseInt(ff[1])-1,
                    Integer.parseInt(ff[0]));
            celular.setText(mod[0][5]);
            cantObra.setText(mod[0][6]);
            pagoEst.setText(mod[0][7]);
        }

        guardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(identificador!=""){
                    String feIni=fecIni.getDayOfMonth()+"-"+(fecIni.getMonth()+1)+"-"+fecIni.getYear();
                    String feFin=fecFin.getDayOfMonth()+"-"+(fecFin.getMonth()+1)+"-"+fecFin.getYear();
                    conn.actEmpleado(identificador,nombre.getText().toString(),actividad.getSelectedItemPosition()+"",feIni,feFin
                    ,celular.getText().toString(),cantObra.getText().toString(),pagoEst.getText().toString());
                }else{
                registrarEmpleado();
                }
                finish();
            }
        });

        cancelar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
    private void registrarEmpleado() {
        BDHandler conn=new BDHandler(this);
        SQLiteDatabase db=conn.getWritableDatabase();
        ContentValues values=new ContentValues();
        values.put(Empleado.NOMBRE,nombre.getText().toString());
        values.put(Empleado.ACTIVIDAD,actividad.getSelectedItemPosition());
        String feIni=fecIni.getDayOfMonth()+"-"+(fecIni.getMonth()+1)+"-"+fecIni.getYear();
        values.put(Empleado.FECHA_INICIO,feIni);
        String feFin=fecFin.getDayOfMonth()+"-"+(fecFin.getMonth()+1)+"-"+fecFin.getYear();
        values.put(Empleado.FECHA_FIN,feFin);
        values.put(Empleado.CELULAR,celular.getText().toString());
        values.put(Empleado.CANT_OBRA,cantObra.getText().toString());
        values.put(Empleado.PAGO_ESTIMADO,pagoEst.getText().toString());

        Long idRsultante=db.insert(Empleado.TABLE_EMPLEADO, Empleado.ID,values);
        Toast.makeText(getApplicationContext(),"Id Registro: "+idRsultante,Toast.LENGTH_SHORT).show();

        ContentValues values2= new ContentValues();
        values2.put(ActividadEmpleado.ID_CLIENTE,(actividad.getSelectedItemPosition()+1)+"");
        values2.put(ActividadEmpleado.ID_EMPLEADO,idRsultante);
        Long idResultante2=db.insert(ActividadEmpleado.TABLE_ACTIVIDAD,ActividadEmpleado.ID_EMPLEADO,values2);
        Toast.makeText(getApplicationContext(),"Id Registro: "+idResultante2,Toast.LENGTH_SHORT).show();

    }

}
