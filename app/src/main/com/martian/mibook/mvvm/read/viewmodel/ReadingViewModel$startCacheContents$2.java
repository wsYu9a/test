package com.martian.mibook.mvvm.read.viewmodel;

import com.martian.mibook.application.MiConfigSingleton;
import com.martian.mibook.lib.model.data.abs.Book;
import com.martian.mibook.lib.model.data.abs.ChapterList;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function3;
import kotlinx.coroutines.CoroutineScope;
import xi.k;
import xi.l;
import ya.b1;

@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "it", ""}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.martian.mibook.mvvm.read.viewmodel.ReadingViewModel$startCacheContents$2", f = "ReadingViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes3.dex */
public final class ReadingViewModel$startCacheContents$2 extends SuspendLambda implements Function3<CoroutineScope, Integer, Continuation<? super Unit>, Object> {
    /* synthetic */ int I$0;
    int label;
    final /* synthetic */ ReadingViewModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ReadingViewModel$startCacheContents$2(ReadingViewModel readingViewModel, Continuation<? super ReadingViewModel$startCacheContents$2> continuation) {
        super(3, continuation);
        this.this$0 = readingViewModel;
    }

    @Override // kotlin.jvm.functions.Function3
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope coroutineScope, Integer num, Continuation<? super Unit> continuation) {
        return invoke(coroutineScope, num.intValue(), continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @l
    public final Object invokeSuspend(@k Object obj) {
        b1.b bVar;
        b1.b bVar2;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.throwOnFailure(obj);
        this.this$0.u2(this.I$0);
        b1 P1 = MiConfigSingleton.b2().P1();
        Book book = this.this$0.getBook();
        bVar = this.this$0.cacheStatusChangedListener;
        P1.w(book, bVar);
        b1 P12 = MiConfigSingleton.b2().P1();
        Book book2 = this.this$0.getBook();
        ChapterList chapterList = this.this$0.getChapterList();
        int cacheStartIndex = this.this$0.getCacheStartIndex();
        bVar2 = this.this$0.cacheStatusChangedListener;
        P12.v(book2, chapterList, cacheStartIndex, 50, bVar2);
        return Unit.INSTANCE;
    }

    @l
    public final Object invoke(@k CoroutineScope coroutineScope, int i10, @l Continuation<? super Unit> continuation) {
        ReadingViewModel$startCacheContents$2 readingViewModel$startCacheContents$2 = new ReadingViewModel$startCacheContents$2(this.this$0, continuation);
        readingViewModel$startCacheContents$2.I$0 = i10;
        return readingViewModel$startCacheContents$2.invokeSuspend(Unit.INSTANCE);
    }
}
