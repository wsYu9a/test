package com.martian.mibook.mvvm.ui.fragment;

import android.graphics.Bitmap;
import androidx.exifinterface.media.ExifInterface;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function3;
import kotlinx.coroutines.CoroutineScope;
import l9.t0;
import xi.k;
import xi.l;

@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003*\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u008a@"}, d2 = {"<anonymous>", "", ExifInterface.GPS_DIRECTION_TRUE, "U", "Lkotlinx/coroutines/CoroutineScope;", "it", "Landroid/graphics/Bitmap;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.martian.mibook.mvvm.ui.fragment.WebViewFragment$url2bitmap$2", f = "WebViewFragment.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes3.dex */
public final class WebViewFragment$url2bitmap$2 extends SuspendLambda implements Function3<CoroutineScope, Bitmap, Continuation<? super Unit>, Object> {
    /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ WebViewFragment<T, U> this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WebViewFragment$url2bitmap$2(WebViewFragment<T, U> webViewFragment, Continuation<? super WebViewFragment$url2bitmap$2> continuation) {
        super(3, continuation);
        this.this$0 = webViewFragment;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @l
    public final Object invokeSuspend(@k Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.throwOnFailure(obj);
        Bitmap bitmap = (Bitmap) this.L$0;
        if (bitmap != null) {
            this.this$0.v1(bitmap);
        } else {
            t0.b(this.this$0.getContext(), "保存失败");
        }
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function3
    @l
    public final Object invoke(@k CoroutineScope coroutineScope, @l Bitmap bitmap, @l Continuation<? super Unit> continuation) {
        WebViewFragment$url2bitmap$2 webViewFragment$url2bitmap$2 = new WebViewFragment$url2bitmap$2(this.this$0, continuation);
        webViewFragment$url2bitmap$2.L$0 = bitmap;
        return webViewFragment$url2bitmap$2.invokeSuspend(Unit.INSTANCE);
    }
}
