package gk;

import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import qj.d;

/* loaded from: classes5.dex */
public final class k extends qj.d {

    /* renamed from: a */
    public static final k f26362a = new k();

    public static final class c implements Comparable<c> {

        /* renamed from: b */
        public final wj.a f26370b;

        /* renamed from: c */
        public final Long f26371c;

        /* renamed from: d */
        public final int f26372d;

        public /* synthetic */ c(wj.a aVar, Long l10, int i10, a aVar2) {
            this(aVar, l10, i10);
        }

        @Override // java.lang.Comparable
        /* renamed from: a */
        public int compareTo(c cVar) {
            int compareTo = this.f26371c.compareTo(cVar.f26371c);
            return compareTo == 0 ? k.d(this.f26372d, cVar.f26372d) : compareTo;
        }

        public c(wj.a aVar, Long l10, int i10) {
            this.f26370b = aVar;
            this.f26371c = l10;
            this.f26372d = i10;
        }
    }

    public static int d(int i10, int i11) {
        if (i10 < i11) {
            return -1;
        }
        return i10 == i11 ? 0 : 1;
    }

    public static k e() {
        return f26362a;
    }

    @Override // qj.d
    public d.a a() {
        return new b();
    }

    public static class b extends d.a implements qj.h {

        /* renamed from: f */
        public static final AtomicIntegerFieldUpdater<b> f26363f = AtomicIntegerFieldUpdater.newUpdater(b.class, "b");

        /* renamed from: b */
        public volatile int f26364b;

        /* renamed from: c */
        public final PriorityBlockingQueue<c> f26365c;

        /* renamed from: d */
        public final ik.a f26366d;

        /* renamed from: e */
        public final AtomicInteger f26367e;

        public class a implements wj.a {

            /* renamed from: b */
            public final /* synthetic */ c f26368b;

            public a(c cVar) {
                this.f26368b = cVar;
            }

            @Override // wj.a
            public void call() {
                b.this.f26365c.remove(this.f26368b);
            }
        }

        public b() {
            this.f26365c = new PriorityBlockingQueue<>();
            this.f26366d = new ik.a();
            this.f26367e = new AtomicInteger();
        }

        @Override // qj.d.a
        public qj.h b(wj.a aVar) {
            return f(aVar, a());
        }

        @Override // qj.d.a
        public qj.h c(wj.a aVar, long j10, TimeUnit timeUnit) {
            long a10 = a() + timeUnit.toMillis(j10);
            return f(new g(aVar, this, a10), a10);
        }

        public final qj.h f(wj.a aVar, long j10) {
            if (this.f26366d.isUnsubscribed()) {
                return ik.f.e();
            }
            c cVar = new c(aVar, Long.valueOf(j10), f26363f.incrementAndGet(this));
            this.f26365c.add(cVar);
            if (this.f26367e.getAndIncrement() != 0) {
                return ik.f.a(new a(cVar));
            }
            do {
                c poll = this.f26365c.poll();
                if (poll != null) {
                    poll.f26370b.call();
                }
            } while (this.f26367e.decrementAndGet() > 0);
            return ik.f.e();
        }

        @Override // qj.h
        public boolean isUnsubscribed() {
            return this.f26366d.isUnsubscribed();
        }

        @Override // qj.h
        public void unsubscribe() {
            this.f26366d.unsubscribe();
        }

        public /* synthetic */ b(a aVar) {
            this();
        }
    }
}
