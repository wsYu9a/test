package com.martian.mibook.mvvm.read.fragment;

import com.martian.mibook.lib.model.data.abs.Chapter;
import com.martian.mibook.mvvm.read.adapter.ReadingBookChapterListAdapter;
import com.martian.mibook.mvvm.read.widget.ReaderLoadingTip;
import com.martian.mibook.ui.reader.ReaderThemeTextView;
import java.util.ArrayList;
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

@Metadata(d1 = {"\u0000\u0018\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0016\u0010\u0003\u001a\u0012\u0012\u0004\u0012\u00020\u00050\u0004j\b\u0012\u0004\u0012\u00020\u0005`\u0006H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "it", "Ljava/util/ArrayList;", "Lcom/martian/mibook/lib/model/data/abs/Chapter;", "Lkotlin/collections/ArrayList;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.martian.mibook.mvvm.read.fragment.ReadingChapterListFragment$refreshChapterList$3", f = "ReadingChapterListFragment.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes3.dex */
public final class ReadingChapterListFragment$refreshChapterList$3 extends SuspendLambda implements Function3<CoroutineScope, ArrayList<Chapter>, Continuation<? super Unit>, Object> {
    /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ ReadingChapterListFragment this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ReadingChapterListFragment$refreshChapterList$3(ReadingChapterListFragment readingChapterListFragment, Continuation<? super ReadingChapterListFragment$refreshChapterList$3> continuation) {
        super(3, continuation);
        this.this$0 = readingChapterListFragment;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @l
    public final Object invokeSuspend(@k Object obj) {
        ReadingBookChapterListAdapter readingBookChapterListAdapter;
        String y02;
        ReadingBookChapterListAdapter readingBookChapterListAdapter2;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.throwOnFailure(obj);
        ArrayList arrayList = (ArrayList) this.L$0;
        ReadingChapterListFragment.r0(this.this$0).loadedTip.setLoadingTip(ReaderLoadingTip.LoadStatus.finish);
        ReadingChapterListFragment.r0(this.this$0).llChapterList.setVisibility(0);
        readingBookChapterListAdapter = this.this$0.chapterListAdapter;
        if (readingBookChapterListAdapter != null) {
            readingBookChapterListAdapter.G(arrayList, this.this$0.I().getCom.martian.mibook.mvvm.tts.service.BaseReadAloudService.x java.lang.String(), this.this$0.I().getBook());
        }
        this.this$0.O0();
        ReaderThemeTextView readerThemeTextView = ReadingChapterListFragment.r0(this.this$0).dirNumbers;
        y02 = this.this$0.y0();
        readerThemeTextView.setText(y02);
        readingBookChapterListAdapter2 = this.this$0.chapterListAdapter;
        if (readingBookChapterListAdapter2 != null) {
            readingBookChapterListAdapter2.r(ReadingChapterListFragment.r0(this.this$0).rvChapterList, 500L);
        }
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function3
    @l
    public final Object invoke(@k CoroutineScope coroutineScope, @k ArrayList<Chapter> arrayList, @l Continuation<? super Unit> continuation) {
        ReadingChapterListFragment$refreshChapterList$3 readingChapterListFragment$refreshChapterList$3 = new ReadingChapterListFragment$refreshChapterList$3(this.this$0, continuation);
        readingChapterListFragment$refreshChapterList$3.L$0 = arrayList;
        return readingChapterListFragment$refreshChapterList$3.invokeSuspend(Unit.INSTANCE);
    }
}
