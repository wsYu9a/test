package com.vivo.mobilead.util;

import org.json.JSONObject;

/* loaded from: classes4.dex */
public class t {
    public static void a(JSONObject jSONObject, String str, String str2) {
        if (jSONObject == null) {
            return;
        }
        try {
            jSONObject.put(str, str2);
        } catch (Exception unused) {
        }
    }
}
