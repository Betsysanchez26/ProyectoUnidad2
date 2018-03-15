package com.example.betsysanchez.proyectounidad2.Activitys;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import com.example.betsysanchez.proyectounidad2.Entidades.BDHandler;
import com.example.betsysanchez.proyectounidad2.Entidades.Cliente;
import com.example.betsysanchez.proyectounidad2.R;

/**
 * Created by BetsySanchez on 07/03/2018.
 */

public class NuevoClienteActivity extends AppCompatActivity {
    EditText nombre,direccion, celular,mail,descripcion,monto;
    CheckBox finalizada;
    Button guardar,cancelar;
    public static String identificadorC="";
    BDHandler conn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.nuevo_cliente);

        nombre=findViewById(R.id.nombreCli);
        direccion=findViewById(R.id.direccionCli);
        celular=findViewById(R.id.celularCli);
        mail=findViewById(R.id.mailCli);
        descripcion=findViewById(R.id.descripcionCli);
        monto=findViewById(R.id.montoCli);
        finalizada=findViewById(R.id.finalizadaCli);
        guardar=findViewById(R.id.guardarCli);
        cancelar=findViewById(R.id.cancelarCli);
        conn=new BDHandler(this);
        if(identificadorC!="") {
            String [][] mod=conn.consultarClientes("select * from cliente where idCliente='" + identificadorC + "'");
            nombre.setText(mod[0][1]);
            direccion.setText(mod[0][2]);
            celular.setText(mod[0][3]);
            mail.setText(mod[0][4]);
            descripcion.setText(mod[0][5]);
            monto.setText(mod[0][6]);
            finalizada.setChecked(Boolean.parseBoolean(mod[0][7]));
        }
        guardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(identificadorC!=""){
                    conn.actCliente(identificadorC,nombre.getText().toString(),direccion.getText().toString(),celular.getText().toString()
                            ,mail.getText().toString(),descripcion.getText().toString(),monto.getText().toString(),finalizada.getText().toString());
                }else{
                    registrarCliente();
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
    private void registrarCliente() {
        BDHandler conn=new BDHandler(this);
        SQLiteDatabase db=conn.getWritableDatabase();
        ContentValues values=new ContentValues();
        values.put(Cliente.NOMBRE,nombre.getText().toString());
        values.put(Cliente.DIRECCION,direccion.getText().toString());
        values.put(Cliente.CELULAR,celular.getText().toString());
        values.put(Cliente.MAIL,mail.getText().toString());
        values.put(Cliente.DESCRIPCION,descripcion.getText().toString());
        values.put(Cliente.MONTO,monto.getText().toString());
        values.put(Cliente.FINALIZADA,finalizada.isChecked()+"");

        Long idRsultante=db.insert(Cliente.TABLE_CLIENTE, Cliente.ID,values);
        Toast.makeText(getApplicationContext(),"Id Registro: "+idRsultante,Toast.LENGTH_SHORT).show();
    }
}
