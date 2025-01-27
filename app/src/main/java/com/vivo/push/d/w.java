package com.vivo.push.d;

import android.content.Context;
import com.vivo.push.model.UPSNotificationMessage;
import com.vivo.push.sdk.PushMessageCallback;

/* loaded from: classes4.dex */
final class w implements Runnable {

    /* renamed from: a */
    final /* synthetic */ UPSNotificationMessage f30992a;

    /* renamed from: b */
    final /* synthetic */ u f30993b;

    w(u uVar, UPSNotificationMessage uPSNotificationMessage) {
        this.f30993b = uVar;
        this.f30992a = uPSNotificationMessage;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Context context;
        u uVar = this.f30993b;
        PushMessageCallback pushMessageCallback = ((z) uVar).f30996b;
        context = ((com.vivo.push.l) uVar).f31028a;
        pushMessageCallback.onNotificationMessageClicked(context, this.f30992a);
    }
}
