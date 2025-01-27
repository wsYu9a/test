package com.kwad.sdk.core.a.kwai;

import com.kwad.components.ad.f.kwai.kwai.b;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public final class iv implements com.kwad.sdk.core.d<b.a> {
    /* renamed from: a */
    private static void a2(b.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        aVar.nW = jSONObject.optInt("timerName");
        aVar.nX = jSONObject.optInt(com.alipay.mobilesecuritysdk.deviceID.c.y);
    }

    /* renamed from: b */
    private static JSONObject b2(b.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        int i2 = aVar.nW;
        if (i2 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "timerName", i2);
        }
        int i3 = aVar.nX;
        if (i3 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, com.alipay.mobilesecuritysdk.deviceID.c.y, i3);
        }
        return jSONObject;
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(b.a aVar, JSONObject jSONObject) {
        a2(aVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(b.a aVar, JSONObject jSONObject) {
        return b2(aVar, jSONObject);
    }
}
