package com.martian.mibook.mvvm.book.viewmodel;

import androidx.lifecycle.MutableLiveData;
import com.martian.mibook.lib.account.response.TYChapterContent;
import com.martian.mibook.mvvm.book.repository.BookRepository;
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

@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u008a@"}, d2 = {"<anonymous>", "", "it", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.martian.mibook.mvvm.book.viewmodel.BookViewModel$getChapterContent$1", f = "BookViewModel.kt", i = {}, l = {108}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes3.dex */
public final class BookViewModel$getChapterContent$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $chapterId;
    final /* synthetic */ String $sourceId;
    final /* synthetic */ String $sourceName;
    int label;
    final /* synthetic */ BookViewModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BookViewModel$getChapterContent$1(BookViewModel bookViewModel, String str, String str2, String str3, Continuation<? super BookViewModel$getChapterContent$1> continuation) {
        super(2, continuation);
        this.this$0 = bookViewModel;
        this.$sourceName = str;
        this.$sourceId = str2;
        this.$chapterId = str3;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @k
    public final Continuation<Unit> create(@l Object obj, @k Continuation<?> continuation) {
        return new BookViewModel$getChapterContent$1(this.this$0, this.$sourceName, this.$sourceId, this.$chapterId, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @l
    public final Object invokeSuspend(@k Object obj) {
        MutableLiveData mutableLiveData;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i10 = this.label;
        if (i10 == 0) {
            ResultKt.throwOnFailure(obj);
            BookRepository f10 = this.this$0.f();
            String str = this.$sourceName;
            String str2 = this.$sourceId;
            String str3 = this.$chapterId;
            this.label = 1;
            obj = f10.f(str, str2, str3, this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i10 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        }
        mutableLiveData = this.this$0._mChapterContentLiveData;
        mutableLiveData.postValue((TYChapterContent) obj);
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    @l
    public final Object invoke(@k CoroutineScope coroutineScope, @l Continuation<? super Unit> continuation) {
        return ((BookViewModel$getChapterContent$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
