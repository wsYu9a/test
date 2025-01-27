package com.kuaishou.weapon.p0;

import org.json.JSONArray;

/* loaded from: classes2.dex */
public class dj {

    /* renamed from: a */
    private static final String f11073a = "bGlidmErKw==";

    /* renamed from: b */
    private static final String f11074b = "WnBvc2VkQnJpZGdlLmphcg==";

    /* renamed from: c */
    private static final String f11075c = "bGlienBvc2VkX2FydC5zbw==";

    public static Integer a(JSONArray jSONArray) {
        if (jSONArray == null) {
            return null;
        }
        try {
            if (jSONArray.length() <= 0) {
                return null;
            }
            String str = new String(c.a(f11074b.getBytes(), 2));
            byte[] a10 = c.a(f11075c.getBytes(), 2);
            return (a10 == null || !a(jSONArray, str, new String(a10))) ? null : 1;
        } catch (Exception unused) {
            return null;
        }
    }

    public static Integer b(JSONArray jSONArray) {
        if (jSONArray == null) {
            return null;
        }
        try {
            if (jSONArray.length() <= 0) {
                return null;
            }
            String str = new String(c.a(f11073a.getBytes(), 2));
            return (str.length() <= 1 || !a(jSONArray, str)) ? null : 1;
        } catch (Exception unused) {
            return null;
        }
    }

    private static boolean a(JSONArray jSONArray, String str, String str2) {
        try {
            if (jSONArray.length() > 0) {
                for (int i10 = 0; i10 < jSONArray.length(); i10++) {
                    String str3 = (String) jSONArray.get(i10);
                    if (str3.contains(str) || str3.contains(str2)) {
                        return true;
                    }
                }
            }
        } catch (Exception unused) {
        }
        return false;
    }

    private static boolean a(JSONArray jSONArray, String str) {
        try {
            if (jSONArray.length() > 0) {
                for (int i10 = 0; i10 < jSONArray.length(); i10++) {
                    if (((String) jSONArray.get(i10)).contains(str)) {
                        return true;
                    }
                }
            }
        } catch (Exception unused) {
        }
        return false;
    }
}
