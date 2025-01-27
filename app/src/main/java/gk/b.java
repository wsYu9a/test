package gk;

import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import qj.d;
import rx.internal.schedulers.ScheduledAction;

/* loaded from: classes5.dex */
public final class b extends qj.d {

    /* renamed from: a */
    public final Executor f26317a;

    public static final class a extends d.a implements Runnable {

        /* renamed from: b */
        public final Executor f26318b;

        /* renamed from: d */
        public final ConcurrentLinkedQueue<ScheduledAction> f26320d = new ConcurrentLinkedQueue<>();

        /* renamed from: e */
        public final AtomicInteger f26321e = new AtomicInteger();

        /* renamed from: c */
        public final ik.b f26319c = new ik.b();

        /* renamed from: gk.b$a$a */
        public class C0702a implements wj.a {

            /* renamed from: b */
            public final /* synthetic */ ik.c f26322b;

            public C0702a(ik.c cVar) {
                this.f26322b = cVar;
            }

            @Override // wj.a
            public void call() {
                a.this.f26319c.d(this.f26322b);
            }
        }

        /* renamed from: gk.b$a$b */
        public class C0703b implements wj.a {

            /* renamed from: b */
            public final /* synthetic */ ik.c f26324b;

            /* renamed from: c */
            public final /* synthetic */ wj.a f26325c;

            /* renamed from: d */
            public final /* synthetic */ qj.h f26326d;

            public C0703b(ik.c cVar, wj.a aVar, qj.h hVar) {
                this.f26324b = cVar;
                this.f26325c = aVar;
                this.f26326d = hVar;
            }

            @Override // wj.a
            public void call() {
                if (this.f26324b.isUnsubscribed()) {
                    return;
                }
                qj.h b10 = a.this.b(this.f26325c);
                this.f26324b.b(b10);
                if (b10.getClass() == ScheduledAction.class) {
                    ((ScheduledAction) b10).add(this.f26326d);
                }
            }
        }

        public a(Executor executor) {
            this.f26318b = executor;
        }

        @Override // qj.d.a
        public qj.h b(wj.a aVar) {
            if (isUnsubscribed()) {
                return ik.f.e();
            }
            ScheduledAction scheduledAction = new ScheduledAction(aVar, this.f26319c);
            this.f26319c.a(scheduledAction);
            this.f26320d.offer(scheduledAction);
            if (this.f26321e.getAndIncrement() == 0) {
                try {
                    this.f26318b.execute(this);
                } catch (RejectedExecutionException e10) {
                    this.f26319c.d(scheduledAction);
                    this.f26321e.decrementAndGet();
                    fk.d.b().a().a(e10);
                    throw e10;
                }
            }
            return scheduledAction;
        }

        @Override // qj.d.a
        public qj.h c(wj.a aVar, long j10, TimeUnit timeUnit) {
            if (j10 <= 0) {
                return b(aVar);
            }
            if (isUnsubscribed()) {
                return ik.f.e();
            }
            Executor executor = this.f26318b;
            ScheduledExecutorService a10 = executor instanceof ScheduledExecutorService ? (ScheduledExecutorService) executor : c.a();
            ik.c cVar = new ik.c();
            ik.c cVar2 = new ik.c();
            cVar2.b(cVar);
            this.f26319c.a(cVar2);
            qj.h a11 = ik.f.a(new C0702a(cVar2));
            ScheduledAction scheduledAction = new ScheduledAction(new C0703b(cVar2, aVar, a11));
            cVar.b(scheduledAction);
            try {
                scheduledAction.add(a10.schedule(scheduledAction, j10, timeUnit));
                return a11;
            } catch (RejectedExecutionException e10) {
                fk.d.b().a().a(e10);
                throw e10;
            }
        }

        @Override // qj.h
        public boolean isUnsubscribed() {
            return this.f26319c.isUnsubscribed();
        }

        @Override // java.lang.Runnable
        public void run() {
            do {
                ScheduledAction poll = this.f26320d.poll();
                if (!poll.isUnsubscribed()) {
                    poll.run();
                }
            } while (this.f26321e.decrementAndGet() > 0);
        }

        @Override // qj.h
        public void unsubscribe() {
            this.f26319c.unsubscribe();
        }
    }

    public b(Executor executor) {
        this.f26317a = executor;
    }

    @Override // qj.d
    public d.a a() {
        return new a(this.f26317a);
    }
}
