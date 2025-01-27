package com.martian.mibook.mvvm.yuewen.viewmodel;

import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import com.martian.mibook.lib.account.response.ExchangeMoney;
import com.martian.mibook.mvvm.tts.NonStickyLiveData;
import com.martian.mibook.mvvm.yuewen.repository.MissionCenterRepository;
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
@DebugMetadata(c = "com.martian.mibook.mvvm.yuewen.viewmodel.MissionCenterViewModel$startExchange$1", f = "MissionCenterViewModel.kt", i = {}, l = {TTDownloadField.CALL_DOWNLOAD_MODEL_GET_MIME_TYPE}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes3.dex */
public final class MissionCenterViewModel$startExchange$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ MissionCenterViewModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MissionCenterViewModel$startExchange$1(MissionCenterViewModel missionCenterViewModel, Continuation<? super MissionCenterViewModel$startExchange$1> continuation) {
        super(2, continuation);
        this.this$0 = missionCenterViewModel;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @k
    public final Continuation<Unit> create(@l Object obj, @k Continuation<?> continuation) {
        return new MissionCenterViewModel$startExchange$1(this.this$0, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @l
    public final Object invokeSuspend(@k Object obj) {
        NonStickyLiveData nonStickyLiveData;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i10 = this.label;
        if (i10 == 0) {
            ResultKt.throwOnFailure(obj);
            int s10 = this.this$0.s();
            int t10 = this.this$0.t(s10);
            MissionCenterRepository f10 = this.this$0.f();
            Integer boxInt = Boxing.boxInt(s10);
            Integer boxInt2 = Boxing.boxInt(t10);
            this.label = 1;
            obj = f10.f(boxInt, boxInt2, this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i10 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        }
        nonStickyLiveData = this.this$0._mExchangeMoneyLiveData;
        nonStickyLiveData.postValue((ExchangeMoney) obj);
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    @l
    public final Object invoke(@k CoroutineScope coroutineScope, @l Continuation<? super Unit> continuation) {
        return ((MissionCenterViewModel$startExchange$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
