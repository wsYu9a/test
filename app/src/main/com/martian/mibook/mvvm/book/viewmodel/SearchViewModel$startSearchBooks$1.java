package com.martian.mibook.mvvm.book.viewmodel;

import androidx.lifecycle.MutableLiveData;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import com.martian.mibook.lib.yuewen.response.YWCategoryBookList;
import com.martian.mibook.mvvm.net.request.SearchBooksParams;
import com.martian.mibook.mvvm.net.request.YWCategoryBookListParams;
import com.martian.mibook.mvvm.net.result.SearchBooksResult;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Deferred;
import xi.k;
import xi.l;

@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u008a@"}, d2 = {"<anonymous>", "", "it", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.martian.mibook.mvvm.book.viewmodel.SearchViewModel$startSearchBooks$1", f = "SearchViewModel.kt", i = {0, 1}, l = {TTDownloadField.CALL_DOWNLOAD_MODEL_SET_VERSION_CODE, 150}, m = "invokeSuspend", n = {"categoryBooksResultDeferred", "searchBooksResult"}, s = {"L$0", "L$0"})
/* loaded from: classes3.dex */
public final class SearchViewModel$startSearchBooks$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ YWCategoryBookListParams $categoryBookListParams;
    final /* synthetic */ boolean $isLoadMore;
    final /* synthetic */ SearchBooksParams $searchBooksParams;
    /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ SearchViewModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SearchViewModel$startSearchBooks$1(SearchViewModel searchViewModel, SearchBooksParams searchBooksParams, boolean z10, YWCategoryBookListParams yWCategoryBookListParams, Continuation<? super SearchViewModel$startSearchBooks$1> continuation) {
        super(2, continuation);
        this.this$0 = searchViewModel;
        this.$searchBooksParams = searchBooksParams;
        this.$isLoadMore = z10;
        this.$categoryBookListParams = yWCategoryBookListParams;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @k
    public final Continuation<Unit> create(@l Object obj, @k Continuation<?> continuation) {
        SearchViewModel$startSearchBooks$1 searchViewModel$startSearchBooks$1 = new SearchViewModel$startSearchBooks$1(this.this$0, this.$searchBooksParams, this.$isLoadMore, this.$categoryBookListParams, continuation);
        searchViewModel$startSearchBooks$1.L$0 = obj;
        return searchViewModel$startSearchBooks$1;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @l
    public final Object invokeSuspend(@k Object obj) {
        Deferred async$default;
        Deferred async$default2;
        Deferred deferred;
        SearchBooksResult searchBooksResult;
        MutableLiveData mutableLiveData;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i10 = this.label;
        if (i10 == 0) {
            ResultKt.throwOnFailure(obj);
            CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
            this.this$0.e0(null);
            this.this$0.f0(null);
            this.this$0.d0(null);
            async$default = BuildersKt__Builders_commonKt.async$default(coroutineScope, null, null, new SearchViewModel$startSearchBooks$1$searchBooksResultDeferred$1(this.this$0, this.$searchBooksParams, null), 3, null);
            async$default2 = BuildersKt__Builders_commonKt.async$default(coroutineScope, null, null, new SearchViewModel$startSearchBooks$1$categoryBooksResultDeferred$1(this.$isLoadMore, this.$categoryBookListParams, this.this$0, null), 3, null);
            this.L$0 = async$default2;
            this.label = 1;
            Object await = async$default.await(this);
            if (await == coroutine_suspended) {
                return coroutine_suspended;
            }
            deferred = async$default2;
            obj = await;
        } else {
            if (i10 != 1) {
                if (i10 != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                searchBooksResult = (SearchBooksResult) this.L$0;
                ResultKt.throwOnFailure(obj);
                mutableLiveData = this.this$0._mSearchBooksResultLiveData;
                mutableLiveData.postValue(new Pair((YWCategoryBookList) obj, searchBooksResult));
                return Unit.INSTANCE;
            }
            deferred = (Deferred) this.L$0;
            ResultKt.throwOnFailure(obj);
        }
        SearchBooksResult searchBooksResult2 = (SearchBooksResult) obj;
        this.L$0 = searchBooksResult2;
        this.label = 2;
        Object await2 = deferred.await(this);
        if (await2 == coroutine_suspended) {
            return coroutine_suspended;
        }
        searchBooksResult = searchBooksResult2;
        obj = await2;
        mutableLiveData = this.this$0._mSearchBooksResultLiveData;
        mutableLiveData.postValue(new Pair((YWCategoryBookList) obj, searchBooksResult));
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    @l
    public final Object invoke(@k CoroutineScope coroutineScope, @l Continuation<? super Unit> continuation) {
        return ((SearchViewModel$startSearchBooks$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
