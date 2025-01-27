package androidx.lifecycle;

import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.arch.core.internal.FastSafeIterableMap;
import androidx.arch.core.internal.SafeIterableMap;
import androidx.lifecycle.Lifecycle;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;

/* loaded from: classes.dex */
public class LifecycleRegistry extends Lifecycle {

    /* renamed from: d */
    private final WeakReference<LifecycleOwner> f2586d;

    /* renamed from: b */
    private FastSafeIterableMap<LifecycleObserver, ObserverWithState> f2584b = new FastSafeIterableMap<>();

    /* renamed from: e */
    private int f2587e = 0;

    /* renamed from: f */
    private boolean f2588f = false;

    /* renamed from: g */
    private boolean f2589g = false;

    /* renamed from: h */
    private ArrayList<Lifecycle.State> f2590h = new ArrayList<>();

    /* renamed from: c */
    private Lifecycle.State f2585c = Lifecycle.State.INITIALIZED;

    /* renamed from: androidx.lifecycle.LifecycleRegistry$1 */
    static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a */
        static final /* synthetic */ int[] f2591a;

        /* renamed from: b */
        static final /* synthetic */ int[] f2592b;

        static {
            int[] iArr = new int[Lifecycle.State.values().length];
            f2592b = iArr;
            try {
                iArr[Lifecycle.State.INITIALIZED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f2592b[Lifecycle.State.CREATED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f2592b[Lifecycle.State.STARTED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f2592b[Lifecycle.State.RESUMED.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f2592b[Lifecycle.State.DESTROYED.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            int[] iArr2 = new int[Lifecycle.Event.values().length];
            f2591a = iArr2;
            try {
                iArr2[Lifecycle.Event.ON_CREATE.ordinal()] = 1;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f2591a[Lifecycle.Event.ON_STOP.ordinal()] = 2;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f2591a[Lifecycle.Event.ON_START.ordinal()] = 3;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                f2591a[Lifecycle.Event.ON_PAUSE.ordinal()] = 4;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                f2591a[Lifecycle.Event.ON_RESUME.ordinal()] = 5;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                f2591a[Lifecycle.Event.ON_DESTROY.ordinal()] = 6;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                f2591a[Lifecycle.Event.ON_ANY.ordinal()] = 7;
            } catch (NoSuchFieldError unused12) {
            }
        }
    }

    static class ObserverWithState {

        /* renamed from: a */
        Lifecycle.State f2593a;

        /* renamed from: b */
        LifecycleEventObserver f2594b;

        ObserverWithState(LifecycleObserver lifecycleObserver, Lifecycle.State state) {
            this.f2594b = Lifecycling.f(lifecycleObserver);
            this.f2593a = state;
        }

        void a(LifecycleOwner lifecycleOwner, Lifecycle.Event event) {
            Lifecycle.State e2 = LifecycleRegistry.e(event);
            this.f2593a = LifecycleRegistry.g(this.f2593a, e2);
            this.f2594b.onStateChanged(lifecycleOwner, event);
            this.f2593a = e2;
        }
    }

    public LifecycleRegistry(@NonNull LifecycleOwner lifecycleOwner) {
        this.f2586d = new WeakReference<>(lifecycleOwner);
    }

    private void a(LifecycleOwner lifecycleOwner) {
        Iterator<Map.Entry<LifecycleObserver, ObserverWithState>> descendingIterator = this.f2584b.descendingIterator();
        while (descendingIterator.hasNext() && !this.f2589g) {
            Map.Entry<LifecycleObserver, ObserverWithState> next = descendingIterator.next();
            ObserverWithState value = next.getValue();
            while (value.f2593a.compareTo(this.f2585c) > 0 && !this.f2589g && this.f2584b.contains(next.getKey())) {
                Lifecycle.Event c2 = c(value.f2593a);
                j(e(c2));
                value.a(lifecycleOwner, c2);
                i();
            }
        }
    }

    private Lifecycle.State b(LifecycleObserver lifecycleObserver) {
        Map.Entry<LifecycleObserver, ObserverWithState> ceil = this.f2584b.ceil(lifecycleObserver);
        Lifecycle.State state = null;
        Lifecycle.State state2 = ceil != null ? ceil.getValue().f2593a : null;
        if (!this.f2590h.isEmpty()) {
            state = this.f2590h.get(r0.size() - 1);
        }
        return g(g(this.f2585c, state2), state);
    }

    private static Lifecycle.Event c(Lifecycle.State state) {
        int i2 = AnonymousClass1.f2592b[state.ordinal()];
        if (i2 == 1) {
            throw new IllegalArgumentException();
        }
        if (i2 == 2) {
            return Lifecycle.Event.ON_DESTROY;
        }
        if (i2 == 3) {
            return Lifecycle.Event.ON_STOP;
        }
        if (i2 == 4) {
            return Lifecycle.Event.ON_PAUSE;
        }
        if (i2 == 5) {
            throw new IllegalArgumentException();
        }
        throw new IllegalArgumentException("Unexpected state value " + state);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void d(LifecycleOwner lifecycleOwner) {
        SafeIterableMap<LifecycleObserver, ObserverWithState>.IteratorWithAdditions iteratorWithAdditions = this.f2584b.iteratorWithAdditions();
        while (iteratorWithAdditions.hasNext() && !this.f2589g) {
            Map.Entry next = iteratorWithAdditions.next();
            ObserverWithState observerWithState = (ObserverWithState) next.getValue();
            while (observerWithState.f2593a.compareTo(this.f2585c) < 0 && !this.f2589g && this.f2584b.contains(next.getKey())) {
                j(observerWithState.f2593a);
                observerWithState.a(lifecycleOwner, l(observerWithState.f2593a));
                i();
            }
        }
    }

    static Lifecycle.State e(Lifecycle.Event event) {
        switch (AnonymousClass1.f2591a[event.ordinal()]) {
            case 1:
            case 2:
                return Lifecycle.State.CREATED;
            case 3:
            case 4:
                return Lifecycle.State.STARTED;
            case 5:
                return Lifecycle.State.RESUMED;
            case 6:
                return Lifecycle.State.DESTROYED;
            default:
                throw new IllegalArgumentException("Unexpected event value " + event);
        }
    }

    private boolean f() {
        if (this.f2584b.size() == 0) {
            return true;
        }
        Lifecycle.State state = this.f2584b.eldest().getValue().f2593a;
        Lifecycle.State state2 = this.f2584b.newest().getValue().f2593a;
        return state == state2 && this.f2585c == state2;
    }

    static Lifecycle.State g(@NonNull Lifecycle.State state, @Nullable Lifecycle.State state2) {
        return (state2 == null || state2.compareTo(state) >= 0) ? state : state2;
    }

    private void h(Lifecycle.State state) {
        if (this.f2585c == state) {
            return;
        }
        this.f2585c = state;
        if (this.f2588f || this.f2587e != 0) {
            this.f2589g = true;
            return;
        }
        this.f2588f = true;
        k();
        this.f2588f = false;
    }

    private void i() {
        this.f2590h.remove(r0.size() - 1);
    }

    private void j(Lifecycle.State state) {
        this.f2590h.add(state);
    }

    private void k() {
        LifecycleOwner lifecycleOwner = this.f2586d.get();
        if (lifecycleOwner == null) {
            throw new IllegalStateException("LifecycleOwner of this LifecycleRegistry is alreadygarbage collected. It is too late to change lifecycle state.");
        }
        while (!f()) {
            this.f2589g = false;
            if (this.f2585c.compareTo(this.f2584b.eldest().getValue().f2593a) < 0) {
                a(lifecycleOwner);
            }
            Map.Entry<LifecycleObserver, ObserverWithState> newest = this.f2584b.newest();
            if (!this.f2589g && newest != null && this.f2585c.compareTo(newest.getValue().f2593a) > 0) {
                d(lifecycleOwner);
            }
        }
        this.f2589g = false;
    }

    private static Lifecycle.Event l(Lifecycle.State state) {
        int i2 = AnonymousClass1.f2592b[state.ordinal()];
        if (i2 != 1) {
            if (i2 == 2) {
                return Lifecycle.Event.ON_START;
            }
            if (i2 == 3) {
                return Lifecycle.Event.ON_RESUME;
            }
            if (i2 == 4) {
                throw new IllegalArgumentException();
            }
            if (i2 != 5) {
                throw new IllegalArgumentException("Unexpected state value " + state);
            }
        }
        return Lifecycle.Event.ON_CREATE;
    }

    @Override // androidx.lifecycle.Lifecycle
    public void addObserver(@NonNull LifecycleObserver lifecycleObserver) {
        LifecycleOwner lifecycleOwner;
        Lifecycle.State state = this.f2585c;
        Lifecycle.State state2 = Lifecycle.State.DESTROYED;
        if (state != state2) {
            state2 = Lifecycle.State.INITIALIZED;
        }
        ObserverWithState observerWithState = new ObserverWithState(lifecycleObserver, state2);
        if (this.f2584b.putIfAbsent(lifecycleObserver, observerWithState) == null && (lifecycleOwner = this.f2586d.get()) != null) {
            boolean z = this.f2587e != 0 || this.f2588f;
            Lifecycle.State b2 = b(lifecycleObserver);
            this.f2587e++;
            while (observerWithState.f2593a.compareTo(b2) < 0 && this.f2584b.contains(lifecycleObserver)) {
                j(observerWithState.f2593a);
                observerWithState.a(lifecycleOwner, l(observerWithState.f2593a));
                i();
                b2 = b(lifecycleObserver);
            }
            if (!z) {
                k();
            }
            this.f2587e--;
        }
    }

    @Override // androidx.lifecycle.Lifecycle
    @NonNull
    public Lifecycle.State getCurrentState() {
        return this.f2585c;
    }

    public int getObserverCount() {
        return this.f2584b.size();
    }

    public void handleLifecycleEvent(@NonNull Lifecycle.Event event) {
        h(e(event));
    }

    @MainThread
    @Deprecated
    public void markState(@NonNull Lifecycle.State state) {
        setCurrentState(state);
    }

    @Override // androidx.lifecycle.Lifecycle
    public void removeObserver(@NonNull LifecycleObserver lifecycleObserver) {
        this.f2584b.remove(lifecycleObserver);
    }

    @MainThread
    public void setCurrentState(@NonNull Lifecycle.State state) {
        h(state);
    }
}
