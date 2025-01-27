package com.kwad.sdk.core.response.model;

import com.ksad.json.annotation.KsJson;
import java.io.Serializable;

@KsJson
/* loaded from: classes2.dex */
public class AdStatusInfo extends com.kwad.sdk.core.response.kwai.a implements Serializable {
    private static final long serialVersionUID = 3728247893272878881L;
    public long downloadFinishTime;
    public long downloadSize;
    public int downloadType;
    public long loadDataTime;
    public boolean loadFromCache;

    public long getDownloadFinishTime() {
        return this.downloadFinishTime;
    }

    public long getDownloadSize() {
        return this.downloadSize;
    }

    public int getDownloadType() {
        return this.downloadType;
    }

    public long getLoadDataTime() {
        return this.loadDataTime;
    }

    public boolean isLoadFromCache() {
        return this.loadFromCache;
    }

    public void setDownloadFinishTime(long j2) {
        this.downloadFinishTime = j2;
    }

    public void setDownloadSize(long j2) {
        this.downloadSize = j2;
    }

    public void setDownloadType(int i2) {
        this.downloadType = i2;
    }

    public void setLoadDataTime(long j2) {
        this.loadDataTime = j2;
    }

    public void setLoadFromCache(boolean z) {
        this.loadFromCache = z;
    }
}
