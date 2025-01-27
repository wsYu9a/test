package com.martian.mibook.mvvm.book.viewmodel;

import androidx.lifecycle.MutableLiveData;
import com.martian.mibook.mvvm.net.ErrorResult;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import xi.k;
import xi.l;

@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u008a@"}, d2 = {"<anonymous>", "", "it", "Lcom/martian/mibook/mvvm/net/ErrorResult;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.martian.mibook.mvvm.book.viewmodel.BookViewModel$getChapterContent$2", f = "BookViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes3.dex */
public final class BookViewModel$getChapterContent$2 extends SuspendLambda implements Function2<ErrorResult, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ BookViewModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BookViewModel$getChapterContent$2(BookViewModel bookViewModel, Continuation<? super BookViewModel$getChapterContent$2> continuation) {
        super(2, continuation);
        this.this$0 = bookViewModel;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @k
    public final Continuation<Unit> create(@l Object obj, @k Continuation<?> continuation) {
        return new BookViewModel$getChapterContent$2(this.this$0, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    @l
    public final Object invoke(@k ErrorResult errorResult, @l Continuation<? super Unit> continuation) {
        return ((BookViewModel$getChapterContent$2) create(errorResult, continuation)).invokeSuspend(Unit.INSTANCE);
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
        mutableLiveData = this.this$0._mChapterContentLiveData;
        mutableLiveData.postValue(null);
        return Unit.INSTANCE;
    }
}
