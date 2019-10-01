package com.android.floripatourguide.build;

public class Item {
    private String itemTitulo;
    private int itemImageResourceId;
    private String[] itemDestaques;

    public Item(String titulo, int imageResourceId) {
        itemTitulo = titulo;
        itemImageResourceId = imageResourceId;
    }

    public Item(String titulo, int imageResourceId, String[] destaques) {
        itemTitulo = titulo;
        itemImageResourceId = imageResourceId;
        itemDestaques = destaques;
    }

    public String[] getDestaques() {
        return itemDestaques;
    }

    public String getTitulo() {
        return itemTitulo;
    }

    public int getImageResourceId() {
        return itemImageResourceId;
    }

}
