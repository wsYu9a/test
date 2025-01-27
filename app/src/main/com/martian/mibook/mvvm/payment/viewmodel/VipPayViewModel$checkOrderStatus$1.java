package com.martian.mibook.mvvm.payment.viewmodel;

import com.martian.mibook.lib.account.response.MiRechargeOrder;
import com.martian.mibook.mvvm.payment.repository.VipPayRepository;
import com.martian.mibook.mvvm.tts.NonStickyLiveData;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import xi.k;
import xi.l;

@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u008a@"}, d2 = {"<anonymous>", "", "it", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.martian.mibook.mvvm.payment.viewmodel.VipPayViewModel$checkOrderStatus$1", f = "VipPayViewModel.kt", i = {}, l = {391}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes3.dex */
public final class VipPayViewModel$checkOrderStatus$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ boolean $withCallback;
    int label;
    final /* synthetic */ VipPayViewModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public VipPayViewModel$checkOrderStatus$1(VipPayViewModel vipPayViewModel, boolean z10, Continuation<? super VipPayViewModel$checkOrderStatus$1> continuation) {
        super(2, continuation);
        this.this$0 = vipPayViewModel;
        this.$withCallback = z10;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @k
    public final Continuation<Unit> create(@l Object obj, @k Continuation<?> continuation) {
        return new VipPayViewModel$checkOrderStatus$1(this.this$0, this.$withCallback, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @l
    public final Object invokeSuspend(@k Object obj) {
        Integer num;
        NonStickyLiveData nonStickyLiveData;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i10 = this.label;
        if (i10 == 0) {
            ResultKt.throwOnFailure(obj);
            VipPayRepository f10 = this.this$0.f();
            num = this.this$0.roid;
            this.label = 1;
            obj = f10.h(num, this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i10 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        }
        MiRechargeOrder miRechargeOrder = (MiRechargeOrder) obj;
        if (miRechargeOrder != null) {
            VipPayViewModel vipPayViewModel = this.this$0;
            Integer num2 = miRechargeOrder.status;
            if (num2 != null && num2.intValue() == 2) {
                vipPayViewModel.m0(2);
            }
        }
        if (this.$withCallback || this.this$0.getPaymentStatus() == 2) {
            nonStickyLiveData = this.this$0._mPayOrderFinishedLiveData;
            nonStickyLiveData.postValue(Boxing.boxBoolean(this.this$0.getPaymentStatus() == 2));
        }
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    @l
    public final Object invoke(@k CoroutineScope coroutineScope, @l Continuation<? super Unit> continuation) {
        return ((VipPayViewModel$checkOrderStatus$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
