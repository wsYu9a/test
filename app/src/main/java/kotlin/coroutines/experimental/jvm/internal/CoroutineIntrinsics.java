package kotlin.coroutines.experimental.jvm.internal;

import androidx.exifinterface.media.ExifInterface;
import f.b.a.d;
import kotlin.Metadata;
import kotlin.coroutines.experimental.Continuation;
import kotlin.coroutines.experimental.ContinuationInterceptor;
import kotlin.coroutines.experimental.CoroutineContext;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a'\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001\"\u0004\b\u0000\u0010\u00002\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001¢\u0006\u0004\b\u0003\u0010\u0004\u001a1\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001\"\u0004\b\u0000\u0010\u00002\u0006\u0010\u0006\u001a\u00020\u00052\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001H\u0000¢\u0006\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {ExifInterface.GPS_DIRECTION_TRUE, "Lkotlin/coroutines/experimental/Continuation;", "continuation", "normalizeContinuation", "(Lkotlin/coroutines/experimental/Continuation;)Lkotlin/coroutines/experimental/Continuation;", "Lkotlin/coroutines/experimental/CoroutineContext;", "context", "interceptContinuationIfNeeded", "(Lkotlin/coroutines/experimental/CoroutineContext;Lkotlin/coroutines/experimental/Continuation;)Lkotlin/coroutines/experimental/Continuation;", "kotlin-stdlib-coroutines"}, k = 2, mv = {1, 4, 0})
@JvmName(name = "CoroutineIntrinsics")
/* loaded from: classes5.dex */
public final class CoroutineIntrinsics {
    /* JADX WARN: Multi-variable type inference failed */
    @d
    public static final <T> Continuation<T> interceptContinuationIfNeeded(@d CoroutineContext context, @d Continuation<? super T> continuation) {
        Continuation<T> interceptContinuation;
        Intrinsics.checkParameterIsNotNull(context, "context");
        Intrinsics.checkParameterIsNotNull(continuation, "continuation");
        ContinuationInterceptor continuationInterceptor = (ContinuationInterceptor) context.get(ContinuationInterceptor.INSTANCE);
        return (continuationInterceptor == null || (interceptContinuation = continuationInterceptor.interceptContinuation(continuation)) == null) ? continuation : interceptContinuation;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @d
    public static final <T> Continuation<T> normalizeContinuation(@d Continuation<? super T> continuation) {
        Continuation<T> continuation2;
        Intrinsics.checkParameterIsNotNull(continuation, "continuation");
        CoroutineImpl coroutineImpl = !(continuation instanceof CoroutineImpl) ? null : continuation;
        return (coroutineImpl == null || (continuation2 = (Continuation<T>) coroutineImpl.getFacade()) == null) ? continuation : continuation2;
    }
}
