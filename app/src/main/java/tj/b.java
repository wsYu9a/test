package tj;

import android.os.Handler;
import ik.f;
import java.util.concurrent.TimeUnit;
import qj.d;
import qj.h;
import rx.internal.schedulers.ScheduledAction;

/* loaded from: classes4.dex */
public final class b extends d {

    /* renamed from: a */
    public final Handler f30908a;

    public static class a extends d.a {

        /* renamed from: b */
        public final Handler f30909b;

        /* renamed from: c */
        public final ik.b f30910c = new ik.b();

        /* renamed from: tj.b$a$a */
        public class C0789a implements wj.a {

            /* renamed from: b */
            public final /* synthetic */ ScheduledAction f30911b;

            public C0789a(ScheduledAction scheduledAction) {
                this.f30911b = scheduledAction;
            }

            @Override // wj.a
            public void call() {
                a.this.f30909b.removeCallbacks(this.f30911b);
            }
        }

        public a(Handler handler) {
            this.f30909b = handler;
        }

        @Override // qj.d.a
        public h b(wj.a aVar) {
            return c(aVar, 0L, TimeUnit.MILLISECONDS);
        }

        @Override // qj.d.a
        public h c(wj.a aVar, long j10, TimeUnit timeUnit) {
            if (this.f30910c.isUnsubscribed()) {
                return f.e();
            }
            ScheduledAction scheduledAction = new ScheduledAction(sj.a.a().b().c(aVar));
            scheduledAction.addParent(this.f30910c);
            this.f30910c.a(scheduledAction);
            this.f30909b.postDelayed(scheduledAction, timeUnit.toMillis(j10));
            scheduledAction.add(f.a(new C0789a(scheduledAction)));
            return scheduledAction;
        }

        @Override // qj.h
        public boolean isUnsubscribed() {
            return this.f30910c.isUnsubscribed();
        }

        @Override // qj.h
        public void unsubscribe() {
            this.f30910c.unsubscribe();
        }
    }

    public b(Handler handler) {
        this.f30908a = handler;
    }

    public static b c(Handler handler) {
        if (handler != null) {
            return new b(handler);
        }
        throw new NullPointerException("handler == null");
    }

    @Override // qj.d
    public d.a a() {
        return new a(this.f30908a);
    }
}
