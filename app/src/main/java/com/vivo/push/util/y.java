package com.vivo.push.util;

import android.content.Context;
import java.util.HashMap;

/* loaded from: classes4.dex */
public final class y implements d {

    /* renamed from: a */
    private static final HashMap<String, Integer> f31117a = new HashMap<>();

    /* renamed from: b */
    private static final HashMap<String, Long> f31118b = new HashMap<>();

    /* renamed from: c */
    private static final HashMap<String, String> f31119c = new HashMap<>();

    /* renamed from: d */
    private static y f31120d;

    /* renamed from: e */
    private Context f31121e;

    /* renamed from: f */
    private d f31122f;

    /* renamed from: g */
    private boolean f31123g;

    private y(Context context) {
        this.f31123g = false;
        this.f31121e = context;
        this.f31123g = a(context);
        p.d("SystemCache", "init status is " + this.f31123g + ";  curCache is " + this.f31122f);
    }

    public static synchronized y b(Context context) {
        y yVar;
        synchronized (y.class) {
            if (f31120d == null) {
                f31120d = new y(context.getApplicationContext());
            }
            yVar = f31120d;
        }
        return yVar;
    }

    public final void a() {
        x xVar = new x();
        if (xVar.a(this.f31121e)) {
            xVar.a();
            p.d("SystemCache", "sp cache is cleared");
        }
    }

    @Override // com.vivo.push.util.d
    public final void b(String str, String str2) {
        d dVar;
        f31119c.put(str, str2);
        if (!this.f31123g || (dVar = this.f31122f) == null) {
            return;
        }
        dVar.b(str, str2);
    }

    @Override // com.vivo.push.util.d
    public final boolean a(Context context) {
        v vVar = new v();
        this.f31122f = vVar;
        boolean a2 = vVar.a(context);
        if (!a2) {
            x xVar = new x();
            this.f31122f = xVar;
            a2 = xVar.a(context);
        }
        if (!a2) {
            this.f31122f = null;
        }
        return a2;
    }

    @Override // com.vivo.push.util.d
    public final String a(String str, String str2) {
        d dVar;
        String str3 = f31119c.get(str);
        return (str3 != null || (dVar = this.f31122f) == null) ? str3 : dVar.a(str, str2);
    }
}
