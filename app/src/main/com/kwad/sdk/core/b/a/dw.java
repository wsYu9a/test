package com.kwad.sdk.core.b.a;

import com.kwad.sdk.core.response.model.AdStyleInfo;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public final class dw implements com.kwad.sdk.core.d<AdStyleInfo.ExtraDisplayInfo> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(AdStyleInfo.ExtraDisplayInfo extraDisplayInfo, JSONObject jSONObject) {
        a2(extraDisplayInfo, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(AdStyleInfo.ExtraDisplayInfo extraDisplayInfo, JSONObject jSONObject) {
        return b2(extraDisplayInfo, jSONObject);
    }

    /* renamed from: a */
    private static void a2(AdStyleInfo.ExtraDisplayInfo extraDisplayInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        extraDisplayInfo.exposeTagInfoList = new ArrayList();
        JSONArray optJSONArray = jSONObject.optJSONArray("exposeTagInfoList");
        if (optJSONArray != null) {
            for (int i10 = 0; i10 < optJSONArray.length(); i10++) {
                AdStyleInfo.ExposeTagInfo exposeTagInfo = new AdStyleInfo.ExposeTagInfo();
                exposeTagInfo.parseJson(optJSONArray.optJSONObject(i10));
                extraDisplayInfo.exposeTagInfoList.add(exposeTagInfo);
            }
        }
    }

    /* renamed from: b */
    private static JSONObject b2(AdStyleInfo.ExtraDisplayInfo extraDisplayInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        com.kwad.sdk.utils.x.putValue(jSONObject, "exposeTagInfoList", extraDisplayInfo.exposeTagInfoList);
        return jSONObject;
    }
}
