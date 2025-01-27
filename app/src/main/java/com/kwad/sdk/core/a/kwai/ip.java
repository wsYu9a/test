package com.kwad.sdk.core.a.kwai;

import com.kwad.components.core.webview.jshandler.as;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public final class ip implements com.kwad.sdk.core.d<as.a> {
    /* renamed from: a */
    private static void a2(as.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        aVar.Ub = jSONObject.optInt("taskStatus");
    }

    /* renamed from: b */
    private static JSONObject b2(as.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        int i2 = aVar.Ub;
        if (i2 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "taskStatus", i2);
        }
        return jSONObject;
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(as.a aVar, JSONObject jSONObject) {
        a2(aVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(as.a aVar, JSONObject jSONObject) {
        return b2(aVar, jSONObject);
    }
}
