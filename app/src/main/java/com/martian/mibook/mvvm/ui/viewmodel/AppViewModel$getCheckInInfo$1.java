package com.martian.mibook.mvvm.ui.viewmodel;

import com.martian.mibook.lib.account.response.BonusPool;
import com.martian.mibook.mvvm.tts.NonStickyLiveData;
import com.martian.mibook.mvvm.ui.repository.AppRepository;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import xi.k;
import xi.l;

@Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\u008a@"}, d2 = {"<anonymous>", ""}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.martian.mibook.mvvm.ui.viewmodel.AppViewModel$getCheckInInfo$1", f = "AppViewModel.kt", i = {}, l = {226}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes3.dex */
public final class AppViewModel$getCheckInInfo$1 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ AppViewModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AppViewModel$getCheckInInfo$1(AppViewModel appViewModel, Continuation<? super AppViewModel$getCheckInInfo$1> continuation) {
        super(1, continuation);
        this.this$0 = appViewModel;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @k
    public final Continuation<Unit> create(@k Continuation<?> continuation) {
        return new AppViewModel$getCheckInInfo$1(this.this$0, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @l
    public final Object invokeSuspend(@k Object obj) {
        NonStickyLiveData nonStickyLiveData;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i10 = this.label;
        if (i10 == 0) {
            ResultKt.throwOnFailure(obj);
            AppRepository f10 = this.this$0.f();
            this.label = 1;
            obj = f10.h(this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i10 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        }
        nonStickyLiveData = this.this$0._mBonusPoolLiveData;
        nonStickyLiveData.postValue((BonusPool) obj);
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function1
    @l
    public final Object invoke(@l Continuation<? super Unit> continuation) {
        return ((AppViewModel$getCheckInInfo$1) create(continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
