package com.kwad.sdk.core.b.a;

import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.kwad.components.core.webview.jshandler.a;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public final class he implements com.kwad.sdk.core.d<a.c> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(a.c cVar, JSONObject jSONObject) {
        a2(cVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(a.c cVar, JSONObject jSONObject) {
        return b2(cVar, jSONObject);
    }

    /* renamed from: a */
    private static void a2(a.c cVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        cVar.errorCode = jSONObject.optInt(MediationConstant.KEY_ERROR_CODE);
        cVar.YE = jSONObject.optInt("extra");
        cVar.YF = jSONObject.optLong("playDuration");
        cVar.YG = jSONObject.optBoolean("clickRewardDialog");
    }

    /* renamed from: b */
    private static JSONObject b2(a.c cVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        int i10 = cVar.errorCode;
        if (i10 != 0) {
            com.kwad.sdk.utils.x.putValue(jSONObject, MediationConstant.KEY_ERROR_CODE, i10);
        }
        int i11 = cVar.YE;
        if (i11 != 0) {
            com.kwad.sdk.utils.x.putValue(jSONObject, "extra", i11);
        }
        long j10 = cVar.YF;
        if (j10 != 0) {
            com.kwad.sdk.utils.x.putValue(jSONObject, "playDuration", j10);
        }
        boolean z10 = cVar.YG;
        if (z10) {
            com.kwad.sdk.utils.x.putValue(jSONObject, "clickRewardDialog", z10);
        }
        return jSONObject;
    }
}
