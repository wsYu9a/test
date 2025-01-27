package com.kwad.sdk.core.b.a;

import com.kwad.sdk.core.response.model.AdMatrixInfo;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public final class d implements com.kwad.sdk.core.d<AdMatrixInfo.ActionBarInfoNew> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(AdMatrixInfo.ActionBarInfoNew actionBarInfoNew, JSONObject jSONObject) {
        a2(actionBarInfoNew, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(AdMatrixInfo.ActionBarInfoNew actionBarInfoNew, JSONObject jSONObject) {
        return b2(actionBarInfoNew, jSONObject);
    }

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
        long j10 = actionBarInfoNew.maxTimeOut;
        if (j10 != 0) {
            com.kwad.sdk.utils.x.putValue(jSONObject, "maxTimeOut", j10);
        }
        int i10 = actionBarInfoNew.cardType;
        if (i10 != 0) {
            com.kwad.sdk.utils.x.putValue(jSONObject, "cardType", i10);
        }
        return jSONObject;
    }
}
