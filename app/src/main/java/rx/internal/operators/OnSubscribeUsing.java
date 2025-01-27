package rx.internal.operators;

import java.util.Arrays;
import java.util.concurrent.atomic.AtomicBoolean;
import rx.a;
import rx.exceptions.CompositeException;

/* loaded from: classes5.dex */
public final class OnSubscribeUsing<T, Resource> implements a.m0<T> {

    /* renamed from: a */
    private final rx.k.n<Resource> f35787a;

    /* renamed from: b */
    private final rx.k.o<? super Resource, ? extends rx.a<? extends T>> f35788b;

    /* renamed from: c */
    private final rx.k.b<? super Resource> f35789c;

    /* renamed from: d */
    private final boolean f35790d;

    private static final class DisposeAction<Resource> extends AtomicBoolean implements rx.k.a, rx.h {
        private static final long serialVersionUID = 4262875056400218316L;
        private rx.k.b<? super Resource> dispose;
        private Resource resource;

        /* synthetic */ DisposeAction(rx.k.b bVar, Object obj, a aVar) {
            this(bVar, obj);
        }

        /* JADX WARN: Type inference failed for: r0v2, types: [Resource, rx.k.b<? super Resource>] */
        @Override // rx.k.a
        public void call() {
            if (compareAndSet(false, true)) {
                ?? r0 = (Resource) null;
                try {
                    this.dispose.call(this.resource);
                } finally {
                    this.resource = null;
                    this.dispose = null;
                }
            }
        }

        @Override // rx.h
        public boolean isUnsubscribed() {
            return get();
        }

        @Override // rx.h
        public void unsubscribe() {
            call();
        }

        private DisposeAction(rx.k.b<? super Resource> bVar, Resource resource) {
            this.dispose = bVar;
            this.resource = resource;
            lazySet(false);
        }
    }

    public OnSubscribeUsing(rx.k.n<Resource> nVar, rx.k.o<? super Resource, ? extends rx.a<? extends T>> oVar, rx.k.b<? super Resource> bVar, boolean z) {
        this.f35787a = nVar;
        this.f35788b = oVar;
        this.f35789c = bVar;
        this.f35790d = z;
    }

    private Throwable a(rx.k.a aVar) {
        if (!this.f35790d) {
            return null;
        }
        try {
            aVar.call();
            return null;
        } catch (Throwable th) {
            return th;
        }
    }

    @Override // rx.k.b
    public void call(rx.g<? super T> gVar) {
        try {
            Resource call = this.f35787a.call();
            DisposeAction disposeAction = new DisposeAction(this.f35789c, call);
            gVar.b(disposeAction);
            rx.a<? extends T> call2 = this.f35788b.call(call);
            if (this.f35790d) {
                call2 = call2.A0(disposeAction);
            }
            try {
                call2.T4(rx.l.e.f(gVar));
            } catch (Throwable th) {
                Throwable a2 = a(disposeAction);
                if (a2 != null) {
                    gVar.onError(new CompositeException(Arrays.asList(th, a2)));
                } else {
                    gVar.onError(th);
                }
            }
        } catch (Throwable th2) {
            gVar.onError(th2);
        }
    }
}
