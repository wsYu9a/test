package ik;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import qj.h;

/* loaded from: classes5.dex */
public final class e implements h {

    /* renamed from: c */
    public static final AtomicReferenceFieldUpdater<e, a> f27044c = AtomicReferenceFieldUpdater.newUpdater(e.class, a.class, "b");

    /* renamed from: b */
    public volatile a f27045b = new a(false, f.b());

    public static final class a {

        /* renamed from: a */
        public final boolean f27046a;

        /* renamed from: b */
        public final h f27047b;

        public a(boolean z10, h hVar) {
            this.f27046a = z10;
            this.f27047b = hVar;
        }

        public a a(h hVar) {
            return new a(this.f27046a, hVar);
        }

        public a b() {
            return new a(true, this.f27047b);
        }
    }

    public h a() {
        return this.f27045b.f27047b;
    }

    public void b(h hVar) {
        a aVar;
        if (hVar == null) {
            throw new IllegalArgumentException("Subscription can not be null");
        }
        do {
            aVar = this.f27045b;
            if (aVar.f27046a) {
                hVar.unsubscribe();
                return;
            }
        } while (!k.a.a(f27044c, this, aVar, aVar.a(hVar)));
        aVar.f27047b.unsubscribe();
    }

    @Override // qj.h
    public boolean isUnsubscribed() {
        return this.f27045b.f27046a;
    }

    @Override // qj.h
    public void unsubscribe() {
        a aVar;
        do {
            aVar = this.f27045b;
            if (aVar.f27046a) {
                return;
            }
        } while (!k.a.a(f27044c, this, aVar, aVar.b()));
        aVar.f27047b.unsubscribe();
    }
}
