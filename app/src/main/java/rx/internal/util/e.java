package rx.internal.util;

import java.util.Queue;
import rx.exceptions.MissingBackpressureException;
import rx.internal.operators.NotificationLite;
import rx.internal.util.m.g0;
import rx.internal.util.m.q;
import rx.internal.util.m.y;

/* loaded from: classes5.dex */
public class e implements rx.h {

    /* renamed from: a */
    private static final NotificationLite<Object> f36782a = NotificationLite.f();

    /* renamed from: b */
    static int f36783b;

    /* renamed from: c */
    public static final int f36784c;

    /* renamed from: d */
    private static c<Queue<Object>> f36785d;

    /* renamed from: e */
    private static c<Queue<Object>> f36786e;

    /* renamed from: f */
    private Queue<Object> f36787f;

    /* renamed from: g */
    private final int f36788g;

    /* renamed from: h */
    private final c<Queue<Object>> f36789h;

    /* renamed from: i */
    public volatile Object f36790i;

    static class a extends c<Queue<Object>> {
        a() {
        }

        @Override // rx.internal.util.c
        /* renamed from: g */
        public y<Object> c() {
            return new y<>(e.f36784c);
        }
    }

    static class b extends c<Queue<Object>> {
        b() {
        }

        @Override // rx.internal.util.c
        /* renamed from: g */
        public q<Object> c() {
            return new q<>(e.f36784c);
        }
    }

    static {
        f36783b = 128;
        if (d.b()) {
            f36783b = 16;
        }
        String property = System.getProperty("rx.ring-buffer.size");
        if (property != null) {
            try {
                f36783b = Integer.parseInt(property);
            } catch (Exception e2) {
                System.err.println("Failed to set 'rx.buffer.size' with value " + property + " => " + e2.getMessage());
            }
        }
        f36784c = f36783b;
        f36785d = new a();
        f36786e = new b();
    }

    private e(Queue<Object> queue, int i2) {
        this.f36787f = queue;
        this.f36789h = null;
        this.f36788g = i2;
    }

    public static e f() {
        return g0.f() ? new e(f36786e, f36784c) : new e();
    }

    public static e g() {
        return g0.f() ? new e(f36785d, f36784c) : new e();
    }

    public boolean a(Object obj, rx.b bVar) {
        return f36782a.a(bVar, obj);
    }

    public Throwable b(Object obj) {
        return f36782a.d(obj);
    }

    public int c() {
        return this.f36788g - e();
    }

    public int d() {
        return this.f36788g;
    }

    public int e() {
        Queue<Object> queue = this.f36787f;
        if (queue == null) {
            return 0;
        }
        return queue.size();
    }

    public Object h(Object obj) {
        return f36782a.e(obj);
    }

    public boolean i(Object obj) {
        return f36782a.g(obj);
    }

    @Override // rx.h
    public boolean isUnsubscribed() {
        return this.f36787f == null;
    }

    public boolean j() {
        Queue<Object> queue = this.f36787f;
        if (queue == null) {
            return true;
        }
        return queue.isEmpty();
    }

    public boolean k(Object obj) {
        return f36782a.h(obj);
    }

    public void l() {
        if (this.f36790i == null) {
            this.f36790i = f36782a.b();
        }
    }

    public void m(Throwable th) {
        if (this.f36790i == null) {
            this.f36790i = f36782a.c(th);
        }
    }

    public void n(Object obj) throws MissingBackpressureException {
        boolean z;
        boolean z2;
        synchronized (this) {
            Queue<Object> queue = this.f36787f;
            z = true;
            z2 = false;
            if (queue != null) {
                z2 = !queue.offer(f36782a.l(obj));
                z = false;
            }
        }
        if (z) {
            throw new IllegalStateException("This instance has been unsubscribed and the queue is no longer usable.");
        }
        if (z2) {
            throw new MissingBackpressureException();
        }
    }

    public Object o() {
        synchronized (this) {
            Queue<Object> queue = this.f36787f;
            if (queue == null) {
                return null;
            }
            Object peek = queue.peek();
            Object obj = this.f36790i;
            if (peek == null && obj != null && queue.peek() == null) {
                peek = obj;
            }
            return peek;
        }
    }

    public Object p() {
        synchronized (this) {
            Queue<Object> queue = this.f36787f;
            if (queue == null) {
                return null;
            }
            Object poll = queue.poll();
            Object obj = this.f36790i;
            if (poll == null && obj != null && queue.peek() == null) {
                this.f36790i = null;
                poll = obj;
            }
            return poll;
        }
    }

    public synchronized void q() {
        Queue<Object> queue = this.f36787f;
        c<Queue<Object>> cVar = this.f36789h;
        if (cVar != null && queue != null) {
            queue.clear();
            this.f36787f = null;
            cVar.e(queue);
        }
    }

    @Override // rx.h
    public void unsubscribe() {
        q();
    }

    private e(c<Queue<Object>> cVar, int i2) {
        this.f36789h = cVar;
        this.f36787f = cVar.b();
        this.f36788g = i2;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    e() {
        /*
            r2 = this;
            rx.internal.util.k r0 = new rx.internal.util.k
            int r1 = rx.internal.util.e.f36784c
            r0.<init>(r1)
            r2.<init>(r0, r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: rx.internal.util.e.<init>():void");
    }
}
