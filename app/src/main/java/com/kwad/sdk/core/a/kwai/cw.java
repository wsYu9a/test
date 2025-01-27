package com.kwad.sdk.core.a.kwai;

import com.kwad.sdk.core.response.model.AdStyleInfo;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public final class cw implements com.kwad.sdk.core.d<AdStyleInfo.ExposeTagInfo> {
    /* renamed from: a */
    private static void a2(AdStyleInfo.ExposeTagInfo exposeTagInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        String optString = jSONObject.optString(com.baidu.mobads.sdk.internal.a.f5473b);
        exposeTagInfo.text = optString;
        if (optString == JSONObject.NULL) {
            exposeTagInfo.text = "";
        }
    }

    /* renamed from: b */
    private static JSONObject b2(AdStyleInfo.ExposeTagInfo exposeTagInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        String str = exposeTagInfo.text;
        if (str != null && !str.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, com.baidu.mobads.sdk.internal.a.f5473b, exposeTagInfo.text);
        }
        return jSONObject;
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(AdStyleInfo.ExposeTagInfo exposeTagInfo, JSONObject jSONObject) {
        a2(exposeTagInfo, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(AdStyleInfo.ExposeTagInfo exposeTagInfo, JSONObject jSONObject) {
        return b2(exposeTagInfo, jSONObject);
    }
}
