package com.martian.mibook.mvvm.book.viewmodel;

import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import com.martian.mibook.mvvm.net.request.SearchBooksParams;
import com.martian.mibook.mvvm.net.result.SearchBooksResult;
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

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "Lcom/martian/mibook/mvvm/net/result/SearchBooksResult;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.martian.mibook.mvvm.book.viewmodel.SearchViewModel$startSearchBooks$1$searchBooksResultDeferred$1", f = "SearchViewModel.kt", i = {}, l = {TTDownloadField.CALL_DOWNLOAD_MODEL_SET_CLICK_TRACK_URL}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes3.dex */
public final class SearchViewModel$startSearchBooks$1$searchBooksResultDeferred$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super SearchBooksResult>, Object> {
    final /* synthetic */ SearchBooksParams $searchBooksParams;
    int label;
    final /* synthetic */ SearchViewModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SearchViewModel$startSearchBooks$1$searchBooksResultDeferred$1(SearchViewModel searchViewModel, SearchBooksParams searchBooksParams, Continuation<? super SearchViewModel$startSearchBooks$1$searchBooksResultDeferred$1> continuation) {
        super(2, continuation);
        this.this$0 = searchViewModel;
        this.$searchBooksParams = searchBooksParams;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @k
    public final Continuation<Unit> create(@l Object obj, @k Continuation<?> continuation) {
        return new SearchViewModel$startSearchBooks$1$searchBooksResultDeferred$1(this.this$0, this.$searchBooksParams, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @l
    public final Object invokeSuspend(@k Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i10 = this.label;
        if (i10 == 0) {
            ResultKt.throwOnFailure(obj);
            SearchViewModel searchViewModel = this.this$0;
            SearchBooksParams searchBooksParams = this.$searchBooksParams;
            this.label = 1;
            obj = searchViewModel.u(searchBooksParams, this);
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

    @Override // kotlin.jvm.functions.Function2
    @l
    public final Object invoke(@k CoroutineScope coroutineScope, @l Continuation<? super SearchBooksResult> continuation) {
        return ((SearchViewModel$startSearchBooks$1$searchBooksResultDeferred$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
