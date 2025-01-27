package com.kwad.sdk.core.request.model;

import com.ksad.json.annotation.KsJson;

@KsJson
/* loaded from: classes3.dex */
public class f extends com.kwad.sdk.core.response.a.a implements com.kwad.sdk.core.b {
    public long aEb;
    public int adStyle;
    public int count;
    public int taskType;

    public f() {
    }

    public final void aA(long j10) {
        this.aEb = j10;
    }

    public f(int i10, int i11, int i12, long j10) {
        this.adStyle = i10;
        this.taskType = i11;
        this.count = 1;
        this.aEb = j10;
    }
}
