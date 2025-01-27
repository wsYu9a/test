package com.martian.mibook.mvvm.book.repository;

import com.martian.mibook.lib.model.data.TYSearchBookList;
import java.util.Map;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import uc.d;
import vc.a;
import xi.k;
import xi.l;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0000H\u008a@¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Luc/d;", "Lcom/martian/mibook/lib/model/data/TYSearchBookList;", "<anonymous>", "()Luc/d;"}, k = 3, mv = {1, 9, 0})
@DebugMetadata(c = "com.martian.mibook.mvvm.book.repository.BookRepository$getRecommendBooks$2", f = "BookRepository.kt", i = {}, l = {27}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes3.dex */
public final class BookRepository$getRecommendBooks$2 extends SuspendLambda implements Function1<Continuation<? super d<TYSearchBookList>>, Object> {
    final /* synthetic */ Map<String, String> $params;
    int label;
    final /* synthetic */ BookRepository this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BookRepository$getRecommendBooks$2(BookRepository bookRepository, Map<String, String> map, Continuation<? super BookRepository$getRecommendBooks$2> continuation) {
        super(1, continuation);
        this.this$0 = bookRepository;
        this.$params = map;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @k
    public final Continuation<Unit> create(@k Continuation<?> continuation) {
        return new BookRepository$getRecommendBooks$2(this.this$0, this.$params, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @l
    public final Object invokeSuspend(@k Object obj) {
        Object a10;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i10 = this.label;
        if (i10 == 0) {
            ResultKt.throwOnFailure(obj);
            a10 = this.this$0.a(a.class);
            Map<String, String> map = this.$params;
            this.label = 1;
            obj = ((a) a10).k(map, this);
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

    @Override // kotlin.jvm.functions.Function1
    @l
    public final Object invoke(@l Continuation<? super d<TYSearchBookList>> continuation) {
        return ((BookRepository$getRecommendBooks$2) create(continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
