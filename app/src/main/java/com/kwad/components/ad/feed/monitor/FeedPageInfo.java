package com.kwad.components.ad.feed.monitor;

import com.ksad.json.annotation.KsJson;
import java.io.Serializable;

@KsJson
/* loaded from: classes.dex */
public class FeedPageInfo extends com.kwad.sdk.core.response.kwai.a implements Serializable {
    private static final long serialVersionUID = -1423277713849754339L;
    public int adNum;
    public long convertDuration;
    public int errorCode;
    public String errorMsg;
    public int expectedRenderType;
    public String extMsg;
    public long loadDataDuration;
    public int loadStatus;
    public int materialType;
    public String materialUrl;
    public long renderDuration;
    public int renderType;
    public long resourceLoadDuration;
    public int status;
    public int type;

    public FeedPageInfo setAdNum(int i2) {
        this.adNum = i2;
        return this;
    }

    public FeedPageInfo setConvertDuration(long j2) {
        this.convertDuration = j2;
        return this;
    }

    public FeedPageInfo setErrorCode(int i2) {
        this.errorCode = i2;
        return this;
    }

    public FeedPageInfo setErrorMsg(String str) {
        this.errorMsg = str;
        return this;
    }

    public FeedPageInfo setExpectedRenderType(int i2) {
        this.expectedRenderType = i2;
        return this;
    }

    public FeedPageInfo setExtMsg(String str) {
        this.extMsg = str;
        return this;
    }

    public FeedPageInfo setLoadDataDuration(long j2) {
        this.loadDataDuration = j2;
        return this;
    }

    public FeedPageInfo setLoadStatus(int i2) {
        this.loadStatus = i2;
        return this;
    }

    public FeedPageInfo setMaterialType(int i2) {
        this.materialType = i2;
        return this;
    }

    public FeedPageInfo setMaterialUrl(String str) {
        this.materialUrl = str;
        return this;
    }

    public FeedPageInfo setRenderDuration(long j2) {
        this.renderDuration = j2;
        return this;
    }

    public FeedPageInfo setRenderType(int i2) {
        this.renderType = i2;
        return this;
    }

    public FeedPageInfo setResourceLoadDuration(long j2) {
        this.resourceLoadDuration = j2;
        return this;
    }

    public FeedPageInfo setStatus(int i2) {
        this.status = i2;
        return this;
    }

    public FeedPageInfo setType(int i2) {
        this.type = i2;
        return this;
    }
}
