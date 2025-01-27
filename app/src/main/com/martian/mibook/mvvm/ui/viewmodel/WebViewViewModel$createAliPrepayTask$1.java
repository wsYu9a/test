package com.martian.mibook.mvvm.ui.viewmodel;

import androidx.collection.ArrayMap;
import com.martian.mibook.lib.account.response.AliRechargeOrder;
import com.martian.mibook.mvvm.tts.NonStickyLiveData;
import com.martian.mibook.mvvm.ui.repository.WebViewRepository;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.CoroutineScope;
import xi.k;
import xi.l;

@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u008a@"}, d2 = {"<anonymous>", "", "it", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.martian.mibook.mvvm.ui.viewmodel.WebViewViewModel$createAliPrepayTask$1", f = "WebViewViewModel.kt", i = {}, l = {42}, m = "invokeSuspend", n = {}, s = {})
@SourceDebugExtension({"SMAP\nWebViewViewModel.kt\nKotlin\n*S Kotlin\n*F\n+ 1 WebViewViewModel.kt\ncom/martian/mibook/mvvm/ui/viewmodel/WebViewViewModel$createAliPrepayTask$1\n+ 2 ArrayMap.kt\nandroidx/collection/ArrayMapKt\n*L\n1#1,77:1\n22#2:78\n*S KotlinDebug\n*F\n+ 1 WebViewViewModel.kt\ncom/martian/mibook/mvvm/ui/viewmodel/WebViewViewModel$createAliPrepayTask$1\n*L\n38#1:78\n*E\n"})
/* loaded from: classes3.dex */
public final class WebViewViewModel$createAliPrepayTask$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $extra;
    final /* synthetic */ int $money;
    final /* synthetic */ String $productId;
    int label;
    final /* synthetic */ WebViewViewModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WebViewViewModel$createAliPrepayTask$1(int i10, String str, String str2, WebViewViewModel webViewViewModel, Continuation<? super WebViewViewModel$createAliPrepayTask$1> continuation) {
        super(2, continuation);
        this.$money = i10;
        this.$productId = str;
        this.$extra = str2;
        this.this$0 = webViewViewModel;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @k
    public final Continuation<Unit> create(@l Object obj, @k Continuation<?> continuation) {
        return new WebViewViewModel$createAliPrepayTask$1(this.$money, this.$productId, this.$extra, this.this$0, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @l
    public final Object invokeSuspend(@k Object obj) {
        NonStickyLiveData nonStickyLiveData;
        NonStickyLiveData nonStickyLiveData2;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i10 = this.label;
        if (i10 == 0) {
            ResultKt.throwOnFailure(obj);
            ArrayMap arrayMap = new ArrayMap();
            arrayMap.put("money", String.valueOf(this.$money));
            arrayMap.put("productId", this.$productId);
            arrayMap.put("extra", this.$extra);
            WebViewRepository f10 = this.this$0.f();
            this.label = 1;
            obj = f10.f(arrayMap, this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i10 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        }
        AliRechargeOrder aliRechargeOrder = (AliRechargeOrder) obj;
        if (aliRechargeOrder != null) {
            aliRechargeOrder.money = this.$money;
            nonStickyLiveData2 = this.this$0._mAliPrepayLiveData;
            nonStickyLiveData2.postValue(aliRechargeOrder);
        } else {
            nonStickyLiveData = this.this$0._mAliPrepayErrorLiveData;
            nonStickyLiveData.postValue(null);
        }
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    @l
    public final Object invoke(@k CoroutineScope coroutineScope, @l Continuation<? super Unit> continuation) {
        return ((WebViewViewModel$createAliPrepayTask$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
