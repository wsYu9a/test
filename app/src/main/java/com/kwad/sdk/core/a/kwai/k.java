package com.kwad.sdk.core.a.kwai;

import com.kwad.sdk.core.response.model.AdStyleInfo;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public final class k implements com.kwad.sdk.core.d<AdStyleInfo.AdBrowseInfo> {
    /* renamed from: a */
    private static void a2(AdStyleInfo.AdBrowseInfo adBrowseInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        adBrowseInfo.enableAdBrowse = jSONObject.optInt("enableAdBrowse");
        adBrowseInfo.adBrowseDuration = jSONObject.optInt("adBrowseDuration");
    }

    /* renamed from: b */
    private static JSONObject b2(AdStyleInfo.AdBrowseInfo adBrowseInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        int i2 = adBrowseInfo.enableAdBrowse;
        if (i2 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "enableAdBrowse", i2);
        }
        int i3 = adBrowseInfo.adBrowseDuration;
        if (i3 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "adBrowseDuration", i3);
        }
        return jSONObject;
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(AdStyleInfo.AdBrowseInfo adBrowseInfo, JSONObject jSONObject) {
        a2(adBrowseInfo, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(AdStyleInfo.AdBrowseInfo adBrowseInfo, JSONObject jSONObject) {
        return b2(adBrowseInfo, jSONObject);
    }
}
