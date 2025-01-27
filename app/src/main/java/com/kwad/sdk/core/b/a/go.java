package com.kwad.sdk.core.b.a;

import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public final class go implements com.kwad.sdk.core.d<com.kwad.sdk.core.webview.b.a.b> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.webview.b.a.b bVar, JSONObject jSONObject) {
        a2(bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.webview.b.a.b bVar, JSONObject jSONObject) {
        return b2(bVar, jSONObject);
    }

    /* renamed from: a */
    private static void a2(com.kwad.sdk.core.webview.b.a.b bVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        bVar.status = jSONObject.optInt("Status");
        bVar.contentEncoding = jSONObject.optString(m5.c.f28293b0);
        Object obj = JSONObject.NULL;
        if (obj.toString().equals(bVar.contentEncoding)) {
            bVar.contentEncoding = "";
        }
        bVar.aIN = jSONObject.optString("Cache-Control");
        if (obj.toString().equals(bVar.aIN)) {
            bVar.aIN = "";
        }
        bVar.aIL = jSONObject.optString("Content-Type");
        if (obj.toString().equals(bVar.aIL)) {
            bVar.aIL = "";
        }
        com.kwad.sdk.core.webview.b.a.a aVar = new com.kwad.sdk.core.webview.b.a.a();
        bVar.aIO = aVar;
        aVar.parseJson(jSONObject.optJSONObject(TTDownloadField.TT_HEADERS));
    }

    /* renamed from: b */
    private static JSONObject b2(com.kwad.sdk.core.webview.b.a.b bVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        int i10 = bVar.status;
        if (i10 != 0) {
            com.kwad.sdk.utils.x.putValue(jSONObject, "Status", i10);
        }
        String str = bVar.contentEncoding;
        if (str != null && !str.equals("")) {
            com.kwad.sdk.utils.x.putValue(jSONObject, m5.c.f28293b0, bVar.contentEncoding);
        }
        String str2 = bVar.aIN;
        if (str2 != null && !str2.equals("")) {
            com.kwad.sdk.utils.x.putValue(jSONObject, "Cache-Control", bVar.aIN);
        }
        String str3 = bVar.aIL;
        if (str3 != null && !str3.equals("")) {
            com.kwad.sdk.utils.x.putValue(jSONObject, "Content-Type", bVar.aIL);
        }
        com.kwad.sdk.utils.x.a(jSONObject, TTDownloadField.TT_HEADERS, bVar.aIO);
        return jSONObject;
    }
}
