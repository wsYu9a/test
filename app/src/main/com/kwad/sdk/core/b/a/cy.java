package com.kwad.sdk.core.b.a;

import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public final class cy implements com.kwad.sdk.core.d<com.kwad.sdk.crash.a> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.crash.a aVar, JSONObject jSONObject) {
        a2(aVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.crash.a aVar, JSONObject jSONObject) {
        return b2(aVar, jSONObject);
    }

    /* renamed from: a */
    private static void a2(com.kwad.sdk.crash.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        aVar.aJr = new ArrayList();
        JSONArray optJSONArray = jSONObject.optJSONArray("appIdList");
        if (optJSONArray != null) {
            for (int i10 = 0; i10 < optJSONArray.length(); i10++) {
                aVar.aJr.add((String) optJSONArray.opt(i10));
            }
        }
        aVar.aJs = new ArrayList();
        JSONArray optJSONArray2 = jSONObject.optJSONArray("sdkVersionList");
        if (optJSONArray2 != null) {
            for (int i11 = 0; i11 < optJSONArray2.length(); i11++) {
                aVar.aJs.add((String) optJSONArray2.opt(i11));
            }
        }
        aVar.aJt = new ArrayList();
        JSONArray optJSONArray3 = jSONObject.optJSONArray("stacktraceList");
        if (optJSONArray3 != null) {
            for (int i12 = 0; i12 < optJSONArray3.length(); i12++) {
                aVar.aJt.add((String) optJSONArray3.opt(i12));
            }
        }
        aVar.aJu = jSONObject.optDouble("crashUploadRate", new Double("1.0").doubleValue());
    }

    /* renamed from: b */
    private static JSONObject b2(com.kwad.sdk.crash.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        com.kwad.sdk.utils.x.putValue(jSONObject, "appIdList", aVar.aJr);
        com.kwad.sdk.utils.x.putValue(jSONObject, "sdkVersionList", aVar.aJs);
        com.kwad.sdk.utils.x.putValue(jSONObject, "stacktraceList", aVar.aJt);
        com.kwad.sdk.utils.x.putValue(jSONObject, "crashUploadRate", aVar.aJu);
        return jSONObject;
    }
}
