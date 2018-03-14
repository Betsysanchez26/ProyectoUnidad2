package com.example.betsysanchez.proyectounidad2.Adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;

import com.example.betsysanchez.proyectounidad2.R;

/**
 * Created by BetsySanchez on 13/03/2018.
 */

public class ClienteAdapter extends RecyclerView.Adapter<ClienteAdapter.RecyclerViewHolder> {
    String data[][];

    public ClienteAdapter(String[][] data) {
        this.data = data;
    }

    @Override
    public ClienteAdapter.RecyclerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_obras_cliente,parent,false);
        return new ClienteAdapter.RecyclerViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ClienteAdapter.RecyclerViewHolder holder, int position) {
        holder.nombre.setText("Nombre: "+data[position][1]);
        holder.actividad.setText("Celular: "+data[position][3]);
        holder.actividad.setText("Actividad: "+data[position][5]);
        holder.monto.setText("Monto:"+data[position][6]);
//        holder.finalizada.setChecked(true);
        // holder.cant_obra.setText(data[position][6]);
        //  holder.pago_estimado.setText(data[position][7]);
    }

    @Override
    public int getItemCount() {
        return data.length;
    }

    public class RecyclerViewHolder extends RecyclerView.ViewHolder {
        TextView nombre, actividad, celular, monto;
        CheckBox finalizada;
        public RecyclerViewHolder(View itemView) {
            super(itemView);
            nombre=itemView.findViewById(R.id.verNombreCli);
            actividad=itemView.findViewById(R.id.verActividadCli);
            celular=itemView.findViewById(R.id.verCelCli);
            monto=itemView.findViewById(R.id.verMontoCli);
         //   finalizada=itemView.findViewById(R.id.finalizadaCli);

        }
    }
}
