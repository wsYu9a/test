package com.martian.mibook.mvvm.tts.dialog;

import android.content.Context;
import com.martian.libmars.ui.theme.ThemeProgressBar;
import com.martian.libmars.ui.theme.ThemeTextView;
import com.martian.mibook.R;
import com.martian.mibook.databinding.DialogDownloadTtsEngineBinding;
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
@DebugMetadata(c = "com.martian.mibook.mvvm.tts.dialog.DownloadTtsEngineDialogFragment$setProgress$1", f = "DownloadTtsEngineDialogFragment.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes3.dex */
public final class DownloadTtsEngineDialogFragment$setProgress$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Integer $percent;
    int label;
    final /* synthetic */ DownloadTtsEngineDialogFragment this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DownloadTtsEngineDialogFragment$setProgress$1(DownloadTtsEngineDialogFragment downloadTtsEngineDialogFragment, Integer num, Continuation<? super DownloadTtsEngineDialogFragment$setProgress$1> continuation) {
        super(2, continuation);
        this.this$0 = downloadTtsEngineDialogFragment;
        this.$percent = num;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @k
    public final Continuation<Unit> create(@l Object obj, @k Continuation<?> continuation) {
        return new DownloadTtsEngineDialogFragment$setProgress$1(this.this$0, this.$percent, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @l
    public final Object invokeSuspend(@k Object obj) {
        DialogDownloadTtsEngineBinding dialogDownloadTtsEngineBinding;
        DialogDownloadTtsEngineBinding dialogDownloadTtsEngineBinding2;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.throwOnFailure(obj);
        dialogDownloadTtsEngineBinding = this.this$0.mViewBinding;
        ThemeProgressBar themeProgressBar = dialogDownloadTtsEngineBinding != null ? dialogDownloadTtsEngineBinding.rbsProgressBar : null;
        if (themeProgressBar != null) {
            Integer num = this.$percent;
            themeProgressBar.setProgress(num != null ? num.intValue() : 0);
        }
        dialogDownloadTtsEngineBinding2 = this.this$0.mViewBinding;
        ThemeTextView themeTextView = dialogDownloadTtsEngineBinding2 != null ? dialogDownloadTtsEngineBinding2.tvDownload : null;
        if (themeTextView != null) {
            Context context = this.this$0.getContext();
            String string = context != null ? context.getString(R.string.download_desc) : null;
            themeTextView.setText(string + this.$percent + "%");
        }
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    @l
    public final Object invoke(@k CoroutineScope coroutineScope, @l Continuation<? super Unit> continuation) {
        return ((DownloadTtsEngineDialogFragment$setProgress$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
