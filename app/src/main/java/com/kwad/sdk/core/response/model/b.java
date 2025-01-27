package com.kwad.sdk.core.response.model;

/* loaded from: classes2.dex */
public final class b {
    private boolean Rp = true;
    private boolean alU;
    private int mHeight;
    private String mUrl;
    private int mWidth;

    public b(String str, int i2, int i3, boolean z, boolean z2) {
        this.mUrl = str;
        this.mWidth = i2;
        this.mHeight = i3;
        this.alU = z2;
    }

    public final int getHeight() {
        return this.mHeight;
    }

    public final String getUrl() {
        return this.mUrl;
    }

    public final int getWidth() {
        return this.mWidth;
    }
}
