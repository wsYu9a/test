package com.kwad.sdk.core.a.kwai;

import com.kwad.sdk.g.b;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public final class hj implements com.kwad.sdk.core.d<b.C0228b> {
    /* renamed from: a */
    private static void a2(b.C0228b c0228b, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        c0228b.aul = jSONObject.optInt("enable_monitor");
        String optString = jSONObject.optString("c_sc_name");
        c0228b.aum = optString;
        if (optString == JSONObject.NULL) {
            c0228b.aum = "";
        }
        String optString2 = jSONObject.optString("c_pcl_name");
        c0228b.aun = optString2;
        if (optString2 == JSONObject.NULL) {
            c0228b.aun = "";
        }
        String optString3 = jSONObject.optString("m_gam_name");
        c0228b.auo = optString3;
        if (optString3 == JSONObject.NULL) {
            c0228b.auo = "";
        }
        String optString4 = jSONObject.optString("m_gsv_name");
        c0228b.aup = optString4;
        if (optString4 == JSONObject.NULL) {
            c0228b.aup = "";
        }
        String optString5 = jSONObject.optString("m_gpv_name");
        c0228b.auq = optString5;
        if (optString5 == JSONObject.NULL) {
            c0228b.auq = "";
        }
    }

    /* renamed from: b */
    private static JSONObject b2(b.C0228b c0228b, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        int i2 = c0228b.aul;
        if (i2 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "enable_monitor", i2);
        }
        String str = c0228b.aum;
        if (str != null && !str.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "c_sc_name", c0228b.aum);
        }
        String str2 = c0228b.aun;
        if (str2 != null && !str2.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "c_pcl_name", c0228b.aun);
        }
        String str3 = c0228b.auo;
        if (str3 != null && !str3.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "m_gam_name", c0228b.auo);
        }
        String str4 = c0228b.aup;
        if (str4 != null && !str4.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "m_gsv_name", c0228b.aup);
        }
        String str5 = c0228b.auq;
        if (str5 != null && !str5.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "m_gpv_name", c0228b.auq);
        }
        return jSONObject;
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(b.C0228b c0228b, JSONObject jSONObject) {
        a2(c0228b, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(b.C0228b c0228b, JSONObject jSONObject) {
        return b2(c0228b, jSONObject);
    }
}
