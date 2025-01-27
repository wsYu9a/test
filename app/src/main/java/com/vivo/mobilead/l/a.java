package com.vivo.mobilead.l;

import android.content.SharedPreferences;
import android.text.TextUtils;
import com.vivo.mobilead.manager.f;

/* loaded from: classes4.dex */
public class a {

    /* renamed from: b */
    private static volatile a f28921b;

    /* renamed from: a */
    private SharedPreferences f28922a;

    private a() {
        if (f.j().c() != null) {
            this.f28922a = f.j().c().getSharedPreferences("crashSp", 0);
        }
    }

    public static a b() {
        if (f28921b == null) {
            synchronized (a.class) {
                if (f28921b == null) {
                    f28921b = new a();
                }
            }
        }
        return f28921b;
    }

    public void a(String str, String str2) {
        SharedPreferences sharedPreferences = this.f28922a;
        if (sharedPreferences == null) {
            return;
        }
        sharedPreferences.edit().putString(str, str2).commit();
    }

    public String a(String str) {
        SharedPreferences sharedPreferences = this.f28922a;
        return sharedPreferences == null ? "" : sharedPreferences.getString(str, "");
    }

    public void a() {
        SharedPreferences sharedPreferences = this.f28922a;
        if (sharedPreferences == null || TextUtils.isEmpty(sharedPreferences.getString("exceptionInfo", ""))) {
            return;
        }
        this.f28922a.edit().putString("exceptionInfo", "").commit();
    }
}
