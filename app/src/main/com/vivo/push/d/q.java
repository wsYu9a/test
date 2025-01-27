package com.vivo.push.d;

import android.content.Context;
import com.vivo.push.model.UnvarnishedMessage;
import com.vivo.push.sdk.PushMessageCallback;

/* loaded from: classes4.dex */
final class q implements Runnable {

    /* renamed from: a */
    final /* synthetic */ UnvarnishedMessage f25010a;

    /* renamed from: b */
    final /* synthetic */ p f25011b;

    public q(p pVar, UnvarnishedMessage unvarnishedMessage) {
        this.f25011b = pVar;
        this.f25010a = unvarnishedMessage;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Context context;
        p pVar = this.f25011b;
        PushMessageCallback pushMessageCallback = ((z) pVar).f25023b;
        context = ((com.vivo.push.l) pVar).f25064a;
        pushMessageCallback.onTransmissionMessage(context, this.f25010a);
    }
}
