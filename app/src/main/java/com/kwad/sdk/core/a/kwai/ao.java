package com.kwad.sdk.core.a.kwai;

import com.kwad.components.core.webview.jshandler.aj;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public final class ao implements com.kwad.sdk.core.d<aj.a> {
    /* renamed from: a */
    private static void a2(aj.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        aVar.id = jSONObject.optInt("id");
        aVar.status = jSONObject.optInt("status");
    }

    /* renamed from: b */
    private static JSONObject b2(aj.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        int i2 = aVar.id;
        if (i2 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "id", i2);
        }
        int i3 = aVar.status;
        if (i3 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "status", i3);
        }
        return jSONObject;
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(aj.a aVar, JSONObject jSONObject) {
        a2(aVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(aj.a aVar, JSONObject jSONObject) {
        return b2(aVar, jSONObject);
    }
}
