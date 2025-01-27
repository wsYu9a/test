package com.kwad.sdk.core.a.kwai;

import com.kwad.components.core.webview.jshandler.WebCardVideoPositionHandler;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public final class ew implements com.kwad.sdk.core.d<WebCardVideoPositionHandler.VideoPosition.KSAdJSCornerModel> {
    /* renamed from: a */
    private static void a2(WebCardVideoPositionHandler.VideoPosition.KSAdJSCornerModel kSAdJSCornerModel, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        kSAdJSCornerModel.topLeft = jSONObject.optDouble("topLeft");
        kSAdJSCornerModel.topRight = jSONObject.optDouble("topRight");
        kSAdJSCornerModel.bottomRight = jSONObject.optDouble("bottomRight");
        kSAdJSCornerModel.bottomLeft = jSONObject.optDouble("bottomLeft");
    }

    /* renamed from: b */
    private static JSONObject b2(WebCardVideoPositionHandler.VideoPosition.KSAdJSCornerModel kSAdJSCornerModel, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        double d2 = kSAdJSCornerModel.topLeft;
        if (d2 != 0.0d) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "topLeft", d2);
        }
        double d3 = kSAdJSCornerModel.topRight;
        if (d3 != 0.0d) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "topRight", d3);
        }
        double d4 = kSAdJSCornerModel.bottomRight;
        if (d4 != 0.0d) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "bottomRight", d4);
        }
        double d5 = kSAdJSCornerModel.bottomLeft;
        if (d5 != 0.0d) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "bottomLeft", d5);
        }
        return jSONObject;
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(WebCardVideoPositionHandler.VideoPosition.KSAdJSCornerModel kSAdJSCornerModel, JSONObject jSONObject) {
        a2(kSAdJSCornerModel, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(WebCardVideoPositionHandler.VideoPosition.KSAdJSCornerModel kSAdJSCornerModel, JSONObject jSONObject) {
        return b2(kSAdJSCornerModel, jSONObject);
    }
}
