package com.vivo.mobilead.model;

/* loaded from: classes4.dex */
public class VLocation {
    private double lat;
    private double lng;

    public VLocation(double d2, double d3) {
        this.lng = 0.0d;
        this.lat = 0.0d;
        this.lng = d2;
        this.lat = d3;
    }

    public double getLat() {
        return this.lat;
    }

    public double getLng() {
        return this.lng;
    }

    public void setLat(double d2) {
        this.lat = d2;
    }

    public void setLng(double d2) {
        this.lng = d2;
    }
}
