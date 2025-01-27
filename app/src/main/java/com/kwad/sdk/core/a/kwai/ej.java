package com.kwad.sdk.core.a.kwai;

import androidx.core.app.NotificationCompat;
import com.kwad.components.core.webview.jshandler.h;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public final class ej implements com.kwad.sdk.core.d<h.b> {
    /* renamed from: a */
    private static void a2(h.b bVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        bVar.status = jSONObject.optInt("status");
        bVar.progress = jSONObject.optInt(NotificationCompat.CATEGORY_PROGRESS);
    }

    /* renamed from: b */
    private static JSONObject b2(h.b bVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        int i2 = bVar.status;
        if (i2 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "status", i2);
        }
        int i3 = bVar.progress;
        if (i3 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, NotificationCompat.CATEGORY_PROGRESS, i3);
        }
        return jSONObject;
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(h.b bVar, JSONObject jSONObject) {
        a2(bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(h.b bVar, JSONObject jSONObject) {
        return b2(bVar, jSONObject);
    }
}
