package com.bytedance.pangle.util;

import android.content.SharedPreferences;
import com.bytedance.pangle.Zeus;
import com.bytedance.pangle.log.ZeusLogger;
import java.util.Locale;

/* loaded from: classes2.dex */
public class l {

    /* renamed from: b */
    private static volatile l f7861b;

    /* renamed from: a */
    public SharedPreferences f7862a = Zeus.getAppApplication().getSharedPreferences("pangle_meta_data_sp", 0);

    private l() {
    }

    public static l a() {
        if (f7861b == null) {
            synchronized (l.class) {
                try {
                    if (f7861b == null) {
                        f7861b = new l();
                    }
                } finally {
                }
            }
        }
        return f7861b;
    }

    public final String b(String str) {
        String string = this.f7862a.getString("HOST_IDENTITY_".concat(String.valueOf(str)), "");
        ZeusLogger.i(ZeusLogger.TAG_INIT, "ZeusSpUtils getHostIdentity pluginPKg = " + str + ", hostIdentity = " + string);
        return string;
    }

    public final void c(String str, int i10, boolean z10) {
        SharedPreferences.Editor edit = this.f7862a.edit();
        edit.putBoolean("dex_remove_state_" + str + hf.e.f26694a + i10, z10);
        edit.apply();
    }

    public final void b(String str, int i10, boolean z10) {
        SharedPreferences.Editor edit = this.f7862a.edit();
        edit.putBoolean("dex_opt_state_" + str + hf.e.f26694a + i10, z10);
        edit.apply();
    }

    public final int a(String str) {
        int i10 = this.f7862a.getInt("PLUGIN_API_VERSION_".concat(String.valueOf(str)), 0);
        ZeusLogger.i(ZeusLogger.TAG_INIT, "ZeusSpUtils getPluginApiVersion pluginPKg = " + str + ", pluginApiVersion = " + i10);
        return i10;
    }

    public final int b(String str, int i10) {
        return this.f7862a.getInt("remove_entry_flag_" + str + hf.e.f26694a + i10, 0);
    }

    public final void a(String str, int i10, boolean z10) {
        SharedPreferences.Editor edit = this.f7862a.edit();
        String str2 = "INSTALLED_" + str + "-" + i10;
        if (z10) {
            edit.putBoolean(str2, true);
        } else {
            edit.remove(str2);
        }
        edit.apply();
    }

    public final int b(String str, int i10, String str2) {
        return this.f7862a.getInt(str2 + "_failed_count_when_rm_entry_" + str + hf.e.f26694a + i10, 0);
    }

    public final boolean a(String str, int i10) {
        return this.f7862a.getBoolean(String.format(Locale.getDefault(), "INSTALLED_%s-%d", str, Integer.valueOf(i10)), false);
    }

    public final void a(String str, int i10, String str2) {
        int b10 = b(str, i10, str2);
        SharedPreferences.Editor edit = this.f7862a.edit();
        edit.putInt(str2 + "_failed_count_when_rm_entry_" + str + hf.e.f26694a + i10, b10 + 1);
        edit.apply();
    }
}
