package com.kwad.sdk.core.a.kwai;

import androidx.core.app.NotificationCompat;
import com.kwad.components.core.webview.jshandler.af;
import com.ss.android.socialbase.downloader.constants.DBDefinition;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public final class es implements com.kwad.sdk.core.d<af.b> {
    /* renamed from: a */
    private static void a2(af.b bVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        bVar.TI = jSONObject.optDouble(NotificationCompat.CATEGORY_PROGRESS);
        bVar.status = jSONObject.optInt("status");
        bVar.totalBytes = jSONObject.optLong(DBDefinition.TOTAL_BYTES);
    }

    /* renamed from: b */
    private static JSONObject b2(af.b bVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        double d2 = bVar.TI;
        if (d2 != 0.0d) {
            com.kwad.sdk.utils.t.putValue(jSONObject, NotificationCompat.CATEGORY_PROGRESS, d2);
        }
        int i2 = bVar.status;
        if (i2 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "status", i2);
        }
        long j2 = bVar.totalBytes;
        if (j2 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, DBDefinition.TOTAL_BYTES, j2);
        }
        return jSONObject;
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(af.b bVar, JSONObject jSONObject) {
        a2(bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(af.b bVar, JSONObject jSONObject) {
        return b2(bVar, jSONObject);
    }
}
