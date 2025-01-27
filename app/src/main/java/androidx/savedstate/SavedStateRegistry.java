package androidx.savedstate;

import android.annotation.SuppressLint;
import android.os.Bundle;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.arch.core.internal.SafeIterableMap;
import androidx.lifecycle.GenericLifecycleObserver;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.savedstate.Recreator;
import java.util.Map;

@SuppressLint({"RestrictedApi"})
/* loaded from: classes.dex */
public final class SavedStateRegistry {

    /* renamed from: a */
    private static final String f3562a = "androidx.lifecycle.BundlableSavedStateRegistry.key";

    /* renamed from: c */
    @Nullable
    private Bundle f3564c;

    /* renamed from: d */
    private boolean f3565d;

    /* renamed from: e */
    private Recreator.SavedStateProvider f3566e;

    /* renamed from: b */
    private SafeIterableMap<String, SavedStateProvider> f3563b = new SafeIterableMap<>();

    /* renamed from: f */
    boolean f3567f = true;

    /* renamed from: androidx.savedstate.SavedStateRegistry$1 */
    class AnonymousClass1 implements GenericLifecycleObserver {
        AnonymousClass1() {
        }

        @Override // androidx.lifecycle.LifecycleEventObserver
        public void onStateChanged(LifecycleOwner lifecycleOwner, Lifecycle.Event event) {
            if (event == Lifecycle.Event.ON_START) {
                SavedStateRegistry.this.f3567f = true;
            } else if (event == Lifecycle.Event.ON_STOP) {
                SavedStateRegistry.this.f3567f = false;
            }
        }
    }

    public interface AutoRecreated {
        void onRecreated(@NonNull SavedStateRegistryOwner savedStateRegistryOwner);
    }

    public interface SavedStateProvider {
        @NonNull
        Bundle saveState();
    }

    SavedStateRegistry() {
    }

    @MainThread
    void a(@NonNull Lifecycle lifecycle, @Nullable Bundle bundle) {
        if (this.f3565d) {
            throw new IllegalStateException("SavedStateRegistry was already restored.");
        }
        if (bundle != null) {
            this.f3564c = bundle.getBundle(f3562a);
        }
        lifecycle.addObserver(new GenericLifecycleObserver() { // from class: androidx.savedstate.SavedStateRegistry.1
            AnonymousClass1() {
            }

            @Override // androidx.lifecycle.LifecycleEventObserver
            public void onStateChanged(LifecycleOwner lifecycleOwner, Lifecycle.Event event) {
                if (event == Lifecycle.Event.ON_START) {
                    SavedStateRegistry.this.f3567f = true;
                } else if (event == Lifecycle.Event.ON_STOP) {
                    SavedStateRegistry.this.f3567f = false;
                }
            }
        });
        this.f3565d = true;
    }

    @MainThread
    void b(@NonNull Bundle bundle) {
        Bundle bundle2 = new Bundle();
        Bundle bundle3 = this.f3564c;
        if (bundle3 != null) {
            bundle2.putAll(bundle3);
        }
        SafeIterableMap<String, SavedStateProvider>.IteratorWithAdditions iteratorWithAdditions = this.f3563b.iteratorWithAdditions();
        while (iteratorWithAdditions.hasNext()) {
            Map.Entry next = iteratorWithAdditions.next();
            bundle2.putBundle((String) next.getKey(), ((SavedStateProvider) next.getValue()).saveState());
        }
        bundle.putBundle(f3562a, bundle2);
    }

    @Nullable
    @MainThread
    public Bundle consumeRestoredStateForKey(@NonNull String str) {
        if (!this.f3565d) {
            throw new IllegalStateException("You can consumeRestoredStateForKey only after super.onCreate of corresponding component");
        }
        Bundle bundle = this.f3564c;
        if (bundle == null) {
            return null;
        }
        Bundle bundle2 = bundle.getBundle(str);
        this.f3564c.remove(str);
        if (this.f3564c.isEmpty()) {
            this.f3564c = null;
        }
        return bundle2;
    }

    @MainThread
    public boolean isRestored() {
        return this.f3565d;
    }

    @MainThread
    public void registerSavedStateProvider(@NonNull String str, @NonNull SavedStateProvider savedStateProvider) {
        if (this.f3563b.putIfAbsent(str, savedStateProvider) != null) {
            throw new IllegalArgumentException("SavedStateProvider with the given key is already registered");
        }
    }

    @MainThread
    public void runOnNextRecreation(@NonNull Class<? extends AutoRecreated> cls) {
        if (!this.f3567f) {
            throw new IllegalStateException("Can not perform this action after onSaveInstanceState");
        }
        if (this.f3566e == null) {
            this.f3566e = new Recreator.SavedStateProvider(this);
        }
        try {
            cls.getDeclaredConstructor(new Class[0]);
            this.f3566e.a(cls.getName());
        } catch (NoSuchMethodException e2) {
            throw new IllegalArgumentException("Class" + cls.getSimpleName() + " must have default constructor in order to be automatically recreated", e2);
        }
    }

    @MainThread
    public void unregisterSavedStateProvider(@NonNull String str) {
        this.f3563b.remove(str);
    }
}
