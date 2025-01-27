package com.kwad.sdk.core.a.kwai;

import com.kwad.components.core.n.kwai.c;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public final class at implements com.kwad.sdk.core.d<c.a> {
    /* renamed from: a */
    private static void a2(c.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        aVar.streamType = jSONObject.optInt("streamType");
        aVar.OX = jSONObject.optInt("maxVolume");
        aVar.OY = jSONObject.optInt("minVolume");
        aVar.OZ = jSONObject.optInt("currentVolume");
    }

    /* renamed from: b */
    private static JSONObject b2(c.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        int i2 = aVar.streamType;
        if (i2 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "streamType", i2);
        }
        int i3 = aVar.OX;
        if (i3 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "maxVolume", i3);
        }
        int i4 = aVar.OY;
        if (i4 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "minVolume", i4);
        }
        int i5 = aVar.OZ;
        if (i5 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "currentVolume", i5);
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
