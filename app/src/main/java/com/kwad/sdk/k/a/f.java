package com.kwad.sdk.k.a;

import androidx.annotation.Nullable;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.service.a.h;
import com.kwad.sdk.utils.be;
import com.kwad.sdk.utils.x;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public final class f extends com.kwad.sdk.core.response.a.a implements com.kwad.sdk.core.b {
    public int aRw = -1;
    public int aRx = -1;

    public static synchronized f Ml() {
        synchronized (f.class) {
            if (!((h) ServiceProvider.get(h.class)).zM()) {
                return null;
            }
            return be.Ml();
        }
    }

    private void a(f fVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        fVar.aRw = jSONObject.optInt("phoneCount", -1);
        fVar.aRx = jSONObject.optInt("activePhoneCount", -1);
        super.afterToJson(jSONObject);
    }

    private static JSONObject b(f fVar, JSONObject jSONObject) {
        x.putValue(jSONObject, "phoneCount", fVar.aRw);
        x.putValue(jSONObject, "activePhoneCount", fVar.aRx);
        return jSONObject;
    }

    @Override // com.kwad.sdk.core.response.a.a, com.kwad.sdk.core.b
    public final void parseJson(@Nullable JSONObject jSONObject) {
        a(this, jSONObject);
        afterParseJson(jSONObject);
    }

    @Override // com.kwad.sdk.core.response.a.a, com.kwad.sdk.core.b
    public final JSONObject toJson() {
        JSONObject b10 = b(this, new JSONObject());
        afterToJson(b10);
        return b10;
    }
}
