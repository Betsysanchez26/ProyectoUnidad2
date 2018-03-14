package com.example.betsysanchez.proyectounidad2.Activitys;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageButton;

import com.example.betsysanchez.proyectounidad2.Adapters.ClienteAdapter;
import com.example.betsysanchez.proyectounidad2.Entidades.BDHandler;
import com.example.betsysanchez.proyectounidad2.R;

public class MainActivity extends AppCompatActivity {
    ImageButton nuevoCliente,empleado;
    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager layoutManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        nuevoCliente = findViewById(R.id.clientes);
        empleado = findViewById(R.id.empleados);
        BDHandler conn=new BDHandler(this);
        recyclerView = findViewById(R.id.recyclerObras);
        String [][] a = conn.consultarClientes("Select * from cliente order by nombre");
        adapter = new ClienteAdapter(a);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
        recyclerView.getAdapter().notifyDataSetChanged();

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
}
