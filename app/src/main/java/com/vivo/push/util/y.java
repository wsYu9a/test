package com.vivo.push.util;

import android.content.Context;
import java.util.HashMap;

/* loaded from: classes4.dex */
public final class y implements d {

    /* renamed from: a */
    private static final HashMap<String, Integer> f25153a = new HashMap<>();

    /* renamed from: b */
    private static final HashMap<String, Long> f25154b = new HashMap<>();

    /* renamed from: c */
    private static final HashMap<String, String> f25155c = new HashMap<>();

    /* renamed from: d */
    private static y f25156d;

    /* renamed from: e */
    private Context f25157e;

    /* renamed from: f */
    private d f25158f;

    /* renamed from: g */
    private boolean f25159g;

    private y(Context context) {
        this.f25159g = false;
        this.f25157e = context;
        this.f25159g = a(context);
        p.d("SystemCache", "init status is " + this.f25159g + ";  curCache is " + this.f25158f);
    }

    public static synchronized y b(Context context) {
        y yVar;
        synchronized (y.class) {
            try {
                if (f25156d == null) {
                    f25156d = new y(context.getApplicationContext());
                }
                yVar = f25156d;
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return yVar;
    }

    public final void a() {
        x xVar = new x();
        if (xVar.a(this.f25157e)) {
            xVar.a();
            p.d("SystemCache", "sp cache is cleared");
        }
    }

    @Override // com.vivo.push.util.d
    public final void b(String str, String str2) {
        d dVar;
        f25155c.put(str, str2);
        if (!this.f25159g || (dVar = this.f25158f) == null) {
            return;
        }
        dVar.b(str, str2);
    }

    @Override // com.vivo.push.util.d
    public final boolean a(Context context) {
        v vVar = new v();
        this.f25158f = vVar;
        boolean a10 = vVar.a(context);
        if (!a10) {
            x xVar = new x();
            this.f25158f = xVar;
            a10 = xVar.a(context);
        }
        if (!a10) {
            this.f25158f = null;
        }
        return a10;
    }

    @Override // com.vivo.push.util.d
    public final String a(String str, String str2) {
        d dVar;
        String str3 = f25155c.get(str);
        return (str3 != null || (dVar = this.f25158f) == null) ? str3 : dVar.a(str, str2);
    }
}
