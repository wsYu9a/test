package com.sigmob.sdk.base.models;

import kotlin.text.Typography;

/* loaded from: classes4.dex */
public class VideoItem {
    public final int height;
    public final String url;
    public final int width;

    public VideoItem(String str, int i10, int i11) {
        this.url = str;
        this.width = i10;
        this.height = i11;
    }

    public String toString() {
        return "\"video\":{\"url\"=\"" + this.url + Typography.quote + ", \"width\"=" + this.width + ", \"height\"=" + this.height + '}';
    }
}
