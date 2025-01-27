package com.kwad.sdk.core.b.a;

import com.kwad.sdk.core.response.model.AdInfo;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public final class jj implements com.kwad.sdk.core.d<AdInfo.SmallAppJumpInfo> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(AdInfo.SmallAppJumpInfo smallAppJumpInfo, JSONObject jSONObject) {
        a2(smallAppJumpInfo, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(AdInfo.SmallAppJumpInfo smallAppJumpInfo, JSONObject jSONObject) {
        return b2(smallAppJumpInfo, jSONObject);
    }

    /* renamed from: a */
    private static void a2(AdInfo.SmallAppJumpInfo smallAppJumpInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        smallAppJumpInfo.smallAppJumpUrl = jSONObject.optString("smallAppJumpUrl");
        Object obj = JSONObject.NULL;
        if (obj.toString().equals(smallAppJumpInfo.smallAppJumpUrl)) {
            smallAppJumpInfo.smallAppJumpUrl = "";
        }
        smallAppJumpInfo.originId = jSONObject.optString("originId");
        if (obj.toString().equals(smallAppJumpInfo.originId)) {
            smallAppJumpInfo.originId = "";
        }
        smallAppJumpInfo.mediaSmallAppId = jSONObject.optString("mediaSmallAppId");
        if (obj.toString().equals(smallAppJumpInfo.mediaSmallAppId)) {
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
            com.kwad.sdk.utils.x.putValue(jSONObject, "smallAppJumpUrl", smallAppJumpInfo.smallAppJumpUrl);
        }
        String str2 = smallAppJumpInfo.originId;
        if (str2 != null && !str2.equals("")) {
            com.kwad.sdk.utils.x.putValue(jSONObject, "originId", smallAppJumpInfo.originId);
        }
        String str3 = smallAppJumpInfo.mediaSmallAppId;
        if (str3 != null && !str3.equals("")) {
            com.kwad.sdk.utils.x.putValue(jSONObject, "mediaSmallAppId", smallAppJumpInfo.mediaSmallAppId);
        }
        return jSONObject;
    }
}
