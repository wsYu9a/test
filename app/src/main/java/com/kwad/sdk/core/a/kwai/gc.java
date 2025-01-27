package com.kwad.sdk.core.a.kwai;

import com.kwad.sdk.core.response.model.PageInfo;
import com.oplus.quickgame.sdk.hall.Constant;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public final class gc implements com.kwad.sdk.core.d<PageInfo> {
    /* renamed from: a */
    private static void a2(PageInfo pageInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        pageInfo.pageType = jSONObject.optInt(Constant.Param.KEY_RPK_PAGE_TYPE);
    }

    /* renamed from: b */
    private static JSONObject b2(PageInfo pageInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        int i2 = pageInfo.pageType;
        if (i2 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, Constant.Param.KEY_RPK_PAGE_TYPE, i2);
        }
        return jSONObject;
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(PageInfo pageInfo, JSONObject jSONObject) {
        a2(pageInfo, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(PageInfo pageInfo, JSONObject jSONObject) {
        return b2(pageInfo, jSONObject);
    }
}
