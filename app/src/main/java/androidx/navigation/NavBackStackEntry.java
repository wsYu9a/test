package androidx.navigation;

import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.AbstractSavedStateViewModelFactory;
import androidx.lifecycle.HasDefaultViewModelProviderFactory;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleRegistry;
import androidx.lifecycle.SavedStateHandle;
import androidx.lifecycle.SavedStateViewModelFactory;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.savedstate.SavedStateRegistry;
import androidx.savedstate.SavedStateRegistryController;
import androidx.savedstate.SavedStateRegistryOwner;
import java.util.UUID;

/* loaded from: classes.dex */
public final class NavBackStackEntry implements LifecycleOwner, ViewModelStoreOwner, HasDefaultViewModelProviderFactory, SavedStateRegistryOwner {

    /* renamed from: a */
    private final Context f2943a;

    /* renamed from: b */
    private final NavDestination f2944b;

    /* renamed from: c */
    private Bundle f2945c;

    /* renamed from: d */
    private final LifecycleRegistry f2946d;

    /* renamed from: e */
    private final SavedStateRegistryController f2947e;

    /* renamed from: f */
    @NonNull
    final UUID f2948f;

    /* renamed from: g */
    private Lifecycle.State f2949g;

    /* renamed from: h */
    private Lifecycle.State f2950h;

    /* renamed from: i */
    private NavControllerViewModel f2951i;

    /* renamed from: j */
    private ViewModelProvider.Factory f2952j;
    private SavedStateHandle k;

    /* renamed from: androidx.navigation.NavBackStackEntry$1 */
    static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a */
        static final /* synthetic */ int[] f2953a;

        static {
            int[] iArr = new int[Lifecycle.Event.values().length];
            f2953a = iArr;
            try {
                iArr[Lifecycle.Event.ON_CREATE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f2953a[Lifecycle.Event.ON_STOP.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f2953a[Lifecycle.Event.ON_START.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f2953a[Lifecycle.Event.ON_PAUSE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f2953a[Lifecycle.Event.ON_RESUME.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f2953a[Lifecycle.Event.ON_DESTROY.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f2953a[Lifecycle.Event.ON_ANY.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    private static class NavResultSavedStateFactory extends AbstractSavedStateViewModelFactory {
        NavResultSavedStateFactory(@NonNull SavedStateRegistryOwner savedStateRegistryOwner, @Nullable Bundle bundle) {
            super(savedStateRegistryOwner, bundle);
        }

        @Override // androidx.lifecycle.AbstractSavedStateViewModelFactory
        @NonNull
        protected <T extends ViewModel> T b(@NonNull String str, @NonNull Class<T> cls, @NonNull SavedStateHandle savedStateHandle) {
            return new SavedStateViewModel(savedStateHandle);
        }
    }

    private static class SavedStateViewModel extends ViewModel {

        /* renamed from: c */
        private SavedStateHandle f2954c;

        SavedStateViewModel(SavedStateHandle savedStateHandle) {
            this.f2954c = savedStateHandle;
        }

        public SavedStateHandle getHandle() {
            return this.f2954c;
        }
    }

    NavBackStackEntry(@NonNull Context context, @NonNull NavDestination navDestination, @Nullable Bundle bundle, @Nullable LifecycleOwner lifecycleOwner, @Nullable NavControllerViewModel navControllerViewModel) {
        this(context, navDestination, bundle, lifecycleOwner, navControllerViewModel, UUID.randomUUID(), null);
    }

    @NonNull
    private static Lifecycle.State b(@NonNull Lifecycle.Event event) {
        switch (AnonymousClass1.f2953a[event.ordinal()]) {
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

    @NonNull
    Lifecycle.State a() {
        return this.f2950h;
    }

    void c(@NonNull Lifecycle.Event event) {
        this.f2949g = b(event);
        g();
    }

    void d(@Nullable Bundle bundle) {
        this.f2945c = bundle;
    }

    void e(@NonNull Bundle bundle) {
        this.f2947e.performSave(bundle);
    }

    void f(@NonNull Lifecycle.State state) {
        this.f2950h = state;
        g();
    }

    void g() {
        if (this.f2949g.ordinal() < this.f2950h.ordinal()) {
            this.f2946d.setCurrentState(this.f2949g);
        } else {
            this.f2946d.setCurrentState(this.f2950h);
        }
    }

    @Nullable
    public Bundle getArguments() {
        return this.f2945c;
    }

    @Override // androidx.lifecycle.HasDefaultViewModelProviderFactory
    @NonNull
    public ViewModelProvider.Factory getDefaultViewModelProviderFactory() {
        if (this.f2952j == null) {
            this.f2952j = new SavedStateViewModelFactory((Application) this.f2943a.getApplicationContext(), this, this.f2945c);
        }
        return this.f2952j;
    }

    @NonNull
    public NavDestination getDestination() {
        return this.f2944b;
    }

    @Override // androidx.lifecycle.LifecycleOwner
    @NonNull
    public Lifecycle getLifecycle() {
        return this.f2946d;
    }

    @NonNull
    public SavedStateHandle getSavedStateHandle() {
        if (this.k == null) {
            this.k = ((SavedStateViewModel) new ViewModelProvider(this, new NavResultSavedStateFactory(this, null)).get(SavedStateViewModel.class)).getHandle();
        }
        return this.k;
    }

    @Override // androidx.savedstate.SavedStateRegistryOwner
    @NonNull
    public SavedStateRegistry getSavedStateRegistry() {
        return this.f2947e.getSavedStateRegistry();
    }

    @Override // androidx.lifecycle.ViewModelStoreOwner
    @NonNull
    public ViewModelStore getViewModelStore() {
        NavControllerViewModel navControllerViewModel = this.f2951i;
        if (navControllerViewModel != null) {
            return navControllerViewModel.h(this.f2948f);
        }
        throw new IllegalStateException("You must call setViewModelStore() on your NavHostController before accessing the ViewModelStore of a navigation graph.");
    }

    NavBackStackEntry(@NonNull Context context, @NonNull NavDestination navDestination, @Nullable Bundle bundle, @Nullable LifecycleOwner lifecycleOwner, @Nullable NavControllerViewModel navControllerViewModel, @NonNull UUID uuid, @Nullable Bundle bundle2) {
        this.f2946d = new LifecycleRegistry(this);
        SavedStateRegistryController create = SavedStateRegistryController.create(this);
        this.f2947e = create;
        this.f2949g = Lifecycle.State.CREATED;
        this.f2950h = Lifecycle.State.RESUMED;
        this.f2943a = context;
        this.f2948f = uuid;
        this.f2944b = navDestination;
        this.f2945c = bundle;
        this.f2951i = navControllerViewModel;
        create.performRestore(bundle2);
        if (lifecycleOwner != null) {
            this.f2949g = lifecycleOwner.getLifecycle().getCurrentState();
        }
    }
}
