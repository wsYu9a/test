package gk;

import qj.d;

/* loaded from: classes5.dex */
public class g implements wj.a {

    /* renamed from: b */
    public final wj.a f26342b;

    /* renamed from: c */
    public final d.a f26343c;

    /* renamed from: d */
    public final long f26344d;

    public g(wj.a aVar, d.a aVar2, long j10) {
        this.f26342b = aVar;
        this.f26343c = aVar2;
        this.f26344d = j10;
    }

    @Override // wj.a
    public void call() {
        if (this.f26343c.isUnsubscribed()) {
            return;
        }
        if (this.f26344d > this.f26343c.a()) {
            long a10 = this.f26344d - this.f26343c.a();
            if (a10 > 0) {
                try {
                    Thread.sleep(a10);
                } catch (InterruptedException e10) {
                    Thread.currentThread().interrupt();
                    throw new RuntimeException(e10);
                }
            }
        }
        if (this.f26343c.isUnsubscribed()) {
            return;
        }
        this.f26342b.call();
    }
}
