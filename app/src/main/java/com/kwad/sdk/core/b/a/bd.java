package com.kwad.sdk.core.b.a;

import com.kwad.components.core.webview.jshandler.as;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public final class bd implements com.kwad.sdk.core.d<as.a> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(as.a aVar, JSONObject jSONObject) {
        a2(aVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(as.a aVar, JSONObject jSONObject) {
        return b2(aVar, jSONObject);
    }

    /* renamed from: a */
    private static void a2(as.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        aVar.f11951id = jSONObject.optInt("id");
        aVar.status = jSONObject.optInt("status");
    }

    /* renamed from: b */
    private static JSONObject b2(as.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        int i10 = aVar.f11951id;
        if (i10 != 0) {
            com.kwad.sdk.utils.x.putValue(jSONObject, "id", i10);
        }
        int i11 = aVar.status;
        if (i11 != 0) {
            com.kwad.sdk.utils.x.putValue(jSONObject, "status", i11);
        }
        return jSONObject;
    }
}
