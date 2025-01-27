package rx.n;

import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import rx.d;
import rx.internal.schedulers.ScheduledAction;

/* loaded from: classes5.dex */
final class b extends rx.d {

    /* renamed from: a */
    final Executor f36934a;

    static final class a extends d.a implements Runnable {

        /* renamed from: a */
        final Executor f36935a;

        /* renamed from: c */
        final ConcurrentLinkedQueue<ScheduledAction> f36937c = new ConcurrentLinkedQueue<>();

        /* renamed from: d */
        final AtomicInteger f36938d = new AtomicInteger();

        /* renamed from: b */
        final rx.p.b f36936b = new rx.p.b();

        /* renamed from: rx.n.b$a$a */
        class C0889a implements rx.k.a {

            /* renamed from: a */
            final /* synthetic */ rx.p.c f36939a;

            C0889a(rx.p.c cVar) {
                this.f36939a = cVar;
            }

            @Override // rx.k.a
            public void call() {
                a.this.f36936b.d(this.f36939a);
            }
        }

        /* renamed from: rx.n.b$a$b */
        class C0890b implements rx.k.a {

            /* renamed from: a */
            final /* synthetic */ rx.p.c f36941a;

            /* renamed from: b */
            final /* synthetic */ rx.k.a f36942b;

            /* renamed from: c */
            final /* synthetic */ rx.h f36943c;

            C0890b(rx.p.c cVar, rx.k.a aVar, rx.h hVar) {
                this.f36941a = cVar;
                this.f36942b = aVar;
                this.f36943c = hVar;
            }

            @Override // rx.k.a
            public void call() {
                if (this.f36941a.isUnsubscribed()) {
                    return;
                }
                rx.h d2 = a.this.d(this.f36942b);
                this.f36941a.b(d2);
                if (d2.getClass() == ScheduledAction.class) {
                    ((ScheduledAction) d2).add(this.f36943c);
                }
            }
        }

        public a(Executor executor) {
            this.f36935a = executor;
        }

        @Override // rx.d.a
        public rx.h d(rx.k.a aVar) {
            if (isUnsubscribed()) {
                return rx.p.f.e();
            }
            ScheduledAction scheduledAction = new ScheduledAction(aVar, this.f36936b);
            this.f36936b.a(scheduledAction);
            this.f36937c.offer(scheduledAction);
            if (this.f36938d.getAndIncrement() == 0) {
                try {
                    this.f36935a.execute(this);
                } catch (RejectedExecutionException e2) {
                    this.f36936b.d(scheduledAction);
                    this.f36938d.decrementAndGet();
                    rx.m.d.b().a().a(e2);
                    throw e2;
                }
            }
            return scheduledAction;
        }

        @Override // rx.d.a
        public rx.h e(rx.k.a aVar, long j2, TimeUnit timeUnit) {
            if (j2 <= 0) {
                return d(aVar);
            }
            if (isUnsubscribed()) {
                return rx.p.f.e();
            }
            Executor executor = this.f36935a;
            ScheduledExecutorService a2 = executor instanceof ScheduledExecutorService ? (ScheduledExecutorService) executor : c.a();
            rx.p.c cVar = new rx.p.c();
            rx.p.c cVar2 = new rx.p.c();
            cVar2.b(cVar);
            this.f36936b.a(cVar2);
            rx.h a3 = rx.p.f.a(new C0889a(cVar2));
            ScheduledAction scheduledAction = new ScheduledAction(new C0890b(cVar2, aVar, a3));
            cVar.b(scheduledAction);
            try {
                scheduledAction.add(a2.schedule(scheduledAction, j2, timeUnit));
                return a3;
            } catch (RejectedExecutionException e2) {
                rx.m.d.b().a().a(e2);
                throw e2;
            }
        }

        @Override // rx.h
        public boolean isUnsubscribed() {
            return this.f36936b.isUnsubscribed();
        }

        @Override // java.lang.Runnable
        public void run() {
            do {
                ScheduledAction poll = this.f36937c.poll();
                if (!poll.isUnsubscribed()) {
                    poll.run();
                }
            } while (this.f36938d.decrementAndGet() > 0);
        }

        @Override // rx.h
        public void unsubscribe() {
            this.f36936b.unsubscribe();
        }
    }

    public b(Executor executor) {
        this.f36934a = executor;
    }

    @Override // rx.d
    public d.a a() {
        return new a(this.f36934a);
    }
}
