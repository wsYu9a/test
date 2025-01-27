package androidx.fragment.app;

import androidx.annotation.NonNull;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleRegistry;

/* loaded from: classes.dex */
class FragmentViewLifecycleOwner implements LifecycleOwner {

    /* renamed from: a */
    private LifecycleRegistry f2517a = null;

    FragmentViewLifecycleOwner() {
    }

    void a(@NonNull Lifecycle.Event event) {
        this.f2517a.handleLifecycleEvent(event);
    }

    void b() {
        if (this.f2517a == null) {
            this.f2517a = new LifecycleRegistry(this);
        }
    }

    boolean c() {
        return this.f2517a != null;
    }

    @Override // androidx.lifecycle.LifecycleOwner
    @NonNull
    public Lifecycle getLifecycle() {
        b();
        return this.f2517a;
    }
}
