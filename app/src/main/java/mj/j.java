package mj;

import android.content.SharedPreferences;
import java.util.Set;

/* loaded from: classes4.dex */
public final class j {
    public static SharedPreferences a() {
        return yk.b.f33564b.getSharedPreferences("sntech_sdk_pref", 0);
    }

    public static Set b(Set set) {
        return a().getStringSet("self_crash_keywords", set);
    }

    public static void c(int i10) {
        a().edit().putInt("START_UP_TIMES", i10).apply();
    }

    public static void d(String str, String str2) {
        a().edit().putString(str, str2).apply();
    }

    public static void e(String str, boolean z10) {
        a().edit().putBoolean(str, z10).apply();
    }

    public static void f() {
        a().edit().remove("ic_data").apply();
    }

    public static void g(Set set) {
        a().edit().putStringSet("self_crash_keywords", set).apply();
    }
}
