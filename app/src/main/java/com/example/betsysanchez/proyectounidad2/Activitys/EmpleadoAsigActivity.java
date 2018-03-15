package com.example.betsysanchez.proyectounidad2.Activitys;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.betsysanchez.proyectounidad2.Adapters.AsignadosAdapter;
import com.example.betsysanchez.proyectounidad2.Entidades.BDHandler;
import com.example.betsysanchez.proyectounidad2.R;

/**
 * Created by BetsySanchez on 14/03/2018.
 */

public class EmpleadoAsigActivity extends AppCompatActivity {
    public static String identificadorO="0";
    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager layoutManager;
    BDHandler conn;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ver_empleados);

        conn=new BDHandler(this);
        recyclerView = findViewById(R.id.recyclerVerEmp);
        String [][] a = conn.consultarRelacion("Select e.nombre,e.celular from empleado e inner join actividad_empleado aE where aE.id_cliente=e.actividad and aE.id_cliente="+Integer.parseInt(identificadorO)+" group by nombre,celular");
        adapter = new AsignadosAdapter(a);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
        recyclerView.getAdapter().notifyDataSetChanged();
    }
}
