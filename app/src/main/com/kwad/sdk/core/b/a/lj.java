package com.kwad.sdk.core.b.a;

import com.kwad.components.core.webview.jshandler.WebCardVideoPositionHandler;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public final class lj implements com.kwad.sdk.core.d<WebCardVideoPositionHandler.VideoPosition> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(WebCardVideoPositionHandler.VideoPosition videoPosition, JSONObject jSONObject) {
        a2(videoPosition, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(WebCardVideoPositionHandler.VideoPosition videoPosition, JSONObject jSONObject) {
        return b2(videoPosition, jSONObject);
    }

    /* renamed from: a */
    private static void a2(WebCardVideoPositionHandler.VideoPosition videoPosition, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        videoPosition.leftMarginRation = jSONObject.optDouble("leftMarginRation");
        videoPosition.topMarginRation = jSONObject.optDouble("topMarginRation");
        videoPosition.widthRation = jSONObject.optDouble("widthRation");
        videoPosition.heightWidthRation = jSONObject.optDouble("heightWidthRation");
        videoPosition.leftMargin = jSONObject.optInt("leftMargin");
        videoPosition.topMargin = jSONObject.optInt("topMargin");
        videoPosition.width = jSONObject.optInt("width");
        videoPosition.height = jSONObject.optInt("height");
        videoPosition.borderRadius = jSONObject.optInt("borderRadius");
    }

    /* renamed from: b */
    private static JSONObject b2(WebCardVideoPositionHandler.VideoPosition videoPosition, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        double d10 = videoPosition.leftMarginRation;
        if (d10 != l5.c.f27899e) {
            com.kwad.sdk.utils.x.putValue(jSONObject, "leftMarginRation", d10);
        }
        double d11 = videoPosition.topMarginRation;
        if (d11 != l5.c.f27899e) {
            com.kwad.sdk.utils.x.putValue(jSONObject, "topMarginRation", d11);
        }
        double d12 = videoPosition.widthRation;
        if (d12 != l5.c.f27899e) {
            com.kwad.sdk.utils.x.putValue(jSONObject, "widthRation", d12);
        }
        double d13 = videoPosition.heightWidthRation;
        if (d13 != l5.c.f27899e) {
            com.kwad.sdk.utils.x.putValue(jSONObject, "heightWidthRation", d13);
        }
        int i10 = videoPosition.leftMargin;
        if (i10 != 0) {
            com.kwad.sdk.utils.x.putValue(jSONObject, "leftMargin", i10);
        }
        int i11 = videoPosition.topMargin;
        if (i11 != 0) {
            com.kwad.sdk.utils.x.putValue(jSONObject, "topMargin", i11);
        }
        int i12 = videoPosition.width;
        if (i12 != 0) {
            com.kwad.sdk.utils.x.putValue(jSONObject, "width", i12);
        }
        int i13 = videoPosition.height;
        if (i13 != 0) {
            com.kwad.sdk.utils.x.putValue(jSONObject, "height", i13);
        }
        int i14 = videoPosition.borderRadius;
        if (i14 != 0) {
            com.kwad.sdk.utils.x.putValue(jSONObject, "borderRadius", i14);
        }
        return jSONObject;
    }
}
