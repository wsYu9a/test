package com.sigmob.sdk.base.models;

import java.io.Serializable;

/* loaded from: classes4.dex */
public class SigVideo implements Serializable {
    int height;
    String thumbUrl;
    String url;
    int width;

    public int getHeight() {
        return this.height;
    }

    public String getThumbUrl() {
        return this.thumbUrl;
    }

    public String getVideoUrl() {
        return this.url;
    }

    public int getWidth() {
        return this.width;
    }
}
