package kotlinx.coroutines.future;

import androidx.exifinterface.media.ExifInterface;
import com.sigmob.sdk.downloader.core.breakpoint.e;
import com.umeng.analytics.pro.f;
import hi.i;
import hi.l;
import java.util.concurrent.CancellationException;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionStage;
import java.util.concurrent.ExecutionException;
import java.util.function.BiFunction;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.CompletableDeferred;
import kotlinx.coroutines.CompletableDeferredKt;
import kotlinx.coroutines.CoroutineContextKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Deferred;
import kotlinx.coroutines.ExceptionsKt;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.JobKt;
import kotlinx.coroutines.future.FutureKt;
import xi.k;

@Metadata(d1 = {"\u0000D\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u001c\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0003\u001a\u0010\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00040\u0001*\u00020\u0005\u001a\u001c\u0010\u0006\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0003\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0007\u001a!\u0010\b\u001a\u0002H\u0002\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0007H\u0086@ø\u0001\u0000¢\u0006\u0002\u0010\t\u001a[\u0010\n\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2'\u0010\u0010\u001a#\b\u0001\u0012\u0004\u0012\u00020\u000b\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u00130\u0011¢\u0006\u0002\b\u0014ø\u0001\u0000¢\u0006\u0002\u0010\u0015\u001a\u0018\u0010\u0016\u001a\u00020\u0004*\u00020\u00052\n\u0010\n\u001a\u0006\u0012\u0002\b\u00030\u0001H\u0002\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0017"}, d2 = {"asCompletableFuture", "Ljava/util/concurrent/CompletableFuture;", ExifInterface.GPS_DIRECTION_TRUE, "Lkotlinx/coroutines/Deferred;", "", "Lkotlinx/coroutines/Job;", "asDeferred", "Ljava/util/concurrent/CompletionStage;", "await", "(Ljava/util/concurrent/CompletionStage;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "future", "Lkotlinx/coroutines/CoroutineScope;", f.X, "Lkotlin/coroutines/CoroutineContext;", "start", "Lkotlinx/coroutines/CoroutineStart;", e.f19025e, "Lkotlin/Function2;", "Lkotlin/coroutines/Continuation;", "", "Lkotlin/ExtensionFunctionType;", "(Lkotlinx/coroutines/CoroutineScope;Lkotlin/coroutines/CoroutineContext;Lkotlinx/coroutines/CoroutineStart;Lkotlin/jvm/functions/Function2;)Ljava/util/concurrent/CompletableFuture;", "setupCancellation", "kotlinx-coroutines-core"}, k = 2, mv = {1, 8, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nFuture.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Future.kt\nkotlinx/coroutines/future/FutureKt\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 CancellableContinuation.kt\nkotlinx/coroutines/CancellableContinuationKt\n*L\n1#1,197:1\n1#2:198\n314#3,11:199\n*S KotlinDebug\n*F\n+ 1 Future.kt\nkotlinx/coroutines/future/FutureKt\n*L\n172#1:199,11\n*E\n"})
/* loaded from: classes4.dex */
public final class FutureKt {
    @k
    public static final <T> CompletableFuture<T> asCompletableFuture(@k Deferred<? extends T> deferred) {
        CompletableFuture<T> a10 = l.a();
        setupCancellation(deferred, a10);
        deferred.invokeOnCompletion(new Function1<Throwable, Unit>() { // from class: kotlinx.coroutines.future.FutureKt$asCompletableFuture$1
            final /* synthetic */ CompletableFuture<T> $future;
            final /* synthetic */ Deferred<T> $this_asCompletableFuture;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            public FutureKt$asCompletableFuture$1(CompletableFuture<T> a102, Deferred<? extends T> deferred2) {
                super(1);
                a10 = a102;
                deferred = deferred2;
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Throwable th2) {
                invoke2(th2);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke */
            public final void invoke2(@xi.l Throwable th2) {
                try {
                    a10.complete(deferred.getCompleted());
                } catch (Throwable th3) {
                    a10.completeExceptionally(th3);
                }
            }
        });
        return a102;
    }

    @k
    public static final <T> Deferred<T> asDeferred(@k CompletionStage<T> completionStage) {
        CompletableFuture completableFuture;
        boolean isDone;
        Throwable cause;
        Object obj;
        completableFuture = completionStage.toCompletableFuture();
        isDone = completableFuture.isDone();
        if (!isDone) {
            CompletableDeferred CompletableDeferred$default = CompletableDeferredKt.CompletableDeferred$default(null, 1, null);
            completionStage.handle(new BiFunction() { // from class: hi.m
                public /* synthetic */ m() {
                }

                @Override // java.util.function.BiFunction
                public final Object apply(Object obj2, Object obj3) {
                    Object invoke;
                    invoke = Function2.this.invoke(obj2, (Throwable) obj3);
                    return invoke;
                }
            });
            JobKt.cancelFutureOnCompletion(CompletableDeferred$default, completableFuture);
            return CompletableDeferred$default;
        }
        try {
            obj = completableFuture.get();
            return CompletableDeferredKt.CompletableDeferred(obj);
        } catch (Throwable th2) {
            th = th2;
            ExecutionException executionException = th instanceof ExecutionException ? (ExecutionException) th : null;
            if (executionException != null && (cause = executionException.getCause()) != null) {
                th = cause;
            }
            CompletableDeferred CompletableDeferred$default2 = CompletableDeferredKt.CompletableDeferred$default(null, 1, null);
            CompletableDeferred$default2.completeExceptionally(th);
            return CompletableDeferred$default2;
        }
    }

    /*  JADX ERROR: JadxRuntimeException in pass: ProcessVariables
        jadx.core.utils.exceptions.JadxRuntimeException: Method arg registers not loaded: kotlinx.coroutines.future.FutureKt$await$2$1.<init>(java.util.concurrent.CompletableFuture<T>, kotlinx.coroutines.future.ContinuationHandler<T>):void, class status: GENERATED_AND_UNLOADED
        	at jadx.core.dex.nodes.MethodNode.getArgRegs(MethodNode.java:290)
        	at jadx.core.dex.visitors.regions.variables.ProcessVariables$1.isArgUnused(ProcessVariables.java:146)
        	at jadx.core.dex.visitors.regions.variables.ProcessVariables$1.lambda$isVarUnused$0(ProcessVariables.java:131)
        	at jadx.core.utils.ListUtils.allMatch(ListUtils.java:193)
        	at jadx.core.dex.visitors.regions.variables.ProcessVariables$1.isVarUnused(ProcessVariables.java:131)
        	at jadx.core.dex.visitors.regions.variables.ProcessVariables$1.processBlock(ProcessVariables.java:82)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:64)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(Unknown Source)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverse(DepthRegionTraversal.java:19)
        	at jadx.core.dex.visitors.regions.variables.ProcessVariables.removeUnusedResults(ProcessVariables.java:73)
        	at jadx.core.dex.visitors.regions.variables.ProcessVariables.visit(ProcessVariables.java:48)
        */
    @xi.l
    public static final <T> java.lang.Object await(@xi.k java.util.concurrent.CompletionStage<T> r4, @xi.k kotlin.coroutines.Continuation<? super T> r5) {
        /*
            java.util.concurrent.CompletableFuture r0 = hi.f.a(r4)
            boolean r1 = hi.g.a(r0)
            if (r1 == 0) goto L19
            java.lang.Object r4 = hi.h.a(r0)     // Catch: java.util.concurrent.ExecutionException -> Lf
            return r4
        Lf:
            r4 = move-exception
            java.lang.Throwable r5 = r4.getCause()
            if (r5 != 0) goto L17
            goto L18
        L17:
            r4 = r5
        L18:
            throw r4
        L19:
            kotlinx.coroutines.CancellableContinuationImpl r1 = new kotlinx.coroutines.CancellableContinuationImpl
            kotlin.coroutines.Continuation r2 = kotlin.coroutines.intrinsics.IntrinsicsKt.intercepted(r5)
            r3 = 1
            r1.<init>(r2, r3)
            r1.initCancellability()
            kotlinx.coroutines.future.ContinuationHandler r2 = new kotlinx.coroutines.future.ContinuationHandler
            r2.<init>(r1)
            java.util.function.BiFunction r3 = hi.i.a(r2)
            hi.j.a(r4, r3)
            kotlinx.coroutines.future.FutureKt$await$2$1 r4 = new kotlinx.coroutines.future.FutureKt$await$2$1
            r4.<init>()
            r1.invokeOnCancellation(r4)
            java.lang.Object r4 = r1.getResult()
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            if (r4 != r0) goto L47
            kotlin.coroutines.jvm.internal.DebugProbesKt.probeCoroutineSuspended(r5)
        L47:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.future.FutureKt.await(java.util.concurrent.CompletionStage, kotlin.coroutines.Continuation):java.lang.Object");
    }

    @k
    public static final <T> CompletableFuture<T> future(@k CoroutineScope coroutineScope, @k CoroutineContext coroutineContext, @k CoroutineStart coroutineStart, @k Function2<? super CoroutineScope, ? super Continuation<? super T>, ? extends Object> function2) {
        if (!(!coroutineStart.isLazy())) {
            throw new IllegalArgumentException((coroutineStart + " start is not supported").toString());
        }
        CoroutineContext newCoroutineContext = CoroutineContextKt.newCoroutineContext(coroutineScope, coroutineContext);
        CompletableFuture<T> a10 = l.a();
        CompletableFutureCoroutine completableFutureCoroutine = new CompletableFutureCoroutine(newCoroutineContext, a10);
        a10.handle(i.a(completableFutureCoroutine));
        completableFutureCoroutine.start(coroutineStart, completableFutureCoroutine, function2);
        return a10;
    }

    public static /* synthetic */ CompletableFuture future$default(CoroutineScope coroutineScope, CoroutineContext coroutineContext, CoroutineStart coroutineStart, Function2 function2, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            coroutineContext = EmptyCoroutineContext.INSTANCE;
        }
        if ((i10 & 2) != 0) {
            coroutineStart = CoroutineStart.DEFAULT;
        }
        return future(coroutineScope, coroutineContext, coroutineStart, function2);
    }

    private static final void setupCancellation(Job job, CompletableFuture<?> completableFuture) {
        completableFuture.handle((BiFunction<? super Object, Throwable, ? extends U>) new BiFunction() { // from class: hi.n
            public /* synthetic */ n() {
            }

            @Override // java.util.function.BiFunction
            public final Object apply(Object obj, Object obj2) {
                Unit unit;
                unit = FutureKt.setupCancellation$lambda$2(Job.this, obj, (Throwable) obj2);
                return unit;
            }
        });
    }

    public static final Unit setupCancellation$lambda$2(Job job, Object obj, Throwable th2) {
        if (th2 != null) {
            r2 = th2 instanceof CancellationException ? (CancellationException) th2 : null;
            if (r2 == null) {
                r2 = ExceptionsKt.CancellationException("CompletableFuture was completed exceptionally", th2);
            }
        }
        job.cancel(r2);
        return Unit.INSTANCE;
    }

    @k
    public static final CompletableFuture<Unit> asCompletableFuture(@k Job job) {
        CompletableFuture<Unit> a10 = l.a();
        setupCancellation(job, a10);
        job.invokeOnCompletion(new Function1<Throwable, Unit>() { // from class: kotlinx.coroutines.future.FutureKt$asCompletableFuture$2
            final /* synthetic */ CompletableFuture<Unit> $future;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public FutureKt$asCompletableFuture$2(CompletableFuture<Unit> a102) {
                super(1);
                a10 = a102;
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Throwable th2) {
                invoke2(th2);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke */
            public final void invoke2(@xi.l Throwable th2) {
                if (th2 == null) {
                    a10.complete(Unit.INSTANCE);
                } else {
                    a10.completeExceptionally(th2);
                }
            }
        });
        return a102;
    }
}
