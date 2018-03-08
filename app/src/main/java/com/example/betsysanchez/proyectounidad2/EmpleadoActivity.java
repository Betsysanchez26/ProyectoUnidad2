package com.example.betsysanchez.proyectounidad2;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;

/**
 * Created by BetsySanchez on 07/03/2018.
 */

public class EmpleadoActivity extends AppCompatActivity{
    ImageButton nuevoEmp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_empleado);
        nuevoEmp = findViewById(R.id.nuevoEmpleado);

        nuevoEmp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(),NuevoEmpleadoActivity.class);
                startActivity(i);
            }
        });
    }
}
