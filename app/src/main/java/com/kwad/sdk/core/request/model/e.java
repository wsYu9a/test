package com.kwad.sdk.core.request.model;

import androidx.annotation.Nullable;
import com.kwad.sdk.core.network.k;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.x;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public final class e implements com.kwad.sdk.core.b {
    private com.kwad.sdk.core.b aDV;

    public static e GL() {
        e eVar = new e();
        try {
            eVar.aDV = ((k) ServiceProvider.get(k.class)).zw();
        } catch (Throwable th2) {
            ServiceProvider.reportSdkCaughtException(th2);
        }
        return eVar;
    }

    @Override // com.kwad.sdk.core.b
    public final void parseJson(@Nullable JSONObject jSONObject) {
    }

    @Override // com.kwad.sdk.core.b
    public final JSONObject toJson() {
        JSONObject jSONObject = new JSONObject();
        x.a(jSONObject, "modeInfo", this.aDV);
        return jSONObject;
    }
}
