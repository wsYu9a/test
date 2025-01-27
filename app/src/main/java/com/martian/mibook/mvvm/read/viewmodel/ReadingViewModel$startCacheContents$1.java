package com.martian.mibook.mvvm.read.viewmodel;

import com.martian.mibook.application.MiConfigSingleton;
import com.martian.mibook.lib.model.data.Source;
import com.martian.mibook.lib.model.data.abs.ChapterList;
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
@DebugMetadata(c = "com.martian.mibook.mvvm.read.viewmodel.ReadingViewModel$startCacheContents$1", f = "ReadingViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes3.dex */
public final class ReadingViewModel$startCacheContents$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Integer>, Object> {
    final /* synthetic */ int $chapterCount;
    final /* synthetic */ int $index;
    int label;
    final /* synthetic */ ReadingViewModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ReadingViewModel$startCacheContents$1(int i10, int i11, ReadingViewModel readingViewModel, Continuation<? super ReadingViewModel$startCacheContents$1> continuation) {
        super(2, continuation);
        this.$index = i10;
        this.$chapterCount = i11;
        this.this$0 = readingViewModel;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @k
    public final Continuation<Unit> create(@l Object obj, @k Continuation<?> continuation) {
        return new ReadingViewModel$startCacheContents$1(this.$index, this.$chapterCount, this.this$0, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @l
    public final Object invokeSuspend(@k Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.throwOnFailure(obj);
        int i10 = this.$index;
        while (true) {
            int i11 = this.$chapterCount;
            if (i10 >= i11) {
                return Boxing.boxInt(i11 - 1);
            }
            ChapterList chapterList = this.this$0.getChapterList();
            if (!MiConfigSingleton.b2().M1().c0(new Source(this.this$0.getSourceName(), this.this$0.getSourceId()), chapterList != null ? chapterList.getItem(i10) : null)) {
                return Boxing.boxInt(i10);
            }
            i10++;
        }
    }

    @Override // kotlin.jvm.functions.Function2
    @l
    public final Object invoke(@k CoroutineScope coroutineScope, @l Continuation<? super Integer> continuation) {
        return ((ReadingViewModel$startCacheContents$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
