package ak;

import ck.g0;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.TimeUnit;
import qj.d;

/* loaded from: classes5.dex */
public abstract class c<T> {

    /* renamed from: a */
    public Queue<T> f237a;

    /* renamed from: b */
    public final int f238b;

    /* renamed from: c */
    public d.a f239c;

    public class a implements wj.a {

        /* renamed from: b */
        public final /* synthetic */ int f240b;

        /* renamed from: c */
        public final /* synthetic */ int f241c;

        public a(int i10, int i11) {
            this.f240b = i10;
            this.f241c = i11;
        }

        @Override // wj.a
        public void call() {
            int size = c.this.f237a.size();
            int i10 = 0;
            if (size < this.f240b) {
                int i11 = this.f241c - size;
                while (i10 < i11) {
                    c.this.f237a.add(c.this.c());
                    i10++;
                }
                return;
            }
            int i12 = this.f241c;
            if (size > i12) {
                int i13 = size - i12;
                while (i10 < i13) {
                    c.this.f237a.poll();
                    i10++;
                }
            }
        }
    }

    public c() {
        this(0, 0, 67L);
    }

    public T b() {
        T poll = this.f237a.poll();
        return poll == null ? c() : poll;
    }

    public abstract T c();

    public final void d(int i10) {
        if (g0.f()) {
            this.f237a = new ck.j(Math.max(this.f238b, 1024));
        } else {
            this.f237a = new ConcurrentLinkedQueue();
        }
        for (int i11 = 0; i11 < i10; i11++) {
            this.f237a.add(c());
        }
    }

    public void e(T t10) {
        if (t10 == null) {
            return;
        }
        this.f237a.offer(t10);
    }

    public void f() {
        this.f239c.unsubscribe();
    }

    public c(int i10, int i11, long j10) {
        this.f238b = i11;
        d(i10);
        d.a a10 = gk.f.a().a();
        this.f239c = a10;
        a10.d(new a(i10, i11), j10, j10, TimeUnit.SECONDS);
    }
}
