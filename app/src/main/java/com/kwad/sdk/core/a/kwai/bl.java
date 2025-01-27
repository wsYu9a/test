package com.kwad.sdk.core.a.kwai;

import com.tencent.open.SocialConstants;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public final class bl implements com.kwad.sdk.core.d<com.kwad.sdk.core.report.j> {
    /* renamed from: a */
    private static void a2(com.kwad.sdk.core.report.j jVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        jVar.llsid = jSONObject.optLong("llsid");
        jVar.creativeId = jSONObject.optLong("creative_id");
        jVar.score = jSONObject.optInt("score");
        jVar.aiq = jSONObject.optInt("is_bidding");
        String optString = jSONObject.optString(SocialConstants.PARAM_SOURCE);
        jVar.source = optString;
        if (optString == JSONObject.NULL) {
            jVar.source = "";
        }
    }

    /* renamed from: b */
    private static JSONObject b2(com.kwad.sdk.core.report.j jVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        long j2 = jVar.llsid;
        if (j2 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "llsid", j2);
        }
        long j3 = jVar.creativeId;
        if (j3 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "creative_id", j3);
        }
        int i2 = jVar.score;
        if (i2 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "score", i2);
        }
        int i3 = jVar.aiq;
        if (i3 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "is_bidding", i3);
        }
        String str = jVar.source;
        if (str != null && !str.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, SocialConstants.PARAM_SOURCE, jVar.source);
        }
        return jSONObject;
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.report.j jVar, JSONObject jSONObject) {
        a2(jVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.report.j jVar, JSONObject jSONObject) {
        return b2(jVar, jSONObject);
    }
}
