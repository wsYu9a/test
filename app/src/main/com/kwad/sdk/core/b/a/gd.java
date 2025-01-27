package com.kwad.sdk.core.b.a;

import com.kwad.sdk.kgeo.KGeoInfo;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public final class gd implements com.kwad.sdk.core.d<KGeoInfo> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(KGeoInfo kGeoInfo, JSONObject jSONObject) {
        a2(kGeoInfo, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(KGeoInfo kGeoInfo, JSONObject jSONObject) {
        return b2(kGeoInfo, jSONObject);
    }

    /* renamed from: a */
    private static void a2(KGeoInfo kGeoInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        kGeoInfo.latitude = jSONObject.optDouble("latitude");
        kGeoInfo.longitude = jSONObject.optDouble("longitude");
        kGeoInfo.range = jSONObject.optInt("range");
        kGeoInfo.rate = jSONObject.optInt("rate");
    }

    /* renamed from: b */
    private static JSONObject b2(KGeoInfo kGeoInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        double d10 = kGeoInfo.latitude;
        if (d10 != l5.c.f27899e) {
            com.kwad.sdk.utils.x.putValue(jSONObject, "latitude", d10);
        }
        double d11 = kGeoInfo.longitude;
        if (d11 != l5.c.f27899e) {
            com.kwad.sdk.utils.x.putValue(jSONObject, "longitude", d11);
        }
        int i10 = kGeoInfo.range;
        if (i10 != 0) {
            com.kwad.sdk.utils.x.putValue(jSONObject, "range", i10);
        }
        int i11 = kGeoInfo.rate;
        if (i11 != 0) {
            com.kwad.sdk.utils.x.putValue(jSONObject, "rate", i11);
        }
        return jSONObject;
    }
}
