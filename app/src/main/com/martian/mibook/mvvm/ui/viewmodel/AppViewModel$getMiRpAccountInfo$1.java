package com.martian.mibook.mvvm.ui.viewmodel;

import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import com.martian.mibook.data.VipStatusRetryInfo;
import com.martian.mibook.mvvm.tts.NonStickyLiveData;
import com.martian.mibook.mvvm.ui.repository.AppRepository;
import com.martian.rpauth.MartianIUserManager;
import com.martian.rpauth.response.MartianRPAccount;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlinx.coroutines.DelayKt;
import xi.k;
import xi.l;

@Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\u008a@"}, d2 = {"<anonymous>", ""}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.martian.mibook.mvvm.ui.viewmodel.AppViewModel$getMiRpAccountInfo$1", f = "AppViewModel.kt", i = {0}, l = {TTDownloadField.CALL_DOWNLOAD_MODEL_SET_CLICK_TRACK_URL, 153}, m = "invokeSuspend", n = {"martianIUserManager"}, s = {"L$0"})
/* loaded from: classes3.dex */
public final class AppViewModel$getMiRpAccountInfo$1 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
    final /* synthetic */ boolean $retry;
    Object L$0;
    int label;
    final /* synthetic */ AppViewModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AppViewModel$getMiRpAccountInfo$1(AppViewModel appViewModel, boolean z10, Continuation<? super AppViewModel$getMiRpAccountInfo$1> continuation) {
        super(1, continuation);
        this.this$0 = appViewModel;
        this.$retry = z10;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @k
    public final Continuation<Unit> create(@k Continuation<?> continuation) {
        return new AppViewModel$getMiRpAccountInfo$1(this.this$0, this.$retry, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @l
    public final Object invokeSuspend(@k Object obj) {
        MartianIUserManager b10;
        NonStickyLiveData nonStickyLiveData;
        VipStatusRetryInfo vipStatusRetryInfo;
        NonStickyLiveData nonStickyLiveData2;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i10 = this.label;
        if (i10 == 0) {
            ResultKt.throwOnFailure(obj);
            b10 = MartianIUserManager.b();
            if (b10 == null || !b10.f()) {
                return Unit.INSTANCE;
            }
            this.this$0.miRpAccountLoading = true;
            AppRepository f10 = this.this$0.f();
            this.L$0 = b10;
            this.label = 1;
            obj = f10.j(this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i10 != 1) {
                if (i10 != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                this.this$0.l0(false);
                this.this$0.miRpAccountLoading = false;
                return Unit.INSTANCE;
            }
            b10 = (MartianIUserManager) this.L$0;
            ResultKt.throwOnFailure(obj);
        }
        MartianRPAccount martianRPAccount = (MartianRPAccount) obj;
        if (martianRPAccount != null) {
            vipStatusRetryInfo = this.this$0.vipStatusRetryInfo;
            if (vipStatusRetryInfo != null && vipStatusRetryInfo.getVipStatusRetry()) {
                if (martianRPAccount.getIsVip() > 0) {
                    AppViewModel.G0(this.this$0, false, 1, null);
                } else {
                    this.this$0.E0();
                }
            }
            b10.j(martianRPAccount);
            nonStickyLiveData2 = this.this$0._mMiRpAccountLiveData;
            nonStickyLiveData2.postValue(martianRPAccount);
        } else if (this.$retry) {
            this.L$0 = null;
            this.label = 2;
            if (DelayKt.delay(5000L, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
            this.this$0.l0(false);
        } else {
            nonStickyLiveData = this.this$0._mMiRpAccountLiveData;
            nonStickyLiveData.postValue(null);
        }
        this.this$0.miRpAccountLoading = false;
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function1
    @l
    public final Object invoke(@l Continuation<? super Unit> continuation) {
        return ((AppViewModel$getMiRpAccountInfo$1) create(continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
