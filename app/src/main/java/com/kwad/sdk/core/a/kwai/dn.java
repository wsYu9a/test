package com.kwad.sdk.core.a.kwai;

import com.vivo.ic.dm.Downloads;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public final class dn implements com.kwad.sdk.core.d<com.kwad.sdk.ranger.a.kwai.a> {
    /* renamed from: a */
    private static void a2(com.kwad.sdk.ranger.a.kwai.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        String optString = jSONObject.optString("key");
        aVar.key = optString;
        if (optString == JSONObject.NULL) {
            aVar.key = "";
        }
        aVar.value = jSONObject.optInt(Downloads.RequestHeaders.COLUMN_VALUE);
    }

    /* renamed from: b */
    private static JSONObject b2(com.kwad.sdk.ranger.a.kwai.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        String str = aVar.key;
        if (str != null && !str.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "key", aVar.key);
        }
        int i2 = aVar.value;
        if (i2 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, Downloads.RequestHeaders.COLUMN_VALUE, i2);
        }
        return jSONObject;
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.ranger.a.kwai.a aVar, JSONObject jSONObject) {
        a2(aVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.ranger.a.kwai.a aVar, JSONObject jSONObject) {
        return b2(aVar, jSONObject);
    }
}
