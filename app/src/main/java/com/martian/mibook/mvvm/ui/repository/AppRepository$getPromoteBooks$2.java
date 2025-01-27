package com.martian.mibook.mvvm.ui.repository;

import com.martian.mibook.lib.yuewen.response.TYInitialBook;
import java.util.List;
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

@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0003\u001a\u0012\u0012\u000e\u0012\f\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0018\u00010\u00010\u0000H\u008a@¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Luc/d;", "", "Lcom/martian/mibook/lib/yuewen/response/TYInitialBook;", "<anonymous>", "()Luc/d;"}, k = 3, mv = {1, 9, 0})
@DebugMetadata(c = "com.martian.mibook.mvvm.ui.repository.AppRepository$getPromoteBooks$2", f = "AppRepository.kt", i = {}, l = {105}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes3.dex */
public final class AppRepository$getPromoteBooks$2 extends SuspendLambda implements Function1<Continuation<? super d<List<? extends TYInitialBook>>>, Object> {
    final /* synthetic */ int $ctype;
    int label;
    final /* synthetic */ AppRepository this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AppRepository$getPromoteBooks$2(AppRepository appRepository, int i10, Continuation<? super AppRepository$getPromoteBooks$2> continuation) {
        super(1, continuation);
        this.this$0 = appRepository;
        this.$ctype = i10;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @k
    public final Continuation<Unit> create(@k Continuation<?> continuation) {
        return new AppRepository$getPromoteBooks$2(this.this$0, this.$ctype, continuation);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Object invoke(Continuation<? super d<List<? extends TYInitialBook>>> continuation) {
        return invoke2((Continuation<? super d<List<TYInitialBook>>>) continuation);
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
            int i11 = this.$ctype;
            this.label = 1;
            obj = ((a) a10).z(i11, this);
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

    @l
    /* renamed from: invoke */
    public final Object invoke2(@l Continuation<? super d<List<TYInitialBook>>> continuation) {
        return ((AppRepository$getPromoteBooks$2) create(continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
