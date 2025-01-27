package com.kwad.sdk.core.b.a;

import com.kwad.components.core.webview.tachikoma.a.x;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public final class bk implements com.kwad.sdk.core.d<x.a> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(x.a aVar, JSONObject jSONObject) {
        a2(aVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(x.a aVar, JSONObject jSONObject) {
        return b2(aVar, jSONObject);
    }

    /* renamed from: a */
    private static void a2(x.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        aVar.adf = jSONObject.optBoolean("hasLoseAudioFocus");
        aVar.adg = jSONObject.optInt("audioFocusStatus");
    }

    /* renamed from: b */
    private static JSONObject b2(x.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        boolean z10 = aVar.adf;
        if (z10) {
            com.kwad.sdk.utils.x.putValue(jSONObject, "hasLoseAudioFocus", z10);
        }
        int i10 = aVar.adg;
        if (i10 != 0) {
            com.kwad.sdk.utils.x.putValue(jSONObject, "audioFocusStatus", i10);
        }
        return jSONObject;
    }
}
