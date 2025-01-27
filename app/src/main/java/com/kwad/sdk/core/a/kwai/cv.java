package com.kwad.sdk.core.a.kwai;

import com.kwad.sdk.core.report.a;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public final class cv implements com.kwad.sdk.core.d<a.C0218a> {
    /* renamed from: a */
    private static void a2(a.C0218a c0218a, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        c0218a.code = jSONObject.optInt("code");
        String optString = jSONObject.optString("msg");
        c0218a.msg = optString;
        if (optString == JSONObject.NULL) {
            c0218a.msg = "";
        }
    }

    /* renamed from: b */
    private static JSONObject b2(a.C0218a c0218a, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        int i2 = c0218a.code;
        if (i2 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "code", i2);
        }
        String str = c0218a.msg;
        if (str != null && !str.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "msg", c0218a.msg);
        }
        return jSONObject;
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(a.C0218a c0218a, JSONObject jSONObject) {
        a2(c0218a, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(a.C0218a c0218a, JSONObject jSONObject) {
        return b2(c0218a, jSONObject);
    }
}
