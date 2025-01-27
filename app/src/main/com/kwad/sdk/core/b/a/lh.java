package com.kwad.sdk.core.b.a;

import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public final class lh implements com.kwad.sdk.core.d<com.kwad.components.core.webview.tachikoma.b.x> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.components.core.webview.tachikoma.b.x xVar, JSONObject jSONObject) {
        a2(xVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.components.core.webview.tachikoma.b.x xVar, JSONObject jSONObject) {
        return b2(xVar, jSONObject);
    }

    /* renamed from: a */
    private static void a2(com.kwad.components.core.webview.tachikoma.b.x xVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        xVar.adB = jSONObject.optString("status");
        Object obj = JSONObject.NULL;
        if (obj.toString().equals(xVar.adB)) {
            xVar.adB = "";
        }
        xVar.errorCode = jSONObject.optInt(MediationConstant.KEY_ERROR_CODE);
        xVar.errorReason = jSONObject.optString("errorReason");
        if (obj.toString().equals(xVar.errorReason)) {
            xVar.errorReason = "";
        }
        xVar.oZ = jSONObject.optInt("currentTime");
    }

    /* renamed from: b */
    private static JSONObject b2(com.kwad.components.core.webview.tachikoma.b.x xVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        String str = xVar.adB;
        if (str != null && !str.equals("")) {
            com.kwad.sdk.utils.x.putValue(jSONObject, "status", xVar.adB);
        }
        int i10 = xVar.errorCode;
        if (i10 != 0) {
            com.kwad.sdk.utils.x.putValue(jSONObject, MediationConstant.KEY_ERROR_CODE, i10);
        }
        String str2 = xVar.errorReason;
        if (str2 != null && !str2.equals("")) {
            com.kwad.sdk.utils.x.putValue(jSONObject, "errorReason", xVar.errorReason);
        }
        int i11 = xVar.oZ;
        if (i11 != 0) {
            com.kwad.sdk.utils.x.putValue(jSONObject, "currentTime", i11);
        }
        return jSONObject;
    }
}
