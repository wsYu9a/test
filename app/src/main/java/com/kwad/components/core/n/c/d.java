package com.kwad.components.core.n.c;

import com.ksad.json.annotation.KsJson;

@KsJson
/* loaded from: classes3.dex */
public class d extends com.kwad.sdk.commercial.c.a {
    public String PV;
    public long PW;
    public long PX;
    public String PZ;
    public long Qa;

    public final d C(long j10) {
        this.PW = j10;
        return this;
    }

    public final d D(long j10) {
        this.PX = j10;
        return this;
    }

    public final d E(long j10) {
        this.Qa = j10;
        return this;
    }

    public final d ar(String str) {
        this.PV = str;
        return this;
    }

    public final d as(String str) {
        this.errorMsg = str;
        return this;
    }

    public final d at(String str) {
        this.PZ = str;
        return this;
    }

    @Override // com.kwad.sdk.commercial.c.a
    /* renamed from: az */
    public final d setErrorCode(int i10) {
        this.errorCode = i10;
        return this;
    }
}
