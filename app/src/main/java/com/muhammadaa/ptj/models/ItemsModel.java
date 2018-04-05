package com.muhammadaa.ptj.models;

/**
 * Created by manggara on 04/05/2018.
 */

public class ItemsModel {

    private String IDevent;
    private String titleEvent;
    private String imgEvent;
    private String tglEvent;
    private String descEvent;

    public ItemsModel(String IDevent, String titleEvent, String imgEvent, String tglEvent, String descEvent) {
        this.IDevent = IDevent;
        this.titleEvent = titleEvent;
        this.imgEvent = imgEvent;
        this.tglEvent = tglEvent;
        this.descEvent = descEvent;
    }

    public String getIDevent() {
        return IDevent;
    }

    public String getTitleEvent() {
        return titleEvent;
    }

    public String getImgEvent() {
        return imgEvent;
    }

    public String getTglEvent() {
        return tglEvent;
    }

    public String getDescEvent() {
        return descEvent;
    }
}
