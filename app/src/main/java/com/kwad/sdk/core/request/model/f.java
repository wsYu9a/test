package com.kwad.sdk.core.request.model;

import com.ksad.json.annotation.KsJson;

@KsJson
/* loaded from: classes2.dex */
public class f extends com.kwad.sdk.core.response.kwai.a implements com.kwad.sdk.core.b {
    public int adStyle;
    public long alK;
    public int count;
    public int taskType;

    public f() {
    }

    public f(int i2, int i3, int i4, long j2) {
        this.adStyle = i2;
        this.taskType = i3;
        this.count = 1;
        this.alK = j2;
    }

    public final void T(long j2) {
        this.alK = j2;
    }
}
