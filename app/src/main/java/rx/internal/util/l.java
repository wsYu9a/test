package rx.internal.util;

/* loaded from: classes5.dex */
public class l implements rx.h {

    /* renamed from: a */
    private final rx.h f36816a;

    public l(rx.h hVar) {
        this.f36816a = hVar;
    }

    @Override // rx.h
    public synchronized boolean isUnsubscribed() {
        return this.f36816a.isUnsubscribed();
    }

    @Override // rx.h
    public synchronized void unsubscribe() {
        this.f36816a.unsubscribe();
    }
}
