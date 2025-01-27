package com.martian.mibook.mvvm.yuewen.fragment;

import com.martian.mibook.application.MiBookManager;
import com.martian.mibook.application.MiConfigSingleton;
import com.martian.mibook.lib.model.data.BookWrapper;
import com.martian.mibook.lib.model.data.MiReadingRecord;
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
@DebugMetadata(c = "com.martian.mibook.mvvm.yuewen.fragment.YWBookMallMainFragment$checkLastReadingRecordBookUpdate$1", f = "YWBookMallMainFragment.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes3.dex */
public final class YWBookMallMainFragment$checkLastReadingRecordBookUpdate$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ YWBookMallMainFragment this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public YWBookMallMainFragment$checkLastReadingRecordBookUpdate$1(YWBookMallMainFragment yWBookMallMainFragment, Continuation<? super YWBookMallMainFragment$checkLastReadingRecordBookUpdate$1> continuation) {
        super(2, continuation);
        this.this$0 = yWBookMallMainFragment;
    }

    /* JADX WARN: Code restructure failed: missing block: B:2:0x0002, code lost:
    
        r1 = r1.rxManager;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final void invokeSuspend$lambda$0(com.martian.mibook.mvvm.yuewen.fragment.YWBookMallMainFragment r1, int r2) {
        /*
            if (r2 <= 0) goto L13
            e9.c r1 = com.martian.mibook.mvvm.yuewen.fragment.YWBookMallMainFragment.r0(r1)
            if (r1 == 0) goto L13
            java.lang.String r2 = ya.j2.f33277r
            int r0 = ya.j2.f33284y
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
            r1.d(r2, r0)
        L13:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.martian.mibook.mvvm.yuewen.fragment.YWBookMallMainFragment$checkLastReadingRecordBookUpdate$1.invokeSuspend$lambda$0(com.martian.mibook.mvvm.yuewen.fragment.YWBookMallMainFragment, int):void");
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @k
    public final Continuation<Unit> create(@l Object obj, @k Continuation<?> continuation) {
        return new YWBookMallMainFragment$checkLastReadingRecordBookUpdate$1(this.this$0, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @l
    public final Object invokeSuspend(@k Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.throwOnFailure(obj);
        MiReadingRecord a22 = MiConfigSingleton.b2().a2();
        BookWrapper o10 = MiConfigSingleton.b2().M1().T().o(a22 != null ? a22.getSourceString() : null);
        if ((o10 != null ? o10.item : null) == null || o10.item.getChapterSize() == null) {
            return Unit.INSTANCE;
        }
        MiConfigSingleton.b2().M1().q1(this.this$0.getActivity(), a22.getSourceString(), new MiBookManager.z() { // from class: com.martian.mibook.mvvm.yuewen.fragment.a
            public /* synthetic */ a() {
            }

            @Override // com.martian.mibook.application.MiBookManager.z
            public final void a(int i10) {
                YWBookMallMainFragment$checkLastReadingRecordBookUpdate$1.invokeSuspend$lambda$0(YWBookMallMainFragment.this, i10);
            }
        });
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    @l
    public final Object invoke(@k CoroutineScope coroutineScope, @l Continuation<? super Unit> continuation) {
        return ((YWBookMallMainFragment$checkLastReadingRecordBookUpdate$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
