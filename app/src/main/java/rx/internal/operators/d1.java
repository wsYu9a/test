package rx.internal.operators;

import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;
import rx.a;
import rx.exceptions.MissingBackpressureException;
import rx.internal.util.a;

/* loaded from: classes5.dex */
public class d1<T> implements a.n0<T, T> {

    /* renamed from: a */
    private final Long f35971a;

    /* renamed from: b */
    private final rx.k.a f35972b;

    private static final class b<T> extends rx.g<T> implements a.InterfaceC0883a {

        /* renamed from: g */
        private final Long f35974g;

        /* renamed from: h */
        private final AtomicLong f35975h;

        /* renamed from: i */
        private final rx.g<? super T> f35976i;
        private final rx.internal.util.a k;
        private final rx.k.a m;

        /* renamed from: f */
        private final ConcurrentLinkedQueue<Object> f35973f = new ConcurrentLinkedQueue<>();

        /* renamed from: j */
        private final AtomicBoolean f35977j = new AtomicBoolean(false);
        private final NotificationLite<T> l = NotificationLite.f();

        public b(rx.g<? super T> gVar, Long l, rx.k.a aVar) {
            this.f35976i = gVar;
            this.f35974g = l;
            this.f35975h = l != null ? new AtomicLong(l.longValue()) : null;
            this.m = aVar;
            this.k = new rx.internal.util.a(this);
        }

        private boolean g() {
            long j2;
            if (this.f35975h == null) {
                return true;
            }
            do {
                j2 = this.f35975h.get();
                if (j2 <= 0) {
                    if (this.f35977j.compareAndSet(false, true)) {
                        unsubscribe();
                        this.f35976i.onError(new MissingBackpressureException("Overflowed buffer of " + this.f35974g));
                        rx.k.a aVar = this.m;
                        if (aVar != null) {
                            aVar.call();
                        }
                    }
                    return false;
                }
            } while (!this.f35975h.compareAndSet(j2, j2 - 1));
            return true;
        }

        @Override // rx.internal.util.a.InterfaceC0883a
        public void a(Throwable th) {
            if (th != null) {
                this.f35976i.onError(th);
            } else {
                this.f35976i.onCompleted();
            }
        }

        @Override // rx.internal.util.a.InterfaceC0883a
        public boolean accept(Object obj) {
            return this.l.a(this.f35976i, obj);
        }

        @Override // rx.g
        public void d() {
            e(Long.MAX_VALUE);
        }

        protected rx.c h() {
            return this.k;
        }

        @Override // rx.b
        public void onCompleted() {
            if (this.f35977j.get()) {
                return;
            }
            this.k.e();
        }

        @Override // rx.b
        public void onError(Throwable th) {
            if (this.f35977j.get()) {
                return;
            }
            this.k.f(th);
        }

        @Override // rx.b
        public void onNext(T t) {
            if (g()) {
                this.f35973f.offer(this.l.l(t));
                this.k.a();
            }
        }

        @Override // rx.internal.util.a.InterfaceC0883a
        public Object peek() {
            return this.f35973f.peek();
        }

        @Override // rx.internal.util.a.InterfaceC0883a
        public Object poll() {
            Object poll = this.f35973f.poll();
            AtomicLong atomicLong = this.f35975h;
            if (atomicLong != null && poll != null) {
                atomicLong.incrementAndGet();
            }
            return poll;
        }
    }

    private static class c {

        /* renamed from: a */
        static final d1<?> f35978a = new d1<>();

        private c() {
        }
    }

    /* synthetic */ d1(a aVar) {
        this();
    }

    public static <T> d1<T> a() {
        return (d1<T>) c.f35978a;
    }

    private d1() {
        this.f35971a = null;
        this.f35972b = null;
    }

    @Override // rx.k.o
    public rx.g<? super T> call(rx.g<? super T> gVar) {
        b bVar = new b(gVar, this.f35971a, this.f35972b);
        gVar.b(bVar);
        gVar.f(bVar.h());
        return bVar;
    }

    public d1(long j2) {
        this(j2, null);
    }

    public d1(long j2, rx.k.a aVar) {
        if (j2 > 0) {
            this.f35971a = Long.valueOf(j2);
            this.f35972b = aVar;
            return;
        }
        throw new IllegalArgumentException("Buffer capacity must be > 0");
    }
}
