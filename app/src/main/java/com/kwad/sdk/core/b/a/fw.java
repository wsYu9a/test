package com.kwad.sdk.core.b.a;

import com.kwad.sdk.core.response.model.HttpDnsInfo;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public final class fw implements com.kwad.sdk.core.d<HttpDnsInfo.IpInfo> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(HttpDnsInfo.IpInfo ipInfo, JSONObject jSONObject) {
        a2(ipInfo, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(HttpDnsInfo.IpInfo ipInfo, JSONObject jSONObject) {
        return b2(ipInfo, jSONObject);
    }

    /* renamed from: a */
    private static void a2(HttpDnsInfo.IpInfo ipInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        ipInfo.ip = jSONObject.optString("ip");
        if (JSONObject.NULL.toString().equals(ipInfo.ip)) {
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
            com.kwad.sdk.utils.x.putValue(jSONObject, "ip", ipInfo.ip);
        }
        int i10 = ipInfo.weight;
        if (i10 != 0) {
            com.kwad.sdk.utils.x.putValue(jSONObject, "weight", i10);
        }
        return jSONObject;
    }
}
