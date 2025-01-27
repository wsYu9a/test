package com.martian.mibook.mvvm.tts.fragment;

import com.martian.mibook.application.MiConfigSingleton;
import com.martian.mibook.lib.model.data.abs.Book;
import com.martian.mibook.lib.model.data.abs.ChapterList;
import com.martian.mibook.mvvm.tts.ReadAloudBook;
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
@DebugMetadata(c = "com.martian.mibook.mvvm.tts.fragment.AudiobookChapterListFragment$startCacheContents$2", f = "AudiobookChapterListFragment.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes3.dex */
public final class AudiobookChapterListFragment$startCacheContents$2 extends SuspendLambda implements Function3<CoroutineScope, Integer, Continuation<? super Unit>, Object> {
    /* synthetic */ int I$0;
    int label;
    final /* synthetic */ AudiobookChapterListFragment this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AudiobookChapterListFragment$startCacheContents$2(AudiobookChapterListFragment audiobookChapterListFragment, Continuation<? super AudiobookChapterListFragment$startCacheContents$2> continuation) {
        super(3, continuation);
        this.this$0 = audiobookChapterListFragment;
    }

    @Override // kotlin.jvm.functions.Function3
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope coroutineScope, Integer num, Continuation<? super Unit> continuation) {
        return invoke(coroutineScope, num.intValue(), continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @l
    public final Object invokeSuspend(@k Object obj) {
        int i10;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.throwOnFailure(obj);
        this.this$0.cacheStartIndex = this.I$0;
        b1 P1 = MiConfigSingleton.b2().P1();
        ReadAloudBook readAloudBook = ReadAloudBook.f15003a;
        P1.w(readAloudBook.a(), this.this$0);
        b1 P12 = MiConfigSingleton.b2().P1();
        Book a10 = readAloudBook.a();
        ChapterList d10 = readAloudBook.d();
        i10 = this.this$0.cacheStartIndex;
        P12.v(a10, d10, i10, 50, this.this$0);
        return Unit.INSTANCE;
    }

    @l
    public final Object invoke(@k CoroutineScope coroutineScope, int i10, @l Continuation<? super Unit> continuation) {
        AudiobookChapterListFragment$startCacheContents$2 audiobookChapterListFragment$startCacheContents$2 = new AudiobookChapterListFragment$startCacheContents$2(this.this$0, continuation);
        audiobookChapterListFragment$startCacheContents$2.I$0 = i10;
        return audiobookChapterListFragment$startCacheContents$2.invokeSuspend(Unit.INSTANCE);
    }
}
