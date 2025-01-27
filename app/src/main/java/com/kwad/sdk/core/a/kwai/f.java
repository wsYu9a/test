package com.kwad.sdk.core.a.kwai;

import com.kwad.sdk.contentalliance.coupon.model.ActivityInfo;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public final class f implements com.kwad.sdk.core.d<ActivityInfo> {
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
        int i2 = activityInfo.actTypeId;
        if (i2 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "actTypeId", i2);
        }
        int i3 = activityInfo.sceneTypeId;
        if (i3 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "sceneTypeId", i3);
        }
        return jSONObject;
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(ActivityInfo activityInfo, JSONObject jSONObject) {
        a2(activityInfo, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(ActivityInfo activityInfo, JSONObject jSONObject) {
        return b2(activityInfo, jSONObject);
    }
}
