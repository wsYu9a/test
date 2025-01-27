package androidx.lifecycle;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.lifecycle.Lifecycle;
import androidx.savedstate.SavedStateRegistry;
import androidx.savedstate.SavedStateRegistryOwner;
import java.util.Iterator;

/* loaded from: classes.dex */
final class SavedStateHandleController implements LifecycleEventObserver {

    /* renamed from: a */
    static final String f2633a = "androidx.lifecycle.savedstate.vm.tag";

    /* renamed from: b */
    private final String f2634b;

    /* renamed from: c */
    private boolean f2635c = false;

    /* renamed from: d */
    private final SavedStateHandle f2636d;

    /* renamed from: androidx.lifecycle.SavedStateHandleController$1 */
    static class AnonymousClass1 implements LifecycleEventObserver {

        /* renamed from: b */
        final /* synthetic */ SavedStateRegistry f2638b;

        AnonymousClass1(SavedStateRegistry savedStateRegistry) {
            savedStateRegistry = savedStateRegistry;
        }

        @Override // androidx.lifecycle.LifecycleEventObserver
        public void onStateChanged(@NonNull LifecycleOwner lifecycleOwner, @NonNull Lifecycle.Event event) {
            if (event == Lifecycle.Event.ON_START) {
                Lifecycle.this.removeObserver(this);
                savedStateRegistry.runOnNextRecreation(OnRecreation.class);
            }
        }
    }

    static final class OnRecreation implements SavedStateRegistry.AutoRecreated {
        OnRecreation() {
        }

        @Override // androidx.savedstate.SavedStateRegistry.AutoRecreated
        public void onRecreated(@NonNull SavedStateRegistryOwner savedStateRegistryOwner) {
            if (!(savedStateRegistryOwner instanceof ViewModelStoreOwner)) {
                throw new IllegalStateException("Internal error: OnRecreation should be registered only on componentsthat implement ViewModelStoreOwner");
            }
            ViewModelStore viewModelStore = ((ViewModelStoreOwner) savedStateRegistryOwner).getViewModelStore();
            SavedStateRegistry savedStateRegistry = savedStateRegistryOwner.getSavedStateRegistry();
            Iterator<String> it = viewModelStore.b().iterator();
            while (it.hasNext()) {
                SavedStateHandleController.a(viewModelStore.a(it.next()), savedStateRegistry, savedStateRegistryOwner.getLifecycle());
            }
            if (viewModelStore.b().isEmpty()) {
                return;
            }
            savedStateRegistry.runOnNextRecreation(OnRecreation.class);
        }
    }

    SavedStateHandleController(String str, SavedStateHandle savedStateHandle) {
        this.f2634b = str;
        this.f2636d = savedStateHandle;
    }

    static void a(ViewModel viewModel, SavedStateRegistry savedStateRegistry, Lifecycle lifecycle) {
        SavedStateHandleController savedStateHandleController = (SavedStateHandleController) viewModel.c(f2633a);
        if (savedStateHandleController == null || savedStateHandleController.e()) {
            return;
        }
        savedStateHandleController.b(savedStateRegistry, lifecycle);
        f(savedStateRegistry, lifecycle);
    }

    static SavedStateHandleController c(SavedStateRegistry savedStateRegistry, Lifecycle lifecycle, String str, Bundle bundle) {
        SavedStateHandleController savedStateHandleController = new SavedStateHandleController(str, SavedStateHandle.a(savedStateRegistry.consumeRestoredStateForKey(str), bundle));
        savedStateHandleController.b(savedStateRegistry, lifecycle);
        f(savedStateRegistry, lifecycle);
        return savedStateHandleController;
    }

    private static void f(SavedStateRegistry savedStateRegistry, Lifecycle lifecycle) {
        Lifecycle.State currentState = lifecycle.getCurrentState();
        if (currentState == Lifecycle.State.INITIALIZED || currentState.isAtLeast(Lifecycle.State.STARTED)) {
            savedStateRegistry.runOnNextRecreation(OnRecreation.class);
        } else {
            lifecycle.addObserver(new LifecycleEventObserver() { // from class: androidx.lifecycle.SavedStateHandleController.1

                /* renamed from: b */
                final /* synthetic */ SavedStateRegistry f2638b;

                AnonymousClass1(SavedStateRegistry savedStateRegistry2) {
                    savedStateRegistry = savedStateRegistry2;
                }

                @Override // androidx.lifecycle.LifecycleEventObserver
                public void onStateChanged(@NonNull LifecycleOwner lifecycleOwner, @NonNull Lifecycle.Event event) {
                    if (event == Lifecycle.Event.ON_START) {
                        Lifecycle.this.removeObserver(this);
                        savedStateRegistry.runOnNextRecreation(OnRecreation.class);
                    }
                }
            });
        }
    }

    void b(SavedStateRegistry savedStateRegistry, Lifecycle lifecycle) {
        if (this.f2635c) {
            throw new IllegalStateException("Already attached to lifecycleOwner");
        }
        this.f2635c = true;
        lifecycle.addObserver(this);
        savedStateRegistry.registerSavedStateProvider(this.f2634b, this.f2636d.c());
    }

    SavedStateHandle d() {
        return this.f2636d;
    }

    boolean e() {
        return this.f2635c;
    }

    @Override // androidx.lifecycle.LifecycleEventObserver
    public void onStateChanged(@NonNull LifecycleOwner lifecycleOwner, @NonNull Lifecycle.Event event) {
        if (event == Lifecycle.Event.ON_DESTROY) {
            this.f2635c = false;
            lifecycleOwner.getLifecycle().removeObserver(this);
        }
    }
}
