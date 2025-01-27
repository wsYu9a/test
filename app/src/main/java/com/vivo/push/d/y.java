package com.vivo.push.d;

import android.content.Context;
import com.vivo.push.sdk.PushMessageCallback;

/* loaded from: classes4.dex */
final class y implements Runnable {

    /* renamed from: a */
    final /* synthetic */ com.vivo.push.b.r f30994a;

    /* renamed from: b */
    final /* synthetic */ x f30995b;

    y(x xVar, com.vivo.push.b.r rVar) {
        this.f30995b = xVar;
        this.f30994a = rVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Context context;
        x xVar = this.f30995b;
        PushMessageCallback pushMessageCallback = ((z) xVar).f30996b;
        context = ((com.vivo.push.l) xVar).f31028a;
        pushMessageCallback.onPublish(context, this.f30994a.h(), this.f30994a.g());
    }
}
