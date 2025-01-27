package androidx.arch.core.executor;

import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import java.lang.reflect.InvocationTargetException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
/* loaded from: classes.dex */
public class DefaultTaskExecutor extends TaskExecutor {

    /* renamed from: a */
    private final Object f1053a = new Object();

    /* renamed from: b */
    private final ExecutorService f1054b = Executors.newFixedThreadPool(4, new ThreadFactory() { // from class: androidx.arch.core.executor.DefaultTaskExecutor.1

        /* renamed from: a */
        private static final String f1056a = "arch_disk_io_%d";

        /* renamed from: b */
        private final AtomicInteger f1057b = new AtomicInteger(0);

        AnonymousClass1() {
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            Thread thread = new Thread(runnable);
            thread.setName(String.format(f1056a, Integer.valueOf(this.f1057b.getAndIncrement())));
            return thread;
        }
    });

    /* renamed from: c */
    @Nullable
    private volatile Handler f1055c;

    /* renamed from: androidx.arch.core.executor.DefaultTaskExecutor$1 */
    class AnonymousClass1 implements ThreadFactory {

        /* renamed from: a */
        private static final String f1056a = "arch_disk_io_%d";

        /* renamed from: b */
        private final AtomicInteger f1057b = new AtomicInteger(0);

        AnonymousClass1() {
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            Thread thread = new Thread(runnable);
            thread.setName(String.format(f1056a, Integer.valueOf(this.f1057b.getAndIncrement())));
            return thread;
        }
    }

    private static Handler a(@NonNull Looper looper) {
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= 28) {
            return Handler.createAsync(looper);
        }
        if (i2 >= 16) {
            try {
                return (Handler) Handler.class.getDeclaredConstructor(Looper.class, Handler.Callback.class, Boolean.TYPE).newInstance(looper, null, Boolean.TRUE);
            } catch (IllegalAccessException | InstantiationException | NoSuchMethodException unused) {
            } catch (InvocationTargetException unused2) {
                return new Handler(looper);
            }
        }
        return new Handler(looper);
    }

    @Override // androidx.arch.core.executor.TaskExecutor
    public void executeOnDiskIO(Runnable runnable) {
        this.f1054b.execute(runnable);
    }

    @Override // androidx.arch.core.executor.TaskExecutor
    public boolean isMainThread() {
        return Looper.getMainLooper().getThread() == Thread.currentThread();
    }

    @Override // androidx.arch.core.executor.TaskExecutor
    public void postToMainThread(Runnable runnable) {
        if (this.f1055c == null) {
            synchronized (this.f1053a) {
                if (this.f1055c == null) {
                    this.f1055c = a(Looper.getMainLooper());
                }
            }
        }
        this.f1055c.post(runnable);
    }
}
