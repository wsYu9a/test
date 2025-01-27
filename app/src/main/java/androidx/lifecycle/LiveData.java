package androidx.lifecycle;

import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.arch.core.executor.ArchTaskExecutor;
import androidx.arch.core.internal.SafeIterableMap;
import androidx.lifecycle.Lifecycle;
import java.util.Iterator;
import java.util.Map;

/* loaded from: classes.dex */
public abstract class LiveData<T> {

    /* renamed from: a */
    static final int f2600a = -1;

    /* renamed from: b */
    static final Object f2601b = new Object();

    /* renamed from: c */
    final Object f2602c;

    /* renamed from: d */
    private SafeIterableMap<Observer<? super T>, LiveData<T>.ObserverWrapper> f2603d;

    /* renamed from: e */
    int f2604e;

    /* renamed from: f */
    private volatile Object f2605f;

    /* renamed from: g */
    volatile Object f2606g;

    /* renamed from: h */
    private int f2607h;

    /* renamed from: i */
    private boolean f2608i;

    /* renamed from: j */
    private boolean f2609j;
    private final Runnable k;

    /* renamed from: androidx.lifecycle.LiveData$1 */
    class AnonymousClass1 implements Runnable {
        AnonymousClass1() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.lang.Runnable
        public void run() {
            Object obj;
            synchronized (LiveData.this.f2602c) {
                obj = LiveData.this.f2606g;
                LiveData.this.f2606g = LiveData.f2601b;
            }
            LiveData.this.setValue(obj);
        }
    }

    private class AlwaysActiveObserver extends LiveData<T>.ObserverWrapper {
        AlwaysActiveObserver(Observer<? super T> observer) {
            super(observer);
        }

        @Override // androidx.lifecycle.LiveData.ObserverWrapper
        boolean d() {
            return true;
        }
    }

    class LifecycleBoundObserver extends LiveData<T>.ObserverWrapper implements LifecycleEventObserver {

        /* renamed from: e */
        @NonNull
        final LifecycleOwner f2612e;

        LifecycleBoundObserver(@NonNull LifecycleOwner lifecycleOwner, Observer<? super T> observer) {
            super(observer);
            this.f2612e = lifecycleOwner;
        }

        @Override // androidx.lifecycle.LiveData.ObserverWrapper
        void b() {
            this.f2612e.getLifecycle().removeObserver(this);
        }

        @Override // androidx.lifecycle.LiveData.ObserverWrapper
        boolean c(LifecycleOwner lifecycleOwner) {
            return this.f2612e == lifecycleOwner;
        }

        @Override // androidx.lifecycle.LiveData.ObserverWrapper
        boolean d() {
            return this.f2612e.getLifecycle().getCurrentState().isAtLeast(Lifecycle.State.STARTED);
        }

        @Override // androidx.lifecycle.LifecycleEventObserver
        public void onStateChanged(@NonNull LifecycleOwner lifecycleOwner, @NonNull Lifecycle.Event event) {
            if (this.f2612e.getLifecycle().getCurrentState() == Lifecycle.State.DESTROYED) {
                LiveData.this.removeObserver(this.f2614a);
            } else {
                a(d());
            }
        }
    }

    private abstract class ObserverWrapper {

        /* renamed from: a */
        final Observer<? super T> f2614a;

        /* renamed from: b */
        boolean f2615b;

        /* renamed from: c */
        int f2616c = -1;

        ObserverWrapper(Observer<? super T> observer) {
            this.f2614a = observer;
        }

        void a(boolean z) {
            if (z == this.f2615b) {
                return;
            }
            this.f2615b = z;
            LiveData liveData = LiveData.this;
            int i2 = liveData.f2604e;
            boolean z2 = i2 == 0;
            liveData.f2604e = i2 + (z ? 1 : -1);
            if (z2 && z) {
                liveData.e();
            }
            LiveData liveData2 = LiveData.this;
            if (liveData2.f2604e == 0 && !this.f2615b) {
                liveData2.f();
            }
            if (this.f2615b) {
                LiveData.this.c(this);
            }
        }

        void b() {
        }

        boolean c(LifecycleOwner lifecycleOwner) {
            return false;
        }

        abstract boolean d();
    }

    public LiveData(T t) {
        this.f2602c = new Object();
        this.f2603d = new SafeIterableMap<>();
        this.f2604e = 0;
        this.f2606g = f2601b;
        this.k = new Runnable() { // from class: androidx.lifecycle.LiveData.1
            AnonymousClass1() {
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.lang.Runnable
            public void run() {
                Object obj;
                synchronized (LiveData.this.f2602c) {
                    obj = LiveData.this.f2606g;
                    LiveData.this.f2606g = LiveData.f2601b;
                }
                LiveData.this.setValue(obj);
            }
        };
        this.f2605f = t;
        this.f2607h = 0;
    }

    static void a(String str) {
        if (ArchTaskExecutor.getInstance().isMainThread()) {
            return;
        }
        throw new IllegalStateException("Cannot invoke " + str + " on a background thread");
    }

    private void b(LiveData<T>.ObserverWrapper observerWrapper) {
        if (observerWrapper.f2615b) {
            if (!observerWrapper.d()) {
                observerWrapper.a(false);
                return;
            }
            int i2 = observerWrapper.f2616c;
            int i3 = this.f2607h;
            if (i2 >= i3) {
                return;
            }
            observerWrapper.f2616c = i3;
            observerWrapper.f2614a.onChanged((Object) this.f2605f);
        }
    }

    void c(@Nullable LiveData<T>.ObserverWrapper observerWrapper) {
        if (this.f2608i) {
            this.f2609j = true;
            return;
        }
        this.f2608i = true;
        do {
            this.f2609j = false;
            if (observerWrapper != null) {
                b(observerWrapper);
                observerWrapper = null;
            } else {
                SafeIterableMap<Observer<? super T>, LiveData<T>.ObserverWrapper>.IteratorWithAdditions iteratorWithAdditions = this.f2603d.iteratorWithAdditions();
                while (iteratorWithAdditions.hasNext()) {
                    b((ObserverWrapper) iteratorWithAdditions.next().getValue());
                    if (this.f2609j) {
                        break;
                    }
                }
            }
        } while (this.f2609j);
        this.f2608i = false;
    }

    int d() {
        return this.f2607h;
    }

    protected void e() {
    }

    protected void f() {
    }

    @Nullable
    public T getValue() {
        T t = (T) this.f2605f;
        if (t != f2601b) {
            return t;
        }
        return null;
    }

    public boolean hasActiveObservers() {
        return this.f2604e > 0;
    }

    public boolean hasObservers() {
        return this.f2603d.size() > 0;
    }

    @MainThread
    public void observe(@NonNull LifecycleOwner lifecycleOwner, @NonNull Observer<? super T> observer) {
        a("observe");
        if (lifecycleOwner.getLifecycle().getCurrentState() == Lifecycle.State.DESTROYED) {
            return;
        }
        LifecycleBoundObserver lifecycleBoundObserver = new LifecycleBoundObserver(lifecycleOwner, observer);
        LiveData<T>.ObserverWrapper putIfAbsent = this.f2603d.putIfAbsent(observer, lifecycleBoundObserver);
        if (putIfAbsent != null && !putIfAbsent.c(lifecycleOwner)) {
            throw new IllegalArgumentException("Cannot add the same observer with different lifecycles");
        }
        if (putIfAbsent != null) {
            return;
        }
        lifecycleOwner.getLifecycle().addObserver(lifecycleBoundObserver);
    }

    @MainThread
    public void observeForever(@NonNull Observer<? super T> observer) {
        a("observeForever");
        AlwaysActiveObserver alwaysActiveObserver = new AlwaysActiveObserver(observer);
        LiveData<T>.ObserverWrapper putIfAbsent = this.f2603d.putIfAbsent(observer, alwaysActiveObserver);
        if (putIfAbsent instanceof LifecycleBoundObserver) {
            throw new IllegalArgumentException("Cannot add the same observer with different lifecycles");
        }
        if (putIfAbsent != null) {
            return;
        }
        alwaysActiveObserver.a(true);
    }

    protected void postValue(T t) {
        boolean z;
        synchronized (this.f2602c) {
            z = this.f2606g == f2601b;
            this.f2606g = t;
        }
        if (z) {
            ArchTaskExecutor.getInstance().postToMainThread(this.k);
        }
    }

    @MainThread
    public void removeObserver(@NonNull Observer<? super T> observer) {
        a("removeObserver");
        LiveData<T>.ObserverWrapper remove = this.f2603d.remove(observer);
        if (remove == null) {
            return;
        }
        remove.b();
        remove.a(false);
    }

    @MainThread
    public void removeObservers(@NonNull LifecycleOwner lifecycleOwner) {
        a("removeObservers");
        Iterator<Map.Entry<Observer<? super T>, LiveData<T>.ObserverWrapper>> it = this.f2603d.iterator();
        while (it.hasNext()) {
            Map.Entry<Observer<? super T>, LiveData<T>.ObserverWrapper> next = it.next();
            if (next.getValue().c(lifecycleOwner)) {
                removeObserver(next.getKey());
            }
        }
    }

    @MainThread
    protected void setValue(T t) {
        a("setValue");
        this.f2607h++;
        this.f2605f = t;
        c(null);
    }

    public LiveData() {
        this.f2602c = new Object();
        this.f2603d = new SafeIterableMap<>();
        this.f2604e = 0;
        Object obj = f2601b;
        this.f2606g = obj;
        this.k = new Runnable() { // from class: androidx.lifecycle.LiveData.1
            AnonymousClass1() {
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.lang.Runnable
            public void run() {
                Object obj2;
                synchronized (LiveData.this.f2602c) {
                    obj2 = LiveData.this.f2606g;
                    LiveData.this.f2606g = LiveData.f2601b;
                }
                LiveData.this.setValue(obj2);
            }
        };
        this.f2605f = obj;
        this.f2607h = -1;
    }
}
