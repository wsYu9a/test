package rx.p;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import rx.h;

/* loaded from: classes5.dex */
public final class e implements h {

    /* renamed from: a */
    static final AtomicReferenceFieldUpdater<e, a> f37115a = AtomicReferenceFieldUpdater.newUpdater(e.class, a.class, "b");

    /* renamed from: b */
    volatile a f37116b = new a(false, f.b());

    private static final class a {

        /* renamed from: a */
        final boolean f37117a;

        /* renamed from: b */
        final h f37118b;

        a(boolean z, h hVar) {
            this.f37117a = z;
            this.f37118b = hVar;
        }

        a a(h hVar) {
            return new a(this.f37117a, hVar);
        }

        a b() {
            return new a(true, this.f37118b);
        }
    }

    public h a() {
        return this.f37116b.f37118b;
    }

    public void b(h hVar) {
        a aVar;
        if (hVar == null) {
            throw new IllegalArgumentException("Subscription can not be null");
        }
        do {
            aVar = this.f37116b;
            if (aVar.f37117a) {
                hVar.unsubscribe();
                return;
            }
        } while (!f37115a.compareAndSet(this, aVar, aVar.a(hVar)));
        aVar.f37118b.unsubscribe();
    }

    @Override // rx.h
    public boolean isUnsubscribed() {
        return this.f37116b.f37117a;
    }

    @Override // rx.h
    public void unsubscribe() {
        a aVar;
        do {
            aVar = this.f37116b;
            if (aVar.f37117a) {
                return;
            }
        } while (!f37115a.compareAndSet(this, aVar, aVar.b()));
        aVar.f37118b.unsubscribe();
    }
}
