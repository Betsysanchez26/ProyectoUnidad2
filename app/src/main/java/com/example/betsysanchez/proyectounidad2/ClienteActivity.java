package com.example.betsysanchez.proyectounidad2;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;

/**
 * Created by BetsySanchez on 07/03/2018.
 */

public class ClienteActivity extends AppCompatActivity {
    ImageButton nuevoCli;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cliente);
        nuevoCli = findViewById(R.id.nuevoCliente);

        nuevoCli.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(),NuevoClienteActivity.class);
                startActivity(i);
            }
        });
    }
}
