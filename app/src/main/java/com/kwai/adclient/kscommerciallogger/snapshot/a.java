package com.kwai.adclient.kscommerciallogger.snapshot;

import org.json.JSONObject;

/* loaded from: classes2.dex */
public final class a extends c {
    a(String str) {
        super(str, 0);
    }

    @Override // com.kwai.adclient.kscommerciallogger.snapshot.c
    public final synchronized d fh(String str) {
        return new b("empty");
    }

    @Override // com.kwai.adclient.kscommerciallogger.snapshot.c
    final JSONObject fi(String str) {
        return new JSONObject();
    }
}
