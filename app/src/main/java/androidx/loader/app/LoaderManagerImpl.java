package androidx.loader.app;

import android.os.Bundle;
import android.os.Looper;
import android.util.Log;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.collection.SparseArrayCompat;
import androidx.core.util.DebugUtils;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.loader.app.LoaderManager;
import androidx.loader.content.Loader;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.lang.reflect.Modifier;

/* loaded from: classes.dex */
class LoaderManagerImpl extends LoaderManager {

    /* renamed from: a */
    static final String f2662a = "LoaderManager";

    /* renamed from: b */
    static boolean f2663b;

    /* renamed from: c */
    @NonNull
    private final LifecycleOwner f2664c;

    /* renamed from: d */
    @NonNull
    private final LoaderViewModel f2665d;

    public static class LoaderInfo<D> extends MutableLiveData<D> implements Loader.OnLoadCompleteListener<D> {
        private final int l;

        @Nullable
        private final Bundle m;

        @NonNull
        private final Loader<D> n;
        private LifecycleOwner o;
        private LoaderObserver<D> p;
        private Loader<D> q;

        LoaderInfo(int i2, @Nullable Bundle bundle, @NonNull Loader<D> loader, @Nullable Loader<D> loader2) {
            this.l = i2;
            this.m = bundle;
            this.n = loader;
            this.q = loader2;
            loader.registerListener(i2, this);
        }

        public void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
            printWriter.print(str);
            printWriter.print("mId=");
            printWriter.print(this.l);
            printWriter.print(" mArgs=");
            printWriter.println(this.m);
            printWriter.print(str);
            printWriter.print("mLoader=");
            printWriter.println(this.n);
            this.n.dump(str + "  ", fileDescriptor, printWriter, strArr);
            if (this.p != null) {
                printWriter.print(str);
                printWriter.print("mCallbacks=");
                printWriter.println(this.p);
                this.p.dump(str + "  ", printWriter);
            }
            printWriter.print(str);
            printWriter.print("mData=");
            printWriter.println(h().dataToString(getValue()));
            printWriter.print(str);
            printWriter.print("mStarted=");
            printWriter.println(hasActiveObservers());
        }

        @Override // androidx.lifecycle.LiveData
        protected void e() {
            if (LoaderManagerImpl.f2663b) {
                Log.v(LoaderManagerImpl.f2662a, "  Starting: " + this);
            }
            this.n.startLoading();
        }

        @Override // androidx.lifecycle.LiveData
        protected void f() {
            if (LoaderManagerImpl.f2663b) {
                Log.v(LoaderManagerImpl.f2662a, "  Stopping: " + this);
            }
            this.n.stopLoading();
        }

        @MainThread
        Loader<D> g(boolean z) {
            if (LoaderManagerImpl.f2663b) {
                Log.v(LoaderManagerImpl.f2662a, "  Destroying: " + this);
            }
            this.n.cancelLoad();
            this.n.abandon();
            LoaderObserver<D> loaderObserver = this.p;
            if (loaderObserver != null) {
                removeObserver(loaderObserver);
                if (z) {
                    loaderObserver.b();
                }
            }
            this.n.unregisterListener(this);
            if ((loaderObserver == null || loaderObserver.a()) && !z) {
                return this.n;
            }
            this.n.reset();
            return this.q;
        }

        @NonNull
        Loader<D> h() {
            return this.n;
        }

        boolean i() {
            LoaderObserver<D> loaderObserver;
            return (!hasActiveObservers() || (loaderObserver = this.p) == null || loaderObserver.a()) ? false : true;
        }

        void j() {
            LifecycleOwner lifecycleOwner = this.o;
            LoaderObserver<D> loaderObserver = this.p;
            if (lifecycleOwner == null || loaderObserver == null) {
                return;
            }
            super.removeObserver(loaderObserver);
            observe(lifecycleOwner, loaderObserver);
        }

        @NonNull
        @MainThread
        Loader<D> k(@NonNull LifecycleOwner lifecycleOwner, @NonNull LoaderManager.LoaderCallbacks<D> loaderCallbacks) {
            LoaderObserver<D> loaderObserver = new LoaderObserver<>(this.n, loaderCallbacks);
            observe(lifecycleOwner, loaderObserver);
            LoaderObserver<D> loaderObserver2 = this.p;
            if (loaderObserver2 != null) {
                removeObserver(loaderObserver2);
            }
            this.o = lifecycleOwner;
            this.p = loaderObserver;
            return this.n;
        }

        @Override // androidx.loader.content.Loader.OnLoadCompleteListener
        public void onLoadComplete(@NonNull Loader<D> loader, @Nullable D d2) {
            if (LoaderManagerImpl.f2663b) {
                Log.v(LoaderManagerImpl.f2662a, "onLoadComplete: " + this);
            }
            if (Looper.myLooper() == Looper.getMainLooper()) {
                setValue(d2);
                return;
            }
            if (LoaderManagerImpl.f2663b) {
                Log.w(LoaderManagerImpl.f2662a, "onLoadComplete was incorrectly called on a background thread");
            }
            postValue(d2);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // androidx.lifecycle.LiveData
        public void removeObserver(@NonNull Observer<? super D> observer) {
            super.removeObserver(observer);
            this.o = null;
            this.p = null;
        }

        @Override // androidx.lifecycle.MutableLiveData, androidx.lifecycle.LiveData
        public void setValue(D d2) {
            super.setValue(d2);
            Loader<D> loader = this.q;
            if (loader != null) {
                loader.reset();
                this.q = null;
            }
        }

        public String toString() {
            StringBuilder sb = new StringBuilder(64);
            sb.append("LoaderInfo{");
            sb.append(Integer.toHexString(System.identityHashCode(this)));
            sb.append(" #");
            sb.append(this.l);
            sb.append(" : ");
            DebugUtils.buildShortClassTag(this.n, sb);
            sb.append("}}");
            return sb.toString();
        }
    }

    static class LoaderObserver<D> implements Observer<D> {

        /* renamed from: a */
        @NonNull
        private final Loader<D> f2666a;

        /* renamed from: b */
        @NonNull
        private final LoaderManager.LoaderCallbacks<D> f2667b;

        /* renamed from: c */
        private boolean f2668c = false;

        LoaderObserver(@NonNull Loader<D> loader, @NonNull LoaderManager.LoaderCallbacks<D> loaderCallbacks) {
            this.f2666a = loader;
            this.f2667b = loaderCallbacks;
        }

        boolean a() {
            return this.f2668c;
        }

        @MainThread
        void b() {
            if (this.f2668c) {
                if (LoaderManagerImpl.f2663b) {
                    Log.v(LoaderManagerImpl.f2662a, "  Resetting: " + this.f2666a);
                }
                this.f2667b.onLoaderReset(this.f2666a);
            }
        }

        public void dump(String str, PrintWriter printWriter) {
            printWriter.print(str);
            printWriter.print("mDeliveredData=");
            printWriter.println(this.f2668c);
        }

        @Override // androidx.lifecycle.Observer
        public void onChanged(@Nullable D d2) {
            if (LoaderManagerImpl.f2663b) {
                Log.v(LoaderManagerImpl.f2662a, "  onLoadFinished in " + this.f2666a + ": " + this.f2666a.dataToString(d2));
            }
            this.f2667b.onLoadFinished(this.f2666a, d2);
            this.f2668c = true;
        }

        public String toString() {
            return this.f2667b.toString();
        }
    }

    static class LoaderViewModel extends ViewModel {

        /* renamed from: c */
        private static final ViewModelProvider.Factory f2669c = new ViewModelProvider.Factory() { // from class: androidx.loader.app.LoaderManagerImpl.LoaderViewModel.1
            AnonymousClass1() {
            }

            @Override // androidx.lifecycle.ViewModelProvider.Factory
            @NonNull
            public <T extends ViewModel> T create(@NonNull Class<T> cls) {
                return new LoaderViewModel();
            }
        };

        /* renamed from: d */
        private SparseArrayCompat<LoaderInfo> f2670d = new SparseArrayCompat<>();

        /* renamed from: e */
        private boolean f2671e = false;

        /* renamed from: androidx.loader.app.LoaderManagerImpl$LoaderViewModel$1 */
        static class AnonymousClass1 implements ViewModelProvider.Factory {
            AnonymousClass1() {
            }

            @Override // androidx.lifecycle.ViewModelProvider.Factory
            @NonNull
            public <T extends ViewModel> T create(@NonNull Class<T> cls) {
                return new LoaderViewModel();
            }
        }

        LoaderViewModel() {
        }

        @NonNull
        static LoaderViewModel g(ViewModelStore viewModelStore) {
            return (LoaderViewModel) new ViewModelProvider(viewModelStore, f2669c).get(LoaderViewModel.class);
        }

        @Override // androidx.lifecycle.ViewModel
        protected void d() {
            super.d();
            int size = this.f2670d.size();
            for (int i2 = 0; i2 < size; i2++) {
                this.f2670d.valueAt(i2).g(true);
            }
            this.f2670d.clear();
        }

        public void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
            if (this.f2670d.size() > 0) {
                printWriter.print(str);
                printWriter.println("Loaders:");
                String str2 = str + "    ";
                for (int i2 = 0; i2 < this.f2670d.size(); i2++) {
                    LoaderInfo valueAt = this.f2670d.valueAt(i2);
                    printWriter.print(str);
                    printWriter.print("  #");
                    printWriter.print(this.f2670d.keyAt(i2));
                    printWriter.print(": ");
                    printWriter.println(valueAt.toString());
                    valueAt.dump(str2, fileDescriptor, printWriter, strArr);
                }
            }
        }

        void f() {
            this.f2671e = false;
        }

        <D> LoaderInfo<D> h(int i2) {
            return this.f2670d.get(i2);
        }

        boolean i() {
            int size = this.f2670d.size();
            for (int i2 = 0; i2 < size; i2++) {
                if (this.f2670d.valueAt(i2).i()) {
                    return true;
                }
            }
            return false;
        }

        boolean j() {
            return this.f2671e;
        }

        void k() {
            int size = this.f2670d.size();
            for (int i2 = 0; i2 < size; i2++) {
                this.f2670d.valueAt(i2).j();
            }
        }

        void l(int i2, @NonNull LoaderInfo loaderInfo) {
            this.f2670d.put(i2, loaderInfo);
        }

        void m(int i2) {
            this.f2670d.remove(i2);
        }

        void n() {
            this.f2671e = true;
        }
    }

    LoaderManagerImpl(@NonNull LifecycleOwner lifecycleOwner, @NonNull ViewModelStore viewModelStore) {
        this.f2664c = lifecycleOwner;
        this.f2665d = LoaderViewModel.g(viewModelStore);
    }

    @NonNull
    @MainThread
    private <D> Loader<D> a(int i2, @Nullable Bundle bundle, @NonNull LoaderManager.LoaderCallbacks<D> loaderCallbacks, @Nullable Loader<D> loader) {
        try {
            this.f2665d.n();
            Loader<D> onCreateLoader = loaderCallbacks.onCreateLoader(i2, bundle);
            if (onCreateLoader == null) {
                throw new IllegalArgumentException("Object returned from onCreateLoader must not be null");
            }
            if (onCreateLoader.getClass().isMemberClass() && !Modifier.isStatic(onCreateLoader.getClass().getModifiers())) {
                throw new IllegalArgumentException("Object returned from onCreateLoader must not be a non-static inner member class: " + onCreateLoader);
            }
            LoaderInfo loaderInfo = new LoaderInfo(i2, bundle, onCreateLoader, loader);
            if (f2663b) {
                Log.v(f2662a, "  Created new loader " + loaderInfo);
            }
            this.f2665d.l(i2, loaderInfo);
            this.f2665d.f();
            return loaderInfo.k(this.f2664c, loaderCallbacks);
        } catch (Throwable th) {
            this.f2665d.f();
            throw th;
        }
    }

    @Override // androidx.loader.app.LoaderManager
    @MainThread
    public void destroyLoader(int i2) {
        if (this.f2665d.j()) {
            throw new IllegalStateException("Called while creating a loader");
        }
        if (Looper.getMainLooper() != Looper.myLooper()) {
            throw new IllegalStateException("destroyLoader must be called on the main thread");
        }
        if (f2663b) {
            Log.v(f2662a, "destroyLoader in " + this + " of " + i2);
        }
        LoaderInfo h2 = this.f2665d.h(i2);
        if (h2 != null) {
            h2.g(true);
            this.f2665d.m(i2);
        }
    }

    @Override // androidx.loader.app.LoaderManager
    @Deprecated
    public void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        this.f2665d.dump(str, fileDescriptor, printWriter, strArr);
    }

    @Override // androidx.loader.app.LoaderManager
    @Nullable
    public <D> Loader<D> getLoader(int i2) {
        if (this.f2665d.j()) {
            throw new IllegalStateException("Called while creating a loader");
        }
        LoaderInfo<D> h2 = this.f2665d.h(i2);
        if (h2 != null) {
            return h2.h();
        }
        return null;
    }

    @Override // androidx.loader.app.LoaderManager
    public boolean hasRunningLoaders() {
        return this.f2665d.i();
    }

    @Override // androidx.loader.app.LoaderManager
    @NonNull
    @MainThread
    public <D> Loader<D> initLoader(int i2, @Nullable Bundle bundle, @NonNull LoaderManager.LoaderCallbacks<D> loaderCallbacks) {
        if (this.f2665d.j()) {
            throw new IllegalStateException("Called while creating a loader");
        }
        if (Looper.getMainLooper() != Looper.myLooper()) {
            throw new IllegalStateException("initLoader must be called on the main thread");
        }
        LoaderInfo<D> h2 = this.f2665d.h(i2);
        if (f2663b) {
            Log.v(f2662a, "initLoader in " + this + ": args=" + bundle);
        }
        if (h2 == null) {
            return a(i2, bundle, loaderCallbacks, null);
        }
        if (f2663b) {
            Log.v(f2662a, "  Re-using existing loader " + h2);
        }
        return h2.k(this.f2664c, loaderCallbacks);
    }

    @Override // androidx.loader.app.LoaderManager
    public void markForRedelivery() {
        this.f2665d.k();
    }

    @Override // androidx.loader.app.LoaderManager
    @NonNull
    @MainThread
    public <D> Loader<D> restartLoader(int i2, @Nullable Bundle bundle, @NonNull LoaderManager.LoaderCallbacks<D> loaderCallbacks) {
        if (this.f2665d.j()) {
            throw new IllegalStateException("Called while creating a loader");
        }
        if (Looper.getMainLooper() != Looper.myLooper()) {
            throw new IllegalStateException("restartLoader must be called on the main thread");
        }
        if (f2663b) {
            Log.v(f2662a, "restartLoader in " + this + ": args=" + bundle);
        }
        LoaderInfo<D> h2 = this.f2665d.h(i2);
        return a(i2, bundle, loaderCallbacks, h2 != null ? h2.g(false) : null);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(128);
        sb.append("LoaderManager{");
        sb.append(Integer.toHexString(System.identityHashCode(this)));
        sb.append(" in ");
        DebugUtils.buildShortClassTag(this.f2664c, sb);
        sb.append("}}");
        return sb.toString();
    }
}
