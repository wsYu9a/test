package com.kwad.sdk.core.a.kwai;

import com.kwad.sdk.core.response.model.AdInfo;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public final class fg implements com.kwad.sdk.core.d<AdInfo.MaterialSize> {
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
        int i2 = materialSize.width;
        if (i2 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "width", i2);
        }
        int i3 = materialSize.height;
        if (i3 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "height", i3);
        }
        return jSONObject;
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(AdInfo.MaterialSize materialSize, JSONObject jSONObject) {
        a2(materialSize, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(AdInfo.MaterialSize materialSize, JSONObject jSONObject) {
        return b2(materialSize, jSONObject);
    }
}
