package com.kwad.sdk.utils;

import android.content.SharedPreferences;
import android.text.TextUtils;
import android.util.Log;
import com.kwad.sdk.service.ServiceProvider;
import java.util.Map;
import java.util.Set;

@Deprecated
/* loaded from: classes2.dex */
public class ba {
    static final String TAG = "ba";

    private static void a(SharedPreferences.Editor editor, String str, Object obj) {
        if (str != null) {
            if (obj instanceof Integer) {
                editor.putInt(str, ((Integer) obj).intValue());
                return;
            }
            if (obj instanceof Long) {
                editor.putLong(str, ((Long) obj).longValue());
                return;
            }
            if (obj instanceof Boolean) {
                editor.putBoolean(str, ((Boolean) obj).booleanValue());
                return;
            }
            if (obj instanceof Float) {
                editor.putFloat(str, ((Float) obj).floatValue());
            } else if (obj instanceof Set) {
                editor.putStringSet(str, (Set) obj);
            } else if (obj instanceof String) {
                editor.putString(str, String.valueOf(obj));
            }
        }
    }

    static void a(String str, String str2, long j2) {
        eN(str).edit().putLong(str2, j2).apply();
    }

    static void a(String str, String str2, String str3, boolean z) {
        if (z && !com.kwad.sdk.core.kwai.c.bY(str3)) {
            str3 = com.kwad.sdk.core.kwai.c.bW(str3);
        }
        eN(str).edit().putString(str2, str3).apply();
    }

    static <T> void a(String str, Map<String, T> map) {
        SharedPreferences.Editor edit = eN(str).edit();
        for (Map.Entry<String, T> entry : map.entrySet()) {
            try {
                a(edit, entry.getKey(), entry.getValue());
            } catch (Throwable th) {
                com.kwad.sdk.core.d.b.e(TAG, Log.getStackTraceString(th));
            }
        }
        edit.apply();
    }

    static void ae(String str, String str2) {
        eN(str).edit().remove(str2).apply();
    }

    static long b(String str, String str2, long j2) {
        return eN(str).getLong(str2, j2);
    }

    static void b(String str, String str2, int i2) {
        eN(str).edit().putInt(str2, i2).apply();
    }

    static int c(String str, String str2, int i2) {
        return eN(str).getInt(str2, i2);
    }

    static SharedPreferences eN(String str) {
        return ServiceProvider.CA().getSharedPreferences(str, 0);
    }

    static void g(String str, String str2, String str3) {
        a(str, str2, str3, false);
    }

    static String h(String str, String str2, String str3) {
        String string = eN(str).getString(str2, str3);
        return (string == null || TextUtils.isEmpty(string)) ? str3 : (TextUtils.equals(string, str3) || !com.kwad.sdk.core.kwai.c.bY(string)) ? string : com.kwad.sdk.core.kwai.c.bX(string);
    }

    static void h(String str, String str2, boolean z) {
        eN(str).edit().putBoolean(str2, z).apply();
    }

    static void i(String str, String str2, String str3) {
        if (com.kwad.sdk.core.kwai.c.bY(str)) {
            return;
        }
        g(str2, str3, com.kwad.sdk.core.kwai.c.bW(str));
    }

    static boolean i(String str, String str2, boolean z) {
        return eN(str).getBoolean(str2, z);
    }
}
