package kotlin.coroutines.experimental.migration;

import androidx.exifinterface.media.ExifInterface;
import f.b.a.d;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0002\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00028\u00000\u0002B\u0015\u0012\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00028\u00000\r¢\u0006\u0004\b\u0012\u0010\u0013J \u0010\u0006\u001a\u00020\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003H\u0016ø\u0001\u0000¢\u0006\u0004\b\u0006\u0010\u0007R\u001c\u0010\t\u001a\u00020\b8\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u001f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00028\u00000\r8\u0006@\u0006¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0014"}, d2 = {"Lkotlin/coroutines/experimental/migration/ContinuationMigration;", ExifInterface.GPS_DIRECTION_TRUE, "Lkotlin/coroutines/Continuation;", "Lkotlin/Result;", "result", "", "resumeWith", "(Ljava/lang/Object;)V", "Lkotlin/coroutines/CoroutineContext;", "context", "Lkotlin/coroutines/CoroutineContext;", "getContext", "()Lkotlin/coroutines/CoroutineContext;", "Lkotlin/coroutines/experimental/Continuation;", "continuation", "Lkotlin/coroutines/experimental/Continuation;", "getContinuation", "()Lkotlin/coroutines/experimental/Continuation;", "<init>", "(Lkotlin/coroutines/experimental/Continuation;)V", "kotlin-stdlib-coroutines"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes5.dex */
final class ContinuationMigration<T> implements Continuation<T> {

    @d
    private final CoroutineContext context;

    @d
    private final kotlin.coroutines.experimental.Continuation<T> continuation;

    /* JADX WARN: Multi-variable type inference failed */
    public ContinuationMigration(@d kotlin.coroutines.experimental.Continuation<? super T> continuation) {
        Intrinsics.checkParameterIsNotNull(continuation, "continuation");
        this.continuation = continuation;
        this.context = CoroutinesMigrationKt.toCoroutineContext(continuation.getContext());
    }

    @Override // kotlin.coroutines.Continuation
    @d
    public CoroutineContext getContext() {
        return this.context;
    }

    @d
    public final kotlin.coroutines.experimental.Continuation<T> getContinuation() {
        return this.continuation;
    }

    @Override // kotlin.coroutines.Continuation
    public void resumeWith(@d Object result) {
        if (Result.m90isSuccessimpl(result)) {
            this.continuation.resume(result);
        }
        Throwable m86exceptionOrNullimpl = Result.m86exceptionOrNullimpl(result);
        if (m86exceptionOrNullimpl != null) {
            this.continuation.resumeWithException(m86exceptionOrNullimpl);
        }
    }
}
