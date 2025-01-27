package com.martian.mibook.mvvm.book.viewmodel;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import xi.k;
import xi.l;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.martian.mibook.mvvm.book.viewmodel.SearchViewModel$getSearchRecommendBooksByKeyword$1", f = "SearchViewModel.kt", i = {0, 1}, l = {80, 81}, m = "invokeSuspend", n = {"$this$launch", "$this$launch"}, s = {"L$0", "L$0"})
/* loaded from: classes3.dex */
public final class SearchViewModel$getSearchRecommendBooksByKeyword$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $keyword;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ SearchViewModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SearchViewModel$getSearchRecommendBooksByKeyword$1(SearchViewModel searchViewModel, String str, Continuation<? super SearchViewModel$getSearchRecommendBooksByKeyword$1> continuation) {
        super(2, continuation);
        this.this$0 = searchViewModel;
        this.$keyword = str;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @k
    public final Continuation<Unit> create(@l Object obj, @k Continuation<?> continuation) {
        SearchViewModel$getSearchRecommendBooksByKeyword$1 searchViewModel$getSearchRecommendBooksByKeyword$1 = new SearchViewModel$getSearchRecommendBooksByKeyword$1(this.this$0, this.$keyword, continuation);
        searchViewModel$getSearchRecommendBooksByKeyword$1.L$0 = obj;
        return searchViewModel$getSearchRecommendBooksByKeyword$1;
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0054 A[Catch: CancellationException -> 0x0064, TRY_LEAVE, TryCatch #0 {CancellationException -> 0x0064, blocks: (B:7:0x0012, B:8:0x004c, B:10:0x0054, B:18:0x0022, B:20:0x003b, B:25:0x002e), top: B:2:0x0008 }] */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @xi.l
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object invokeSuspend(@xi.k java.lang.Object r6) {
        /*
            r5 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r5.label
            r2 = 2
            r3 = 1
            if (r1 == 0) goto L27
            if (r1 == r3) goto L1e
            if (r1 != r2) goto L16
            java.lang.Object r0 = r5.L$0
            kotlinx.coroutines.CoroutineScope r0 = (kotlinx.coroutines.CoroutineScope) r0
            kotlin.ResultKt.throwOnFailure(r6)     // Catch: java.util.concurrent.CancellationException -> L64
            goto L4c
        L16:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r0)
            throw r6
        L1e:
            java.lang.Object r1 = r5.L$0
            kotlinx.coroutines.CoroutineScope r1 = (kotlinx.coroutines.CoroutineScope) r1
            kotlin.ResultKt.throwOnFailure(r6)     // Catch: java.util.concurrent.CancellationException -> L64
            r6 = r1
            goto L3b
        L27:
            kotlin.ResultKt.throwOnFailure(r6)
            java.lang.Object r6 = r5.L$0
            kotlinx.coroutines.CoroutineScope r6 = (kotlinx.coroutines.CoroutineScope) r6
            r5.L$0 = r6     // Catch: java.util.concurrent.CancellationException -> L64
            r5.label = r3     // Catch: java.util.concurrent.CancellationException -> L64
            r3 = 800(0x320, double:3.953E-321)
            java.lang.Object r1 = kotlinx.coroutines.DelayKt.delay(r3, r5)     // Catch: java.util.concurrent.CancellationException -> L64
            if (r1 != r0) goto L3b
            return r0
        L3b:
            com.martian.mibook.mvvm.book.viewmodel.SearchViewModel r1 = r5.this$0     // Catch: java.util.concurrent.CancellationException -> L64
            java.lang.String r3 = r5.$keyword     // Catch: java.util.concurrent.CancellationException -> L64
            r5.L$0 = r6     // Catch: java.util.concurrent.CancellationException -> L64
            r5.label = r2     // Catch: java.util.concurrent.CancellationException -> L64
            java.lang.Object r1 = com.martian.mibook.mvvm.book.viewmodel.SearchViewModel.m(r1, r3, r5)     // Catch: java.util.concurrent.CancellationException -> L64
            if (r1 != r0) goto L4a
            return r0
        L4a:
            r0 = r6
            r6 = r1
        L4c:
            java.util.List r6 = (java.util.List) r6     // Catch: java.util.concurrent.CancellationException -> L64
            boolean r0 = kotlinx.coroutines.CoroutineScopeKt.isActive(r0)     // Catch: java.util.concurrent.CancellationException -> L64
            if (r0 == 0) goto L64
            com.martian.mibook.mvvm.book.viewmodel.SearchViewModel r0 = r5.this$0     // Catch: java.util.concurrent.CancellationException -> L64
            com.martian.mibook.mvvm.tts.NonStickyLiveData r0 = com.martian.mibook.mvvm.book.viewmodel.SearchViewModel.q(r0)     // Catch: java.util.concurrent.CancellationException -> L64
            kotlin.Pair r1 = new kotlin.Pair     // Catch: java.util.concurrent.CancellationException -> L64
            java.lang.String r2 = r5.$keyword     // Catch: java.util.concurrent.CancellationException -> L64
            r1.<init>(r2, r6)     // Catch: java.util.concurrent.CancellationException -> L64
            r0.postValue(r1)     // Catch: java.util.concurrent.CancellationException -> L64
        L64:
            kotlin.Unit r6 = kotlin.Unit.INSTANCE
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.martian.mibook.mvvm.book.viewmodel.SearchViewModel$getSearchRecommendBooksByKeyword$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    @Override // kotlin.jvm.functions.Function2
    @l
    public final Object invoke(@k CoroutineScope coroutineScope, @l Continuation<? super Unit> continuation) {
        return ((SearchViewModel$getSearchRecommendBooksByKeyword$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
