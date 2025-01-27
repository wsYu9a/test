package com.kwad.sdk.core.a.kwai;

import com.opos.acs.st.utils.ErrorContants;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public final class e implements com.kwad.sdk.core.d<com.kwad.sdk.core.webview.c.a.a> {
    /* renamed from: a */
    private static void a2(com.kwad.sdk.core.webview.c.a.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        aVar.TA = jSONObject.optBoolean("clickActionButton");
        aVar.TC = jSONObject.optInt("area");
        aVar.jU = jSONObject.optInt("itemClickType");
        aVar.aqn = jSONObject.optInt("convertPageType", new Integer(ErrorContants.NET_ERROR).intValue());
        com.kwad.sdk.core.webview.c.a.c cVar = new com.kwad.sdk.core.webview.c.a.c();
        aVar.TD = cVar;
        cVar.parseJson(jSONObject.optJSONObject("logParam"));
        aVar.IQ = jSONObject.optBoolean("needReport", new Boolean("true").booleanValue());
        aVar.creativeId = jSONObject.optLong("creativeId", new Long(ErrorContants.NET_ERROR).longValue());
        String optString = jSONObject.optString("liveItemId");
        aVar.IY = optString;
        if (optString == JSONObject.NULL) {
            aVar.IY = "";
        }
        aVar.aqo = jSONObject.optInt("sceneType");
        aVar.adStyle = jSONObject.optInt("adStyle", new Integer(ErrorContants.NET_ERROR).intValue());
    }

    /* renamed from: b */
    private static JSONObject b2(com.kwad.sdk.core.webview.c.a.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        boolean z = aVar.TA;
        if (z) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "clickActionButton", z);
        }
        int i2 = aVar.TC;
        if (i2 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "area", i2);
        }
        int i3 = aVar.jU;
        if (i3 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "itemClickType", i3);
        }
        com.kwad.sdk.utils.t.putValue(jSONObject, "convertPageType", aVar.aqn);
        com.kwad.sdk.utils.t.a(jSONObject, "logParam", aVar.TD);
        com.kwad.sdk.utils.t.putValue(jSONObject, "needReport", aVar.IQ);
        com.kwad.sdk.utils.t.putValue(jSONObject, "creativeId", aVar.creativeId);
        String str = aVar.IY;
        if (str != null && !str.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "liveItemId", aVar.IY);
        }
        int i4 = aVar.aqo;
        if (i4 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "sceneType", i4);
        }
        com.kwad.sdk.utils.t.putValue(jSONObject, "adStyle", aVar.adStyle);
        return jSONObject;
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.webview.c.a.a aVar, JSONObject jSONObject) {
        a2(aVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.webview.c.a.a aVar, JSONObject jSONObject) {
        return b2(aVar, jSONObject);
    }
}
