package com.kwad.sdk.core.a.kwai;

import com.kwad.sdk.core.response.model.AdMatrixInfo;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public final class g implements com.kwad.sdk.core.d<AdMatrixInfo.ActivityMiddlePageInfo> {
    /* renamed from: a */
    private static void a2(AdMatrixInfo.ActivityMiddlePageInfo activityMiddlePageInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        activityMiddlePageInfo.showHeaderBar = jSONObject.optBoolean("showHeaderBar");
    }

    /* renamed from: b */
    private static JSONObject b2(AdMatrixInfo.ActivityMiddlePageInfo activityMiddlePageInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        boolean z = activityMiddlePageInfo.showHeaderBar;
        if (z) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "showHeaderBar", z);
        }
        return jSONObject;
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(AdMatrixInfo.ActivityMiddlePageInfo activityMiddlePageInfo, JSONObject jSONObject) {
        a2(activityMiddlePageInfo, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(AdMatrixInfo.ActivityMiddlePageInfo activityMiddlePageInfo, JSONObject jSONObject) {
        return b2(activityMiddlePageInfo, jSONObject);
    }
}
