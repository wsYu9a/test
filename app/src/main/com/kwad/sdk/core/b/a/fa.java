package com.kwad.sdk.core.b.a;

import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public final class fa implements com.kwad.sdk.core.d<com.kwad.sdk.commercial.g.b> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.commercial.g.b bVar, JSONObject jSONObject) {
        a2(bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.commercial.g.b bVar, JSONObject jSONObject) {
        return b2(bVar, jSONObject);
    }

    /* renamed from: a */
    private static void a2(com.kwad.sdk.commercial.g.b bVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        bVar.status = jSONObject.optInt("status");
        bVar.Qq = jSONObject.optInt("landing_page_type");
        bVar.url = jSONObject.optString("url");
        Object obj = JSONObject.NULL;
        if (obj.toString().equals(bVar.url)) {
            bVar.url = "";
        }
        bVar.arD = jSONObject.optString(MonitorConstants.URL_HOST);
        if (obj.toString().equals(bVar.arD)) {
            bVar.arD = "";
        }
        bVar.arK = jSONObject.optString(MonitorConstants.URL_PATH);
        if (obj.toString().equals(bVar.arK)) {
            bVar.arK = "";
        }
    }

    /* renamed from: b */
    private static JSONObject b2(com.kwad.sdk.commercial.g.b bVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        int i10 = bVar.status;
        if (i10 != 0) {
            com.kwad.sdk.utils.x.putValue(jSONObject, "status", i10);
        }
        int i11 = bVar.Qq;
        if (i11 != 0) {
            com.kwad.sdk.utils.x.putValue(jSONObject, "landing_page_type", i11);
        }
        String str = bVar.url;
        if (str != null && !str.equals("")) {
            com.kwad.sdk.utils.x.putValue(jSONObject, "url", bVar.url);
        }
        String str2 = bVar.arD;
        if (str2 != null && !str2.equals("")) {
            com.kwad.sdk.utils.x.putValue(jSONObject, MonitorConstants.URL_HOST, bVar.arD);
        }
        String str3 = bVar.arK;
        if (str3 != null && !str3.equals("")) {
            com.kwad.sdk.utils.x.putValue(jSONObject, MonitorConstants.URL_PATH, bVar.arK);
        }
        return jSONObject;
    }
}
