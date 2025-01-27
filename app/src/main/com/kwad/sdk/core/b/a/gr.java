package com.kwad.sdk.core.b.a;

import com.kwad.sdk.core.response.model.AdInfo;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public final class gr implements com.kwad.sdk.core.d<AdInfo.MaterialSize> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(AdInfo.MaterialSize materialSize, JSONObject jSONObject) {
        a2(materialSize, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(AdInfo.MaterialSize materialSize, JSONObject jSONObject) {
        return b2(materialSize, jSONObject);
    }

    /* renamed from: a */
    private static void a2(AdInfo.MaterialSize materialSize, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        materialSize.width = jSONObject.optInt("width");
        materialSize.height = jSONObject.optInt("height");
    }

    /* renamed from: b */
    private static JSONObject b2(AdInfo.MaterialSize materialSize, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        int i10 = materialSize.width;
        if (i10 != 0) {
            com.kwad.sdk.utils.x.putValue(jSONObject, "width", i10);
        }
        int i11 = materialSize.height;
        if (i11 != 0) {
            com.kwad.sdk.utils.x.putValue(jSONObject, "height", i11);
        }
        return jSONObject;
    }
}
