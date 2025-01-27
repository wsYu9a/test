package com.kwad.sdk.core.a.kwai;

import com.kwad.sdk.core.response.model.AdMatrixInfo;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public final class cs implements com.kwad.sdk.core.d<AdMatrixInfo.EndCardInfo> {
    /* renamed from: a */
    private static void a2(AdMatrixInfo.EndCardInfo endCardInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        endCardInfo.cardShowPlayCount = jSONObject.optInt("cardShowPlayCount");
        endCardInfo.cardType = jSONObject.optInt("cardType");
    }

    /* renamed from: b */
    private static JSONObject b2(AdMatrixInfo.EndCardInfo endCardInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        int i2 = endCardInfo.cardShowPlayCount;
        if (i2 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "cardShowPlayCount", i2);
        }
        int i3 = endCardInfo.cardType;
        if (i3 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "cardType", i3);
        }
        return jSONObject;
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(AdMatrixInfo.EndCardInfo endCardInfo, JSONObject jSONObject) {
        a2(endCardInfo, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(AdMatrixInfo.EndCardInfo endCardInfo, JSONObject jSONObject) {
        return b2(endCardInfo, jSONObject);
    }
}
