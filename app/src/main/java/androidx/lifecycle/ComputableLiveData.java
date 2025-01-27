package androidx.lifecycle;

import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import androidx.annotation.VisibleForTesting;
import androidx.annotation.WorkerThread;
import androidx.arch.core.executor.ArchTaskExecutor;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicBoolean;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: classes.dex */
public abstract class ComputableLiveData<T> {

    /* renamed from: a */
    final Executor f2572a;

    /* renamed from: b */
    final LiveData<T> f2573b;

    /* renamed from: c */
    final AtomicBoolean f2574c;

    /* renamed from: d */
    final AtomicBoolean f2575d;

    /* renamed from: e */
    @VisibleForTesting
    final Runnable f2576e;

    /* renamed from: f */
    @VisibleForTesting
    final Runnable f2577f;

    /* renamed from: androidx.lifecycle.ComputableLiveData$1 */
    class AnonymousClass1 extends LiveData<T> {
        AnonymousClass1() {
        }

        @Override // androidx.lifecycle.LiveData
        protected void e() {
            ComputableLiveData computableLiveData = ComputableLiveData.this;
            computableLiveData.f2572a.execute(computableLiveData.f2576e);
        }
    }

    /* renamed from: androidx.lifecycle.ComputableLiveData$2 */
    class AnonymousClass2 implements Runnable {
        AnonymousClass2() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.lang.Runnable
        @WorkerThread
        public void run() {
            do {
                boolean z = false;
                if (ComputableLiveData.this.f2575d.compareAndSet(false, true)) {
                    Object obj = null;
                    boolean z2 = false;
                    while (ComputableLiveData.this.f2574c.compareAndSet(true, false)) {
                        try {
                            obj = ComputableLiveData.this.a();
                            z2 = true;
                        } catch (Throwable th) {
                            ComputableLiveData.this.f2575d.set(false);
                            throw th;
                        }
                    }
                    if (z2) {
                        ComputableLiveData.this.f2573b.postValue(obj);
                    }
                    ComputableLiveData.this.f2575d.set(false);
                    z = z2;
                }
                if (!z) {
                    return;
                }
            } while (ComputableLiveData.this.f2574c.get());
        }
    }

    /* renamed from: androidx.lifecycle.ComputableLiveData$3 */
    class AnonymousClass3 implements Runnable {
        AnonymousClass3() {
        }

        @Override // java.lang.Runnable
        @MainThread
        public void run() {
            boolean hasActiveObservers = ComputableLiveData.this.f2573b.hasActiveObservers();
            if (ComputableLiveData.this.f2574c.compareAndSet(false, true) && hasActiveObservers) {
                ComputableLiveData computableLiveData = ComputableLiveData.this;
                computableLiveData.f2572a.execute(computableLiveData.f2576e);
            }
        }
    }

    public ComputableLiveData() {
        this(ArchTaskExecutor.getIOThreadExecutor());
    }

    @WorkerThread
    protected abstract T a();

    @NonNull
    public LiveData<T> getLiveData() {
        return this.f2573b;
    }

    public void invalidate() {
        ArchTaskExecutor.getInstance().executeOnMainThread(this.f2577f);
    }

    public ComputableLiveData(@NonNull Executor executor) {
        this.f2574c = new AtomicBoolean(true);
        this.f2575d = new AtomicBoolean(false);
        this.f2576e = new Runnable() { // from class: androidx.lifecycle.ComputableLiveData.2
            AnonymousClass2() {
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.lang.Runnable
            @WorkerThread
            public void run() {
                do {
                    boolean z = false;
                    if (ComputableLiveData.this.f2575d.compareAndSet(false, true)) {
                        Object obj = null;
                        boolean z2 = false;
                        while (ComputableLiveData.this.f2574c.compareAndSet(true, false)) {
                            try {
                                obj = ComputableLiveData.this.a();
                                z2 = true;
                            } catch (Throwable th) {
                                ComputableLiveData.this.f2575d.set(false);
                                throw th;
                            }
                        }
                        if (z2) {
                            ComputableLiveData.this.f2573b.postValue(obj);
                        }
                        ComputableLiveData.this.f2575d.set(false);
                        z = z2;
                    }
                    if (!z) {
                        return;
                    }
                } while (ComputableLiveData.this.f2574c.get());
            }
        };
        this.f2577f = new Runnable() { // from class: androidx.lifecycle.ComputableLiveData.3
            AnonymousClass3() {
            }

            @Override // java.lang.Runnable
            @MainThread
            public void run() {
                boolean hasActiveObservers = ComputableLiveData.this.f2573b.hasActiveObservers();
                if (ComputableLiveData.this.f2574c.compareAndSet(false, true) && hasActiveObservers) {
                    ComputableLiveData computableLiveData = ComputableLiveData.this;
                    computableLiveData.f2572a.execute(computableLiveData.f2576e);
                }
            }
        };
        this.f2572a = executor;
        this.f2573b = new LiveData<T>() { // from class: androidx.lifecycle.ComputableLiveData.1
            AnonymousClass1() {
            }

            @Override // androidx.lifecycle.LiveData
            protected void e() {
                ComputableLiveData computableLiveData = ComputableLiveData.this;
                computableLiveData.f2572a.execute(computableLiveData.f2576e);
            }
        };
    }
}
