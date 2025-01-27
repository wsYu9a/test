package com.umeng.commonsdk.internal;

import android.content.Context;

/* loaded from: classes4.dex */
public class b {

    /* renamed from: b */
    private static b f24491b;

    /* renamed from: a */
    private Context f24492a;

    /* renamed from: c */
    private c f24493c;

    private b(Context context) {
        this.f24492a = context;
        this.f24493c = new c(context);
    }

    public static synchronized b a(Context context) {
        b bVar;
        synchronized (b.class) {
            try {
                if (f24491b == null) {
                    f24491b = new b(context.getApplicationContext());
                }
                bVar = f24491b;
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return bVar;
    }

    public c a() {
        return this.f24493c;
    }
}
