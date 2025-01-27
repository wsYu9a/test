package com.martian.mibook.mvvm.ui.fragment;

import androidx.exifinterface.media.ExifInterface;
import java.net.URL;
import java.net.URLConnection;
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

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001\"\u0004\b\u0000\u0010\u0003\"\u0004\b\u0001\u0010\u0004*\u00020\u0005H\u008a@"}, d2 = {"<anonymous>", "Ljava/net/URLConnection;", "kotlin.jvm.PlatformType", ExifInterface.GPS_DIRECTION_TRUE, "U", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.martian.mibook.mvvm.ui.fragment.WebViewFragment$url2bitmap$1$conn$1", f = "WebViewFragment.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes3.dex */
public final class WebViewFragment$url2bitmap$1$conn$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super URLConnection>, Object> {
    final /* synthetic */ URL $iconUrl;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WebViewFragment$url2bitmap$1$conn$1(URL url, Continuation<? super WebViewFragment$url2bitmap$1$conn$1> continuation) {
        super(2, continuation);
        this.$iconUrl = url;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @k
    public final Continuation<Unit> create(@l Object obj, @k Continuation<?> continuation) {
        return new WebViewFragment$url2bitmap$1$conn$1(this.$iconUrl, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @l
    public final Object invokeSuspend(@k Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.throwOnFailure(obj);
        return this.$iconUrl.openConnection();
    }

    @Override // kotlin.jvm.functions.Function2
    @l
    public final Object invoke(@k CoroutineScope coroutineScope, @l Continuation<? super URLConnection> continuation) {
        return ((WebViewFragment$url2bitmap$1$conn$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
