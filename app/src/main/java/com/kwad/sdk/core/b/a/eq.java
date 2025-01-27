package com.kwad.sdk.core.b.a;

import com.kwad.components.core.webview.jshandler.f;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public final class eq implements com.kwad.sdk.core.d<f.a> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(f.a aVar, JSONObject jSONObject) {
        a2(aVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(f.a aVar, JSONObject jSONObject) {
        return b2(aVar, jSONObject);
    }

    /* renamed from: a */
    private static void a2(f.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        aVar.showLiveStatus = jSONObject.optInt("showLiveStatus");
        aVar.showLiveStyle = jSONObject.optInt("showLiveStyle");
    }

    /* renamed from: b */
    private static JSONObject b2(f.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        int i10 = aVar.showLiveStatus;
        if (i10 != 0) {
            com.kwad.sdk.utils.x.putValue(jSONObject, "showLiveStatus", i10);
        }
        int i11 = aVar.showLiveStyle;
        if (i11 != 0) {
            com.kwad.sdk.utils.x.putValue(jSONObject, "showLiveStyle", i11);
        }
        return jSONObject;
    }
}
