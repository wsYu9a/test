package kotlinx.coroutines;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Metadata;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.ThreadPoolDispatcherKt;
import xi.k;

@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u001a\u0018\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0007\u001a\u0010\u0010\u0006\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u0005H\u0007¨\u0006\u0007"}, d2 = {"newFixedThreadPoolContext", "Lkotlinx/coroutines/ExecutorCoroutineDispatcher;", "nThreads", "", "name", "", "newSingleThreadContext", "kotlinx-coroutines-core"}, k = 2, mv = {1, 8, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nThreadPoolDispatcher.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ThreadPoolDispatcher.kt\nkotlinx/coroutines/ThreadPoolDispatcherKt\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,72:1\n1#2:73\n*E\n"})
/* loaded from: classes4.dex */
public final class ThreadPoolDispatcherKt {
    @k
    @DelicateCoroutinesApi
    public static final ExecutorCoroutineDispatcher newFixedThreadPoolContext(int i10, @k String str) {
        if (i10 >= 1) {
            return ExecutorsKt.from((ExecutorService) Executors.newScheduledThreadPool(i10, new ThreadFactory() { // from class: ei.a

                /* renamed from: b */
                public final /* synthetic */ int f25910b;

                /* renamed from: c */
                public final /* synthetic */ String f25911c;

                /* renamed from: d */
                public final /* synthetic */ AtomicInteger f25912d;

                public /* synthetic */ a(int i102, String str2, AtomicInteger atomicInteger) {
                    i10 = i102;
                    str = str2;
                    atomicInteger = atomicInteger;
                }

                @Override // java.util.concurrent.ThreadFactory
                public final Thread newThread(Runnable runnable) {
                    Thread newFixedThreadPoolContext$lambda$1;
                    newFixedThreadPoolContext$lambda$1 = ThreadPoolDispatcherKt.newFixedThreadPoolContext$lambda$1(i10, str, atomicInteger, runnable);
                    return newFixedThreadPoolContext$lambda$1;
                }
            }));
        }
        throw new IllegalArgumentException(("Expected at least one thread, but " + i102 + " specified").toString());
    }

    public static final Thread newFixedThreadPoolContext$lambda$1(int i10, String str, AtomicInteger atomicInteger, Runnable runnable) {
        if (i10 != 1) {
            str = str + '-' + atomicInteger.incrementAndGet();
        }
        Thread thread = new Thread(runnable, str);
        thread.setDaemon(true);
        return thread;
    }

    @k
    @DelicateCoroutinesApi
    public static final ExecutorCoroutineDispatcher newSingleThreadContext(@k String str) {
        return newFixedThreadPoolContext(1, str);
    }
}
