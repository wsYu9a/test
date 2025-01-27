package com.kwad.sdk.core.request.model;

import androidx.annotation.Nullable;
import com.kwad.sdk.core.network.l;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.t;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public final class e implements com.kwad.sdk.core.b {
    private com.kwad.sdk.core.b alE;

    public static e xu() {
        e eVar = new e();
        l lVar = (l) ServiceProvider.get(l.class);
        if (lVar != null) {
            eVar.alE = lVar.ss();
        }
        return eVar;
    }

    @Override // com.kwad.sdk.core.b
    public final void parseJson(@Nullable JSONObject jSONObject) {
    }

    @Override // com.kwad.sdk.core.b
    public final JSONObject toJson() {
        JSONObject jSONObject = new JSONObject();
        t.a(jSONObject, "modeInfo", this.alE);
        return jSONObject;
    }
}
