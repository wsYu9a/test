package com.martian.mibook.mvvm.book.repository;

import com.martian.mibook.lib.account.response.TYChapterContent;
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

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0000H\u008a@¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Luc/d;", "Lcom/martian/mibook/lib/account/response/TYChapterContent;", "<anonymous>", "()Luc/d;"}, k = 3, mv = {1, 9, 0})
@DebugMetadata(c = "com.martian.mibook.mvvm.book.repository.BookRepository$getChapterContent$2", f = "BookRepository.kt", i = {}, l = {18}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes3.dex */
public final class BookRepository$getChapterContent$2 extends SuspendLambda implements Function1<Continuation<? super d<TYChapterContent>>, Object> {
    final /* synthetic */ String $chapterId;
    final /* synthetic */ String $sourceId;
    final /* synthetic */ String $sourceName;
    int label;
    final /* synthetic */ BookRepository this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BookRepository$getChapterContent$2(BookRepository bookRepository, String str, String str2, String str3, Continuation<? super BookRepository$getChapterContent$2> continuation) {
        super(1, continuation);
        this.this$0 = bookRepository;
        this.$sourceName = str;
        this.$sourceId = str2;
        this.$chapterId = str3;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @k
    public final Continuation<Unit> create(@k Continuation<?> continuation) {
        return new BookRepository$getChapterContent$2(this.this$0, this.$sourceName, this.$sourceId, this.$chapterId, continuation);
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
            String str = this.$sourceName;
            String str2 = this.$sourceId;
            String str3 = this.$chapterId;
            this.label = 1;
            obj = ((a) a10).l(str, str2, str3, this);
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
    public final Object invoke(@l Continuation<? super d<TYChapterContent>> continuation) {
        return ((BookRepository$getChapterContent$2) create(continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
