package rx.internal.util;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.TimeUnit;
import rx.d;
import rx.internal.util.m.g0;

/* loaded from: classes5.dex */
public abstract class c<T> {

    /* renamed from: a */
    private Queue<T> f36775a;

    /* renamed from: b */
    private final int f36776b;

    /* renamed from: c */
    private d.a f36777c;

    class a implements rx.k.a {

        /* renamed from: a */
        final /* synthetic */ int f36778a;

        /* renamed from: b */
        final /* synthetic */ int f36779b;

        a(int i2, int i3) {
            this.f36778a = i2;
            this.f36779b = i3;
        }

        @Override // rx.k.a
        public void call() {
            int size = c.this.f36775a.size();
            int i2 = 0;
            if (size < this.f36778a) {
                int i3 = this.f36779b - size;
                while (i2 < i3) {
                    c.this.f36775a.add(c.this.c());
                    i2++;
                }
                return;
            }
            int i4 = this.f36779b;
            if (size > i4) {
                int i5 = size - i4;
                while (i2 < i5) {
                    c.this.f36775a.poll();
                    i2++;
                }
            }
        }
    }

    public c() {
        this(0, 0, 67L);
    }

    private void d(int i2) {
        if (g0.f()) {
            this.f36775a = new rx.internal.util.m.j(Math.max(this.f36776b, 1024));
        } else {
            this.f36775a = new ConcurrentLinkedQueue();
        }
        for (int i3 = 0; i3 < i2; i3++) {
            this.f36775a.add(c());
        }
    }

    public T b() {
        T poll = this.f36775a.poll();
        return poll == null ? c() : poll;
    }

    protected abstract T c();

    public void e(T t) {
        if (t == null) {
            return;
        }
        this.f36775a.offer(t);
    }

    public void f() {
        this.f36777c.unsubscribe();
    }

    private c(int i2, int i3, long j2) {
        this.f36776b = i3;
        d(i2);
        d.a a2 = rx.n.f.a().a();
        this.f36777c = a2;
        a2.f(new a(i2, i3), j2, j2, TimeUnit.SECONDS);
    }
}
