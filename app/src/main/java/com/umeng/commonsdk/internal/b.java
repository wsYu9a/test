package com.umeng.commonsdk.internal;

import android.content.Context;

/* loaded from: classes4.dex */
public class b {

    /* renamed from: b */
    private static b f26188b;

    /* renamed from: a */
    private Context f26189a;

    /* renamed from: c */
    private c f26190c;

    private b(Context context) {
        this.f26189a = context;
        this.f26190c = new c(context);
    }

    public static synchronized b a(Context context) {
        b bVar;
        synchronized (b.class) {
            if (f26188b == null) {
                f26188b = new b(context.getApplicationContext());
            }
            bVar = f26188b;
        }
        return bVar;
    }

    public c a() {
        return this.f26190c;
    }
}
