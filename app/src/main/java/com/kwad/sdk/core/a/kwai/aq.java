package com.kwad.sdk.core.a.kwai;

import androidx.core.app.NotificationCompat;
import com.kwad.components.core.webview.jshandler.ak;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public final class aq implements com.kwad.sdk.core.d<ak.a> {
    /* renamed from: a */
    private static void a2(ak.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        aVar.TI = jSONObject.optDouble(NotificationCompat.CATEGORY_PROGRESS);
        aVar.status = jSONObject.optInt("status");
    }

    /* renamed from: b */
    private static JSONObject b2(ak.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        double d2 = aVar.TI;
        if (d2 != 0.0d) {
            com.kwad.sdk.utils.t.putValue(jSONObject, NotificationCompat.CATEGORY_PROGRESS, d2);
        }
        int i2 = aVar.status;
        if (i2 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "status", i2);
        }
        return jSONObject;
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(ak.a aVar, JSONObject jSONObject) {
        a2(aVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(ak.a aVar, JSONObject jSONObject) {
        return b2(aVar, jSONObject);
    }
}
