package com.kwad.sdk.core.a.kwai;

import com.kwad.components.core.webview.jshandler.ae;
import com.opos.acs.st.utils.ErrorContants;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public final class dw implements com.kwad.sdk.core.d<ae.b> {
    /* renamed from: a */
    private static void a2(ae.b bVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        bVar.creativeId = jSONObject.optLong("creativeId", new Long(ErrorContants.NET_ERROR).longValue());
    }

    /* renamed from: b */
    private static JSONObject b2(ae.b bVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        com.kwad.sdk.utils.t.putValue(jSONObject, "creativeId", bVar.creativeId);
        return jSONObject;
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(ae.b bVar, JSONObject jSONObject) {
        a2(bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(ae.b bVar, JSONObject jSONObject) {
        return b2(bVar, jSONObject);
    }
}
