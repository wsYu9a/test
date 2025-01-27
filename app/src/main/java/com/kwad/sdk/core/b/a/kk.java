package com.kwad.sdk.core.b.a;

import com.kwad.sdk.core.g.a;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public final class kk implements com.kwad.sdk.core.d<a.C0496a> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(a.C0496a c0496a, JSONObject jSONObject) {
        a2(c0496a, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(a.C0496a c0496a, JSONObject jSONObject) {
        return b2(c0496a, jSONObject);
    }

    /* renamed from: a */
    private static void a2(a.C0496a c0496a, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        c0496a.aFn = new ArrayList();
        JSONArray optJSONArray = jSONObject.optJSONArray("sdk_version");
        if (optJSONArray != null) {
            for (int i10 = 0; i10 < optJSONArray.length(); i10++) {
                c0496a.aFn.add((String) optJSONArray.opt(i10));
            }
        }
        c0496a.aFo = jSONObject.optInt(com.umeng.analytics.pro.bt.f23629y);
        c0496a.aFp = new ArrayList();
        JSONArray optJSONArray2 = jSONObject.optJSONArray("abi");
        if (optJSONArray2 != null) {
            for (int i11 = 0; i11 < optJSONArray2.length(); i11++) {
                c0496a.aFp.add((String) optJSONArray2.opt(i11));
            }
        }
        c0496a.aFq = new ArrayList();
        JSONArray optJSONArray3 = jSONObject.optJSONArray(com.baidu.mobads.sdk.internal.bm.f6905j);
        if (optJSONArray3 != null) {
            for (int i12 = 0; i12 < optJSONArray3.length(); i12++) {
                c0496a.aFq.add((String) optJSONArray3.opt(i12));
            }
        }
    }

    /* renamed from: b */
    private static JSONObject b2(a.C0496a c0496a, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        com.kwad.sdk.utils.x.putValue(jSONObject, "sdk_version", c0496a.aFn);
        int i10 = c0496a.aFo;
        if (i10 != 0) {
            com.kwad.sdk.utils.x.putValue(jSONObject, com.umeng.analytics.pro.bt.f23629y, i10);
        }
        com.kwad.sdk.utils.x.putValue(jSONObject, "abi", c0496a.aFp);
        com.kwad.sdk.utils.x.putValue(jSONObject, com.baidu.mobads.sdk.internal.bm.f6905j, c0496a.aFq);
        return jSONObject;
    }
}
