package com.vivo.push.c;

import android.content.Context;
import com.vivo.push.util.ContextDelegate;

/* loaded from: classes4.dex */
public class d {

    /* renamed from: d */
    private static volatile d f24964d;

    /* renamed from: a */
    private b f24965a;

    /* renamed from: b */
    private c f24966b;

    /* renamed from: c */
    private Context f24967c;

    private d(Context context) {
        if (this.f24965a == null) {
            this.f24967c = ContextDelegate.getContext(context.getApplicationContext());
            this.f24965a = new e(this.f24967c);
        }
        if (this.f24966b == null) {
            this.f24966b = new a();
        }
    }

    public static d a(Context context) {
        if (f24964d == null) {
            synchronized (d.class) {
                try {
                    if (f24964d == null && context != null) {
                        f24964d = new d(context);
                    }
                } finally {
                }
            }
        }
        return f24964d;
    }

    public final b a() {
        return this.f24965a;
    }
}
