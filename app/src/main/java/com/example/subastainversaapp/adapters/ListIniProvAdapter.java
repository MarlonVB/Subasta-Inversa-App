package com.example.subastainversaapp.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.example.subastainversaapp.R;
import com.example.subastainversaapp.entity.Subasta;

import java.util.List;

public class ListIniProvAdapter extends RecyclerView.Adapter<ListIniProvAdapter.ViewHolder> {

    private List<Subasta> auctionList;
    private final LayoutInflater layoutInflater;
    private final Context context;



    public ListIniProvAdapter(List<Subasta> auctionList, Context context){
        this.layoutInflater = LayoutInflater.from(context);
        this.auctionList = auctionList;
        this.context = context;
    }

    @Override
    public int getItemCount() {
        return auctionList.size();
    }

    @Override
    public ListIniProvAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
        View view = layoutInflater.inflate(R.layout.inicio_prov_item,null);
        return new ListIniProvAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ListIniProvAdapter.ViewHolder holder , final int position) {
        holder.bindData(auctionList.get(position));
        /*holder.lista.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //implement onClick

                Toast.makeText(context, holder.servicio.getText(), Toast.LENGTH_LONG).show();
            }
        });*/
    }

    public void setItems(List<Subasta> items){
        auctionList=items;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView numero, servicio, fcini, fcfin;
        ListView lista;
        Button ofert;

        ViewHolder(View itemView) {
            super(itemView);
            numero = itemView.findViewById(R.id.txtnroiniprov);
            servicio = itemView.findViewById(R.id.txtserviniprov);
            fcini = itemView.findViewById(R.id.txtfeciniprov);
            fcfin = itemView.findViewById(R.id.txtprecioOR);
            lista=itemView.findViewById(R.id.listaIniProv);
        }

        void bindData(final Subasta item) {
            //System.out.println(item.getIdSubasta().toString()+"WWWWWWWWWWWWWWWWWWWWWWW");

            //if(item.getServicio().getIdServicio()==)
            Long nro=item.getIdSubasta();
            //SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
            //String f_ini=formato.format(item.getFechaInicio());
            //String f_fin=formato.format(item.getFechaFin());
            numero.setText(nro+"");
            servicio.setText(item.getServicio().getNombreServicio());
            //fcini.setText(f_ini);
            //fcfin.setText(f_fin);
        }

    }
}
