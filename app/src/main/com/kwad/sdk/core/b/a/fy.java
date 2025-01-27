package com.kwad.sdk.core.b.a;

import com.kwad.components.core.webview.jshandler.ao;
import com.ss.android.socialbase.downloader.constants.DBDefinition;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public final class fy implements com.kwad.sdk.core.d<ao.b> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(ao.b bVar, JSONObject jSONObject) {
        a2(bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(ao.b bVar, JSONObject jSONObject) {
        return b2(bVar, jSONObject);
    }

    /* renamed from: a */
    private static void a2(ao.b bVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        bVar.aav = jSONObject.optDouble("progress");
        bVar.status = jSONObject.optInt("status");
        bVar.totalBytes = jSONObject.optLong(DBDefinition.TOTAL_BYTES);
        bVar.soFarBytes = jSONObject.optLong("soFarBytes");
        bVar.aaw = jSONObject.optDouble("realProgress");
    }

    /* renamed from: b */
    private static JSONObject b2(ao.b bVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        double d10 = bVar.aav;
        if (d10 != l5.c.f27899e) {
            com.kwad.sdk.utils.x.putValue(jSONObject, "progress", d10);
        }
        int i10 = bVar.status;
        if (i10 != 0) {
            com.kwad.sdk.utils.x.putValue(jSONObject, "status", i10);
        }
        long j10 = bVar.totalBytes;
        if (j10 != 0) {
            com.kwad.sdk.utils.x.putValue(jSONObject, DBDefinition.TOTAL_BYTES, j10);
        }
        long j11 = bVar.soFarBytes;
        if (j11 != 0) {
            com.kwad.sdk.utils.x.putValue(jSONObject, "soFarBytes", j11);
        }
        double d11 = bVar.aaw;
        if (d11 != l5.c.f27899e) {
            com.kwad.sdk.utils.x.putValue(jSONObject, "realProgress", d11);
        }
        return jSONObject;
    }
}
