package com.kwad.sdk.utils.b;

import com.ksad.json.annotation.KsJson;

@KsJson
/* loaded from: classes3.dex */
public class a extends com.kwad.sdk.commercial.c.a {
    public int aWT = -1;
    public int aWU = -1;
    public int aWV = -1;

    @Override // com.kwad.sdk.core.response.a.a
    public String toString() {
        return "KvOperationRecord{putCount=" + this.aWT + ", getFailedCount=" + this.aWU + ", getSuccessCount=" + this.aWV + '}';
    }
}
