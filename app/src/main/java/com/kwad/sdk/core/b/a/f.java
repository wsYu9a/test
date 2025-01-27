package com.kwad.sdk.core.b.a;

import com.kwad.sdk.contentalliance.coupon.model.ActivityInfo;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public final class f implements com.kwad.sdk.core.d<ActivityInfo> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(ActivityInfo activityInfo, JSONObject jSONObject) {
        a2(activityInfo, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(ActivityInfo activityInfo, JSONObject jSONObject) {
        return b2(activityInfo, jSONObject);
    }

    /* renamed from: a */
    private static void a2(ActivityInfo activityInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        activityInfo.actTypeId = jSONObject.optInt("actTypeId");
        activityInfo.sceneTypeId = jSONObject.optInt("sceneTypeId");
    }

    /* renamed from: b */
    private static JSONObject b2(ActivityInfo activityInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        int i10 = activityInfo.actTypeId;
        if (i10 != 0) {
            com.kwad.sdk.utils.x.putValue(jSONObject, "actTypeId", i10);
        }
        int i11 = activityInfo.sceneTypeId;
        if (i11 != 0) {
            com.kwad.sdk.utils.x.putValue(jSONObject, "sceneTypeId", i11);
        }
        return jSONObject;
    }
}
