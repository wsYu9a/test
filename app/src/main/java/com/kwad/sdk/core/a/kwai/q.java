package com.kwad.sdk.core.a.kwai;

import com.kwad.components.core.webview.jshandler.o;
import com.opos.acs.st.utils.ErrorContants;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public final class q implements com.kwad.sdk.core.d<o.a> {
    /* renamed from: a */
    private static void a2(o.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        aVar.creativeId = jSONObject.optLong("creativeId", new Long(ErrorContants.NET_ERROR).longValue());
        aVar.adStyle = jSONObject.optInt("adStyle", new Integer(ErrorContants.NET_ERROR).intValue());
    }

    /* renamed from: b */
    private static JSONObject b2(o.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        com.kwad.sdk.utils.t.putValue(jSONObject, "creativeId", aVar.creativeId);
        com.kwad.sdk.utils.t.putValue(jSONObject, "adStyle", aVar.adStyle);
        return jSONObject;
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(o.a aVar, JSONObject jSONObject) {
        a2(aVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(o.a aVar, JSONObject jSONObject) {
        return b2(aVar, jSONObject);
    }
}
