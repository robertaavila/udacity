package com.android.floripatourguide.build;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class ItemAdapter extends ArrayAdapter<Item> {

    static class ViewHolder {
        TextView titulo;
        ImageView image;
    }

    public ItemAdapter(Context context, ArrayList<Item> items) {
        super(context, 0, items);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        View listItemView = convertView;

        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.list_item, parent, false);
        }

        Item currentItem = getItem(position);

        ViewHolder holder = new ViewHolder();

        holder.titulo = listItemView.findViewById(R.id.titulo);
        holder.titulo.setText(currentItem.getTitulo());

        holder.image = listItemView.findViewById(R.id.image);
        holder.image.setImageResource(currentItem.getImageResourceId());

        return listItemView;
    }

}
