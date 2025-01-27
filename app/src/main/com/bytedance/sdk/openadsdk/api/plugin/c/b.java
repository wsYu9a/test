package com.bytedance.sdk.openadsdk.api.plugin.c;

import android.os.Build;
import android.text.TextUtils;
import b7.d;
import com.bytedance.JProtect;
import java.security.SecureRandom;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public class b {
    @JProtect
    public static String a(String str) {
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        String a10 = a();
        String a11 = a(a10, 32);
        String b10 = b();
        return 3 + a10 + b10 + ((a11 == null || b10 == null) ? null : a.a(str, b10, a11));
    }

    public static String b() {
        String a10 = a(8);
        if (a10 == null || a10.length() != 16) {
            return null;
        }
        return a10;
    }

    private static SecureRandom c() {
        SecureRandom instanceStrong;
        if (Build.VERSION.SDK_INT < 26) {
            return new SecureRandom();
        }
        try {
            instanceStrong = SecureRandom.getInstanceStrong();
            return instanceStrong;
        } catch (Throwable unused) {
            return new SecureRandom();
        }
    }

    @JProtect
    public static JSONObject a(JSONObject jSONObject) {
        JSONObject jSONObject2 = new JSONObject();
        if (jSONObject == null) {
            return jSONObject2;
        }
        try {
            try {
                String a10 = a(jSONObject.toString());
                if (!TextUtils.isEmpty(a10)) {
                    jSONObject2.put(d.f1362o, a10);
                    jSONObject2.put("cypher", 3);
                } else {
                    jSONObject2.put(d.f1362o, jSONObject.toString());
                    jSONObject2.put("cypher", 0);
                }
            } catch (Throwable unused) {
                jSONObject2.put(d.f1362o, jSONObject.toString());
                jSONObject2.put("cypher", 0);
            }
        } catch (Throwable unused2) {
        }
        return jSONObject2;
    }

    public static String a() {
        String a10 = a(16);
        if (a10 == null || a10.length() != 32) {
            return null;
        }
        return a10;
    }

    public static String a(String str, int i10) {
        if (str == null || str.length() != i10) {
            return null;
        }
        int i11 = i10 / 2;
        return str.substring(i11, i10) + str.substring(0, i11);
    }

    public static String a(int i10) {
        try {
            byte[] bArr = new byte[i10];
            c().nextBytes(bArr);
            return c.a(bArr);
        } catch (Exception unused) {
            return null;
        }
    }
}
