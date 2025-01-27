package com.martian.mibook.mvvm.read.fragment;

import com.martian.mibook.lib.model.data.abs.Chapter;
import com.martian.mibook.lib.model.data.abs.ChapterList;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import xi.k;
import xi.l;

@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0012\u0012\u0004\u0012\u00020\u00020\u0001j\b\u0012\u0004\u0012\u00020\u0002`\u0003*\u00020\u0004H\u008a@"}, d2 = {"<anonymous>", "Ljava/util/ArrayList;", "Lcom/martian/mibook/lib/model/data/abs/Chapter;", "Lkotlin/collections/ArrayList;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.martian.mibook.mvvm.read.fragment.ReadingChapterListFragment$refreshChapterList$1", f = "ReadingChapterListFragment.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes3.dex */
public final class ReadingChapterListFragment$refreshChapterList$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super ArrayList<Chapter>>, Object> {
    int label;
    final /* synthetic */ ReadingChapterListFragment this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ReadingChapterListFragment$refreshChapterList$1(ReadingChapterListFragment readingChapterListFragment, Continuation<? super ReadingChapterListFragment$refreshChapterList$1> continuation) {
        super(2, continuation);
        this.this$0 = readingChapterListFragment;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @k
    public final Continuation<Unit> create(@l Object obj, @k Continuation<?> continuation) {
        return new ReadingChapterListFragment$refreshChapterList$1(this.this$0, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @l
    public final Object invokeSuspend(@k Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.throwOnFailure(obj);
        ArrayList arrayList = new ArrayList();
        ChapterList chapterList = this.this$0.I().getChapterList();
        if (chapterList != null && chapterList.getCount() > 0) {
            int count = chapterList.getCount();
            for (int i10 = 0; i10 < count; i10++) {
                Chapter item = chapterList.getItem(i10);
                if (item != null) {
                    Intrinsics.checkNotNull(item);
                    Boxing.boxBoolean(arrayList.add(item));
                }
            }
        }
        return arrayList;
    }

    @Override // kotlin.jvm.functions.Function2
    @l
    public final Object invoke(@k CoroutineScope coroutineScope, @l Continuation<? super ArrayList<Chapter>> continuation) {
        return ((ReadingChapterListFragment$refreshChapterList$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
