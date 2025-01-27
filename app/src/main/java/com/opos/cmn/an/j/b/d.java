package com.opos.cmn.an.j.b;

import java.util.concurrent.Executor;

/* loaded from: classes4.dex */
public final class d<T, K> implements com.opos.cmn.an.j.a.b, com.opos.cmn.an.j.a.c<K>, com.opos.cmn.an.j.a.d<T> {

    /* renamed from: a */
    private com.opos.cmn.an.j.a.b f16591a;

    /* renamed from: b */
    private com.opos.cmn.an.j.a.d<T> f16592b;

    /* renamed from: c */
    private com.opos.cmn.an.j.a.c<K> f16593c;

    /* renamed from: d */
    private Executor f16594d;

    /* renamed from: com.opos.cmn.an.j.b.d$1 */
    class AnonymousClass1 implements Runnable {
        AnonymousClass1() {
        }

        @Override // java.lang.Runnable
        public void run() {
            d.this.f16591a.a();
        }
    }

    /* renamed from: com.opos.cmn.an.j.b.d$2 */
    class AnonymousClass2 implements Runnable {

        /* renamed from: a */
        final /* synthetic */ Object f16596a;

        AnonymousClass2(Object obj) {
            k = obj;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.lang.Runnable
        public void run() {
            d.this.f16593c.a(k);
        }
    }

    /* renamed from: com.opos.cmn.an.j.b.d$3 */
    class AnonymousClass3 implements Runnable {

        /* renamed from: a */
        final /* synthetic */ Object f16598a;

        AnonymousClass3(Object obj) {
            t = obj;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.lang.Runnable
        public void run() {
            d.this.f16592b.b(t);
        }
    }

    public d(Executor executor, com.opos.cmn.an.j.a.b bVar, com.opos.cmn.an.j.a.d<T> dVar, com.opos.cmn.an.j.a.c<K> cVar) {
        this.f16594d = executor;
        this.f16591a = bVar;
        this.f16592b = dVar;
        this.f16593c = cVar;
    }

    @Override // com.opos.cmn.an.j.a.b
    public void a() {
        if (this.f16591a != null) {
            this.f16594d.execute(new Runnable() { // from class: com.opos.cmn.an.j.b.d.1
                AnonymousClass1() {
                }

                @Override // java.lang.Runnable
                public void run() {
                    d.this.f16591a.a();
                }
            });
        }
    }

    @Override // com.opos.cmn.an.j.a.c
    public void a(K k) {
        if (this.f16593c != null) {
            this.f16594d.execute(new Runnable() { // from class: com.opos.cmn.an.j.b.d.2

                /* renamed from: a */
                final /* synthetic */ Object f16596a;

                AnonymousClass2(Object k2) {
                    k = k2;
                }

                /* JADX WARN: Multi-variable type inference failed */
                @Override // java.lang.Runnable
                public void run() {
                    d.this.f16593c.a(k);
                }
            });
        }
    }

    @Override // com.opos.cmn.an.j.a.d
    public void b(T t) {
        if (this.f16592b != null) {
            this.f16594d.execute(new Runnable() { // from class: com.opos.cmn.an.j.b.d.3

                /* renamed from: a */
                final /* synthetic */ Object f16598a;

                AnonymousClass3(Object t2) {
                    t = t2;
                }

                /* JADX WARN: Multi-variable type inference failed */
                @Override // java.lang.Runnable
                public void run() {
                    d.this.f16592b.b(t);
                }
            });
        }
    }
}
