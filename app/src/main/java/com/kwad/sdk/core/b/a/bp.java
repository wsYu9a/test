package com.kwad.sdk.core.b.a;

import com.kwad.components.core.webview.jshandler.au;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public final class bp implements com.kwad.sdk.core.d<au.a> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(au.a aVar, JSONObject jSONObject) {
        a2(aVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(au.a aVar, JSONObject jSONObject) {
        return b2(aVar, jSONObject);
    }

    /* renamed from: a */
    private static void a2(au.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        aVar.status = jSONObject.optInt("status");
    }

    /* renamed from: b */
    private static JSONObject b2(au.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        int i10 = aVar.status;
        if (i10 != 0) {
            com.kwad.sdk.utils.x.putValue(jSONObject, "status", i10);
        }
        return jSONObject;
    }
}
