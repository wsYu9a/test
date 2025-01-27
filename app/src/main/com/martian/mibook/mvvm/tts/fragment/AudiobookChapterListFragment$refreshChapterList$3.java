package com.martian.mibook.mvvm.tts.fragment;

import androidx.constraintlayout.widget.ConstraintLayout;
import com.martian.libmars.widget.recyclerview.LoadingTip;
import com.martian.mibook.databinding.DialogAudioBookChapterListBinding;
import com.martian.mibook.lib.model.data.abs.Chapter;
import com.martian.mibook.mvvm.tts.ReadAloudBook;
import com.martian.mibook.mvvm.tts.adapter.AudiobookChapterAdapter;
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
@DebugMetadata(c = "com.martian.mibook.mvvm.tts.fragment.AudiobookChapterListFragment$refreshChapterList$3", f = "AudiobookChapterListFragment.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes3.dex */
public final class AudiobookChapterListFragment$refreshChapterList$3 extends SuspendLambda implements Function3<CoroutineScope, ArrayList<Chapter>, Continuation<? super Unit>, Object> {
    /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ AudiobookChapterListFragment this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AudiobookChapterListFragment$refreshChapterList$3(AudiobookChapterListFragment audiobookChapterListFragment, Continuation<? super AudiobookChapterListFragment$refreshChapterList$3> continuation) {
        super(3, continuation);
        this.this$0 = audiobookChapterListFragment;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @l
    public final Object invokeSuspend(@k Object obj) {
        DialogAudioBookChapterListBinding dialogAudioBookChapterListBinding;
        DialogAudioBookChapterListBinding dialogAudioBookChapterListBinding2;
        DialogAudioBookChapterListBinding dialogAudioBookChapterListBinding3;
        LoadingTip loadingTip;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.throwOnFailure(obj);
        ArrayList arrayList = (ArrayList) this.L$0;
        dialogAudioBookChapterListBinding = this.this$0.binding;
        if (dialogAudioBookChapterListBinding != null && (loadingTip = dialogAudioBookChapterListBinding.loadedTip) != null) {
            loadingTip.setLoadingTip(LoadingTip.LoadStatus.finish);
        }
        dialogAudioBookChapterListBinding2 = this.this$0.binding;
        ConstraintLayout constraintLayout = dialogAudioBookChapterListBinding2 != null ? dialogAudioBookChapterListBinding2.clChapterList : null;
        if (constraintLayout != null) {
            constraintLayout.setVisibility(0);
        }
        AudiobookChapterAdapter audiobookChapterAdapter = this.this$0.chapterListAdapter;
        if (audiobookChapterAdapter != null) {
            ReadAloudBook readAloudBook = ReadAloudBook.f15003a;
            audiobookChapterAdapter.D(arrayList, readAloudBook.c(), readAloudBook.a());
        }
        this.this$0.r0();
        AudiobookChapterAdapter audiobookChapterAdapter2 = this.this$0.chapterListAdapter;
        if (audiobookChapterAdapter2 != null) {
            dialogAudioBookChapterListBinding3 = this.this$0.binding;
            audiobookChapterAdapter2.p(dialogAudioBookChapterListBinding3 != null ? dialogAudioBookChapterListBinding3.rvChapterList : null, 500L);
        }
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function3
    @l
    public final Object invoke(@k CoroutineScope coroutineScope, @k ArrayList<Chapter> arrayList, @l Continuation<? super Unit> continuation) {
        AudiobookChapterListFragment$refreshChapterList$3 audiobookChapterListFragment$refreshChapterList$3 = new AudiobookChapterListFragment$refreshChapterList$3(this.this$0, continuation);
        audiobookChapterListFragment$refreshChapterList$3.L$0 = arrayList;
        return audiobookChapterListFragment$refreshChapterList$3.invokeSuspend(Unit.INSTANCE);
    }
}
