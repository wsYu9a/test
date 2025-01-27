package com.martian.mibook.mvvm.tts.dialog;

import android.content.Context;
import com.martian.libmars.ui.theme.ThemeProgressBar;
import com.martian.libmars.ui.theme.ThemeTextView;
import com.martian.mibook.R;
import com.martian.mibook.databinding.DialogDownloadTtsEngineBinding;
import com.tencent.bugly.beta.tinker.TinkerReport;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.DelayKt;
import xi.k;
import xi.l;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.martian.mibook.mvvm.tts.dialog.DownloadTtsEngineDialogFragment$setFinished$1", f = "DownloadTtsEngineDialogFragment.kt", i = {}, l = {TinkerReport.KEY_APPLIED_PACKAGE_CHECK_TINKER_ID_NOT_EQUAL}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes3.dex */
public final class DownloadTtsEngineDialogFragment$setFinished$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ DownloadTtsEngineDialogFragment this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DownloadTtsEngineDialogFragment$setFinished$1(DownloadTtsEngineDialogFragment downloadTtsEngineDialogFragment, Continuation<? super DownloadTtsEngineDialogFragment$setFinished$1> continuation) {
        super(2, continuation);
        this.this$0 = downloadTtsEngineDialogFragment;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @k
    public final Continuation<Unit> create(@l Object obj, @k Continuation<?> continuation) {
        return new DownloadTtsEngineDialogFragment$setFinished$1(this.this$0, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @l
    public final Object invokeSuspend(@k Object obj) {
        DialogDownloadTtsEngineBinding dialogDownloadTtsEngineBinding;
        DialogDownloadTtsEngineBinding dialogDownloadTtsEngineBinding2;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i10 = this.label;
        if (i10 == 0) {
            ResultKt.throwOnFailure(obj);
            dialogDownloadTtsEngineBinding = this.this$0.mViewBinding;
            ThemeProgressBar themeProgressBar = dialogDownloadTtsEngineBinding != null ? dialogDownloadTtsEngineBinding.rbsProgressBar : null;
            if (themeProgressBar != null) {
                themeProgressBar.setProgress(100);
            }
            dialogDownloadTtsEngineBinding2 = this.this$0.mViewBinding;
            ThemeTextView themeTextView = dialogDownloadTtsEngineBinding2 != null ? dialogDownloadTtsEngineBinding2.tvDownload : null;
            if (themeTextView != null) {
                Context context = this.this$0.getContext();
                themeTextView.setText(context != null ? context.getString(R.string.installing) : null);
            }
            this.label = 1;
            if (DelayKt.delay(500L, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i10 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        }
        this.this$0.dismiss();
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    @l
    public final Object invoke(@k CoroutineScope coroutineScope, @l Continuation<? super Unit> continuation) {
        return ((DownloadTtsEngineDialogFragment$setFinished$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
