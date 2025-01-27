package com.kwad.sdk.core.b.a;

import com.kwad.sdk.core.response.model.AdMatrixInfo;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public final class kg implements com.kwad.sdk.core.d<AdMatrixInfo.StyleInfo> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(AdMatrixInfo.StyleInfo styleInfo, JSONObject jSONObject) {
        a2(styleInfo, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(AdMatrixInfo.StyleInfo styleInfo, JSONObject jSONObject) {
        return b2(styleInfo, jSONObject);
    }

    /* renamed from: a */
    private static void a2(AdMatrixInfo.StyleInfo styleInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        styleInfo.title = jSONObject.optString("title");
        if (JSONObject.NULL.toString().equals(styleInfo.title)) {
            styleInfo.title = "";
        }
    }

    /* renamed from: b */
    private static JSONObject b2(AdMatrixInfo.StyleInfo styleInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        String str = styleInfo.title;
        if (str != null && !str.equals("")) {
            com.kwad.sdk.utils.x.putValue(jSONObject, "title", styleInfo.title);
        }
        return jSONObject;
    }
}
