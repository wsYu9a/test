package com.kwad.sdk.core.a.kwai;

import com.kwad.sdk.core.imageloader.ImageLoaderInfo;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public final class ef implements com.kwad.sdk.core.d<ImageLoaderInfo> {
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
        int i2 = imageLoaderInfo.totalCount;
        if (i2 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "total_count", i2);
        }
        int i3 = imageLoaderInfo.failedCount;
        if (i3 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "failed_count", i3);
        }
        int i4 = imageLoaderInfo.successCount;
        if (i4 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "success_count", i4);
        }
        double d2 = imageLoaderInfo.duration;
        if (d2 != 0.0d) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "duration", d2);
        }
        return jSONObject;
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(ImageLoaderInfo imageLoaderInfo, JSONObject jSONObject) {
        a2(imageLoaderInfo, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(ImageLoaderInfo imageLoaderInfo, JSONObject jSONObject) {
        return b2(imageLoaderInfo, jSONObject);
    }
}
