package com.kwad.sdk.core.b.a;

import org.json.JSONObject;

/* loaded from: classes3.dex */
public final class km implements com.kwad.sdk.core.d<com.kwad.sdk.core.request.model.f> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.request.model.f fVar, JSONObject jSONObject) {
        a2(fVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.request.model.f fVar, JSONObject jSONObject) {
        return b2(fVar, jSONObject);
    }

    /* renamed from: a */
    private static void a2(com.kwad.sdk.core.request.model.f fVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        fVar.adStyle = jSONObject.optInt("adStyle");
        fVar.taskType = jSONObject.optInt("taskType");
        fVar.count = jSONObject.optInt(c7.g.f1744b);
        fVar.aEb = jSONObject.optLong("lastModifiedTime");
    }

    /* renamed from: b */
    private static JSONObject b2(com.kwad.sdk.core.request.model.f fVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        int i10 = fVar.adStyle;
        if (i10 != 0) {
            com.kwad.sdk.utils.x.putValue(jSONObject, "adStyle", i10);
        }
        int i11 = fVar.taskType;
        if (i11 != 0) {
            com.kwad.sdk.utils.x.putValue(jSONObject, "taskType", i11);
        }
        int i12 = fVar.count;
        if (i12 != 0) {
            com.kwad.sdk.utils.x.putValue(jSONObject, c7.g.f1744b, i12);
        }
        long j10 = fVar.aEb;
        if (j10 != 0) {
            com.kwad.sdk.utils.x.putValue(jSONObject, "lastModifiedTime", j10);
        }
        return jSONObject;
    }
}
