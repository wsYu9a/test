package com.martian.mibook.mvvm.yuewen.viewmodel;

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
@DebugMetadata(c = "com.martian.mibook.mvvm.yuewen.viewmodel.BookRankViewModel$getAllCategories$2", f = "BookRankViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes3.dex */
public final class BookRankViewModel$getAllCategories$2 extends SuspendLambda implements Function2<ErrorResult, Continuation<? super Unit>, Object> {
    /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ BookRankViewModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BookRankViewModel$getAllCategories$2(BookRankViewModel bookRankViewModel, Continuation<? super BookRankViewModel$getAllCategories$2> continuation) {
        super(2, continuation);
        this.this$0 = bookRankViewModel;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @k
    public final Continuation<Unit> create(@l Object obj, @k Continuation<?> continuation) {
        BookRankViewModel$getAllCategories$2 bookRankViewModel$getAllCategories$2 = new BookRankViewModel$getAllCategories$2(this.this$0, continuation);
        bookRankViewModel$getAllCategories$2.L$0 = obj;
        return bookRankViewModel$getAllCategories$2;
    }

    @Override // kotlin.jvm.functions.Function2
    @l
    public final Object invoke(@k ErrorResult errorResult, @l Continuation<? super Unit> continuation) {
        return ((BookRankViewModel$getAllCategories$2) create(errorResult, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @l
    public final Object invokeSuspend(@k Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.throwOnFailure(obj);
        this.this$0.g().postValue((ErrorResult) this.L$0);
        return Unit.INSTANCE;
    }
}
