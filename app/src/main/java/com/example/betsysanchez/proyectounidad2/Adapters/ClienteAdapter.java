package com.example.betsysanchez.proyectounidad2.Adapters;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.betsysanchez.proyectounidad2.Activitys.EmpleadoAsigActivity;
import com.example.betsysanchez.proyectounidad2.Activitys.NuevoClienteActivity;
import com.example.betsysanchez.proyectounidad2.Activitys.NuevoEmpleadoActivity;
import com.example.betsysanchez.proyectounidad2.R;

/**
 * Created by BetsySanchez on 13/03/2018.
 */

public class ClienteAdapter extends RecyclerView.Adapter<ClienteAdapter.RecyclerViewHolder> {
    String data[][];
    Context context;

    public ClienteAdapter(String[][] data,Context context) {
        this.data = data;
        this.context=context;
    }

    @Override
    public ClienteAdapter.RecyclerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_obras_cliente,parent,false);
        return new ClienteAdapter.RecyclerViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ClienteAdapter.RecyclerViewHolder holder, int position) {
        final String id = data[position][0];
        holder.nombre.setText("Nombre: "+data[position][1]);
        holder.celular.setText("Celular: "+data[position][3]);
        holder.actividad.setText("Actividad "+(Integer.parseInt(data[position][0])-1)+": "+data[position][5]);
        holder.monto.setText("Monto:"+data[position][6]);
       // Toast.makeText(context,"Fin: "+data[position][7],Toast.LENGTH_SHORT).show();
        if(data[position][7].equals("true")){
            holder.finalizada.setBackgroundResource(R.drawable.ic_check_box_white_24dp);
            holder.etiqueta.setText("Finalizada");
        }else {
            holder.finalizada.setBackgroundResource(R.drawable.ic_check_box_outline_blank);
            holder.etiqueta.setText("En Proceso");
        }
        holder.edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NuevoClienteActivity nC = new NuevoClienteActivity();
                nC.identificadorC=id;
                //System.out.println("Adapter "+id);
                Intent i = new Intent(context,NuevoClienteActivity.class);
                context.startActivity(i);
            }
        });
        holder.verEmpleados.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EmpleadoAsigActivity eA = new EmpleadoAsigActivity();
                eA.identificadorO=id;
                //System.out.println("Adapter "+id);
                Intent i = new Intent(context,EmpleadoAsigActivity.class);
                context.startActivity(i);
            }
        });
    }

    @Override
    public int getItemCount() {
        return data.length;
    }

    public class RecyclerViewHolder extends RecyclerView.ViewHolder {
        TextView nombre, actividad, celular, monto,etiqueta;
        ImageView finalizada;
        ImageButton edit;
        Button verEmpleados;
        public RecyclerViewHolder(View itemView) {
            super(itemView);
            nombre=itemView.findViewById(R.id.verNombreCli);
            actividad=itemView.findViewById(R.id.verActividadCli);
            celular=itemView.findViewById(R.id.verCelCli);
            monto=itemView.findViewById(R.id.verMontoCli);
            finalizada=itemView.findViewById(R.id.verFinalizadaCli);
            etiqueta=itemView.findViewById(R.id.etiquetaFinalizado);
            edit=itemView.findViewById(R.id.editarCliente);
            verEmpleados=itemView.findViewById(R.id.verEmpCliente);

        }
    }
}
