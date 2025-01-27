package com.martian.mibook.mvvm.payment.viewmodel;

import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
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
@DebugMetadata(c = "com.martian.mibook.mvvm.payment.viewmodel.VipPayViewModel$createPrepayOrder$1", f = "VipPayViewModel.kt", i = {}, l = {TTDownloadField.CALL_DOWNLOAD_MODEL_SET_IS_SHOW_NOTIFICATION, TTDownloadField.CALL_DOWNLOAD_MODEL_SET_VERSION_CODE}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes3.dex */
public final class VipPayViewModel$createPrepayOrder$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ VipPayViewModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public VipPayViewModel$createPrepayOrder$1(VipPayViewModel vipPayViewModel, Continuation<? super VipPayViewModel$createPrepayOrder$1> continuation) {
        super(2, continuation);
        this.this$0 = vipPayViewModel;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @k
    public final Continuation<Unit> create(@l Object obj, @k Continuation<?> continuation) {
        return new VipPayViewModel$createPrepayOrder$1(this.this$0, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @l
    public final Object invokeSuspend(@k Object obj) {
        int i10;
        Object z10;
        Object B;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i11 = this.label;
        if (i11 == 0) {
            ResultKt.throwOnFailure(obj);
            int paymentMethod = this.this$0.getPaymentMethod();
            i10 = this.this$0.payMethodWeixin;
            if (paymentMethod == i10) {
                VipPayViewModel vipPayViewModel = this.this$0;
                this.label = 1;
                B = vipPayViewModel.B(this);
                if (B == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else if (paymentMethod == this.this$0.getPayMethodAlipay()) {
                VipPayViewModel vipPayViewModel2 = this.this$0;
                this.label = 2;
                z10 = vipPayViewModel2.z(this);
                if (z10 == coroutine_suspended) {
                    return coroutine_suspended;
                }
            }
        } else {
            if (i11 != 1 && i11 != 2) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        }
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    @l
    public final Object invoke(@k CoroutineScope coroutineScope, @l Continuation<? super Unit> continuation) {
        return ((VipPayViewModel$createPrepayOrder$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
