package com.kwad.sdk.core.a.kwai;

import com.kwad.components.core.webview.jshandler.m;
import com.vivo.ic.dm.Downloads;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public final class ij implements com.kwad.sdk.core.d<m.a> {
    /* renamed from: a */
    private static void a2(m.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        String optString = jSONObject.optString("key");
        aVar.key = optString;
        if (optString == JSONObject.NULL) {
            aVar.key = "";
        }
        String optString2 = jSONObject.optString(Downloads.RequestHeaders.COLUMN_VALUE);
        aVar.value = optString2;
        if (optString2 == JSONObject.NULL) {
            aVar.value = "";
        }
    }

    /* renamed from: b */
    private static JSONObject b2(m.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        String str = aVar.key;
        if (str != null && !str.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "key", aVar.key);
        }
        String str2 = aVar.value;
        if (str2 != null && !str2.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, Downloads.RequestHeaders.COLUMN_VALUE, aVar.value);
        }
        return jSONObject;
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(m.a aVar, JSONObject jSONObject) {
        a2(aVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(m.a aVar, JSONObject jSONObject) {
        return b2(aVar, jSONObject);
    }
}
