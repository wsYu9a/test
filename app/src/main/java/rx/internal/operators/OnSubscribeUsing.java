package rx.internal.operators;

import ek.e;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicBoolean;
import qj.a;
import qj.g;
import qj.h;
import rx.exceptions.CompositeException;
import wj.b;
import wj.n;
import wj.o;

/* loaded from: classes5.dex */
public final class OnSubscribeUsing<T, Resource> implements a.m0<T> {

    /* renamed from: b */
    public final n<Resource> f30458b;

    /* renamed from: c */
    public final o<? super Resource, ? extends qj.a<? extends T>> f30459c;

    /* renamed from: d */
    public final b<? super Resource> f30460d;

    /* renamed from: e */
    public final boolean f30461e;

    public static final class DisposeAction<Resource> extends AtomicBoolean implements wj.a, h {
        private static final long serialVersionUID = 4262875056400218316L;
        private b<? super Resource> dispose;
        private Resource resource;

        public /* synthetic */ DisposeAction(b bVar, Object obj, a aVar) {
            this(bVar, obj);
        }

        /* JADX WARN: Type inference failed for: r0v2, types: [Resource, wj.b<? super Resource>] */
        @Override // wj.a
        public void call() {
            if (compareAndSet(false, true)) {
                ?? r02 = (Resource) null;
                try {
                    this.dispose.call(this.resource);
                } finally {
                    this.resource = null;
                    this.dispose = null;
                }
            }
        }

        @Override // qj.h
        public boolean isUnsubscribed() {
            return get();
        }

        @Override // qj.h
        public void unsubscribe() {
            call();
        }

        private DisposeAction(b<? super Resource> bVar, Resource resource) {
            this.dispose = bVar;
            this.resource = resource;
            lazySet(false);
        }
    }

    public OnSubscribeUsing(n<Resource> nVar, o<? super Resource, ? extends qj.a<? extends T>> oVar, b<? super Resource> bVar, boolean z10) {
        this.f30458b = nVar;
        this.f30459c = oVar;
        this.f30460d = bVar;
        this.f30461e = z10;
    }

    public final Throwable a(wj.a aVar) {
        if (!this.f30461e) {
            return null;
        }
        try {
            aVar.call();
            return null;
        } catch (Throwable th2) {
            return th2;
        }
    }

    @Override // wj.b
    public void call(g<? super T> gVar) {
        try {
            Resource call = this.f30458b.call();
            DisposeAction disposeAction = new DisposeAction(this.f30460d, call);
            gVar.b(disposeAction);
            qj.a<? extends T> call2 = this.f30459c.call(call);
            if (this.f30461e) {
                call2 = call2.A0(disposeAction);
            }
            try {
                call2.T4(e.f(gVar));
            } catch (Throwable th2) {
                Throwable a10 = a(disposeAction);
                if (a10 != null) {
                    gVar.onError(new CompositeException(Arrays.asList(th2, a10)));
                } else {
                    gVar.onError(th2);
                }
            }
        } catch (Throwable th3) {
            gVar.onError(th3);
        }
    }
}
