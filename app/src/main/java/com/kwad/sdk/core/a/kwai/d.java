package com.kwad.sdk.core.a.kwai;

import com.kwad.sdk.core.response.model.AdMatrixInfo;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public final class d implements com.kwad.sdk.core.d<AdMatrixInfo.ActionBarInfoNew> {
    /* renamed from: a */
    private static void a2(AdMatrixInfo.ActionBarInfoNew actionBarInfoNew, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        actionBarInfoNew.maxTimeOut = jSONObject.optLong("maxTimeOut");
        actionBarInfoNew.cardType = jSONObject.optInt("cardType");
    }

    /* renamed from: b */
    private static JSONObject b2(AdMatrixInfo.ActionBarInfoNew actionBarInfoNew, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        long j2 = actionBarInfoNew.maxTimeOut;
        if (j2 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "maxTimeOut", j2);
        }
        int i2 = actionBarInfoNew.cardType;
        if (i2 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "cardType", i2);
        }
        return jSONObject;
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(AdMatrixInfo.ActionBarInfoNew actionBarInfoNew, JSONObject jSONObject) {
        a2(actionBarInfoNew, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(AdMatrixInfo.ActionBarInfoNew actionBarInfoNew, JSONObject jSONObject) {
        return b2(actionBarInfoNew, jSONObject);
    }
}
