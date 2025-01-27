package com.kwad.sdk.core.a.kwai;

import com.opos.mobad.activity.VideoActivity;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public final class bp implements com.kwad.sdk.core.d<com.kwad.components.core.webview.a.a.g> {
    /* renamed from: a */
    private static void a2(com.kwad.components.core.webview.a.a.g gVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        String optString = jSONObject.optString("payload");
        gVar.Ts = optString;
        if (optString == JSONObject.NULL) {
            gVar.Ts = "";
        }
        gVar.Tr = jSONObject.optInt(VideoActivity.EXTRA_KEY_ACTION_TYPE);
    }

    /* renamed from: b */
    private static JSONObject b2(com.kwad.components.core.webview.a.a.g gVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        String str = gVar.Ts;
        if (str != null && !str.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "payload", gVar.Ts);
        }
        int i2 = gVar.Tr;
        if (i2 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, VideoActivity.EXTRA_KEY_ACTION_TYPE, i2);
        }
        return jSONObject;
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.components.core.webview.a.a.g gVar, JSONObject jSONObject) {
        a2(gVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.components.core.webview.a.a.g gVar, JSONObject jSONObject) {
        return b2(gVar, jSONObject);
    }
}
