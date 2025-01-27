package com.martian.mibook.mvvm.yuewen.repository;

import com.martian.mibook.lib.account.response.BooksUpdateInfo;
import java.util.List;
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

@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0003\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u00010\u0000H\u008a@¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Luc/d;", "", "Lcom/martian/mibook/lib/account/response/BooksUpdateInfo;", "<anonymous>", "()Luc/d;"}, k = 3, mv = {1, 9, 0})
@DebugMetadata(c = "com.martian.mibook.mvvm.yuewen.repository.BookShelfRepository$getBooksUpdateInfo$2", f = "BookShelfRepository.kt", i = {}, l = {12}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes3.dex */
public final class BookShelfRepository$getBooksUpdateInfo$2 extends SuspendLambda implements Function1<Continuation<? super d<List<? extends BooksUpdateInfo>>>, Object> {
    final /* synthetic */ String $sourceStrings;
    int label;
    final /* synthetic */ BookShelfRepository this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BookShelfRepository$getBooksUpdateInfo$2(BookShelfRepository bookShelfRepository, String str, Continuation<? super BookShelfRepository$getBooksUpdateInfo$2> continuation) {
        super(1, continuation);
        this.this$0 = bookShelfRepository;
        this.$sourceStrings = str;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @k
    public final Continuation<Unit> create(@k Continuation<?> continuation) {
        return new BookShelfRepository$getBooksUpdateInfo$2(this.this$0, this.$sourceStrings, continuation);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Object invoke(Continuation<? super d<List<? extends BooksUpdateInfo>>> continuation) {
        return invoke2((Continuation<? super d<List<BooksUpdateInfo>>>) continuation);
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
            String str = this.$sourceStrings;
            this.label = 1;
            obj = ((a) a10).J(str, this);
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

    @l
    /* renamed from: invoke */
    public final Object invoke2(@l Continuation<? super d<List<BooksUpdateInfo>>> continuation) {
        return ((BookShelfRepository$getBooksUpdateInfo$2) create(continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
