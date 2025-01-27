package gk;

import java.util.concurrent.TimeUnit;
import qj.d;

/* loaded from: classes5.dex */
public final class d extends qj.d {

    /* renamed from: a */
    public static final d f26332a = new d();

    public static d c() {
        return f26332a;
    }

    @Override // qj.d
    public d.a a() {
        return new b();
    }

    public class b extends d.a implements qj.h {

        /* renamed from: b */
        public final ik.a f26333b;

        public b() {
            this.f26333b = new ik.a();
        }

        @Override // qj.d.a
        public qj.h b(wj.a aVar) {
            aVar.call();
            return ik.f.e();
        }

        @Override // qj.d.a
        public qj.h c(wj.a aVar, long j10, TimeUnit timeUnit) {
            return b(new g(aVar, this, d.this.b() + timeUnit.toMillis(j10)));
        }

        @Override // qj.h
        public boolean isUnsubscribed() {
            return this.f26333b.isUnsubscribed();
        }

        @Override // qj.h
        public void unsubscribe() {
            this.f26333b.unsubscribe();
        }

        public /* synthetic */ b(d dVar, a aVar) {
            this();
        }
    }
}
