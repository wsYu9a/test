package com.kwad.sdk.core.b.a;

import com.kwad.components.core.webview.jshandler.at;
import com.ss.android.socialbase.downloader.constants.DBDefinition;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public final class bg implements com.kwad.sdk.core.d<at.a> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(at.a aVar, JSONObject jSONObject) {
        a2(aVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(at.a aVar, JSONObject jSONObject) {
        return b2(aVar, jSONObject);
    }

    /* renamed from: a */
    private static void a2(at.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        aVar.aav = jSONObject.optDouble("progress");
        aVar.status = jSONObject.optInt("status");
        aVar.totalBytes = jSONObject.optLong(DBDefinition.TOTAL_BYTES);
        aVar.soFarBytes = jSONObject.optLong("soFarBytes");
        aVar.aaw = jSONObject.optDouble("realProgress");
    }

    /* renamed from: b */
    private static JSONObject b2(at.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        double d10 = aVar.aav;
        if (d10 != l5.c.f27899e) {
            com.kwad.sdk.utils.x.putValue(jSONObject, "progress", d10);
        }
        int i10 = aVar.status;
        if (i10 != 0) {
            com.kwad.sdk.utils.x.putValue(jSONObject, "status", i10);
        }
        long j10 = aVar.totalBytes;
        if (j10 != 0) {
            com.kwad.sdk.utils.x.putValue(jSONObject, DBDefinition.TOTAL_BYTES, j10);
        }
        long j11 = aVar.soFarBytes;
        if (j11 != 0) {
            com.kwad.sdk.utils.x.putValue(jSONObject, "soFarBytes", j11);
        }
        double d11 = aVar.aaw;
        if (d11 != l5.c.f27899e) {
            com.kwad.sdk.utils.x.putValue(jSONObject, "realProgress", d11);
        }
        return jSONObject;
    }
}
