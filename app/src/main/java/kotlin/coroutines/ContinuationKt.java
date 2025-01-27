package kotlin.coroutines;

import androidx.exifinterface.media.ExifInterface;
import com.tencent.open.SocialConstants;
import com.vivo.ic.dm.Downloads;
import f.b.a.d;
import kotlin.Metadata;
import kotlin.NotImplementedError;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.SinceKotlin;
import kotlin.Unit;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.internal.InlineOnly;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.InlineMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000>\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\u001a(\u0010\u0004\u001a\u00020\u0003\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\u0006\u0010\u0002\u001a\u00028\u0000H\u0087\b¢\u0006\u0004\b\u0004\u0010\u0005\u001a(\u0010\b\u001a\u00020\u0003\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\u0006\u0010\u0007\u001a\u00020\u0006H\u0087\b¢\u0006\u0004\b\b\u0010\t\u001aC\u0010\u000f\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001\"\u0004\b\u0000\u0010\u00002\u0006\u0010\u000b\u001a\u00020\n2\u001a\b\u0004\u0010\u000e\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\r\u0012\u0004\u0012\u00020\u00030\fH\u0087\bø\u0001\u0000¢\u0006\u0004\b\u000f\u0010\u0010\u001aF\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00030\u0001\"\u0004\b\u0000\u0010\u0000*\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0001\u0012\u0006\u0012\u0004\u0018\u00010\u00110\f2\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001H\u0007ø\u0001\u0000¢\u0006\u0004\b\u0013\u0010\u0014\u001a_\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00030\u0001\"\u0004\b\u0000\u0010\u0015\"\u0004\b\u0001\u0010\u0000*#\b\u0001\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\u0001\u0012\u0006\u0012\u0004\u0018\u00010\u00110\u0016¢\u0006\u0002\b\u00172\u0006\u0010\u0018\u001a\u00028\u00002\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00028\u00010\u0001H\u0007ø\u0001\u0000¢\u0006\u0004\b\u0013\u0010\u0019\u001a@\u0010\u001a\u001a\u00020\u0003\"\u0004\b\u0000\u0010\u0000*\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0001\u0012\u0006\u0012\u0004\u0018\u00010\u00110\f2\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001H\u0007ø\u0001\u0000¢\u0006\u0004\b\u001a\u0010\u001b\u001aY\u0010\u001a\u001a\u00020\u0003\"\u0004\b\u0000\u0010\u0015\"\u0004\b\u0001\u0010\u0000*#\b\u0001\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\u0001\u0012\u0006\u0012\u0004\u0018\u00010\u00110\u0016¢\u0006\u0002\b\u00172\u0006\u0010\u0018\u001a\u00028\u00002\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00028\u00010\u0001H\u0007ø\u0001\u0000¢\u0006\u0004\b\u001a\u0010\u001c\u001a5\u0010\u001e\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u00002\u001a\b\u0004\u0010\u001d\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0001\u0012\u0004\u0012\u00020\u00030\fH\u0087Hø\u0001\u0000¢\u0006\u0004\b\u001e\u0010\u001f\"\u001d\u0010$\u001a\u00020\n8Æ\u0002@\u0007X\u0087\u0004¢\u0006\f\u0012\u0004\b\"\u0010#\u001a\u0004\b \u0010!\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006%"}, d2 = {ExifInterface.GPS_DIRECTION_TRUE, "Lkotlin/coroutines/Continuation;", Downloads.RequestHeaders.COLUMN_VALUE, "", "resume", "(Lkotlin/coroutines/Continuation;Ljava/lang/Object;)V", "", "exception", "resumeWithException", "(Lkotlin/coroutines/Continuation;Ljava/lang/Throwable;)V", "Lkotlin/coroutines/CoroutineContext;", "context", "Lkotlin/Function1;", "Lkotlin/Result;", "resumeWith", "Continuation", "(Lkotlin/coroutines/CoroutineContext;Lkotlin/jvm/functions/Function1;)Lkotlin/coroutines/Continuation;", "", "completion", "createCoroutine", "(Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Lkotlin/coroutines/Continuation;", "R", "Lkotlin/Function2;", "Lkotlin/ExtensionFunctionType;", SocialConstants.PARAM_RECEIVER, "(Lkotlin/jvm/functions/Function2;Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Lkotlin/coroutines/Continuation;", "startCoroutine", "(Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)V", "(Lkotlin/jvm/functions/Function2;Ljava/lang/Object;Lkotlin/coroutines/Continuation;)V", "block", "suspendCoroutine", "(Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getCoroutineContext", "()Lkotlin/coroutines/CoroutineContext;", "coroutineContext$annotations", "()V", "coroutineContext", "kotlin-stdlib"}, k = 2, mv = {1, 4, 0})
/* loaded from: classes5.dex */
public final class ContinuationKt {
    @SinceKotlin(version = "1.3")
    @InlineOnly
    private static final <T> Continuation<T> Continuation(final CoroutineContext coroutineContext, final Function1<? super Result<? extends T>, Unit> function1) {
        return new Continuation<T>() { // from class: kotlin.coroutines.ContinuationKt$Continuation$1
            @Override // kotlin.coroutines.Continuation
            @d
            public CoroutineContext getContext() {
                return CoroutineContext.this;
            }

            @Override // kotlin.coroutines.Continuation
            public void resumeWith(@d Object result) {
                function1.invoke(Result.m82boximpl(result));
            }
        };
    }

    @SinceKotlin(version = "1.3")
    @InlineOnly
    public static /* synthetic */ void coroutineContext$annotations() {
    }

    @d
    @SinceKotlin(version = "1.3")
    public static final <T> Continuation<Unit> createCoroutine(@d Function1<? super Continuation<? super T>, ? extends Object> createCoroutine, @d Continuation<? super T> completion) {
        Continuation<Unit> createCoroutineUnintercepted;
        Continuation intercepted;
        Object coroutine_suspended;
        Intrinsics.checkParameterIsNotNull(createCoroutine, "$this$createCoroutine");
        Intrinsics.checkParameterIsNotNull(completion, "completion");
        createCoroutineUnintercepted = IntrinsicsKt__IntrinsicsJvmKt.createCoroutineUnintercepted(createCoroutine, completion);
        intercepted = IntrinsicsKt__IntrinsicsJvmKt.intercepted(createCoroutineUnintercepted);
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        return new SafeContinuation(intercepted, coroutine_suspended);
    }

    private static final CoroutineContext getCoroutineContext() {
        throw new NotImplementedError("Implemented as intrinsic");
    }

    @SinceKotlin(version = "1.3")
    @InlineOnly
    private static final <T> void resume(@d Continuation<? super T> continuation, T t) {
        Result.Companion companion = Result.INSTANCE;
        continuation.resumeWith(Result.m83constructorimpl(t));
    }

    @SinceKotlin(version = "1.3")
    @InlineOnly
    private static final <T> void resumeWithException(@d Continuation<? super T> continuation, Throwable th) {
        Result.Companion companion = Result.INSTANCE;
        continuation.resumeWith(Result.m83constructorimpl(ResultKt.createFailure(th)));
    }

    @SinceKotlin(version = "1.3")
    public static final <T> void startCoroutine(@d Function1<? super Continuation<? super T>, ? extends Object> startCoroutine, @d Continuation<? super T> completion) {
        Continuation<Unit> createCoroutineUnintercepted;
        Continuation intercepted;
        Intrinsics.checkParameterIsNotNull(startCoroutine, "$this$startCoroutine");
        Intrinsics.checkParameterIsNotNull(completion, "completion");
        createCoroutineUnintercepted = IntrinsicsKt__IntrinsicsJvmKt.createCoroutineUnintercepted(startCoroutine, completion);
        intercepted = IntrinsicsKt__IntrinsicsJvmKt.intercepted(createCoroutineUnintercepted);
        Unit unit = Unit.INSTANCE;
        Result.Companion companion = Result.INSTANCE;
        intercepted.resumeWith(Result.m83constructorimpl(unit));
    }

    @SinceKotlin(version = "1.3")
    @InlineOnly
    private static final <T> Object suspendCoroutine(Function1<? super Continuation<? super T>, Unit> function1, Continuation<? super T> continuation) {
        Continuation intercepted;
        Object coroutine_suspended;
        InlineMarker.mark(0);
        intercepted = IntrinsicsKt__IntrinsicsJvmKt.intercepted(continuation);
        SafeContinuation safeContinuation = new SafeContinuation(intercepted);
        function1.invoke(safeContinuation);
        Object orThrow = safeContinuation.getOrThrow();
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (orThrow == coroutine_suspended) {
            DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        InlineMarker.mark(1);
        return orThrow;
    }

    @d
    @SinceKotlin(version = "1.3")
    public static final <R, T> Continuation<Unit> createCoroutine(@d Function2<? super R, ? super Continuation<? super T>, ? extends Object> createCoroutine, R r, @d Continuation<? super T> completion) {
        Continuation<Unit> createCoroutineUnintercepted;
        Continuation intercepted;
        Object coroutine_suspended;
        Intrinsics.checkParameterIsNotNull(createCoroutine, "$this$createCoroutine");
        Intrinsics.checkParameterIsNotNull(completion, "completion");
        createCoroutineUnintercepted = IntrinsicsKt__IntrinsicsJvmKt.createCoroutineUnintercepted(createCoroutine, r, completion);
        intercepted = IntrinsicsKt__IntrinsicsJvmKt.intercepted(createCoroutineUnintercepted);
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        return new SafeContinuation(intercepted, coroutine_suspended);
    }

    @SinceKotlin(version = "1.3")
    public static final <R, T> void startCoroutine(@d Function2<? super R, ? super Continuation<? super T>, ? extends Object> startCoroutine, R r, @d Continuation<? super T> completion) {
        Continuation<Unit> createCoroutineUnintercepted;
        Continuation intercepted;
        Intrinsics.checkParameterIsNotNull(startCoroutine, "$this$startCoroutine");
        Intrinsics.checkParameterIsNotNull(completion, "completion");
        createCoroutineUnintercepted = IntrinsicsKt__IntrinsicsJvmKt.createCoroutineUnintercepted(startCoroutine, r, completion);
        intercepted = IntrinsicsKt__IntrinsicsJvmKt.intercepted(createCoroutineUnintercepted);
        Unit unit = Unit.INSTANCE;
        Result.Companion companion = Result.INSTANCE;
        intercepted.resumeWith(Result.m83constructorimpl(unit));
    }
}
