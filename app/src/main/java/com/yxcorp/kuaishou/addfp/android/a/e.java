package com.yxcorp.kuaishou.addfp.android.a;

import android.content.Context;
import android.content.SharedPreferences;

/* loaded from: classes4.dex */
public class e {

    /* renamed from: a */
    private SharedPreferences f25178a;

    /* renamed from: b */
    private SharedPreferences.Editor f25179b;

    public e(Context context) {
        try {
            SharedPreferences sharedPreferences = context.getSharedPreferences("kscfg_outdfp", 0);
            this.f25178a = sharedPreferences;
            this.f25179b = sharedPreferences.edit();
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
    }

    public void a(String str) {
        this.f25179b.putString("kwtk", str);
        this.f25179b.commit();
    }

    public String b() {
        return this.f25178a.getString("kwtk", "");
    }

    public boolean a() {
        return this.f25178a.getBoolean("xytk", true);
    }
}
