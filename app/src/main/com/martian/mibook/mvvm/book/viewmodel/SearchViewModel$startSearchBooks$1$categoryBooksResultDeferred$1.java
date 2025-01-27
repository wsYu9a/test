package com.martian.mibook.mvvm.book.viewmodel;

import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import com.martian.mibook.lib.yuewen.response.YWCategoryBookList;
import com.martian.mibook.mvvm.net.request.YWCategoryBookListParams;
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

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "Lcom/martian/mibook/lib/yuewen/response/YWCategoryBookList;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.martian.mibook.mvvm.book.viewmodel.SearchViewModel$startSearchBooks$1$categoryBooksResultDeferred$1", f = "SearchViewModel.kt", i = {}, l = {TTDownloadField.CALL_DOWNLOAD_MODEL_SET_HEADERS}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes3.dex */
public final class SearchViewModel$startSearchBooks$1$categoryBooksResultDeferred$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super YWCategoryBookList>, Object> {
    final /* synthetic */ YWCategoryBookListParams $categoryBookListParams;
    final /* synthetic */ boolean $isLoadMore;
    int label;
    final /* synthetic */ SearchViewModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SearchViewModel$startSearchBooks$1$categoryBooksResultDeferred$1(boolean z10, YWCategoryBookListParams yWCategoryBookListParams, SearchViewModel searchViewModel, Continuation<? super SearchViewModel$startSearchBooks$1$categoryBooksResultDeferred$1> continuation) {
        super(2, continuation);
        this.$isLoadMore = z10;
        this.$categoryBookListParams = yWCategoryBookListParams;
        this.this$0 = searchViewModel;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @k
    public final Continuation<Unit> create(@l Object obj, @k Continuation<?> continuation) {
        return new SearchViewModel$startSearchBooks$1$categoryBooksResultDeferred$1(this.$isLoadMore, this.$categoryBookListParams, this.this$0, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @l
    public final Object invokeSuspend(@k Object obj) {
        YWCategoryBookListParams yWCategoryBookListParams;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i10 = this.label;
        try {
            if (i10 == 0) {
                ResultKt.throwOnFailure(obj);
                if (this.$isLoadMore || (yWCategoryBookListParams = this.$categoryBookListParams) == null) {
                    return null;
                }
                SearchViewModel searchViewModel = this.this$0;
                this.label = 1;
                obj = searchViewModel.S(yWCategoryBookListParams, this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i10 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            return (YWCategoryBookList) obj;
        } catch (Exception unused) {
            return null;
        }
    }

    @Override // kotlin.jvm.functions.Function2
    @l
    public final Object invoke(@k CoroutineScope coroutineScope, @l Continuation<? super YWCategoryBookList> continuation) {
        return ((SearchViewModel$startSearchBooks$1$categoryBooksResultDeferred$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
