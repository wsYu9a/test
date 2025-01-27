package com.vivo.push.c;

import android.content.Context;
import com.vivo.push.util.ContextDelegate;

/* loaded from: classes4.dex */
public class d {

    /* renamed from: d */
    private static volatile d f30937d;

    /* renamed from: a */
    private b f30938a;

    /* renamed from: b */
    private c f30939b;

    /* renamed from: c */
    private Context f30940c;

    private d(Context context) {
        if (this.f30938a == null) {
            this.f30940c = ContextDelegate.getContext(context.getApplicationContext());
            this.f30938a = new e(this.f30940c);
        }
        if (this.f30939b == null) {
            this.f30939b = new a();
        }
    }

    public static d a(Context context) {
        if (f30937d == null) {
            synchronized (d.class) {
                if (f30937d == null && context != null) {
                    f30937d = new d(context);
                }
            }
        }
        return f30937d;
    }

    public final b a() {
        return this.f30938a;
    }
}
