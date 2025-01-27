package com.kwad.sdk.core.a.kwai;

import com.kwad.sdk.core.response.model.HttpDnsInfo;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public final class eq implements com.kwad.sdk.core.d<HttpDnsInfo.IpInfo> {
    /* renamed from: a */
    private static void a2(HttpDnsInfo.IpInfo ipInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        String optString = jSONObject.optString("ip");
        ipInfo.ip = optString;
        if (optString == JSONObject.NULL) {
            ipInfo.ip = "";
        }
        ipInfo.weight = jSONObject.optInt("weight");
    }

    /* renamed from: b */
    private static JSONObject b2(HttpDnsInfo.IpInfo ipInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        String str = ipInfo.ip;
        if (str != null && !str.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "ip", ipInfo.ip);
        }
        int i2 = ipInfo.weight;
        if (i2 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "weight", i2);
        }
        return jSONObject;
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(HttpDnsInfo.IpInfo ipInfo, JSONObject jSONObject) {
        a2(ipInfo, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(HttpDnsInfo.IpInfo ipInfo, JSONObject jSONObject) {
        return b2(ipInfo, jSONObject);
    }
}
