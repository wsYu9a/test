package com.martian.mibook.mvvm.yuewen.viewmodel;

import com.martian.libugrowth.data.UpgradeInfo;
import com.martian.mibook.mvvm.yuewen.repository.AccountRepository;
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
@DebugMetadata(c = "com.martian.mibook.mvvm.yuewen.viewmodel.AccountViewModel$checkUpgrade$1", f = "AccountViewModel.kt", i = {}, l = {57}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes3.dex */
public final class AccountViewModel$checkUpgrade$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ boolean $manual;
    int label;
    final /* synthetic */ AccountViewModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AccountViewModel$checkUpgrade$1(AccountViewModel accountViewModel, boolean z10, Continuation<? super AccountViewModel$checkUpgrade$1> continuation) {
        super(2, continuation);
        this.this$0 = accountViewModel;
        this.$manual = z10;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @k
    public final Continuation<Unit> create(@l Object obj, @k Continuation<?> continuation) {
        return new AccountViewModel$checkUpgrade$1(this.this$0, this.$manual, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @l
    public final Object invokeSuspend(@k Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i10 = this.label;
        if (i10 == 0) {
            ResultKt.throwOnFailure(obj);
            AccountRepository f10 = this.this$0.f();
            boolean z10 = this.$manual;
            this.label = 1;
            obj = f10.g(z10, this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i10 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        }
        UpgradeInfo upgradeInfo = (UpgradeInfo) obj;
        if (upgradeInfo != null) {
            boolean z11 = this.$manual;
            AccountViewModel accountViewModel = this.this$0;
            upgradeInfo.setManual(z11);
            accountViewModel.u().postValue(upgradeInfo);
        }
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    @l
    public final Object invoke(@k CoroutineScope coroutineScope, @l Continuation<? super Unit> continuation) {
        return ((AccountViewModel$checkUpgrade$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
