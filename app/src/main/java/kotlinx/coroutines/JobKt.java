package kotlinx.coroutines;

import java.util.concurrent.CancellationException;
import java.util.concurrent.Future;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import xi.k;
import xi.l;

@Metadata(d1 = {"kotlinx/coroutines/JobKt__FutureKt", "kotlinx/coroutines/JobKt__JobKt"}, k = 4, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class JobKt {
    @k
    public static final CompletableJob Job(@l Job job) {
        return JobKt__JobKt.Job(job);
    }

    @l
    public static final Object cancelAndJoin(@k Job job, @k Continuation<? super Unit> continuation) {
        return JobKt__JobKt.cancelAndJoin(job, continuation);
    }

    public static final void cancelFutureOnCancellation(@k CancellableContinuation<?> cancellableContinuation, @k Future<?> future) {
        JobKt__FutureKt.cancelFutureOnCancellation(cancellableContinuation, future);
    }

    @InternalCoroutinesApi
    @k
    public static final DisposableHandle cancelFutureOnCompletion(@k Job job, @k Future<?> future) {
        return JobKt__FutureKt.cancelFutureOnCompletion(job, future);
    }

    @k
    public static final DisposableHandle disposeOnCompletion(@k Job job, @k DisposableHandle disposableHandle) {
        return JobKt__JobKt.disposeOnCompletion(job, disposableHandle);
    }

    public static final void ensureActive(@k CoroutineContext coroutineContext) {
        JobKt__JobKt.ensureActive(coroutineContext);
    }

    @k
    public static final Job getJob(@k CoroutineContext coroutineContext) {
        return JobKt__JobKt.getJob(coroutineContext);
    }

    public static final boolean isActive(@k CoroutineContext coroutineContext) {
        return JobKt__JobKt.isActive(coroutineContext);
    }

    public static final void cancel(@k CoroutineContext coroutineContext, @l CancellationException cancellationException) {
        JobKt__JobKt.cancel(coroutineContext, cancellationException);
    }

    public static final void ensureActive(@k Job job) {
        JobKt__JobKt.ensureActive(job);
    }

    public static final void cancel(@k Job job, @k String str, @l Throwable th2) {
        JobKt__JobKt.cancel(job, str, th2);
    }

    public static final void cancelChildren(@k CoroutineContext coroutineContext, @l CancellationException cancellationException) {
        JobKt__JobKt.cancelChildren(coroutineContext, cancellationException);
    }

    public static final void cancelChildren(@k Job job, @l CancellationException cancellationException) {
        JobKt__JobKt.cancelChildren(job, cancellationException);
    }
}
