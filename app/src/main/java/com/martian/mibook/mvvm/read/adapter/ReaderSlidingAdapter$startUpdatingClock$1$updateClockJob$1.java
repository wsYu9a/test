package com.martian.mibook.mvvm.read.adapter;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import xi.k;
import xi.l;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.martian.mibook.mvvm.read.adapter.ReaderSlidingAdapter$startUpdatingClock$1$updateClockJob$1", f = "ReaderSlidingAdapter.kt", i = {0, 1}, l = {247, 248}, m = "invokeSuspend", n = {"$this$launch", "$this$launch"}, s = {"L$0", "L$0"})
/* loaded from: classes3.dex */
public final class ReaderSlidingAdapter$startUpdatingClock$1$updateClockJob$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ ReaderSlidingAdapter this$0;

    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.martian.mibook.mvvm.read.adapter.ReaderSlidingAdapter$startUpdatingClock$1$updateClockJob$1$1", f = "ReaderSlidingAdapter.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.martian.mibook.mvvm.read.adapter.ReaderSlidingAdapter$startUpdatingClock$1$updateClockJob$1$1 */
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ ReaderSlidingAdapter this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(ReaderSlidingAdapter readerSlidingAdapter, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.this$0 = readerSlidingAdapter;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @k
        public final Continuation<Unit> create(@l Object obj, @k Continuation<?> continuation) {
            return new AnonymousClass1(this.this$0, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @l
        public final Object invokeSuspend(@k Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            ReaderSlidingAdapter.H2(this.this$0, null, 1, null);
            return Unit.INSTANCE;
        }

        @Override // kotlin.jvm.functions.Function2
        @l
        public final Object invoke(@k CoroutineScope coroutineScope, @l Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ReaderSlidingAdapter$startUpdatingClock$1$updateClockJob$1(ReaderSlidingAdapter readerSlidingAdapter, Continuation<? super ReaderSlidingAdapter$startUpdatingClock$1$updateClockJob$1> continuation) {
        super(2, continuation);
        this.this$0 = readerSlidingAdapter;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @k
    public final Continuation<Unit> create(@l Object obj, @k Continuation<?> continuation) {
        ReaderSlidingAdapter$startUpdatingClock$1$updateClockJob$1 readerSlidingAdapter$startUpdatingClock$1$updateClockJob$1 = new ReaderSlidingAdapter$startUpdatingClock$1$updateClockJob$1(this.this$0, continuation);
        readerSlidingAdapter$startUpdatingClock$1$updateClockJob$1.L$0 = obj;
        return readerSlidingAdapter$startUpdatingClock$1$updateClockJob$1;
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0066 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0067  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0034  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:15:0x0064 -> B:6:0x0015). Please report as a decompilation issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @xi.l
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object invokeSuspend(@xi.k java.lang.Object r13) {
        /*
            r12 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r12.label
            r2 = 2
            r3 = 1
            if (r1 == 0) goto L27
            if (r1 == r3) goto L1f
            if (r1 != r2) goto L17
            java.lang.Object r1 = r12.L$0
            kotlinx.coroutines.CoroutineScope r1 = (kotlinx.coroutines.CoroutineScope) r1
            kotlin.ResultKt.throwOnFailure(r13)
        L15:
            r13 = r1
            goto L2e
        L17:
            java.lang.IllegalStateException r13 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r13.<init>(r0)
            throw r13
        L1f:
            java.lang.Object r1 = r12.L$0
            kotlinx.coroutines.CoroutineScope r1 = (kotlinx.coroutines.CoroutineScope) r1
            kotlin.ResultKt.throwOnFailure(r13)
            goto L50
        L27:
            kotlin.ResultKt.throwOnFailure(r13)
            java.lang.Object r13 = r12.L$0
            kotlinx.coroutines.CoroutineScope r13 = (kotlinx.coroutines.CoroutineScope) r13
        L2e:
            boolean r1 = kotlinx.coroutines.CoroutineScopeKt.isActive(r13)
            if (r1 == 0) goto L67
            long r4 = java.lang.System.currentTimeMillis()
            r1 = 60000(0xea60, float:8.4078E-41)
            long r6 = (long) r1
            long r8 = r4 / r6
            r10 = 1
            long r8 = r8 + r10
            long r8 = r8 * r6
            long r8 = r8 - r4
            r12.L$0 = r13
            r12.label = r3
            java.lang.Object r1 = kotlinx.coroutines.DelayKt.delay(r8, r12)
            if (r1 != r0) goto L4f
            return r0
        L4f:
            r1 = r13
        L50:
            kotlinx.coroutines.MainCoroutineDispatcher r13 = kotlinx.coroutines.Dispatchers.getMain()
            com.martian.mibook.mvvm.read.adapter.ReaderSlidingAdapter$startUpdatingClock$1$updateClockJob$1$1 r4 = new com.martian.mibook.mvvm.read.adapter.ReaderSlidingAdapter$startUpdatingClock$1$updateClockJob$1$1
            com.martian.mibook.mvvm.read.adapter.ReaderSlidingAdapter r5 = r12.this$0
            r6 = 0
            r4.<init>(r5, r6)
            r12.L$0 = r1
            r12.label = r2
            java.lang.Object r13 = kotlinx.coroutines.BuildersKt.withContext(r13, r4, r12)
            if (r13 != r0) goto L15
            return r0
        L67:
            kotlin.Unit r13 = kotlin.Unit.INSTANCE
            return r13
        */
        throw new UnsupportedOperationException("Method not decompiled: com.martian.mibook.mvvm.read.adapter.ReaderSlidingAdapter$startUpdatingClock$1$updateClockJob$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    @Override // kotlin.jvm.functions.Function2
    @l
    public final Object invoke(@k CoroutineScope coroutineScope, @l Continuation<? super Unit> continuation) {
        return ((ReaderSlidingAdapter$startUpdatingClock$1$updateClockJob$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
