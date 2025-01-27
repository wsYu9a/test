package com.kwad.sdk.core.a.kwai;

import com.vivo.ic.dm.Downloads;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public final class fe implements com.kwad.sdk.core.d<com.kwad.sdk.core.webview.a.kwai.b> {
    /* renamed from: a */
    private static void a2(com.kwad.sdk.core.webview.a.kwai.b bVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        bVar.status = jSONObject.optInt("Status");
        String optString = jSONObject.optString("Content-Encoding");
        bVar.contentEncoding = optString;
        if (optString == JSONObject.NULL) {
            bVar.contentEncoding = "";
        }
        String optString2 = jSONObject.optString("Cache-Control");
        bVar.apW = optString2;
        if (optString2 == JSONObject.NULL) {
            bVar.apW = "";
        }
        String optString3 = jSONObject.optString("Content-Type");
        bVar.apU = optString3;
        if (optString3 == JSONObject.NULL) {
            bVar.apU = "";
        }
        com.kwad.sdk.core.webview.a.kwai.a aVar = new com.kwad.sdk.core.webview.a.kwai.a();
        bVar.apX = aVar;
        aVar.parseJson(jSONObject.optJSONObject(Downloads.RequestHeaders.URI_SEGMENT));
    }

    /* renamed from: b */
    private static JSONObject b2(com.kwad.sdk.core.webview.a.kwai.b bVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        int i2 = bVar.status;
        if (i2 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "Status", i2);
        }
        String str = bVar.contentEncoding;
        if (str != null && !str.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "Content-Encoding", bVar.contentEncoding);
        }
        String str2 = bVar.apW;
        if (str2 != null && !str2.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "Cache-Control", bVar.apW);
        }
        String str3 = bVar.apU;
        if (str3 != null && !str3.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "Content-Type", bVar.apU);
        }
        com.kwad.sdk.utils.t.a(jSONObject, Downloads.RequestHeaders.URI_SEGMENT, bVar.apX);
        return jSONObject;
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.webview.a.kwai.b bVar, JSONObject jSONObject) {
        a2(bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.webview.a.kwai.b bVar, JSONObject jSONObject) {
        return b2(bVar, jSONObject);
    }
}
