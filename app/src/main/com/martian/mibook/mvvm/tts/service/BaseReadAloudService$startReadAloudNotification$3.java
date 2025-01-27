package com.martian.mibook.mvvm.tts.service;

import android.app.Notification;
import android.graphics.Bitmap;
import android.widget.RemoteViews;
import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestBuilder;
import com.bumptech.glide.request.target.NotificationTarget;
import com.martian.mibook.R;
import com.martian.mibook.lib.model.data.abs.Book;
import com.martian.mibook.mvvm.tts.ReadAloudBook;
import java.lang.ref.WeakReference;
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
@DebugMetadata(c = "com.martian.mibook.mvvm.tts.service.BaseReadAloudService$startReadAloudNotification$3", f = "BaseReadAloudService.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes3.dex */
public final class BaseReadAloudService$startReadAloudNotification$3 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ BaseReadAloudService this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BaseReadAloudService$startReadAloudNotification$3(BaseReadAloudService baseReadAloudService, Continuation<? super BaseReadAloudService$startReadAloudNotification$3> continuation) {
        super(2, continuation);
        this.this$0 = baseReadAloudService;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @k
    public final Continuation<Unit> create(@l Object obj, @k Continuation<?> continuation) {
        return new BaseReadAloudService$startReadAloudNotification$3(this.this$0, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @l
    public final Object invokeSuspend(@k Object obj) {
        WeakReference weakReference;
        RemoteViews remoteViews;
        Notification notification;
        Notification notification2;
        NotificationTarget G;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.throwOnFailure(obj);
        weakReference = this.this$0.remoteViewWeakReference;
        if (weakReference != null && (remoteViews = (RemoteViews) weakReference.get()) != null) {
            BaseReadAloudService baseReadAloudService = this.this$0;
            notification = baseReadAloudService.notification;
            baseReadAloudService.f0(remoteViews, notification);
            notification2 = baseReadAloudService.notification;
            G = baseReadAloudService.G(remoteViews, notification2);
            if (G != null) {
                RequestBuilder<Bitmap> asBitmap = Glide.with(baseReadAloudService).asBitmap();
                Book a10 = ReadAloudBook.f15003a.a();
                asBitmap.load2(a10 != null ? a10.getCover() : null).error(R.drawable.tts_default_cover).into((RequestBuilder) G);
            }
        }
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    @l
    public final Object invoke(@k CoroutineScope coroutineScope, @l Continuation<? super Unit> continuation) {
        return ((BaseReadAloudService$startReadAloudNotification$3) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
