package g5;

import b5.u;
import e5.f1;
import java.util.Iterator;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

@e
/* loaded from: classes2.dex */
public abstract class d {

    public static final class b extends d {

        /* renamed from: a */
        public static final b f26124a = new b();

        @Override // g5.d
        public void a(Object obj, Iterator<j> it) {
            u.E(obj);
            while (it.hasNext()) {
                it.next().d(obj);
            }
        }
    }

    public static d b() {
        return b.f26124a;
    }

    public static d c() {
        return new c();
    }

    public static d d() {
        return new C0698d();
    }

    public abstract void a(Object obj, Iterator<j> it);

    public static final class c extends d {

        /* renamed from: a */
        public final ConcurrentLinkedQueue<a> f26125a;

        public static final class a {

            /* renamed from: a */
            public final Object f26126a;

            /* renamed from: b */
            public final j f26127b;

            public /* synthetic */ a(Object obj, j jVar, a aVar) {
                this(obj, jVar);
            }

            public a(Object obj, j jVar) {
                this.f26126a = obj;
                this.f26127b = jVar;
            }
        }

        public c() {
            this.f26125a = f1.f();
        }

        @Override // g5.d
        public void a(Object obj, Iterator<j> it) {
            u.E(obj);
            while (it.hasNext()) {
                this.f26125a.add(new a(obj, it.next()));
            }
            while (true) {
                a poll = this.f26125a.poll();
                if (poll == null) {
                    return;
                } else {
                    poll.f26127b.d(poll.f26126a);
                }
            }
        }

        public /* synthetic */ c(a aVar) {
            this();
        }
    }

    /* renamed from: g5.d$d */
    public static final class C0698d extends d {

        /* renamed from: a */
        public final ThreadLocal<Queue<c>> f26128a;

        /* renamed from: b */
        public final ThreadLocal<Boolean> f26129b;

        /* renamed from: g5.d$d$a */
        public class a extends ThreadLocal<Queue<c>> {
            public a(C0698d c0698d) {
            }

            @Override // java.lang.ThreadLocal
            /* renamed from: a */
            public Queue<c> initialValue() {
                return f1.d();
            }
        }

        /* renamed from: g5.d$d$b */
        public class b extends ThreadLocal<Boolean> {
            public b(C0698d c0698d) {
            }

            @Override // java.lang.ThreadLocal
            /* renamed from: a */
            public Boolean initialValue() {
                return Boolean.FALSE;
            }
        }

        /* renamed from: g5.d$d$c */
        public static final class c {

            /* renamed from: a */
            public final Object f26130a;

            /* renamed from: b */
            public final Iterator<j> f26131b;

            public /* synthetic */ c(Object obj, Iterator it, a aVar) {
                this(obj, it);
            }

            public c(Object obj, Iterator<j> it) {
                this.f26130a = obj;
                this.f26131b = it;
            }
        }

        public C0698d() {
            this.f26128a = new a(this);
            this.f26129b = new b(this);
        }

        @Override // g5.d
        public void a(Object obj, Iterator<j> it) {
            u.E(obj);
            u.E(it);
            Queue<c> queue = this.f26128a.get();
            queue.offer(new c(obj, it));
            if (this.f26129b.get().booleanValue()) {
                return;
            }
            this.f26129b.set(Boolean.TRUE);
            while (true) {
                try {
                    c poll = queue.poll();
                    if (poll == null) {
                        return;
                    }
                    while (poll.f26131b.hasNext()) {
                        ((j) poll.f26131b.next()).d(poll.f26130a);
                    }
                } finally {
                    this.f26129b.remove();
                    this.f26128a.remove();
                }
            }
        }

        public /* synthetic */ C0698d(a aVar) {
            this();
        }
    }
}
