package com.martian.mibook.mvvm.book.viewmodel;

import androidx.lifecycle.MutableLiveData;
import com.martian.mibook.lib.model.data.TYSearchBookList;
import com.martian.mibook.mvvm.book.repository.BookRepository;
import com.martian.mibook.mvvm.extensions.ExtKt;
import com.martian.mibook.mvvm.net.request.RecommendBooksParams;
import java.util.Map;
import java.util.Random;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import xi.k;
import xi.l;

@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u008a@"}, d2 = {"<anonymous>", "", "it", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.martian.mibook.mvvm.book.viewmodel.BookViewModel$getRecommendBookList$1", f = "BookViewModel.kt", i = {}, l = {131}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes3.dex */
public final class BookViewModel$getRecommendBookList$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ int $pageIndex;
    final /* synthetic */ int $pageSize;
    int label;
    final /* synthetic */ BookViewModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BookViewModel$getRecommendBookList$1(int i10, int i11, BookViewModel bookViewModel, Continuation<? super BookViewModel$getRecommendBookList$1> continuation) {
        super(2, continuation);
        this.$pageIndex = i10;
        this.$pageSize = i11;
        this.this$0 = bookViewModel;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @k
    public final Continuation<Unit> create(@l Object obj, @k Continuation<?> continuation) {
        return new BookViewModel$getRecommendBookList$1(this.$pageIndex, this.$pageSize, this.this$0, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @l
    public final Object invokeSuspend(@k Object obj) {
        MutableLiveData mutableLiveData;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i10 = this.label;
        if (i10 == 0) {
            ResultKt.throwOnFailure(obj);
            RecommendBooksParams recommendBooksParams = new RecommendBooksParams(null, null, null, null, null, null, null, 127, null);
            recommendBooksParams.setPage(Boxing.boxInt(this.$pageIndex));
            recommendBooksParams.setPageSize(Boxing.boxInt(this.$pageSize));
            recommendBooksParams.setSearchType(Boxing.boxInt(3));
            BookInfo bookInfo = this.this$0.getBookInfo();
            recommendBooksParams.setSourceName(bookInfo != null ? bookInfo.getSourceName() : null);
            BookInfo bookInfo2 = this.this$0.getBookInfo();
            recommendBooksParams.setSourceId(bookInfo2 != null ? bookInfo2.getSourceId() : null);
            BookInfo bookInfo3 = this.this$0.getBookInfo();
            recommendBooksParams.setKeywords(bookInfo3 != null ? bookInfo3.getBookName() : null);
            if (this.this$0.getSeed() == 0) {
                this.this$0.Q(new Random().nextInt(10000));
            }
            recommendBooksParams.setSeed(Boxing.boxInt(this.this$0.getSeed()));
            Map<String, String> f10 = ExtKt.f(recommendBooksParams);
            BookRepository f11 = this.this$0.f();
            this.label = 1;
            obj = f11.g(f10, this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i10 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        }
        TYSearchBookList tYSearchBookList = (TYSearchBookList) obj;
        mutableLiveData = this.this$0._mRecommendBookListLiveData;
        mutableLiveData.postValue(tYSearchBookList != null ? tYSearchBookList.getBookItemList() : null);
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    @l
    public final Object invoke(@k CoroutineScope coroutineScope, @l Continuation<? super Unit> continuation) {
        return ((BookViewModel$getRecommendBookList$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
