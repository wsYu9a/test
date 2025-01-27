package com.martian.mibook.mvvm.tts.activity;

import android.content.DialogInterface;
import com.martian.mibook.mvvm.tts.dialog.DownloadTtsEngineDialogFragment;
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
@DebugMetadata(c = "com.martian.mibook.mvvm.tts.activity.AudiobookActivity$readAloudEventObserver$2$1$1", f = "AudiobookActivity.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes3.dex */
public final class AudiobookActivity$readAloudEventObserver$2$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ AudiobookActivity this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AudiobookActivity$readAloudEventObserver$2$1$1(AudiobookActivity audiobookActivity, Continuation<? super AudiobookActivity$readAloudEventObserver$2$1$1> continuation) {
        super(2, continuation);
        this.this$0 = audiobookActivity;
    }

    public static final void invokeSuspend$lambda$0(AudiobookActivity audiobookActivity, DialogInterface dialogInterface) {
        DownloadTtsEngineDialogFragment downloadTtsEngineDialogFragment;
        downloadTtsEngineDialogFragment = audiobookActivity.downloadTtsEngineDialogFragment;
        if (downloadTtsEngineDialogFragment != null) {
            audiobookActivity.I3();
        }
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @k
    public final Continuation<Unit> create(@l Object obj, @k Continuation<?> continuation) {
        return new AudiobookActivity$readAloudEventObserver$2$1$1(this.this$0, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @l
    public final Object invokeSuspend(@k Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.throwOnFailure(obj);
        ac.a.W(this.this$0.getApplicationContext(), "Google下载弹窗-曝光");
        this.this$0.U2();
        AudiobookActivity audiobookActivity = this.this$0;
        audiobookActivity.downloadTtsEngineDialogFragment = DownloadTtsEngineDialogFragment.INSTANCE.e(audiobookActivity, new DialogInterface.OnDismissListener() { // from class: com.martian.mibook.mvvm.tts.activity.f
            public /* synthetic */ f() {
            }

            @Override // android.content.DialogInterface.OnDismissListener
            public final void onDismiss(DialogInterface dialogInterface) {
                AudiobookActivity$readAloudEventObserver$2$1$1.invokeSuspend$lambda$0(AudiobookActivity.this, dialogInterface);
            }
        });
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    @l
    public final Object invoke(@k CoroutineScope coroutineScope, @l Continuation<? super Unit> continuation) {
        return ((AudiobookActivity$readAloudEventObserver$2$1$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
