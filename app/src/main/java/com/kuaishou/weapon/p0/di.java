package com.kuaishou.weapon.p0;

import org.json.JSONArray;

/* loaded from: classes.dex */
public class di {

    /* renamed from: a */
    private static final String f9289a = "bGlidmErKw==";

    /* renamed from: b */
    private static final String f9290b = "WnBvc2VkQnJpZGdlLmphcg==";

    /* renamed from: c */
    private static final String f9291c = "bGlienBvc2VkX2FydC5zbw==";

    public static Integer a(JSONArray jSONArray) {
        if (jSONArray == null) {
            return null;
        }
        try {
            if (jSONArray.length() <= 0) {
                return null;
            }
            String str = new String(c.a(f9290b.getBytes(), 2));
            byte[] a2 = c.a(f9291c.getBytes(), 2);
            return (a2 == null || !a(jSONArray, str, new String(a2))) ? null : 1;
        } catch (Exception unused) {
            return null;
        }
    }

    private static boolean a(JSONArray jSONArray, String str) {
        try {
            if (jSONArray.length() > 0) {
                for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                    if (((String) jSONArray.get(i2)).contains(str)) {
                        return true;
                    }
                }
            }
        } catch (Exception unused) {
        }
        return false;
    }

    private static boolean a(JSONArray jSONArray, String str, String str2) {
        try {
            if (jSONArray.length() > 0) {
                for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                    String str3 = (String) jSONArray.get(i2);
                    if (str3.contains(str) || str3.contains(str2)) {
                        return true;
                    }
                }
            }
        } catch (Exception unused) {
        }
        return false;
    }

    public static Integer b(JSONArray jSONArray) {
        if (jSONArray == null) {
            return null;
        }
        try {
            if (jSONArray.length() <= 0) {
                return null;
            }
            String str = new String(c.a(f9289a.getBytes(), 2));
            return (str.length() <= 1 || !a(jSONArray, str)) ? null : 1;
        } catch (Exception unused) {
            return null;
        }
    }
}
