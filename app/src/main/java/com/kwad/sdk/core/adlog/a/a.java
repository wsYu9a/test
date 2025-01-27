package com.kwad.sdk.core.adlog.a;

import androidx.annotation.NonNull;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public final class a {
    public JSONObject asR;
    public com.kwad.sdk.core.adlog.c.a asS;
    public long asT;
    public int asU;
    public String asV;
    public int retryCount;
    public String url;

    public static a CF() {
        return new a();
    }

    public final a am(long j10) {
        this.asT = j10;
        return this;
    }

    public final a c(com.kwad.sdk.core.adlog.c.a aVar) {
        this.asS = aVar;
        return this;
    }

    public final a cs(int i10) {
        this.asU = i10;
        return this;
    }

    public final a di(String str) {
        this.url = str;
        return this;
    }

    public final a dj(String str) {
        this.asV = str;
        return this;
    }

    public final a i(JSONObject jSONObject) {
        this.asR = jSONObject;
        return this;
    }

    @NonNull
    public final String toString() {
        return "AdLogCache {actionType=" + this.asS.asm + ", retryCount=" + this.retryCount + ", retryErrorCode=" + this.asU + ", retryErrorMsg=" + this.asV + '}';
    }
}
