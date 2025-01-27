package com.vivo.push.d;

import android.content.Context;
import com.vivo.push.model.UPSNotificationMessage;
import com.vivo.push.sdk.PushMessageCallback;

/* loaded from: classes4.dex */
final class w implements Runnable {

    /* renamed from: a */
    final /* synthetic */ UPSNotificationMessage f25019a;

    /* renamed from: b */
    final /* synthetic */ u f25020b;

    public w(u uVar, UPSNotificationMessage uPSNotificationMessage) {
        this.f25020b = uVar;
        this.f25019a = uPSNotificationMessage;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Context context;
        u uVar = this.f25020b;
        PushMessageCallback pushMessageCallback = ((z) uVar).f25023b;
        context = ((com.vivo.push.l) uVar).f25064a;
        pushMessageCallback.onNotificationMessageClicked(context, this.f25019a);
    }
}
