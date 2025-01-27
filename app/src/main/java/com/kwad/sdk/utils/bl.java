package com.kwad.sdk.utils;

import android.content.SharedPreferences;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.Nullable;
import com.kwad.sdk.service.ServiceProvider;
import java.util.Map;
import java.util.Set;

@Deprecated
/* loaded from: classes3.dex */
public class bl {
    static final String TAG = "bl";

    public static void a(String str, String str2, int i10) {
        SharedPreferences hc2 = hc(str);
        if (hc2 == null) {
            return;
        }
        hc2.edit().putInt(str2, i10).apply();
    }

    public static void aw(String str, String str2) {
        SharedPreferences hc2 = hc(str);
        if (hc2 == null) {
            return;
        }
        hc2.edit().remove(str2).apply();
    }

    public static int b(String str, String str2, int i10) {
        SharedPreferences hc2 = hc(str);
        return hc2 == null ? i10 : hc2.getInt(str2, i10);
    }

    public static void g(String str, String str2, String str3) {
        a(str, str2, str3, false);
    }

    public static String h(String str, String str2, String str3) {
        try {
            SharedPreferences hc2 = hc(str);
            if (hc2 == null) {
                return str3;
            }
            String string = hc2.getString(str2, str3);
            if (string != null && !TextUtils.isEmpty(string)) {
                return (TextUtils.equals(string, str3) || !com.kwad.sdk.core.a.c.dV(string)) ? string : com.kwad.sdk.core.a.c.dU(string);
            }
            return str3;
        } catch (Throwable th2) {
            ServiceProvider.reportSdkCaughtException(th2);
            return "";
        }
    }

    @Nullable
    public static SharedPreferences hc(String str) {
        try {
            return ServiceProvider.MA().getSharedPreferences(str, 0);
        } catch (Throwable th2) {
            com.kwad.sdk.core.d.c.printStackTraceOnly(th2);
            return null;
        }
    }

    public static void i(String str, String str2, String str3) {
        if (com.kwad.sdk.core.a.c.dV(str)) {
            return;
        }
        g(str2, str3, com.kwad.sdk.core.a.c.dT(str));
    }

    public static void l(String str, String str2, boolean z10) {
        SharedPreferences hc2 = hc(str);
        if (hc2 == null) {
            return;
        }
        hc2.edit().putBoolean(str2, z10).apply();
    }

    public static boolean m(String str, String str2, boolean z10) {
        SharedPreferences hc2 = hc(str);
        return hc2 == null ? z10 : hc2.getBoolean(str2, z10);
    }

    public static void a(String str, String str2, long j10) {
        SharedPreferences hc2 = hc(str);
        if (hc2 == null) {
            return;
        }
        hc2.edit().putLong(str2, j10).apply();
    }

    public static long b(String str, String str2, long j10) {
        SharedPreferences hc2 = hc(str);
        return hc2 == null ? j10 : hc2.getLong(str2, j10);
    }

    public static void a(String str, String str2, String str3, boolean z10) {
        try {
            SharedPreferences hc2 = hc(str);
            if (hc2 == null) {
                return;
            }
            if (z10 && !com.kwad.sdk.core.a.c.dV(str3)) {
                hc2.edit().putString(str2, com.kwad.sdk.core.a.c.dT(str3)).apply();
            } else {
                hc2.edit().putString(str2, str3).apply();
            }
        } catch (Throwable th2) {
            ServiceProvider.reportSdkCaughtException(th2);
        }
    }

    public static <T> void a(String str, Map<String, T> map) {
        SharedPreferences hc2 = hc(str);
        if (hc2 == null) {
            return;
        }
        SharedPreferences.Editor edit = hc2.edit();
        for (Map.Entry<String, T> entry : map.entrySet()) {
            try {
                a(edit, entry.getKey(), entry.getValue());
            } catch (Throwable th2) {
                com.kwad.sdk.core.d.c.e(TAG, Log.getStackTraceString(th2));
            }
        }
        edit.apply();
    }

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
}
