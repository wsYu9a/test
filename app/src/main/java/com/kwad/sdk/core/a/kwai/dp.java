package com.kwad.sdk.core.a.kwai;

import com.kwad.components.core.webview.jshandler.c;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public final class dp implements com.kwad.sdk.core.d<c.a> {
    /* renamed from: a */
    private static void a2(c.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        aVar.showLiveStatus = jSONObject.optInt("showLiveStatus");
        aVar.showLiveStyle = jSONObject.optInt("showLiveStyle");
    }

    /* renamed from: b */
    private static JSONObject b2(c.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        int i2 = aVar.showLiveStatus;
        if (i2 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "showLiveStatus", i2);
        }
        int i3 = aVar.showLiveStyle;
        if (i3 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "showLiveStyle", i3);
        }
        return jSONObject;
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(c.a aVar, JSONObject jSONObject) {
        a2(aVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(c.a aVar, JSONObject jSONObject) {
        return b2(aVar, jSONObject);
    }
}
