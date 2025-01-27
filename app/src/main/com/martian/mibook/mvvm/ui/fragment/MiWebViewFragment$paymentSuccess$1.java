package com.martian.mibook.mvvm.ui.fragment;

import ac.a;
import android.content.Context;
import com.martian.mibook.activity.RechargeOrderDetailActivity;
import com.martian.mibook.application.MiConfigSingleton;
import com.martian.mibook.mvvm.ui.viewmodel.AppViewModel;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import l9.t0;
import xi.k;
import xi.l;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.martian.mibook.mvvm.ui.fragment.MiWebViewFragment$paymentSuccess$1", f = "MiWebViewFragment.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes3.dex */
public final class MiWebViewFragment$paymentSuccess$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ int $method;
    final /* synthetic */ String $orderJson;
    final /* synthetic */ Integer $roid;
    int label;
    final /* synthetic */ MiWebViewFragment this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MiWebViewFragment$paymentSuccess$1(MiWebViewFragment miWebViewFragment, int i10, String str, Integer num, Continuation<? super MiWebViewFragment$paymentSuccess$1> continuation) {
        super(2, continuation);
        this.this$0 = miWebViewFragment;
        this.$method = i10;
        this.$orderJson = str;
        this.$roid = num;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @k
    public final Continuation<Unit> create(@l Object obj, @k Continuation<?> continuation) {
        return new MiWebViewFragment$paymentSuccess$1(this.this$0, this.$method, this.$orderJson, this.$roid, continuation);
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
        AppViewModel G = this.this$0.G();
        if (G != null) {
            G.F0(true);
        }
        Context context = this.this$0.getContext();
        str = MiWebViewFragment.C;
        t0.b(context, str);
        MiConfigSingleton.b2().k3(this.$method);
        a.a0(this.this$0.getActivity(), "", this.$method == 0 ? "微信充值-成功" : "支付宝充值-成功");
        this.this$0.l2(this.$orderJson);
        Integer num = this.$roid;
        if (num != null) {
            RechargeOrderDetailActivity.m3(this.this$0.getActivity(), Boxing.boxInt(num.intValue()), 800);
        }
        MiWebViewFragment.L1(this.this$0).webview.reload();
        MiWebViewFragment.n2(this.this$0, false, 1, null);
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    @l
    public final Object invoke(@k CoroutineScope coroutineScope, @l Continuation<? super Unit> continuation) {
        return ((MiWebViewFragment$paymentSuccess$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
