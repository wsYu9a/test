package com.martian.mibook.mvvm.yuewen.viewmodel;

import androidx.lifecycle.MutableLiveData;
import com.martian.mibook.lib.account.response.WithdrawRankList;
import com.martian.mibook.mvvm.extensions.ExtKt;
import com.martian.mibook.mvvm.net.request.GetWithdrawOrdersRankParams;
import com.martian.mibook.mvvm.yuewen.repository.MissionCenterRepository;
import java.util.Map;
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

@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u008a@"}, d2 = {"<anonymous>", "", "it", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.martian.mibook.mvvm.yuewen.viewmodel.MissionCenterViewModel$getWithdrawOrdersRank$1", f = "MissionCenterViewModel.kt", i = {}, l = {190}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes3.dex */
public final class MissionCenterViewModel$getWithdrawOrdersRank$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ MissionCenterViewModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MissionCenterViewModel$getWithdrawOrdersRank$1(MissionCenterViewModel missionCenterViewModel, Continuation<? super MissionCenterViewModel$getWithdrawOrdersRank$1> continuation) {
        super(2, continuation);
        this.this$0 = missionCenterViewModel;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @k
    public final Continuation<Unit> create(@l Object obj, @k Continuation<?> continuation) {
        return new MissionCenterViewModel$getWithdrawOrdersRank$1(this.this$0, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @l
    public final Object invokeSuspend(@k Object obj) {
        MutableLiveData mutableLiveData;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i10 = this.label;
        if (i10 == 0) {
            ResultKt.throwOnFailure(obj);
            GetWithdrawOrdersRankParams getWithdrawOrdersRankParams = new GetWithdrawOrdersRankParams(0, 0, false, 0, 15, null);
            getWithdrawOrdersRankParams.setPage(0);
            getWithdrawOrdersRankParams.setPageSize(3);
            getWithdrawOrdersRankParams.setWithHeader(true);
            Map<String, String> f10 = ExtKt.f(getWithdrawOrdersRankParams);
            MissionCenterRepository f11 = this.this$0.f();
            this.label = 1;
            obj = f11.g(f10, this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i10 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        }
        mutableLiveData = this.this$0._mWithdrawRankListLiveData;
        mutableLiveData.postValue((WithdrawRankList) obj);
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    @l
    public final Object invoke(@k CoroutineScope coroutineScope, @l Continuation<? super Unit> continuation) {
        return ((MissionCenterViewModel$getWithdrawOrdersRank$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
