package com.kwad.sdk.core.b.a;

import com.kwad.sdk.i.a;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public final class iz implements com.kwad.sdk.core.d<a.b> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(a.b bVar, JSONObject jSONObject) {
        a2(bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(a.b bVar, JSONObject jSONObject) {
        return b2(bVar, jSONObject);
    }

    /* renamed from: a */
    private static void a2(a.b bVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        bVar.aNZ = jSONObject.optInt("enable_monitor");
        bVar.aOa = jSONObject.optString("c_sc_name");
        Object obj = JSONObject.NULL;
        if (obj.toString().equals(bVar.aOa)) {
            bVar.aOa = "";
        }
        bVar.aOb = jSONObject.optString("c_pcl_name");
        if (obj.toString().equals(bVar.aOb)) {
            bVar.aOb = "";
        }
        bVar.aOc = jSONObject.optString("m_gam_name");
        if (obj.toString().equals(bVar.aOc)) {
            bVar.aOc = "";
        }
        bVar.aOd = jSONObject.optString("m_gsv_name");
        if (obj.toString().equals(bVar.aOd)) {
            bVar.aOd = "";
        }
        bVar.aOe = jSONObject.optString("m_gpv_name");
        if (obj.toString().equals(bVar.aOe)) {
            bVar.aOe = "";
        }
    }

    /* renamed from: b */
    private static JSONObject b2(a.b bVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        int i10 = bVar.aNZ;
        if (i10 != 0) {
            com.kwad.sdk.utils.x.putValue(jSONObject, "enable_monitor", i10);
        }
        String str = bVar.aOa;
        if (str != null && !str.equals("")) {
            com.kwad.sdk.utils.x.putValue(jSONObject, "c_sc_name", bVar.aOa);
        }
        String str2 = bVar.aOb;
        if (str2 != null && !str2.equals("")) {
            com.kwad.sdk.utils.x.putValue(jSONObject, "c_pcl_name", bVar.aOb);
        }
        String str3 = bVar.aOc;
        if (str3 != null && !str3.equals("")) {
            com.kwad.sdk.utils.x.putValue(jSONObject, "m_gam_name", bVar.aOc);
        }
        String str4 = bVar.aOd;
        if (str4 != null && !str4.equals("")) {
            com.kwad.sdk.utils.x.putValue(jSONObject, "m_gsv_name", bVar.aOd);
        }
        String str5 = bVar.aOe;
        if (str5 != null && !str5.equals("")) {
            com.kwad.sdk.utils.x.putValue(jSONObject, "m_gpv_name", bVar.aOe);
        }
        return jSONObject;
    }
}
