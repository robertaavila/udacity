package com.android.floripatourguide.build;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class PraiasFragment extends Fragment {
    public PraiasFragment() {

    }

    @Override
    public void onStart() {
        super.onStart();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.item_listview, container, false);

        final ArrayList<Item> items = new ArrayList<Item>();

        items.add(new Item(getString(R.string.praias_daniela),
                R.drawable.praia_daniela));

        items.add(new Item(getString(R.string.praias_barra),
                R.drawable.praias_barra));

        items.add(new Item(getString(R.string.praias_brava),
                R.drawable.praia_brava));

        items.add(new Item(getString(R.string.praias_ingleses),
                R.drawable.praia_ingleses));

        items.add(new Item(getString(R.string.praias_joaquina),
                R.drawable.praia_joaquina));

        items.add(new Item(getString(R.string.praias_mocambique),
                R.drawable.praia_mocambique));

        final ItemAdapter adapter = new ItemAdapter(getActivity(), items);

        ListView listView = rootView.findViewById(R.id.list);

        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Item currentItem = items.get(i);

                Intent itemDetailIntent = new Intent(getContext(), ItemDetail.class);

                itemDetailIntent.putExtra(getString(R.string.intent_extra_item_titulo),
                        currentItem.getTitulo());

                startActivity(itemDetailIntent);
            }
        });

        return rootView;
    }

}