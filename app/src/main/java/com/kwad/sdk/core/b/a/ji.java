package com.kwad.sdk.core.b.a;

import com.kwad.sdk.core.response.model.AdMatrixInfo;
import com.martian.mibook.ui.colorpicker.ColorPicker;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public final class ji implements com.kwad.sdk.core.d<AdMatrixInfo.SlideInfo> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(AdMatrixInfo.SlideInfo slideInfo, JSONObject jSONObject) {
        a2(slideInfo, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(AdMatrixInfo.SlideInfo slideInfo, JSONObject jSONObject) {
        return b2(slideInfo, jSONObject);
    }

    /* renamed from: a */
    private static void a2(AdMatrixInfo.SlideInfo slideInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        slideInfo.angle = new ArrayList();
        JSONArray optJSONArray = jSONObject.optJSONArray(ColorPicker.K);
        if (optJSONArray != null) {
            for (int i10 = 0; i10 < optJSONArray.length(); i10++) {
                slideInfo.angle.add((Integer) optJSONArray.opt(i10));
            }
        }
    }

    /* renamed from: b */
    private static JSONObject b2(AdMatrixInfo.SlideInfo slideInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        com.kwad.sdk.utils.x.putValue(jSONObject, ColorPicker.K, slideInfo.angle);
        return jSONObject;
    }
}
