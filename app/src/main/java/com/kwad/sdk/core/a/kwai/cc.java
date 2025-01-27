package com.kwad.sdk.core.a.kwai;

import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public final class cc implements com.kwad.sdk.core.d<com.kwad.sdk.crash.a> {
    /* renamed from: a */
    private static void a2(com.kwad.sdk.crash.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        aVar.aqy = new ArrayList();
        JSONArray optJSONArray = jSONObject.optJSONArray("appIdList");
        if (optJSONArray != null) {
            for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
                aVar.aqy.add((String) optJSONArray.opt(i2));
            }
        }
        aVar.aqz = new ArrayList();
        JSONArray optJSONArray2 = jSONObject.optJSONArray("sdkVersionList");
        if (optJSONArray2 != null) {
            for (int i3 = 0; i3 < optJSONArray2.length(); i3++) {
                aVar.aqz.add((String) optJSONArray2.opt(i3));
            }
        }
        aVar.aqA = new ArrayList();
        JSONArray optJSONArray3 = jSONObject.optJSONArray("stacktraceList");
        if (optJSONArray3 != null) {
            for (int i4 = 0; i4 < optJSONArray3.length(); i4++) {
                aVar.aqA.add((String) optJSONArray3.opt(i4));
            }
        }
        aVar.aqB = jSONObject.optDouble("crashUploadRate", new Double("1.0").doubleValue());
    }

    /* renamed from: b */
    private static JSONObject b2(com.kwad.sdk.crash.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        com.kwad.sdk.utils.t.putValue(jSONObject, "appIdList", aVar.aqy);
        com.kwad.sdk.utils.t.putValue(jSONObject, "sdkVersionList", aVar.aqz);
        com.kwad.sdk.utils.t.putValue(jSONObject, "stacktraceList", aVar.aqA);
        com.kwad.sdk.utils.t.putValue(jSONObject, "crashUploadRate", aVar.aqB);
        return jSONObject;
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.crash.a aVar, JSONObject jSONObject) {
        a2(aVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.crash.a aVar, JSONObject jSONObject) {
        return b2(aVar, jSONObject);
    }
}
