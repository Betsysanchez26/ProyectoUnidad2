package com.example.betsysanchez.proyectounidad2.Adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.betsysanchez.proyectounidad2.R;

/**
 * Created by BetsySanchez on 13/03/2018.
 */

public class AsignadosAdapter extends RecyclerView.Adapter<AsignadosAdapter.RecyclerViewHolder>{
    String data[][];

    public AsignadosAdapter(String[][] data) {
        this.data = data;
    }

    @Override
    public AsignadosAdapter.RecyclerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.empleado_asignado,parent,false);
        return new AsignadosAdapter.RecyclerViewHolder(view);
    }

    @Override
    public void onBindViewHolder(AsignadosAdapter.RecyclerViewHolder holder, int position) {
        holder.nombre.setText("Nombre: "+data[position][0]);
        holder.celular.setText("Celular: "+data[position][1]);
    }

    @Override
    public int getItemCount() {
        return data.length;
    }

    public class RecyclerViewHolder extends RecyclerView.ViewHolder{
        TextView nombre, celular;
        public RecyclerViewHolder(View itemView) {
            super(itemView);
            nombre=itemView.findViewById(R.id.nombreAsig);
            celular=itemView.findViewById(R.id.celularAsig);

        }
    }
}
