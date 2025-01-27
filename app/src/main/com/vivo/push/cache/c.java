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
    protected static final Object f24975a = new Object();

    /* renamed from: b */
    protected List<T> f24976b = new ArrayList();

    /* renamed from: c */
    protected Context f24977c;

    /* renamed from: d */
    private byte[] f24978d;

    /* renamed from: e */
    private byte[] f24979e;

    public c(Context context) {
        this.f24977c = ContextDelegate.getContext(context);
        w b10 = w.b();
        b10.a(this.f24977c);
        this.f24978d = b10.c();
        this.f24979e = b10.d();
        c();
    }

    private String b() {
        return y.b(this.f24977c).a(a(), null);
    }

    private void d(String str) {
        y.b(this.f24977c).b(a(), str);
    }

    public abstract String a();

    public abstract List<T> a(String str);

    public abstract String b(String str) throws Exception;

    public final void c() {
        synchronized (f24975a) {
            g.a(a());
            this.f24976b.clear();
            c(b());
        }
    }

    public final byte[] e() {
        byte[] bArr = this.f24978d;
        return (bArr == null || bArr.length <= 0) ? w.b().c() : bArr;
    }

    public final byte[] f() {
        byte[] bArr = this.f24979e;
        return (bArr == null || bArr.length <= 0) ? w.b().d() : bArr;
    }

    public final void d() {
        synchronized (f24975a) {
            this.f24976b.clear();
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
            List<T> a10 = a(b(str));
            if (a10 != null) {
                this.f24976b.addAll(a10);
            }
        } catch (Exception e10) {
            d();
            p.d("CacheSettings", p.a(e10));
        }
    }
}
