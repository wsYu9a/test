package androidx.lifecycle;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.lifecycle.ViewModelProvider;
import androidx.savedstate.SavedStateRegistry;
import androidx.savedstate.SavedStateRegistryOwner;

/* loaded from: classes.dex */
public abstract class AbstractSavedStateViewModelFactory extends ViewModelProvider.KeyedFactory {

    /* renamed from: a */
    static final String f2556a = "androidx.lifecycle.savedstate.vm.tag";

    /* renamed from: b */
    private final SavedStateRegistry f2557b;

    /* renamed from: c */
    private final Lifecycle f2558c;

    /* renamed from: d */
    private final Bundle f2559d;

    public AbstractSavedStateViewModelFactory(@NonNull SavedStateRegistryOwner savedStateRegistryOwner, @Nullable Bundle bundle) {
        this.f2557b = savedStateRegistryOwner.getSavedStateRegistry();
        this.f2558c = savedStateRegistryOwner.getLifecycle();
        this.f2559d = bundle;
    }

    @Override // androidx.lifecycle.ViewModelProvider.OnRequeryFactory
    void a(@NonNull ViewModel viewModel) {
        SavedStateHandleController.a(viewModel, this.f2557b, this.f2558c);
    }

    @NonNull
    protected abstract <T extends ViewModel> T b(@NonNull String str, @NonNull Class<T> cls, @NonNull SavedStateHandle savedStateHandle);

    @Override // androidx.lifecycle.ViewModelProvider.KeyedFactory
    @NonNull
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public final <T extends ViewModel> T create(@NonNull String str, @NonNull Class<T> cls) {
        SavedStateHandleController c2 = SavedStateHandleController.c(this.f2557b, this.f2558c, str, this.f2559d);
        T t = (T) b(str, cls, c2.d());
        t.e(f2556a, c2);
        return t;
    }

    @Override // androidx.lifecycle.ViewModelProvider.KeyedFactory, androidx.lifecycle.ViewModelProvider.Factory
    @NonNull
    public final <T extends ViewModel> T create(@NonNull Class<T> cls) {
        String canonicalName = cls.getCanonicalName();
        if (canonicalName != null) {
            return (T) create(canonicalName, cls);
        }
        throw new IllegalArgumentException("Local and anonymous classes can not be ViewModels");
    }
}
