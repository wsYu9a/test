package com.martian.ttbook.b.a.k;

import android.content.Context;

/* loaded from: classes4.dex */
public abstract class h {
    public static h a(Context context, String str) {
        return b(context, str, 4096);
    }

    public static h b(Context context, String str, int i2) {
        i iVar = 4096 == i2 ? new i(context) : new i(context);
        iVar.g(str);
        return iVar;
    }

    public abstract String c(String str, String str2);

    public abstract boolean d(String str);

    public abstract void e(String str, String str2);

    public abstract boolean f(String str);

    public abstract void g(String str);
}
