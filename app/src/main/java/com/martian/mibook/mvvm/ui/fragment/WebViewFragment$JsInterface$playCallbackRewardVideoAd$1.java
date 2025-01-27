package com.martian.mibook.mvvm.ui.fragment;

import androidx.exifinterface.media.ExifInterface;
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

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003*\u00020\u0004H\u008a@"}, d2 = {"<anonymous>", "", ExifInterface.GPS_DIRECTION_TRUE, "U", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.martian.mibook.mvvm.ui.fragment.WebViewFragment$JsInterface$playCallbackRewardVideoAd$1", f = "WebViewFragment.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes3.dex */
public final class WebViewFragment$JsInterface$playCallbackRewardVideoAd$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $adsId;
    final /* synthetic */ String $position;
    final /* synthetic */ int $reward;
    final /* synthetic */ String $rewardExtra;
    final /* synthetic */ String $rewardName;
    int label;
    final /* synthetic */ WebViewFragment<T, U> this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WebViewFragment$JsInterface$playCallbackRewardVideoAd$1(WebViewFragment<T, U> webViewFragment, String str, String str2, int i10, String str3, String str4, Continuation<? super WebViewFragment$JsInterface$playCallbackRewardVideoAd$1> continuation) {
        super(2, continuation);
        this.this$0 = webViewFragment;
        this.$position = str;
        this.$adsId = str2;
        this.$reward = i10;
        this.$rewardName = str3;
        this.$rewardExtra = str4;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @k
    public final Continuation<Unit> create(@l Object obj, @k Continuation<?> continuation) {
        return new WebViewFragment$JsInterface$playCallbackRewardVideoAd$1(this.this$0, this.$position, this.$adsId, this.$reward, this.$rewardName, this.$rewardExtra, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @l
    public final Object invokeSuspend(@k Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.throwOnFailure(obj);
        this.this$0.a1(this.$position, this.$adsId, this.$reward, this.$rewardName, this.$rewardExtra);
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    @l
    public final Object invoke(@k CoroutineScope coroutineScope, @l Continuation<? super Unit> continuation) {
        return ((WebViewFragment$JsInterface$playCallbackRewardVideoAd$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
