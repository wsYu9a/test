package com.kwad.sdk.core.b.a;

import com.kwad.components.core.webview.jshandler.WebCardVideoPositionHandler;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public final class ge implements com.kwad.sdk.core.d<WebCardVideoPositionHandler.VideoPosition.KSAdJSCornerModel> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(WebCardVideoPositionHandler.VideoPosition.KSAdJSCornerModel kSAdJSCornerModel, JSONObject jSONObject) {
        a2(kSAdJSCornerModel, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(WebCardVideoPositionHandler.VideoPosition.KSAdJSCornerModel kSAdJSCornerModel, JSONObject jSONObject) {
        return b2(kSAdJSCornerModel, jSONObject);
    }

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
        double d10 = kSAdJSCornerModel.topLeft;
        if (d10 != l5.c.f27899e) {
            com.kwad.sdk.utils.x.putValue(jSONObject, "topLeft", d10);
        }
        double d11 = kSAdJSCornerModel.topRight;
        if (d11 != l5.c.f27899e) {
            com.kwad.sdk.utils.x.putValue(jSONObject, "topRight", d11);
        }
        double d12 = kSAdJSCornerModel.bottomRight;
        if (d12 != l5.c.f27899e) {
            com.kwad.sdk.utils.x.putValue(jSONObject, "bottomRight", d12);
        }
        double d13 = kSAdJSCornerModel.bottomLeft;
        if (d13 != l5.c.f27899e) {
            com.kwad.sdk.utils.x.putValue(jSONObject, "bottomLeft", d13);
        }
        return jSONObject;
    }
}
