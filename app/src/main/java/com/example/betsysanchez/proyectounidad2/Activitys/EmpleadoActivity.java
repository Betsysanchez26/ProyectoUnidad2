package com.example.betsysanchez.proyectounidad2.Activitys;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import com.example.betsysanchez.proyectounidad2.Adapters.EmpleadoAdapter;
import com.example.betsysanchez.proyectounidad2.Entidades.BDHandler;
import com.example.betsysanchez.proyectounidad2.R;

/**
 * Created by BetsySanchez on 07/03/2018.
 */

public class EmpleadoActivity extends AppCompatActivity{
    Button nuevoEmp;
    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager layoutManager;
    BDHandler conn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_empleado);
        nuevoEmp = findViewById(R.id.nuevoEmpleado);
        conn=new BDHandler(this);
        recyclerView = findViewById(R.id.recyclerEmpleados);
        String [][] a = conn.consultarEmpleados("Select * from empleado order by nombre");
        adapter = new EmpleadoAdapter(a,getApplicationContext());
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
        recyclerView.getAdapter().notifyDataSetChanged();


        nuevoEmp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(),NuevoEmpleadoActivity.class);
                startActivity(i);
            }
        });
    }
    public String getActividad(int id){
        return  id+"";
    }
}
