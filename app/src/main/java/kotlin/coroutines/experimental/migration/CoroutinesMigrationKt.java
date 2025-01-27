package kotlin.coroutines.experimental.migration;

import androidx.exifinterface.media.ExifInterface;
import f.b.a.d;
import kotlin.Metadata;
import kotlin.SinceKotlin;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.ContinuationInterceptor;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.experimental.ContinuationInterceptor;
import kotlin.coroutines.experimental.migration.ContextMigration;
import kotlin.coroutines.experimental.migration.ExperimentalContextMigration;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000B\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a%\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u0001H\u0007¢\u0006\u0004\b\u0003\u0010\u0004\u001a%\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u0002H\u0007¢\u0006\u0004\b\u0005\u0010\u0006\u001a\u0013\u0010\t\u001a\u00020\b*\u00020\u0007H\u0007¢\u0006\u0004\b\t\u0010\n\u001a\u0013\u0010\u000b\u001a\u00020\u0007*\u00020\bH\u0007¢\u0006\u0004\b\u000b\u0010\f\u001a\u0013\u0010\u000f\u001a\u00020\u000e*\u00020\rH\u0007¢\u0006\u0004\b\u000f\u0010\u0010\u001a\u0013\u0010\u0011\u001a\u00020\r*\u00020\u000eH\u0007¢\u0006\u0004\b\u0011\u0010\u0012\u001aA\u0010\u0016\u001a\u0016\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00150\u0014\"\u0004\b\u0000\u0010\u0013*\u0016\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0001\u0012\u0006\u0012\u0004\u0018\u00010\u00150\u0014H\u0000¢\u0006\u0004\b\u0016\u0010\u0017\u001aS\u0010\u0016\u001a\u001c\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00150\u0019\"\u0004\b\u0000\u0010\u0018\"\u0004\b\u0001\u0010\u0013*\u001c\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\u0001\u0012\u0006\u0012\u0004\u0018\u00010\u00150\u0019H\u0000¢\u0006\u0004\b\u0016\u0010\u001a\u001ae\u0010\u0016\u001a\"\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00150\u001c\"\u0004\b\u0000\u0010\u0018\"\u0004\b\u0001\u0010\u001b\"\u0004\b\u0002\u0010\u0013*\"\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00020\u0001\u0012\u0006\u0012\u0004\u0018\u00010\u00150\u001cH\u0000¢\u0006\u0004\b\u0016\u0010\u001d¨\u0006\u001e"}, d2 = {ExifInterface.GPS_DIRECTION_TRUE, "Lkotlin/coroutines/Continuation;", "Lkotlin/coroutines/experimental/Continuation;", "toExperimentalContinuation", "(Lkotlin/coroutines/Continuation;)Lkotlin/coroutines/experimental/Continuation;", "toContinuation", "(Lkotlin/coroutines/experimental/Continuation;)Lkotlin/coroutines/Continuation;", "Lkotlin/coroutines/CoroutineContext;", "Lkotlin/coroutines/experimental/CoroutineContext;", "toExperimentalCoroutineContext", "(Lkotlin/coroutines/CoroutineContext;)Lkotlin/coroutines/experimental/CoroutineContext;", "toCoroutineContext", "(Lkotlin/coroutines/experimental/CoroutineContext;)Lkotlin/coroutines/CoroutineContext;", "Lkotlin/coroutines/ContinuationInterceptor;", "Lkotlin/coroutines/experimental/ContinuationInterceptor;", "toExperimentalContinuationInterceptor", "(Lkotlin/coroutines/ContinuationInterceptor;)Lkotlin/coroutines/experimental/ContinuationInterceptor;", "toContinuationInterceptor", "(Lkotlin/coroutines/experimental/ContinuationInterceptor;)Lkotlin/coroutines/ContinuationInterceptor;", "R", "Lkotlin/Function1;", "", "toExperimentalSuspendFunction", "(Lkotlin/jvm/functions/Function1;)Lkotlin/jvm/functions/Function1;", "T1", "Lkotlin/Function2;", "(Lkotlin/jvm/functions/Function2;)Lkotlin/jvm/functions/Function2;", "T2", "Lkotlin/Function3;", "(Lkotlin/jvm/functions/Function3;)Lkotlin/jvm/functions/Function3;", "kotlin-stdlib-coroutines"}, k = 2, mv = {1, 4, 0})
/* loaded from: classes5.dex */
public final class CoroutinesMigrationKt {
    @d
    @SinceKotlin(version = "1.3")
    public static final <T> Continuation<T> toContinuation(@d kotlin.coroutines.experimental.Continuation<? super T> toContinuation) {
        Continuation<T> continuation;
        Intrinsics.checkParameterIsNotNull(toContinuation, "$this$toContinuation");
        ExperimentalContinuationMigration experimentalContinuationMigration = (ExperimentalContinuationMigration) (!(toContinuation instanceof ExperimentalContinuationMigration) ? null : toContinuation);
        return (experimentalContinuationMigration == null || (continuation = experimentalContinuationMigration.getContinuation()) == null) ? new ContinuationMigration(toContinuation) : continuation;
    }

    @d
    @SinceKotlin(version = "1.3")
    public static final ContinuationInterceptor toContinuationInterceptor(@d kotlin.coroutines.experimental.ContinuationInterceptor toContinuationInterceptor) {
        ContinuationInterceptor interceptor;
        Intrinsics.checkParameterIsNotNull(toContinuationInterceptor, "$this$toContinuationInterceptor");
        ExperimentalContinuationInterceptorMigration experimentalContinuationInterceptorMigration = (ExperimentalContinuationInterceptorMigration) (!(toContinuationInterceptor instanceof ExperimentalContinuationInterceptorMigration) ? null : toContinuationInterceptor);
        return (experimentalContinuationInterceptorMigration == null || (interceptor = experimentalContinuationInterceptorMigration.getInterceptor()) == null) ? new ContinuationInterceptorMigration(toContinuationInterceptor) : interceptor;
    }

    @d
    @SinceKotlin(version = "1.3")
    public static final CoroutineContext toCoroutineContext(@d kotlin.coroutines.experimental.CoroutineContext toCoroutineContext) {
        CoroutineContext coroutineContext;
        Intrinsics.checkParameterIsNotNull(toCoroutineContext, "$this$toCoroutineContext");
        ContinuationInterceptor.Companion companion = kotlin.coroutines.experimental.ContinuationInterceptor.INSTANCE;
        kotlin.coroutines.experimental.ContinuationInterceptor continuationInterceptor = (kotlin.coroutines.experimental.ContinuationInterceptor) toCoroutineContext.get(companion);
        ExperimentalContextMigration.Companion companion2 = ExperimentalContextMigration.INSTANCE;
        ExperimentalContextMigration experimentalContextMigration = (ExperimentalContextMigration) toCoroutineContext.get(companion2);
        kotlin.coroutines.experimental.CoroutineContext minusKey = toCoroutineContext.minusKey(companion).minusKey(companion2);
        if (experimentalContextMigration == null || (coroutineContext = experimentalContextMigration.getContext()) == null) {
            coroutineContext = EmptyCoroutineContext.INSTANCE;
        }
        if (minusKey != kotlin.coroutines.experimental.EmptyCoroutineContext.INSTANCE) {
            coroutineContext = coroutineContext.plus(new ContextMigration(minusKey));
        }
        return continuationInterceptor == null ? coroutineContext : coroutineContext.plus(toContinuationInterceptor(continuationInterceptor));
    }

    @d
    @SinceKotlin(version = "1.3")
    public static final <T> kotlin.coroutines.experimental.Continuation<T> toExperimentalContinuation(@d Continuation<? super T> toExperimentalContinuation) {
        kotlin.coroutines.experimental.Continuation<T> continuation;
        Intrinsics.checkParameterIsNotNull(toExperimentalContinuation, "$this$toExperimentalContinuation");
        ContinuationMigration continuationMigration = (ContinuationMigration) (!(toExperimentalContinuation instanceof ContinuationMigration) ? null : toExperimentalContinuation);
        return (continuationMigration == null || (continuation = continuationMigration.getContinuation()) == null) ? new ExperimentalContinuationMigration(toExperimentalContinuation) : continuation;
    }

    @d
    @SinceKotlin(version = "1.3")
    public static final kotlin.coroutines.experimental.ContinuationInterceptor toExperimentalContinuationInterceptor(@d kotlin.coroutines.ContinuationInterceptor toExperimentalContinuationInterceptor) {
        kotlin.coroutines.experimental.ContinuationInterceptor interceptor;
        Intrinsics.checkParameterIsNotNull(toExperimentalContinuationInterceptor, "$this$toExperimentalContinuationInterceptor");
        ContinuationInterceptorMigration continuationInterceptorMigration = (ContinuationInterceptorMigration) (!(toExperimentalContinuationInterceptor instanceof ContinuationInterceptorMigration) ? null : toExperimentalContinuationInterceptor);
        return (continuationInterceptorMigration == null || (interceptor = continuationInterceptorMigration.getInterceptor()) == null) ? new ExperimentalContinuationInterceptorMigration(toExperimentalContinuationInterceptor) : interceptor;
    }

    @d
    @SinceKotlin(version = "1.3")
    public static final kotlin.coroutines.experimental.CoroutineContext toExperimentalCoroutineContext(@d CoroutineContext toExperimentalCoroutineContext) {
        kotlin.coroutines.experimental.CoroutineContext coroutineContext;
        Intrinsics.checkParameterIsNotNull(toExperimentalCoroutineContext, "$this$toExperimentalCoroutineContext");
        ContinuationInterceptor.Companion companion = kotlin.coroutines.ContinuationInterceptor.INSTANCE;
        kotlin.coroutines.ContinuationInterceptor continuationInterceptor = (kotlin.coroutines.ContinuationInterceptor) toExperimentalCoroutineContext.get(companion);
        ContextMigration.Companion companion2 = ContextMigration.INSTANCE;
        ContextMigration contextMigration = (ContextMigration) toExperimentalCoroutineContext.get(companion2);
        CoroutineContext minusKey = toExperimentalCoroutineContext.minusKey(companion).minusKey(companion2);
        if (contextMigration == null || (coroutineContext = contextMigration.getContext()) == null) {
            coroutineContext = kotlin.coroutines.experimental.EmptyCoroutineContext.INSTANCE;
        }
        if (minusKey != EmptyCoroutineContext.INSTANCE) {
            coroutineContext = coroutineContext.plus(new ExperimentalContextMigration(minusKey));
        }
        return continuationInterceptor == null ? coroutineContext : coroutineContext.plus(toExperimentalContinuationInterceptor(continuationInterceptor));
    }

    @d
    public static final <R> Function1<kotlin.coroutines.experimental.Continuation<? super R>, Object> toExperimentalSuspendFunction(@d Function1<? super Continuation<? super R>, ? extends Object> toExperimentalSuspendFunction) {
        Intrinsics.checkParameterIsNotNull(toExperimentalSuspendFunction, "$this$toExperimentalSuspendFunction");
        return new ExperimentalSuspendFunction0Migration(toExperimentalSuspendFunction);
    }

    @d
    public static final <T1, R> Function2<T1, kotlin.coroutines.experimental.Continuation<? super R>, Object> toExperimentalSuspendFunction(@d Function2<? super T1, ? super Continuation<? super R>, ? extends Object> toExperimentalSuspendFunction) {
        Intrinsics.checkParameterIsNotNull(toExperimentalSuspendFunction, "$this$toExperimentalSuspendFunction");
        return new ExperimentalSuspendFunction1Migration(toExperimentalSuspendFunction);
    }

    @d
    public static final <T1, T2, R> Function3<T1, T2, kotlin.coroutines.experimental.Continuation<? super R>, Object> toExperimentalSuspendFunction(@d Function3<? super T1, ? super T2, ? super Continuation<? super R>, ? extends Object> toExperimentalSuspendFunction) {
        Intrinsics.checkParameterIsNotNull(toExperimentalSuspendFunction, "$this$toExperimentalSuspendFunction");
        return new ExperimentalSuspendFunction2Migration(toExperimentalSuspendFunction);
    }
}
