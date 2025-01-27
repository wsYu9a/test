package com.jd.ad.sdk.dl.model;

import l5.c;

/* loaded from: classes2.dex */
public class JADExtra implements IJADExtra {
    private double price = c.f27899e;

    @Override // com.jd.ad.sdk.dl.model.IJADExtra
    public int getPrice() {
        return (int) Math.round(this.price);
    }

    public void setPrice(double d10) {
        this.price = d10;
    }
}
