package com.example.betsysanchez.proyectounidad2.Activitys;

import android.animation.StateListAnimator;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.ImageButton;
import android.widget.Switch;
import android.widget.Toast;

import com.example.betsysanchez.proyectounidad2.Adapters.ClienteAdapter;
import com.example.betsysanchez.proyectounidad2.Entidades.BDHandler;
import com.example.betsysanchez.proyectounidad2.R;

public class MainActivity extends AppCompatActivity {
    ImageButton nuevoCliente,empleado;
    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager layoutManager;
    Switch filtro;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        nuevoCliente = findViewById(R.id.clientes);
        empleado = findViewById(R.id.empleados);
        filtro= findViewById(R.id.switchFin);
        recyclerView = findViewById(R.id.recyclerObras);

        load("Select * from cliente order by nombre");
        filtro.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(b){
                    load("Select * from cliente where finalizada='true' order by nombre");
                   // Toast.makeText(getApplicationContext(),"Estado "+b,Toast.LENGTH_SHORT).show();
                }else{
                    load("Select * from cliente order by nombre");
                }
            }
        });
           // a = conn.consultarClientes("Select * from cliente where finalizada=true order by nombre");
           // a = conn.consultarClientes("Select * from cliente order by nombre");


        nuevoCliente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i= new Intent(getApplicationContext(),NuevoClienteActivity.class);
                startActivity(i);

            }
        });
        empleado.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(),EmpleadoActivity.class);
                startActivity(i);
            }
        });
    }
    public void load(String query){
        BDHandler conn=new BDHandler(this);
        String [][] a=conn.consultarClientes(query);
        adapter = new ClienteAdapter(a,getApplicationContext());
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
        recyclerView.getAdapter().notifyDataSetChanged();
    }
}
