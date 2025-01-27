package com.kwad.sdk.h.kwai;

import androidx.annotation.Nullable;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.ax;
import com.kwad.sdk.utils.t;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public final class f extends com.kwad.sdk.core.response.kwai.a implements com.kwad.sdk.core.b {
    public int axJ = -1;
    public int axK = -1;

    public static synchronized f Cj() {
        synchronized (f.class) {
            if (!((com.kwad.sdk.service.kwai.f) ServiceProvider.get(com.kwad.sdk.service.kwai.f.class)).sx()) {
                return null;
            }
            return ax.Cj();
        }
    }

    private void a(f fVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        fVar.axJ = jSONObject.optInt("phoneCount", -1);
        fVar.axK = jSONObject.optInt("activePhoneCount", -1);
        super.afterToJson(jSONObject);
    }

    private static JSONObject b(f fVar, JSONObject jSONObject) {
        t.putValue(jSONObject, "phoneCount", fVar.axJ);
        t.putValue(jSONObject, "activePhoneCount", fVar.axK);
        return jSONObject;
    }

    @Override // com.kwad.sdk.core.response.kwai.a, com.kwad.sdk.core.b
    public final void parseJson(@Nullable JSONObject jSONObject) {
        a(this, jSONObject);
        afterParseJson(jSONObject);
    }

    @Override // com.kwad.sdk.core.response.kwai.a, com.kwad.sdk.core.b
    public final JSONObject toJson() {
        JSONObject b2 = b(this, new JSONObject());
        afterToJson(b2);
        return b2;
    }
}
