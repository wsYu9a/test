package com.kwad.sdk.core.b.a;

import com.kwad.components.core.webview.jshandler.i;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public final class eu implements com.kwad.sdk.core.d<i.b> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(i.b bVar, JSONObject jSONObject) {
        a2(bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(i.b bVar, JSONObject jSONObject) {
        return b2(bVar, jSONObject);
    }

    /* renamed from: a */
    private static void a2(i.b bVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        bVar.YM = jSONObject.optInt("playableSrc");
        bVar.YN = jSONObject.optInt("isMiddleEnd");
        bVar.Og = jSONObject.optInt("adType");
    }

    /* renamed from: b */
    private static JSONObject b2(i.b bVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        int i10 = bVar.YM;
        if (i10 != 0) {
            com.kwad.sdk.utils.x.putValue(jSONObject, "playableSrc", i10);
        }
        int i11 = bVar.YN;
        if (i11 != 0) {
            com.kwad.sdk.utils.x.putValue(jSONObject, "isMiddleEnd", i11);
        }
        int i12 = bVar.Og;
        if (i12 != 0) {
            com.kwad.sdk.utils.x.putValue(jSONObject, "adType", i12);
        }
        return jSONObject;
    }
}
