package androidx.lifecycle;

import android.app.Application;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import java.lang.reflect.InvocationTargetException;

/* loaded from: classes.dex */
public class ViewModelProvider {

    /* renamed from: a */
    private static final String f2655a = "androidx.lifecycle.ViewModelProvider.DefaultKey";

    /* renamed from: b */
    private final Factory f2656b;

    /* renamed from: c */
    private final ViewModelStore f2657c;

    public static class AndroidViewModelFactory extends NewInstanceFactory {

        /* renamed from: b */
        private static AndroidViewModelFactory f2658b;

        /* renamed from: c */
        private Application f2659c;

        public AndroidViewModelFactory(@NonNull Application application) {
            this.f2659c = application;
        }

        @NonNull
        public static AndroidViewModelFactory getInstance(@NonNull Application application) {
            if (f2658b == null) {
                f2658b = new AndroidViewModelFactory(application);
            }
            return f2658b;
        }

        @Override // androidx.lifecycle.ViewModelProvider.NewInstanceFactory, androidx.lifecycle.ViewModelProvider.Factory
        @NonNull
        public <T extends ViewModel> T create(@NonNull Class<T> cls) {
            if (!AndroidViewModel.class.isAssignableFrom(cls)) {
                return (T) super.create(cls);
            }
            try {
                return cls.getConstructor(Application.class).newInstance(this.f2659c);
            } catch (IllegalAccessException e2) {
                throw new RuntimeException("Cannot create an instance of " + cls, e2);
            } catch (InstantiationException e3) {
                throw new RuntimeException("Cannot create an instance of " + cls, e3);
            } catch (NoSuchMethodException e4) {
                throw new RuntimeException("Cannot create an instance of " + cls, e4);
            } catch (InvocationTargetException e5) {
                throw new RuntimeException("Cannot create an instance of " + cls, e5);
            }
        }
    }

    public interface Factory {
        @NonNull
        <T extends ViewModel> T create(@NonNull Class<T> cls);
    }

    static abstract class KeyedFactory extends OnRequeryFactory implements Factory {
        KeyedFactory() {
        }

        @NonNull
        public <T extends ViewModel> T create(@NonNull Class<T> cls) {
            throw new UnsupportedOperationException("create(String, Class<?>) must be called on implementaions of KeyedFactory");
        }

        @NonNull
        public abstract <T extends ViewModel> T create(@NonNull String str, @NonNull Class<T> cls);
    }

    public static class NewInstanceFactory implements Factory {

        /* renamed from: a */
        private static NewInstanceFactory f2660a;

        @NonNull
        static NewInstanceFactory a() {
            if (f2660a == null) {
                f2660a = new NewInstanceFactory();
            }
            return f2660a;
        }

        @Override // androidx.lifecycle.ViewModelProvider.Factory
        @NonNull
        public <T extends ViewModel> T create(@NonNull Class<T> cls) {
            try {
                return cls.newInstance();
            } catch (IllegalAccessException e2) {
                throw new RuntimeException("Cannot create an instance of " + cls, e2);
            } catch (InstantiationException e3) {
                throw new RuntimeException("Cannot create an instance of " + cls, e3);
            }
        }
    }

    static class OnRequeryFactory {
        OnRequeryFactory() {
        }

        void a(@NonNull ViewModel viewModel) {
        }
    }

    public ViewModelProvider(@NonNull ViewModelStoreOwner viewModelStoreOwner) {
        this(viewModelStoreOwner.getViewModelStore(), viewModelStoreOwner instanceof HasDefaultViewModelProviderFactory ? ((HasDefaultViewModelProviderFactory) viewModelStoreOwner).getDefaultViewModelProviderFactory() : NewInstanceFactory.a());
    }

    @NonNull
    @MainThread
    public <T extends ViewModel> T get(@NonNull Class<T> cls) {
        String canonicalName = cls.getCanonicalName();
        if (canonicalName == null) {
            throw new IllegalArgumentException("Local and anonymous classes can not be ViewModels");
        }
        return (T) get("androidx.lifecycle.ViewModelProvider.DefaultKey:" + canonicalName, cls);
    }

    @NonNull
    @MainThread
    public <T extends ViewModel> T get(@NonNull String str, @NonNull Class<T> cls) {
        T t;
        T t2 = (T) this.f2657c.a(str);
        if (cls.isInstance(t2)) {
            Object obj = this.f2656b;
            if (obj instanceof OnRequeryFactory) {
                ((OnRequeryFactory) obj).a(t2);
            }
            return t2;
        }
        Factory factory = this.f2656b;
        if (factory instanceof KeyedFactory) {
            t = (T) ((KeyedFactory) factory).create(str, cls);
        } else {
            t = (T) factory.create(cls);
        }
        this.f2657c.c(str, t);
        return t;
    }

    public ViewModelProvider(@NonNull ViewModelStoreOwner viewModelStoreOwner, @NonNull Factory factory) {
        this(viewModelStoreOwner.getViewModelStore(), factory);
    }

    public ViewModelProvider(@NonNull ViewModelStore viewModelStore, @NonNull Factory factory) {
        this.f2656b = factory;
        this.f2657c = viewModelStore;
    }
}
