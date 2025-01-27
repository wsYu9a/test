package com.vivo.push.d;

import android.content.Context;
import com.vivo.push.model.UnvarnishedMessage;
import com.vivo.push.sdk.PushMessageCallback;

/* loaded from: classes4.dex */
final class q implements Runnable {

    /* renamed from: a */
    final /* synthetic */ UnvarnishedMessage f30983a;

    /* renamed from: b */
    final /* synthetic */ p f30984b;

    q(p pVar, UnvarnishedMessage unvarnishedMessage) {
        this.f30984b = pVar;
        this.f30983a = unvarnishedMessage;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Context context;
        p pVar = this.f30984b;
        PushMessageCallback pushMessageCallback = ((z) pVar).f30996b;
        context = ((com.vivo.push.l) pVar).f31028a;
        pushMessageCallback.onTransmissionMessage(context, this.f30983a);
    }
}
