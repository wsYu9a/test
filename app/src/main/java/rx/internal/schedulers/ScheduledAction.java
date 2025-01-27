package rx.internal.schedulers;

import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import rx.h;
import rx.internal.util.i;

/* loaded from: classes5.dex */
public final class ScheduledAction extends AtomicReference<Thread> implements Runnable, h {
    private static final long serialVersionUID = -3962399486978279857L;
    final rx.k.a action;
    final i cancel;

    private static final class Remover extends AtomicBoolean implements h {
        private static final long serialVersionUID = 247232374289553518L;
        final rx.p.b parent;
        final ScheduledAction s;

        public Remover(ScheduledAction scheduledAction, rx.p.b bVar) {
            this.s = scheduledAction;
            this.parent = bVar;
        }

        @Override // rx.h
        public boolean isUnsubscribed() {
            return this.s.isUnsubscribed();
        }

        @Override // rx.h
        public void unsubscribe() {
            if (compareAndSet(false, true)) {
                this.parent.d(this.s);
            }
        }
    }

    private static final class Remover2 extends AtomicBoolean implements h {
        private static final long serialVersionUID = 247232374289553518L;
        final i parent;
        final ScheduledAction s;

        public Remover2(ScheduledAction scheduledAction, i iVar) {
            this.s = scheduledAction;
            this.parent = iVar;
        }

        @Override // rx.h
        public boolean isUnsubscribed() {
            return this.s.isUnsubscribed();
        }

        @Override // rx.h
        public void unsubscribe() {
            if (compareAndSet(false, true)) {
                this.parent.d(this.s);
            }
        }
    }

    private final class b implements h {

        /* renamed from: a */
        private final Future<?> f36731a;

        /* synthetic */ b(ScheduledAction scheduledAction, Future future, a aVar) {
            this(future);
        }

        @Override // rx.h
        public boolean isUnsubscribed() {
            return this.f36731a.isCancelled();
        }

        @Override // rx.h
        public void unsubscribe() {
            if (ScheduledAction.this.get() != Thread.currentThread()) {
                this.f36731a.cancel(true);
            } else {
                this.f36731a.cancel(false);
            }
        }

        private b(Future<?> future) {
            this.f36731a = future;
        }
    }

    public ScheduledAction(rx.k.a aVar) {
        this.action = aVar;
        this.cancel = new i();
    }

    public void add(h hVar) {
        this.cancel.a(hVar);
    }

    public void addParent(rx.p.b bVar) {
        this.cancel.a(new Remover(this, bVar));
    }

    @Override // rx.h
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
            } finally {
            }
        }
    }

    @Override // rx.h
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

    public ScheduledAction(rx.k.a aVar, rx.p.b bVar) {
        this.action = aVar;
        this.cancel = new i(new Remover(this, bVar));
    }

    public ScheduledAction(rx.k.a aVar, i iVar) {
        this.action = aVar;
        this.cancel = new i(new Remover2(this, iVar));
    }
}
