package ik;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import qj.h;

/* loaded from: classes5.dex */
public final class a implements h {

    /* renamed from: d */
    public static final AtomicIntegerFieldUpdater<a> f27026d = AtomicIntegerFieldUpdater.newUpdater(a.class, "c");

    /* renamed from: b */
    public final wj.a f27027b;

    /* renamed from: c */
    public volatile int f27028c;

    public a() {
        this.f27027b = null;
    }

    public static a a() {
        return new a();
    }

    public static a b(wj.a aVar) {
        return new a(aVar);
    }

    @Override // qj.h
    public boolean isUnsubscribed() {
        return this.f27028c != 0;
    }

    @Override // qj.h
    public final void unsubscribe() {
        wj.a aVar;
        if (!f27026d.compareAndSet(this, 0, 1) || (aVar = this.f27027b) == null) {
            return;
        }
        aVar.call();
    }

    public a(wj.a aVar) {
        this.f27027b = aVar;
    }
}
