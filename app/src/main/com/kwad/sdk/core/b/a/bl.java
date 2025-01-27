package com.kwad.sdk.core.b.a;

import com.kwad.components.core.request.model.b;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public final class bl implements com.kwad.sdk.core.d<b.a> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(b.a aVar, JSONObject jSONObject) {
        a2(aVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(b.a aVar, JSONObject jSONObject) {
        return b2(aVar, jSONObject);
    }

    /* renamed from: a */
    private static void a2(b.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        aVar.streamType = jSONObject.optInt("streamType");
        aVar.UH = jSONObject.optInt("maxVolume");
        aVar.UI = jSONObject.optInt("minVolume");
        aVar.UJ = jSONObject.optInt("currentVolume");
    }

    /* renamed from: b */
    private static JSONObject b2(b.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        int i10 = aVar.streamType;
        if (i10 != 0) {
            com.kwad.sdk.utils.x.putValue(jSONObject, "streamType", i10);
        }
        int i11 = aVar.UH;
        if (i11 != 0) {
            com.kwad.sdk.utils.x.putValue(jSONObject, "maxVolume", i11);
        }
        int i12 = aVar.UI;
        if (i12 != 0) {
            com.kwad.sdk.utils.x.putValue(jSONObject, "minVolume", i12);
        }
        int i13 = aVar.UJ;
        if (i13 != 0) {
            com.kwad.sdk.utils.x.putValue(jSONObject, "currentVolume", i13);
        }
        return jSONObject;
    }
}
