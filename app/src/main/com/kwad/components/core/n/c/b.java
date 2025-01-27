package com.kwad.components.core.n.c;

import com.ksad.json.annotation.KsJson;

@KsJson
/* loaded from: classes3.dex */
public class b extends com.kwad.sdk.commercial.c.a {
    public String PV;
    public long PW;
    public long PX;
    public long PY;
    public String PZ;

    public final b A(long j10) {
        this.PW = j10;
        return this;
    }

    public final b B(long j10) {
        this.PX = j10;
        return this;
    }

    public final b ao(String str) {
        this.PV = str;
        return this;
    }

    public final b ap(String str) {
        this.errorMsg = str;
        return this;
    }

    public final b aq(String str) {
        this.PZ = str;
        return this;
    }

    public final b ax(int i10) {
        this.PY = i10;
        return this;
    }

    @Override // com.kwad.sdk.commercial.c.a
    /* renamed from: ay */
    public final b setErrorCode(int i10) {
        this.errorCode = i10;
        return this;
    }
}
