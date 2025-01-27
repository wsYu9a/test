package com.martian.mibook.mvvm.yuewen.viewmodel;

import androidx.lifecycle.MutableLiveData;
import com.martian.mibook.lib.yuewen.response.YWChannelBookList;
import com.martian.mibook.mvvm.extensions.ExtKt;
import com.martian.mibook.mvvm.net.request.YWBookChannelBooksParams;
import com.martian.mibook.mvvm.yuewen.repository.YWChannelBookListRepository;
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
@DebugMetadata(c = "com.martian.mibook.mvvm.yuewen.viewmodel.YWChannelBookListViewModel$getYWChannelBookList$1", f = "YWChannelBookListViewModel.kt", i = {}, l = {34}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes3.dex */
public final class YWChannelBookListViewModel$getYWChannelBookList$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ YWBookChannelBooksParams $params;
    Object L$0;
    int label;
    final /* synthetic */ YWChannelBookListViewModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public YWChannelBookListViewModel$getYWChannelBookList$1(YWBookChannelBooksParams yWBookChannelBooksParams, YWChannelBookListViewModel yWChannelBookListViewModel, Continuation<? super YWChannelBookListViewModel$getYWChannelBookList$1> continuation) {
        super(2, continuation);
        this.$params = yWBookChannelBooksParams;
        this.this$0 = yWChannelBookListViewModel;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @k
    public final Continuation<Unit> create(@l Object obj, @k Continuation<?> continuation) {
        return new YWChannelBookListViewModel$getYWChannelBookList$1(this.$params, this.this$0, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @l
    public final Object invokeSuspend(@k Object obj) {
        YWChannelBookListViewModel yWChannelBookListViewModel;
        MutableLiveData mutableLiveData;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i10 = this.label;
        if (i10 == 0) {
            ResultKt.throwOnFailure(obj);
            Map<String, String> f10 = ExtKt.f(this.$params);
            YWChannelBookListViewModel yWChannelBookListViewModel2 = this.this$0;
            YWChannelBookListRepository f11 = yWChannelBookListViewModel2.f();
            this.L$0 = yWChannelBookListViewModel2;
            this.label = 1;
            obj = f11.f(f10, this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
            yWChannelBookListViewModel = yWChannelBookListViewModel2;
        } else {
            if (i10 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            yWChannelBookListViewModel = (YWChannelBookListViewModel) this.L$0;
            ResultKt.throwOnFailure(obj);
        }
        YWChannelBookList yWChannelBookList = (YWChannelBookList) obj;
        mutableLiveData = yWChannelBookListViewModel._mChannelBooksLiveData;
        mutableLiveData.postValue(yWChannelBookList != null ? yWChannelBookList.getBookList() : null);
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    @l
    public final Object invoke(@k CoroutineScope coroutineScope, @l Continuation<? super Unit> continuation) {
        return ((YWChannelBookListViewModel$getYWChannelBookList$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
