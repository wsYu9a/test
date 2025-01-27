package com.kwad.sdk.core.b.a;

import com.kwad.components.core.webview.jshandler.l;
import com.ss.android.socialbase.downloader.constants.DBDefinition;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public final class fn implements com.kwad.sdk.core.d<l.b> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(l.b bVar, JSONObject jSONObject) {
        a2(bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(l.b bVar, JSONObject jSONObject) {
        return b2(bVar, jSONObject);
    }

    /* renamed from: a */
    private static void a2(l.b bVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        bVar.status = jSONObject.optInt("status");
        bVar.progress = jSONObject.optInt("progress");
        bVar.soFarBytes = jSONObject.optLong("soFarBytes");
        bVar.totalBytes = jSONObject.optLong(DBDefinition.TOTAL_BYTES);
        bVar.YQ = jSONObject.optInt("realProgress");
    }

    /* renamed from: b */
    private static JSONObject b2(l.b bVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        int i10 = bVar.status;
        if (i10 != 0) {
            com.kwad.sdk.utils.x.putValue(jSONObject, "status", i10);
        }
        int i11 = bVar.progress;
        if (i11 != 0) {
            com.kwad.sdk.utils.x.putValue(jSONObject, "progress", i11);
        }
        long j10 = bVar.soFarBytes;
        if (j10 != 0) {
            com.kwad.sdk.utils.x.putValue(jSONObject, "soFarBytes", j10);
        }
        long j11 = bVar.totalBytes;
        if (j11 != 0) {
            com.kwad.sdk.utils.x.putValue(jSONObject, DBDefinition.TOTAL_BYTES, j11);
        }
        int i12 = bVar.YQ;
        if (i12 != 0) {
            com.kwad.sdk.utils.x.putValue(jSONObject, "realProgress", i12);
        }
        return jSONObject;
    }
}
