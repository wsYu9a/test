package ak;

import ck.g0;
import ck.q;
import ck.y;
import java.util.Queue;
import rx.exceptions.MissingBackpressureException;
import rx.internal.operators.NotificationLite;

/* loaded from: classes5.dex */
public class e implements qj.h {

    /* renamed from: f */
    public static final NotificationLite<Object> f244f = NotificationLite.f();

    /* renamed from: g */
    public static int f245g;

    /* renamed from: h */
    public static final int f246h;

    /* renamed from: i */
    public static c<Queue<Object>> f247i;

    /* renamed from: j */
    public static c<Queue<Object>> f248j;

    /* renamed from: b */
    public Queue<Object> f249b;

    /* renamed from: c */
    public final int f250c;

    /* renamed from: d */
    public final c<Queue<Object>> f251d;

    /* renamed from: e */
    public volatile Object f252e;

    public static class a extends c<Queue<Object>> {
        @Override // ak.c
        /* renamed from: g */
        public y<Object> c() {
            return new y<>(e.f246h);
        }
    }

    public static class b extends c<Queue<Object>> {
        @Override // ak.c
        /* renamed from: g */
        public q<Object> c() {
            return new q<>(e.f246h);
        }
    }

    static {
        f245g = 128;
        if (d.b()) {
            f245g = 16;
        }
        String property = System.getProperty("rx.ring-buffer.size");
        if (property != null) {
            try {
                f245g = Integer.parseInt(property);
            } catch (Exception e10) {
                System.err.println("Failed to set 'rx.buffer.size' with value " + property + " => " + e10.getMessage());
            }
        }
        f246h = f245g;
        f247i = new a();
        f248j = new b();
    }

    public e(Queue<Object> queue, int i10) {
        this.f249b = queue;
        this.f251d = null;
        this.f250c = i10;
    }

    public static e f() {
        return g0.f() ? new e(f248j, f246h) : new e();
    }

    public static e g() {
        return g0.f() ? new e(f247i, f246h) : new e();
    }

    public boolean a(Object obj, qj.b bVar) {
        return f244f.a(bVar, obj);
    }

    public Throwable b(Object obj) {
        return f244f.d(obj);
    }

    public int c() {
        return this.f250c - e();
    }

    public int d() {
        return this.f250c;
    }

    public int e() {
        Queue<Object> queue = this.f249b;
        if (queue == null) {
            return 0;
        }
        return queue.size();
    }

    public Object h(Object obj) {
        return f244f.e(obj);
    }

    public boolean i(Object obj) {
        return f244f.g(obj);
    }

    @Override // qj.h
    public boolean isUnsubscribed() {
        return this.f249b == null;
    }

    public boolean j() {
        Queue<Object> queue = this.f249b;
        if (queue == null) {
            return true;
        }
        return queue.isEmpty();
    }

    public boolean k(Object obj) {
        return f244f.h(obj);
    }

    public void l() {
        if (this.f252e == null) {
            this.f252e = f244f.b();
        }
    }

    public void m(Throwable th2) {
        if (this.f252e == null) {
            this.f252e = f244f.c(th2);
        }
    }

    public void n(Object obj) throws MissingBackpressureException {
        boolean z10;
        boolean z11;
        synchronized (this) {
            try {
                Queue<Object> queue = this.f249b;
                z10 = true;
                z11 = false;
                if (queue != null) {
                    z11 = !queue.offer(f244f.l(obj));
                    z10 = false;
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
        if (z10) {
            throw new IllegalStateException("This instance has been unsubscribed and the queue is no longer usable.");
        }
        if (z11) {
            throw new MissingBackpressureException();
        }
    }

    public Object o() {
        synchronized (this) {
            try {
                Queue<Object> queue = this.f249b;
                if (queue == null) {
                    return null;
                }
                Object peek = queue.peek();
                Object obj = this.f252e;
                if (peek == null && obj != null && queue.peek() == null) {
                    peek = obj;
                }
                return peek;
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public Object p() {
        synchronized (this) {
            try {
                Queue<Object> queue = this.f249b;
                if (queue == null) {
                    return null;
                }
                Object poll = queue.poll();
                Object obj = this.f252e;
                if (poll == null && obj != null && queue.peek() == null) {
                    this.f252e = null;
                    poll = obj;
                }
                return poll;
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public synchronized void q() {
        Queue<Object> queue = this.f249b;
        c<Queue<Object>> cVar = this.f251d;
        if (cVar != null && queue != null) {
            queue.clear();
            this.f249b = null;
            cVar.e(queue);
        }
    }

    @Override // qj.h
    public void unsubscribe() {
        q();
    }

    public e(c<Queue<Object>> cVar, int i10) {
        this.f251d = cVar;
        this.f249b = cVar.b();
        this.f250c = i10;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public e() {
        /*
            r2 = this;
            ak.k r0 = new ak.k
            int r1 = ak.e.f246h
            r0.<init>(r1)
            r2.<init>(r0, r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: ak.e.<init>():void");
    }
}
