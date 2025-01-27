package com.martian.mibook.mvvm.yuewen.viewmodel;

import androidx.lifecycle.MutableLiveData;
import com.martian.mibook.application.MiConfigSingleton;
import com.martian.mibook.lib.yuewen.response.YWBookMall;
import com.martian.mibook.mvvm.net.ErrorResult;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import xi.k;
import xi.l;

@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u008a@"}, d2 = {"<anonymous>", "", "it", "Lcom/martian/mibook/mvvm/net/ErrorResult;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.martian.mibook.mvvm.yuewen.viewmodel.BookMallViewModel$getBookMallData$2", f = "BookMallViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes3.dex */
public final class BookMallViewModel$getBookMallData$2 extends SuspendLambda implements Function2<ErrorResult, Continuation<? super Unit>, Object> {
    final /* synthetic */ boolean $isLoadMore;
    /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ BookMallViewModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BookMallViewModel$getBookMallData$2(boolean z10, BookMallViewModel bookMallViewModel, Continuation<? super BookMallViewModel$getBookMallData$2> continuation) {
        super(2, continuation);
        this.$isLoadMore = z10;
        this.this$0 = bookMallViewModel;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @k
    public final Continuation<Unit> create(@l Object obj, @k Continuation<?> continuation) {
        BookMallViewModel$getBookMallData$2 bookMallViewModel$getBookMallData$2 = new BookMallViewModel$getBookMallData$2(this.$isLoadMore, this.this$0, continuation);
        bookMallViewModel$getBookMallData$2.L$0 = obj;
        return bookMallViewModel$getBookMallData$2;
    }

    @Override // kotlin.jvm.functions.Function2
    @l
    public final Object invoke(@k ErrorResult errorResult, @l Continuation<? super Unit> continuation) {
        return ((BookMallViewModel$getBookMallData$2) create(errorResult, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @l
    public final Object invokeSuspend(@k Object obj) {
        YWBookMall d22;
        MutableLiveData mutableLiveData;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.throwOnFailure(obj);
        ErrorResult errorResult = (ErrorResult) this.L$0;
        if (this.$isLoadMore || (d22 = MiConfigSingleton.b2().M1().d2(this.this$0.getTid())) == null) {
            errorResult.setObj(Boxing.boxBoolean(this.$isLoadMore));
            this.this$0.g().postValue(errorResult);
            return Unit.INSTANCE;
        }
        mutableLiveData = this.this$0._mYWBookMallLiveData;
        mutableLiveData.postValue(d22);
        return Unit.INSTANCE;
    }
}
