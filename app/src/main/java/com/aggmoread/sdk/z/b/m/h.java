package com.aggmoread.sdk.z.b.m;

import android.content.Context;

/* loaded from: classes.dex */
public abstract class h {
    public static h a(Context context, String str) {
        return a(context, str, 4096);
    }

    public abstract String a(String str, String str2);

    public abstract boolean a(String str);

    public abstract void b(String str, String str2);

    public abstract boolean b(String str);

    public abstract void c(String str);

    public static h a(Context context, String str, int i10) {
        i iVar = 4096 == i10 ? new i(context) : new i(context);
        iVar.c(str);
        return iVar;
    }
}
