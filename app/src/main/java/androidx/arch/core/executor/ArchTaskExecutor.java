package androidx.arch.core.executor;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import java.util.concurrent.Executor;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
/* loaded from: classes.dex */
public class ArchTaskExecutor extends TaskExecutor {

    /* renamed from: a */
    private static volatile ArchTaskExecutor f1048a;

    /* renamed from: b */
    @NonNull
    private static final Executor f1049b = new Executor() { // from class: androidx.arch.core.executor.ArchTaskExecutor.1
        AnonymousClass1() {
        }

        @Override // java.util.concurrent.Executor
        public void execute(Runnable runnable) {
            ArchTaskExecutor.getInstance().postToMainThread(runnable);
        }
    };

    /* renamed from: c */
    @NonNull
    private static final Executor f1050c = new Executor() { // from class: androidx.arch.core.executor.ArchTaskExecutor.2
        AnonymousClass2() {
        }

        @Override // java.util.concurrent.Executor
        public void execute(Runnable runnable) {
            ArchTaskExecutor.getInstance().executeOnDiskIO(runnable);
        }
    };

    /* renamed from: d */
    @NonNull
    private TaskExecutor f1051d;

    /* renamed from: e */
    @NonNull
    private TaskExecutor f1052e;

    /* renamed from: androidx.arch.core.executor.ArchTaskExecutor$1 */
    static class AnonymousClass1 implements Executor {
        AnonymousClass1() {
        }

        @Override // java.util.concurrent.Executor
        public void execute(Runnable runnable) {
            ArchTaskExecutor.getInstance().postToMainThread(runnable);
        }
    }

    /* renamed from: androidx.arch.core.executor.ArchTaskExecutor$2 */
    static class AnonymousClass2 implements Executor {
        AnonymousClass2() {
        }

        @Override // java.util.concurrent.Executor
        public void execute(Runnable runnable) {
            ArchTaskExecutor.getInstance().executeOnDiskIO(runnable);
        }
    }

    private ArchTaskExecutor() {
        DefaultTaskExecutor defaultTaskExecutor = new DefaultTaskExecutor();
        this.f1052e = defaultTaskExecutor;
        this.f1051d = defaultTaskExecutor;
    }

    @NonNull
    public static Executor getIOThreadExecutor() {
        return f1050c;
    }

    @NonNull
    public static ArchTaskExecutor getInstance() {
        if (f1048a != null) {
            return f1048a;
        }
        synchronized (ArchTaskExecutor.class) {
            if (f1048a == null) {
                f1048a = new ArchTaskExecutor();
            }
        }
        return f1048a;
    }

    @NonNull
    public static Executor getMainThreadExecutor() {
        return f1049b;
    }

    @Override // androidx.arch.core.executor.TaskExecutor
    public void executeOnDiskIO(Runnable runnable) {
        this.f1051d.executeOnDiskIO(runnable);
    }

    @Override // androidx.arch.core.executor.TaskExecutor
    public boolean isMainThread() {
        return this.f1051d.isMainThread();
    }

    @Override // androidx.arch.core.executor.TaskExecutor
    public void postToMainThread(Runnable runnable) {
        this.f1051d.postToMainThread(runnable);
    }

    public void setDelegate(@Nullable TaskExecutor taskExecutor) {
        if (taskExecutor == null) {
            taskExecutor = this.f1052e;
        }
        this.f1051d = taskExecutor;
    }
}
