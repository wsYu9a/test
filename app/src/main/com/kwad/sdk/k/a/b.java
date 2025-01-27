package com.kwad.sdk.k.a;

import androidx.annotation.Nullable;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.service.a.h;
import com.kwad.sdk.utils.be;
import com.kwad.sdk.utils.x;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public final class b extends com.kwad.sdk.core.response.a.a implements com.kwad.sdk.core.b {
    public int aRl;
    public int aRm;
    public int aRn;

    public b(int i10, int i11, int i12) {
        this.aRl = i10;
        this.aRm = i11;
        this.aRn = i12;
    }

    public static synchronized b Mk() {
        synchronized (b.class) {
            if (!((h) ServiceProvider.get(h.class)).zO()) {
                return null;
            }
            return be.Mk();
        }
    }

    private static void a(b bVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        bVar.aRl = jSONObject.optInt("cellId", -1);
        bVar.aRm = jSONObject.optInt("lac", -1);
        bVar.aRn = jSONObject.optInt("bsss", -1);
    }

    private static JSONObject b(b bVar, JSONObject jSONObject) {
        x.putValue(jSONObject, "cellId", bVar.aRl);
        x.putValue(jSONObject, "lac", bVar.aRm);
        x.putValue(jSONObject, "bsss", bVar.aRn);
        return jSONObject;
    }

    @Override // com.kwad.sdk.core.response.a.a, com.kwad.sdk.core.b
    public final void parseJson(@Nullable JSONObject jSONObject) {
        a(this, jSONObject);
        super.afterParseJson(jSONObject);
    }

    @Override // com.kwad.sdk.core.response.a.a, com.kwad.sdk.core.b
    public final JSONObject toJson() {
        return b(this, new JSONObject());
    }
}
