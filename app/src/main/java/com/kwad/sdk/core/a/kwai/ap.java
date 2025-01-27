package com.kwad.sdk.core.a.kwai;

import com.kwad.sdk.crash.model.message.AnrReason;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public final class ap implements com.kwad.sdk.core.d<AnrReason> {
    /* renamed from: a */
    private static void a2(AnrReason anrReason, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        String optString = jSONObject.optString("mTag");
        anrReason.mTag = optString;
        if (optString == JSONObject.NULL) {
            anrReason.mTag = "";
        }
        String optString2 = jSONObject.optString("mShortMsg");
        anrReason.mShortMsg = optString2;
        if (optString2 == JSONObject.NULL) {
            anrReason.mShortMsg = "";
        }
        String optString3 = jSONObject.optString("mLongMsg");
        anrReason.mLongMsg = optString3;
        if (optString3 == JSONObject.NULL) {
            anrReason.mLongMsg = "";
        }
    }

    /* renamed from: b */
    private static JSONObject b2(AnrReason anrReason, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        String str = anrReason.mTag;
        if (str != null && !str.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "mTag", anrReason.mTag);
        }
        String str2 = anrReason.mShortMsg;
        if (str2 != null && !str2.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "mShortMsg", anrReason.mShortMsg);
        }
        String str3 = anrReason.mLongMsg;
        if (str3 != null && !str3.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "mLongMsg", anrReason.mLongMsg);
        }
        return jSONObject;
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(AnrReason anrReason, JSONObject jSONObject) {
        a2(anrReason, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(AnrReason anrReason, JSONObject jSONObject) {
        return b2(anrReason, jSONObject);
    }
}
