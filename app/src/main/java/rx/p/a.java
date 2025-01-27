package rx.p;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import rx.h;

/* loaded from: classes5.dex */
public final class a implements h {

    /* renamed from: a */
    static final AtomicIntegerFieldUpdater<a> f37097a = AtomicIntegerFieldUpdater.newUpdater(a.class, "c");

    /* renamed from: b */
    private final rx.k.a f37098b;

    /* renamed from: c */
    volatile int f37099c;

    public a() {
        this.f37098b = null;
    }

    public static a a() {
        return new a();
    }

    public static a b(rx.k.a aVar) {
        return new a(aVar);
    }

    @Override // rx.h
    public boolean isUnsubscribed() {
        return this.f37099c != 0;
    }

    @Override // rx.h
    public final void unsubscribe() {
        rx.k.a aVar;
        if (!f37097a.compareAndSet(this, 0, 1) || (aVar = this.f37098b) == null) {
            return;
        }
        aVar.call();
    }

    private a(rx.k.a aVar) {
        this.f37098b = aVar;
    }
}
