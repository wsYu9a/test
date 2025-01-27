package com.martian.mibook.mvvm.tts.fragment;

import com.martian.libmars.widget.recyclerview.LoadingTip;
import com.martian.mibook.databinding.DialogAudioBookChapterListBinding;
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
@DebugMetadata(c = "com.martian.mibook.mvvm.tts.fragment.AudiobookChapterListFragment$refreshChapterList$4", f = "AudiobookChapterListFragment.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes3.dex */
public final class AudiobookChapterListFragment$refreshChapterList$4 extends SuspendLambda implements Function3<CoroutineScope, Throwable, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ AudiobookChapterListFragment this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AudiobookChapterListFragment$refreshChapterList$4(AudiobookChapterListFragment audiobookChapterListFragment, Continuation<? super AudiobookChapterListFragment$refreshChapterList$4> continuation) {
        super(3, continuation);
        this.this$0 = audiobookChapterListFragment;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @l
    public final Object invokeSuspend(@k Object obj) {
        DialogAudioBookChapterListBinding dialogAudioBookChapterListBinding;
        LoadingTip loadingTip;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.throwOnFailure(obj);
        dialogAudioBookChapterListBinding = this.this$0.binding;
        if (dialogAudioBookChapterListBinding != null && (loadingTip = dialogAudioBookChapterListBinding.loadedTip) != null) {
            loadingTip.setLoadingTip(LoadingTip.LoadStatus.empty);
        }
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function3
    @l
    public final Object invoke(@k CoroutineScope coroutineScope, @k Throwable th2, @l Continuation<? super Unit> continuation) {
        return new AudiobookChapterListFragment$refreshChapterList$4(this.this$0, continuation).invokeSuspend(Unit.INSTANCE);
    }
}
