package com.muhammadaa.ptj.models;

/**
 * Created by manggara on 04/05/2018.
 */

public class ItemsModel {

    private int IDItem;
    private String titleItem;
    private String descItem;
    private String hargaItem;
    private String imageItem;

    public ItemsModel(int IDItem, String titleItem, String descItem, String hargaItem, String imageItem) {
        this.IDItem = IDItem;
        this.titleItem = titleItem;
        this.descItem = descItem;
        this.hargaItem = hargaItem;
        this.imageItem = imageItem;
    }

    public int getIDItem() {
        return IDItem;
    }

    public String getTitleItem() {
        return titleItem;
    }

    public String getDescItem() {
        return descItem;
    }

    public String getHargaItem() {
        return hargaItem;
    }

    public String getImageItem() {
        return imageItem;
    }
}
