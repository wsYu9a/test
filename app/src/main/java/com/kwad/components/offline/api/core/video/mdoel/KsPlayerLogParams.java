package com.kwad.components.offline.api.core.video.mdoel;

/* loaded from: classes2.dex */
public class KsPlayerLogParams {
    public long adStyle;
    public long clickTime = -1;
    public int contentType;
    public long photoId;

    public KsPlayerLogParams setAdStyle(long j2) {
        this.adStyle = j2;
        return this;
    }

    public KsPlayerLogParams setClickTime(long j2) {
        this.clickTime = j2;
        return this;
    }

    public KsPlayerLogParams setContentType(int i2) {
        this.contentType = i2;
        return this;
    }

    public KsPlayerLogParams setPhotoId(long j2) {
        this.photoId = j2;
        return this;
    }
}
