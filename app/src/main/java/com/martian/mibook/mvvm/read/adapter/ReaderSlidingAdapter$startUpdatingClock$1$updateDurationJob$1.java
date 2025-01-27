package com.martian.mibook.mvvm.read.adapter;

import com.martian.mibook.mvvm.read.dialog.ReadingExitRecommendDialogFragment;
import com.martian.mibook.mvvm.read.viewmodel.ReadingViewModel;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import org.mozilla.universalchardet.prober.g;
import xi.k;
import xi.l;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.martian.mibook.mvvm.read.adapter.ReaderSlidingAdapter$startUpdatingClock$1$updateDurationJob$1", f = "ReaderSlidingAdapter.kt", i = {}, l = {226, 229, g.f29289p, 236}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes3.dex */
public final class ReaderSlidingAdapter$startUpdatingClock$1$updateDurationJob$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ ReaderSlidingAdapter this$0;

    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.martian.mibook.mvvm.read.adapter.ReaderSlidingAdapter$startUpdatingClock$1$updateDurationJob$1$1", f = "ReaderSlidingAdapter.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.martian.mibook.mvvm.read.adapter.ReaderSlidingAdapter$startUpdatingClock$1$updateDurationJob$1$1 */
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
            ReadingViewModel.g0(this.this$0.T0(), false, false, 3, null);
            return Unit.INSTANCE;
        }

        @Override // kotlin.jvm.functions.Function2
        @l
        public final Object invoke(@k CoroutineScope coroutineScope, @l Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }
    }

    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.martian.mibook.mvvm.read.adapter.ReaderSlidingAdapter$startUpdatingClock$1$updateDurationJob$1$2", f = "ReaderSlidingAdapter.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.martian.mibook.mvvm.read.adapter.ReaderSlidingAdapter$startUpdatingClock$1$updateDurationJob$1$2 */
    public static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ ReaderSlidingAdapter this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(ReaderSlidingAdapter readerSlidingAdapter, Continuation<? super AnonymousClass2> continuation) {
            super(2, continuation);
            this.this$0 = readerSlidingAdapter;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @k
        public final Continuation<Unit> create(@l Object obj, @k Continuation<?> continuation) {
            return new AnonymousClass2(this.this$0, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @l
        public final Object invokeSuspend(@k Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            ReadingExitRecommendDialogFragment.INSTANCE.a(this.this$0.getActivity(), this.this$0.T0());
            return Unit.INSTANCE;
        }

        @Override // kotlin.jvm.functions.Function2
        @l
        public final Object invoke(@k CoroutineScope coroutineScope, @l Continuation<? super Unit> continuation) {
            return ((AnonymousClass2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ReaderSlidingAdapter$startUpdatingClock$1$updateDurationJob$1(ReaderSlidingAdapter readerSlidingAdapter, Continuation<? super ReaderSlidingAdapter$startUpdatingClock$1$updateDurationJob$1> continuation) {
        super(2, continuation);
        this.this$0 = readerSlidingAdapter;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @k
    public final Continuation<Unit> create(@l Object obj, @k Continuation<?> continuation) {
        return new ReaderSlidingAdapter$startUpdatingClock$1$updateDurationJob$1(this.this$0, continuation);
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0081  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0066  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0074 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0069  */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @xi.l
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object invokeSuspend(@xi.k java.lang.Object r9) {
        /*
            r8 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r8.label
            r2 = 0
            r3 = 4
            r4 = 3
            r5 = 2
            r6 = 1
            if (r1 == 0) goto L2e
            if (r1 == r6) goto L2a
            if (r1 == r5) goto L26
            if (r1 == r4) goto L22
            if (r1 != r3) goto L1a
            kotlin.ResultKt.throwOnFailure(r9)
            goto L95
        L1a:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r9.<init>(r0)
            throw r9
        L22:
            kotlin.ResultKt.throwOnFailure(r9)
            goto L75
        L26:
            kotlin.ResultKt.throwOnFailure(r9)
            goto L5c
        L2a:
            kotlin.ResultKt.throwOnFailure(r9)
            goto L3c
        L2e:
            kotlin.ResultKt.throwOnFailure(r9)
            r8.label = r6
            r6 = 30000(0x7530, double:1.4822E-319)
            java.lang.Object r9 = kotlinx.coroutines.DelayKt.delay(r6, r8)
            if (r9 != r0) goto L3c
            return r0
        L3c:
            com.martian.mibook.mvvm.read.adapter.ReaderSlidingAdapter r9 = r8.this$0
            com.martian.mibook.mvvm.read.viewmodel.ReadingViewModel r9 = com.martian.mibook.mvvm.read.adapter.ReaderSlidingAdapter.j0(r9)
            com.martian.mibook.mvvm.net.result.TYBookTopUser r9 = r9.getTyBookTopUser()
            if (r9 != 0) goto L5c
            kotlinx.coroutines.MainCoroutineDispatcher r9 = kotlinx.coroutines.Dispatchers.getMain()
            com.martian.mibook.mvvm.read.adapter.ReaderSlidingAdapter$startUpdatingClock$1$updateDurationJob$1$1 r1 = new com.martian.mibook.mvvm.read.adapter.ReaderSlidingAdapter$startUpdatingClock$1$updateDurationJob$1$1
            com.martian.mibook.mvvm.read.adapter.ReaderSlidingAdapter r6 = r8.this$0
            r1.<init>(r6, r2)
            r8.label = r5
            java.lang.Object r9 = kotlinx.coroutines.BuildersKt.withContext(r9, r1, r8)
            if (r9 != r0) goto L5c
            return r0
        L5c:
            com.martian.libmars.common.ConfigSingleton r9 = com.martian.libmars.common.ConfigSingleton.D()
            boolean r9 = r9.B0()
            if (r9 == 0) goto L69
            r5 = 3000(0xbb8, double:1.482E-320)
            goto L6c
        L69:
            r5 = 150000(0x249f0, double:7.411E-319)
        L6c:
            r8.label = r4
            java.lang.Object r9 = kotlinx.coroutines.DelayKt.delay(r5, r8)
            if (r9 != r0) goto L75
            return r0
        L75:
            com.martian.mibook.mvvm.read.adapter.ReaderSlidingAdapter r9 = r8.this$0
            com.martian.mibook.mvvm.read.viewmodel.ReadingViewModel r9 = com.martian.mibook.mvvm.read.adapter.ReaderSlidingAdapter.j0(r9)
            java.util.List r9 = r9.u1()
            if (r9 != 0) goto L95
            kotlinx.coroutines.MainCoroutineDispatcher r9 = kotlinx.coroutines.Dispatchers.getMain()
            com.martian.mibook.mvvm.read.adapter.ReaderSlidingAdapter$startUpdatingClock$1$updateDurationJob$1$2 r1 = new com.martian.mibook.mvvm.read.adapter.ReaderSlidingAdapter$startUpdatingClock$1$updateDurationJob$1$2
            com.martian.mibook.mvvm.read.adapter.ReaderSlidingAdapter r4 = r8.this$0
            r1.<init>(r4, r2)
            r8.label = r3
            java.lang.Object r9 = kotlinx.coroutines.BuildersKt.withContext(r9, r1, r8)
            if (r9 != r0) goto L95
            return r0
        L95:
            kotlin.Unit r9 = kotlin.Unit.INSTANCE
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.martian.mibook.mvvm.read.adapter.ReaderSlidingAdapter$startUpdatingClock$1$updateDurationJob$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    @Override // kotlin.jvm.functions.Function2
    @l
    public final Object invoke(@k CoroutineScope coroutineScope, @l Continuation<? super Unit> continuation) {
        return ((ReaderSlidingAdapter$startUpdatingClock$1$updateDurationJob$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
