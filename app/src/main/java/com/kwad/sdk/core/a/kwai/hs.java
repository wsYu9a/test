package com.kwad.sdk.core.a.kwai;

import com.kwad.sdk.core.response.model.AdProductInfo;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public final class hs implements com.kwad.sdk.core.d<AdProductInfo.SpikeInfo> {
    /* renamed from: a */
    private static void a2(AdProductInfo.SpikeInfo spikeInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        spikeInfo.endTime = jSONObject.optLong("endTime");
        spikeInfo.soldStock = jSONObject.optInt("soldStock");
        spikeInfo.originalStock = jSONObject.optInt("originalStock");
    }

    /* renamed from: b */
    private static JSONObject b2(AdProductInfo.SpikeInfo spikeInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        long j2 = spikeInfo.endTime;
        if (j2 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "endTime", j2);
        }
        int i2 = spikeInfo.soldStock;
        if (i2 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "soldStock", i2);
        }
        int i3 = spikeInfo.originalStock;
        if (i3 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "originalStock", i3);
        }
        return jSONObject;
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(AdProductInfo.SpikeInfo spikeInfo, JSONObject jSONObject) {
        a2(spikeInfo, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(AdProductInfo.SpikeInfo spikeInfo, JSONObject jSONObject) {
        return b2(spikeInfo, jSONObject);
    }
}
