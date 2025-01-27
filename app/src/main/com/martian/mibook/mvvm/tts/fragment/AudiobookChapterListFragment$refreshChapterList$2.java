package com.martian.mibook.mvvm.tts.fragment;

import androidx.constraintlayout.widget.ConstraintLayout;
import com.martian.libmars.widget.recyclerview.LoadingTip;
import com.martian.mibook.databinding.DialogAudioBookChapterListBinding;
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

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.martian.mibook.mvvm.tts.fragment.AudiobookChapterListFragment$refreshChapterList$2", f = "AudiobookChapterListFragment.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes3.dex */
public final class AudiobookChapterListFragment$refreshChapterList$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ AudiobookChapterListFragment this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AudiobookChapterListFragment$refreshChapterList$2(AudiobookChapterListFragment audiobookChapterListFragment, Continuation<? super AudiobookChapterListFragment$refreshChapterList$2> continuation) {
        super(2, continuation);
        this.this$0 = audiobookChapterListFragment;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @k
    public final Continuation<Unit> create(@l Object obj, @k Continuation<?> continuation) {
        return new AudiobookChapterListFragment$refreshChapterList$2(this.this$0, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @l
    public final Object invokeSuspend(@k Object obj) {
        DialogAudioBookChapterListBinding dialogAudioBookChapterListBinding;
        DialogAudioBookChapterListBinding dialogAudioBookChapterListBinding2;
        LoadingTip loadingTip;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.throwOnFailure(obj);
        dialogAudioBookChapterListBinding = this.this$0.binding;
        ConstraintLayout constraintLayout = dialogAudioBookChapterListBinding != null ? dialogAudioBookChapterListBinding.clChapterList : null;
        if (constraintLayout != null) {
            constraintLayout.setVisibility(8);
        }
        dialogAudioBookChapterListBinding2 = this.this$0.binding;
        if (dialogAudioBookChapterListBinding2 != null && (loadingTip = dialogAudioBookChapterListBinding2.loadedTip) != null) {
            loadingTip.setLoadingTip(LoadingTip.LoadStatus.loading);
        }
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    @l
    public final Object invoke(@k CoroutineScope coroutineScope, @l Continuation<? super Unit> continuation) {
        return ((AudiobookChapterListFragment$refreshChapterList$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
