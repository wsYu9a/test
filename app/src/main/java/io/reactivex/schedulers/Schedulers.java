package io.reactivex.schedulers;

import io.reactivex.Scheduler;
import io.reactivex.annotations.Experimental;
import io.reactivex.annotations.NonNull;
import io.reactivex.internal.schedulers.ComputationScheduler;
import io.reactivex.internal.schedulers.ExecutorScheduler;
import io.reactivex.internal.schedulers.IoScheduler;
import io.reactivex.internal.schedulers.NewThreadScheduler;
import io.reactivex.internal.schedulers.SchedulerPoolFactory;
import io.reactivex.internal.schedulers.SingleScheduler;
import io.reactivex.internal.schedulers.TrampolineScheduler;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;

/* loaded from: classes4.dex */
public final class Schedulers {

    @NonNull
    static final Scheduler SINGLE = RxJavaPlugins.initSingleScheduler(new SingleTask());

    @NonNull
    static final Scheduler COMPUTATION = RxJavaPlugins.initComputationScheduler(new ComputationTask());

    @NonNull
    static final Scheduler IO = RxJavaPlugins.initIoScheduler(new IOTask());

    @NonNull
    static final Scheduler TRAMPOLINE = TrampolineScheduler.instance();

    @NonNull
    static final Scheduler NEW_THREAD = RxJavaPlugins.initNewThreadScheduler(new NewThreadTask());

    public static final class ComputationHolder {
        static final Scheduler DEFAULT = new ComputationScheduler();
    }

    public static final class ComputationTask implements Callable<Scheduler> {
        @Override // java.util.concurrent.Callable
        public Scheduler call() throws Exception {
            return ComputationHolder.DEFAULT;
        }
    }

    public static final class IOTask implements Callable<Scheduler> {
        @Override // java.util.concurrent.Callable
        public Scheduler call() throws Exception {
            return IoHolder.DEFAULT;
        }
    }

    public static final class IoHolder {
        static final Scheduler DEFAULT = new IoScheduler();
    }

    public static final class NewThreadHolder {
        static final Scheduler DEFAULT = new NewThreadScheduler();
    }

    public static final class NewThreadTask implements Callable<Scheduler> {
        @Override // java.util.concurrent.Callable
        public Scheduler call() throws Exception {
            return NewThreadHolder.DEFAULT;
        }
    }

    public static final class SingleHolder {
        static final Scheduler DEFAULT = new SingleScheduler();
    }

    public static final class SingleTask implements Callable<Scheduler> {
        @Override // java.util.concurrent.Callable
        public Scheduler call() throws Exception {
            return SingleHolder.DEFAULT;
        }
    }

    private Schedulers() {
        throw new IllegalStateException("No instances!");
    }

    @NonNull
    public static Scheduler computation() {
        return RxJavaPlugins.onComputationScheduler(COMPUTATION);
    }

    @NonNull
    public static Scheduler from(@NonNull Executor executor) {
        return new ExecutorScheduler(executor, false);
    }

    @NonNull
    public static Scheduler io() {
        return RxJavaPlugins.onIoScheduler(IO);
    }

    @NonNull
    public static Scheduler newThread() {
        return RxJavaPlugins.onNewThreadScheduler(NEW_THREAD);
    }

    public static void shutdown() {
        computation().shutdown();
        io().shutdown();
        newThread().shutdown();
        single().shutdown();
        trampoline().shutdown();
        SchedulerPoolFactory.shutdown();
    }

    @NonNull
    public static Scheduler single() {
        return RxJavaPlugins.onSingleScheduler(SINGLE);
    }

    public static void start() {
        computation().start();
        io().start();
        newThread().start();
        single().start();
        trampoline().start();
        SchedulerPoolFactory.start();
    }

    @NonNull
    public static Scheduler trampoline() {
        return TRAMPOLINE;
    }

    @Experimental
    @NonNull
    public static Scheduler from(@NonNull Executor executor, boolean z10) {
        return new ExecutorScheduler(executor, z10);
    }
}
