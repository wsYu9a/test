package com.martian.mibook.mvvm.tts;

import com.martian.mibook.lib.model.data.abs.Book;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import xi.k;
import xi.l;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.martian.mibook.mvvm.tts.TTSReadManager$doStartService$1$deferredResult$1", f = "TTSReadManager.kt", i = {}, l = {50}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes3.dex */
public final class TTSReadManager$doStartService$1$deferredResult$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Boolean>, Object> {
    final /* synthetic */ Book $book;
    final /* synthetic */ String $bookSource;
    final /* synthetic */ int $chapterIndex;
    final /* synthetic */ int $contentPos;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TTSReadManager$doStartService$1$deferredResult$1(Book book, String str, int i10, int i11, Continuation<? super TTSReadManager$doStartService$1$deferredResult$1> continuation) {
        super(2, continuation);
        this.$book = book;
        this.$bookSource = str;
        this.$chapterIndex = i10;
        this.$contentPos = i11;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @k
    public final Continuation<Unit> create(@l Object obj, @k Continuation<?> continuation) {
        return new TTSReadManager$doStartService$1$deferredResult$1(this.$book, this.$bookSource, this.$chapterIndex, this.$contentPos, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @l
    public final Object invokeSuspend(@k Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i10 = this.label;
        if (i10 == 0) {
            ResultKt.throwOnFailure(obj);
            ReadAloudBook readAloudBook = ReadAloudBook.f15003a;
            Book book = this.$book;
            Intrinsics.checkNotNullExpressionValue(book, "$book");
            String str = this.$bookSource;
            int i11 = this.$chapterIndex;
            int i12 = this.$contentPos;
            this.label = 1;
            obj = readAloudBook.u(book, str, i11, i12, this);
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
    public final Object invoke(@k CoroutineScope coroutineScope, @l Continuation<? super Boolean> continuation) {
        return ((TTSReadManager$doStartService$1$deferredResult$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
