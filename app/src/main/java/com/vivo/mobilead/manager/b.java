package com.vivo.mobilead.manager;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.bugly.beta.tinker.TinkerReport;
import com.vivo.ic.VLog;
import com.vivo.ic.spmanager.BaseSharePreference;
import java.util.UUID;

/* loaded from: classes4.dex */
public class b extends BaseSharePreference {

    /* renamed from: a */
    private Context f29508a;

    /* renamed from: com.vivo.mobilead.manager.b$b */
    private static class C0601b {

        /* renamed from: a */
        private static final b f29509a = new b();
    }

    /* synthetic */ b(a aVar) {
        this();
    }

    public static b l() {
        return C0601b.f29509a;
    }

    public void a(long j2) {
        if (getSharedPreferences() == null) {
            return;
        }
        putLong("get_applist_time", j2);
    }

    public void b(long j2) {
        if (getSharedPreferences() == null) {
            return;
        }
        putLong("KEY_nextQueryTimestamp", j2);
    }

    public void c(int i2) {
        if (getSharedPreferences() == null) {
            return;
        }
        putInt("reqCtl", i2);
    }

    public String d() {
        String string = getSharedPreferences() != null ? getString("KEY_GNERATEUUID_IMEI", "") : "";
        if (TextUtils.isEmpty(string)) {
            string = UUID.randomUUID().toString().replaceAll("-", "");
            if (getSharedPreferences() != null) {
                putString("KEY_GNERATEUUID_IMEI", string);
            }
        }
        return string;
    }

    public int e() {
        return getSharedPreferences() == null ? TinkerReport.KEY_APPLIED_VERSION_CHECK : getInt("key_icon_show_interval", TinkerReport.KEY_APPLIED_VERSION_CHECK);
    }

    public boolean f() {
        if (getSharedPreferences() == null) {
            return true;
        }
        return getBoolean("imageloader_switch", true);
    }

    public long g() {
        if (getSharedPreferences() == null) {
            return 0L;
        }
        return getLong("KEY_nextQueryTimestamp", 0L);
    }

    @Override // com.vivo.ic.spmanager.BaseSharePreference
    public boolean getBoolean(String str, boolean z) {
        try {
            return super.getBoolean(str, z);
        } catch (Exception unused) {
            return false;
        }
    }

    @Override // com.vivo.ic.spmanager.BaseSharePreference
    public float getFloat(String str, float f2) {
        try {
            return super.getFloat(str, f2);
        } catch (Exception unused) {
            return 0.0f;
        }
    }

    @Override // com.vivo.ic.spmanager.BaseSharePreference
    public int getInt(String str, int i2) {
        try {
            return super.getInt(str, i2);
        } catch (Exception unused) {
            return 0;
        }
    }

    @Override // com.vivo.ic.spmanager.BaseSharePreference
    public long getLong(String str, long j2) {
        try {
            return super.getLong(str, j2);
        } catch (Exception unused) {
            return 0L;
        }
    }

    @Override // com.vivo.ic.spmanager.BaseSharePreference
    public String getString(String str, String str2) {
        try {
            return super.getString(str, str2);
        } catch (Exception unused) {
            return "";
        }
    }

    public int h() {
        if (getSharedPreferences() == null) {
            return 31;
        }
        return getInt("reqCtl", 31);
    }

    public String i() {
        return getSharedPreferences() == null ? "" : getString("KEY_vivoAdStrategy", "");
    }

    public int j() {
        if (getSharedPreferences() == null) {
            return 0;
        }
        return getInt("key_video", 0);
    }

    public boolean k() {
        if (getSharedPreferences() == null) {
            return true;
        }
        return getBoolean("key_first_open", true);
    }

    @Override // com.vivo.ic.spmanager.BaseSharePreference
    public void putBoolean(String str, boolean z) {
        try {
            super.putBoolean(str, z);
        } catch (Exception unused) {
        }
    }

    @Override // com.vivo.ic.spmanager.BaseSharePreference
    public void putFloat(String str, float f2) {
        try {
            super.putFloat(str, f2);
        } catch (Exception unused) {
        }
    }

    @Override // com.vivo.ic.spmanager.BaseSharePreference
    public void putInt(String str, int i2) {
        try {
            super.putInt(str, i2);
        } catch (Exception unused) {
        }
    }

    @Override // com.vivo.ic.spmanager.BaseSharePreference
    public void putLong(String str, long j2) {
        try {
            super.putLong(str, j2);
        } catch (Exception unused) {
        }
    }

    @Override // com.vivo.ic.spmanager.BaseSharePreference
    public void putString(String str, String str2) {
        try {
            super.putString(str, str2);
        } catch (Exception unused) {
        }
    }

    private b() {
        Context c2 = f.j().c();
        this.f29508a = c2;
        if (c2 != null) {
            init(c2, "VivoOpenAdSDK", true);
        }
    }

    public long a() {
        if (getSharedPreferences() == null) {
            return 0L;
        }
        return getLong("get_applist_time", 0L);
    }

    public int b() {
        if (getSharedPreferences() == null) {
            return 15;
        }
        return getInt("KEY_BANNER_REFRESH_TIME", 15);
    }

    public void c(long j2) {
        if (getSharedPreferences() == null) {
            return;
        }
        try {
            String binaryString = Long.toBinaryString(j2);
            if (TextUtils.isEmpty(binaryString)) {
                return;
            }
            putBoolean("imageloader_switch", binaryString.charAt(binaryString.length() - 1) == '0');
        } catch (Exception e2) {
            VLog.e("FPSetting", e2.getMessage());
        }
    }

    public void a(String str) {
        if (getSharedPreferences() == null) {
            return;
        }
        putString("KEY_vivoAdStrategy", str);
    }

    public void b(String str, int i2) {
        if (getSharedPreferences() == null) {
            return;
        }
        putInt(str, i2);
    }

    public void a(boolean z) {
        if (getSharedPreferences() == null) {
            return;
        }
        putBoolean("key_first_open", z);
    }

    public void b(String str) {
        if (getSharedPreferences() == null || TextUtils.isEmpty(str)) {
            return;
        }
        putString("key_channel", str);
    }

    public void d(int i2) {
        if (getSharedPreferences() != null && i2 > 0 && i2 < 600) {
            putInt("key_video", i2);
        }
    }

    public void a(int i2) {
        if (getSharedPreferences() == null) {
            return;
        }
        putInt("KEY_BANNER_REFRESH_TIME", i2);
    }

    public String c() {
        return getSharedPreferences() == null ? "" : getString("key_channel", "");
    }

    public void b(int i2) {
        if (getSharedPreferences() == null) {
            return;
        }
        putInt("key_icon_show_interval", i2);
    }

    public void a(String str, int i2) {
        if (getSharedPreferences() == null) {
            return;
        }
        putInt(str, i2);
    }
}
