package ik;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import qj.h;

/* loaded from: classes5.dex */
public final class c implements h {

    /* renamed from: c */
    public static final AtomicReferenceFieldUpdater<c, a> f27031c = AtomicReferenceFieldUpdater.newUpdater(c.class, a.class, "b");

    /* renamed from: b */
    public volatile a f27032b = new a(false, f.b());

    public static final class a {

        /* renamed from: a */
        public final boolean f27033a;

        /* renamed from: b */
        public final h f27034b;

        public a(boolean z10, h hVar) {
            this.f27033a = z10;
            this.f27034b = hVar;
        }

        public a a(h hVar) {
            return new a(this.f27033a, hVar);
        }

        public a b() {
            return new a(true, this.f27034b);
        }
    }

    public h a() {
        return this.f27032b.f27034b;
    }

    public void b(h hVar) {
        a aVar;
        if (hVar == null) {
            throw new IllegalArgumentException("Subscription can not be null");
        }
        do {
            aVar = this.f27032b;
            if (aVar.f27033a) {
                hVar.unsubscribe();
                return;
            }
        } while (!k.a.a(f27031c, this, aVar, aVar.a(hVar)));
    }

    @Override // qj.h
    public boolean isUnsubscribed() {
        return this.f27032b.f27033a;
    }

    @Override // qj.h
    public void unsubscribe() {
        a aVar;
        do {
            aVar = this.f27032b;
            if (aVar.f27033a) {
                return;
            }
        } while (!k.a.a(f27031c, this, aVar, aVar.b()));
        aVar.f27034b.unsubscribe();
    }
}
