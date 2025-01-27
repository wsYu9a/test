package com.vivo.push.cache;

import android.content.Context;
import android.text.TextUtils;
import com.vivo.push.util.ContextDelegate;
import com.vivo.push.util.g;
import com.vivo.push.util.p;
import com.vivo.push.util.w;
import com.vivo.push.util.y;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes4.dex */
public abstract class c<T> {

    /* renamed from: a */
    protected static final Object f30948a = new Object();

    /* renamed from: b */
    protected List<T> f30949b = new ArrayList();

    /* renamed from: c */
    protected Context f30950c;

    /* renamed from: d */
    private byte[] f30951d;

    /* renamed from: e */
    private byte[] f30952e;

    protected c(Context context) {
        this.f30950c = ContextDelegate.getContext(context);
        w b2 = w.b();
        b2.a(this.f30950c);
        this.f30951d = b2.c();
        this.f30952e = b2.d();
        c();
    }

    private String b() {
        return y.b(this.f30950c).a(a(), null);
    }

    private void d(String str) {
        y.b(this.f30950c).b(a(), str);
    }

    protected abstract String a();

    protected abstract List<T> a(String str);

    abstract String b(String str) throws Exception;

    public final void c() {
        synchronized (f30948a) {
            g.a(a());
            this.f30949b.clear();
            c(b());
        }
    }

    protected final byte[] e() {
        byte[] bArr = this.f30951d;
        return (bArr == null || bArr.length <= 0) ? w.b().c() : bArr;
    }

    protected final byte[] f() {
        byte[] bArr = this.f30952e;
        return (bArr == null || bArr.length <= 0) ? w.b().d() : bArr;
    }

    public final void d() {
        synchronized (f30948a) {
            this.f30949b.clear();
            d("");
            p.d("CacheSettings", "clear " + a() + " strApps");
        }
    }

    private void c(String str) {
        if (TextUtils.isEmpty(str)) {
            p.d("CacheSettings", "ClientManager init " + a() + " strApps empty.");
            return;
        }
        if (str.length() > 10000) {
            p.d("CacheSettings", "sync " + a() + " strApps lenght too large");
            d();
            return;
        }
        try {
            p.d("CacheSettings", "ClientManager init " + a() + " strApps : " + str);
            List<T> a2 = a(b(str));
            if (a2 != null) {
                this.f30949b.addAll(a2);
            }
        } catch (Exception e2) {
            d();
            p.d("CacheSettings", p.a(e2));
        }
    }
}
