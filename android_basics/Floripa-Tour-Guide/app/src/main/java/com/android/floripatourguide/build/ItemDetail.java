package com.android.floripatourguide.build;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class ItemDetail extends AppCompatActivity {
    final ArrayList<Item> mItems = new ArrayList<Item>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_detail);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);

        String itemTitulo = getIntent().getStringExtra(getString(R.string.intent_extra_item_titulo));

        setTitle(itemTitulo);

        initItems(mItems);

        int currentItemIndex = getItemIndexByTitulo(itemTitulo);

        inflateLayout(currentItemIndex);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            onBackPressed();
            return true;
        }
        return false;
    }

    private void inflateLayout(int index) {
        ImageView itemImage = findViewById(R.id.item_image);
        itemImage.setImageResource(mItems.get(index).getImageResourceId());

        TextView itemTitulo = findViewById(R.id.item_titulo);
        itemTitulo.setText(mItems.get(index).getTitulo());

        TextView itemDestaques = findViewById(R.id.item_destaques);
        String[] destaques = mItems.get(index).getDestaques();

        String destaques_text = "";

        for (int i = 0; i < destaques.length; i++) {
            destaques_text += "* " + destaques[i] + "\n\n";
        }
        itemDestaques.setText(destaques_text);
    }


    private int getItemIndexByTitulo(String titulo) {
        try {
            for (int i = 0; i < mItems.size(); i++) {
                Item currentItem = mItems.get(i);
                String currentTitulo = currentItem.getTitulo();
                if (titulo.equals(currentTitulo)) {
                    return i;
                }
            }
        } catch (Error error) {
        }
        return -1;
    }

    private void initItems(ArrayList<Item> items) {

        items.add(new Item(getString(R.string.passeios_anhatomirim_titulo),
                R.drawable.passeio_anhatomirim,
                getResources().getStringArray(R.array.passeios_anhatomirim_destaques)
        ));

        items.add(new Item(getString(R.string.passeios_beira_mar_titulo),
                R.drawable.passeio_beira_mar,
                getResources().getStringArray(R.array.passeios_beira_mar_destaques)
        ));

        items.add(new Item(getString(R.string.passeios_catedral_titulo),
                R.drawable.passeio_catedral,
                getResources().getStringArray(R.array.passeios_catedral_destaques)
        ));

        items.add(new Item(getString(R.string.passeios_costa_lagoa_titulo),
                R.drawable.passeio_costa_lagoa,
                getResources().getStringArray(R.array.passeios_costa_lagoa_destaques)
        ));

        items.add(new Item(getString(R.string.passeios_fortaleza_titulo),
                R.drawable.passeio_fortaleza_sao_jose,
                getResources().getStringArray(R.array.passeios_fortaleza_destaques)
        ));

        items.add(new Item(getString(R.string.passeios_ilha_campeche_titulo),
                R.drawable.passeio_ilha_campeche,
                getResources().getStringArray(R.array.passeios_ilha_campeche_destaques)
        ));

        items.add(new Item(getString(R.string.comida_posto),
                R.drawable.comida_posto,
                getResources().getStringArray(R.array.detalhes_posto)
        ));

        items.add(new Item(getString(R.string.comida_sushinami),
                R.drawable.comida_sushinami,
                getResources().getStringArray(R.array.detalhes_sushinami)
        ));

        items.add(new Item(getString(R.string.comida_sambaqui),
                R.drawable.comida_sambaqui,
                getResources().getStringArray(R.array.detalhes_sambaqui)
        ));

        items.add(new Item(getString(R.string.comida_uncle),
                R.drawable.comida_uncle,
                getResources().getStringArray(R.array.detalhes_uncle)
        ));

        items.add(new Item(getString(R.string.comida_forneria),
                R.drawable.comida_forneria,
                getResources().getStringArray(R.array.detalhes_forneria)
        ));

        items.add(new Item(getString(R.string.comida_deli),
                R.drawable.comida_deli,
                getResources().getStringArray(R.array.detalhes_deli)
        ));

        items.add(new Item(getString(R.string.praias_barra),
                R.drawable.praias_barra,
                getResources().getStringArray(R.array.praias_barra_descricao)
        ));

        items.add(new Item(getString(R.string.praias_brava),
                R.drawable.praia_brava,
                getResources().getStringArray(R.array.praias_brava_descricao)
        ));

        items.add(new Item(getString(R.string.praias_ingleses),
                R.drawable.praia_ingleses,
                getResources().getStringArray(R.array.praias_ingleses_descricao)
        ));

        items.add(new Item(getString(R.string.praias_joaquina),
                R.drawable.praia_joaquina,
                getResources().getStringArray(R.array.praias_joaquina_detalhes)
        ));

        items.add(new Item(getString(R.string.praias_mocambique),
                R.drawable.praia_mocambique,
                getResources().getStringArray(R.array.praias_mocambique_descricao)
        ));

        items.add(new Item(getString(R.string.praias_daniela),
                R.drawable.praia_daniela,
                getResources().getStringArray(R.array.praia_daniela_descricao)
        ));

        items.add(new Item(getString(R.string.trilha_galheta),
                R.drawable.trilha_galheta,
                getResources().getStringArray(R.array.trilha_galheta_detalhes)
        ));

        items.add(new Item(getString(R.string.trilha_campeche),
                R.drawable.trilha_ilha_campeche,
                getResources().getStringArray(R.array.trilha_campeche_detalhes)
        ));

        items.add(new Item(getString(R.string.trilha_lagoinha),
                R.drawable.trilha_lagoinha_leste,
                getResources().getStringArray(R.array.trilha_lagoinha_detalhes)
        ));

        items.add(new Item(getString(R.string.trilha_lampiao),
                R.drawable.trilha_morro_lampiao,
                getResources().getStringArray(R.array.trilha_lampiao_detalhes)
        ));

        items.add(new Item(getString(R.string.trilha_pocao),
                R.drawable.trilha_pocao,
                getResources().getStringArray(R.array.trilha_pocao_detalhes)
        ));

        items.add(new Item(getString(R.string.trilha_rio_vermelho),
                R.drawable.trilha_rio_vermelho,
                getResources().getStringArray(R.array.trilha_rio_vermelho_detalhes)
        ));
    }
}

