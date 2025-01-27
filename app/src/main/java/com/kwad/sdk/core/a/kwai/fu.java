package com.kwad.sdk.core.a.kwai;

import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public final class fu implements com.kwad.sdk.core.d<com.kwad.sdk.core.network.k> {
    /* renamed from: a */
    private static void a2(com.kwad.sdk.core.network.k kVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        kVar.agC = jSONObject.optLong("request_prepare_cost");
        kVar.agD = jSONObject.optLong("request_add_params_cost");
        kVar.agE = jSONObject.optLong("request_create_cost");
        kVar.agF = jSONObject.optInt("keep_alive");
        kVar.agG = jSONObject.optLong("dns_start");
        kVar.agH = jSONObject.optLong("dns_cost");
        kVar.agI = jSONObject.optLong("connect_establish_start");
        kVar.agJ = jSONObject.optLong("connect_establish_cost");
        kVar.agK = jSONObject.optLong("request_start");
        kVar.agL = jSONObject.optLong("request_cost");
        kVar.agM = jSONObject.optLong("request_size");
        kVar.agN = jSONObject.optLong("response_start");
        kVar.agO = jSONObject.optLong("response_cost");
        kVar.agP = jSONObject.optLong("response_parse_cost");
        kVar.agQ = jSONObject.optLong("response_size");
        kVar.agR = jSONObject.optLong("waiting_response_cost");
        kVar.agS = jSONObject.optLong("total_cost");
        kVar.agT = jSONObject.optInt("proxy_used");
        String optString = jSONObject.optString("request_id");
        kVar.agU = optString;
        if (optString == JSONObject.NULL) {
            kVar.agU = "";
        }
        kVar.agV = jSONObject.optInt("has_data_v2");
        kVar.result = jSONObject.optInt("result");
        kVar.agW = jSONObject.optLong("response_done_cost");
        String optString2 = jSONObject.optString(MonitorConstants.HOST_IP);
        kVar.agX = optString2;
        if (optString2 == JSONObject.NULL) {
            kVar.agX = "";
        }
        kVar.agY = jSONObject.optInt("ip_type");
        kVar.agZ = jSONObject.optInt("recommend_ping_time");
        kVar.aha = jSONObject.optInt("backup_ping_time");
        kVar.ahb = jSONObject.optInt("other_ping_time");
    }

    /* renamed from: b */
    private static JSONObject b2(com.kwad.sdk.core.network.k kVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        long j2 = kVar.agC;
        if (j2 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "request_prepare_cost", j2);
        }
        long j3 = kVar.agD;
        if (j3 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "request_add_params_cost", j3);
        }
        long j4 = kVar.agE;
        if (j4 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "request_create_cost", j4);
        }
        int i2 = kVar.agF;
        if (i2 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "keep_alive", i2);
        }
        long j5 = kVar.agG;
        if (j5 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "dns_start", j5);
        }
        long j6 = kVar.agH;
        if (j6 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "dns_cost", j6);
        }
        long j7 = kVar.agI;
        if (j7 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "connect_establish_start", j7);
        }
        long j8 = kVar.agJ;
        if (j8 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "connect_establish_cost", j8);
        }
        long j9 = kVar.agK;
        if (j9 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "request_start", j9);
        }
        long j10 = kVar.agL;
        if (j10 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "request_cost", j10);
        }
        long j11 = kVar.agM;
        if (j11 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "request_size", j11);
        }
        long j12 = kVar.agN;
        if (j12 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "response_start", j12);
        }
        long j13 = kVar.agO;
        if (j13 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "response_cost", j13);
        }
        long j14 = kVar.agP;
        if (j14 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "response_parse_cost", j14);
        }
        long j15 = kVar.agQ;
        if (j15 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "response_size", j15);
        }
        long j16 = kVar.agR;
        if (j16 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "waiting_response_cost", j16);
        }
        long j17 = kVar.agS;
        if (j17 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "total_cost", j17);
        }
        int i3 = kVar.agT;
        if (i3 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "proxy_used", i3);
        }
        String str = kVar.agU;
        if (str != null && !str.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "request_id", kVar.agU);
        }
        int i4 = kVar.agV;
        if (i4 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "has_data_v2", i4);
        }
        int i5 = kVar.result;
        if (i5 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "result", i5);
        }
        long j18 = kVar.agW;
        if (j18 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "response_done_cost", j18);
        }
        String str2 = kVar.agX;
        if (str2 != null && !str2.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, MonitorConstants.HOST_IP, kVar.agX);
        }
        int i6 = kVar.agY;
        if (i6 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "ip_type", i6);
        }
        int i7 = kVar.agZ;
        if (i7 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "recommend_ping_time", i7);
        }
        int i8 = kVar.aha;
        if (i8 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "backup_ping_time", i8);
        }
        int i9 = kVar.ahb;
        if (i9 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "other_ping_time", i9);
        }
        return jSONObject;
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.network.k kVar, JSONObject jSONObject) {
        a2(kVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.network.k kVar, JSONObject jSONObject) {
        return b2(kVar, jSONObject);
    }
}
