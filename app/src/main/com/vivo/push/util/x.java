package com.vivo.push.util;

import android.content.Context;
import android.content.SharedPreferences;

/* loaded from: classes4.dex */
public final class x implements d {

    /* renamed from: a */
    private static String f25150a = "SpCache";

    /* renamed from: b */
    private static String f25151b = "com.vivo.push.cache";

    /* renamed from: c */
    private SharedPreferences f25152c;

    @Override // com.vivo.push.util.d
    public final boolean a(Context context) {
        if (this.f25152c != null) {
            return true;
        }
        this.f25152c = context.getSharedPreferences(f25151b, 0);
        return true;
    }

    @Override // com.vivo.push.util.d
    public final void b(String str, String str2) {
        SharedPreferences.Editor edit = this.f25152c.edit();
        if (edit == null) {
            p.b(f25150a, "putString error by ".concat(String.valueOf(str)));
            return;
        }
        edit.putString(str, str2);
        b.a(edit);
        p.d(f25150a, "putString by ".concat(String.valueOf(str)));
    }

    @Override // com.vivo.push.util.d
    public final String a(String str, String str2) {
        String string = this.f25152c.getString(str, str2);
        p.d(f25150a, "getString " + str + " is " + string);
        return string;
    }

    public final void a() {
        SharedPreferences.Editor edit = this.f25152c.edit();
        if (edit != null) {
            edit.clear();
            b.a(edit);
        }
        p.d(f25150a, "system cache is cleared");
    }
}
