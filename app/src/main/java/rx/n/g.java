package rx.n;

import rx.d;

/* loaded from: classes5.dex */
class g implements rx.k.a {

    /* renamed from: a */
    private final rx.k.a f36959a;

    /* renamed from: b */
    private final d.a f36960b;

    /* renamed from: c */
    private final long f36961c;

    public g(rx.k.a aVar, d.a aVar2, long j2) {
        this.f36959a = aVar;
        this.f36960b = aVar2;
        this.f36961c = j2;
    }

    @Override // rx.k.a
    public void call() {
        if (this.f36960b.isUnsubscribed()) {
            return;
        }
        if (this.f36961c > this.f36960b.c()) {
            long c2 = this.f36961c - this.f36960b.c();
            if (c2 > 0) {
                try {
                    Thread.sleep(c2);
                } catch (InterruptedException e2) {
                    Thread.currentThread().interrupt();
                    throw new RuntimeException(e2);
                }
            }
        }
        if (this.f36960b.isUnsubscribed()) {
            return;
        }
        this.f36959a.call();
    }
}
