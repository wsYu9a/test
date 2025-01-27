package rx.internal.schedulers;

import ak.i;
import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import qj.h;

/* loaded from: classes5.dex */
public final class ScheduledAction extends AtomicReference<Thread> implements Runnable, h {
    private static final long serialVersionUID = -3962399486978279857L;
    final wj.a action;
    final i cancel;

    public static final class Remover extends AtomicBoolean implements h {
        private static final long serialVersionUID = 247232374289553518L;
        final ik.b parent;

        /* renamed from: s */
        final ScheduledAction f30538s;

        public Remover(ScheduledAction scheduledAction, ik.b bVar) {
            this.f30538s = scheduledAction;
            this.parent = bVar;
        }

        @Override // qj.h
        public boolean isUnsubscribed() {
            return this.f30538s.isUnsubscribed();
        }

        @Override // qj.h
        public void unsubscribe() {
            if (compareAndSet(false, true)) {
                this.parent.d(this.f30538s);
            }
        }
    }

    public static final class Remover2 extends AtomicBoolean implements h {
        private static final long serialVersionUID = 247232374289553518L;
        final i parent;

        /* renamed from: s */
        final ScheduledAction f30539s;

        public Remover2(ScheduledAction scheduledAction, i iVar) {
            this.f30539s = scheduledAction;
            this.parent = iVar;
        }

        @Override // qj.h
        public boolean isUnsubscribed() {
            return this.f30539s.isUnsubscribed();
        }

        @Override // qj.h
        public void unsubscribe() {
            if (compareAndSet(false, true)) {
                this.parent.d(this.f30539s);
            }
        }
    }

    public final class b implements h {

        /* renamed from: b */
        public final Future<?> f30540b;

        public /* synthetic */ b(ScheduledAction scheduledAction, Future future, a aVar) {
            this(future);
        }

        @Override // qj.h
        public boolean isUnsubscribed() {
            return this.f30540b.isCancelled();
        }

        @Override // qj.h
        public void unsubscribe() {
            if (ScheduledAction.this.get() != Thread.currentThread()) {
                this.f30540b.cancel(true);
            } else {
                this.f30540b.cancel(false);
            }
        }

        public b(Future<?> future) {
            this.f30540b = future;
        }
    }

    public ScheduledAction(wj.a aVar) {
        this.action = aVar;
        this.cancel = new i();
    }

    public void add(h hVar) {
        this.cancel.a(hVar);
    }

    public void addParent(ik.b bVar) {
        this.cancel.a(new Remover(this, bVar));
    }

    @Override // qj.h
    public boolean isUnsubscribed() {
        return this.cancel.isUnsubscribed();
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            lazySet(Thread.currentThread());
            this.action.call();
        } finally {
            try {
                unsubscribe();
            } catch (Throwable th2) {
            }
        }
        unsubscribe();
    }

    @Override // qj.h
    public void unsubscribe() {
        if (this.cancel.isUnsubscribed()) {
            return;
        }
        this.cancel.unsubscribe();
    }

    public void add(Future<?> future) {
        this.cancel.a(new b(future));
    }

    public void addParent(i iVar) {
        this.cancel.a(new Remover2(this, iVar));
    }

    public ScheduledAction(wj.a aVar, ik.b bVar) {
        this.action = aVar;
        this.cancel = new i(new Remover(this, bVar));
    }

    public ScheduledAction(wj.a aVar, i iVar) {
        this.action = aVar;
        this.cancel = new i(new Remover2(this, iVar));
    }
}
