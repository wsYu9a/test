package com.kwad.sdk.core.a.kwai;

import com.kwad.sdk.core.response.model.AdStyleInfo;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public final class cq implements com.kwad.sdk.core.d<AdStyleInfo.PlayDetailInfo.DrawAdInfo> {
    /* renamed from: a */
    private static void a2(AdStyleInfo.PlayDetailInfo.DrawAdInfo drawAdInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        drawAdInfo.forcedWatch = jSONObject.optBoolean("forcedWatch");
    }

    /* renamed from: b */
    private static JSONObject b2(AdStyleInfo.PlayDetailInfo.DrawAdInfo drawAdInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        boolean z = drawAdInfo.forcedWatch;
        if (z) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "forcedWatch", z);
        }
        return jSONObject;
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(AdStyleInfo.PlayDetailInfo.DrawAdInfo drawAdInfo, JSONObject jSONObject) {
        a2(drawAdInfo, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(AdStyleInfo.PlayDetailInfo.DrawAdInfo drawAdInfo, JSONObject jSONObject) {
        return b2(drawAdInfo, jSONObject);
    }
}
