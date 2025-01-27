package com.sigmob.sdk.base.models;

/* loaded from: classes4.dex */
public class SigImage {
    private int height;
    private String imageUrl;
    private int width;

    public SigImage(String str, int i10, int i11) {
        this.imageUrl = str;
        this.width = i10;
        this.height = i11;
    }

    public int getHeight() {
        return this.height;
    }

    public String getImageUrl() {
        return this.imageUrl;
    }

    public int getWidth() {
        return this.width;
    }
}
