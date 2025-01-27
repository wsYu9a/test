package com.kwad.sdk.core.b.a;

import com.kwad.sdk.commercial.model.HybridLoadMsg;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public final class ff implements com.kwad.sdk.core.d<HybridLoadMsg> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(HybridLoadMsg hybridLoadMsg, JSONObject jSONObject) {
        a2(hybridLoadMsg, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(HybridLoadMsg hybridLoadMsg, JSONObject jSONObject) {
        return b2(hybridLoadMsg, jSONObject);
    }

    /* renamed from: a */
    private static void a2(HybridLoadMsg hybridLoadMsg, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        hybridLoadMsg.sceneId = jSONObject.optString("scene_id");
        Object obj = JSONObject.NULL;
        if (obj.toString().equals(hybridLoadMsg.sceneId)) {
            hybridLoadMsg.sceneId = "";
        }
        hybridLoadMsg.h5Version = jSONObject.optString("h5_version");
        if (obj.toString().equals(hybridLoadMsg.h5Version)) {
            hybridLoadMsg.h5Version = "";
        }
        hybridLoadMsg.loadType = jSONObject.optInt("load_type");
        hybridLoadMsg.state = jSONObject.optInt("state");
        hybridLoadMsg.interval = jSONObject.optString(com.umeng.analytics.pro.bt.f23596ba);
        if (obj.toString().equals(hybridLoadMsg.interval)) {
            hybridLoadMsg.interval = "";
        }
        hybridLoadMsg.failState = jSONObject.optInt("fail_state");
        hybridLoadMsg.failReason = jSONObject.optString("fail_reason");
        if (obj.toString().equals(hybridLoadMsg.failReason)) {
            hybridLoadMsg.failReason = "";
        }
        hybridLoadMsg.url = jSONObject.optString("url");
        if (obj.toString().equals(hybridLoadMsg.url)) {
            hybridLoadMsg.url = "";
        }
        hybridLoadMsg.packageUrl = jSONObject.optString("package_url");
        if (obj.toString().equals(hybridLoadMsg.packageUrl)) {
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
            com.kwad.sdk.utils.x.putValue(jSONObject, "scene_id", hybridLoadMsg.sceneId);
        }
        String str2 = hybridLoadMsg.h5Version;
        if (str2 != null && !str2.equals("")) {
            com.kwad.sdk.utils.x.putValue(jSONObject, "h5_version", hybridLoadMsg.h5Version);
        }
        int i10 = hybridLoadMsg.loadType;
        if (i10 != 0) {
            com.kwad.sdk.utils.x.putValue(jSONObject, "load_type", i10);
        }
        int i11 = hybridLoadMsg.state;
        if (i11 != 0) {
            com.kwad.sdk.utils.x.putValue(jSONObject, "state", i11);
        }
        String str3 = hybridLoadMsg.interval;
        if (str3 != null && !str3.equals("")) {
            com.kwad.sdk.utils.x.putValue(jSONObject, com.umeng.analytics.pro.bt.f23596ba, hybridLoadMsg.interval);
        }
        int i12 = hybridLoadMsg.failState;
        if (i12 != 0) {
            com.kwad.sdk.utils.x.putValue(jSONObject, "fail_state", i12);
        }
        String str4 = hybridLoadMsg.failReason;
        if (str4 != null && !str4.equals("")) {
            com.kwad.sdk.utils.x.putValue(jSONObject, "fail_reason", hybridLoadMsg.failReason);
        }
        String str5 = hybridLoadMsg.url;
        if (str5 != null && !str5.equals("")) {
            com.kwad.sdk.utils.x.putValue(jSONObject, "url", hybridLoadMsg.url);
        }
        String str6 = hybridLoadMsg.packageUrl;
        if (str6 != null && !str6.equals("")) {
            com.kwad.sdk.utils.x.putValue(jSONObject, "package_url", hybridLoadMsg.packageUrl);
        }
        return jSONObject;
    }
}
