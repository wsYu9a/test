package androidx.lifecycle;

import androidx.annotation.CallSuper;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.arch.core.internal.SafeIterableMap;
import java.util.Iterator;
import java.util.Map;

/* loaded from: classes.dex */
public class MediatorLiveData<T> extends MutableLiveData<T> {
    private SafeIterableMap<LiveData<?>, Source<?>> l = new SafeIterableMap<>();

    private static class Source<V> implements Observer<V> {

        /* renamed from: a */
        final LiveData<V> f2618a;

        /* renamed from: b */
        final Observer<? super V> f2619b;

        /* renamed from: c */
        int f2620c = -1;

        Source(LiveData<V> liveData, Observer<? super V> observer) {
            this.f2618a = liveData;
            this.f2619b = observer;
        }

        void a() {
            this.f2618a.observeForever(this);
        }

        void b() {
            this.f2618a.removeObserver(this);
        }

        @Override // androidx.lifecycle.Observer
        public void onChanged(@Nullable V v) {
            if (this.f2620c != this.f2618a.d()) {
                this.f2620c = this.f2618a.d();
                this.f2619b.onChanged(v);
            }
        }
    }

    @MainThread
    public <S> void addSource(@NonNull LiveData<S> liveData, @NonNull Observer<? super S> observer) {
        Source<?> source = new Source<>(liveData, observer);
        Source<?> putIfAbsent = this.l.putIfAbsent(liveData, source);
        if (putIfAbsent != null && putIfAbsent.f2619b != observer) {
            throw new IllegalArgumentException("This source was already added with the different observer");
        }
        if (putIfAbsent == null && hasActiveObservers()) {
            source.a();
        }
    }

    @Override // androidx.lifecycle.LiveData
    @CallSuper
    protected void e() {
        Iterator<Map.Entry<LiveData<?>, Source<?>>> it = this.l.iterator();
        while (it.hasNext()) {
            it.next().getValue().a();
        }
    }

    @Override // androidx.lifecycle.LiveData
    @CallSuper
    protected void f() {
        Iterator<Map.Entry<LiveData<?>, Source<?>>> it = this.l.iterator();
        while (it.hasNext()) {
            it.next().getValue().b();
        }
    }

    @MainThread
    public <S> void removeSource(@NonNull LiveData<S> liveData) {
        Source<?> remove = this.l.remove(liveData);
        if (remove != null) {
            remove.b();
        }
    }
}
