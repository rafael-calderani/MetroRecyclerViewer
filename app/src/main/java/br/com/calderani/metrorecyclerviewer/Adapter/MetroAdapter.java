package br.com.calderani.metrorecyclerviewer.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

import br.com.calderani.metrorecyclerviewer.model.Metro;
import br.com.calderani.metrorecyclerviewer.R;

/**
 * Created by logonrm on 26/06/2017.
 */

public class MetroAdapter extends RecyclerView.Adapter<MetroAdapter.MetroViewHolder>
    implements OnItemClickListener {
    private List<Metro> metroList;
    private OnItemClickListener listener;
    public MetroAdapter(List<Metro> l, OnItemClickListener listener)
    {
        metroList = l;
        this.listener = listener;
    }

    @Override
    public MetroViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View metroView = inflater.inflate(R.layout.metro_row, parent, false);

        return new MetroViewHolder(metroView);
    }

    @Override
    public void onBindViewHolder(MetroViewHolder holder, final int position) {
        Metro m = metroList.get(position);
        holder.tvCor.setText(m.getCor());
        holder.tvNumero.setText(m.getNumero());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onItemClick(metroList.get(position));
            }
        });
        Picasso.with(holder.itemView.getContext())
                .load(m.getUrlImagem())
                .placeholder(R.mipmap.ic_launcher)    // IMG de Loading
                .error(R.mipmap.ic_launcher)          // IMG de Erro
                .into(holder.ivImagem);
    }

    @Override
    public int getItemCount() {
        return metroList.size();
    }

    @Override
    public void onItemClick(Metro item) {

    }

    public class MetroViewHolder extends RecyclerView.ViewHolder {
        public ImageView ivImagem;
        public TextView tvCor;
        public TextView tvNumero;

        public MetroViewHolder(View itemView) {
            super(itemView);
            ivImagem = (ImageView) itemView.findViewById(R.id.ivImagem);
            tvCor = (TextView) itemView.findViewById(R.id.tvCor);
            tvNumero = (TextView) itemView.findViewById(R.id.tvNumero);
        }
    }

    public void update(List<Metro> l){
        metroList = l;
        notifyDataSetChanged();
    }
}
