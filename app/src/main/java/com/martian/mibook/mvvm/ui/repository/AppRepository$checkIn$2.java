package com.martian.mibook.mvvm.ui.repository;

import com.martian.mibook.lib.account.response.CheckinResult;
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

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0000H\u008a@¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Luc/d;", "Lcom/martian/mibook/lib/account/response/CheckinResult;", "<anonymous>", "()Luc/d;"}, k = 3, mv = {1, 9, 0})
@DebugMetadata(c = "com.martian.mibook.mvvm.ui.repository.AppRepository$checkIn$2", f = "AppRepository.kt", i = {}, l = {40}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes3.dex */
public final class AppRepository$checkIn$2 extends SuspendLambda implements Function1<Continuation<? super d<CheckinResult>>, Object> {
    int label;
    final /* synthetic */ AppRepository this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AppRepository$checkIn$2(AppRepository appRepository, Continuation<? super AppRepository$checkIn$2> continuation) {
        super(1, continuation);
        this.this$0 = appRepository;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @k
    public final Continuation<Unit> create(@k Continuation<?> continuation) {
        return new AppRepository$checkIn$2(this.this$0, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @l
    public final Object invokeSuspend(@k Object obj) {
        Object a10;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i10 = this.label;
        if (i10 == 0) {
            ResultKt.throwOnFailure(obj);
            a10 = this.this$0.a(a.class);
            this.label = 1;
            obj = ((a) a10).D(this);
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
    public final Object invoke(@l Continuation<? super d<CheckinResult>> continuation) {
        return ((AppRepository$checkIn$2) create(continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
