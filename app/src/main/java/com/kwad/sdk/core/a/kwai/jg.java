package com.kwad.sdk.core.a.kwai;

import com.kwad.components.core.webview.jshandler.WebCardVideoPositionHandler;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public final class jg implements com.kwad.sdk.core.d<WebCardVideoPositionHandler.VideoPosition> {
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
        double d2 = videoPosition.leftMarginRation;
        if (d2 != 0.0d) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "leftMarginRation", d2);
        }
        double d3 = videoPosition.topMarginRation;
        if (d3 != 0.0d) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "topMarginRation", d3);
        }
        double d4 = videoPosition.widthRation;
        if (d4 != 0.0d) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "widthRation", d4);
        }
        double d5 = videoPosition.heightWidthRation;
        if (d5 != 0.0d) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "heightWidthRation", d5);
        }
        int i2 = videoPosition.leftMargin;
        if (i2 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "leftMargin", i2);
        }
        int i3 = videoPosition.topMargin;
        if (i3 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "topMargin", i3);
        }
        int i4 = videoPosition.width;
        if (i4 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "width", i4);
        }
        int i5 = videoPosition.height;
        if (i5 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "height", i5);
        }
        int i6 = videoPosition.borderRadius;
        if (i6 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "borderRadius", i6);
        }
        return jSONObject;
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(WebCardVideoPositionHandler.VideoPosition videoPosition, JSONObject jSONObject) {
        a2(videoPosition, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(WebCardVideoPositionHandler.VideoPosition videoPosition, JSONObject jSONObject) {
        return b2(videoPosition, jSONObject);
    }
}
