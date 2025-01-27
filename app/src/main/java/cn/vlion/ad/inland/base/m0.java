package cn.vlion.ad.inland.base;

import android.content.SharedPreferences;
import android.text.TextUtils;
import cn.vlion.ad.inland.base.util.date.VlionDateUtils;
import cn.vlion.ad.inland.base.util.init.VlionSDkManager;

/* loaded from: classes.dex */
public final class m0 {

    /* renamed from: b */
    public static volatile m0 f3087b;

    /* renamed from: a */
    public SharedPreferences f3088a;

    public static m0 b() {
        if (f3087b == null) {
            synchronized (m0.class) {
                try {
                    if (f3087b == null) {
                        f3087b = new m0();
                    }
                } finally {
                }
            }
        }
        return f3087b;
    }

    public final void a(String str, long j10) {
        try {
            if (this.f3088a == null || str == null) {
                return;
            }
            this.f3088a.edit().putLong(str, j10).putString("vlion_key_down_date", VlionDateUtils.dateFormatDay()).apply();
        } catch (Throwable th2) {
            VlionSDkManager.getInstance().upLoadCatchException(th2);
        }
    }

    public final boolean a() {
        try {
            String dateFormatDay = VlionDateUtils.dateFormatDay();
            SharedPreferences sharedPreferences = this.f3088a;
            String string = sharedPreferences != null ? sharedPreferences.getString("vlion_key_down_date", "") : "";
            if (!TextUtils.isEmpty(string) && !TextUtils.equals(dateFormatDay, string)) {
                if (!string.isEmpty()) {
                    try {
                        SharedPreferences sharedPreferences2 = this.f3088a;
                        if (sharedPreferences2 != null) {
                            SharedPreferences.Editor edit = sharedPreferences2.edit();
                            edit.clear();
                            edit.apply();
                        }
                    } catch (Throwable th2) {
                        VlionSDkManager.getInstance().upLoadCatchException(th2);
                    }
                }
                return false;
            }
            return true;
        } catch (Throwable th3) {
            VlionSDkManager.getInstance().upLoadCatchException(th3);
            return false;
        }
    }
}
