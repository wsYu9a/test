package com.martian.ttbook.b.a.g;

import android.content.Context;
import android.util.Log;
import b.d.e.c.a.f.g;
import com.martian.ttbook.b.a.k.f;

/* loaded from: classes4.dex */
public class a {

    /* renamed from: a */
    private static a f14939a;

    /* renamed from: b */
    private Context f14940b;

    /* renamed from: c */
    private b.d.e.c.a.f.a f14941c;

    /* renamed from: d */
    private g f14942d = g.f4615a;

    /* renamed from: e */
    private boolean f14943e;

    /* renamed from: f */
    private b f14944f;

    private a() {
    }

    public static synchronized a f() {
        a aVar;
        synchronized (a.class) {
            if (f14939a == null) {
                synchronized (a.class) {
                    if (f14939a == null) {
                        f14939a = new a();
                    }
                }
            }
            aVar = f14939a;
        }
        return aVar;
    }

    public Context a() {
        return this.f14940b;
    }

    public void b(g gVar) {
        this.f14942d = gVar;
    }

    public boolean c(Context context, b.d.e.c.a.f.a aVar, b bVar) {
        if (this.f14943e) {
            return true;
        }
        if (context == null || aVar == null) {
            Log.e("apia_manager_tag", "初始化参数为空，初始化失败！");
            return this.f14943e;
        }
        this.f14940b = context.getApplicationContext();
        this.f14941c = aVar;
        this.f14944f = bVar;
        f.c(context);
        this.f14943e = true;
        return true;
    }

    public b.d.e.c.a.f.a d() {
        return this.f14941c;
    }

    public b e() {
        return this.f14944f;
    }

    public g g() {
        return this.f14942d;
    }

    public boolean h() {
        return this.f14943e;
    }
}
