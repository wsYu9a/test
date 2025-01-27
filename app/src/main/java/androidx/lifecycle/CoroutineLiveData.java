package androidx.lifecycle;

import androidx.exifinterface.media.ExifInterface;
import com.sigmob.sdk.downloader.core.breakpoint.e;
import com.umeng.analytics.pro.f;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.SupervisorKt;
import xi.k;
import xi.l;

@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0000\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002BK\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012-\u0010\u0007\u001a)\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\t\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\n\u0012\u0006\u0012\u0004\u0018\u00010\f0\b¢\u0006\u0002\b\rø\u0001\u0000¢\u0006\u0002\u0010\u000eJ\u0013\u0010\u0013\u001a\u00020\u000bH\u0080@ø\u0001\u0000¢\u0006\u0004\b\u0014\u0010\u0015J!\u0010\u0016\u001a\u00020\u00172\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00028\u00000\u0019H\u0080@ø\u0001\u0000¢\u0006\u0004\b\u001a\u0010\u001bJ\b\u0010\u001c\u001a\u00020\u000bH\u0014J\b\u0010\u001d\u001a\u00020\u000bH\u0014R\u0016\u0010\u000f\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0082\u000e¢\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u001e"}, d2 = {"Landroidx/lifecycle/CoroutineLiveData;", ExifInterface.GPS_DIRECTION_TRUE, "Landroidx/lifecycle/MediatorLiveData;", f.X, "Lkotlin/coroutines/CoroutineContext;", "timeoutInMs", "", e.f19025e, "Lkotlin/Function2;", "Landroidx/lifecycle/LiveDataScope;", "Lkotlin/coroutines/Continuation;", "", "", "Lkotlin/ExtensionFunctionType;", "(Lkotlin/coroutines/CoroutineContext;JLkotlin/jvm/functions/Function2;)V", "blockRunner", "Landroidx/lifecycle/BlockRunner;", "emittedSource", "Landroidx/lifecycle/EmittedSource;", "clearSource", "clearSource$lifecycle_livedata_ktx_release", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "emitSource", "Lkotlinx/coroutines/DisposableHandle;", "source", "Landroidx/lifecycle/LiveData;", "emitSource$lifecycle_livedata_ktx_release", "(Landroidx/lifecycle/LiveData;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "onActive", "onInactive", "lifecycle-livedata-ktx_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes.dex */
public final class CoroutineLiveData<T> extends MediatorLiveData<T> {

    @l
    private BlockRunner<T> blockRunner;

    @l
    private EmittedSource emittedSource;

    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "", ExifInterface.GPS_DIRECTION_TRUE, "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
    /* renamed from: androidx.lifecycle.CoroutineLiveData$1 */
    public static final class AnonymousClass1 extends Lambda implements Function0<Unit> {
        final /* synthetic */ CoroutineLiveData<T> this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(CoroutineLiveData<T> coroutineLiveData) {
            super(0);
            this.this$0 = coroutineLiveData;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.INSTANCE;
        }

        /* renamed from: invoke */
        public final void invoke2() {
            ((CoroutineLiveData) this.this$0).blockRunner = null;
        }
    }

    public /* synthetic */ CoroutineLiveData(CoroutineContext coroutineContext, long j10, Function2 function2, int i10, DefaultConstructorMarker defaultConstructorMarker) {
        this((i10 & 1) != 0 ? EmptyCoroutineContext.INSTANCE : coroutineContext, (i10 & 2) != 0 ? 5000L : j10, function2);
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0035  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
    @xi.l
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object clearSource$lifecycle_livedata_ktx_release(@xi.k kotlin.coroutines.Continuation<? super kotlin.Unit> r5) {
        /*
            r4 = this;
            boolean r0 = r5 instanceof androidx.lifecycle.CoroutineLiveData$clearSource$1
            if (r0 == 0) goto L13
            r0 = r5
            androidx.lifecycle.CoroutineLiveData$clearSource$1 r0 = (androidx.lifecycle.CoroutineLiveData$clearSource$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            androidx.lifecycle.CoroutineLiveData$clearSource$1 r0 = new androidx.lifecycle.CoroutineLiveData$clearSource$1
            r0.<init>(r4, r5)
        L18:
            java.lang.Object r5 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L35
            if (r2 != r3) goto L2d
            java.lang.Object r0 = r0.L$0
            androidx.lifecycle.CoroutineLiveData r0 = (androidx.lifecycle.CoroutineLiveData) r0
            kotlin.ResultKt.throwOnFailure(r5)
            goto L48
        L2d:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r0)
            throw r5
        L35:
            kotlin.ResultKt.throwOnFailure(r5)
            androidx.lifecycle.EmittedSource r5 = r4.emittedSource
            if (r5 == 0) goto L47
            r0.L$0 = r4
            r0.label = r3
            java.lang.Object r5 = r5.disposeNow(r0)
            if (r5 != r1) goto L47
            return r1
        L47:
            r0 = r4
        L48:
            r5 = 0
            r0.emittedSource = r5
            kotlin.Unit r5 = kotlin.Unit.INSTANCE
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.lifecycle.CoroutineLiveData.clearSource$lifecycle_livedata_ktx_release(kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x0065 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0046  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0024  */
    @xi.l
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object emitSource$lifecycle_livedata_ktx_release(@xi.k androidx.lifecycle.LiveData<T> r6, @xi.k kotlin.coroutines.Continuation<? super kotlinx.coroutines.DisposableHandle> r7) {
        /*
            r5 = this;
            boolean r0 = r7 instanceof androidx.lifecycle.CoroutineLiveData$emitSource$1
            if (r0 == 0) goto L13
            r0 = r7
            androidx.lifecycle.CoroutineLiveData$emitSource$1 r0 = (androidx.lifecycle.CoroutineLiveData$emitSource$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            androidx.lifecycle.CoroutineLiveData$emitSource$1 r0 = new androidx.lifecycle.CoroutineLiveData$emitSource$1
            r0.<init>(r5, r7)
        L18:
            java.lang.Object r7 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L46
            if (r2 == r4) goto L38
            if (r2 != r3) goto L30
            java.lang.Object r6 = r0.L$0
            androidx.lifecycle.CoroutineLiveData r6 = (androidx.lifecycle.CoroutineLiveData) r6
            kotlin.ResultKt.throwOnFailure(r7)
            goto L66
        L30:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L38:
            java.lang.Object r6 = r0.L$1
            androidx.lifecycle.LiveData r6 = (androidx.lifecycle.LiveData) r6
            java.lang.Object r2 = r0.L$0
            androidx.lifecycle.CoroutineLiveData r2 = (androidx.lifecycle.CoroutineLiveData) r2
            kotlin.ResultKt.throwOnFailure(r7)
            r7 = r6
            r6 = r2
            goto L58
        L46:
            kotlin.ResultKt.throwOnFailure(r7)
            r0.L$0 = r5
            r0.L$1 = r6
            r0.label = r4
            java.lang.Object r7 = r5.clearSource$lifecycle_livedata_ktx_release(r0)
            if (r7 != r1) goto L56
            return r1
        L56:
            r7 = r6
            r6 = r5
        L58:
            r0.L$0 = r6
            r2 = 0
            r0.L$1 = r2
            r0.label = r3
            java.lang.Object r7 = androidx.lifecycle.CoroutineLiveDataKt.addDisposableSource(r6, r7, r0)
            if (r7 != r1) goto L66
            return r1
        L66:
            androidx.lifecycle.EmittedSource r7 = (androidx.lifecycle.EmittedSource) r7
            r6.emittedSource = r7
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.lifecycle.CoroutineLiveData.emitSource$lifecycle_livedata_ktx_release(androidx.lifecycle.LiveData, kotlin.coroutines.Continuation):java.lang.Object");
    }

    @Override // androidx.lifecycle.MediatorLiveData, androidx.lifecycle.LiveData
    public void onActive() {
        super.onActive();
        BlockRunner<T> blockRunner = this.blockRunner;
        if (blockRunner != null) {
            blockRunner.maybeRun();
        }
    }

    @Override // androidx.lifecycle.MediatorLiveData, androidx.lifecycle.LiveData
    public void onInactive() {
        super.onInactive();
        BlockRunner<T> blockRunner = this.blockRunner;
        if (blockRunner != null) {
            blockRunner.cancel();
        }
    }

    public CoroutineLiveData(@k CoroutineContext context, long j10, @k Function2<? super LiveDataScope<T>, ? super Continuation<? super Unit>, ? extends Object> block) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(block, "block");
        this.blockRunner = new BlockRunner<>(this, block, j10, CoroutineScopeKt.CoroutineScope(Dispatchers.getMain().getImmediate().plus(context).plus(SupervisorKt.SupervisorJob((Job) context.get(Job.INSTANCE)))), new Function0<Unit>(this) { // from class: androidx.lifecycle.CoroutineLiveData.1
            final /* synthetic */ CoroutineLiveData<T> this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AnonymousClass1(CoroutineLiveData<T> this) {
                super(0);
                this.this$0 = this;
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke */
            public final void invoke2() {
                ((CoroutineLiveData) this.this$0).blockRunner = null;
            }
        });
    }
}
