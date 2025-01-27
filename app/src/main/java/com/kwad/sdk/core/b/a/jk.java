package com.kwad.sdk.core.b.a;

import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public final class jk implements com.kwad.sdk.core.d<com.kwad.sdk.commercial.smallApp.b> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.commercial.smallApp.b bVar, JSONObject jSONObject) {
        a2(bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.commercial.smallApp.b bVar, JSONObject jSONObject) {
        return b2(bVar, jSONObject);
    }

    /* renamed from: a */
    private static void a2(com.kwad.sdk.commercial.smallApp.b bVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        bVar.status = jSONObject.optInt("status");
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
        bVar.ash = jSONObject.optString("small_origin_id");
        if (obj.toString().equals(bVar.ash)) {
            bVar.ash = "";
        }
        bVar.asi = jSONObject.optString("small_app_id");
        if (obj.toString().equals(bVar.asi)) {
            bVar.asi = "";
        }
        bVar.asj = jSONObject.optString("jump_from");
        if (obj.toString().equals(bVar.asj)) {
            bVar.asj = "";
        }
    }

    /* renamed from: b */
    private static JSONObject b2(com.kwad.sdk.commercial.smallApp.b bVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        int i10 = bVar.status;
        if (i10 != 0) {
            com.kwad.sdk.utils.x.putValue(jSONObject, "status", i10);
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
        String str4 = bVar.ash;
        if (str4 != null && !str4.equals("")) {
            com.kwad.sdk.utils.x.putValue(jSONObject, "small_origin_id", bVar.ash);
        }
        String str5 = bVar.asi;
        if (str5 != null && !str5.equals("")) {
            com.kwad.sdk.utils.x.putValue(jSONObject, "small_app_id", bVar.asi);
        }
        String str6 = bVar.asj;
        if (str6 != null && !str6.equals("")) {
            com.kwad.sdk.utils.x.putValue(jSONObject, "jump_from", bVar.asj);
        }
        return jSONObject;
    }
}
