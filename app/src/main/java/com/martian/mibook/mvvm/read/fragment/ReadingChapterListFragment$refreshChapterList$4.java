package com.martian.mibook.mvvm.read.fragment;

import com.martian.mibook.mvvm.read.widget.ReaderLoadingTip;
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

@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "it", ""}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.martian.mibook.mvvm.read.fragment.ReadingChapterListFragment$refreshChapterList$4", f = "ReadingChapterListFragment.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes3.dex */
public final class ReadingChapterListFragment$refreshChapterList$4 extends SuspendLambda implements Function3<CoroutineScope, Throwable, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ ReadingChapterListFragment this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ReadingChapterListFragment$refreshChapterList$4(ReadingChapterListFragment readingChapterListFragment, Continuation<? super ReadingChapterListFragment$refreshChapterList$4> continuation) {
        super(3, continuation);
        this.this$0 = readingChapterListFragment;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @l
    public final Object invokeSuspend(@k Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.throwOnFailure(obj);
        ReadingChapterListFragment.r0(this.this$0).loadedTip.setLoadingTip(ReaderLoadingTip.LoadStatus.empty);
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function3
    @l
    public final Object invoke(@k CoroutineScope coroutineScope, @k Throwable th2, @l Continuation<? super Unit> continuation) {
        return new ReadingChapterListFragment$refreshChapterList$4(this.this$0, continuation).invokeSuspend(Unit.INSTANCE);
    }
}
