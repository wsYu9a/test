package com.bytedance.pangle.util;

import android.content.SharedPreferences;
import com.bytedance.pangle.Zeus;
import com.bytedance.pangle.log.ZeusLogger;
import java.util.Locale;

/* loaded from: classes.dex */
public class l {

    /* renamed from: b */
    private static volatile l f6338b;

    /* renamed from: a */
    public SharedPreferences f6339a = Zeus.getAppApplication().getSharedPreferences("pangle_meta_data_sp", 0);

    private l() {
    }

    public static l a() {
        if (f6338b == null) {
            synchronized (l.class) {
                if (f6338b == null) {
                    f6338b = new l();
                }
            }
        }
        return f6338b;
    }

    public final String b(String str) {
        String string = this.f6339a.getString("HOST_IDENTITY_".concat(String.valueOf(str)), "");
        ZeusLogger.i(ZeusLogger.TAG_INIT, "ZeusSpUtils getHostIdentity pluginPKg = " + str + ", hostIdentity = " + string);
        return string;
    }

    public final void c(String str, int i2, boolean z) {
        SharedPreferences.Editor edit = this.f6339a.edit();
        edit.putBoolean("dex_remove_state_" + str + "_" + i2, z);
        edit.apply();
    }

    public final void b(String str, int i2, boolean z) {
        SharedPreferences.Editor edit = this.f6339a.edit();
        edit.putBoolean("dex_opt_state_" + str + "_" + i2, z);
        edit.apply();
    }

    public final int a(String str) {
        int i2 = this.f6339a.getInt("PLUGIN_API_VERSION_".concat(String.valueOf(str)), 0);
        ZeusLogger.i(ZeusLogger.TAG_INIT, "ZeusSpUtils getPluginApiVersion pluginPKg = " + str + ", pluginApiVersion = " + i2);
        return i2;
    }

    public final int b(String str, int i2) {
        return this.f6339a.getInt("remove_entry_flag_" + str + "_" + i2, 0);
    }

    public final void a(String str, int i2, boolean z) {
        SharedPreferences.Editor edit = this.f6339a.edit();
        String str2 = "INSTALLED_" + str + "-" + i2;
        if (z) {
            edit.putBoolean(str2, true);
        } else {
            edit.remove(str2);
        }
        edit.apply();
    }

    public final int b(String str, int i2, String str2) {
        return this.f6339a.getInt(str2 + "_failed_count_when_rm_entry_" + str + "_" + i2, 0);
    }

    public final boolean a(String str, int i2) {
        return this.f6339a.getBoolean(String.format(Locale.getDefault(), "INSTALLED_%s-%d", str, Integer.valueOf(i2)), false);
    }

    public final void a(String str, int i2, String str2) {
        int b2 = b(str, i2, str2);
        SharedPreferences.Editor edit = this.f6339a.edit();
        edit.putInt(str2 + "_failed_count_when_rm_entry_" + str + "_" + i2, b2 + 1);
        edit.apply();
    }
}
