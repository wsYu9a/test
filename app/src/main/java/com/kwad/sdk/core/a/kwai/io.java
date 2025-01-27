package com.kwad.sdk.core.a.kwai;

import org.json.JSONObject;

/* loaded from: classes2.dex */
public final class io implements com.kwad.sdk.core.d<com.kwad.sdk.core.request.model.f> {
    /* renamed from: a */
    private static void a2(com.kwad.sdk.core.request.model.f fVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        fVar.adStyle = jSONObject.optInt("adStyle");
        fVar.taskType = jSONObject.optInt("taskType");
        fVar.count = jSONObject.optInt("count");
        fVar.alK = jSONObject.optLong("lastModifiedTime");
    }

    /* renamed from: b */
    private static JSONObject b2(com.kwad.sdk.core.request.model.f fVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        int i2 = fVar.adStyle;
        if (i2 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "adStyle", i2);
        }
        int i3 = fVar.taskType;
        if (i3 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "taskType", i3);
        }
        int i4 = fVar.count;
        if (i4 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "count", i4);
        }
        long j2 = fVar.alK;
        if (j2 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "lastModifiedTime", j2);
        }
        return jSONObject;
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.request.model.f fVar, JSONObject jSONObject) {
        a2(fVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.request.model.f fVar, JSONObject jSONObject) {
        return b2(fVar, jSONObject);
    }
}
