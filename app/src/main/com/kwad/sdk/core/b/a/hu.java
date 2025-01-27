package com.kwad.sdk.core.b.a;

import com.kwad.sdk.m.a.a;
import com.vivo.push.PushClientConstants;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public final class hu implements com.kwad.sdk.core.d<a.C0511a> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(a.C0511a c0511a, JSONObject jSONObject) {
        a2(c0511a, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(a.C0511a c0511a, JSONObject jSONObject) {
        return b2(c0511a, jSONObject);
    }

    /* renamed from: a */
    private static void a2(a.C0511a c0511a, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        c0511a.aRS = jSONObject.optString("typeStr");
        Object obj = JSONObject.NULL;
        if (obj.toString().equals(c0511a.aRS)) {
            c0511a.aRS = "";
        }
        c0511a.aRT = jSONObject.optString("valueStr");
        if (obj.toString().equals(c0511a.aRT)) {
            c0511a.aRT = "";
        }
        c0511a.aRU = jSONObject.optString("listValueType");
        if (obj.toString().equals(c0511a.aRU)) {
            c0511a.aRU = "";
        }
        c0511a.aRV = new ArrayList();
        JSONArray optJSONArray = jSONObject.optJSONArray("valueStrList");
        if (optJSONArray != null) {
            for (int i10 = 0; i10 < optJSONArray.length(); i10++) {
                c0511a.aRV.add((String) optJSONArray.opt(i10));
            }
        }
        c0511a.fieldName = jSONObject.optString("fieldName");
        Object obj2 = JSONObject.NULL;
        if (obj2.toString().equals(c0511a.fieldName)) {
            c0511a.fieldName = "";
        }
        c0511a.className = jSONObject.optString(PushClientConstants.TAG_CLASS_NAME);
        if (obj2.toString().equals(c0511a.className)) {
            c0511a.className = "";
        }
        c0511a.aRW = new ArrayList();
        JSONArray optJSONArray2 = jSONObject.optJSONArray("childParamList");
        if (optJSONArray2 != null) {
            for (int i11 = 0; i11 < optJSONArray2.length(); i11++) {
                a.C0511a c0511a2 = new a.C0511a();
                c0511a2.parseJson(optJSONArray2.optJSONObject(i11));
                c0511a.aRW.add(c0511a2);
            }
        }
    }

    /* renamed from: b */
    private static JSONObject b2(a.C0511a c0511a, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        String str = c0511a.aRS;
        if (str != null && !str.equals("")) {
            com.kwad.sdk.utils.x.putValue(jSONObject, "typeStr", c0511a.aRS);
        }
        String str2 = c0511a.aRT;
        if (str2 != null && !str2.equals("")) {
            com.kwad.sdk.utils.x.putValue(jSONObject, "valueStr", c0511a.aRT);
        }
        String str3 = c0511a.aRU;
        if (str3 != null && !str3.equals("")) {
            com.kwad.sdk.utils.x.putValue(jSONObject, "listValueType", c0511a.aRU);
        }
        com.kwad.sdk.utils.x.putValue(jSONObject, "valueStrList", c0511a.aRV);
        String str4 = c0511a.fieldName;
        if (str4 != null && !str4.equals("")) {
            com.kwad.sdk.utils.x.putValue(jSONObject, "fieldName", c0511a.fieldName);
        }
        String str5 = c0511a.className;
        if (str5 != null && !str5.equals("")) {
            com.kwad.sdk.utils.x.putValue(jSONObject, PushClientConstants.TAG_CLASS_NAME, c0511a.className);
        }
        com.kwad.sdk.utils.x.putValue(jSONObject, "childParamList", c0511a.aRW);
        return jSONObject;
    }
}
