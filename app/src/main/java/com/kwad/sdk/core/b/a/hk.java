package com.kwad.sdk.core.b.a;

import com.shu.priory.config.AdKeys;
import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public final class hk implements com.kwad.sdk.core.d<com.kwad.sdk.core.network.j> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.network.j jVar, JSONObject jSONObject) {
        a2(jVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.network.j jVar, JSONObject jSONObject) {
        return b2(jVar, jSONObject);
    }

    /* renamed from: a */
    private static void a2(com.kwad.sdk.core.network.j jVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        jVar.azT = jSONObject.optLong("request_prepare_cost");
        jVar.azU = jSONObject.optLong("request_add_params_cost");
        jVar.azV = jSONObject.optLong("request_create_cost");
        jVar.azW = jSONObject.optInt("keep_alive");
        jVar.azX = jSONObject.optLong("dns_start");
        jVar.azY = jSONObject.optLong("dns_cost");
        jVar.azZ = jSONObject.optLong("connect_establish_start");
        jVar.aAa = jSONObject.optLong("connect_establish_cost");
        jVar.aAb = jSONObject.optLong("request_start");
        jVar.aAc = jSONObject.optLong("request_cost");
        jVar.aAd = jSONObject.optLong("request_size");
        jVar.aAe = jSONObject.optLong("response_start");
        jVar.aAf = jSONObject.optLong("response_cost");
        jVar.aAg = jSONObject.optLong("response_parse_cost");
        jVar.aAh = jSONObject.optLong("response_size");
        jVar.aAi = jSONObject.optLong("waiting_response_cost");
        jVar.aAj = jSONObject.optLong("total_cost");
        jVar.aAk = jSONObject.optInt("proxy_used");
        jVar.aAl = jSONObject.optString(AdKeys.REQUEST_ID);
        Object obj = JSONObject.NULL;
        if (obj.toString().equals(jVar.aAl)) {
            jVar.aAl = "";
        }
        jVar.aAm = jSONObject.optInt("has_data_v2");
        jVar.result = jSONObject.optInt(p3.i.f29758c);
        jVar.aAn = jSONObject.optLong("response_done_cost");
        jVar.aAo = jSONObject.optString(MonitorConstants.HOST_IP);
        if (obj.toString().equals(jVar.aAo)) {
            jVar.aAo = "";
        }
        jVar.aAp = jSONObject.optInt("ip_type");
        jVar.aAq = jSONObject.optInt("recommend_ping_time");
        jVar.aAr = jSONObject.optInt("backup_ping_time");
        jVar.aAs = jSONObject.optInt("other_ping_time");
    }

    /* renamed from: b */
    private static JSONObject b2(com.kwad.sdk.core.network.j jVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        long j10 = jVar.azT;
        if (j10 != 0) {
            com.kwad.sdk.utils.x.putValue(jSONObject, "request_prepare_cost", j10);
        }
        long j11 = jVar.azU;
        if (j11 != 0) {
            com.kwad.sdk.utils.x.putValue(jSONObject, "request_add_params_cost", j11);
        }
        long j12 = jVar.azV;
        if (j12 != 0) {
            com.kwad.sdk.utils.x.putValue(jSONObject, "request_create_cost", j12);
        }
        int i10 = jVar.azW;
        if (i10 != 0) {
            com.kwad.sdk.utils.x.putValue(jSONObject, "keep_alive", i10);
        }
        long j13 = jVar.azX;
        if (j13 != 0) {
            com.kwad.sdk.utils.x.putValue(jSONObject, "dns_start", j13);
        }
        long j14 = jVar.azY;
        if (j14 != 0) {
            com.kwad.sdk.utils.x.putValue(jSONObject, "dns_cost", j14);
        }
        long j15 = jVar.azZ;
        if (j15 != 0) {
            com.kwad.sdk.utils.x.putValue(jSONObject, "connect_establish_start", j15);
        }
        long j16 = jVar.aAa;
        if (j16 != 0) {
            com.kwad.sdk.utils.x.putValue(jSONObject, "connect_establish_cost", j16);
        }
        long j17 = jVar.aAb;
        if (j17 != 0) {
            com.kwad.sdk.utils.x.putValue(jSONObject, "request_start", j17);
        }
        long j18 = jVar.aAc;
        if (j18 != 0) {
            com.kwad.sdk.utils.x.putValue(jSONObject, "request_cost", j18);
        }
        long j19 = jVar.aAd;
        if (j19 != 0) {
            com.kwad.sdk.utils.x.putValue(jSONObject, "request_size", j19);
        }
        long j20 = jVar.aAe;
        if (j20 != 0) {
            com.kwad.sdk.utils.x.putValue(jSONObject, "response_start", j20);
        }
        long j21 = jVar.aAf;
        if (j21 != 0) {
            com.kwad.sdk.utils.x.putValue(jSONObject, "response_cost", j21);
        }
        long j22 = jVar.aAg;
        if (j22 != 0) {
            com.kwad.sdk.utils.x.putValue(jSONObject, "response_parse_cost", j22);
        }
        long j23 = jVar.aAh;
        if (j23 != 0) {
            com.kwad.sdk.utils.x.putValue(jSONObject, "response_size", j23);
        }
        long j24 = jVar.aAi;
        if (j24 != 0) {
            com.kwad.sdk.utils.x.putValue(jSONObject, "waiting_response_cost", j24);
        }
        long j25 = jVar.aAj;
        if (j25 != 0) {
            com.kwad.sdk.utils.x.putValue(jSONObject, "total_cost", j25);
        }
        int i11 = jVar.aAk;
        if (i11 != 0) {
            com.kwad.sdk.utils.x.putValue(jSONObject, "proxy_used", i11);
        }
        String str = jVar.aAl;
        if (str != null && !str.equals("")) {
            com.kwad.sdk.utils.x.putValue(jSONObject, AdKeys.REQUEST_ID, jVar.aAl);
        }
        int i12 = jVar.aAm;
        if (i12 != 0) {
            com.kwad.sdk.utils.x.putValue(jSONObject, "has_data_v2", i12);
        }
        int i13 = jVar.result;
        if (i13 != 0) {
            com.kwad.sdk.utils.x.putValue(jSONObject, p3.i.f29758c, i13);
        }
        long j26 = jVar.aAn;
        if (j26 != 0) {
            com.kwad.sdk.utils.x.putValue(jSONObject, "response_done_cost", j26);
        }
        String str2 = jVar.aAo;
        if (str2 != null && !str2.equals("")) {
            com.kwad.sdk.utils.x.putValue(jSONObject, MonitorConstants.HOST_IP, jVar.aAo);
        }
        int i14 = jVar.aAp;
        if (i14 != 0) {
            com.kwad.sdk.utils.x.putValue(jSONObject, "ip_type", i14);
        }
        int i15 = jVar.aAq;
        if (i15 != 0) {
            com.kwad.sdk.utils.x.putValue(jSONObject, "recommend_ping_time", i15);
        }
        int i16 = jVar.aAr;
        if (i16 != 0) {
            com.kwad.sdk.utils.x.putValue(jSONObject, "backup_ping_time", i16);
        }
        int i17 = jVar.aAs;
        if (i17 != 0) {
            com.kwad.sdk.utils.x.putValue(jSONObject, "other_ping_time", i17);
        }
        return jSONObject;
    }
}
