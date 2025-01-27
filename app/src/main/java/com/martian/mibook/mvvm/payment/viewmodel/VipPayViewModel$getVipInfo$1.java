package com.martian.mibook.mvvm.payment.viewmodel;

import com.martian.mibook.mvvm.payment.data.VipInfo;
import com.martian.mibook.mvvm.payment.repository.VipPayRepository;
import com.martian.mibook.mvvm.tts.NonStickyLiveData;
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
@DebugMetadata(c = "com.martian.mibook.mvvm.payment.viewmodel.VipPayViewModel$getVipInfo$1", f = "VipPayViewModel.kt", i = {}, l = {129}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes3.dex */
public final class VipPayViewModel$getVipInfo$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ VipPayViewModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public VipPayViewModel$getVipInfo$1(VipPayViewModel vipPayViewModel, Continuation<? super VipPayViewModel$getVipInfo$1> continuation) {
        super(2, continuation);
        this.this$0 = vipPayViewModel;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @k
    public final Continuation<Unit> create(@l Object obj, @k Continuation<?> continuation) {
        return new VipPayViewModel$getVipInfo$1(this.this$0, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @l
    public final Object invokeSuspend(@k Object obj) {
        NonStickyLiveData nonStickyLiveData;
        String H;
        NonStickyLiveData nonStickyLiveData2;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i10 = this.label;
        try {
            if (i10 == 0) {
                ResultKt.throwOnFailure(obj);
                VipPayRepository f10 = this.this$0.f();
                H = this.this$0.H();
                this.label = 1;
                obj = f10.i(H, this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i10 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            nonStickyLiveData2 = this.this$0._mVipInfoLiveData;
            nonStickyLiveData2.postValue((VipInfo) obj);
        } catch (Exception unused) {
            nonStickyLiveData = this.this$0._mVipInfoLiveData;
            nonStickyLiveData.postValue(null);
        }
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    @l
    public final Object invoke(@k CoroutineScope coroutineScope, @l Continuation<? super Unit> continuation) {
        return ((VipPayViewModel$getVipInfo$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
