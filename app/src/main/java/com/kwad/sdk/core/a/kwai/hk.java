package com.kwad.sdk.core.a.kwai;

import com.kwad.sdk.core.scene.URLPackage;
import com.kwad.sdk.internal.api.NativeAdExtraDataImpl;
import com.kwad.sdk.internal.api.SceneImpl;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public final class hk implements com.kwad.sdk.core.d<SceneImpl> {
    /* renamed from: a */
    private static void a2(SceneImpl sceneImpl, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        URLPackage uRLPackage = new URLPackage();
        sceneImpl.urlPackage = uRLPackage;
        uRLPackage.parseJson(jSONObject.optJSONObject("urlPackage"));
        sceneImpl.posId = jSONObject.optLong("posId");
        sceneImpl.entryScene = jSONObject.optLong("entryScene");
        sceneImpl.adNum = jSONObject.optInt("adNum");
        sceneImpl.action = jSONObject.optInt("action");
        sceneImpl.width = jSONObject.optInt("width");
        sceneImpl.height = jSONObject.optInt("height");
        sceneImpl.adStyle = jSONObject.optInt("adStyle");
        sceneImpl.screenOrientation = jSONObject.optInt("screenOrientation");
        NativeAdExtraDataImpl nativeAdExtraDataImpl = new NativeAdExtraDataImpl();
        sceneImpl.nativeAdExtraData = nativeAdExtraDataImpl;
        nativeAdExtraDataImpl.parseJson(jSONObject.optJSONObject("nativeAdExtraData"));
        String optString = jSONObject.optString("backUrl");
        sceneImpl.backUrl = optString;
        if (optString == JSONObject.NULL) {
            sceneImpl.backUrl = "";
        }
        String optString2 = jSONObject.optString("bidResponse");
        sceneImpl.bidResponse = optString2;
        if (optString2 == JSONObject.NULL) {
            sceneImpl.bidResponse = "";
        }
        String optString3 = jSONObject.optString("bidResponseV2");
        sceneImpl.bidResponseV2 = optString3;
        if (optString3 == JSONObject.NULL) {
            sceneImpl.bidResponseV2 = "";
        }
    }

    /* renamed from: b */
    private static JSONObject b2(SceneImpl sceneImpl, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        com.kwad.sdk.utils.t.a(jSONObject, "urlPackage", sceneImpl.urlPackage);
        long j2 = sceneImpl.posId;
        if (j2 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "posId", j2);
        }
        long j3 = sceneImpl.entryScene;
        if (j3 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "entryScene", j3);
        }
        int i2 = sceneImpl.adNum;
        if (i2 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "adNum", i2);
        }
        int i3 = sceneImpl.action;
        if (i3 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "action", i3);
        }
        int i4 = sceneImpl.width;
        if (i4 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "width", i4);
        }
        int i5 = sceneImpl.height;
        if (i5 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "height", i5);
        }
        int i6 = sceneImpl.adStyle;
        if (i6 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "adStyle", i6);
        }
        int i7 = sceneImpl.screenOrientation;
        if (i7 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "screenOrientation", i7);
        }
        com.kwad.sdk.utils.t.a(jSONObject, "nativeAdExtraData", sceneImpl.nativeAdExtraData);
        String str = sceneImpl.backUrl;
        if (str != null && !str.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "backUrl", sceneImpl.backUrl);
        }
        String str2 = sceneImpl.bidResponse;
        if (str2 != null && !str2.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "bidResponse", sceneImpl.bidResponse);
        }
        String str3 = sceneImpl.bidResponseV2;
        if (str3 != null && !str3.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "bidResponseV2", sceneImpl.bidResponseV2);
        }
        return jSONObject;
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(SceneImpl sceneImpl, JSONObject jSONObject) {
        a2(sceneImpl, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(SceneImpl sceneImpl, JSONObject jSONObject) {
        return b2(sceneImpl, jSONObject);
    }
}
