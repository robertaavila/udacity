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

public class ComidaFragment extends Fragment {
    public ComidaFragment() {
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

        items.add(new Item(getString(R.string.comida_deli),
                R.drawable.comida_deli));

        items.add(new Item(getString(R.string.comida_forneria),
                R.drawable.comida_forneria));

        items.add(new Item(getString(R.string.comida_posto),
                R.drawable.comida_posto));

        items.add(new Item(getString(R.string.comida_sushinami),
                R.drawable.comida_sushinami));

        items.add(new Item(getString(R.string.comida_uncle),
                R.drawable.comida_uncle));

        items.add(new Item(getString(R.string.comida_sambaqui),
                R.drawable.comida_sambaqui));

        final ItemAdapter adapter = new ItemAdapter(getActivity(), items);

        ListView listView = rootView.findViewById(R.id.list);

        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Item currentItem = items.get(i);
                Intent itemDetailIntent = new Intent(getContext(), ItemDetail.class);
                itemDetailIntent.putExtra(getString(R.string.intent_extra_item_titulo), currentItem.getTitulo());

                startActivity(itemDetailIntent);
            }
        });

        return rootView;
    }
}