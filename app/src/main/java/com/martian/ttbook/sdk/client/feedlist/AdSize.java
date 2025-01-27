package com.martian.ttbook.sdk.client.feedlist;

/* loaded from: classes4.dex */
public final class AdSize {
    public static final AdSize AUTO = new AdSize(-1, -2);
    public static final int AUTO_HEIGHT = -2;
    public static final int FULL_WIDTH = -1;
    private int adHeight;
    private int adWidth;

    public AdSize(int i2, int i3) {
        this.adWidth = i2;
        this.adHeight = i3;
    }

    public int getAdHeight() {
        return this.adHeight;
    }

    public int getAdWidth() {
        return this.adWidth;
    }

    public String toString() {
        return "AdSize{adWidth=" + this.adWidth + ", adHeight=" + this.adHeight + '}';
    }
}
