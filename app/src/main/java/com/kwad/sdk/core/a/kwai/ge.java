package com.kwad.sdk.core.a.kwai;

import com.kwad.sdk.ranger.kwai.a;
import com.vivo.push.PushClientConstants;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public final class ge implements com.kwad.sdk.core.d<a.C0230a> {
    /* renamed from: a */
    private static void a2(a.C0230a c0230a, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        String optString = jSONObject.optString("typeStr");
        c0230a.ayu = optString;
        if (optString == JSONObject.NULL) {
            c0230a.ayu = "";
        }
        String optString2 = jSONObject.optString("valueStr");
        c0230a.ayv = optString2;
        if (optString2 == JSONObject.NULL) {
            c0230a.ayv = "";
        }
        String optString3 = jSONObject.optString("listValueType");
        c0230a.ayw = optString3;
        if (optString3 == JSONObject.NULL) {
            c0230a.ayw = "";
        }
        c0230a.ayx = new ArrayList();
        JSONArray optJSONArray = jSONObject.optJSONArray("valueStrList");
        if (optJSONArray != null) {
            for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
                c0230a.ayx.add((String) optJSONArray.opt(i2));
            }
        }
        String optString4 = jSONObject.optString("fieldName");
        c0230a.fieldName = optString4;
        if (optString4 == JSONObject.NULL) {
            c0230a.fieldName = "";
        }
        String optString5 = jSONObject.optString(PushClientConstants.TAG_CLASS_NAME);
        c0230a.className = optString5;
        if (optString5 == JSONObject.NULL) {
            c0230a.className = "";
        }
        c0230a.ayy = new ArrayList();
        JSONArray optJSONArray2 = jSONObject.optJSONArray("childParamList");
        if (optJSONArray2 != null) {
            for (int i3 = 0; i3 < optJSONArray2.length(); i3++) {
                a.C0230a c0230a2 = new a.C0230a();
                c0230a2.parseJson(optJSONArray2.optJSONObject(i3));
                c0230a.ayy.add(c0230a2);
            }
        }
    }

    /* renamed from: b */
    private static JSONObject b2(a.C0230a c0230a, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        String str = c0230a.ayu;
        if (str != null && !str.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "typeStr", c0230a.ayu);
        }
        String str2 = c0230a.ayv;
        if (str2 != null && !str2.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "valueStr", c0230a.ayv);
        }
        String str3 = c0230a.ayw;
        if (str3 != null && !str3.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "listValueType", c0230a.ayw);
        }
        com.kwad.sdk.utils.t.putValue(jSONObject, "valueStrList", c0230a.ayx);
        String str4 = c0230a.fieldName;
        if (str4 != null && !str4.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "fieldName", c0230a.fieldName);
        }
        String str5 = c0230a.className;
        if (str5 != null && !str5.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, PushClientConstants.TAG_CLASS_NAME, c0230a.className);
        }
        com.kwad.sdk.utils.t.putValue(jSONObject, "childParamList", c0230a.ayy);
        return jSONObject;
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(a.C0230a c0230a, JSONObject jSONObject) {
        a2(c0230a, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(a.C0230a c0230a, JSONObject jSONObject) {
        return b2(c0230a, jSONObject);
    }
}
