package com.kwad.sdk.core.a.kwai;

import com.kwad.sdk.g.b;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public final class hi implements com.kwad.sdk.core.d<b.a> {
    /* renamed from: a */
    private static void a2(b.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        aVar.auj = jSONObject.optInt("ds");
        String optString = jSONObject.optString("sv");
        aVar.sdkVersion = optString;
        if (optString == JSONObject.NULL) {
            aVar.sdkVersion = "";
        }
        String optString2 = jSONObject.optString("spv");
        aVar.auk = optString2;
        if (optString2 == JSONObject.NULL) {
            aVar.auk = "";
        }
    }

    /* renamed from: b */
    private static JSONObject b2(b.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        int i2 = aVar.auj;
        if (i2 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "ds", i2);
        }
        String str = aVar.sdkVersion;
        if (str != null && !str.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "sv", aVar.sdkVersion);
        }
        String str2 = aVar.auk;
        if (str2 != null && !str2.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "spv", aVar.auk);
        }
        return jSONObject;
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(b.a aVar, JSONObject jSONObject) {
        a2(aVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(b.a aVar, JSONObject jSONObject) {
        return b2(aVar, jSONObject);
    }
}
