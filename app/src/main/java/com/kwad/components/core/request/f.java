package com.kwad.components.core.request;

import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.ad;
import com.kwad.sdk.utils.x;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public final class f extends com.kwad.sdk.core.network.d {
    public f() {
        try {
            JSONArray jSONArray = new JSONArray();
            x.a(jSONArray, new JSONObject());
            putBody("impInfo", jSONArray);
            putBody("appTag", ad.Nz());
        } catch (Throwable th2) {
            ServiceProvider.reportSdkCaughtException(th2);
        }
    }

    @Override // com.kwad.sdk.core.network.b, com.kwad.sdk.core.network.f
    public final String getUrl() {
        return com.kwad.sdk.h.zk();
    }
}
