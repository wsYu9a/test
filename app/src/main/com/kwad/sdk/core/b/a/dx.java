package com.kwad.sdk.core.b.a;

import org.json.JSONObject;

/* loaded from: classes3.dex */
public final class dx implements com.kwad.sdk.core.d<com.kwad.sdk.crash.online.monitor.a.b> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.crash.online.monitor.a.b bVar, JSONObject jSONObject) {
        a2(bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.crash.online.monitor.a.b bVar, JSONObject jSONObject) {
        return b2(bVar, jSONObject);
    }

    /* renamed from: a */
    private static void a2(com.kwad.sdk.crash.online.monitor.a.b bVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        bVar.appId = jSONObject.optString("appId");
        Object obj = JSONObject.NULL;
        if (obj.toString().equals(bVar.appId)) {
            bVar.appId = "";
        }
        bVar.aLw = jSONObject.optString("pluginListenerName");
        if (obj.toString().equals(bVar.aLw)) {
            bVar.aLw = "";
        }
        bVar.aLx = jSONObject.optString("reportMethodName");
        if (obj.toString().equals(bVar.aLx)) {
            bVar.aLx = "";
        }
        bVar.aLy = jSONObject.optString("otherProxyClassName");
        if (obj.toString().equals(bVar.aLy)) {
            bVar.aLy = "";
        }
        bVar.aLz = jSONObject.optString("otherFieldName");
        if (obj.toString().equals(bVar.aLz)) {
            bVar.aLz = "";
        }
        bVar.aLA = jSONObject.optString("otherLevelFieldName");
        if (obj.toString().equals(bVar.aLA)) {
            bVar.aLA = "";
        }
        bVar.aLB = jSONObject.optString("blockTag");
        if (obj.toString().equals(bVar.aLB)) {
            bVar.aLB = "";
        }
    }

    /* renamed from: b */
    private static JSONObject b2(com.kwad.sdk.crash.online.monitor.a.b bVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        String str = bVar.appId;
        if (str != null && !str.equals("")) {
            com.kwad.sdk.utils.x.putValue(jSONObject, "appId", bVar.appId);
        }
        String str2 = bVar.aLw;
        if (str2 != null && !str2.equals("")) {
            com.kwad.sdk.utils.x.putValue(jSONObject, "pluginListenerName", bVar.aLw);
        }
        String str3 = bVar.aLx;
        if (str3 != null && !str3.equals("")) {
            com.kwad.sdk.utils.x.putValue(jSONObject, "reportMethodName", bVar.aLx);
        }
        String str4 = bVar.aLy;
        if (str4 != null && !str4.equals("")) {
            com.kwad.sdk.utils.x.putValue(jSONObject, "otherProxyClassName", bVar.aLy);
        }
        String str5 = bVar.aLz;
        if (str5 != null && !str5.equals("")) {
            com.kwad.sdk.utils.x.putValue(jSONObject, "otherFieldName", bVar.aLz);
        }
        String str6 = bVar.aLA;
        if (str6 != null && !str6.equals("")) {
            com.kwad.sdk.utils.x.putValue(jSONObject, "otherLevelFieldName", bVar.aLA);
        }
        String str7 = bVar.aLB;
        if (str7 != null && !str7.equals("")) {
            com.kwad.sdk.utils.x.putValue(jSONObject, "blockTag", bVar.aLB);
        }
        return jSONObject;
    }
}
