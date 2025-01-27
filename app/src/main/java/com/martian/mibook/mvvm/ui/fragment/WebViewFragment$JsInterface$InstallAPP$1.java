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
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.CoroutineScope;
import xi.k;
import xi.l;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003*\u00020\u0004H\u008a@"}, d2 = {"<anonymous>", "", ExifInterface.GPS_DIRECTION_TRUE, "U", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.martian.mibook.mvvm.ui.fragment.WebViewFragment$JsInterface$InstallAPP$1", f = "WebViewFragment.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes3.dex */
public final class WebViewFragment$JsInterface$InstallAPP$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $url;
    int label;
    final /* synthetic */ WebViewFragment<T, U> this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WebViewFragment$JsInterface$InstallAPP$1(String str, WebViewFragment<T, U> webViewFragment, Continuation<? super WebViewFragment$JsInterface$InstallAPP$1> continuation) {
        super(2, continuation);
        this.$url = str;
        this.this$0 = webViewFragment;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @k
    public final Continuation<Unit> create(@l Object obj, @k Continuation<?> continuation) {
        return new WebViewFragment$JsInterface$InstallAPP$1(this.$url, this.this$0, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @l
    public final Object invokeSuspend(@k Object obj) {
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.throwOnFailure(obj);
        int lastIndexOf$default = StringsKt.lastIndexOf$default((CharSequence) this.$url, "/", 0, false, 6, (Object) null) + 1;
        WebViewFragment<T, U> webViewFragment = this.this$0;
        String substring = this.$url.substring(lastIndexOf$default);
        Intrinsics.checkNotNullExpressionValue(substring, "substring(...)");
        webViewFragment.apkName = substring;
        str = this.this$0.apkName;
        if (str != null) {
            String str6 = null;
            if (!StringsKt.contains$default((CharSequence) str, (CharSequence) ".apk", false, 2, (Object) null)) {
                str3 = this.this$0.apkName;
                int length = str3 != null ? str3.length() : 0;
                if (length > 10) {
                    WebViewFragment<T, U> webViewFragment2 = this.this$0;
                    str5 = webViewFragment2.apkName;
                    if (str5 != null) {
                        str6 = str5.substring(length - 10);
                        Intrinsics.checkNotNullExpressionValue(str6, "substring(...)");
                    }
                    webViewFragment2.apkName = str6;
                }
                WebViewFragment<T, U> webViewFragment3 = this.this$0;
                str4 = webViewFragment3.apkName;
                webViewFragment3.apkName = str4 + ".apk";
            }
        }
        WebViewFragment<T, U> webViewFragment4 = this.this$0;
        String str7 = this.$url;
        str2 = webViewFragment4.apkName;
        webViewFragment4.x0(str7, str2);
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    @l
    public final Object invoke(@k CoroutineScope coroutineScope, @l Continuation<? super Unit> continuation) {
        return ((WebViewFragment$JsInterface$InstallAPP$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
