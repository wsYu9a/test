package com.kwad.sdk.core.a.kwai;

import com.kwad.sdk.core.response.model.AdMatrixInfo;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public final class hf implements com.kwad.sdk.core.d<AdMatrixInfo.RotateDegreeInfo> {
    /* renamed from: a */
    private static void a2(AdMatrixInfo.RotateDegreeInfo rotateDegreeInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        rotateDegreeInfo.rotateDegree = jSONObject.optInt("rotateDegree");
        rotateDegreeInfo.direction = jSONObject.optInt("direction");
    }

    /* renamed from: b */
    private static JSONObject b2(AdMatrixInfo.RotateDegreeInfo rotateDegreeInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        int i2 = rotateDegreeInfo.rotateDegree;
        if (i2 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "rotateDegree", i2);
        }
        int i3 = rotateDegreeInfo.direction;
        if (i3 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "direction", i3);
        }
        return jSONObject;
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(AdMatrixInfo.RotateDegreeInfo rotateDegreeInfo, JSONObject jSONObject) {
        a2(rotateDegreeInfo, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(AdMatrixInfo.RotateDegreeInfo rotateDegreeInfo, JSONObject jSONObject) {
        return b2(rotateDegreeInfo, jSONObject);
    }
}
