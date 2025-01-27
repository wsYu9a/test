package com.kwad.sdk.core.a.kwai;

import com.kwad.components.core.webview.jshandler.e;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public final class ds implements com.kwad.sdk.core.d<e.b> {
    /* renamed from: a */
    private static void a2(e.b bVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        bVar.Se = jSONObject.optInt("playableSrc");
        bVar.Sf = jSONObject.optInt("isPlayAgainScene");
        bVar.Sg = jSONObject.optInt("isMiddleEnd");
        bVar.JE = jSONObject.optInt("adType");
    }

    /* renamed from: b */
    private static JSONObject b2(e.b bVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        int i2 = bVar.Se;
        if (i2 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "playableSrc", i2);
        }
        int i3 = bVar.Sf;
        if (i3 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "isPlayAgainScene", i3);
        }
        int i4 = bVar.Sg;
        if (i4 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "isMiddleEnd", i4);
        }
        int i5 = bVar.JE;
        if (i5 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "adType", i5);
        }
        return jSONObject;
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(e.b bVar, JSONObject jSONObject) {
        a2(bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(e.b bVar, JSONObject jSONObject) {
        return b2(bVar, jSONObject);
    }
}
