package com.kwad.sdk.core.a.kwai;

import com.kwad.sdk.commercial.model.HybridLoadMsg;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public final class ec implements com.kwad.sdk.core.d<HybridLoadMsg> {
    /* renamed from: a */
    private static void a2(HybridLoadMsg hybridLoadMsg, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        String optString = jSONObject.optString("scene_id");
        hybridLoadMsg.sceneId = optString;
        if (optString == JSONObject.NULL) {
            hybridLoadMsg.sceneId = "";
        }
        String optString2 = jSONObject.optString("h5_version");
        hybridLoadMsg.h5Version = optString2;
        if (optString2 == JSONObject.NULL) {
            hybridLoadMsg.h5Version = "";
        }
        hybridLoadMsg.loadType = jSONObject.optInt("load_type");
        hybridLoadMsg.state = jSONObject.optInt("state");
        String optString3 = jSONObject.optString(com.umeng.analytics.pro.am.aU);
        hybridLoadMsg.interval = optString3;
        if (optString3 == JSONObject.NULL) {
            hybridLoadMsg.interval = "";
        }
        hybridLoadMsg.failState = jSONObject.optInt("fail_state");
        String optString4 = jSONObject.optString("fail_reason");
        hybridLoadMsg.failReason = optString4;
        if (optString4 == JSONObject.NULL) {
            hybridLoadMsg.failReason = "";
        }
        String optString5 = jSONObject.optString("url");
        hybridLoadMsg.url = optString5;
        if (optString5 == JSONObject.NULL) {
            hybridLoadMsg.url = "";
        }
        String optString6 = jSONObject.optString("package_url");
        hybridLoadMsg.packageUrl = optString6;
        if (optString6 == JSONObject.NULL) {
            hybridLoadMsg.packageUrl = "";
        }
    }

    /* renamed from: b */
    private static JSONObject b2(HybridLoadMsg hybridLoadMsg, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        String str = hybridLoadMsg.sceneId;
        if (str != null && !str.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "scene_id", hybridLoadMsg.sceneId);
        }
        String str2 = hybridLoadMsg.h5Version;
        if (str2 != null && !str2.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "h5_version", hybridLoadMsg.h5Version);
        }
        int i2 = hybridLoadMsg.loadType;
        if (i2 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "load_type", i2);
        }
        int i3 = hybridLoadMsg.state;
        if (i3 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "state", i3);
        }
        String str3 = hybridLoadMsg.interval;
        if (str3 != null && !str3.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, com.umeng.analytics.pro.am.aU, hybridLoadMsg.interval);
        }
        int i4 = hybridLoadMsg.failState;
        if (i4 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "fail_state", i4);
        }
        String str4 = hybridLoadMsg.failReason;
        if (str4 != null && !str4.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "fail_reason", hybridLoadMsg.failReason);
        }
        String str5 = hybridLoadMsg.url;
        if (str5 != null && !str5.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "url", hybridLoadMsg.url);
        }
        String str6 = hybridLoadMsg.packageUrl;
        if (str6 != null && !str6.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "package_url", hybridLoadMsg.packageUrl);
        }
        return jSONObject;
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(HybridLoadMsg hybridLoadMsg, JSONObject jSONObject) {
        a2(hybridLoadMsg, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(HybridLoadMsg hybridLoadMsg, JSONObject jSONObject) {
        return b2(hybridLoadMsg, jSONObject);
    }
}
