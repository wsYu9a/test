package com.martian.mibook.mvvm.book.viewmodel;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import xi.k;
import xi.l;

@Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.martian.mibook.mvvm.book.viewmodel.SearchViewModel", f = "SearchViewModel.kt", i = {0, 0, 0}, l = {282}, m = "asyncSearchBooksByCategory", n = {"this", "categoryBookListParams", "ywCategory"}, s = {"L$0", "L$1", "L$2"})
/* loaded from: classes3.dex */
public final class SearchViewModel$asyncSearchBooksByCategory$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ SearchViewModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SearchViewModel$asyncSearchBooksByCategory$1(SearchViewModel searchViewModel, Continuation<? super SearchViewModel$asyncSearchBooksByCategory$1> continuation) {
        super(continuation);
        this.this$0 = searchViewModel;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @l
    public final Object invokeSuspend(@k Object obj) {
        Object w10;
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        w10 = this.this$0.w(null, null, this);
        return w10;
    }
}
