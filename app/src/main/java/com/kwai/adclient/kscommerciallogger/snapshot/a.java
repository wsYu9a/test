package com.kwai.adclient.kscommerciallogger.snapshot;

import org.json.JSONObject;

/* loaded from: classes3.dex */
public final class a extends c {
    public a(String str) {
        super(str, 0);
    }

    @Override // com.kwai.adclient.kscommerciallogger.snapshot.c
    public final synchronized d hA(String str) {
        return new b("empty");
    }

    @Override // com.kwai.adclient.kscommerciallogger.snapshot.c
    public final JSONObject hB(String str) {
        return new JSONObject();
    }
}
