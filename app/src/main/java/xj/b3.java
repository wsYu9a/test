package xj;

import java.util.Deque;
import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import rx.internal.operators.NotificationLite;

/* loaded from: classes5.dex */
public final class b3<T> implements qj.c {

    /* renamed from: g */
    public static final AtomicLongFieldUpdater<b3> f32079g = AtomicLongFieldUpdater.newUpdater(b3.class, "f");

    /* renamed from: b */
    public final NotificationLite<T> f32080b;

    /* renamed from: c */
    public final Deque<Object> f32081c;

    /* renamed from: d */
    public final qj.g<? super T> f32082d;

    /* renamed from: e */
    public volatile boolean f32083e = false;

    /* renamed from: f */
    public volatile long f32084f = 0;

    public b3(NotificationLite<T> notificationLite, Deque<Object> deque, qj.g<? super T> gVar) {
        this.f32080b = notificationLite;
        this.f32081c = deque;
        this.f32082d = gVar;
    }

    public void a(long j10) {
        Object poll;
        if (this.f32084f == Long.MAX_VALUE) {
            if (j10 == 0) {
                try {
                    for (Object obj : this.f32081c) {
                        if (this.f32082d.isUnsubscribed()) {
                            return;
                        } else {
                            this.f32080b.a(this.f32082d, obj);
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
        if (j10 != 0) {
            return;
        }
        while (true) {
            long j11 = this.f32084f;
            int i10 = 0;
            while (true) {
                j11--;
                if (j11 < 0 || (poll = this.f32081c.poll()) == null) {
                    break;
                }
                if (this.f32082d.isUnsubscribed() || this.f32080b.a(this.f32082d, poll)) {
                    return;
                } else {
                    i10++;
                }
            }
            while (true) {
                long j12 = this.f32084f;
                long j13 = j12 - i10;
                if (j12 != Long.MAX_VALUE) {
                    if (f32079g.compareAndSet(this, j12, j13)) {
                        if (j13 == 0) {
                            return;
                        }
                    }
                }
            }
        }
    }

    public void b() {
        if (this.f32083e) {
            return;
        }
        this.f32083e = true;
        a(0L);
    }

    @Override // qj.c
    public void request(long j10) {
        if (this.f32084f == Long.MAX_VALUE) {
            return;
        }
        long andSet = j10 == Long.MAX_VALUE ? f32079g.getAndSet(this, Long.MAX_VALUE) : a.b(f32079g, this, j10);
        if (this.f32083e) {
            a(andSet);
        }
    }
}
