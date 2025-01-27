package com.kwad.sdk.core.b.a;

import com.kwad.sdk.i.a;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public final class iy implements com.kwad.sdk.core.d<a.C0508a> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(a.C0508a c0508a, JSONObject jSONObject) {
        a2(c0508a, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(a.C0508a c0508a, JSONObject jSONObject) {
        return b2(c0508a, jSONObject);
    }

    /* renamed from: a */
    private static void a2(a.C0508a c0508a, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        c0508a.aNY = jSONObject.optInt("ds");
        c0508a.sdkVersion = jSONObject.optString(n3.a.f28754t);
        Object obj = JSONObject.NULL;
        if (obj.toString().equals(c0508a.sdkVersion)) {
            c0508a.sdkVersion = "";
        }
        c0508a.aJK = jSONObject.optString("spv");
        if (obj.toString().equals(c0508a.aJK)) {
            c0508a.aJK = "";
        }
    }

    /* renamed from: b */
    private static JSONObject b2(a.C0508a c0508a, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        int i10 = c0508a.aNY;
        if (i10 != 0) {
            com.kwad.sdk.utils.x.putValue(jSONObject, "ds", i10);
        }
        String str = c0508a.sdkVersion;
        if (str != null && !str.equals("")) {
            com.kwad.sdk.utils.x.putValue(jSONObject, n3.a.f28754t, c0508a.sdkVersion);
        }
        String str2 = c0508a.aJK;
        if (str2 != null && !str2.equals("")) {
            com.kwad.sdk.utils.x.putValue(jSONObject, "spv", c0508a.aJK);
        }
        return jSONObject;
    }
}
