package com.example.harj10;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import java.util.ArrayList;
import java.util.List;

public class ListaAdapter extends ArrayAdapter<String> {
    private ArrayList<String> lista;
    private LayoutInflater layoutInflater;
    private Integer[] kuvalista;
    private Context context;


    public ListaAdapter(@NonNull Context context, @NonNull List<String> objects,Integer [] kuvalista) {
        super(context,R.layout.listalayout, objects);
        this.context = context;
        lista = (ArrayList<String>) objects;
        this.kuvalista =  kuvalista;
    }
    public void add(@NonNull String object){
        lista.add(object);
        super.add(object);
        notifyDataSetChanged();

    }
    public View getView(int position, View convertView, ViewGroup parent){


        View view = convertView;
        ViewHolder viewHolder=null;

        if(view == null){
            layoutInflater = LayoutInflater.from(context);


            view = layoutInflater.inflate(R.layout.listalayout,null,true);
            viewHolder = new ViewHolder(view);
            view.setTag(viewHolder);

        }else{
            viewHolder = (ViewHolder) view.getTag();

        }
        viewHolder.tv.setText(lista.get(position));
        viewHolder.iv.setImageResource(kuvalista[position]);

        return view;

    }
    class ViewHolder{

        TextView tv;
        ImageView iv;
        ViewHolder(View v){

            tv= v.findViewById(R.id.listaTextview);
            iv = v.findViewById(R.id.listaImageView);
        }
    }
}
