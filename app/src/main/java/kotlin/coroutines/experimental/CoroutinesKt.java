package kotlin.coroutines.experimental;

import androidx.exifinterface.media.ExifInterface;
import com.tencent.open.SocialConstants;
import f.b.a.d;
import f.b.a.e;
import kotlin.Metadata;
import kotlin.NotImplementedError;
import kotlin.SinceKotlin;
import kotlin.TypeCastException;
import kotlin.Unit;
import kotlin.coroutines.experimental.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;
import kotlin.coroutines.experimental.jvm.internal.CoroutineIntrinsics;
import kotlin.internal.InlineOnly;
import kotlin.jvm.JvmName;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.InlineMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u001aY\u0010\t\u001a\u00020\b\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001*#\b\u0001\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u0002¢\u0006\u0002\b\u00052\u0006\u0010\u0006\u001a\u00028\u00002\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00010\u0003H\u0007ø\u0001\u0000¢\u0006\u0004\b\t\u0010\n\u001a@\u0010\t\u001a\u00020\b\"\u0004\b\u0000\u0010\u0001*\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u000b2\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003H\u0007ø\u0001\u0000¢\u0006\u0004\b\t\u0010\f\u001a_\u0010\r\u001a\b\u0012\u0004\u0012\u00020\b0\u0003\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001*#\b\u0001\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u0002¢\u0006\u0002\b\u00052\u0006\u0010\u0006\u001a\u00028\u00002\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00010\u0003H\u0007ø\u0001\u0000¢\u0006\u0004\b\r\u0010\u000e\u001aF\u0010\r\u001a\b\u0012\u0004\u0012\u00020\b0\u0003\"\u0004\b\u0000\u0010\u0001*\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u000b2\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003H\u0007ø\u0001\u0000¢\u0006\u0004\b\r\u0010\u000f\u001a5\u0010\u0011\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u00012\u001a\b\u0004\u0010\u0010\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0003\u0012\u0004\u0012\u00020\b0\u000bH\u0087Hø\u0001\u0000¢\u0006\u0004\b\u0011\u0010\u0012\u001a,\u0010\u0014\u001a\u00020\b2\n\u0010\u0007\u001a\u0006\u0012\u0002\b\u00030\u00032\u000e\u0010\u0010\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u0013H\u0081\b¢\u0006\u0004\b\u0014\u0010\u0015\"\u001d\u0010\u001b\u001a\u00020\u00168Æ\u0002@\u0007X\u0087\u0004¢\u0006\f\u0012\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u0017\u0010\u0018\u0082\u0002\u0004\n\u0002\b\t¨\u0006\u001c"}, d2 = {"R", ExifInterface.GPS_DIRECTION_TRUE, "Lkotlin/Function2;", "Lkotlin/coroutines/experimental/Continuation;", "", "Lkotlin/ExtensionFunctionType;", SocialConstants.PARAM_RECEIVER, "completion", "", "startCoroutine", "(Lkotlin/jvm/functions/Function2;Ljava/lang/Object;Lkotlin/coroutines/experimental/Continuation;)V", "Lkotlin/Function1;", "(Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/experimental/Continuation;)V", "createCoroutine", "(Lkotlin/jvm/functions/Function2;Ljava/lang/Object;Lkotlin/coroutines/experimental/Continuation;)Lkotlin/coroutines/experimental/Continuation;", "(Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/experimental/Continuation;)Lkotlin/coroutines/experimental/Continuation;", "block", "suspendCoroutine", "(Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/experimental/Continuation;)Ljava/lang/Object;", "Lkotlin/Function0;", "processBareContinuationResume", "(Lkotlin/coroutines/experimental/Continuation;Lkotlin/jvm/functions/Function0;)V", "Lkotlin/coroutines/experimental/CoroutineContext;", "getCoroutineContext", "()Lkotlin/coroutines/experimental/CoroutineContext;", "coroutineContext$annotations", "()V", "coroutineContext", "kotlin-stdlib-coroutines"}, k = 2, mv = {1, 4, 0})
@JvmName(name = "CoroutinesKt")
/* loaded from: classes5.dex */
public final class CoroutinesKt {
    @SinceKotlin(version = "1.2")
    @InlineOnly
    public static /* synthetic */ void coroutineContext$annotations() {
    }

    @d
    @SinceKotlin(version = "1.1")
    public static final <R, T> Continuation<Unit> createCoroutine(@d Function2<? super R, ? super Continuation<? super T>, ? extends Object> createCoroutine, R r, @d Continuation<? super T> completion) {
        Continuation<Unit> createCoroutineUnchecked;
        Object coroutine_suspended;
        Intrinsics.checkParameterIsNotNull(createCoroutine, "$this$createCoroutine");
        Intrinsics.checkParameterIsNotNull(completion, "completion");
        createCoroutineUnchecked = IntrinsicsKt__IntrinsicsJvmKt.createCoroutineUnchecked(createCoroutine, r, completion);
        coroutine_suspended = IntrinsicsKt__IntrinsicsJvmKt.getCOROUTINE_SUSPENDED();
        return new SafeContinuation(createCoroutineUnchecked, coroutine_suspended);
    }

    private static final CoroutineContext getCoroutineContext() {
        throw new NotImplementedError("Implemented as intrinsic");
    }

    @InlineOnly
    private static final void processBareContinuationResume(Continuation<?> continuation, Function0<? extends Object> function0) {
        Object coroutine_suspended;
        try {
            Object invoke = function0.invoke();
            coroutine_suspended = IntrinsicsKt__IntrinsicsJvmKt.getCOROUTINE_SUSPENDED();
            if (invoke != coroutine_suspended) {
                if (continuation == null) {
                    throw new TypeCastException("null cannot be cast to non-null type kotlin.coroutines.experimental.Continuation<kotlin.Any?>");
                }
                continuation.resume(invoke);
            }
        } catch (Throwable th) {
            continuation.resumeWithException(th);
        }
    }

    @SinceKotlin(version = "1.1")
    public static final <R, T> void startCoroutine(@d Function2<? super R, ? super Continuation<? super T>, ? extends Object> startCoroutine, R r, @d Continuation<? super T> completion) {
        Continuation<Unit> createCoroutineUnchecked;
        Intrinsics.checkParameterIsNotNull(startCoroutine, "$this$startCoroutine");
        Intrinsics.checkParameterIsNotNull(completion, "completion");
        createCoroutineUnchecked = IntrinsicsKt__IntrinsicsJvmKt.createCoroutineUnchecked(startCoroutine, r, completion);
        createCoroutineUnchecked.resume(Unit.INSTANCE);
    }

    @e
    @SinceKotlin(version = "1.1")
    public static final <T> Object suspendCoroutine(@d Function1<? super Continuation<? super T>, Unit> function1, @d Continuation<? super T> continuation) {
        SafeContinuation safeContinuation = new SafeContinuation(CoroutineIntrinsics.normalizeContinuation(continuation));
        function1.invoke(safeContinuation);
        return safeContinuation.getResult();
    }

    @e
    @SinceKotlin(version = "1.1")
    private static final Object suspendCoroutine$$forInline(@d Function1 function1, @d Continuation continuation) {
        InlineMarker.mark(0);
        SafeContinuation safeContinuation = new SafeContinuation(CoroutineIntrinsics.normalizeContinuation(continuation));
        function1.invoke(safeContinuation);
        Object result = safeContinuation.getResult();
        InlineMarker.mark(1);
        return result;
    }

    @d
    @SinceKotlin(version = "1.1")
    public static final <T> Continuation<Unit> createCoroutine(@d Function1<? super Continuation<? super T>, ? extends Object> createCoroutine, @d Continuation<? super T> completion) {
        Continuation<Unit> createCoroutineUnchecked;
        Object coroutine_suspended;
        Intrinsics.checkParameterIsNotNull(createCoroutine, "$this$createCoroutine");
        Intrinsics.checkParameterIsNotNull(completion, "completion");
        createCoroutineUnchecked = IntrinsicsKt__IntrinsicsJvmKt.createCoroutineUnchecked(createCoroutine, completion);
        coroutine_suspended = IntrinsicsKt__IntrinsicsJvmKt.getCOROUTINE_SUSPENDED();
        return new SafeContinuation(createCoroutineUnchecked, coroutine_suspended);
    }

    @SinceKotlin(version = "1.1")
    public static final <T> void startCoroutine(@d Function1<? super Continuation<? super T>, ? extends Object> startCoroutine, @d Continuation<? super T> completion) {
        Continuation<Unit> createCoroutineUnchecked;
        Intrinsics.checkParameterIsNotNull(startCoroutine, "$this$startCoroutine");
        Intrinsics.checkParameterIsNotNull(completion, "completion");
        createCoroutineUnchecked = IntrinsicsKt__IntrinsicsJvmKt.createCoroutineUnchecked(startCoroutine, completion);
        createCoroutineUnchecked.resume(Unit.INSTANCE);
    }
}
