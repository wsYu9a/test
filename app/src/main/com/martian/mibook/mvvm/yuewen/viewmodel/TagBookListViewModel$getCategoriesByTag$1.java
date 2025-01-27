package com.martian.mibook.mvvm.yuewen.viewmodel;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import xi.k;
import xi.l;

@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u008a@"}, d2 = {"<anonymous>", "", "it", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.martian.mibook.mvvm.yuewen.viewmodel.TagBookListViewModel$getCategoriesByTag$1", f = "TagBookListViewModel.kt", i = {0}, l = {31, 54}, m = "invokeSuspend", n = {"tyTags"}, s = {"L$0"})
/* loaded from: classes3.dex */
public final class TagBookListViewModel$getCategoriesByTag$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function1<Continuation<? super Unit>, Object> $followBlock;
    Object L$0;
    int label;
    final /* synthetic */ TagBookListViewModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public TagBookListViewModel$getCategoriesByTag$1(TagBookListViewModel tagBookListViewModel, Function1<? super Continuation<? super Unit>, ? extends Object> function1, Continuation<? super TagBookListViewModel$getCategoriesByTag$1> continuation) {
        super(2, continuation);
        this.this$0 = tagBookListViewModel;
        this.$followBlock = function1;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @k
    public final Continuation<Unit> create(@l Object obj, @k Continuation<?> continuation) {
        return new TagBookListViewModel$getCategoriesByTag$1(this.this$0, this.$followBlock, continuation);
    }

    /* JADX WARN: Removed duplicated region for block: B:38:0x010e A[RETURN] */
    /* JADX WARN: Type inference failed for: r10v3, types: [T, java.util.List] */
    /* JADX WARN: Type inference failed for: r2v3, types: [T, java.util.List] */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @xi.l
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object invokeSuspend(@xi.k java.lang.Object r10) {
        /*
            Method dump skipped, instructions count: 286
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.martian.mibook.mvvm.yuewen.viewmodel.TagBookListViewModel$getCategoriesByTag$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    @Override // kotlin.jvm.functions.Function2
    @l
    public final Object invoke(@k CoroutineScope coroutineScope, @l Continuation<? super Unit> continuation) {
        return ((TagBookListViewModel$getCategoriesByTag$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
