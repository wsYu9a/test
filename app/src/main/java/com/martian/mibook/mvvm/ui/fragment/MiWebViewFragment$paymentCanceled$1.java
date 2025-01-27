package com.martian.mibook.mvvm.ui.fragment;

import ac.a;
import android.content.Context;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import l9.t0;
import xi.k;
import xi.l;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.martian.mibook.mvvm.ui.fragment.MiWebViewFragment$paymentCanceled$1", f = "MiWebViewFragment.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes3.dex */
public final class MiWebViewFragment$paymentCanceled$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $orderJson;
    int label;
    final /* synthetic */ MiWebViewFragment this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MiWebViewFragment$paymentCanceled$1(MiWebViewFragment miWebViewFragment, String str, Continuation<? super MiWebViewFragment$paymentCanceled$1> continuation) {
        super(2, continuation);
        this.this$0 = miWebViewFragment;
        this.$orderJson = str;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @k
    public final Continuation<Unit> create(@l Object obj, @k Continuation<?> continuation) {
        return new MiWebViewFragment$paymentCanceled$1(this.this$0, this.$orderJson, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @l
    public final Object invokeSuspend(@k Object obj) {
        String str;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.throwOnFailure(obj);
        Context context = this.this$0.getContext();
        str = MiWebViewFragment.D;
        t0.b(context, str);
        a.a0(this.this$0.getActivity(), "", "微信充值-取消");
        MiWebViewFragment.L1(this.this$0).webview.loadUrl("javascript:rechargeResult(0, " + this.$orderJson + ")");
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    @l
    public final Object invoke(@k CoroutineScope coroutineScope, @l Continuation<? super Unit> continuation) {
        return ((MiWebViewFragment$paymentCanceled$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
