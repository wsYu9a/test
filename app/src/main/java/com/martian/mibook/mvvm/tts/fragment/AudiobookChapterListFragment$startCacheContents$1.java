package com.martian.mibook.mvvm.tts.fragment;

import com.martian.mibook.application.MiConfigSingleton;
import com.martian.mibook.lib.model.data.Source;
import com.martian.mibook.lib.model.data.abs.Book;
import com.martian.mibook.lib.model.data.abs.ChapterList;
import com.martian.mibook.mvvm.tts.ReadAloudBook;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import xi.k;
import xi.l;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\b\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.martian.mibook.mvvm.tts.fragment.AudiobookChapterListFragment$startCacheContents$1", f = "AudiobookChapterListFragment.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes3.dex */
public final class AudiobookChapterListFragment$startCacheContents$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Integer>, Object> {
    final /* synthetic */ int $chapterCount;
    final /* synthetic */ int $index;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AudiobookChapterListFragment$startCacheContents$1(int i10, int i11, Continuation<? super AudiobookChapterListFragment$startCacheContents$1> continuation) {
        super(2, continuation);
        this.$index = i10;
        this.$chapterCount = i11;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @k
    public final Continuation<Unit> create(@l Object obj, @k Continuation<?> continuation) {
        return new AudiobookChapterListFragment$startCacheContents$1(this.$index, this.$chapterCount, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @l
    public final Object invokeSuspend(@k Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.throwOnFailure(obj);
        ReadAloudBook readAloudBook = ReadAloudBook.f15003a;
        Book a10 = readAloudBook.a();
        String sourceName = a10 != null ? a10.getSourceName() : null;
        Book a11 = readAloudBook.a();
        Source source = new Source(sourceName, a11 != null ? a11.getSourceId() : null);
        int i10 = this.$index;
        while (true) {
            int i11 = this.$chapterCount;
            if (i10 >= i11) {
                return Boxing.boxInt(i11 - 1);
            }
            ChapterList d10 = ReadAloudBook.f15003a.d();
            if (!MiConfigSingleton.b2().M1().c0(source, d10 != null ? d10.getItem(i10) : null)) {
                return Boxing.boxInt(i10);
            }
            i10++;
        }
    }

    @Override // kotlin.jvm.functions.Function2
    @l
    public final Object invoke(@k CoroutineScope coroutineScope, @l Continuation<? super Integer> continuation) {
        return ((AudiobookChapterListFragment$startCacheContents$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
