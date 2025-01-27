package com.kwad.sdk.core.a.kwai;

import com.kwad.components.core.webview.jshandler.ar;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public final class ji implements com.kwad.sdk.core.d<ar.a> {
    /* renamed from: a */
    private static void a2(ar.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        aVar.status = jSONObject.optInt("status");
    }

    /* renamed from: b */
    private static JSONObject b2(ar.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        int i2 = aVar.status;
        if (i2 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "status", i2);
        }
        return jSONObject;
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(ar.a aVar, JSONObject jSONObject) {
        a2(aVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(ar.a aVar, JSONObject jSONObject) {
        return b2(aVar, jSONObject);
    }
}
