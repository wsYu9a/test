package androidx.lifecycle;

import android.annotation.SuppressLint;
import android.app.Application;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.ViewModelProvider;
import androidx.savedstate.SavedStateRegistry;
import androidx.savedstate.SavedStateRegistryOwner;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;

/* loaded from: classes.dex */
public final class SavedStateViewModelFactory extends ViewModelProvider.KeyedFactory {

    /* renamed from: a */
    private static final Class<?>[] f2639a = {Application.class, SavedStateHandle.class};

    /* renamed from: b */
    private static final Class<?>[] f2640b = {SavedStateHandle.class};

    /* renamed from: c */
    private final Application f2641c;

    /* renamed from: d */
    private final ViewModelProvider.AndroidViewModelFactory f2642d;

    /* renamed from: e */
    private final Bundle f2643e;

    /* renamed from: f */
    private final Lifecycle f2644f;

    /* renamed from: g */
    private final SavedStateRegistry f2645g;

    public SavedStateViewModelFactory(@NonNull Application application, @NonNull SavedStateRegistryOwner savedStateRegistryOwner) {
        this(application, savedStateRegistryOwner, null);
    }

    private static <T> Constructor<T> b(Class<T> cls, Class<?>[] clsArr) {
        for (Object obj : cls.getConstructors()) {
            Constructor<T> constructor = (Constructor<T>) obj;
            if (Arrays.equals(clsArr, constructor.getParameterTypes())) {
                return constructor;
            }
        }
        return null;
    }

    @Override // androidx.lifecycle.ViewModelProvider.OnRequeryFactory
    void a(@NonNull ViewModel viewModel) {
        SavedStateHandleController.a(viewModel, this.f2645g, this.f2644f);
    }

    @Override // androidx.lifecycle.ViewModelProvider.KeyedFactory
    @NonNull
    public <T extends ViewModel> T create(@NonNull String str, @NonNull Class<T> cls) {
        boolean isAssignableFrom = AndroidViewModel.class.isAssignableFrom(cls);
        Constructor b2 = isAssignableFrom ? b(cls, f2639a) : b(cls, f2640b);
        if (b2 == null) {
            return (T) this.f2642d.create(cls);
        }
        SavedStateHandleController c2 = SavedStateHandleController.c(this.f2645g, this.f2644f, str, this.f2643e);
        try {
            T t = isAssignableFrom ? (T) b2.newInstance(this.f2641c, c2.d()) : (T) b2.newInstance(c2.d());
            t.e("androidx.lifecycle.savedstate.vm.tag", c2);
            return t;
        } catch (IllegalAccessException e2) {
            throw new RuntimeException("Failed to access " + cls, e2);
        } catch (InstantiationException e3) {
            throw new RuntimeException("A " + cls + " cannot be instantiated.", e3);
        } catch (InvocationTargetException e4) {
            throw new RuntimeException("An exception happened in constructor of " + cls, e4.getCause());
        }
    }

    @SuppressLint({"LambdaLast"})
    public SavedStateViewModelFactory(@NonNull Application application, @NonNull SavedStateRegistryOwner savedStateRegistryOwner, @Nullable Bundle bundle) {
        this.f2645g = savedStateRegistryOwner.getSavedStateRegistry();
        this.f2644f = savedStateRegistryOwner.getLifecycle();
        this.f2643e = bundle;
        this.f2641c = application;
        this.f2642d = ViewModelProvider.AndroidViewModelFactory.getInstance(application);
    }

    @Override // androidx.lifecycle.ViewModelProvider.KeyedFactory, androidx.lifecycle.ViewModelProvider.Factory
    @NonNull
    public <T extends ViewModel> T create(@NonNull Class<T> cls) {
        String canonicalName = cls.getCanonicalName();
        if (canonicalName != null) {
            return (T) create(canonicalName, cls);
        }
        throw new IllegalArgumentException("Local and anonymous classes can not be ViewModels");
    }
}
