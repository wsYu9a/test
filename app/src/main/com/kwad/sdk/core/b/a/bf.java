package com.kwad.sdk.core.b.a;

import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public final class bf implements com.kwad.sdk.core.d<com.kwad.sdk.commercial.a.b> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.commercial.a.b bVar, JSONObject jSONObject) {
        a2(bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.commercial.a.b bVar, JSONObject jSONObject) {
        return b2(bVar, jSONObject);
    }

    /* renamed from: a */
    private static void a2(com.kwad.sdk.commercial.a.b bVar, JSONObject jSONObject) {
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
        bVar.downloadId = jSONObject.optString(MonitorConstants.EXTRA_DOWNLOAD_ID);
        if (obj.toString().equals(bVar.downloadId)) {
            bVar.downloadId = "";
        }
        bVar.arE = jSONObject.optString("apk_package");
        if (obj.toString().equals(bVar.arE)) {
            bVar.arE = "";
        }
        bVar.arF = jSONObject.optString("apk_name");
        if (obj.toString().equals(bVar.arF)) {
            bVar.arF = "";
        }
        bVar.arG = jSONObject.optLong("apk_size");
        bVar.downloadTime = jSONObject.optLong(MonitorConstants.EXTRA_DOWNLOAD_TIME);
        bVar.arH = jSONObject.optLong("apk_cur_size");
        bVar.arI = jSONObject.optInt("apk_install_type");
        bVar.arJ = jSONObject.optInt("apk_install_source");
    }

    /* renamed from: b */
    private static JSONObject b2(com.kwad.sdk.commercial.a.b bVar, JSONObject jSONObject) {
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
        String str3 = bVar.downloadId;
        if (str3 != null && !str3.equals("")) {
            com.kwad.sdk.utils.x.putValue(jSONObject, MonitorConstants.EXTRA_DOWNLOAD_ID, bVar.downloadId);
        }
        String str4 = bVar.arE;
        if (str4 != null && !str4.equals("")) {
            com.kwad.sdk.utils.x.putValue(jSONObject, "apk_package", bVar.arE);
        }
        String str5 = bVar.arF;
        if (str5 != null && !str5.equals("")) {
            com.kwad.sdk.utils.x.putValue(jSONObject, "apk_name", bVar.arF);
        }
        long j10 = bVar.arG;
        if (j10 != 0) {
            com.kwad.sdk.utils.x.putValue(jSONObject, "apk_size", j10);
        }
        long j11 = bVar.downloadTime;
        if (j11 != 0) {
            com.kwad.sdk.utils.x.putValue(jSONObject, MonitorConstants.EXTRA_DOWNLOAD_TIME, j11);
        }
        long j12 = bVar.arH;
        if (j12 != 0) {
            com.kwad.sdk.utils.x.putValue(jSONObject, "apk_cur_size", j12);
        }
        int i11 = bVar.arI;
        if (i11 != 0) {
            com.kwad.sdk.utils.x.putValue(jSONObject, "apk_install_type", i11);
        }
        int i12 = bVar.arJ;
        if (i12 != 0) {
            com.kwad.sdk.utils.x.putValue(jSONObject, "apk_install_source", i12);
        }
        return jSONObject;
    }
}
