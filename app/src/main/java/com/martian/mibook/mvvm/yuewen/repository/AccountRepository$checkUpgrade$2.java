package com.martian.mibook.mvvm.yuewen.repository;

import com.martian.libugrowth.data.UpgradeInfo;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import uc.d;
import vc.a;
import xi.k;
import xi.l;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0000H\u008a@¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Luc/d;", "Lcom/martian/libugrowth/data/UpgradeInfo;", "<anonymous>", "()Luc/d;"}, k = 3, mv = {1, 9, 0})
@DebugMetadata(c = "com.martian.mibook.mvvm.yuewen.repository.AccountRepository$checkUpgrade$2", f = "AccountRepository.kt", i = {}, l = {14}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes3.dex */
public final class AccountRepository$checkUpgrade$2 extends SuspendLambda implements Function1<Continuation<? super d<UpgradeInfo>>, Object> {
    final /* synthetic */ boolean $force;
    int label;
    final /* synthetic */ AccountRepository this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AccountRepository$checkUpgrade$2(AccountRepository accountRepository, boolean z10, Continuation<? super AccountRepository$checkUpgrade$2> continuation) {
        super(1, continuation);
        this.this$0 = accountRepository;
        this.$force = z10;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @k
    public final Continuation<Unit> create(@k Continuation<?> continuation) {
        return new AccountRepository$checkUpgrade$2(this.this$0, this.$force, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @l
    public final Object invokeSuspend(@k Object obj) {
        Object b10;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i10 = this.label;
        if (i10 == 0) {
            ResultKt.throwOnFailure(obj);
            b10 = this.this$0.b(a.class);
            boolean z10 = this.$force;
            this.label = 1;
            obj = ((a) b10).A(z10, this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i10 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        }
        return obj;
    }

    @Override // kotlin.jvm.functions.Function1
    @l
    public final Object invoke(@l Continuation<? super d<UpgradeInfo>> continuation) {
        return ((AccountRepository$checkUpgrade$2) create(continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
