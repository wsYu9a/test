package com.bytedance.sdk.openadsdk.api.plugin.zx;

import android.os.Build;
import android.text.TextUtils;
import com.bytedance.JProtect;
import com.heytap.mcssdk.n.d;
import java.security.SecureRandom;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class zx {
    private static SecureRandom i() {
        if (Build.VERSION.SDK_INT < 26) {
            return new SecureRandom();
        }
        try {
            return SecureRandom.getInstanceStrong();
        } catch (Throwable unused) {
            return new SecureRandom();
        }
    }

    @JProtect
    public static String j(String str) {
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        String j2 = j();
        String j3 = j(j2, 32);
        String zx = zx();
        String str2 = null;
        if (j3 != null && zx != null) {
            str2 = j.j(str, zx, j3);
        }
        return 3 + j2 + zx + str2;
    }

    public static String zx() {
        String j2 = j(8);
        if (j2 == null || j2.length() != 16) {
            return null;
        }
        return j2;
    }

    @JProtect
    public static JSONObject j(JSONObject jSONObject) {
        JSONObject jSONObject2 = new JSONObject();
        if (jSONObject == null) {
            return jSONObject2;
        }
        try {
            try {
                String j2 = j(jSONObject.toString());
                if (!TextUtils.isEmpty(j2)) {
                    jSONObject2.put(d.l, j2);
                    jSONObject2.put("cypher", 3);
                } else {
                    jSONObject2.put(d.l, jSONObject.toString());
                    jSONObject2.put("cypher", 0);
                }
            } catch (Throwable unused) {
                jSONObject2.put(d.l, jSONObject.toString());
                jSONObject2.put("cypher", 0);
            }
        } catch (Throwable unused2) {
        }
        return jSONObject2;
    }

    public static String j() {
        String j2 = j(16);
        if (j2 == null || j2.length() != 32) {
            return null;
        }
        return j2;
    }

    public static String j(String str, int i2) {
        if (str == null || str.length() != i2) {
            return null;
        }
        int i3 = i2 / 2;
        return str.substring(i3, i2) + str.substring(0, i3);
    }

    public static String j(int i2) {
        try {
            byte[] bArr = new byte[i2];
            i().nextBytes(bArr);
            return i.j(bArr);
        } catch (Exception unused) {
            return null;
        }
    }
}
