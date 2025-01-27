package com.kwad.sdk.core.b.a;

import com.alimm.tanx.core.ad.event.track.expose.ExposeManager;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public final class cg implements com.kwad.sdk.core.d<com.kwad.sdk.core.report.h> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.report.h hVar, JSONObject jSONObject) {
        a2(hVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.report.h hVar, JSONObject jSONObject) {
        return b2(hVar, jSONObject);
    }

    /* renamed from: a */
    private static void a2(com.kwad.sdk.core.report.h hVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        hVar.llsid = jSONObject.optLong("llsid");
        hVar.creativeId = jSONObject.optLong(ExposeManager.UtArgsNames.creativeId);
        hVar.score = jSONObject.optInt("score");
        hVar.aBQ = jSONObject.optInt("is_bidding");
        hVar.source = jSONObject.optString("source");
        if (JSONObject.NULL.toString().equals(hVar.source)) {
            hVar.source = "";
        }
    }

    /* renamed from: b */
    private static JSONObject b2(com.kwad.sdk.core.report.h hVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        long j10 = hVar.llsid;
        if (j10 != 0) {
            com.kwad.sdk.utils.x.putValue(jSONObject, "llsid", j10);
        }
        long j11 = hVar.creativeId;
        if (j11 != 0) {
            com.kwad.sdk.utils.x.putValue(jSONObject, ExposeManager.UtArgsNames.creativeId, j11);
        }
        int i10 = hVar.score;
        if (i10 != 0) {
            com.kwad.sdk.utils.x.putValue(jSONObject, "score", i10);
        }
        int i11 = hVar.aBQ;
        if (i11 != 0) {
            com.kwad.sdk.utils.x.putValue(jSONObject, "is_bidding", i11);
        }
        String str = hVar.source;
        if (str != null && !str.equals("")) {
            com.kwad.sdk.utils.x.putValue(jSONObject, "source", hVar.source);
        }
        return jSONObject;
    }
}
