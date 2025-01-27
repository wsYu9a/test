package com.martian.mibook.mvvm.book.viewmodel;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import xi.k;
import xi.l;

@Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.martian.mibook.mvvm.book.viewmodel.SearchViewModel", f = "SearchViewModel.kt", i = {0, 0}, l = {168, 176, 178}, m = "searchBooksByCategory", n = {"this", "categoryBookListParams"}, s = {"L$0", "L$1"})
/* loaded from: classes3.dex */
public final class SearchViewModel$searchBooksByCategory$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ SearchViewModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SearchViewModel$searchBooksByCategory$1(SearchViewModel searchViewModel, Continuation<? super SearchViewModel$searchBooksByCategory$1> continuation) {
        super(continuation);
        this.this$0 = searchViewModel;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @l
    public final Object invokeSuspend(@k Object obj) {
        Object S;
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        S = this.this$0.S(null, this);
        return S;
    }
}
