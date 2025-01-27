package com.yxcorp.kuaishou.addfp.android.a;

import android.content.Context;
import android.content.SharedPreferences;

/* loaded from: classes5.dex */
public class e {

    /* renamed from: a */
    private SharedPreferences f34697a;

    /* renamed from: b */
    private SharedPreferences.Editor f34698b;

    public e(Context context) {
        try {
            SharedPreferences sharedPreferences = context.getSharedPreferences("kscfg_outdfp", 0);
            this.f34697a = sharedPreferences;
            this.f34698b = sharedPreferences.edit();
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void a(String str) {
        this.f34698b.putString("kwtk", str);
        this.f34698b.commit();
    }

    public boolean a() {
        return this.f34697a.getBoolean("xytk", true);
    }

    public String b() {
        return this.f34697a.getString("kwtk", "");
    }
}
