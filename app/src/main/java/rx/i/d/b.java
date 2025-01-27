package rx.i.d;

import android.os.Handler;
import java.util.concurrent.TimeUnit;
import rx.d;
import rx.h;
import rx.internal.schedulers.ScheduledAction;
import rx.p.f;

/* loaded from: classes5.dex */
public final class b extends d {

    /* renamed from: a */
    private final Handler f35778a;

    static class a extends d.a {

        /* renamed from: a */
        private final Handler f35779a;

        /* renamed from: b */
        private final rx.p.b f35780b = new rx.p.b();

        /* renamed from: rx.i.d.b$a$a */
        class C0846a implements rx.k.a {

            /* renamed from: a */
            final /* synthetic */ ScheduledAction f35781a;

            C0846a(ScheduledAction scheduledAction) {
                this.f35781a = scheduledAction;
            }

            @Override // rx.k.a
            public void call() {
                a.this.f35779a.removeCallbacks(this.f35781a);
            }
        }

        a(Handler handler) {
            this.f35779a = handler;
        }

        @Override // rx.d.a
        public h d(rx.k.a aVar) {
            return e(aVar, 0L, TimeUnit.MILLISECONDS);
        }

        @Override // rx.d.a
        public h e(rx.k.a aVar, long j2, TimeUnit timeUnit) {
            if (this.f35780b.isUnsubscribed()) {
                return f.e();
            }
            ScheduledAction scheduledAction = new ScheduledAction(rx.i.c.a.a().b().c(aVar));
            scheduledAction.addParent(this.f35780b);
            this.f35780b.a(scheduledAction);
            this.f35779a.postDelayed(scheduledAction, timeUnit.toMillis(j2));
            scheduledAction.add(f.a(new C0846a(scheduledAction)));
            return scheduledAction;
        }

        @Override // rx.h
        public boolean isUnsubscribed() {
            return this.f35780b.isUnsubscribed();
        }

        @Override // rx.h
        public void unsubscribe() {
            this.f35780b.unsubscribe();
        }
    }

    b(Handler handler) {
        this.f35778a = handler;
    }

    public static b c(Handler handler) {
        if (handler != null) {
            return new b(handler);
        }
        throw new NullPointerException("handler == null");
    }

    @Override // rx.d
    public d.a a() {
        return new a(this.f35778a);
    }
}
