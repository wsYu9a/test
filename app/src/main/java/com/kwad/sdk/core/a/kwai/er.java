package com.kwad.sdk.core.a.kwai;

import com.kwad.components.core.webview.jshandler.af;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public final class er implements com.kwad.sdk.core.d<af.a> {
    /* renamed from: a */
    private static void a2(af.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        String optString = jSONObject.optString("adTemplate");
        aVar.TB = optString;
        if (optString == JSONObject.NULL) {
            aVar.TB = "";
        }
    }

    /* renamed from: b */
    private static JSONObject b2(af.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        String str = aVar.TB;
        if (str != null && !str.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "adTemplate", aVar.TB);
        }
        return jSONObject;
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(af.a aVar, JSONObject jSONObject) {
        a2(aVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(af.a aVar, JSONObject jSONObject) {
        return b2(aVar, jSONObject);
    }
}
