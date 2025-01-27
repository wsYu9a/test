package com.kwad.sdk.core.a.kwai;

import com.kwad.sdk.core.response.model.AdInfo;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public final class hr implements com.kwad.sdk.core.d<AdInfo.SmallAppJumpInfo> {
    /* renamed from: a */
    private static void a2(AdInfo.SmallAppJumpInfo smallAppJumpInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        String optString = jSONObject.optString("smallAppJumpUrl");
        smallAppJumpInfo.smallAppJumpUrl = optString;
        if (optString == JSONObject.NULL) {
            smallAppJumpInfo.smallAppJumpUrl = "";
        }
        String optString2 = jSONObject.optString("originId");
        smallAppJumpInfo.originId = optString2;
        if (optString2 == JSONObject.NULL) {
            smallAppJumpInfo.originId = "";
        }
        String optString3 = jSONObject.optString("mediaSmallAppId");
        smallAppJumpInfo.mediaSmallAppId = optString3;
        if (optString3 == JSONObject.NULL) {
            smallAppJumpInfo.mediaSmallAppId = "";
        }
    }

    /* renamed from: b */
    private static JSONObject b2(AdInfo.SmallAppJumpInfo smallAppJumpInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        String str = smallAppJumpInfo.smallAppJumpUrl;
        if (str != null && !str.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "smallAppJumpUrl", smallAppJumpInfo.smallAppJumpUrl);
        }
        String str2 = smallAppJumpInfo.originId;
        if (str2 != null && !str2.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "originId", smallAppJumpInfo.originId);
        }
        String str3 = smallAppJumpInfo.mediaSmallAppId;
        if (str3 != null && !str3.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "mediaSmallAppId", smallAppJumpInfo.mediaSmallAppId);
        }
        return jSONObject;
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(AdInfo.SmallAppJumpInfo smallAppJumpInfo, JSONObject jSONObject) {
        a2(smallAppJumpInfo, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(AdInfo.SmallAppJumpInfo smallAppJumpInfo, JSONObject jSONObject) {
        return b2(smallAppJumpInfo, jSONObject);
    }
}
