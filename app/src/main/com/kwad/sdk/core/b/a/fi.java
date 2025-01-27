package com.kwad.sdk.core.b.a;

import com.kwad.sdk.core.imageloader.ImageLoaderInfo;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public final class fi implements com.kwad.sdk.core.d<ImageLoaderInfo> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(ImageLoaderInfo imageLoaderInfo, JSONObject jSONObject) {
        a2(imageLoaderInfo, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(ImageLoaderInfo imageLoaderInfo, JSONObject jSONObject) {
        return b2(imageLoaderInfo, jSONObject);
    }

    /* renamed from: a */
    private static void a2(ImageLoaderInfo imageLoaderInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        imageLoaderInfo.totalCount = jSONObject.optInt("total_count");
        imageLoaderInfo.failedCount = jSONObject.optInt("failed_count");
        imageLoaderInfo.successCount = jSONObject.optInt("success_count");
        imageLoaderInfo.duration = jSONObject.optDouble("duration");
    }

    /* renamed from: b */
    private static JSONObject b2(ImageLoaderInfo imageLoaderInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        int i10 = imageLoaderInfo.totalCount;
        if (i10 != 0) {
            com.kwad.sdk.utils.x.putValue(jSONObject, "total_count", i10);
        }
        int i11 = imageLoaderInfo.failedCount;
        if (i11 != 0) {
            com.kwad.sdk.utils.x.putValue(jSONObject, "failed_count", i11);
        }
        int i12 = imageLoaderInfo.successCount;
        if (i12 != 0) {
            com.kwad.sdk.utils.x.putValue(jSONObject, "success_count", i12);
        }
        double d10 = imageLoaderInfo.duration;
        if (d10 != l5.c.f27899e) {
            com.kwad.sdk.utils.x.putValue(jSONObject, "duration", d10);
        }
        return jSONObject;
    }
}
