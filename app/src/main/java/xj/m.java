package xj;

import java.util.concurrent.TimeUnit;
import qj.a;
import qj.d;

/* loaded from: classes5.dex */
public final class m<T> implements a.m0<T> {

    /* renamed from: b */
    public final qj.a<? extends T> f32425b;

    /* renamed from: c */
    public final long f32426c;

    /* renamed from: d */
    public final TimeUnit f32427d;

    /* renamed from: e */
    public final qj.d f32428e;

    public class a implements wj.a {

        /* renamed from: b */
        public final /* synthetic */ qj.g f32429b;

        public a(qj.g gVar) {
            this.f32429b = gVar;
        }

        @Override // wj.a
        public void call() {
            if (this.f32429b.isUnsubscribed()) {
                return;
            }
            m.this.f32425b.T4(ek.e.f(this.f32429b));
        }
    }

    public m(qj.a<? extends T> aVar, long j10, TimeUnit timeUnit, qj.d dVar) {
        this.f32425b = aVar;
        this.f32426c = j10;
        this.f32427d = timeUnit;
        this.f32428e = dVar;
    }

    @Override // wj.b
    public void call(qj.g<? super T> gVar) {
        d.a a10 = this.f32428e.a();
        gVar.b(a10);
        a10.c(new a(gVar), this.f32426c, this.f32427d);
    }
}
