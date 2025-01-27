package com.kwad.sdk.core.a.kwai;

import com.kwad.components.core.webview.jshandler.w;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public final class gn implements com.kwad.sdk.core.d<w.a> {
    /* renamed from: a */
    private static void a2(w.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        String optString = jSONObject.optString("playableExtraData");
        aVar.playableExtraData = optString;
        if (optString == JSONObject.NULL) {
            aVar.playableExtraData = "";
        }
    }

    /* renamed from: b */
    private static JSONObject b2(w.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        String str = aVar.playableExtraData;
        if (str != null && !str.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "playableExtraData", aVar.playableExtraData);
        }
        return jSONObject;
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(w.a aVar, JSONObject jSONObject) {
        a2(aVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(w.a aVar, JSONObject jSONObject) {
        return b2(aVar, jSONObject);
    }
}
