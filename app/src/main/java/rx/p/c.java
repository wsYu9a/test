package rx.p;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import rx.h;

/* loaded from: classes5.dex */
public final class c implements h {

    /* renamed from: a */
    static final AtomicReferenceFieldUpdater<c, a> f37102a = AtomicReferenceFieldUpdater.newUpdater(c.class, a.class, "b");

    /* renamed from: b */
    volatile a f37103b = new a(false, f.b());

    private static final class a {

        /* renamed from: a */
        final boolean f37104a;

        /* renamed from: b */
        final h f37105b;

        a(boolean z, h hVar) {
            this.f37104a = z;
            this.f37105b = hVar;
        }

        a a(h hVar) {
            return new a(this.f37104a, hVar);
        }

        a b() {
            return new a(true, this.f37105b);
        }
    }

    public h a() {
        return this.f37103b.f37105b;
    }

    public void b(h hVar) {
        a aVar;
        if (hVar == null) {
            throw new IllegalArgumentException("Subscription can not be null");
        }
        do {
            aVar = this.f37103b;
            if (aVar.f37104a) {
                hVar.unsubscribe();
                return;
            }
        } while (!f37102a.compareAndSet(this, aVar, aVar.a(hVar)));
    }

    @Override // rx.h
    public boolean isUnsubscribed() {
        return this.f37103b.f37104a;
    }

    @Override // rx.h
    public void unsubscribe() {
        a aVar;
        do {
            aVar = this.f37103b;
            if (aVar.f37104a) {
                return;
            }
        } while (!f37102a.compareAndSet(this, aVar, aVar.b()));
        aVar.f37105b.unsubscribe();
    }
}
