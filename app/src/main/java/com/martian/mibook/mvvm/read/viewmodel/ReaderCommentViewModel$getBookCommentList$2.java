package com.martian.mibook.mvvm.read.viewmodel;

import androidx.lifecycle.MutableLiveData;
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
@DebugMetadata(c = "com.martian.mibook.mvvm.read.viewmodel.ReaderCommentViewModel$getBookCommentList$2", f = "ReaderCommentViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes3.dex */
public final class ReaderCommentViewModel$getBookCommentList$2 extends SuspendLambda implements Function2<ErrorResult, Continuation<? super Unit>, Object> {
    final /* synthetic */ boolean $isLoadMore;
    /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ ReaderCommentViewModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ReaderCommentViewModel$getBookCommentList$2(boolean z10, ReaderCommentViewModel readerCommentViewModel, Continuation<? super ReaderCommentViewModel$getBookCommentList$2> continuation) {
        super(2, continuation);
        this.$isLoadMore = z10;
        this.this$0 = readerCommentViewModel;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @k
    public final Continuation<Unit> create(@l Object obj, @k Continuation<?> continuation) {
        ReaderCommentViewModel$getBookCommentList$2 readerCommentViewModel$getBookCommentList$2 = new ReaderCommentViewModel$getBookCommentList$2(this.$isLoadMore, this.this$0, continuation);
        readerCommentViewModel$getBookCommentList$2.L$0 = obj;
        return readerCommentViewModel$getBookCommentList$2;
    }

    @Override // kotlin.jvm.functions.Function2
    @l
    public final Object invoke(@k ErrorResult errorResult, @l Continuation<? super Unit> continuation) {
        return ((ReaderCommentViewModel$getBookCommentList$2) create(errorResult, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @l
    public final Object invokeSuspend(@k Object obj) {
        MutableLiveData mutableLiveData;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.throwOnFailure(obj);
        ErrorResult errorResult = (ErrorResult) this.L$0;
        errorResult.setObj(Boxing.boxBoolean(this.$isLoadMore));
        mutableLiveData = this.this$0._mBookCommentsErrorLiveData;
        mutableLiveData.postValue(errorResult);
        return Unit.INSTANCE;
    }
}
