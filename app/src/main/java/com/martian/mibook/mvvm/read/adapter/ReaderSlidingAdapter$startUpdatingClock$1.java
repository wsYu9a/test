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
@DebugMetadata(c = "com.martian.mibook.mvvm.read.adapter.ReaderSlidingAdapter$startUpdatingClock$1", f = "ReaderSlidingAdapter.kt", i = {0, 1}, l = {214, 254, 255}, m = "invokeSuspend", n = {"$this$launch", "updateClockJob"}, s = {"L$0", "L$0"})
/* loaded from: classes3.dex */
public final class ReaderSlidingAdapter$startUpdatingClock$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ ReaderSlidingAdapter this$0;

    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.martian.mibook.mvvm.read.adapter.ReaderSlidingAdapter$startUpdatingClock$1$1", f = "ReaderSlidingAdapter.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.martian.mibook.mvvm.read.adapter.ReaderSlidingAdapter$startUpdatingClock$1$1 */
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
    public ReaderSlidingAdapter$startUpdatingClock$1(ReaderSlidingAdapter readerSlidingAdapter, Continuation<? super ReaderSlidingAdapter$startUpdatingClock$1> continuation) {
        super(2, continuation);
        this.this$0 = readerSlidingAdapter;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @k
    public final Continuation<Unit> create(@l Object obj, @k Continuation<?> continuation) {
        ReaderSlidingAdapter$startUpdatingClock$1 readerSlidingAdapter$startUpdatingClock$1 = new ReaderSlidingAdapter$startUpdatingClock$1(this.this$0, continuation);
        readerSlidingAdapter$startUpdatingClock$1.L$0 = obj;
        return readerSlidingAdapter$startUpdatingClock$1;
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x00af A[RETURN] */
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
            r2 = 3
            r3 = 2
            r4 = 1
            r5 = 0
            if (r1 == 0) goto L30
            if (r1 == r4) goto L28
            if (r1 == r3) goto L1f
            if (r1 != r2) goto L17
            kotlin.ResultKt.throwOnFailure(r13)
            goto Lb0
        L17:
            java.lang.IllegalStateException r13 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r13.<init>(r0)
            throw r13
        L1f:
            java.lang.Object r1 = r12.L$0
            kotlinx.coroutines.Job r1 = (kotlinx.coroutines.Job) r1
            kotlin.ResultKt.throwOnFailure(r13)
            goto La5
        L28:
            java.lang.Object r1 = r12.L$0
            kotlinx.coroutines.CoroutineScope r1 = (kotlinx.coroutines.CoroutineScope) r1
            kotlin.ResultKt.throwOnFailure(r13)
            goto L4e
        L30:
            kotlin.ResultKt.throwOnFailure(r13)
            java.lang.Object r13 = r12.L$0
            r1 = r13
            kotlinx.coroutines.CoroutineScope r1 = (kotlinx.coroutines.CoroutineScope) r1
            kotlinx.coroutines.MainCoroutineDispatcher r13 = kotlinx.coroutines.Dispatchers.getMain()
            com.martian.mibook.mvvm.read.adapter.ReaderSlidingAdapter$startUpdatingClock$1$1 r6 = new com.martian.mibook.mvvm.read.adapter.ReaderSlidingAdapter$startUpdatingClock$1$1
            com.martian.mibook.mvvm.read.adapter.ReaderSlidingAdapter r7 = r12.this$0
            r6.<init>(r7, r5)
            r12.L$0 = r1
            r12.label = r4
            java.lang.Object r13 = kotlinx.coroutines.BuildersKt.withContext(r13, r6, r12)
            if (r13 != r0) goto L4e
            return r0
        L4e:
            com.martian.mibook.mvvm.read.dialog.ReadingExitRecommendDialogFragment$a r13 = com.martian.mibook.mvvm.read.dialog.ReadingExitRecommendDialogFragment.INSTANCE
            com.martian.mibook.mvvm.read.adapter.ReaderSlidingAdapter r6 = r12.this$0
            androidx.fragment.app.FragmentActivity r6 = r6.getActivity()
            int r6 = r13.b(r6)
            com.martian.mibook.mvvm.read.adapter.ReaderSlidingAdapter r7 = r12.this$0
            com.martian.mibook.mvvm.read.viewmodel.ReadingViewModel r7 = com.martian.mibook.mvvm.read.adapter.ReaderSlidingAdapter.j0(r7)
            java.util.List r7 = r7.u1()
            if (r7 == 0) goto L6b
            int r7 = r7.size()
            goto L6c
        L6b:
            r7 = 0
        L6c:
            if (r4 > r7) goto L7f
            if (r7 >= r6) goto L7f
            com.martian.mibook.mvvm.read.adapter.ReaderSlidingAdapter r4 = r12.this$0
            androidx.fragment.app.FragmentActivity r4 = r4.getActivity()
            com.martian.mibook.mvvm.read.adapter.ReaderSlidingAdapter r6 = r12.this$0
            com.martian.mibook.mvvm.read.viewmodel.ReadingViewModel r6 = com.martian.mibook.mvvm.read.adapter.ReaderSlidingAdapter.j0(r6)
            r13.a(r4, r6)
        L7f:
            com.martian.mibook.mvvm.read.adapter.ReaderSlidingAdapter$startUpdatingClock$1$updateDurationJob$1 r9 = new com.martian.mibook.mvvm.read.adapter.ReaderSlidingAdapter$startUpdatingClock$1$updateDurationJob$1
            com.martian.mibook.mvvm.read.adapter.ReaderSlidingAdapter r13 = r12.this$0
            r9.<init>(r13, r5)
            r10 = 3
            r11 = 0
            r7 = 0
            r8 = 0
            r6 = r1
            kotlinx.coroutines.Job r13 = kotlinx.coroutines.BuildersKt.launch$default(r6, r7, r8, r9, r10, r11)
            com.martian.mibook.mvvm.read.adapter.ReaderSlidingAdapter$startUpdatingClock$1$updateClockJob$1 r9 = new com.martian.mibook.mvvm.read.adapter.ReaderSlidingAdapter$startUpdatingClock$1$updateClockJob$1
            com.martian.mibook.mvvm.read.adapter.ReaderSlidingAdapter r4 = r12.this$0
            r9.<init>(r4, r5)
            kotlinx.coroutines.Job r1 = kotlinx.coroutines.BuildersKt.launch$default(r6, r7, r8, r9, r10, r11)
            r12.L$0 = r1
            r12.label = r3
            java.lang.Object r13 = r13.join(r12)
            if (r13 != r0) goto La5
            return r0
        La5:
            r12.L$0 = r5
            r12.label = r2
            java.lang.Object r13 = r1.join(r12)
            if (r13 != r0) goto Lb0
            return r0
        Lb0:
            kotlin.Unit r13 = kotlin.Unit.INSTANCE
            return r13
        */
        throw new UnsupportedOperationException("Method not decompiled: com.martian.mibook.mvvm.read.adapter.ReaderSlidingAdapter$startUpdatingClock$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    @Override // kotlin.jvm.functions.Function2
    @l
    public final Object invoke(@k CoroutineScope coroutineScope, @l Continuation<? super Unit> continuation) {
        return ((ReaderSlidingAdapter$startUpdatingClock$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
