package com.kwad.sdk.core.a.kwai;

import com.kwad.sdk.core.report.y;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public final class bi implements com.kwad.sdk.core.d<y.a> {
    /* renamed from: a */
    private static void a2(y.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        String optString = jSONObject.optString("template_id");
        aVar.templateId = optString;
        if (optString == JSONObject.NULL) {
            aVar.templateId = "";
        }
        String optString2 = jSONObject.optString("template_show_type");
        aVar.ajZ = optString2;
        if (optString2 == JSONObject.NULL) {
            aVar.ajZ = "";
        }
        aVar.aka = jSONObject.optInt("award_task_name");
        aVar.akb = jSONObject.optInt("jumps_liveroom_type");
        aVar.akc = jSONObject.optInt("universe_feature_freg");
        aVar.ake = jSONObject.optInt("is_special_preload");
    }

    /* renamed from: b */
    private static JSONObject b2(y.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        String str = aVar.templateId;
        if (str != null && !str.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "template_id", aVar.templateId);
        }
        String str2 = aVar.ajZ;
        if (str2 != null && !str2.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "template_show_type", aVar.ajZ);
        }
        int i2 = aVar.aka;
        if (i2 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "award_task_name", i2);
        }
        int i3 = aVar.akb;
        if (i3 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "jumps_liveroom_type", i3);
        }
        int i4 = aVar.akc;
        if (i4 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "universe_feature_freg", i4);
        }
        int i5 = aVar.ake;
        if (i5 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "is_special_preload", i5);
        }
        return jSONObject;
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(y.a aVar, JSONObject jSONObject) {
        a2(aVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(y.a aVar, JSONObject jSONObject) {
        return b2(aVar, jSONObject);
    }
}
