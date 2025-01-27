package rx.internal.operators;

import java.util.Deque;
import java.util.concurrent.atomic.AtomicLongFieldUpdater;

/* loaded from: classes5.dex */
final class b3<T> implements rx.c {

    /* renamed from: a */
    private static final AtomicLongFieldUpdater<b3> f35911a = AtomicLongFieldUpdater.newUpdater(b3.class, "f");

    /* renamed from: b */
    private final NotificationLite<T> f35912b;

    /* renamed from: c */
    private final Deque<Object> f35913c;

    /* renamed from: d */
    private final rx.g<? super T> f35914d;

    /* renamed from: e */
    private volatile boolean f35915e = false;

    /* renamed from: f */
    private volatile long f35916f = 0;

    public b3(NotificationLite<T> notificationLite, Deque<Object> deque, rx.g<? super T> gVar) {
        this.f35912b = notificationLite;
        this.f35913c = deque;
        this.f35914d = gVar;
    }

    void a(long j2) {
        Object poll;
        if (this.f35916f == Long.MAX_VALUE) {
            if (j2 == 0) {
                try {
                    for (Object obj : this.f35913c) {
                        if (this.f35914d.isUnsubscribed()) {
                            return;
                        } else {
                            this.f35912b.a(this.f35914d, obj);
                        }
                    }
                } finally {
                    try {
                        return;
                    } finally {
                    }
                }
                return;
            }
            return;
        }
        if (j2 != 0) {
            return;
        }
        while (true) {
            long j3 = this.f35916f;
            int i2 = 0;
            while (true) {
                j3--;
                if (j3 < 0 || (poll = this.f35913c.poll()) == null) {
                    break;
                }
                if (this.f35914d.isUnsubscribed() || this.f35912b.a(this.f35914d, poll)) {
                    return;
                } else {
                    i2++;
                }
            }
            while (true) {
                long j4 = this.f35916f;
                long j5 = j4 - i2;
                if (j4 != Long.MAX_VALUE) {
                    if (f35911a.compareAndSet(this, j4, j5)) {
                        if (j5 == 0) {
                            return;
                        }
                    }
                }
            }
        }
    }

    void b() {
        if (this.f35915e) {
            return;
        }
        this.f35915e = true;
        a(0L);
    }

    @Override // rx.c
    public void request(long j2) {
        if (this.f35916f == Long.MAX_VALUE) {
            return;
        }
        long andSet = j2 == Long.MAX_VALUE ? f35911a.getAndSet(this, Long.MAX_VALUE) : a.b(f35911a, this, j2);
        if (this.f35915e) {
            a(andSet);
        }
    }
}
