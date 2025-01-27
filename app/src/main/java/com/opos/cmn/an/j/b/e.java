package com.opos.cmn.an.j.b;

import java.util.concurrent.Callable;

/* loaded from: classes4.dex */
public final class e<T> implements Runnable {

    /* renamed from: a */
    private static final c f16600a = new c();

    /* renamed from: b */
    private static final b f16601b = new b();

    /* renamed from: c */
    private Runnable f16602c;

    /* renamed from: d */
    private Callable<T> f16603d;

    /* renamed from: e */
    private d<T, Throwable> f16604e;

    public e(f<T, Throwable> fVar) {
        this.f16602c = fVar.f16609e;
        this.f16603d = fVar.f16610f;
        this.f16604e = new d<>(fVar.f16608d == com.opos.cmn.an.j.a.a.MAIN ? f16600a : f16601b, fVar.f16607c, fVar.f16605a, fVar.f16606b);
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            Runnable runnable = this.f16602c;
            if (runnable != null) {
                runnable.run();
            } else {
                Callable<T> callable = this.f16603d;
                if (callable != null) {
                    this.f16604e.b((d<T, Throwable>) callable.call());
                }
            }
        } catch (Exception e2) {
            com.opos.cmn.an.f.a.c("RunnableWrapper", "threadpool execute error:", e2);
            this.f16604e.a((d<T, Throwable>) e2);
        }
        this.f16604e.a();
    }
}
