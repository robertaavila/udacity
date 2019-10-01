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

public class TrilhasFragment extends Fragment {

    public TrilhasFragment() {

    }

    @Override
    public void onStop() {
        super.onStop();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.item_listview, container, false);

        final ArrayList<Item> items = new ArrayList<Item>();

        items.add(new Item(getString(R.string.trilha_lampiao),
                R.drawable.trilha_morro_lampiao));

        items.add(new Item(getString(R.string.trilha_galheta),
                R.drawable.trilha_galheta));

        items.add(new Item(getString(R.string.trilha_campeche),
                R.drawable.trilha_ilha_campeche));

        items.add(new Item(getString(R.string.trilha_pocao),
                R.drawable.trilha_pocao));

        items.add(new Item(getString(R.string.trilha_rio_vermelho),
                R.drawable.trilha_rio_vermelho));

        items.add(new Item(getString(R.string.trilha_lagoinha),
                R.drawable.trilha_lagoinha_leste));

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
