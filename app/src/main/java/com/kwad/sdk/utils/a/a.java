package com.kwad.sdk.utils.a;

import com.ksad.json.annotation.KsJson;

@KsJson
/* loaded from: classes2.dex */
public class a extends com.kwad.sdk.core.response.kwai.a {
    public int aCK = -1;
    public int aCL = -1;
    public int aCM = -1;

    @Override // com.kwad.sdk.core.response.kwai.a
    public String toString() {
        return "KvOperationRecord{putCount=" + this.aCK + ", getFailedCount=" + this.aCL + ", getSuccessCount=" + this.aCM + '}';
    }
}
