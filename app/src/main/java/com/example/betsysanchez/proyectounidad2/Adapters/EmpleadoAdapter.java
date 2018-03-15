package com.example.betsysanchez.proyectounidad2.Adapters;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.betsysanchez.proyectounidad2.Activitys.EmpleadoActivity;
import com.example.betsysanchez.proyectounidad2.Activitys.NuevoClienteActivity;
import com.example.betsysanchez.proyectounidad2.Activitys.NuevoEmpleadoActivity;
import com.example.betsysanchez.proyectounidad2.Entidades.BDHandler;
import com.example.betsysanchez.proyectounidad2.R;

/**
 * Created by BetsySanchez on 09/03/2018.
 */

public class EmpleadoAdapter extends RecyclerView.Adapter<EmpleadoAdapter.RecyclerViewHolder> {
    String data[][];
    Context context;

    public EmpleadoAdapter(String[][] data,Context context) {
        this.data = data;
        this.context=context;
    }

    @Override
    public RecyclerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_empleado,parent,false);
        return new RecyclerViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerViewHolder holder, int position) {
        final String id = data[position][0];
        EmpleadoActivity ne= new EmpleadoActivity();
        holder.nombre.setText("Nombre: "+data[position][1]);
        holder.actividad.setText("Actividad: "+ne.getActividad(Integer.parseInt(data[position][2])));
        holder.fecha_inicio.setText("Fecha de Inicio: "+data[position][3]);
        holder.fecha_fin.setText("Fecha de fin:"+data[position][4]);
        holder.celular.setText("Celular: "+data[position][5]);
       // holder.cant_obra.setText(data[position][6]);
      //  holder.pago_estimado.setText(data[position][7]);
        holder.edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                NuevoEmpleadoActivity nE = new NuevoEmpleadoActivity();
                nE.identificador=id;
                //System.out.println("Adapter "+id);
                Intent i = new Intent(context,NuevoEmpleadoActivity.class);
                context.startActivity(i);
            }
        });
        holder.delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }

    @Override
    public int getItemCount() {
        return data.length;
    }

    public class RecyclerViewHolder extends RecyclerView.ViewHolder {
        TextView nombre, actividad, fecha_inicio, fecha_fin, celular, cant_obra, pago_estimado;
        ImageButton edit,delete;
        public RecyclerViewHolder(View itemView) {
            super(itemView);
           nombre=itemView.findViewById(R.id.verNombreEmpl);
           actividad=itemView.findViewById(R.id.verActEmpl);
            fecha_inicio=itemView.findViewById(R.id.verFecIniEmpl);
            fecha_fin=itemView.findViewById(R.id.verFecFinEmpl);
            celular=itemView.findViewById(R.id.verCelularEmpl);
            edit=itemView.findViewById(R.id.editarEmpleado);
            delete=itemView.findViewById(R.id.eliminarEmpleado);
            //cant_obra=itemView.findViewById(R.id.cantObra);
           // pago_estimado=itemView.findViewById(R.id.pagoEst);
        }
    }
}
