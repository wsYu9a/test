package xj;

import ak.a;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;
import qj.a;
import rx.exceptions.MissingBackpressureException;
import rx.internal.operators.NotificationLite;

/* loaded from: classes5.dex */
public class d1<T> implements a.n0<T, T> {

    /* renamed from: b */
    public final Long f32139b;

    /* renamed from: c */
    public final wj.a f32140c;

    public static final class b<T> extends qj.g<T> implements a.InterfaceC0003a {

        /* renamed from: h */
        public final Long f32142h;

        /* renamed from: i */
        public final AtomicLong f32143i;

        /* renamed from: j */
        public final qj.g<? super T> f32144j;

        /* renamed from: l */
        public final ak.a f32146l;

        /* renamed from: n */
        public final wj.a f32148n;

        /* renamed from: g */
        public final ConcurrentLinkedQueue<Object> f32141g = new ConcurrentLinkedQueue<>();

        /* renamed from: k */
        public final AtomicBoolean f32145k = new AtomicBoolean(false);

        /* renamed from: m */
        public final NotificationLite<T> f32147m = NotificationLite.f();

        public b(qj.g<? super T> gVar, Long l10, wj.a aVar) {
            this.f32144j = gVar;
            this.f32142h = l10;
            this.f32143i = l10 != null ? new AtomicLong(l10.longValue()) : null;
            this.f32148n = aVar;
            this.f32146l = new ak.a(this);
        }

        @Override // ak.a.InterfaceC0003a
        public void a(Throwable th2) {
            if (th2 != null) {
                this.f32144j.onError(th2);
            } else {
                this.f32144j.onCompleted();
            }
        }

        @Override // ak.a.InterfaceC0003a
        public boolean accept(Object obj) {
            return this.f32147m.a(this.f32144j, obj);
        }

        @Override // qj.g
        public void d() {
            e(Long.MAX_VALUE);
        }

        public final boolean g() {
            long j10;
            if (this.f32143i == null) {
                return true;
            }
            do {
                j10 = this.f32143i.get();
                if (j10 <= 0) {
                    if (this.f32145k.compareAndSet(false, true)) {
                        unsubscribe();
                        this.f32144j.onError(new MissingBackpressureException("Overflowed buffer of " + this.f32142h));
                        wj.a aVar = this.f32148n;
                        if (aVar != null) {
                            aVar.call();
                        }
                    }
                    return false;
                }
            } while (!this.f32143i.compareAndSet(j10, j10 - 1));
            return true;
        }

        public qj.c h() {
            return this.f32146l;
        }

        @Override // qj.b
        public void onCompleted() {
            if (this.f32145k.get()) {
                return;
            }
            this.f32146l.e();
        }

        @Override // qj.b
        public void onError(Throwable th2) {
            if (this.f32145k.get()) {
                return;
            }
            this.f32146l.f(th2);
        }

        @Override // qj.b
        public void onNext(T t10) {
            if (g()) {
                this.f32141g.offer(this.f32147m.l(t10));
                this.f32146l.a();
            }
        }

        @Override // ak.a.InterfaceC0003a
        public Object peek() {
            return this.f32141g.peek();
        }

        @Override // ak.a.InterfaceC0003a
        public Object poll() {
            Object poll = this.f32141g.poll();
            AtomicLong atomicLong = this.f32143i;
            if (atomicLong != null && poll != null) {
                atomicLong.incrementAndGet();
            }
            return poll;
        }
    }

    public static class c {

        /* renamed from: a */
        public static final d1<?> f32149a = new d1<>();
    }

    public /* synthetic */ d1(a aVar) {
        this();
    }

    public static <T> d1<T> a() {
        return (d1<T>) c.f32149a;
    }

    public d1() {
        this.f32139b = null;
        this.f32140c = null;
    }

    @Override // wj.o
    public qj.g<? super T> call(qj.g<? super T> gVar) {
        b bVar = new b(gVar, this.f32139b, this.f32140c);
        gVar.b(bVar);
        gVar.f(bVar.h());
        return bVar;
    }

    public d1(long j10) {
        this(j10, null);
    }

    public d1(long j10, wj.a aVar) {
        if (j10 > 0) {
            this.f32139b = Long.valueOf(j10);
            this.f32140c = aVar;
            return;
        }
        throw new IllegalArgumentException("Buffer capacity must be > 0");
    }
}
