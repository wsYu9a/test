package com.ss.android.downloadlib.g;

import java.lang.ref.SoftReference;

/* loaded from: classes4.dex */
public class c<P, R> implements Runnable {

    /* renamed from: a */
    private P f21642a;

    /* renamed from: b */
    private R f21643b;

    /* renamed from: c */
    private int f21644c;

    /* renamed from: d */
    private SoftReference<a<P, R>> f21645d;

    /* renamed from: e */
    private c<?, P> f21646e;

    /* renamed from: f */
    private c<R, ?> f21647f;

    public interface a<PARAM, RESULT> {
        RESULT a(PARAM param);
    }

    private c(int i10, a<P, R> aVar, P p10) {
        this.f21644c = i10;
        this.f21645d = new SoftReference<>(aVar);
        this.f21642a = p10;
    }

    public static <P, R> c<P, R> a(a<P, R> aVar, P p10) {
        return new c<>(2, aVar, p10);
    }

    private R b() {
        return this.f21643b;
    }

    @Override // java.lang.Runnable
    public void run() {
        c<?, P> cVar;
        if (this.f21644c == 0 && !m.b()) {
            com.ss.android.downloadlib.g.a().b().post(this);
            return;
        }
        if (this.f21644c == 1 && m.b()) {
            com.ss.android.downloadlib.d.a().a(this);
            return;
        }
        if (this.f21644c == 2 && m.b()) {
            com.ss.android.downloadlib.d.a().b(this);
            return;
        }
        if (this.f21642a == null && (cVar = this.f21646e) != null) {
            this.f21642a = cVar.b();
        }
        a<P, R> aVar = this.f21645d.get();
        if (aVar == null) {
            return;
        }
        this.f21643b = aVar.a(this.f21642a);
        c<R, ?> cVar2 = this.f21647f;
        if (cVar2 != null) {
            cVar2.run();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public <NR> c<R, NR> a(int i10, a<R, NR> aVar) {
        c cVar = (c<R, ?>) new c(i10, aVar, null);
        this.f21647f = cVar;
        cVar.f21646e = this;
        return cVar;
    }

    public <NR> c<R, NR> a(a<R, NR> aVar) {
        return a(0, aVar);
    }

    public void a() {
        c<?, P> cVar = this.f21646e;
        if (cVar != null) {
            cVar.a();
        } else {
            run();
        }
    }
}
