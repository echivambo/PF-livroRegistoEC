package com.example.echivambo.livroregistoec.adapter;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.echivambo.livroregistoec.MainActivity;
import com.example.echivambo.livroregistoec.R;
import com.example.echivambo.livroregistoec.model.ConsultaPF;
import com.example.echivambo.livroregistoec.model.auxiliar.UtentePF;

import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {
    private ArrayList<ConsultaPF> mDataset;
    private Context context;

    // Provide a reference to the views for each data item
    // Complex data items may need more than one view per item, and
    // you provide access to all the views for a data item in a view holder
    public static class MyViewHolder extends RecyclerView.ViewHolder {
        // each data item is just a string in this case
        public TextView tvNomeUtente;
        public TextView tvNIDCSR;
        public TextView tvNIDTARV;
        public TextView tvCodigo;
        public CardView cvRegistoSessao;
        public MyViewHolder(View itemView) {
            super(itemView);
            tvNomeUtente = (TextView) itemView.findViewById(R.id.tvNomeUtente);
            tvNIDCSR = (TextView) itemView.findViewById(R.id.tvNIDCSR);
            tvNIDTARV = (TextView) itemView.findViewById(R.id.tvNIDTARV);
            tvCodigo = (TextView) itemView.findViewById(R.id.tvCodigo);
            cvRegistoSessao = (CardView) itemView.findViewById(R.id.cvRegistoSessao);
        }
    }

    // Provide a suitable constructor (depends on the kind of dataset)
    public MyAdapter(Context context, ArrayList<ConsultaPF> myDataset) {
        mDataset = myDataset;
        this.context = context;
    }

    // Create new views (invoked by the layout manager)
    @Override
    public MyAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View listItem = LayoutInflater.from(parent.getContext()).inflate(R.layout.utentes_seguimento, parent,false);
        return new MyViewHolder(listItem);
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(@NonNull final MyViewHolder holder, final int position) {
         final String codigoConsulta = mDataset.get(position).getCodigo_consulta();
        // - get element from your dataset at this position
        // - replace the contents of the view with that element
        holder.tvNomeUtente.setText(mDataset.get(position).getNome());
        holder.tvNIDCSR.setText("NID CDR/PF: "+mDataset.get(position).getNid_csr_pf());
        holder.tvNIDTARV.setText("NID TARV: "+mDataset.get(position).getNid_csr_pf());
        holder.tvCodigo.setText("Codigo: "+codigoConsulta);

        holder.cvRegistoSessao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bundle bundle = new Bundle();
                bundle.putString("numero_consulta", mDataset.get(position).getNumero_consulta()+"");

                Intent intent = new Intent(context, MainActivity.class);
                intent.putExtras(bundle);
                context.startActivity(intent);

                Toast.makeText(context, "Clique e encontrei "+codigoConsulta, Toast.LENGTH_LONG).show();
            }
        });
    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return mDataset.size();
    }
}