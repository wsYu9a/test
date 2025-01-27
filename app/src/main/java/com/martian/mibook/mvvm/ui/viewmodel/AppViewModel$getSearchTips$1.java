package com.martian.mibook.mvvm.ui.viewmodel;

import androidx.lifecycle.MutableLiveData;
import com.martian.mibook.application.MiConfigSingleton;
import com.martian.mibook.mvvm.ui.repository.AppRepository;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import xi.k;
import xi.l;

@Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\u008a@"}, d2 = {"<anonymous>", ""}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.martian.mibook.mvvm.ui.viewmodel.AppViewModel$getSearchTips$1", f = "AppViewModel.kt", i = {}, l = {404}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes3.dex */
public final class AppViewModel$getSearchTips$1 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ AppViewModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AppViewModel$getSearchTips$1(AppViewModel appViewModel, Continuation<? super AppViewModel$getSearchTips$1> continuation) {
        super(1, continuation);
        this.this$0 = appViewModel;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @k
    public final Continuation<Unit> create(@k Continuation<?> continuation) {
        return new AppViewModel$getSearchTips$1(this.this$0, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @l
    public final Object invokeSuspend(@k Object obj) {
        MutableLiveData mutableLiveData;
        List list;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i10 = this.label;
        if (i10 == 0) {
            ResultKt.throwOnFailure(obj);
            AppRepository f10 = this.this$0.f();
            int p10 = MiConfigSingleton.b2().p();
            this.label = 1;
            obj = f10.m(p10, 0, 50, this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i10 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        }
        List list2 = (List) obj;
        this.this$0.searchTips = list2 != null ? CollectionsKt.shuffled(list2) : null;
        this.this$0.searchTipsIndex = -1;
        mutableLiveData = this.this$0._mSearchTipsLiveData;
        list = this.this$0.searchTips;
        mutableLiveData.postValue(list);
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function1
    @l
    public final Object invoke(@l Continuation<? super Unit> continuation) {
        return ((AppViewModel$getSearchTips$1) create(continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
